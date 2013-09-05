package com.itp.rrencryptioninucloud.manager;

import com.itp.rrencryptioninucloud.dbHandler.DbHandler;


public class UserHandler {
	String username,password;
	boolean valid;
	
 public boolean isValid(String username,String password) throws Exception{
	
	 try{
		 valid=DbHandler.isValidUser(username, password);
	 }catch(Exception e){
		 throw e;
	 }
	 return valid;
	
 }
 
 
 public boolean isValid(String username,String password,String role) throws Exception{
		
	 try{
		 valid=DbHandler.isValidUser(username, password,role);
	 }catch(Exception e){
		 throw e;
	 }
	 return valid;
	
 }
 

}
