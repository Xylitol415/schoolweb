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
功能介绍：预备党员信息

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
<form name="fom" id="fom" method="post" action="StudentyuServlet?mtype=query">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"></td>
			<td width="550">查看内容：姓名：
              <input type="text" name="searchname0" value="${searchname0}" />
                班级：
              <input type="text" name="searchname1" value="${searchname1}" />
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
               <td height="20" ><font color="blue"  >预备党员信息管理</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${usertype==1}"><a href="files/studentyu/add.jsp">添加</a></c:if>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="javascript:window.print();" >打印</a> </td>
          	 </tr>
          	 <tr>
               <td height="10" valign="top" ><hr size="1" color="green" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
                <table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" >
                  <tr>
                    <td  align="center" bgcolor="#EEEEEE">序列</td>
				    <td  align="center" bgcolor="#EEEEEE">支部名称</td>
				    <td  align="center" bgcolor="#EEEEEE">所属学院</td>
				    <td  align="center" bgcolor="#EEEEEE">姓名</td>
				    <td  align="center" bgcolor="#EEEEEE">班级</td>
				    <td  align="center" bgcolor="#EEEEEE">性别</td>
				    <td  align="center" bgcolor="#EEEEEE">民族</td>
				    <td  align="center" bgcolor="#EEEEEE">籍贯</td>
				    <td  align="center" bgcolor="#EEEEEE">出生日期</td>
				    <td  align="center" bgcolor="#EEEEEE">身份证号码</td>
				    <td  align="center" bgcolor="#EEEEEE">申请入党时间</td>
				    <td  align="center" bgcolor="#EEEEEE">列积极分子时间</td>
				    <td  align="center" bgcolor="#EEEEEE">发展对象时间</td>
				    <td  align="center" bgcolor="#EEEEEE">接收时间</td>
				    <td  align="center" bgcolor="#EEEEEE">入党介绍人</td>
				    <td  align="center" bgcolor="#EEEEEE">思想汇报</td>
				    <td  align="center" bgcolor="#EEEEEE">支部决议</td>
				    <td  align="center" bgcolor="#EEEEEE">审批状态</td>
				    <td  align="center" bgcolor="#EEEEEE">审批/审批人</td>
			      	<%if("1".equals((String)request.getSession().getAttribute("usertype"))){%>
			                    <td  align="center" bgcolor="#EEEEEE">操作</td>
			        <%} %> 
			        <td  align="center" bgcolor="#EEEEEE">转出</td>           
                  </tr>
                  <c:forEach items="${pageinfo.datas}" var="l" varStatus="i">
	                  <tr>
	                    <td bgcolor="#FFFFFF" align="center">${i.index+1}</td>
					    
					    <td bgcolor="#FFFFFF" align="center">${l.typename }</td>
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
					    <td bgcolor="#FFFFFF" align="center">${l.username }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.classname }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.sex }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.nation }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.place }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.barthday }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.idcard }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.rudate }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.fenzhi }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.fadate }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.jiedate }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.jieuser }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.sixiang }</td>
					    <td bgcolor="#FFFFFF" align="center">${l.jueyi }</td>
					    <td bgcolor="#FFFFFF" align="center">
					    <c:if test="${l.status =='待批准'}"><font color="green">待批准</font></c:if>
					    <c:if test="${l.status !=null&&l.status =='已同意'}"><font color="green">${l.status}</font></c:if>
					    <c:if test="${l.status !=null&&l.status =='不同意'}"><font color="red">${l.status}</font></c:if>
					    </td>
					    <td bgcolor="#FFFFFF" align="center">
					    <c:if test="${l.applyer ==null&&usertype==1}">待批准</c:if>
					    <c:if test="${l.applyer ==null&&usertype==0}"><a href="StudentyuServlet?mtype=apply&flag=0&id=${l.id}" >同意</a>|<a href="StudentyuServlet?mtype=apply&flag=1&id=${l.id}" >不同意</a></c:if>
					    <c:if test="${l.applyer !=null}">${l.applyer}</c:if>
					    </td>
					<%if("1".equals((String)request.getSession().getAttribute("usertype"))){%>		    
	                    <td bgcolor="#FFFFFF" align="center"><a href="StudentyuServlet?mtype=preupdate&id=${l.id}">修改</a>|<a onclick="doDelete(${l.id})">删除</a></td>
	                    <td bgcolor="#FFFFFF" align="center">
		                    <c:if test="${l.rollstatus == 0}"><a href="StudentyuServlet?mtype=prerollio&id=${l.id}">申请</a></c:if>
		                    <c:if test="${l.rollstatus == 1}"><font color="green">待审核</font></c:if>
		                </td>
	                <%} %>  
	                <%if("0".equals((String)request.getSession().getAttribute("usertype"))){%>		    
		                    <td bgcolor="#FFFFFF" align="center">
		                    <c:if test="${l.rollstatus == 0}"><font color="green">正常</font></c:if>
		                    <c:if test="${l.rollstatus == 1}"><a href="StudentyuServlet?mtype=rollupdate&flag=0&id=${l.id}" >同意</a>|<a href="StudentyuServlet?mtype=rollupdate&flag=1&id=${l.id}" >不同意</a></c:if>
		                    </td>
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
			window.location.href="StudentyuServlet?mtype=delete&id="+lid;
		}
	}
</script>
</body>
</html>
