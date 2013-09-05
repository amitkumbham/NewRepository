package com.itp.cloud.dbConstants;


	public interface DbConstants {
		final static String DRIVERNAME="com.mysql.jdbc.Driver";
		final static String DATABASENAME="cloud";
		final static  String DATABASEURL = "jdbc:mysql://localhost:3306/cloud";
		final static String USERNAME="root";
		final static String PASSWORD="";


		final static String VALIDUSER="select * from Registration where userName=? and password=? and Role=?";
		final static String INSERTUSER="insert into Registration(userName,password,emailId,phonenumber,securityquestion,secqurityanswer,Role,token) values(?,?,?,?,?,?,?,?)";
		final static String ADDSERVER="create table AddServer";
		final static String INSERTSERVER="insert into Insertserver(addserver,filename,fileid,filedata) values(?,?,?,?)";
		final static String DELETESERVER="Delete from Servername where  servername=?";
		final static String severInfo="insert into severInfo(mserver,kserver) values(?,?)";
		final static String updateregistration="update Registration where userName=?";
		String SELECTUSER="select * from Registration where userName=?";
		String CHECKANSWER="select * from Registration where userName=? and securityQuestion=? and secqurityanswer=?";
		
		//Server related queries
	
		
		// Server Status Queries  
		
		String SELECTSERVERLIST="SELECT * FROM SERVERSTATUS WHERE STATUS=? order by serverName";
		String INSERTSERVERSTATUS="INSERT INTO SERVERSTATUS (SERVERNAME,STATUS) VALUES(?,?)";
		String UPDATESERVERSTATUS="UPDATE SERVERSTATUS SET STATUS=? WHERE SERVERNAME=?";
		String DELETESERVERSTATUS="DELETE FROM SERVERSTATUS WHERE SERVERNAME=?";
		
		// Update related queries
		
		final static String VALIDACTION="select * from Registration where userName=? and token=?";

		
// user request Queries  
		
		String SELECTUSERREQESTLIST="SELECT * FROM USERREQUESTS WHERE STATUS=? order by serverName";
		String INSERTUSERREQEST="INSERT INTO USERREQUESTS (SERVERNAME,USERNAME,STATUS) VALUES(?,?,?)";
		String UPDATEUSERREQEST="UPDATE USERREQUESTS SET STATUS=? WHERE SERVERNAME=?";
		String DELETEUSERREQEST="DELETE FROM USERREQUESTS WHERE SERVERNAME=?";
		
}
