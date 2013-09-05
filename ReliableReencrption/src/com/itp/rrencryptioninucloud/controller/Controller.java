package com.itp.rrencryptioninucloud.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itp.rrencryptioninucloud.bean.User;
import com.itp.rrencryptioninucloud.dbHandler.DbHandler;
import com.itp.rrencryptioninucloud.manager.LoginHandler;
import com.itp.rrencryptioninucloud.manager.UserHandler;
import com.itp.rrencryptioninucloud.manager.UserManager;


/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList al;
	ServletContext sc=null;
	HttpSession session=null;
	
	 private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 50 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;

	  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("enter into doGet(-,-)");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String pageInfo=request.getParameter("pageInfo");
		
		System.out.println("The pageInfo value--"+pageInfo);
		
		//HttpSession session=null;
		ServletContext sc=getServletContext();
		
		if(pageInfo.equalsIgnoreCase("loginPage")){
			String username=request.getParameter("username");
		    String password=request.getParameter("password");
		    String role=request.getParameter("role");
		  System.out.println("the username is-->"+username);  
		    session = request.getSession(true);
		    // Set some attribute values to the session
		    // In this case user and password from the request and client
		    session.setAttribute("username", username);
		    session.setAttribute("password", password);

		  //getting the session         
		  //  session = request.getSession();
		  //setting the attribute customers to the customers object         
		    //session.setAttribute("username", username); 
		   
		    //create servletcontext attribute
		    sc.setAttribute("uname", username);
		    
		    if(role.equals("admin")){
		    LoginHandler login=new LoginHandler();
		    try{
		    boolean valid=login.isValid(username,password);
		    if(valid){  
		    RequestDispatcher rd=request.getRequestDispatcher("AdminPage.jsp");
			rd.forward(request,response);
		    }
		    else{
		    	RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
				rd.forward(request,response);
		    }
		    }catch(Exception e){
		    	out.println(e);
		    }
		}
		    
		    
		    else if(role.equals("user")){
		    	UserHandler login=new UserHandler();
		    	try{
				    boolean valid=login.isValid(username,password,role);
				    if(valid){  
				    	RequestDispatcher rd=request.getRequestDispatcher("UserPage.jsp");
						rd.forward(request,response);

				    }
				    else{
				    	RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
						rd.forward(request,response);
				    }
				    }catch(Exception e){
				    	out.println(e);
				    }
			   				    
			    
		    }
		    
		    
		    else if(role.equals("dataowner")){
		    	UserHandler login=new UserHandler();
		    	try{
				    boolean valid=login.isValid(username,password,role);
				    if(valid){  
				    	RequestDispatcher rd=request.getRequestDispatcher("DataOwnerPage.jsp");
						rd.forward(request,response);

				    }
				    else{
				    	RequestDispatcher rd=request.getRequestDispatcher("DataOwnerLogin.jsp");
						rd.forward(request,response);
				    }
				    }catch(Exception e){
				    	out.println(e);
				    }
			   				    
			    
		    }
		    
		}//role condition
		
         
		else if(pageInfo.equals("createUserPage")){
			RequestDispatcher rd=request.getRequestDispatcher("newUser.jsp");
			rd.forward(request,response);
		}
		
		//insert the new user data into database
		else if(pageInfo.equals("userInfo")){
			String username=request.getParameter("user");
			String password=request.getParameter("pwd");
			String phno=request.getParameter("phno");
			String emailid=request.getParameter("email");
			String usertype=request.getParameter("utype");
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPhno(phno);
			user.setEmailid(emailid);
			user.setUsertype(usertype);
			
			UserManager u=new UserManager(user);
			
			try {
				boolean valid=u.createUser(user);
				if(valid){
			RequestDispatcher rd=request.getRequestDispatcher("userDetails.jsp");
			rd.forward(request,response);
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher("existUser.jsp");
					rd.forward(request,response);
				}
			} catch (Exception e) {
				RequestDispatcher rd=request.getRequestDispatcher("existUser.jsp");
				rd.forward(request,response);
			}
		}
		
		
		
		
		//user profile modification
		else if(pageInfo.equals("profilemodi")){
			String un=(String)session.getAttribute("username");
			System.out.println("The user name is----"+un);
			User user=new User();
			try
			{
			user=DbHandler.isModifyUser(un);
			System.out.println("the user object data in contorller---->"+user);
			request.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("ModifyUserProfile.jsp");
			rd.forward(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//else if
		
		//user profile modified data inserted into data base
		else if(pageInfo.equals("userModInfo")){
			
			
			
			System.out.println("enter into user modify condition---");
			//read the form data form ModifyUserProfile.jsp page
			String username=request.getParameter("user");
			String password=request.getParameter("pwd");
			
			String phno=request.getParameter("phno");
			String emailid=request.getParameter("email");
			
			String country=request.getParameter("country");
			User user=new User();
			
			user.setUsername(username);
			user.setPassword(password);
			user.setPhno(phno);
			user.setEmailid(emailid);
			user.setUsertype(country);
			
			UserManager u=new UserManager(user);
			
			try {
				System.out.println("Enter into try block of usermanager");
				boolean valid=u.updateUserProfile(user);
				if(valid){
			RequestDispatcher rd=request.getRequestDispatcher("ModifyUserDetails.jsp");
			rd.forward(request,response);
				}
				else{
					RequestDispatcher rd=request.getRequestDispatcher("NotModifyUserDetails.jsp");
					rd.forward(request,response);
				}
			} catch (Exception e) {
				RequestDispatcher rd=request.getRequestDispatcher("NotModifyUserDetails.jsp");
				rd.forward(request,response);
			}
			
			
		}//else if
		
		
		//user module prevelages
		
			
		
		
				
		//upload file page
		//user module login page checking
		else if(pageInfo.equals("uploadfile")){
			RequestDispatcher rd=request.getRequestDispatcher("DataOwnerUploadfile.jsp");
			rd.forward(request,response);
		}//else if
		
		//select server
		else if(pageInfo.equals("selectserver")){
			String username=(String)session.getAttribute("username");
			
			ArrayList al=new ArrayList();
			try
			{
				al=DbHandler.getId();
				System.out.println("the list data is ------>"+al);
			}//try
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			//create request attribute
			request.setAttribute("id",al);
			
			RequestDispatcher rd=request.getRequestDispatcher("SelectServer.jsp");
			rd.forward(request,response);
		}//else if
		
		
		//get uploaded files details
		else if(pageInfo.equals("uploadedfiles")){
			ArrayList al=new ArrayList();
			try
			{
				String name=(String)request.getParameter("t2");
				al=DbHandler.getUploadedFiles(name);
				System.out.println("the username is------>"+name);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//create request attributes
			request.setAttribute("ufd",al);
			RequestDispatcher rd=request.getRequestDispatcher("UploadedFiles.jsp");
			rd.forward(request,response);
		}//else if
		
		
		//download file form server
		else if(pageInfo.equals("downloadfile")){
			
			int keyval=Integer.parseInt(request.getParameter("id"));
			
			//create request attributes
			request.setAttribute("key",keyval);
			session.setAttribute("k",keyval);
			RequestDispatcher rd=request.getRequestDispatcher("download.jsp");
			rd.forward(request,response);
		}//else if
		else if(pageInfo.equals("download")){
			String fname=null;
			int key=Integer.parseInt(request.getParameter("key"));
			int val=(Integer)session.getAttribute("k");
			//System.out.println("The key values is------->"+val);
			try
			{
				System.out.println("enter into try block of download link");
				fname=DbHandler.getFileDetails(val);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			//file downloda
			  String filename=fname.substring( fname.lastIndexOf("\\"));
			 // System.out.println("the file name is---->"+key);
			     String filename1= filename.substring(1,filename.length());
			    // System.out.println("the file name is@@@@@"+filename1);
			 //String filename = "student.txt"; 
			  //String filepath = "e:\\"; 
			  response.setContentType("APPLICATION/OCTET-STREAM"); 
			  response.setHeader("Content-Disposition","attachment; filename=\"" + filename1 + "\""); 

			  java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fname );
			  
			  int i; 
			  while ((i=fileInputStream.read()) != -1) {
			    out.write(i); 
			  } 
			  fileInputStream.close(); 
			  out.close(); 			
			
			RequestDispatcher rd=request.getRequestDispatcher("download.jsp");
			rd.forward(request,response);
		}//else if
		
		
			
		
		//user module login page checking
		else if(pageInfo.equals("userLogin")){
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.jsp");
			rd.forward(request,response);
		}//else if
		
		else if(pageInfo.equals("dataownerLogin")){
			RequestDispatcher rd=request.getRequestDispatcher("DataOwnerLogin.jsp");
			rd.forward(request,response);
		}//else if
		
		else if(pageInfo.equals("serverLogin")){
			RequestDispatcher rd=request.getRequestDispatcher("ServerLogin.jsp");
			rd.forward(request,response);
		}//else if
		
		else if(pageInfo.equals("adminLogin")){
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(request,response);
		}//else if
		
		//logout or home page
		else if(pageInfo.equals("sessionPage")){
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}//else if
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
