package com.itp.cloud.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itp.cloud.dbhandler.DbHandler;

/**
 * Servlet implementation class LoginManager
 */
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String userType=request.getParameter("userType");
		System.out.println(userType);
		PrintWriter out=response.getWriter();
		try{
		boolean valid=DbHandler.isValidUser(userName, password,userType);
		System.out.println(valid);
		if(valid)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("userName", userName);
			if(userType.equalsIgnoreCase("service provider")){
			List list= DbHandler.selectServerList("true");
			if(list.size()==0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Controller?pageInfo=MKServerPage");
			rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Controller?pageInfo=serverDetails");
				rd.forward(request,response);
			}
			}
			else  if(userType.equalsIgnoreCase("user")){
				RequestDispatcher rd=request.getRequestDispatcher("Controller?pageInfo=homePage");
				rd.forward(request,response);
			}
			else  if(userType.equalsIgnoreCase("thirdParty")){
				
			}
			{
				
			}
		}
		else
		{
			response.sendRedirect("Controller?pageInfo=LoginPage");
		}
		}catch(Exception ex)
		{
			out.println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
