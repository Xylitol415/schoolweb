<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：用户退出数据销毁

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%
	try{
				session.removeAttribute("username");
				session.removeAttribute("realname");
				session.removeAttribute("usertype");
				session.removeAttribute("userid");
				response.sendRedirect("login.jsp");
	} catch (Exception e) {
		out.println(e.getMessage());
	} 
%>
