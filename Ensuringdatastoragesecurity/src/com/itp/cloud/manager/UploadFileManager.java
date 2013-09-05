package com.itp.cloud.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
 * Servlet implementation class UploadFileManager
 */
public class UploadFileManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("userName");
		String token=request.getParameter("token");
		String serverName=request.getParameter("serverName");
		String fileName=request.getParameter("fileName");
		PrintWriter out=response.getWriter();
		List list=new ArrayList();
		list.add(userName);
		list.add(token);
		try {
			boolean validAction=DbHandler.validAction(list);
			if(validAction)
			{
				list=new ArrayList();
				boolean updated=DbHandler.uploadFile(serverName, fileName);
				System.out.println(updated);
				if(updated)
				{
					RequestDispatcher rd=request.getRequestDispatcher("Controller?pageInfo=serverDetailsDisplay&serverName="+serverName);
					rd.forward(request, response);
					
				}
				else
				{
					out.println("some error occur please try again");
				}
			}
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
