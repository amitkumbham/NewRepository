<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
 
<body>
    <h2>Howdy, <s:property value="username" />...!</h2>
    
    <table width="100%" border=2 height="100%">
<tr>
<td width=30%>
<table>
<tr>
<td>
<s:a href="upload1">File Upload</s:a>
</td>
</tr>
<tr>
<td>
<s:a href="download1">File download</s:a>
</td>
</tr>
<tr>
<td>
<s:a href="active">Active and Inactive server</s:a>
</td>
</tr>

<tr>
<td>
</td>
</tr>

<tr>
<td>
<a href="Controller?pageInfo=logout"/><font size="3">LogOut</font></a><br></br>
</td>
</tr>


</table>
</td>


<td width=80%>

<h1>HomePage</h1>
<body bgcolor="cyan">
<font size="20" color="blue">Welcome to Cloud Computing</font>
</td>
</tr>
</table>
    
    
</body>
</html>