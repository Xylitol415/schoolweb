package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TNews;
import com.bean.TUser;
import com.dao.NewsDao;
import com.dao.UserDao;
import com.util.MD5;
import com.util.PageInfo;
import com.util.SimpleBaseServlet;
/**
 * 
 * 
 * 功能：用户操作
 *
 */
public class UserServlet extends SimpleBaseServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				String mtype = request.getParameter("mtype");
				String url = "";
				UserDao userdao = new UserDao();
				NewsDao newsdao =  new NewsDao();
				TNews tnews = new TNews();
			/**
			 * 用户登录验证
			 */
				if("login".equals(mtype)){
				
				String username = request.getParameter("username");//账号
				String password = request.getParameter("password");//密码
				String usertype = request.getParameter("usertype");//角色
				TUser user = null;
				//验证用户登录信息
				if(username!=null&&password!=null&&usertype!=null){
					//MD5加密
					MD5 md5 = MD5.getInstance();
					password = md5.strToMD5(password);
					user = userdao.checkUser(username, password, usertype);
					tnews = newsdao.getNews("1");
				}
				if(user.getUsername()!=null&&!"".equals(user.getUsername())){//登录成功 将用户信息保存到session中
					request.getSession().setAttribute("userid", user.getId().toString());
					request.getSession().setAttribute("username", user.getUsername());
					request.getSession().setAttribute("realname", user.getRealname());
					request.getSession().setAttribute("usertype", user.getUsertype().toString());
					request.getSession().setAttribute("typeid", user.getTypeid().toString());
					request.getSession().setAttribute("tnews", tnews);
					url = "/index.jsp";
				}else{//登录失败 返回首页
					url = "/login.jsp?info=error";//登录页面显示错误提示
				}
			/**
			 * 修改密码
			 */	
			}else if("updatepassword".equals(mtype)){
				String password = request.getParameter("password1");//密码
				//MD5加密
				MD5 md5 = MD5.getInstance();
				password = md5.strToMD5(password);
				userdao.updatepassword(password, (String)request.getSession().getAttribute("userid"));
				url = "/files/user/passwordupdate.jsp";
			/**
			 * 添加用户
			 */
			}else if("add".equals(mtype)){	
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				TUser user = new TUser();
				//MD5加密
				MD5 md5 = MD5.getInstance();
				String password =  request.getParameter("password");
				password = md5.strToMD5(password);
				user.setUsername(request.getParameter("username"));
				user.setPassword(password);
				user.setRealname(request.getParameter("realname"));
				user.setUsertype(Integer.parseInt(request.getParameter("usertype")));
				user.setUsernum(format.format(date));
				user.setAtrr(request.getParameter("atrr"));
				user.setPhone(request.getParameter("phone"));
				user.setCard(request.getParameter("card"));
				user.setTypeid(request.getParameter("typeid"));
				if(userdao.findName(request.getParameter("username"))!=1){
					userdao.addUser(user);
					url = "/UserServlet?mtype=query&flag=success";
				}else{
					url = "/UserServlet?mtype=query&flag=error";
				}
			/**
			 * 初始化修改用户界面
			 */
			}else if("preupdate".equals(mtype)){	
					request.setAttribute("user", userdao.getUser(request.getParameter("id")));
					url = "/files/user/userupdate.jsp";
				
			/**
			 * 修改用户
			 */
			}else if("update".equals(mtype)){	
				TUser user = new TUser();
				user.setId(Integer.parseInt(request.getParameter("id")));
				String password =  request.getParameter("password");
				//MD5加密
				MD5 md5 = MD5.getInstance();
				password = md5.strToMD5(password);
				user.setPassword(password);
				user.setRealname(request.getParameter("realname"));
				user.setAtrr(request.getParameter("atrr"));
				user.setPhone(request.getParameter("phone"));
				user.setCard(request.getParameter("card"));
				user.setTypeid(request.getParameter("typeid"));
				userdao.updateUser(user);
				url = "/UserServlet?mtype=query";
			/**
			 * 遍历用户
			 */
			}else if("query".equals(mtype)){
				if (request.getSession().getAttribute("querypageunit") == null) {
					request.getSession().setAttribute("querypageunit",
							this.pageunit);
				}
				int curpage = this.getCurrentpage(request);
				int pageunit = this.getPageunit(request, "querypageunit");
				
				String urlpage = "UserServlet?mtype=query";
				StringBuffer cond = new StringBuffer();
				if(null!=request.getParameter("searchname")&&""!=request.getParameter("searchname").trim()){
					cond.append(" and a.username like '%"+request.getParameter("searchname").trim()+"%' ");
				}
				cond.append(" and a.usertype =1 ");
				PageInfo pageInfo = userdao.queryTUser(curpage,
						pageunit, request, urlpage, cond.toString());
				request.setAttribute("pageinfo", pageInfo);
				request.setAttribute("searchname", request.getParameter("searchname"));
				url = "/files/user/userlist.jsp";
			/**
			 * 删除用户
			 */
			}else if("delete".equals(mtype)){	
					userdao.delUser(request.getParameter("id"));
					url = "/UserServlet?mtype=query";	
			}
			//重定向到目标地址
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher .forward(request, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}