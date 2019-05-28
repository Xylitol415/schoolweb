package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TZuzhi;
import com.dao.ZuzhiDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：组织信息Servlet
 *
 */
public class ZuzhiServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			ZuzhiDao zuzhiDao = new ZuzhiDao();
			/**
			 * 添加组织信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TZuzhi zuzhi  = new TZuzhi();
				zuzhi.setApplyer(request.getParameter("applyer"));
				zuzhi.setCsum(request.getParameter("csum"));
				zuzhi.setHuodate(request.getParameter("huodate"));
				zuzhi.setHuouser(request.getParameter("huouser"));
				zuzhi.setPlace(request.getParameter("place"));
				zuzhi.setStatus("待批准");
				zuzhi.setTel(request.getParameter("tel"));
				zuzhi.setTypeid(request.getParameter("typeid"));
				zuzhi.setTypename(request.getParameter("typename"));
				zuzhi.setXiangqing(request.getParameter("xiangqing"));
				zuzhi.setHuoname(request.getParameter("huoname"));
				zuzhiDao.addZuzhi(zuzhi);
				url = "/ZuzhiServlet?mtype=query&flag=success";
			/**
			 * 初始化修改组织信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("zuzhi", zuzhiDao.getZuzhi(request.getParameter("id")));
					url = "/files/zuzhi/update.jsp";
				
			/**
			 * 修改组织信息
			 */
			}else if("update".equals(mtype)){	
				TZuzhi zuzhi = new TZuzhi();
				zuzhi.setId(Integer.parseInt(request.getParameter("id")));
				zuzhi.setApplyer(request.getParameter("applyer"));
				zuzhi.setCsum(request.getParameter("csum"));
				zuzhi.setHuodate(request.getParameter("huodate"));
				zuzhi.setHuouser(request.getParameter("huouser"));
				zuzhi.setPlace(request.getParameter("place"));
				zuzhi.setStatus(request.getParameter("status"));
				zuzhi.setTel(request.getParameter("tel"));
				zuzhi.setTypeid(request.getParameter("typeid"));
				zuzhi.setTypename(request.getParameter("typename"));
				zuzhi.setXiangqing(request.getParameter("xiangqing"));
				zuzhi.setHuoname(request.getParameter("huoname"));
				zuzhiDao.updateZuzhi(zuzhi);
				url = "/ZuzhiServlet?mtype=query";
			/**
			 * 遍历组织信息
			 */
			}else if("apply".equals(mtype)){	
				TZuzhi zuzhi = new TZuzhi();
				zuzhi.setId(Integer.parseInt(request.getParameter("id")));
				if("0".equals(request.getParameter("flag"))){
					zuzhi.setStatus("已同意");
				}else{
					zuzhi.setStatus("不同意");
				}
				zuzhi.setApplyer((String)request.getSession().getAttribute("username"));
				zuzhiDao.applyZuzhi(zuzhi);
				url = "/ZuzhiServlet?mtype=query";
			/**
			 * 遍历组织信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "ZuzhiServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname0")&&""!=request.getParameter("searchname0").trim()){
					cond.append(" and a.typename like '%"+request.getParameter("searchname0").trim()+"%' ");
				}
				if(null!=request.getSession().getAttribute("usertype")&&!"0".equals(((String)request.getSession().getAttribute("usertype")))){
					cond.append(" and a.typeid like '%"+(String)request.getSession().getAttribute("typeid")+"%' ");
				}
				PageInfo pageInfo = zuzhiDao.queryTZuzhi(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname0", request.getParameter("searchname0"));
				url = "/files/zuzhi/list.jsp";
			/**
			 * 删除组织信息
			 */
			}else if("delete".equals(mtype)){	
				zuzhiDao.delZuzhi(request.getParameter("id"));
					url = "/ZuzhiServlet?mtype=query";	
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}