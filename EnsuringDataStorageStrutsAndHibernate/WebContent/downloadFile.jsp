<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
 
<body>
<h1>Struts 2 download file example</h1>
 
<s:url id="fileDownload" namespace="/" action="download" ></s:url>
 
<h4>Download file - <s:a href="%{fileDownload}">fileABC.txt</s:a>
</h4>
 
</body>
</html>