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
				if(document.form.typename.value==""||document.form.typename.value==null)
				{
					alert("不能为空！");
					document.form.typename.focus();
					return false;
				}
				if(document.form.huoname.value==""||document.form.huoname.value==null)
				{
					alert("不能为空！");
					document.form.huoname.focus();
					return false;
				}
				if(document.form.place.value==""||document.form.place.value==null)
				{
					alert("不能为空！");
					document.form.place.focus();
					return false;
				}
				if(document.form.huodate.value==""||document.form.huodate.value==null)
				{
					alert("不能为空！");
					document.form.huodate.focus();
					return false;
				}
				if(document.form.csum.value==""||document.form.csum.value==null)
				{
					alert("不能为空！");
					document.form.csum.focus();
					return false;
				}
				if(document.form.huouser.value==""||document.form.huouser.value==null)
				{
					alert("不能为空！");
					document.form.huouser.focus();
					return false;
				}
				if(document.form.tel.value==""||document.form.tel.value==null)
				{
					alert("不能为空！");
					document.form.tel.focus();
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
  <form action="ZuzhiServlet?mtype=update" method="post"  name="form"  onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改组织信息</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>组织信息</legend>
				     <input name='id' type="hidden" class="text" style="width:154px" value="${zuzhi.id }"/>
				     <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">院系名称:</td>
					    <td width="35%"><span class="red">
					    <select name="typeid1" disabled="disabled">							    	
					    		<option value="0" <c:if test="${zuzhi.typeid==0}"> selected="selected" </c:if> >经济与管理学院</option>
					    		<option value="1" <c:if test="${zuzhi.typeid==1}"> selected="selected" </c:if> >文学院</option>
					    		<option value="2" <c:if test="${zuzhi.typeid==2}"> selected="selected" </c:if> >计算机与信息学院</option>
					    		<option value="3" <c:if test="${zuzhi.typeid==3}"> selected="selected" </c:if> >外国语学院</option>
					    		<option value="4" <c:if test="${zuzhi.typeid==4}"> selected="selected" </c:if> >法学院</option>
					    		<option value="5" <c:if test="${zuzhi.typeid==5}"> selected="selected" </c:if> >马克思主义学院</option>
					    		<option value="6" <c:if test="${zuzhi.typeid==6}"> selected="selected" </c:if> >美术学院</option>
					    		<option value="7" <c:if test="${zuzhi.typeid==7}"> selected="selected" </c:if> >人文与社会学院</option>
					    		<option value="8" <c:if test="${zuzhi.typeid==8}"> selected="selected" </c:if> >传媒学院</option>
					    		<option value="9" <c:if test="${zuzhi.typeid==9}"> selected="selected" </c:if> >数学与计算科学学院</option>
					    		<option value="10" <c:if test="${zuzhi.typeid==10}"> selected="selected" </c:if> >物理与电气学院</option>
					    		<option value="11" <c:if test="${zuzhi.typeid==11}"> selected="selected" </c:if> >化学化工学院</option>
					    		<option value="12" <c:if test="${zuzhi.typeid==12}"> selected="selected" </c:if> >资源环境学院</option>
					    		<option value="13" <c:if test="${zuzhi.typeid==13}"> selected="selected" </c:if> >教师教育学院</option>
					    		<option value="14" <c:if test="${zuzhi.typeid==14}"> selected="selected" </c:if> >生命科学学院</option>
					    		<option value="15" <c:if test="${zuzhi.typeid==15}"> selected="selected" </c:if> >体育学院</option>
					    		<option value="16" <c:if test="${zuzhi.typeid==16}"> selected="selected" </c:if> >继续教育学院</option>
					    		<option value="17" <c:if test="${zuzhi.typeid==17}"> selected="selected" </c:if> >音乐与黄梅戏学院</option>
					    	</select>
					    	<input name='typeid'  type="hidden" class="text" style="width:154px" value="${zuzhi.typeid}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">所属支部:</td>
					    <td width="35%"><span class="red">
					    <input name='typename'  type="text" class="text" style="width:154px" value="${zuzhi.typename}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">活动名称:</td>
					    <td width="35%"><span class="red">
				        <input name='huoname' type="text" class="text" style="width:154px" value="${zuzhi.huoname}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">地点:</td>
					    <td width="35%"><span class="red">
				        <input name='place' type="text" class="text" style="width:154px" value="${zuzhi.place}"/>
				        *</span>
				        </td>
					  </tr>					 
					  <tr>
					    <td align="right" width="19%">活动时间:</td>
					    <td width="35%"><span class="red">
					    <input type="text" name="huodate" id="huodate" value="${zuzhi.huodate}" class="Wdate date-font12-333" onClick="WdatePicker({})" size="12" maxlength="15" style="border: solid 1px #ccc;width: 100px" size="40"  > 
				        *</span>
				        </td>
					    <td align="right" width="19%">参与人数:</td>
					    <td width="35%"><span class="red">
				        <input name='csum' type="text" class="text" style="width:154px" value="${zuzhi.csum}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">活动负责人:</td>
					    <td width="35%"><span class="red">
				        <input name='huouser' type="text" class="text" style="width:154px" value="${zuzhi.huouser}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">联系电话:</td>
					    <td width="35%"><span class="red">
				        <input name='tel' type="text" class="text" style="width:154px" value="${zuzhi.tel}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">活动详情:</td>
					    <td width="35%"><span class="red">
					    <input name='xiangqing' type="text" class="text" style="width:154px" value="${zuzhi.xiangqing}"/>
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
