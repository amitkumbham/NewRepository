package com.itp.action1.persistance1;
//EmpBean.java(HB POJO class HB persistence class)
public class LoginBean implements java.io.Serializable
{
	//declare properties/fields
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}//class