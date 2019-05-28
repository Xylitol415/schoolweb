<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：用户密码修改页面

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
<script type="text/javascript">
function commit() {
	if(form1.password1.value=='') {
		alert("密码不能为空，请重新输入！");
		form1.password1.focus();
		return false;
	}
		if(form1.password2.value=='') {
		alert("密码不能为空，请重新输入！");
		form1.password2.focus();
		return false;
	}
	if(form1.password2.value!=form1.password1.value) {
		alert("两次密码输入不同，请重新输入！");
		form1.password1.focus();
		return false;
	}
	return true;
}
</script>
</head>

<body class="ContentBody">
  <form action="UserServlet?mtype=updatepassword" method="post"  name="form1" onsubmit="return commit();" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人管理>>密码修改</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>密码信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">新密码:</td>
					    <td width="35%"><span class="red">
				        <input name='password1' type="password"" class="text" style="width:154px" value=""/>
				        *</span>
				        </td>
					    <td align="right" width="19%">确认密码:</td>
					    <td width="35%"><span class="red">
				        <input name='password2' type="password" class="text" style="width:154px" value=""/>
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
			<input type="submit" name="submitbut" value="保存" />　
			
			<input type="reset" name="reset" value="重置" /></TD>
		</TR>
		</TABLE>

</div>
</form>
</body>
</html>
