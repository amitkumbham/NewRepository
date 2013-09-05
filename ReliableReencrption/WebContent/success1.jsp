

<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="cyan">
<!-- main div start -->
<div id="container">

<!-- header div tag -->
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div -->
<div id="menu">
<jsp:include page="AdminServices.jsp"/>
</div>

<!-- content div -->
<div id="content">

<div style="position: absolute; left: 500px; top: 500px;"><!-- heading div tag -->
<span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">NEW SERVICE DETAILS ARE ADDED SUCCESSFULLY....</span>
</div>

<form  method=get action=Controller >

<table width="500" cellspacing="2">
<tr>
<td><div align="left"></div>
<table width="120" cellspacing="2" cellpadding="2" align="left">

</table>

</td>
</tr>
</table>
</form>
</div><!-- end of content div tag -->

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div tag -->
</body>

</html>
