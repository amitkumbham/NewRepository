<!DOCTYPE html>
<html>

<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- main div start -->
<div id="container">

<!-- header div tag -->

<h1><jsp:include page="header.html"/></h1>

<!-- options div -->
<div id="menu">

</div>

<!-- content div -->
<div id="content">
	<form action=Controller method='get'>
	<table style='position:relative;top:300px;'><tr><td><b>Select Your CSP</b></td><td><select name='service'>
							<option>--Select--</option>
							<option value='csp1'>CSP1</option>
							</select></td></tr>
							<tr height='20'></tr>
							<tr><td colspan=2><input type='submit' value="Submit"></input></td></tr>
							<input type="hidden" name="pageInfo" value="csp1"></input>
							</table>
							</form>
</div>

<!-- footer div -->

<jsp:include page="Footer.html"/>

</div><!-- end of main div -->

</body>
</html>