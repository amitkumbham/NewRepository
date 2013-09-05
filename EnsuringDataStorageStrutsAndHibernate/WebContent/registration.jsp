<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<title>
UserRegistration
</title>
</head>
<center>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">user registration</font></h1>
<form action="userRegistration" method="get">

<table>
<tr>
<td>userName:</td>
<td>
<input type="text" name="username"></input></td>
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
<td><input type="text" name="emailid"/></td>
</tr>

<tr>
<td>Phone Number</td>
<td><input type="text" name="phonenumber"/></td>
</tr>

<tr>
<td>Security Question</td>
<td><select name="securityquestion">
<option value="name?">what is your name?</option>
<option value="petname?">what is your pet name? </option>
<option value="firstteacher?">who is your first teacher?</option>
</select></td>
</tr>

<tr>
<td>SecurityAnswer</td>
<td><input type="text" name="securityanswer"/></td>
</tr>
 <tr>
<td>userType</td>
<td><select name="usertype" >
<option value="thirdParty">Third Party</option>
<option value="user">user</option>

</select></td>
</tr>


<tr>
<td><input type="submit" value="submit" />
<input type="reset" value="cancel"/></td>
</tr>
</table>
</form>
</body>
</center>
</html>