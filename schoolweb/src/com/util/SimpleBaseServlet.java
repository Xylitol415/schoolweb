package com.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class SimpleBaseServlet extends HttpServlet  {
	//分页变量
	public int currentpage = 1;
	public int pageunit = 10;
	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPageunit() {
		return pageunit;
	}

	public void setPageunit(int pageunit) {
		this.pageunit = pageunit;
	}
	public int getCurrentpage(HttpServletRequest request) {
		String currentpage = request.getParameter("currentpage");
		if(currentpage != null && !"".equals(currentpage)){
			return Integer.parseInt(currentpage);
		}
		return this.currentpage;
	}

	public int getPageunit(HttpServletRequest request,String str) {
		String pageunit= request.getParameter("pageunit");
		if(pageunit != null && !"".equals(pageunit)){
			request.getSession().setAttribute(str, pageunit);
			return Integer.parseInt(pageunit);
		}else{
			return Integer.parseInt(request.getSession().getAttribute(str).toString());
		}
	}
}
