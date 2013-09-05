<html>

<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
</head>

<body>

<!-- main div start -->
<div id="container">

<!-- header div tag -->
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div -->
<div id="menu">

</div>

<!-- content div -->
<div id="content">

	<div style="position: absolute; left: 450px; top: 400px;"><img src="images/admin.jpg"  width="600" height="300"/>

</div>

<form method=get action=Controller>
<br></br><br></br>
<h3> </h3>
<!-- this is div tag that is related to table tag -->
<div style="position: absolute; left: 600px; top: 450px;">
<table align="center">
<tr><td></td></tr>

<td>

<table>
<tr>

<tr><td>

</td></tr>
<tr><td>UserName:</td><td><input type=text name="username"></input></td></tr>
<tr><td>PassWord:</td><td><input type=password name="password"></input></td></tr>


</select></td></tr>
<tr><td><div style="position: absolute; left: 90px; top: 90px;"><input type=submit value=submit></div></input></td></tr>
<input type=hidden name=pageInfo value=loginPage></input>
<input type=hidden name=role value=admin></input>
</table>
</td>
</tr>
</table>
</div>
<!-- end of div tag that is related to table tag -->
</form>
</div><!-- end of content div -->

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->
</body>

</html>
