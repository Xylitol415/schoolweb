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
				if(document.form.username.value==""||document.form.username.value==null)
				{
					alert("不能为空！");
					document.form.username.focus();
					return false;
				}
				if(document.form.nation.value==""||document.form.nation.value==null)
				{
					alert("不能为空！");
					document.form.nation.focus();
					return false;
				}
				if(document.form.place.value==""||document.form.place.value==null)
				{
					alert("不能为空！");
					document.form.place.focus();
					return false;
				}
				if(document.form.barthday.value==""||document.form.barthday.value==null)
				{
					alert("不能为空！");
					document.form.barthday.focus();
					return false;
				}
				if(document.form.fenzhi.value==""||document.form.fenzhi.value==null)
				{
					alert("不能为空！");
					document.form.fenzhi.focus();
					return false;
				}
				if(document.form.rudate.value==""||document.form.rudate.value==null)
				{
					alert("不能为空！");
					document.form.rudate.focus();
					return false;
				}
				if(document.form.fenzhidate.value==""||document.form.fenzhidate.value==null)
				{
					alert("不能为空！");
					document.form.fenzhidate.focus();
					return false;
				}
				if(document.form.istrain.value==""||document.form.istrain.value==null)
				{
					alert("不能为空！");
					document.form.istrain.focus();
					return false;
				}
				if(document.form.sixiang.value==""||document.form.sixiang.value==null)
				{
					alert("不能为空！");
					document.form.sixiang.focus();
					return false;
				}
				if(document.form.idcard.value==""||document.form.idcard.value==null)
				{
					alert("不能为空！");
					document.form.sixiang.focus();
					return false;
				}
				var date1 = new Date(document.form.rudate.value);
				var date2 = new Date(document.form.barthday.value);
				var s1 = date1.getTime(),s2 = date2.getTime();
				var total = (s1 - s2)/1000;
				var day = parseInt(total / (24*60*60));//计算整数天数
				console.log(day>6570);
				if(day<6570){
					alert("入党年龄未满18岁，请重新输入申请入党时间！");
					return false;
				}
		
				var date3 = new Date(document.form.fenzhidate.value);
				var s3 = date3.getTime();
				var total = (s1 - s3)/1000;
				var day = parseInt(total / (24*60*60));//计算整数天数
				console.log(day>0);
				if(day>0){
					alert("列为积极分子时间应大于申请入党时间！");
					return false;
				}
				return true;
		}
</script>
</head>

<body class="ContentBody">
  <form action="StudentruServlet?mtype=update" method="post"  name="form"  onSubmit="return checkValue()" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
   <tr>
      <td height="10">&nbsp;</td>
  </tr>
  <tr>
      <td align="left" ><font color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改入党积极分子信息</font></td>
  </tr>
  <tr>
    <td class="CPanel">		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">		
		<tr>
			<td width="100%">
				<fieldset style="height:100%;">
				<legend>入党积极分子信息</legend>
				     <input name='id' type="hidden" class="text" style="width:154px" value="${studentru.id }"/>
				     <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="19%">学院名称:</td>
					    <td width="35%"><span class="red">
					    <select name="typeid1" disabled="disabled">
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
					    	<input name='typeid'  type="hidden" class="text" style="width:154px" value="${studentru.typeid}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">所属支部:</td>
					    <td width="35%"><span class="red">
					    <input name='typename'  type="text" class="text" style="width:154px" value="${studentru.typename}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">姓名:</td>
					    <td width="35%"><span class="red">
				        <input name='username' type="text" class="text" style="width:154px" value="${studentru.username}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">班级:</td>
					    <td width="35%"><span class="red">
				        <input name='classname' type="text" class="text" style="width:154px" value="${studentru.classname}"/>
				        *</span>
				        </td>
					  </tr>					 
					  <tr>
					    <td align="right" width="19%">性别:</td>
					    <td width="35%"><span class="red">
					    <select name='sex'>
					    	<option <c:if test="${studentru.sex=='男' }"> selected="selected"</c:if> value="男">男</option>
					    	<option <c:if test="${studentru.sex=='女' }"> selected="selected"</c:if> value="女">女</option>
					    </select>
				        *</span>
				        </td>
					    <td align="right" width="19%">民族:</td>
					    <td width="35%"><span class="red">
				        <input name='nation' type="text" class="text" style="width:154px" value="${studentru.nation}"/>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">籍贯:</td>
					    <td width="35%"><span class="red">
				        <input name='place' type="text" class="text" style="width:154px" value="${studentru.place}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">出生日期:</td>
					    <td width="35%"><span class="red">
				        <input type="text" name="barthday" id="barthday" value="${studentru.barthday}" class="Wdate date-font12-333" onClick="WdatePicker({})" size="12" maxlength="15" style="border: solid 1px #ccc;width: 100px" size="40"  > 
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">积极分子:</td>
					    <td width="35%"><span class="red">
					    <select name='fenzhi'>
					    	<option <c:if test="${studentru.fenzhi=='是' }"> selected="selected"</c:if> value="是">是</option>
					    	<option <c:if test="${studentru.fenzhi=='否' }"> selected="selected"</c:if> value="否">否</option>
					    </select>
				        *</span>
				        </td>
					    <td align="right" width="19%">申请入党时间:</td>
					    <td width="35%"><span class="red">
					    <input type="text" name="rudate" id="rudate" value="${studentru.rudate}" class="Wdate date-font12-333" onClick="WdatePicker({})" size="12" maxlength="15" style="border: solid 1px #ccc;width: 100px" size="40"  > 
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">列积极分子时间:</td>
					    <td width="35%"><span class="red">
					    <input type="text" name="fenzhidate" id="fenzhidate" value="${studentru.fenzhidate}" class="Wdate date-font12-333" onClick="WdatePicker({})" size="12" maxlength="15" style="border: solid 1px #ccc;width: 100px" size="40"  > 
				        *</span>
				        </td>
					    <td align="right" width="19%">是否培训:</td>
					    <td width="35%"><span class="red">
					    <select name='istrain'>
					    	<option <c:if test="${studentru.istrain=='是' }"> selected="selected"</c:if> value="是">是</option>
					    	<option <c:if test="${studentru.istrain=='否' }"> selected="selected"</c:if> value="否">否</option>
					    </select>
				        *</span>
				        </td>
					  </tr>
					  <tr>
					    <td align="right" width="19%">思想汇报:</td>
					    <td width="35%"><span class="red">
				        <input name='sixiang' type="text" class="text" style="width:154px" value="${studentru.sixiang}"/>
				        *</span>
				        </td>
					    <td align="right" width="19%">身份证号码：</td>
					    <td width="35%"><span class="red">
					    <input name='idcard' type="text" class="text" style="width:154px" value="${studentru.idcard}"/>
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
