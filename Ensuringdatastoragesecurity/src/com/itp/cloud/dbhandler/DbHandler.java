package com.itp.cloud.dbhandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.itp.cloud.dbConstants.DbConstants;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;



public class DbHandler implements DbConstants{
	

	
	public static boolean isValidUser(String userName,String password,String userType) throws Exception
	{
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(VALIDUSER);
			ps.setString(1,userName);
			ps.setString(2, password);
			ps.setString(3, userType);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
			else{
				return false;
			}
			
		}catch(Exception ex){
			throw ex;
		}
		finally{
			if(con!=null)
			{
				try{
				con.close();	
				}catch(Exception ex)
				{
					throw ex;
				}
			}
		}
		
	} // end of method isValid....................
	
	public static boolean insertUser(List parm)throws Exception{
		Connection con=null;
		boolean  rs=false;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(INSERTUSER);
			for(int i=0;i<parm.size();i++)
			{
				ps.setString(i+1,parm.get(i)+"");
			}
			rs=ps.execute();
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(con!=null)
			{
				try{
				con.close();	
				}catch(Exception ex)
				{
					throw ex;
				}
			}
		}
	return rs;
	}
	
	
	
	public static boolean isAddServer()throws Exception{
		Connection con=null;
		boolean  rs=false;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(ADDSERVER);
			/*for(int i=0;i<parm.size();i++)
			{
				ps.setString(i+1,parm.get(i)+"");
			}*/
			rs=ps.execute();
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(con!=null)
			{
				try{
				con.close();	
				}catch(Exception ex)
				{
					throw ex;
				}
			}
		}
	return rs;
	}
	
	
	public static boolean addServer(String query)throws Exception{
		Connection con=null;
		int  rs=0;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(query);
			
			rs=ps.executeUpdate();
			if(rs>0)
				return false;
			else
				return true;
		}
		catch(Exception ex){
			throw ex;
		}
		finally{
			if(con!=null)
			{
				try{
				con.close();	
				}catch(Exception ex)
				{
					throw ex;
				}
			}
		}
	
	}  // End Of Add server 
	
		

public static boolean DeleteServer(String ServerName)throws Exception{
	Connection con=null;
	boolean  rs=false;
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(UPDATESERVERSTATUS);
		ps.setString(1, "false");
		ps.setString(2, ServerName);
		rs=ps.execute();
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}
return rs;
}

public static boolean severInfo(List parm)throws Exception{
	Connection con=null;
	boolean  rs=false;
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(severInfo);
		for(int i=0;i<parm.size();i++)
		{
			ps.setString(i+1,parm.get(i)+"");
		}
		rs=ps.execute();
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}
return rs;
}

	
public static boolean upDateUser(List parm)throws Exception{
	Connection con=null;
	boolean  rs=false;
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(updateregistration);
		for(int i=0;i<parm.size();i++)
		{
			ps.setString(i+1,parm.get(i)+"");
		}
		rs=ps.execute();
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}
return rs;
}

public static List selectServer(String serverName)throws Exception{
	Connection con=null;
	List list=new ArrayList();
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		String query="select * from "+serverName;
		System.out.println("inside select server");
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println("inside select server");
		ResultSet rs=ps.executeQuery();
		System.out.println("inside select server");
		ResultSetMetaData meta=(ResultSetMetaData)rs.getMetaData();
		System.out.println("inside select server");
		String firstCol=meta.getColumnName(1);
		String  secondColumn=meta.getColumnName(2);
		String Thirdcolumn=meta.getColumnName(3);
		System.out.println(firstCol+"   "+secondColumn+"  "+Thirdcolumn);
		while(rs.next())
		{
			Map  map=new HashMap();
			map.put(firstCol, rs.getString(1));
			map.put(secondColumn, rs.getString(2));
			map.put(Thirdcolumn, rs.getBinaryStream(3));
			list.add(map);
		}
	return list;
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}
public static List selectServerList(String status)throws Exception{
	Connection con=null;
	List list=new ArrayList();
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(SELECTSERVERLIST);
		ps.setString(1, status);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(rs.getString(2));
		}
	return list;
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}

public static boolean insertServerStatus(List params)throws Exception{
	Connection con=null;
		try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(INSERTSERVERSTATUS);
		for (int i = 0; i < params.size(); i++) {
			ps.setString(i+1,params.get(i)+"");
						
		}
		int update=ps.executeUpdate();
		if(update>0)
		{
			return true;
		}
		else
			return false;
	
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}

public static boolean updateServerStatus(String serverName,String status)throws Exception{
	Connection con=null;
		try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(UPDATESERVERSTATUS);
		ps.setString(1, status);
		ps.setString(2, serverName);
		System.out.println(serverName+"  "+status);
		
		int update=ps.executeUpdate();
		
		if(update>0)
		{
			return true;
		}
		else
			return false;
	
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}// End of Update Server Status

public static void addMKServer(int size){
	String addserver="server";
	String filename="FileName";
	String fileid="sNo";
	String filedata="UploadFile";
	try{
	int count=selectServerList("true").size();
	System.out.println("Server count  "+ count);
	for(int i=0;i<size;i++){
		String serverName=addserver+(count+i+1);
	String query="create table cloudcomputing."+serverName+" ("+fileid+" INT( 100 ) NOT NULL AUTO_INCREMENT PRIMARY KEY ,"+filename+" varchar(100),"+filedata+" blob)";
	System.out.println("query is "+query);
	
	
	boolean valid=DbHandler.addServer(query);
	List list=new ArrayList();
	list.add(serverName);
	list.add("true");
	DbHandler.insertServerStatus(list);
	}
	}catch(Exception ex)
	{
System.out.println(ex);
ex.printStackTrace();
	}

}


public static boolean uploadFile(String serverName,String fileName)
{
	Connection con=null;
	PreparedStatement pstatement = null;

	System.out.println("<br>saveFile name  11   ");
	try{

		// below code is to handle with the data type BLOB 
	

	com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
	ds.setServerName("localhost");

	ds.setPortNumber(3306);
	ds.setDatabaseName(DATABASENAME);
	ds.setUser(USERNAME);
	ds.setPassword(PASSWORD);
	con = ds.getConnection();
	String filePath=fileName;
	fileName=fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
	System.out.println("file name  "+fileName +"  file path=  "+filePath);
	InputStream in=new FileInputStream(filePath);
	String query="insert into "+serverName+"  values("+null+",?,?)";
	
	
	pstatement=con.prepareStatement(query);
	pstatement.setString(1, fileName);
	pstatement.setBinaryStream(2, in);
	boolean valid=pstatement.execute();
	if(!valid)
	
		return true;
	
	else
	
		return false;
	
	}
	catch(Exception e)
	{
		System.out.println(e);
		}
	finally{
		if(con!=null)
			try{
			con.close();
			
			}catch(Exception e){System.out.println(e);}
	}
	return false;

}// End of Upload file function

public static String downloadFile(String serverName,String columnName,String id)
{
	System.out.println(id);
	Connection con=null;
InputStream in=null;
	try{
		


	com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
	ds.setServerName("localhost");
	ds.setPortNumber(3306);
	ds.setDatabaseName(DATABASENAME);
	ds.setUser(USERNAME);
	ds.setPassword(PASSWORD);
	con = ds.getConnection();
	

	java.sql.Statement st=con.createStatement();
	System.out.println("haiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	System.out.println("Select * from "+serverName+"  where "+columnName+"="+id);
	ResultSet rs=st.executeQuery("Select * from "+serverName+"  where "+columnName+"="+"'"+id+"'");
	System.out.println("Select * from "+serverName+"  where "+columnName+"="+id);
	System.out.println("haiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	String fileName=null;
	 if(rs.next())
	 {
	 in=rs.getBinaryStream(3);
	 System.out.println("haiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii     3");
	//////////////////////////////////
	 fileName="C:\\Documents and Settings\\All Users\\Desktop\\"+rs.getString(2);
	 }
	File f=new File(fileName);
	System.out.println("\nFile is created........ ..........................."+fileName);

	    
	    OutputStream out1=new FileOutputStream(f);
	    byte buf[]=new byte[1024];
	    int len;
	    while((len=in.read(buf))>0)
	    out1.write(buf,0,len);
	    out1.close();
	    in.close();
	    System.out.println("\nFile is created........ ..........................."+fileName);
	    return fileName;
	}catch(Exception ex){
		System.out.println(ex);
	}	
	finally{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	return null;

}// End of Download File

public static boolean validAction(List parm)throws Exception{
	Connection con=null;
	System.out.println("haiiiii 1");
	boolean  rs=false;
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		System.out.println("haiiiii 2");
		PreparedStatement ps=con.prepareStatement(VALIDACTION);
		
		System.out.println("haiiiii 3");
		for(int i=0;i<parm.size();i++)
		{
			System.out.println("haiiiii "+i);
			ps.setString(i+1,parm.get(i)+"");
		}
		ResultSet rs1=ps.executeQuery();
		System.out.println("haiiiii 5");
		if(rs1.next()){
			return true;
			
		}
		else return false;
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}

public static List selectUserRequest(String status)throws Exception{
	Connection con=null;
	List list=new ArrayList();
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(SELECTUSERREQESTLIST);
		ps.setString(1, status);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Map map=new HashMap();
			map.put("serverName",rs.getString(2));
			map.put("userName",rs.getString(3));
			map.put("status",rs.getString(4));
			list.add(map);
		}
	return list;
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}// End of Update Server Status

public static boolean insertUserRequest(List params)throws Exception{
	Connection con=null;
		try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(INSERTUSERREQEST);
		for(int i=0;i<params.size();i++)
		ps.setString(i+1, params.get(i)+"");
		int update=ps.executeUpdate();
		
		if(update>0)
		{
			return true;
		}
		else
			return false;
	
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}// End of inser user reqest method

public static boolean deleteUserRequest(String serverName )throws Exception{
	Connection con=null;
	boolean  rs=false;
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(DELETEUSERREQEST);
			ps.setString(1,serverName);
		
		rs=ps.execute();
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}
return rs;
}


public static List selectUser(String userName)throws Exception{
	Connection con=null;
	List list=new ArrayList();
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(SELECTUSER);
		ps.setString(1, userName);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			list.add(rs.getString(4));
			list.add(rs.getString(5));
			list.add(rs.getString(6));
			list.add(rs.getString(7));
			list.add(rs.getString(8));
			
		}
	return list;
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}

public static String checkAnswer(String userName,String question,String answer)throws Exception{
	Connection con=null;
	List list=new ArrayList();
	try{
		Class.forName(DRIVERNAME);
		con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
		PreparedStatement ps=con.prepareStatement(CHECKANSWER);
		ps.setString(1, userName);
		ps.setString(2, question);
		ps.setString(3, answer);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			return rs.getString("token");
		}
	return null;
	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			con.close();	
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}

}



} // End of DBHandler.java
