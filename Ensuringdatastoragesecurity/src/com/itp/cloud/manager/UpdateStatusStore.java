package com.itp.cloud.manager;

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
 * Servlet implementation class UpdateStatusStore
 */
public class UpdateStatusStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serverName=request.getParameter("serverName");
		String userName=request.getParameter("userName");
		String status=request.getParameter("status");
		List params=new ArrayList();
		PrintWriter out=response.getWriter();
		params.add(serverName);
		params.add(userName);
		params.add(status);
		try {
			DbHandler.insertUserRequest(params);
			
			out.println("<td>Success fully done <br> <a href=\"javascript: history.go(-1)\"> click here to go to Previous page</a></td>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
