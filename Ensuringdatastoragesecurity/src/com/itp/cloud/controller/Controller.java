package com.itp.cloud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet  class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageInfo=request.getParameter("pageInfo");
		PrintWriter out=response.getWriter();
		if(pageInfo.equalsIgnoreCase("search"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("SearchManager");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("searchResults"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\search\\SearchResults.jsp");
			rd.forward(request, response);
			
		}
		
		else if(pageInfo.equalsIgnoreCase("login"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("LoginManager");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("loginPage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\Login.jsp");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("UserRegistration"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationManager");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("UserRegistrationPage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\UserRegistration.jsp");
			rd.forward(request, response);
			
		}
		
		else if(pageInfo.equalsIgnoreCase("serverinfo"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("ServerManager");
			rd.forward(request, response);
			
		}
				
		else if(pageInfo.equalsIgnoreCase("success"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\Success.jsp");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("serverdetails"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ServerDetails.jsp");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("viewregistration"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ViewRegistration.jsp");
			rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("AddServerPage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\AddServer.jsp");
			rd.forward(request, response);
		}	
		else if(pageInfo.equalsIgnoreCase("addServer"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("AddServerManager");
			rd.forward(request, response);
		}	
			else if(pageInfo.equalsIgnoreCase("DeleteServerPage"))
			{
				out.println("PageInfo  "+pageInfo);
				RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\DeleteServer.jsp");
				rd.forward(request, response);
			
		}
			else if(pageInfo.equalsIgnoreCase("deleteserver"))
			{
				out.println("PageInfo  "+pageInfo);
				RequestDispatcher rd=request.getRequestDispatcher("DeleteServerManager");
				rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("MKServerPage"))
			{
				out.println("PageInfo  "+pageInfo);
				RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ServerInfo.jsp");
				rd.forward(request, response);
			
		}
		else if(pageInfo.equalsIgnoreCase("serverInfoManager"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ServerDetails.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("serverDetailsDisplay"))
		{
			System.out.println("hellooooooooooooooooooooooooo");
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ServerDetailsDisplay.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("homePage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\Home.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("uploadPage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\UploadFile.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("uploading"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("UploadFileManager");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("ErrorRecoveryPage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ErrorRecovery.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("DownloadManager"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("DownloadManager");
			rd.forward(request, response);
		}
		
		else if(pageInfo.equalsIgnoreCase("downloadPage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\UserServerList.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("requestServerActivePage"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\ServerStatusPages\\ServerActiveInactive.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("updateStatusStore"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateStatusStore");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("userRequests"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\UserRequests.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("updateUserRequestStatus"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateUserRequestManager");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("SecurityQuestion"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\SecurityQuestion.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("checkAnswer"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\CheckAnswer.jsp");
			rd.forward(request, response);
		}
		else if(pageInfo.equalsIgnoreCase("logout"))
		{
			out.println("PageInfo  "+pageInfo);
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF\\jsps\\Login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}

