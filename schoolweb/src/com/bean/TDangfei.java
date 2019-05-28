package com.bean;

/**
 * 
 * 
 * 党费信息bean
 */

public class TDangfei implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeid;
	private String typename;
	private String username;
	private String classname;
	private Integer dangtype; // 党员人数
	private String shouyear;
	private Double dangfei;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getDangtype() {
		return dangtype;
	}
	public void setDangtype(Integer dangtype) {
		this.dangtype = dangtype;
	}
	public String getShouyear() {
		return shouyear;
	}
	public void setShouyear(String shouyear) {
		this.shouyear = shouyear;
	}
	public Double getDangfei() {
		return dangfei;
	}
	public void setDangfei(Double dangfei) {
		this.dangfei = dangfei;
	}

}