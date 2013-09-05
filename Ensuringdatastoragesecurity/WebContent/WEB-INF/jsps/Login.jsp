
<html>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">Login Page</font></h1>
<form action="Controller" method="get">
<input type="hidden" name="pageInfo" value="login"></input> 

<table width="100%" >
<tr></tr>
<tr>
<td width="50%" align="center">
<table border="2" width="60%">
<tr>
<td>userName:</td>
<td>
<input type="text" name="userName"></input></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>userType</td>
<td><select name="userType" >
<option value="service provider">service provider</option>
<option value="user">user</option>


</select></td>
</tr>
<tr></tr>
<tr>
<td></td>
<br></br>
<td><input type="submit" value="submit" />
<input type="reset" value="cancel"></input></td>
</tr></table>
<br></br>
<br></br>
<a href="Controller?pageInfo=UserRegistrationPage"><font size="4">UserRegistration</font></a>

<td width="50%">
<table border="1">
<tr>
<th> Project Description 
</th>
</tr>
<tr>
<td>
Ensuring data storage security in cloud computing will provide security for the user databases and it provides the quality of service.
</td>
</tr>
</table>

</td>
</tr>

</body>
</html>