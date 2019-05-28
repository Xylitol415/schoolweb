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
%>
<!-- 
功能介绍：系部信息

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
<form name="fom" id="fom" method="post" action="NewsServlet?mtype=query">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"></td>
			<td width="550">查看内容：公告标题：
			  <input name="searchname" type="text" value="${searchname}">
              <input name="Submit" type="submit" class="right-button02" value="查 询" /></td>
				
			 <td width="132" align="left">
			 </td>
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  </form>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20" ><font color="blue"  >公告信息管理</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${usertype==0}"><a href="files/news/add.jsp">添加</a></c:if> </td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
				    <td  align="center" bgcolor="#EEEEEE">公告标题</td>
				    <td  align="center" bgcolor="#EEEEEE">发布时间</td>
				    <td  align="center" bgcolor="#EEEEEE">公告内容</td>
				    <td  align="center" bgcolor="#EEEEEE">发布人</td>
				    <td  align="center" bgcolor="#EEEEEE">公告详情</td>
      	<%if("0".equals((String)request.getSession().getAttribute("usertype"))){%>
                    <td  align="center" bgcolor="#EEEEEE">操作</td>
        <%} %>            
                  </tr>
                  <c:forEach items="${pageinfo.datas}" var="l" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF" align="center">${i.index+1}</td>
					    <td bgcolor="#FFFFFF" align="center">${l.title }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.inputdate }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.remark }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.username }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.xiangqing }</td>
		<%if("0".equals((String)request.getSession().getAttribute("usertype"))){%>		    
	                    <td bgcolor="#FFFFFF" align="center"><a href="NewsServlet?mtype=preupdate&id=${l.id}">修改</a>|<a onclick="doDelete(${l.id})">删除</a></td>
	                <%} %>  
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
<script type="text/javascript">
	function doDelete(lid){
		/*如果弹出的对话框，用户点击的是确定，马上去请求Servlet
		*/
		var flag = confirm("是否确定删除？");
		if(flag){
			// 表明点了确定，访问servlet，在当前页面上打开超链接
			window.location.href="NewsServlet?mtype=delete&id="+lid;
		}
	}
</script>
</body>
</html>
