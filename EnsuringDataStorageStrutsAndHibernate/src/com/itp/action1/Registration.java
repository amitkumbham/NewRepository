package com.itp.action1;

import org.apache.log4j.Logger;

import javassist.compiler.ast.Symbol;

import com.itp.action1.persistance1.LoginClient;
import com.itp.action1.persistance1.RegistrationBean;
import com.opensymphony.xwork2.ActionSupport;

public class Registration extends ActionSupport 
{
	static org.apache.log4j.Logger log = Logger.getLogger(LoginClient.class);
	
	public Registration()
	{
		log.debug("from constructor");
	}
	
	private String username;
	private String password;
	private String emailid;
	private String phonenumber;
	private String securityquestion;
	private String securityanswer;
	private String usertype;
	private int id=0;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		System.out.println(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSecurityquestion() {
		return securityquestion;
	}

	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}

	public String getSecurityanswer() {
		return securityanswer;
	}

	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	
	
	
	@Override
	public String execute() throws Exception 
	{
		return "success";
	}

	RegistrationBean rb=new RegistrationBean();
	
	
	
	public RegistrationBean getRb() {
		return rb;
	}



	public void setRb(RegistrationBean rb) {
		this.rb = rb;
	}



	public String userRegistration() 
	{
		
		//Registration rb=new Registration();
		System.out.println(rb.getPhonenumber());
		rb.setId(id);
		rb.setUsername(username);
		rb.setPassword(password);
		rb.setEmailid(emailid);
		rb.setPhonenumber(phonenumber);
		rb.setSecurityquestion(securityquestion);
		rb.setSecurityanswer(securityanswer);
		rb.setUsertype(usertype);
		
		LoginClient lc= new LoginClient();
				
		lc.registration(rb);
		
		return "success";

	}

}
