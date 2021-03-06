package com.itp.cloud.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.cloud.dbhandler.DbHandler;

/**
 * Servlet implementation class LoginManager
 */
public class RegistrationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		String emailId=request.getParameter("emailId");
		String phonenumber=request.getParameter("phonenumber");
		String securityquestion=request.getParameter("SecurityQuestion");
		String secqurityanswer=request.getParameter("secqurityanswer");
		String Role=request.getParameter("userType");
		String token=request.getParameter("token");
		
		List parm=new ArrayList();
		parm.add(userName);
		parm.add(password);
		
		parm.add(emailId);
		parm.add(phonenumber);
		parm.add(securityquestion);
		parm.add(secqurityanswer);
		parm.add(Role);
		parm.add(token);
		request.setAttribute("list",parm);
		
		
		
		PrintWriter out=response.getWriter();
		try{
		boolean valid=DbHandler.insertUser(parm);
		System.out.println(valid+"  valid");
		if(valid)
		{
			response.sendRedirect("Controller?pageInfo=ViewRegistration");
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
