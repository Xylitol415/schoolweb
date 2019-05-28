<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：修改页面

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
%>
<script type="text/javascript">
		function checkValue(){
				if(document.form.title.value==""||document.form.title.value==null)
				{
					alert("不能为空！");
					document.form.title.focus();
					return false;
				}
				if(document.form.inputdate.value==""||document.form.inputdate.value==null)
				{
					alert("不能为空！");
					document.form.inputdate.focus();
					return false;
				}
				if(document.form.remark.value==""||document.form.remark.value==null)
				{
					alert("不能为空！");
					document.form.remark.focus();
					return false;
				}
				if(document.form.xiangqing.value==""||document.form.xiangqing.value==null)
				{
					alert("不能为空！");
					document.form.xiangqing.focus();
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="NewsServlet?mtype=update" method="post"  name="form"  onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改公告信息</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>公告信息</legend>
				     <input name='id' type="hidden" class="text" style="width:154px" value="${news.id }"/>
				     <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">公告标题:</td>
					    <td width="35%"><span class="red">
					    <input name='title' type="text" class="text" style="width:154px" value="${news.title }"/>
				        *</span>
				        </td>
					    <td align="right" width="19%"></td>
					    <td width="35%"><span class="red"></span>
				        </td>
					  </tr>					 
					  <tr>
					    <td align="right" width="19%">公告内容:</td>
					    <td width="35%"><span class="red">
					   	<textarea name='remark' rows="4" cols="40">${news.remark }</textarea>
				        *</span>
				        </td>
					    <td align="right" width="19%">公告详情:</td>
					    <td width="35%"><span class="red">
					    <textarea name='xiangqing' rows="4" cols="40">${news.xiangqing }</textarea>
				        *</span>
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
