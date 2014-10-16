package com.briup.estore.bean;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String userid;
	private String password;
	private String department;
	private String lianxi1;
	private String lianxi2;
	private String email;
	private int tel;
	private int shouji;
	private int youbian;
	private int telphone;
	public int getTelphone(){
		return telphone;
	}
	public void setTelphone(int telphone){
		this.telphone=telphone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLianxi1() {
		return lianxi1;
	}
	public void setLianxi1(String lianxi1) {
		this.lianxi1 = lianxi1;
	}
	public String getLianxi2() {
		return lianxi2;
	}
	public void setLianxi2(String lianxi2) {
		this.lianxi2 = lianxi2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getShouji() {
		return shouji;
	}
	public void setShouji(int shouji) {
		this.shouji = shouji;
	}
	public int getYoubian() {
		return youbian;
	}
	public void setYoubian(int youbian) {
		this.youbian = youbian;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userid,String lianxi1, String password,int youbian,int tel,int telphone,String email,int shouji) {
		this.email=email;
		this.youbian=youbian;
		this.tel=tel;
		this.shouji=shouji;
		this.userid = userid;
		this.password = password;
		this.lianxi1=lianxi1;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

	
}
