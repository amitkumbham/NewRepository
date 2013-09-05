package com.itp.cloud.manager;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.cloud.dbhandler.DbHandler;

/**
 * Servlet implementation class DownloadManager
 */
public class DownloadManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serverName=request.getParameter("serverName");
		String columnName=request.getParameter("columnName");
		String id=request.getParameter("id");
		System.out.println(serverName+"  "+columnName+"   "+id);
		String fileName=DbHandler.downloadFile(serverName, columnName, id);
		PrintWriter out=response.getWriter();
		
		if(fileName!=null)
		{
			out.println("Success fully downloaded with file path   " +fileName);
			//out.println("<a href='"+fileName+"' target='_blank'>click to save in some location</a>");
		}
		else
		{
			out.println("there are some errors occurred please try again");
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
