package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TNews;
import com.dao.NewsDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：公告信息Servlet
 *
 */
public class NewsServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			NewsDao newsDao = new NewsDao();
			/**
			 * 添加公告信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				TNews news  = new TNews();
				news.setUsername((String)request.getSession().getAttribute("username"));
				news.setInputdate(format.format(date));
				news.setRemark(request.getParameter("remark"));
				news.setTitle(request.getParameter("title"));
				news.setXiangqing(request.getParameter("xiangqing"));
				newsDao.addNews(news);
				url = "/NewsServlet?mtype=query&flag=success";
			/**
			 * 初始化修改公告信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("news", newsDao.getNews(request.getParameter("id")));
					url = "/files/news/update.jsp";
				
			/**
			 * 修改公告信息
			 */
			}else if("update".equals(mtype)){
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				TNews news = new TNews();
				news.setId(Integer.parseInt(request.getParameter("id")));
				news.setUsername((String)request.getSession().getAttribute("username"));
				news.setInputdate(format.format(date));
				news.setRemark(request.getParameter("remark"));
				news.setTitle(request.getParameter("title"));
				news.setXiangqing(request.getParameter("xiangqing"));
				newsDao.updateNews(news);
				url = "/NewsServlet?mtype=query";
			/**
			 * 遍历公告信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "NewsServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname")&&""!=request.getParameter("searchname").trim()){
					cond.append(" and a.title like '%"+request.getParameter("searchname").trim()+"%' ");
				}
				PageInfo pageInfo = newsDao.queryTNews(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname", request.getParameter("searchname"));
				url = "/files/news/list.jsp";
			/**
			 * 删除公告信息
			 */
			}else if("delete".equals(mtype)){	
				newsDao.delNews(request.getParameter("id"));
					url = "/NewsServlet?mtype=query";	
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}