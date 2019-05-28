<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(request.getParameter("flag")!=null&&"success".equals(request.getParameter("flag"))){
	response.getWriter().println("<script>alert('添加成功!');</script>");
}
if(request.getParameter("flag")!=null&&"error".equals(request.getParameter("flag"))){
	response.getWriter().println("<script>alert('用户名已存在!');</script>");
}
%>
<!-- 
功能介绍：用户查看列表（系统管理员使用）

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form name="fom" id="fom" method="post" action="UserServlet?mtype=query">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"></td>
			<td width="550">查看内容： 登录名：
              <input type="text" name="searchname" value="${searchname}" />
              <input name="Submit" type="submit" class="right-button02" value="查 询" /></td>
			 <td width="132" align="left"></td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20" ><font color="blue"  >系统管理</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="files/user/useradd.jsp">添加</a> </td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
				    <td  align="center" bgcolor="#EEEEEE">登录名</td>
                    <td  height="20" align="center" bgcolor="#EEEEEE">姓名</td>
                    <td  align="center" bgcolor="#EEEEEE">编号</td>
                    <td  align="center" bgcolor="#EEEEEE">地址</td>
                    <td  align="center" bgcolor="#EEEEEE">电话</td>
                    <td  align="center" bgcolor="#EEEEEE">身份证</td>
                    <td  align="center" bgcolor="#EEEEEE">所属学院</td>
                    <td  align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${pageinfo.datas}" var="l" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF" align="center">${i.index+1}</td>
					    <td bgcolor="#FFFFFF" align="center">${l.username }</td>
	                    <td bgcolor="#FFFFFF" align="center">${l.realname }</td>
	                    <td bgcolor="#FFFFFF" align="center">${l.usernum }</td>
	                    <td bgcolor="#FFFFFF" align="center">${l.atrr }</td>
	                    <td bgcolor="#FFFFFF" align="center">${l.phone}</td>
	                    <td bgcolor="#FFFFFF" align="center">${l.card}</td>
	                    <td bgcolor="#FFFFFF" align="center">
	                    <c:if test="${l.typeid==0}">经济与管理学院</c:if>
	                    <c:if test="${l.typeid==1}">文学院</c:if>
	                    <c:if test="${l.typeid==2}">计算机与信息学院</c:if>
	                    <c:if test="${l.typeid==3}">外国语学院</c:if>
	                    <c:if test="${l.typeid==4}">法学院</c:if>
	                    <c:if test="${l.typeid==5}">马克思主义学院</c:if>
	                    <c:if test="${l.typeid==6}">美术学院</c:if>
	                    <c:if test="${l.typeid==7}">人文与社会学院</c:if>
	                    <c:if test="${l.typeid==8}">传媒学院</c:if>
	                    <c:if test="${l.typeid==9}">数学与计算科学学院</c:if>
	                    <c:if test="${l.typeid==10}">物理与电气学院</c:if>
	                    <c:if test="${l.typeid==11}">化学化工学院</c:if>
	                    <c:if test="${l.typeid==12}">资源环境学院</c:if>
	                    <c:if test="${l.typeid==13}">教师教育学院</c:if>
	                    <c:if test="${l.typeid==14}">生命科学学院</c:if>
	                    <c:if test="${l.typeid==15}">体育学院</c:if>
	                    <c:if test="${l.typeid==16}">继续教育学院</c:if>
	                    <c:if test="${l.typeid==17}">音乐与黄梅戏学院</c:if> 
	                    </td>
	                    <td bgcolor="#FFFFFF" align="center"><a href="UserServlet?mtype=preupdate&id=${l.id}">修改</a>|<a onclick="doDelete(${l.id})">删除</a></td>
	                  </tr>
	               </c:forEach>
                </table></td>
              </tr>
              <tr>
		              	<td rowspan="1">
		              	<c:import url="/pagetag.jsp"></c:import>
		              	</td>
		       </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
<script type="text/javascript">
	function doDelete(lid){
		/*如果弹出的对话框，用户点击的是确定，马上去请求Servlet
		*/
		var flag = confirm("是否确定删除？");
		if(flag){
			// 表明点了确定，访问servlet，在当前页面上打开超链接
			window.location.href="UserServlet?mtype=delete&id="+lid;
		}
	}
</script>
</body>
</html>
