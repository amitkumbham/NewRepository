<%@page import='java.util.*' %>
<html>

<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">
function validate(f1)
{
	
	
	var user=f1.key.value;
	var u=f1.val.value;
	
	//------------------------------------------------------------------------------
	

	//------------------------------------------------------------------------------
	if(user=="")
	{
		alert("please enter Decrypted key");
		f1.key.focus();
		return false;
	}
	if(user.length<6)
	{
		alert("please enter displayed Decryption key");
		f1.key.focus();
		return false;
	}
	if(u!=user)
	{
		alert("please enter correct Decryption key");
		f1.key.focus();
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
<jsp:include page="UserServices.jsp"/>		
</div>

<!-- content div -->
<div id="content">

<div style="position: absolute; left: 580px; top: 350px;"><span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">DOWNLOAD FILE</span></div>

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

<tr><td>
<%Random rand = new Random();
int key = rand.nextInt(900000) + 100000; %>
</td></tr>
<tr><td>Decryption Key:</td><td><%=key %></input></td></tr>
<tr><td>Key</td><td><input type=text name="key"></input></td></tr>


</select></td></tr>
<tr><td><div style="position: absolute; left: 90px; top: 90px;"><input type=submit value=Download></input></div></td></tr>
<input type=hidden name=pageInfo value=download></input>
<input type=hidden name=val value=<%=key%>></input>

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
