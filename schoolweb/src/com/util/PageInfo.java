package com.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageInfo {

	public PageInfo() {
	}
/*	public PageInfo(int curpage,int pagerecord,int allrecord)
	{
		this.curpage=curpage;
		this.pagerecord=pagerecord;
		this.allrecord=allrecord;
		this.allpage=(allrecord+pagerecord-1)/pagerecord;
	}*/
	public PageInfo(int curpage,int pagerecord,int allrecord,List pageData)
	{
		
		this.currentpage=curpage;
		this.pageunit=pagerecord;
		this.totlerecords=allrecord;
		int num =(allrecord+pagerecord-1)/pagerecord;
		this.pagenum=num;
		this.datas=pageData;
	}
	public PageInfo(int currentpage, int pageunit, int totlerecords, String url, List datas) {
		this.currentpage = currentpage;
		this.pageunit = pageunit;
		this.totlerecords = totlerecords;
		this.url = url;
		this.nextpage = this.currentpage + 1;
		this.prepage = this.currentpage - 1;
		int num = (totlerecords + pageunit -1)/pageunit;
		if(num==0){
			num = 1;
		}
		this.pagenum = num;
		this.datas = datas;
	}

	
	private Map<String,String> condition; //查询条件
	
	private int currentpage;	//当前页
	
	private int pageunit;		//分页单位
	
	private int totlerecords;	//总记录数
	
	private int pagenum;		//总页数
	
	private int prepage; 		 //上一页
	
	private int nextpage; 		//下一页
	
	private String url;
	
	private List datas;
	
	private List jsr = new ArrayList(0);			


	public List getJsr() {
		return jsr;
	}

	public void setJsr(List jsr) {
		this.jsr = jsr;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public int getNextpage() {
		return nextpage;
	}

	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		if(pagenum==0){
			pagenum = 1;
		}
		this.pagenum = pagenum;
	}

	public int getPageunit() {
		return pageunit;
	}

	public void setPageunit(int pageunit) {
		this.pageunit = pageunit;
	}

	public int getPrepage() {
		return prepage;
	}

	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}

	public int getTotlerecords() {
		return totlerecords;
	}

	public void setTotlerecords(int totlerecords) {
		this.totlerecords = totlerecords;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, String> getCondition() {
		return condition;
	}
	public void setCondition(Map<String, String> condition) {
		this.condition = condition;
	}
}
