package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TStudentru;
import com.bean.TStudentzh;
import com.dao.StudentruDao;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：入党积极分子信息Servlet
 *
 */
public class StudentruServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mtype = request.getParameter("mtype");
			String url = "";
			StudentruDao studentruDao = new StudentruDao();
			/**
			 * 添加入党积极分子信息
			 */
			if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TStudentru studentru  = new TStudentru();
				studentru.setBarthday(request.getParameter("barthday"));
				studentru.setClassname(request.getParameter("classname"));
				studentru.setFenzhi(request.getParameter("fenzhi"));
				studentru.setFenzhidate(request.getParameter("fenzhidate"));
				studentru.setIstrain(request.getParameter("istrain"));
				studentru.setNation(request.getParameter("nation"));
				studentru.setPlace(request.getParameter("place"));
				studentru.setRudate(request.getParameter("rudate"));
				studentru.setSixiang(request.getParameter("sixiang"));
				studentru.setTypeid(request.getParameter("typeid"));
				studentru.setTypename(request.getParameter("typename"));
				studentru.setUsername(request.getParameter("username"));
				studentru.setSex(request.getParameter("sex"));
				studentru.setIdcard(request.getParameter("idcard"));
				studentruDao.addStudentru(studentru);
				url = "/StudentruServlet?mtype=query&flag=success";
			/**
			 * 初始化修改入党积极分子信息界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("studentru", studentruDao.getStudentru(request.getParameter("id")));
					url = "/files/studentru/update.jsp";
				
			/**
			 * 修改入党积极分子信息
			 */
			}else if("update".equals(mtype)){	
				TStudentru studentru = new TStudentru();
				studentru.setId(Integer.parseInt(request.getParameter("id")));
				studentru.setBarthday(request.getParameter("barthday"));
				studentru.setClassname(request.getParameter("classname"));
				studentru.setFenzhi(request.getParameter("fenzhi"));
				studentru.setFenzhidate(request.getParameter("fenzhidate"));
				studentru.setIstrain(request.getParameter("istrain"));
				studentru.setNation(request.getParameter("nation"));
				studentru.setPlace(request.getParameter("place"));
				studentru.setRudate(request.getParameter("rudate"));
				studentru.setSixiang(request.getParameter("sixiang"));
				studentru.setTypeid(request.getParameter("typeid"));
				studentru.setTypename(request.getParameter("typename"));
				studentru.setUsername(request.getParameter("username"));
				studentru.setSex(request.getParameter("sex"));
				studentru.setIdcard(request.getParameter("idcard"));
				studentruDao.updateStudentru(studentru);
				url = "/StudentruServlet?mtype=query";
			/**
			 * 遍历入党积极分子信息
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "StudentruServlet?mtype=query";
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
				PageInfo pageInfo = studentruDao.queryTStudentru(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname0", request.getParameter("searchname0"));
				request.setAttribute("searchname1", request.getParameter("searchname1"));
				url = "/files/studentru/list.jsp";
			/**
			 * 删除入党积极分子信息
			 */
			}else if("delete".equals(mtype)){	
				studentruDao.delStudentru(request.getParameter("id"));
				url = "/StudentruServlet?mtype=query";	
			/**
			 * 初始化入党积极分子转出信息界面
			 */
			}else if("prerollio".equals(mtype)){	
					request.setAttribute("studentru", studentruDao.getStudentru(request.getParameter("id")));
					url = "/files/studentru/rollIO.jsp";
			
			/**
			 * 入党积极分子转出信息更新
			 */
			}else if("rollio".equals(mtype)){	
				TStudentru studentru = new TStudentru();
				studentru.setId(Integer.parseInt(request.getParameter("id")));
				studentru.setNewtid(request.getParameter("newtid"));
				studentru.setNewtname(request.getParameter("newtname"));
				studentru.setRollstatus(Integer.parseInt(request.getParameter("rollstatus")));
				studentruDao.rollStudentru(studentru);
				url = "/StudentruServlet?mtype=query";
			/**
			 * 入党积极分子转出信息更新
			 */
			}else if("rollupdate".equals(mtype)){	
				TStudentru studentru = new TStudentru();
				studentru.setId(Integer.parseInt(request.getParameter("id")));
				studentruDao.rollupdateStudentru(studentru,request.getParameter("flag"));
				url = "/StudentruServlet?mtype=query";
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}