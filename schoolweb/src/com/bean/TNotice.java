package com.bean;

/**
 * 
 * 
 * 系部信息bean
 */

public class TNotice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeid;
	private Integer snum;
	private Integer runum;
	private Integer yunum;
	private Integer zhnum;
	private String username;
	private String tel;
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
	public Integer getSnum() {
		return snum;
	}
	public void setSnum(Integer snum) {
		this.snum = snum;
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
	public Integer getRunum() {
		return runum;
	}
	public void setRunum(Integer runum) {
		this.runum = runum;
	}
	public Integer getYunum() {
		return yunum;
	}
	public void setYunum(Integer yunum) {
		this.yunum = yunum;
	}
	public Integer getZhnum() {
		return zhnum;
	}
	public void setZhnum(Integer zhnum) {
		this.zhnum = zhnum;
	}
	@Override
	public String toString() {
		return "TNotice [id=" + id + ", typeid=" + typeid + ", snum=" + snum
				+ ", runum=" + runum + ", yunum=" + yunum + ", zhnum=" + zhnum
				+ ", username=" + username + ", tel=" + tel + "]";
	}
	

}