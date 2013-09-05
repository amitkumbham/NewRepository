<%@page import="java.util.*"%>
<html>
<head>
<title>view registration</title>
</head>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">Login Page</font></h1>
<form action="Controller" method="get">
<input type="hidden" name="pageInfo" value="viewregistration"></input> 

<tr>
<th>userName</th>
<th>password</th>
<th>emailId</th>
<th>phonenumber</th>
<th>SecurityQuestion</th>
<th>secqurityanswer</th>
<th>userType</th>
</tr>
<%=(List)request.getAttribute("list")
   
   %>
 <a href="Controller?pageInfo=UpdateUserRegistration">update</a>

</body>
</html>