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
<%if("0".equals((String)request.getSession().getAttribute("usertype"))){%>
<form name="fom" id="fom" method="post" action="NoticeServlet?mtype=query">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"></td>
			<td width="550">查看内容：学院名称：
              <select name="searchname">
              		<option value="">-请选择-</option>
		    		
		    		<option value="0" <c:if test="${searchname==0}"> selected="selected" </c:if> >经济与管理学院</option>
		    		<option value="1" <c:if test="${searchname==1}"> selected="selected" </c:if> >文学院</option>
		    		<option value="2" <c:if test="${searchname==2}"> selected="selected" </c:if> >计算机与信息学院</option>
		    		<option value="3" <c:if test="${searchname==3}"> selected="selected" </c:if> >外国语学院</option>
		    		<option value="4" <c:if test="${searchname==4}"> selected="selected" </c:if> >法学院</option>
		    		<option value="5" <c:if test="${searchname==5}"> selected="selected" </c:if> >马克思主义学院</option>
		    		<option value="6" <c:if test="${searchname==6}"> selected="selected" </c:if> >美术学院</option>
		    		<option value="7" <c:if test="${searchname==7}"> selected="selected" </c:if> >人文与社会学院</option>
		    		<option value="8" <c:if test="${searchname==8}"> selected="selected" </c:if> >传媒学院</option>
		    		<option value="9" <c:if test="${searchname==9}"> selected="selected" </c:if> >数学与计算科学学院</option>
		    		<option value="10" <c:if test="${searchname==10}"> selected="selected" </c:if> >物理与电气学院</option>
		    		<option value="11" <c:if test="${searchname==11}"> selected="selected" </c:if> >化学化工学院</option>
		    		<option value="12" <c:if test="${searchname==12}"> selected="selected" </c:if> >资源环境学院</option>
		    		<option value="13" <c:if test="${searchname==13}"> selected="selected" </c:if> >教师教育学院</option>
		    		<option value="14" <c:if test="${searchname==14}"> selected="selected" </c:if> >生命科学学院</option>
		    		<option value="15" <c:if test="${searchname==15}"> selected="selected" </c:if> >体育学院</option>
		    		<option value="16" <c:if test="${searchname==16}"> selected="selected" </c:if> >继续教育学院</option>
		    		<option value="17" <c:if test="${searchname==17}"> selected="selected" </c:if> >音乐与黄梅戏学院</option>
			  </select>
              <input name="Submit" type="submit" class="right-button02" value="查 询" /></td>
			 <td width="132" align="right">
			 <%if("1".equals((String)request.getSession().getAttribute("usertype"))){%>
			 <img src="./images/laba.png"></img>
			 <font size="2px" color="red"><marquee scrollamount="3" width="150px;" direction="left" behavior="scroll">
			<a href="NewsServlet?mtype=query" style="color:red;"> 公告：${tnews.remark }</a></marquee></font>
			  <%} %> 
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
               <td height="20" ><font color="blue"  >学院信息管理</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${usertype==0}"><a href="files/notice/add.jsp">添加</a></c:if> </td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
				    <td  align="center" bgcolor="#EEEEEE">学院名称</td>
				    <td  align="center" bgcolor="#EEEEEE">入党积极分子人数</td>
				    <td  align="center" bgcolor="#EEEEEE">预备党员人数</td>				    
				    <td  align="center" bgcolor="#EEEEEE">正式党员人数</td>				
				    <td  align="center" bgcolor="#EEEEEE">学生人数</td>
				    <td  align="center" bgcolor="#EEEEEE">办公室主任</td>
				    <td  align="center" bgcolor="#EEEEEE">办公室电话</td>
      	
                    <td  align="center" bgcolor="#EEEEEE">操作</td>
                   
                  </tr>
                  <c:forEach items="${pageinfo.datas}" var="l" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF" align="center">${i.index+1}</td>
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
					    <td bgcolor="#FFFFFF" align="center">${l.runum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.yunum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.zhnum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.snum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.username }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.tel }</td>
	                    <td bgcolor="#FFFFFF" align="center"><a href="NoticeServlet?mtype=preupdate&id=${l.id}">修改</a>|<a onclick="doDelete(${l.id})">删除</a></td>
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
 <%} %>
 
 
<%if("1".equals((String)request.getSession().getAttribute("usertype"))){%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"></td>
			<td width="550">
			 <td width="132" align="right">
			 <%if("1".equals((String)request.getSession().getAttribute("usertype"))){%>
			 <img src="./images/laba.png"></img>
			 <font size="2px" color="red"><marquee scrollamount="3" width="150px;" direction="left" behavior="scroll">
			<a href="NewsServlet?mtype=query" style="color:red;"> 公告：${tnews.remark }</a></marquee></font>
			  <%} %> 
			 </td>	
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
               <td height="20" ><font color="blue"  >近三年支部党员信息</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${usertype==0}"><a href="files/notice/add.jsp">添加</a></c:if> </td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
				    <td  align="center" bgcolor="#EEEEEE">年份</td>
				    <td  align="center" bgcolor="#EEEEEE">入党积极分子人数</td>
				    <td  align="center" bgcolor="#EEEEEE">预备党员人数</td>				    
				    <td  align="center" bgcolor="#EEEEEE">正式党员人数</td>				
				    <td  align="center" bgcolor="#EEEEEE">学生人数</td>
				   	<td  align="center" bgcolor="#EEEEEE">办公室主任</td>
				   	<td  align="center" bgcolor="#EEEEEE">办公室电话</td>
                  </tr>
                  <c:forEach items="${list}" var="l" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF" align="center">${i.index+1}</td>
					    <td bgcolor="#FFFFFF" align="center">${2019-i.index }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.runum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.yunum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.zhnum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.snum }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.username }</td>
					   	<td bgcolor="#FFFFFF" align="center">${l.tel }</td>
	                  </tr>
	               </c:forEach>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>
 <%} %>
 
<script type="text/javascript">
	function doDelete(lid){
		/*如果弹出的对话框，用户点击的是确定，马上去请求Servlet
		*/
		var flag = confirm("是否确定删除？");
		if(flag){
			// 表明点了确定，访问servlet，在当前页面上打开超链接
			window.location.href="NoticeServlet?mtype=delete&id="+lid;
		}
	}
</script>
</body>
</html>
