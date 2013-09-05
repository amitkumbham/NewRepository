package com.itp.cloud.login;

//public class ServerDetailsManager {

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.cloud.dbhandler.DbHandler;

/**
 * Servlet implementation class LoginManager
 */
public class ServerDetailsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerDetailsManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String userName=request.getParameter("");
		//String password=request.getParameter("");
		PrintWriter out=response.getWriter();
		try{
		boolean valid=DbHandler.isAddServer();
		if(valid)
		{
			response.sendRedirect("Controller?pageInfo=AddServer");
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
