package com.itp.rrencryptioninucloud.manager;


import com.itp.rrencryptioninucloud.bean.User;
import com.itp.rrencryptioninucloud.dbHandler.DbHandler;


public class UserManager {
	boolean valid;
	String fname;
	String mname;
	String lname;
	String username;
	String password;
	String repwd;
	String phno;
	String emailid;
	String caddr;
	String paddr;
	String city;
	String pin;
	String state;
	String country;
	
	
public UserManager(User user){
	
}
public boolean createUser(User user) throws Exception{
	System.out.println("enter into createUser()----");
	try{
	valid=DbHandler.isCreateUser(user);
	}catch(Exception e){
		throw e;
	}
	return valid;
}

public boolean updateUserProfile(User user) throws Exception{
	try{
		System.out.println("enter into try block of updateUserProfile() method");
	valid=DbHandler.isupdateUserProfile(user);
	}catch(Exception e){
		throw e;
	}
	return valid;
}


}//class
