package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TNotice;
import com.dao.NoticeDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：系部信息Servlet
 *
 */
public class NoticeServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String typeid = request.getParameter("typeid");
			String url = "";
			NoticeDao noticeDao = new NoticeDao();
			/**
			 * 添加系部信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TNotice notice  = new TNotice();
				notice.setTypeid(request.getParameter("typeid"));
				notice.setSnum(Integer.parseInt(request.getParameter("snum")));
				notice.setTel(request.getParameter("tel"));
				notice.setUsername(request.getParameter("username"));
				noticeDao.addNotice(notice);
				url = "/NoticeServlet?mtype=query&flag=success";
			/**
			 * 初始化修改系部信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("notice", noticeDao.getNotice(request.getParameter("id")));
					url = "/files/notice/update.jsp";
				
			/**
			 * 修改系部信息
			 */
			}else if("update".equals(mtype)){	
				TNotice notice = new TNotice();
				notice.setId(Integer.parseInt(request.getParameter("id")));
				notice.setTypeid(request.getParameter("typeid"));
				notice.setSnum(Integer.parseInt(request.getParameter("snum")));	
				notice.setTel(request.getParameter("tel"));
				notice.setUsername(request.getParameter("username"));
				noticeDao.updateNotice(notice);
				url = "/NoticeServlet?mtype=query";
			/**
			 * 遍历系部信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "NoticeServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname")&&""!=request.getParameter("searchname").trim()){
					cond.append(" and a.typeid like '%"+request.getParameter("searchname").trim()+"%' ");
				}
				PageInfo pageInfo = noticeDao.queryTNotice(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname", request.getParameter("searchname"));
				url = "/files/notice/list.jsp";
				
			/**
			 * 计算当前系管理员所在学院近三年党员数据
			 */
			}else if("countQuery".equals(mtype)){
				System.out.println(request.getParameter("typeid"));
				List<TNotice> list = noticeDao.getTNotices(request.getParameter("typeid"));
//				System.out.println("list长度：：："+list.size());
//				for (TNotice tNotice : list) {
//					System.out.println(tNotice.toString());
//				}
				request.setAttribute("list", list);
				url = "/files/notice/list.jsp";
			/**
			 * 删除系部信息
			 */
			}else if("delete".equals(mtype)){	
				noticeDao.delNotice(request.getParameter("id"));
				url = "/NoticeServlet?mtype=query";	
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}