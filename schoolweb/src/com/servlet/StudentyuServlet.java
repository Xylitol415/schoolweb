package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.TStudentyu;
import com.dao.StudentyuDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：预备党员信息Servlet
 *
 */
public class StudentyuServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			StudentyuDao studentyuDao = new StudentyuDao();
			/**
			 * 添加预备党员信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TStudentyu studentyu  = new TStudentyu();
				studentyu.setBarthday(request.getParameter("barthday"));
				studentyu.setClassname(request.getParameter("classname"));
				studentyu.setFenzhi(request.getParameter("fenzhi"));
				studentyu.setNation(request.getParameter("nation"));
				studentyu.setPlace(request.getParameter("place"));
				studentyu.setSixiang(request.getParameter("sixiang"));
				studentyu.setTypeid(request.getParameter("typeid"));
				studentyu.setTypename(request.getParameter("typename"));
				studentyu.setUsername(request.getParameter("username"));
				studentyu.setSex(request.getParameter("sex"));
				studentyu.setApplyer(request.getParameter("applyer"));
				studentyu.setFadate(request.getParameter("fadate"));
				studentyu.setJiedate(request.getParameter("jiedate"));
				studentyu.setJieuser(request.getParameter("jieuser"));
				studentyu.setJueyi(request.getParameter("jueyi"));
				studentyu.setStatus(request.getParameter("status"));
				studentyu.setRudate(request.getParameter("rudate"));
				studentyu.setIdcard(request.getParameter("idcard"));
				studentyuDao.addStudentyu(studentyu);
				url = "/StudentyuServlet?mtype=query&flag=success";
			/**
			 * 初始化修改预备党员信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("studentyu", studentyuDao.getStudentyu(request.getParameter("id")));
					url = "/files/studentyu/update.jsp";
				
			/**
			 * 修改预备党员信息
			 */
			}else if("update".equals(mtype)){	
				TStudentyu studentyu = new TStudentyu();
				studentyu.setId(Integer.parseInt(request.getParameter("id")));
				studentyu.setBarthday(request.getParameter("barthday"));
				studentyu.setClassname(request.getParameter("classname"));
				studentyu.setFenzhi(request.getParameter("fenzhi"));
				studentyu.setNation(request.getParameter("nation"));
				studentyu.setPlace(request.getParameter("place"));
				studentyu.setSixiang(request.getParameter("sixiang"));
				studentyu.setTypeid(request.getParameter("typeid"));
				studentyu.setTypename(request.getParameter("typename"));
				studentyu.setUsername(request.getParameter("username"));
				studentyu.setSex(request.getParameter("sex"));
				studentyu.setApplyer(request.getParameter("applyer"));
				studentyu.setFadate(request.getParameter("fadate"));
				studentyu.setJiedate(request.getParameter("jiedate"));
				studentyu.setJieuser(request.getParameter("jieuser"));
				studentyu.setJueyi(request.getParameter("jueyi"));
				studentyu.setStatus(request.getParameter("status"));
				studentyu.setRudate(request.getParameter("rudate"));
				studentyu.setIdcard(request.getParameter("idcard"));
				studentyuDao.updateStudentyu(studentyu);
				url = "/StudentyuServlet?mtype=query";
			/**
			 * 遍历预备党员信息
			 */
			}else if("apply".equals(mtype)){	
				TStudentyu studentyu = new TStudentyu();
				studentyu.setId(Integer.parseInt(request.getParameter("id")));
				if("0".equals(request.getParameter("flag"))){
					studentyu.setStatus("已同意");
				}else{
					studentyu.setStatus("不同意");
				}
				studentyu.setApplyer((String)request.getSession().getAttribute("username"));
				studentyuDao.applyStudentyu(studentyu);
				url = "/StudentyuServlet?mtype=query";
			/**
			 * 遍历预备党员信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "StudentyuServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname0")&&""!=request.getParameter("searchname0").trim()){
					cond.append(" and a.username like '%"+request.getParameter("searchname0").trim()+"%' ");
				}
				if(null!=request.getParameter("searchname1")&&""!=request.getParameter("searchname1").trim()){
					cond.append(" and a.classname like '%"+request.getParameter("searchname1").trim()+"%' ");
				}
				if(null!=request.getSession().getAttribute("usertype")&&!"0".equals(((String)request.getSession().getAttribute("usertype")))){
					cond.append(" and a.typeid like '%"+(String)request.getSession().getAttribute("typeid")+"%' ");
				}
				PageInfo pageInfo = studentyuDao.queryTStudentyu(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname0", request.getParameter("searchname0"));
				request.setAttribute("searchname1", request.getParameter("searchname1"));
				url = "/files/studentyu/list.jsp";
			/**
			 * 删除预备党员信息
			 */
			}else if("delete".equals(mtype)){	
				studentyuDao.delStudentyu(request.getParameter("id"));
					url = "/StudentyuServlet?mtype=query";
					
			
			/**
			 * 初始化预备党员转出信息界面
			 */
			}else if("prerollio".equals(mtype)){	
					request.setAttribute("studentyu", studentyuDao.getStudentyu(request.getParameter("id")));
					url = "/files/studentyu/rollIO.jsp";
			
			/**
			 * 预备党员转出信息更新
			 */
			}else if("rollio".equals(mtype)){	
				TStudentyu studentyu = new TStudentyu();
				studentyu.setId(Integer.parseInt(request.getParameter("id")));
				studentyu.setNewtid(request.getParameter("newtid"));
				studentyu.setNewtname(request.getParameter("newtname"));
				studentyu.setRollstatus(Integer.parseInt(request.getParameter("rollstatus")));
				studentyuDao.rollStudentyu(studentyu);
				url = "/StudentyuServlet?mtype=query";
			/**
			 * 预备党员转出信息更新
			 */
			}else if("rollupdate".equals(mtype)){	
				TStudentyu studentyu = new TStudentyu();
				studentyu.setId(Integer.parseInt(request.getParameter("id")));
				studentyuDao.rollupdateStudentyu(studentyu,request.getParameter("flag"));
				url = "/StudentyuServlet?mtype=query";
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}