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
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
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
				
				if(document.form.newtname.value==""||document.form.newtname.value==null)
				{
					alert("不能为空！");
					document.form.newtname.focus();
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="StudentzhServlet?mtype=rollio" method="post"  name="form"  onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改正式党员信息</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>正式党员信息</legend>
				     <input name='id' type="hidden" class="text" style="width:154px" value="${studentzh.id }"/>
				     <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">学院名称:</td>
					    <td width="35%"><span class="red">
					    <select name="newtid">
					    		<option value="0"  >经济与管理学院</option>
					    		<option value="1"  >文学院</option>
					    		<option value="2"  >计算机与信息学院</option>
					    		<option value="3"  >外国语学院</option>
					    		<option value="4" >法学院</option>
					    		<option value="5"  >马克思主义学院</option>
					    		<option value="6" >美术学院</option>
					    		<option value="7"  >人文与社会学院</option>
					    		<option value="8"  >传媒学院</option>
					    		<option value="9" >数学与计算科学学院</option>
					    		<option value="10">物理与电气学院</option>
					    		<option value="11" >化学化工学院</option>
					    		<option value="12" >资源环境学院</option>
					    		<option value="13" >教师教育学院</option>
					    		<option value="14" >生命科学学院</option>
					    		<option value="15" >体育学院</option>
					    		<option value="16"  >继续教育学院</option>
					    		<option value="17" >音乐与黄梅戏学院</option>
					    	</select>
					    	
				        *</span>
				        </td>
					    <td align="right" width="19%">所属支部:</td>
					    <td width="35%"><span class="red">
					    <input name='newtname'  type="text" class="text" style="width:154px" value="${studentzh.typename}"/>
					    <input name='rollstatus' type="hidden" class="text" style="width:154px" value="1"/>
				        
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
