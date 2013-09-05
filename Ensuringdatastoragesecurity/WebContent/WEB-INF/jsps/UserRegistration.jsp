<%! int token=new Random().nextInt(12345); %>
<script type="text/javascript">
function dis()
{
	alert("token is"+token);
}
</script>

<%@page import="java.util.Random"%><html>
<head>
<title>
UserRegistration
</title>
</head>
<center>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">user registration</font></h1>
<form action="Controller" method="get">
<input type="hidden" name="pageInfo" value="userRegistration"></input>
<input type="hidden" name="token" value="<%= token%>"></input>
<% System.out.println(token); %>
<table>
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
<td>ConfirmPassword:</td>
<td><input type="password" name="confirmpassword"/></td>
</tr>

<tr>
<td>Email-ID</td>
<td><input type="text" name="emailId"/></td>
</tr>

<tr>
<td>Phone Number</td>
<td><input type="text" name="phonenumber"/></td>
</tr>

<tr>
<td>Security Question</td>
<td><select name="SecurityQuestion">
<option value="what is your name?">what is your name?</option>
<option value="what is your pet name?">what is your pet name? </option>
<option value="who is your first teacher?">who is your first teacher?</option>
</select></td>
</tr>

<tr>
<td>SecurityAnswer</td>
<td><input type="text" name="secqurityanswer"/></td>
</tr>
 <tr>
<td>userType</td>
<td><select name="userType" >
<option value="thirdParty">Third Party</option>
<option value="user">user</option>

</select></td>
</tr>


<tr>
<td><input type="submit" value="submit" onClick="dis()"/>
<input type="reset" value="cancel"/></td>
</tr>
</table>
</form>
</body>
</center>
</html>