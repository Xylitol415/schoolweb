package com.bean;

/**
 * 
 * 
 * 支部信息bean
 */

public class TSonnotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeid;
	private String typename;
	private Integer rusun;
	private Integer yusun;
	private Integer dangsun;
	private Integer ssun;
	private String username;
	private String tel;
	private String phone;
	private String email;
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
	public Integer getRusun() {
		return rusun;
	}
	public void setRusun(Integer rusun) {
		this.rusun = rusun;
	}
	public Integer getDangsun() {
		return dangsun;
	}
	public void setDangsun(Integer dangsun) {
		this.dangsun = dangsun;
	}
	public Integer getYusun() {
		return yusun;
	}
	public void setYusun(Integer yusun) {
		this.yusun = yusun;
	}
	public Integer getSsun() {
		return ssun;
	}
	public void setSsun(Integer ssun) {
		this.ssun = ssun;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}