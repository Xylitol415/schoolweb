<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：用户添加页面（系统管理员使用）

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
<%
if(request.getParameter("flag")!=null&&"success".equals(request.getParameter("flag"))){
	response.getWriter().println("<script>alert('添加成功!');</script>");
}
if(request.getParameter("flag")!=null&&"error".equals(request.getParameter("flag"))){
	response.getWriter().println("<script>alert('用户名已存在!');</script>");
}
%>
<script type="text/javascript">
		function checkValue(){
				if(document.form.password.value==""||document.form.password.value==null)
				{
					alert("不能为空！");
					document.form.password.focus();
					return false;
				}
				if(document.form.realname.value==""||document.form.realname.value==null)
				{
					alert("不能为空！");
					document.form.realname.focus();
					return false;
				}
				if(document.form.atrr.value==""||document.form.atrr.value==null)
				{
					alert("不能为空！");
					document.form.atrr.focus();
					return false;
				}
				if(document.form.phone.value==""||document.form.phone.value==null)
				{
					alert("不能为空！");
					document.form.phone.focus();
					return false;
				}
				if(document.form.card.value==""||document.form.card.value==null)
				{
					alert("不能为空！");
					document.form.card.focus();
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="UserServlet?mtype=update" method="post"  name="form"  onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加用户信息</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>用户信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">用户帐号:</td>
					    <td width="35%"><span class="red">
					    ${user.username}
				        <input name='id' type="hidden" value="${user.id}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">登录密码:</td>
					    <td width="35%"><span class="red">
				        <input name='password' type="text" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					  </tr>					 
					  <tr>
					    <td align="right" width="19%">姓名:</td>
					    <td width="35%"><span class="red">
				        <input name='realname' type="text" class="text" style="width:154px" value="${user.realname}"/>
				        *</span>
				        </td>					  
					    <td align="right" width="19%">联系地址:</td>
					    <td width="35%"><span class="red">
				        <input name='atrr' type="text" class="text" style="width:154px" value="${user.atrr}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">联系电话:</td>
					    <td width="35%"><span class="red">
				        <input name='phone' type="text" class="text" style="width:154px" value="${user.phone}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">身份证:</td>
					    <td width="35%"><span class="red">
				        <input name='card' type="text" class="text" style="width:154px" value="${user.card}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">所属学院:</td>
					    <td width="35%"><span class="red">
					    	<select name="typeid">		    		
					    	    <option value="0" <c:if test="${user.typeid==0}"> selected="selected" </c:if> >经济与管理学院</option>
					    		<option value="1" <c:if test="${user.typeid==1}"> selected="selected" </c:if> >文学院</option>
					    		<option value="2" <c:if test="${user.typeid==2}"> selected="selected" </c:if> >计算机与信息学院</option>
					    		<option value="3" <c:if test="${user.typeid==3}"> selected="selected" </c:if> >外国语学院</option>
					    		<option value="4" <c:if test="${user.typeid==4}"> selected="selected" </c:if> >法学院</option>
					    		<option value="5" <c:if test="${user.typeid==5}"> selected="selected" </c:if> >马克思主义学院</option>
					    		<option value="6" <c:if test="${user.typeid==6}"> selected="selected" </c:if> >美术学院</option>
					    		<option value="7" <c:if test="${user.typeid==7}"> selected="selected" </c:if> >人文与社会学院</option>
					    		<option value="8" <c:if test="${user.typeid==8}"> selected="selected" </c:if> >传媒学院</option>
					    		<option value="9" <c:if test="${user.typeid==9}"> selected="selected" </c:if> >数学与计算科学学院</option>
					    		<option value="10" <c:if test="${user.typeid==10}"> selected="selected" </c:if> >物理与电气学院</option>
					    		<option value="11" <c:if test="${user.typeid==11}"> selected="selected" </c:if> >化学化工学院</option>
					    		<option value="12" <c:if test="${user.typeid==12}"> selected="selected" </c:if> >资源环境学院</option>
					    		<option value="13" <c:if test="${user.typeid==13}"> selected="selected" </c:if> >教师教育学院</option>
					    		<option value="14" <c:if test="${user.typeid==14}"> selected="selected" </c:if> >生命科学学院</option>
					    		<option value="15" <c:if test="${user.typeid==15}"> selected="selected" </c:if> >体育学院</option>
					    		<option value="16" <c:if test="${user.typeid==16}"> selected="selected" </c:if> >继续教育学院</option>
					    		<option value="17" <c:if test="${user.typeid==17}"> selected="selected" </c:if> >音乐与黄梅戏学院</option>
					    	</select>
				        *</span>
				        </td>
					    <td align="right" width="19%"></td>
					    <td width="35%"><span class="red"></span>
				        </td>
					  </tr>
					  </table>
			  <br />
				</fieldset>			</td>
			
		</TR>
		</TABLE>
	 </td>
  </tr>
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="submitbut" value="保存"  />　
			
			<input type="reset" name="reset" value="重置"  /></TD>
		</TR>
		</TABLE>
</div>
</form>
</body>
</html>
