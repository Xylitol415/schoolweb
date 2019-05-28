<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
功能介绍：系统登录界面

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>高校学生党员管理信息系统</title>
<style type="text/css">
<!--
body {
    background-color:yellow;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function commit() {
	if(form1.username.value=="") {
		alert("请您输入用户名！");
		form1.username.focus();
		return false;
	}
	if(form1.password.value=="") {
		alert("请您输入密码！");
		form1.password.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<form action="UserServlet?mtype=login" method="post" name="form1" onsubmit="return commit()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="147" background="images/top02.gif" width="100%" ><img src="images/top.png" width="100%" /></td>
  </tr>
</table>
<center>
<fieldset style="width:562px;align=center">
<table width="562" border="0" align="center" cellpadding="0" cellspacing="0" class="right-table03">
  <tr>
    <td width="221"><table width="95%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
      
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="login-text01">
          <tr>
            <td align="center"><img src="images/ico13.gif" width="107" height="97" /></td>
          </tr>
          <tr>
            <td height="40" align="center">&nbsp;</td>
          </tr>
          
        </table></td>
        <td width="5" height="292" >&nbsp;</td>
      </tr>
    </table></td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">帐	号&nbsp;&nbsp;&nbsp;<br /></td>
        <td width="69%"><input name="username" id= "username" type="text" size="28" style="width:150px" /></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密	码&nbsp;&nbsp;&nbsp;<br /></td>
        <td><input name="password" id="password" type="password" size="30" style="width:150px"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">用  户&nbsp;&nbsp;&nbsp;<br /></td>
        <td><input name="usertype" id="usertype" type="radio" checked="checked" value="0" /><font size="2">超级管理员</font>&nbsp;<input name="usertype" id="usertype" type="radio"  value="1" /><font size="2">系管理员</font></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input name="Submit2" type="submit"  value="登 录" />
          &nbsp;&nbsp;&nbsp;<input name="reset2" type="reset""  value="重 置" /></td>
      </tr>
      <%
      if("error".equals(request.getParameter("info"))){ %>
      	<font color="red">登录信息错误，请重新填写！</font>
      <%}%>
      
    </table></td>
  </tr>
</table>
</fieldset>
</center>
</form>
</body>
</html>