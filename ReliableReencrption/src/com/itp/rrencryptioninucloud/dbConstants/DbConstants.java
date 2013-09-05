package com.itp.rrencryptioninucloud.dbConstants;

public interface DbConstants {
	final static String DRIVERNAME="com.mysql.jdbc.Driver";
	final static String DATABASENAME="rrencryption_cloud";
	final static String DATABASEURL = "jdbc:mysql://localhost:3306/rrencryption_cloud";
	final static String USERNAME="root";
	final static String PASSWORD="";

	final static String VALIDADMIN="select username,password from admin where username=? and password=?";
	final static String VALIDUSER="select emailid,password from  userdetails where emailid=? and password=? and usertype=?";
	final static String CREATEUSER="insert into userdetails(username,password,phone,emailid,usertype) values(?,?,?,?,?)";
	
	
	final static String DOCUMENTS="select documentId from document";
	final static String DOCDETAILS="select distinct(categoryName) from document where documentId=?";
	final static String GETUSER="select username,email_id,phno,city from userdetails";
	final static String GETID="select id,emailid from userdetails where usertype=?";
	
	final static String UPLOADDATA="insert into uploadfiledetails(keyvalue,ownername,filename,storedpath,filedata,uploaddate)values(?,?,?,?,?,now())";
	final static String GETFILEDETAILS="select storedpath from uploadfiledetails where keyvalue=?";
    final static String GETUPLOADEDFILES="select id,keyvalue,ownername,filename from uploadfiledetails where ownername=?";
	
	final static String MODIFYUSER="select *from userdetails where emailid=?";
	final static String UPDATEUSERDETAILS="update  userdetails set username=?,password=?,phone=?,usertype=?  where emailid=?";
	
	

}
