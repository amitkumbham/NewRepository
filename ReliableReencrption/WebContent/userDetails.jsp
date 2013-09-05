<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="cyan">

<div id="container"><!-- open of main div -->

<!--Heade div tag  -->
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div tag -->
<div id="menu">

</div>

<!-- content div tag -->

<div id="content">

<form method=get action=Controller>
<table align="center">
<tr><td></td></tr>

<td>

<table>

<tr><td>
<h3>User Registered Successfully</h3>
</td></tr>
<tr><td><h3>Click Here for Login</h3> </td></tr>
<tr><td><a href=Controller?pageInfo=sessionPage>login</a></td></tr>
</table>
</td>
</tr>
</table>
</form>
</div><!-- end of content div -->

<!-- footer div tag -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->
</body>

</html>
