<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 
功能介绍：系统左边菜单栏

 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>高校学生党员管理信息系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(../images/left.gif);
}
-->
</style>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="../images/ico05.gif";//图片ico04为白色的正方形
	
	for(var i=1;i<80;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="../images/ico06.gif";}//图片ico06为白色的正方形
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	
	//alert(imgobj);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="../images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="../images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="../images/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
  <tr>
    <TD>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="207" height="55" background="../images/nav01.gif">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tr>
					<td width="25%" rowspan="2"><img src="../images/ico02.gif" width="35" height="35" /></td>
					<td width="75%" height="22" class="left-font01">您好，<span class="left-font02"><%=(String)session.getAttribute("username") %></span></td>
				  </tr>
				  <tr>
					<td height="22" class="left-font01">
						[&nbsp;<a href="/schoolweb/out_login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]</td>
				  </tr>
				</table>
			</td>
		  </tr>
		</table>


		<!--  个人信息管理开始    公共 -->
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img1" id="img1" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="user/passwordupdate.jsp" target="mainFrame" class="left-font03" onClick="tupian('11');" >个人管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
		<!-- 个人信息管理结束    公共-->
		<% if("0".equals((String)request.getSession().getAttribute("usertype"))){%>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../UserServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >系统管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>   
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../NoticeServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >学院信息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../SonnoticeServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >支部信息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../StudentruServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >入党积极分子信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../StudentyuServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >预备党员信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../StudentzhServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >正式党员信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../DangfeiServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >党费信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../ZuzhiServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >组织活动信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../NewsServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >公告信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>              
      	<% }if("1".equals((String)request.getSession().getAttribute("usertype"))){
      	String typeid = (String)request.getSession().getAttribute("typeid");
      	//out.write("typeid==="+typeid);
      	%>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../NoticeServlet?mtype=countQuery&typeid=${sessionScope.typeid }" target="mainFrame" class="left-font03" onClick="tupian('13');" >学院信息</a></td>
					</tr>
				</table>
			</td>
          </tr>	
          </TABLE>
          <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../SonnoticeServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >支部信息管理</a></td>
					</tr>
				</table>
			</td>
          </tr>	
          </TABLE> 
          <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../StudentruServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >入党积极分子信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../StudentyuServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >预备党员信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../StudentzhServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >正式党员信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../DangfeiServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >党费信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../ZuzhiServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >组织活动信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE>
        <TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="20">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img2" id="img2" src="../images/ico04.gif" width="8" height="11" /></td>
						<td width="92%">
								<a href="../NewsServlet?mtype=query" target="mainFrame" class="left-font03" onClick="tupian('13');" >公告信息</a></td>
					</tr>
				</table>
			</td>
          </tr>		  
        </TABLE> 	  
      	<%}%>    	   	    	
	  </TD>
  </tr>
  
</table>
</body>
</html>
