package com.itp.cloud.login;

//public class AddServer {

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.cloud.dbhandler.DbHandler;

/**
 * Servlet implementation class LoginManager
 */
public class AddServerManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServerManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addserver=request.getParameter("addServer");
		String filename=request.getParameter("filename");
		String fileid=request.getParameter("fileid");
		String filedata=request.getParameter("filedata");

		String query="create table cloud."+addserver+" ("+fileid+" INT( 100 ) NOT NULL AUTO_INCREMENT PRIMARY KEY ,"+filename+" varchar(100),"+filedata+" blob)";
		System.out.println("query is "+query);
		PrintWriter out=response.getWriter();
		try{
		boolean valid=DbHandler.addServer(query);
		List params=new ArrayList();
		params.add(addserver);
		params.add("true");
		boolean valid1=DbHandler.insertServerStatus(params);
		if(valid)
		{
			response.sendRedirect("Controller?pageInfo=ServerDetails");
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
		doGet(request, response);
	}

}

