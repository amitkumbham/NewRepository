package com.itp.rrencryptioninucloud.manager;
// Import required java libraries
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sun.misc.Cleaner;

import com.itp.rrencryptioninucloud.dbHandler.DbHandler;

public class UploadServlet extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 50 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

   public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload"); 
      System.out.println("enter into init()"+filePath);
   }
   public void doPost(HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
	   
	   System.out.println("enter into dopost()---");
	   
	 //read form data
       String sitename=request.getParameter("name");
       String filepath=request.getParameter("bfile");
       System.out.println("name----"+sitename);
       System.out.println("path---"+filepath);
	   
      // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
      response.setContentType("text/html");
      java.io.PrintWriter out = response.getWriter( );
      if( !isMultipart ){
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
      }
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try{ 
      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);
	
      // Process the uploaded file items
      Iterator i = fileItems.iterator();

      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet upload</title>");  
      out.println("</head>");
      out.println("<body>");
      while ( i.hasNext () ) 
      {
         FileItem fi = (FileItem)i.next();
         if ( !fi.isFormField () )	
         {
            // Get the uploaded file parameters
            String fieldName = fi.getFieldName();
            String fileName = fi.getName();
            String contentType = fi.getContentType();
            //String v=fi.getString();
            System.out.println("the file path=====>>"+filePath + fileName.substring( fileName.lastIndexOf("\\")));
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ){
               file = new File( filePath + 
               fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
               file = new File( filePath + 
               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            fi.write( file ) ;
            
            //file to insert into database also
          HttpSession session = request.getSession(false);
            String username=(String)session.getAttribute("username");
            String filename=fileName.substring( fileName.lastIndexOf("\\"));
            String filename1=filename.replace(".html","");
            String filename2=filename1.replace("\\","");
            System.out.println("the file name after modifying======>>>"+filename2);
            String storepath=filePath + fileName.substring( fileName.lastIndexOf("\\"));
            
            File file=new File(fileName);
            FileInputStream is = new FileInputStream(file);
            
            /*System.out.println("the file name is----->>>"+fileName.substring( fileName.lastIndexOf("\\")));
            System.out.println("the username is======>>>"+username);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            PreparedStatement ps = con.prepareStatement("INSERT INTO test VALUES(?,?)");
     
            ps.setString(1,filePath + fileName.substring( fileName.lastIndexOf("\\")));
              ps.setBinaryStream(2,is,is.available());
     
              ps.executeUpdate();*/
            
            Random rand = new Random();
            int key = rand.nextInt(900000) + 100000;
            //System.out.println(n);
   
            //call dbhandler method
              boolean val=DbHandler.uploadFile(username, filename2, storepath,file,key);
            if(val)
            {
            	//out.println("Uploaded Filename: " + fileName + "<br>");
            	RequestDispatcher rd=request.getRequestDispatcher("DataOwnerUploadfile.jsp");
            	rd.forward(request,response);
            }//if
         }//if
      }//while 
      out.println("</body>");
      out.println("</html>");
   }catch(Exception ex) {
       System.out.println(ex);
   }
   }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
   } 
}
