<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：添加页面

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
				if(document.form.typename.value==""||document.form.typename.value==null)
				{
					alert("不能为空！");
					document.form.typename.focus();
					return false;
				}
				if(document.form.username.value==""||document.form.username.value==null)
				{
					alert("不能为空！");
					document.form.username.focus();
					return false;
				}
				if(document.form.classname.value==""||document.form.classname.value==null)
				{
					alert("不能为空！");
					document.form.classname.focus();
					return false;
				}
				if(document.form.dangtype.value==""||document.form.dangtype.value==null)
				{
					alert("不能为空！");
					document.form.dangtype.focus();
					return false;
				}
				if(document.form.shouyear.value==""||document.form.shouyear.value==null)
				{
					alert("不能为空！");
					document.form.shouyear.focus();
					return false;
				}
				if(document.form.dangfei.value==""||document.form.dangfei.value==null)
				{
					alert("不能为空！");
					document.form.dangfei.focus();
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="DangfeiServlet?mtype=add" method="post"  name="form"  onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加信息</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>党费信息</legend>
					<table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">学院名称:</td>
					    <td width="35%"><span class="red">
					    <select name="typeid1"  disabled="disabled">
					    		<option value="0" <c:if test="${typeid==0}"> selected="selected" </c:if> >经济与管理学院</option>
					    		<option value="1" <c:if test="${typeid==1}"> selected="selected" </c:if> >文学院</option>
					    		<option value="2" <c:if test="${typeid==2}"> selected="selected" </c:if> >计算机与信息学院</option>
					    		<option value="3" <c:if test="${typeid==3}"> selected="selected" </c:if> >外国语学院</option>
					    		<option value="4" <c:if test="${typeid==4}"> selected="selected" </c:if> >法学院</option>
					    		<option value="5" <c:if test="${typeid==5}"> selected="selected" </c:if> >马克思主义学院</option>
					    		<option value="6" <c:if test="${typeid==6}"> selected="selected" </c:if> >美术学院</option>
					    		<option value="7" <c:if test="${typeid==7}"> selected="selected" </c:if> >人文与社会学院</option>
					    		<option value="8" <c:if test="${typeid==8}"> selected="selected" </c:if> >传媒学院</option>
					    		<option value="9" <c:if test="${typeid==9}"> selected="selected" </c:if> >数学与计算科学学院</option>
					    		<option value="10" <c:if test="${typeid==10}"> selected="selected" </c:if> >物理与电气学院</option>
					    		<option value="11" <c:if test="${typeid==11}"> selected="selected" </c:if> >化学化工学院</option>
					    		<option value="12" <c:if test="${typeid==12}"> selected="selected" </c:if> >资源环境学院</option>
					    		<option value="13" <c:if test="${typeid==13}"> selected="selected" </c:if> >教师教育学院</option>
					    		<option value="14" <c:if test="${typeid==14}"> selected="selected" </c:if> >生命科学学院</option>
					    		<option value="15" <c:if test="${typeid==15}"> selected="selected" </c:if> >体育学院</option>
					    		<option value="16" <c:if test="${typeid==16}"> selected="selected" </c:if> >继续教育学院</option>
					    		<option value="17" <c:if test="${typeid==17}"> selected="selected" </c:if> >音乐与黄梅戏学院</option>
					    </select>
					    <input name='typeid'  type="hidden" class="text" style="width:154px" value="${typeid}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">支部名称:</td>
					    <td width="35%"><span class="red">
					    <input name='typename'  type="text" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">支部书记:</td>
					    <td width="35%"><span class="red">
				        <input name='username' type="text" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					    <td align="right" width="19%">班级:</td>
					    <td width="35%"><span class="red">
				        <input name='classname' type="text" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					  </tr>					 
					  <tr>
					    <td align="right" width="19%">人数:</td>
					    <td width="35%"><span class="red">
				        <input name='dangtype' type="text" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					    <td align="right" width="19%">党费收缴年度:</td>
					    <td width="35%"><span class="red">
				        <input name='shouyear' type="text" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">党费（每人2.4元/年）:</td>
					    <td width="35%"><span class="red">
				        <input name='dangfei' type="text" class="text" style="width:154px" value=""/>
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
