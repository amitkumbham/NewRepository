package com.itp.action1;

import java.io.File;


import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.log4j.Logger;
import com.itp.action1.persistance1.LoginClient;
import com.itp.action1.persistance1.RegistrationBean;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = null;
	//private static final Logger log = Logger.getLogger(Login.class.getName());
	public Login()
	{
		
		//log.info("const");
	}
    private String username;
    private String password;
    
    private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	private InputStream fileInputStream;
	 
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
    public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String execute1() throws Exception {
	    fileInputStream = new FileInputStream(new File("C:\\downloadfile.txt"));
	    return SUCCESS;
	}
	public String execute() 
    {
    	LoginClient lc= new LoginClient();
    	
    	RegistrationBean rb;
    	
    	rb=lc.main1(this.username);
    	
    	String password = rb.getPassword();
    	
    	 
        if ( this.password.equals(password)) {
            return "success";
        } else {
            addActionError(getText("error.login"));
            return "error";
        }
    }

	public String display() {
		return NONE;
	}
	
    public String upload1()
    {
    	System.out.println("upload");
    	
		
		return SUCCESS;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}

