package com.itp.rrencryptioninucloud.dbHandler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.rrencryptioninucloud.bean.UploadFilesDetails;
import com.itp.rrencryptioninucloud.bean.User;
import com.itp.rrencryptioninucloud.dbConstants.DbConstants;


public class DbHandler implements DbConstants {
	
	
	public static boolean isValidAdmin(String username,String password) throws Exception
	{
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(VALIDADMIN);
			ps.setString(1,username);
			ps.setString(2, password);
		
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
	}
	
	public static boolean isValidUser(String username,String password) throws Exception
	{
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(VALIDUSER);
			ps.setString(1,username);
			ps.setString(2, password);
			
			
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
	}//isValidUser(-)
	
	public static boolean isValidUser(String username,String password,String role) throws Exception
	{
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(VALIDUSER);
			ps.setString(1,username);
			ps.setString(2, password);
			ps.setString(3,role);
			
			
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
	}//isValidUser(-,-,-)
	
	public static boolean isCreateUser(User user)
	{
		System.out.println("enter into iscreateuser()-----");
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(CREATEUSER);
			System.out.println("enter into iscreateuser()-----"+ps);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			
			ps.setString(3,user.getPhno());
			ps.setString(4,user.getEmailid());
			
			ps.setString(5,user.getUsertype());
			System.out.println("create user method--->"+ps);
			int a=ps.executeUpdate();
			if(a>0)
				return true;
			else{
				return false;
			}
			
		}catch(Exception ex){
			//throw ex;
			ex.printStackTrace();
		}
		finally{
			if(con!=null)
			{
				try{
				con.close();	
				}catch(Exception ex)
				{
					//throw ex;
					ex.printStackTrace();
				}
			}
		}
		return false;
	}
	
	//displaying user details method
	public static User isModifyUser(String username) throws Exception
	{
		System.out.println("enter into isModifyUser()");
		Connection con=null;
		User user=null;
		try{
			System.out.println("enter into isModifyUser() try block");
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(MODIFYUSER);
			ps.setString(1,username);
			
			System.out.println("the object data is----->"+ps);
			
			ResultSet rs=ps.executeQuery();
			
			//process the resultset object
			while(rs.next())
			{
				user=new User();
				
				
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhno(rs.getString(5));
				user.setEmailid(rs.getString(4));
				user.setUsertype(rs.getString(6));

				
			}//while
			
				return user;
			
			
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
	}//modifyUser(-)
	
	//modify user deatails
	public static boolean isupdateUserProfile(User user) throws Exception
	{
		System.out.println("enter into isUpdateUserProfile() method");
		Connection con=null;
		try{
			System.out.println("enter into try block of isUpdateUserProfile() method");
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(UPDATEUSERDETAILS);
			
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getPhno());
			ps.setString(4,user.getUsertype());
			ps.setString(5,user.getEmailid());
			
			System.out.println("the prepared statement obj--"+ps);
			
			int a=ps.executeUpdate();
			System.out.println("the value of a is"+a);
			if(a>0)
				return true;
			else{
				return false;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
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
	

	
	/*public static List getDocuments() throws Exception{
		List list=null;
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(DOCUMENTS);
			ResultSet rs = ps.executeQuery();
			list=new ArrayList();
			while(rs.next()){
				list.add(rs.getString(1));
			}
		}catch(Exception e){
			throw e;
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return list;
	}*/
	
	/*public static List getDocumentsData(List containFiles) throws Exception{
		List list=null;
		Connection con=null;
		//List containFiles=(List)request.getSession().getAttribute("list");
		//out.println("<h3>The Terminology contain documents are:</h3>");
		for(int k=0;k<containFiles.size();k++){
			
			//out.println("<h4><a href=Controller?pageInfo=infoPage&file="+containFiles.get(k)+">"+containFiles.get(k)+"</a></h4>");
			
			try{
				// Open the file that is the first 
				// command line parameter
				FileInputStream fstream = new FileInputStream("c:/files/"+containFiles.get(k)+".txt");
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				String pat="Speaker";
				//Read File Line By Line
				while ((strLine = br.readLine()) != null) 	{
					// Print the content on the console
					//System.out.println (strLine);
					//System.out.println ("hello world");
					String s[]=strLine.split(" ");
					//System.out.println (s.length);
					//int i=0;
					for(int i=0;i<s.length;i++)
					{
				
						//System.out.println ("the string is"+s[i]);
						if(s[i].equals("Speaker"))
						{
							list.add(strLine);
						
						}
						
					}
				}
				//Close the input stream
				in.close();
				}catch (Exception e){//Catch exception if any
					System.err.println("Error: " + e.getMessage());
					//System.err.println("Some problem in file");
				}

		}

		return list;
	}
*/	
	/*public static String getDocDetails(String documentId) throws Exception{
	    StringBuffer buffer=null;
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(DOCDETAILS);
			ps.setString(1,documentId);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			buffer =new StringBuffer();
			
		     buffer.append("<table border=1>");
		     
		     while(rs.next()){
		     buffer.append("<tr>");
		     for(int i=1;i<=numberOfColumns;i++){
		    	 buffer.append("<td>"+rs.getString(i) +"</td>");
		     }
		     buffer.append("</tr>");
		     }
		     buffer.append("</table>");
		     
		    				
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
			return buffer.toString();
	}*/
	
	/*public static String getUsers() throws Exception
	{
		Connection con=null;
		StringBuffer buffer=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(GETUSER);
			
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			buffer =new StringBuffer();
			buffer.append("<h3>The visited Users are:</h3>");
		     buffer.append("<table border=1>");
		     buffer.append("<tr>");
		     for(int i=1;i<=numberOfColumns;i++){
		    	 buffer.append("<th>"+rsmd.getColumnName(i) +"</th>");
		    	 System.out.println(rsmd.getColumnName(i)); 
		     }
		     buffer.append("</tr>");
		     while(rs.next()){
		     buffer.append("<tr>");
		     for(int i=1;i<=numberOfColumns;i++){
		    	 buffer.append("<td>"+rs.getString(i) +"</td>");
		     }
		     buffer.append("</tr>");
		     }
		     buffer.append("</table>");
		     buffer.append("<h3><a href=Controller?pageInfo=sessionPage>logout</a></h3>");
			
			
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
		return buffer.toString();
	}*/
	

	
	
	
	
	//file upload and down load related methods
	
	public static boolean uploadFile(String username,String filename,String storepath,File file,int key)
	{
		Connection con=null;
		PreparedStatement ps = null;

		System.out.println("<br>saveFile name  11   ");
		System.out.println("Store path is------>"+storepath);
		try{

			// below code is to handle with the data type BLOB 
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			ps=con.prepareStatement(UPLOADDATA);
			
			//create fileinputstream
			FileInputStream is = new FileInputStream(file);
			
			//set the values to place holders
			ps.setInt(1,key);
			ps.setString(2,username);
			ps.setString(3,filename);
			ps.setString(4,storepath);
			ps.setBinaryStream(5,is,is.available());
			
		
		System.out.println("the query---->"+ps);
		boolean valid=ps.execute();
		if(!valid)
		
			return true;
		
		else
		
			return false;
		
		}
		catch(Exception e)
		{
			//System.out.println(e);
			e.printStackTrace();
			}
		finally{
			if(con!=null)
				try{
				con.close();
				
				}catch(Exception e){System.out.println(e);}
		}
		return false;

	}// End of Upload file function


	
	
	/*//download the file from the database table
	public static String downloadFile(int id)
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
		System.out.println("Select * from fileupload  where id="+id);
		ResultSet rs=st.executeQuery("Select * from fileupload  where id="+"'"+id+"'");
//		System.out.println("Select * from "+serverName+"  where "+columnName+"="+id);
		System.out.println("haiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		String fileName=null;
		 if(rs.next())
		 {
		 in=rs.getBinaryStream(7);
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
*/	
	//get file details
	public static String getFileDetails(int key) throws Exception
	{
		System.out.println("enter into getFileDetails()");
		Connection con=null;
		StringBuffer buffer=null;
		String fname=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(GETFILEDETAILS);
			ps.setInt(1,key);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				fname=rs.getString(1);
			}
			System.out.println("file name is---->"+fname);
			
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
		return fname;
	}//End of the method

	
	//method to get id and username
	public static ArrayList getId() throws Exception
	{
		System.out.println("enter into getId()");
		Connection con=null;
		User user=null;
		ArrayList al=new ArrayList();
		try{
			System.out.println("enter into getId() try block");
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(GETID);
			ps.setString(1,"dataowner");
			
			System.out.println("the query is------>"+ps);
			
			ResultSet rs=ps.executeQuery();
			
			//process the resultset object
			while(rs.next())
			{
				user=new User();
				
				
				user.setId(rs.getInt(1));
				user.setEmailid(rs.getString(2));
				
				al.add(user);
			}//while
			
				return al;
			
			
		}//try
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
	}//getId(-)
	
	//method for to get uploaded file details
	public static ArrayList getUploadedFiles(String username) throws Exception
	{
		System.out.println("enter into getUploadedFiles(-)");
		Connection con=null;
		User user=null;
		ArrayList al=new ArrayList();
		try{
			System.out.println("enter into getUploadedFiles() try block");
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(GETUPLOADEDFILES);
			ps.setString(1,username);
			
			System.out.println("the query is------>"+ps);
			
			ResultSet rs=ps.executeQuery();
			
			//process the resultset object
			while(rs.next())
			{
				UploadFilesDetails ufd=new UploadFilesDetails();
				ufd.setId(rs.getInt(1));
				ufd.setKeyvalue(rs.getInt(2));
				ufd.setOwnername(rs.getString(3));
				ufd.setFilename(rs.getString(4));
				
				al.add(ufd);
			}//while
			
				return al;
			
			
		}//try
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
	}//getId(-)
	
	//generate data time
	public static java.sql.Date getCurrentDatetime() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	


	
}//class
