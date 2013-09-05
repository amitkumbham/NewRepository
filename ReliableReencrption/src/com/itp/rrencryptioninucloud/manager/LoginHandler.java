package com.itp.rrencryptioninucloud.manager;

import com.itp.rrencryptioninucloud.dbHandler.DbHandler;

public class LoginHandler {

	boolean valid;
	
	 public boolean isValid(String username,String password) throws Exception{
		
		 try{
			 valid=DbHandler.isValidAdmin(username, password);
		 }catch(Exception e){
			 throw e;
		 }
		 return valid;
		
	 }
}
