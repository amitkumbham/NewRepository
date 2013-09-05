<html>

<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
	
	
	<script type="text/javascript">
function validate(f1)
{
	
	var user=f1.username.value;
	var pwd=f1.password.value;
	

	//------------------------------------------------------------------------------
	if(user=="")
	{
		alert("please enter username name");
		f1.username.focus();
		return false;
	}
	
	if(!isNaN(user))
	{
		alert("user name must be alphabate");
		f1.username.focus();
		return false;
	}

	//------------------------------------------------------------------------------
	if(pwd=="")
	{
		alert("please enter password");
		f1.password.focus();
		return false;
	}
		
	return true;
}
</script>
	
	
</head>

<body>

<!-- main div start -->
<div id="container">

<!-- header div tag -->
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div -->
<div id="menu">
<jsp:include page="Services.jsp"/>		
</div>

<!-- content div -->
<div id="content">

<div style="position: absolute; left: 580px; top: 350px;"><span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">WELCOME TO DATA OWNER LOGIN</span></div>

<div style="position: absolute; left: 450px; top: 400px;"><img src="images/login.jpg"  width="600" height="300"/>

	
</div>

<form method=get action=Controller onsubmit="return validate(this);">
<br></br><br></br>
<h3> </h3>
<div style="position: absolute; left: 600px; top: 450px;">
<table align="center">
<tr><td></td></tr>

<td>

<table>
<tr>
<td><a href=Controller?pageInfo=createUserPage>New User Registration</a></td></tr>
<tr><td>

</td></tr>
<tr><td>UserName:</td><td><input type=text name="username"></input></td></tr>
<tr><td>PassWord:</td><td><input type=password name="password"></input></td></tr>


</select></td></tr>
<tr><td><div style="position: absolute; left: 90px; top: 90px;"><input type=submit value=submit></input></div></td></tr>
<input type=hidden name=pageInfo value=loginPage></input>
<input type=hidden name=role value=dataowner></input>
</table>
</td>
</tr>
</table>
</div>
</form>
</div><!-- end of content div -->

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->
</body>

</html>
