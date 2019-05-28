<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.util.*" %>
<script type="text/javascript">
			function checkpageunit(){
				var pageunit = document.getElementsByName("pageunit")[0];
				if(/[^\d]+/.test(pageunit.value)){
					alert("请输入一个数字！");
					pageunit.focus();
					return false;
				}
				if(pageunit.value<=0){
					alert("请输入大于零的数字！");
					pageunit.focus();
					return false;
				}
			}
			//查询栏中 点击翻页链接执行此方法
			function serch_reselt(pagenum,pageunit){
				pageForm.action =document.getElementById("_cond").value + "&currentpage="+pagenum+"&pageunit="+pageunit;
				pageForm.submit();
			}
			
</script>
   <form name="pageForm" id="pageaction" action = "${pageinfo.url }"  method = "post" onsubmit="return checkpageunit();">
   <table   class="trcolor04"    width = "100%" border = "0" rules = "none">
		<tr align = "center">
			<td>
				<input name="cond"  id="_cond" value="${pageinfo.url }" type="hidden">
				<input name="pageunit"  id="pageunit" value="10" type="hidden">
				<div id="setCount">
				<!-- 每页显示数量：&nbsp;
				<select name="pageunit" id="pageunit">
					<option value="2" ${pageinfo.pageunit==2 ? "selected='selected'" : "" }>2</option>
					<option value="5" ${pageinfo.pageunit==5 ? "selected='selected'" : "" }>5</option>
					<option value="10" ${pageinfo.pageunit==10 ? "selected='selected'" : "" }>10</option>
					<option value="20" ${pageinfo.pageunit==20 ? "selected='selected'" : "" }>20</option>
					<option value="50" ${pageinfo.pageunit==50 ? "selected='selected'" : "" }>50</option>
					<option value="100" ${pageinfo.pageunit==100 ? "selected='selected'" : "" }>100</option>
				</select>
				 <input type = "button"   value="设置"  class="an01"  onclick="serch_reselt2()">-->
				</div>
			</td>
			<td>共${pageinfo.pagenum}页</td>
			<td>共${pageinfo.totlerecords}条记录</td>
			<td>当前第${pageinfo.currentpage }页</td>
			<td>每页${pageinfo.pageunit }条记录</td>
			<td align = "right">
				<%if(((PageInfo)request.getAttribute("pageinfo")).getCurrentpage()!=1){ %>
					<a id="startpage" href = "javascript:serch_reselt(1,${pageinfo.pageunit});">首页</a>
					<a id="prepage" href = "javascript:serch_reselt(${pageinfo.currentpage-1 },${pageinfo.pageunit});">上一页</a>
				<%} %>
			</td>
			<td align = "left">
				<%if(((PageInfo)request.getAttribute("pageinfo")).getCurrentpage()!=((PageInfo)request.getAttribute("pageinfo")).getPagenum()){ %>
					<a id="nextpage" href="javascript:serch_reselt(${pageinfo.currentpage+1 },${pageinfo.pageunit});" >下一页</a>&nbsp;&nbsp;&nbsp;
					<a id="lastpage" href="javascript:serch_reselt(${pageinfo.pagenum },${pageinfo.pageunit});">尾页</a>
				<%} %>
			</td>
		</tr>
	</table>
   </form>
   

