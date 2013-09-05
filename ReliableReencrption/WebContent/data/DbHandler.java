package com.itp.ensuringdistributedaccountability.dbHandler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.itp.ensuringdistributedaccountability.bean.DataBean;
import com.itp.ensuringdistributedaccountability.bean.DownloadBean;
import com.itp.ensuringdistributedaccountability.bean.DownloadFilesListBean;
import com.itp.ensuringdistributedaccountability.bean.User;
import com.itp.ensuringdistributedaccountability.dbConstants.DbConstants;


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
	}
	
	public static boolean isCreateUser(User user) throws Exception
	{
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(CREATEUSER);
			ps.setString(1,user.getFname());
			ps.setString(2,user.getMname());
			ps.setString(3,user.getLname());
			ps.setString(4,user.getUsername());
			ps.setString(5,user.getPassword());
			ps.setString(6,user.getRepwd());
			ps.setString(7,user.getPhno());
			ps.setString(8,user.getEmailid());
			ps.setString(9,user.getCaddr());
			ps.setString(10,user.getPaddr());
			ps.setString(11,user.getCity());
			ps.setString(12,user.getPin());
			ps.setString(13,user.getState());
			ps.setString(14,user.getCountry());
			ps.setString(15,user.getUsertype());
			System.out.println("create user method--->"+ps);
			int a=ps.executeUpdate();
			if(a>0)
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
	
	//displaying user details method
	public static User isModifyUser(String username) throws Exception
	{
		Connection con=null;
		User user=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(MODIFYUSER);
			ps.setString(1,username);
			
			ResultSet rs=ps.executeQuery();
			
			//process the resultset object
			while(rs.next())
			{
				user=new User();
				user.setFname(rs.getString(1));
				user.setMname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setRepwd(rs.getString(6));
				user.setPhno(rs.getString(7));
				user.setEmailid(rs.getString(8));
				user.setCaddr(rs.getString(9));
				user.setPaddr(rs.getString(10));
				user.setCity(rs.getString(11));
				user.setPin(rs.getString(12));
				user.setState(rs.getString(13));
				user.setCountry(rs.getString(14));
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
			ps.setString(1,user.getFname());
			ps.setString(2,user.getMname());
			ps.setString(3,user.getLname());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getRepwd());
			ps.setString(6,user.getPhno());
			ps.setString(7,user.getEmailid());
			ps.setString(8,user.getCaddr());
			ps.setString(9,user.getPaddr());
			ps.setString(10,user.getCity());
			ps.setString(11,user.getPin());
			ps.setString(12,user.getState());
			ps.setString(13,user.getCountry());
			ps.setString(14,user.getUsername());
			
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
	
	//user module related mthod get the data from data base
	
	public static ArrayList getDataView() throws Exception{
		Connection con=null;
		ArrayList al=new ArrayList();
		StringBuffer buffer;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(GETDATA);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				DataDetailsBean db=new DataDetailsBean();
				db.setServiceID(Integer.parseInt(rs.getString(1)));
				db.setTitle(rs.getString(2));
				db.setDescription(rs.getString(3));
				db.setPrice(Integer.parseInt(rs.getString(4)));
				//db.setUpdatedPrice(Integer.parseInt(rs.getString(5)));
				al.add(db);
			}//while loop
				
			rs.close();
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
		return al;
	}//method close
	
	public static List getDocuments() throws Exception{
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
	}
	
	public static List getDocumentsData(List containFiles) throws Exception{
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
	
	public static String getDocDetails(String documentId) throws Exception{
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
	}
	
	public static String getUsers() throws Exception
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
	}
	
	//admin module insert service into data base
	public static boolean insertService(int sid,String title,String des,int oprice) throws Exception
	{
		Connection con=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(INSERTSERVICE);
			ps.setInt(1,sid);
			ps.setString(2,title);
			ps.setString(3,des);
			ps.setInt(4,oprice);
			
			
			
			int a=ps.executeUpdate();
			if(a>0)
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
	}//method close
	
	
	
	
	//file upload and down load related methods
	
	public static boolean uploadFile(String fname,String dcost,String redcost,String fileName)
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
		String query="insert into fileupload(fname,ownername,uploadtime,dcost,redcost,filename) values(?,?,?,?,?,?)";
		
		
		pstatement=con.prepareStatement(query);
		pstatement.setString(1, fname);
		pstatement.setString(2,"admin");
		
		
		java.sql.Date date=getCurrentDatetime();
		
		Calendar cal = Calendar.getInstance();
		pstatement.setDate(3,new java.sql.Date(cal.getTimeInMillis()));
		pstatement.setString(4,dcost);
		pstatement.setString(5,redcost);
		pstatement.setBinaryStream(6,in);
		System.out.println("the query---->"+pstatement);
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

	
	//generate data time
	public static java.sql.Date getCurrentDatetime() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	//method for to get data 
	
	//displaying user details method
	public static ArrayList getData() throws Exception
	{
		System.out.println("enter into getData()---");
		Connection con=null;
		
		ArrayList al=new ArrayList();
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(DISPDATA);
			
			ResultSet rs=ps.executeQuery();
			System.out.println("the resultset is---->"+rs);
			//process the resultset object
			while(rs.next())
			{
				DataBean db=new DataBean();
				System.out.println("enter into while loop");
				db.setId(rs.getInt(1));
				db.setFname(rs.getString(2));
				db.setOwnername(rs.getString(3));
				
				//convert sql date to util date
				java.sql.Date sqld1=rs.getDate(4);
				java.util.Date ud1=(java.util.Date)sqld1;
				//covert ud1 to string
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-dd-MMM");
				String dob=sdf1.format(ud1);
				
				db.setUploadtime(sqld1);
				db.setDcost(rs.getString(5));
				db.setRedcost(rs.getString(6));
				al.add(db);
			}//while
			System.out.println("the arraylis in method--->"+al);
				return al;
			
			
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
	}//getData(-)
	
//download data to display
	
	public static DataBean downloadDataDisp(int fid) throws Exception
	{
		Connection con=null;
		DataBean db=null;
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(DOWNLOADDATA);
			ps.setInt(1,fid);
			
			ResultSet rs=ps.executeQuery();
			
			//process the resultset object
			while(rs.next())
			{
				db=new DataBean();
				db.setId(rs.getInt(1));
				db.setFname(rs.getString(2));
				db.setOwnername(rs.getString(3));
				db.setPdate(rs.getString(4));
				db.setDcost(rs.getString(5));
				db.setRedcost(rs.getString(6));
			}//while
			
				return db;
			
			
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
	
	
	//insert download file details

	public static boolean insertDownloadFileData(DownloadBean db)
	{
		Connection con=null;
		PreparedStatement ps = null;

		System.out.println("<br>saveFile name  11   ");
		try{

			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			ps=con.prepareStatement(INSERTDDATA);		
		
		ps.setInt(1,db.getFileid());
		ps.setString(2, db.getFilename());
		ps.setString(3, db.getOwnername());
		ps.setString(4,db.getUploaddate());
		ps.setInt(5, db.getDcost());
		ps.setInt(6, db.getRdcost());
		ps.setString(7, db.getCardtype());
		ps.setString(8, db.getCardname());
		ps.setString(9, db.getAccno());
		ps.setString(10, db.getExpirydate());
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  //get current date time with Date()
		  Date date = new Date();
		  System.out.println(dateFormat.format(date));
	 
		ps.setString(11,dateFormat.format(date));
		ps.setString(12, db.getUsername());
		
		System.out.println("the query---->"+ps);
		boolean valid=ps.execute();
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
	
	
	//downloaded files list retrived from database
	public static ArrayList getDownloadFiles(String username) throws Exception
	{
		System.out.println("enter into getDownloadfiles()---");
		Connection con=null;
		
		ArrayList al=new ArrayList();
		try{
			Class.forName(DRIVERNAME);
			con=DriverManager.getConnection(DATABASEURL,USERNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement(DOWNLOADFILESLIST);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			System.out.println("the resultset is---->"+rs);
			//process the resultset object
			while(rs.next())
			{
				
				DownloadFilesListBean dflb=new DownloadFilesListBean();
				System.out.println("enter into while loop");
				dflb.setFileid(rs.getInt(1));
				dflb.setFilename(rs.getString(2));
				dflb.setOwnername(rs.getString(3));
				dflb.setUploaddate(rs.getString(4));
				dflb.setDownloaddate(rs.getString(5));
				dflb.setDcost(rs.getInt(6));
				dflb.setUsername(rs.getString(7));
				al.add(dflb);
			}//while
			System.out.println("the arraylis in method--->"+al);
				return al;
			
			
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
	}//getDownloadFiles()
	
	
}//class
