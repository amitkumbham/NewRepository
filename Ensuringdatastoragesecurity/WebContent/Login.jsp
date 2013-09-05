<html>
<head>

<title>Login</title>
</head>
<center>
<h1> <font size="32" color="orange">Login Page</font></h1>
<form action="Controller" method="get">
<body bgcolor="cyan">
<a href="home.jsp" target="A"></a>
<input type="hidden" name="pageInfo" value="login"></input> 
<table >

<tr>
<td>userName:</td>
<td><input type="text" name="userName"></input></td>
</tr>
<tr><td>
Password:</td>
<td>
<input type="password" name="password"/></td>
</tr>
<tr><td>userType</td>
<td>
<select name="userType">
<option value="admin">service provider</option>
<option value="admin">user</option>
</select></td></tr>
</table>
<input type="submit" value="submit"/>
<input type="reset" value="cancel"/>




</body>
</form>
</center>
</html>