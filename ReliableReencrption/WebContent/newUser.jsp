<html>
<head>

<script type="text/javascript">
function validate(f1)
{
	
	
	var user=f1.user.value;
	var pwd=f1.pwd.value;
	var phno=f1.phno.value;
	var email=f1.email.value;
	var usertype=f1.utype.value;

	//------------------------------------------------------------------------------
	

	//------------------------------------------------------------------------------
	if(user=="")
	{
		alert("please enter login name");
		f1.user.focus();
		return false;
	}

	//------------------------------------------------------------------------------
	if(pwd=="")
	{
		alert("please enter password");
		f1.pwd.focus();
		return false;
	}
	//------------------------------------------------------------------------------
	
	if(phno=="")
	{
		alert("please enter phone number");
		f1.phno.focus();
		return false;
	}
	if(isNaN(phno))
	{
		alert("phone number must be numeric");
		f1.phno.focus();
		return false;
	}
	
	
	//------------------------------------------------------------------------------
	if(email=="")
	{
		alert("please enter mail id");
		f1.email.focus();
		return false;
	}
	//------------------------------------------------------------------------------
	if(usertype=="")
	{
		alert("please select usertype");
		f1.utype.focus();
		return false;
	}
	
	
	return true;
}
</script>	


	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
</head>


<body>
<!-- main div tag -->
<div id="container">

<!-- heading div tag -->
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div tag -->
<div id="menu">

</div>

<!-- body div tag -->
<div id="content">



<!-- <div style="position: absolute; left: 205px; top: 200px;"><img src="images/registration.jpg"  width="1033" height="800"/></div><!-- image div tag -->
<br></br>
<div style="position: absolute; left: 540px; top: 340px;"><!-- heading div tag -->
<span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">REGISTRATION</span>
</div>

<div style="position: absolute; left: 500px; top: 380px;"><!-- form page related div tag -->
<form name=form1 method=get action=Controller onsubmit="return validate(this);">
<table align="center">
<td>
<input type=hidden name=pageInfo value=userInfo></input>
<table>


<tr><td>USER NAME:</td><td><input type=text name=user></input></td></tr>
<tr><td>PASSWORD:</td><td><input type=password name=pwd></input></td></tr>
<tr><td>PHONE NUMBER:</td><td><input type=text name=phno></input></td></tr>
<tr><td>EMAIL ID:</td><td><input type=text name=email></input></td></tr>


<tr><td>USERTYPE:</td><td><select name='utype'>
<option value=''>--Select--</option>
  <option value='dataowner'>DataOwner</option>
  <option value='user'>User</option>
  
</select></td></tr>

<tr><td colspan='2'><center><input type=submit value=submit></input></center></td></tr>
</table>
</td>
</tr>
</table>

</form>
</div>
</div>

<!-- footer div tag -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div>
</body>
</html>