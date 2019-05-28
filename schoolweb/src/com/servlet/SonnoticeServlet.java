package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TSonnotice;
import com.dao.SonnoticeDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：支部信息Servlet
 *
 */
public class SonnoticeServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			SonnoticeDao noticeDao = new SonnoticeDao();
			/**
			 * 添加支部信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TSonnotice notice  = new TSonnotice();
				notice.setTypeid(request.getParameter("typeid"));
				notice.setDangsun(Integer.parseInt(request.getParameter("dangsun")));
				notice.setEmail(request.getParameter("email"));
				notice.setPhone(request.getParameter("phone"));
				notice.setRusun(Integer.parseInt(request.getParameter("rusun")));
				notice.setTel(request.getParameter("tel"));
				notice.setTypename(request.getParameter("typename"));
				notice.setUsername(request.getParameter("username"));
				noticeDao.addSonnotice(notice);
				url = "/SonnoticeServlet?mtype=query&flag=success";
			/**
			 * 初始化修改支部信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("sonnotice", noticeDao.getSonnotice(request.getParameter("id")));
					url = "/files/sonnotice/update.jsp";
				
			/**
			 * 修改支部信息
			 */
			}else if("update".equals(mtype)){	
				TSonnotice notice = new TSonnotice();
				notice.setId(Integer.parseInt(request.getParameter("id")));
				notice.setTypeid(request.getParameter("typeid"));
				notice.setDangsun(Integer.parseInt(request.getParameter("dangsun")));
				notice.setEmail(request.getParameter("email"));
				notice.setPhone(request.getParameter("phone"));
				notice.setRusun(Integer.parseInt(request.getParameter("rusun")));
				notice.setTel(request.getParameter("tel"));
				notice.setTypename(request.getParameter("typename"));
				notice.setUsername(request.getParameter("username"));
				noticeDao.updateSonnotice(notice);
				url = "/SonnoticeServlet?mtype=query";
			/**
			 * 遍历支部信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "SonnoticeServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname")&&""!=request.getParameter("searchname").trim()){
					cond.append(" and a.typename like '%"+request.getParameter("searchname").trim()+"%' ");
				}
				if(null!=request.getSession().getAttribute("usertype")&&!"0".equals(((String)request.getSession().getAttribute("usertype")))){
					cond.append(" and a.typeid like '%"+(String)request.getSession().getAttribute("typeid")+"%' ");
				}
				PageInfo pageInfo = noticeDao.queryTSonnotice(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname", request.getParameter("searchname"));
				url = "/files/sonnotice/list.jsp";
			/**
			 * 删除支部信息
			 */
			}else if("delete".equals(mtype)){	
				noticeDao.delSonnotice(request.getParameter("id"));
					url = "/SonnoticeServlet?mtype=query";	
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}