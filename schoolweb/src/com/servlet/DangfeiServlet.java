package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TDangfei;
import com.dao.DangfeiDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：党费信息Servlet
 *
 */
public class DangfeiServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			DangfeiDao dangfeiDao = new DangfeiDao();
			/**
			 * 添加党费信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TDangfei dangfei  = new TDangfei();
				dangfei.setTypeid(request.getParameter("typeid"));
				dangfei.setClassname(request.getParameter("classname"));
				dangfei.setDangfei(Double.parseDouble(request.getParameter("dangfei")));
				dangfei.setDangtype(Integer.parseInt(request.getParameter("dangtype")));
				dangfei.setShouyear(request.getParameter("shouyear"));
				dangfei.setTypename(request.getParameter("typename"));
				dangfei.setUsername(request.getParameter("username"));
				dangfeiDao.addDangfei(dangfei);
				url = "/DangfeiServlet?mtype=query&flag=success";
			/**
			 * 初始化修改党费信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("dangfei", dangfeiDao.getDangfei(request.getParameter("id")));
					url = "/files/dangfei/update.jsp";
				
			/**
			 * 修改党费信息
			 */
			}else if("update".equals(mtype)){	
				TDangfei dangfei = new TDangfei();
				dangfei.setId(Integer.parseInt(request.getParameter("id")));
				dangfei.setTypeid(request.getParameter("typeid"));
				dangfei.setClassname(request.getParameter("classname"));
				dangfei.setDangfei(Double.parseDouble(request.getParameter("dangfei")));
				dangfei.setDangtype(Integer.parseInt(request.getParameter("dangtype")));
				dangfei.setShouyear(request.getParameter("shouyear"));
				dangfei.setTypename(request.getParameter("typename"));
				dangfei.setUsername(request.getParameter("username"));
				dangfeiDao.updateDangfei(dangfei);
				url = "/DangfeiServlet?mtype=query";
			/**
			 * 遍历党费信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "DangfeiServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname")&&""!=request.getParameter("searchname").trim()){
					cond.append(" and a.typename like '%"+request.getParameter("searchname").trim()+"%' ");
				}
				if(null!=request.getSession().getAttribute("usertype")&&!"0".equals(((String)request.getSession().getAttribute("usertype")))){
					cond.append(" and a.typeid like '%"+(String)request.getSession().getAttribute("typeid")+"%' ");
				}
				PageInfo pageInfo = dangfeiDao.queryTDangfei(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname", request.getParameter("searchname"));
				url = "/files/dangfei/list.jsp";
			/**
			 * 删除党费信息
			 */
			}else if("delete".equals(mtype)){	
				dangfeiDao.delDangfei(request.getParameter("id"));
					url = "/DangfeiServlet?mtype=query";	
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}