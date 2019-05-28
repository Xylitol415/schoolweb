package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.TStudentzh;
import com.dao.StudentzhDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：正式党员信息Servlet
 *
 */
public class StudentzhServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			StudentzhDao studentzhDao = new StudentzhDao();
			/**
			 * 添加正式党员信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TStudentzh studentzh  = new TStudentzh();
				studentzh.setBarthday(request.getParameter("barthday"));
				studentzh.setClassname(request.getParameter("classname"));
				studentzh.setFenzhi(request.getParameter("fenzhi"));
				studentzh.setNation(request.getParameter("nation"));
				studentzh.setPlace(request.getParameter("place"));
				studentzh.setSixiang(request.getParameter("sixiang"));
				studentzh.setTypeid(request.getParameter("typeid"));
				studentzh.setTypename(request.getParameter("typename"));
				studentzh.setUsername(request.getParameter("username"));
				studentzh.setSex(request.getParameter("sex"));
				studentzh.setApplyer(request.getParameter("applyer"));
				studentzh.setFadate(request.getParameter("fadate"));
				studentzh.setJiedate(request.getParameter("jiedate"));
				studentzh.setZhuandate(request.getParameter("zhuandate"));
				studentzh.setJieuser(request.getParameter("jieuser"));
				studentzh.setJueyi(request.getParameter("jueyi"));
				studentzh.setStatus(request.getParameter("status"));
				studentzh.setRudate(request.getParameter("rudate"));
				studentzh.setIdcard(request.getParameter("idcard"));
				studentzhDao.addStudentzh(studentzh);
				url = "/StudentzhServlet?mtype=query&flag=success";
			/**
			 * 初始化修改正式党员信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("studentzh", studentzhDao.getStudentzh(request.getParameter("id")));
					url = "/files/studentzh/update.jsp";
				
			/**
			 * 修改正式党员信息
			 */
			}else if("update".equals(mtype)){	
				TStudentzh studentzh = new TStudentzh();
				studentzh.setId(Integer.parseInt(request.getParameter("id")));
				studentzh.setBarthday(request.getParameter("barthday"));
				studentzh.setClassname(request.getParameter("classname"));
				studentzh.setFenzhi(request.getParameter("fenzhi"));
				studentzh.setNation(request.getParameter("nation"));
				studentzh.setPlace(request.getParameter("place"));
				studentzh.setSixiang(request.getParameter("sixiang"));
				studentzh.setTypeid(request.getParameter("typeid"));
				studentzh.setTypename(request.getParameter("typename"));
				studentzh.setUsername(request.getParameter("username"));
				studentzh.setSex(request.getParameter("sex"));
				studentzh.setApplyer(request.getParameter("applyer"));
				studentzh.setFadate(request.getParameter("fadate"));
				studentzh.setJiedate(request.getParameter("jiedate"));
				studentzh.setZhuandate(request.getParameter("zhuandate"));
				studentzh.setJieuser(request.getParameter("jieuser"));
				studentzh.setJueyi(request.getParameter("jueyi"));
				studentzh.setStatus(request.getParameter("status"));
				studentzh.setRudate(request.getParameter("rudate"));
				studentzh.setIdcard(request.getParameter("idcard"));
				studentzhDao.updateStudentzh(studentzh);
				url = "/StudentzhServlet?mtype=query";
			/**
			 * 遍历正式党员信息
			 */
			}else if("apply".equals(mtype)){	
				TStudentzh studentzh = new TStudentzh();
				studentzh.setId(Integer.parseInt(request.getParameter("id")));
				if("0".equals(request.getParameter("flag"))){
					studentzh.setStatus("已同意");
				}else{
					studentzh.setStatus("不同意");
				}
				studentzh.setApplyer((String)request.getSession().getAttribute("username"));
				studentzhDao.applyStudentzh(studentzh);
				url = "/StudentzhServlet?mtype=query";
			/**
			 * 遍历正式党员信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "StudentzhServlet?mtype=query";
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
				PageInfo pageInfo = studentzhDao.queryTStudentzh(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname0", request.getParameter("searchname0"));
				request.setAttribute("searchname1", request.getParameter("searchname1"));
				url = "/files/studentzh/list.jsp";
			/**
			 * 删除正式党员信息
			 */
			}else if("delete".equals(mtype)){	
				studentzhDao.delStudentzh(request.getParameter("id"));
					url = "/StudentzhServlet?mtype=query";	
					
			/**
			 * 初始化预备党员转出信息界面
			 */
			}else if("prerollio".equals(mtype)){	
					request.setAttribute("studentzh", studentzhDao.getStudentzh(request.getParameter("id")));
					url = "/files/studentzh/rollIO.jsp";
			
			/**
			 * 预备党员转出信息更新
			 */
			}else if("rollio".equals(mtype)){	
				TStudentzh studentzh = new TStudentzh();
				studentzh.setId(Integer.parseInt(request.getParameter("id")));
				studentzh.setNewtid(request.getParameter("newtid"));
				studentzh.setNewtname(request.getParameter("newtname"));
				studentzh.setRollstatus(Integer.parseInt(request.getParameter("rollstatus")));
				studentzhDao.rollstudentzh(studentzh);
				url = "/StudentzhServlet?mtype=query";
			/**
			 * 预备党员转出信息更新
			 */
			}else if("rollupdate".equals(mtype)){	
				TStudentzh studentzh = new TStudentzh();
				studentzh.setId(Integer.parseInt(request.getParameter("id")));
				studentzhDao.rollupdatestudentzh(studentzh,request.getParameter("flag"));
			url = "/StudentzhServlet?mtype=query";
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}