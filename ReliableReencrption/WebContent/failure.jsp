

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

<form  method=get action=Controller >

<table width="500" cellspacing="2">
<tr>
<td><div align="left"></div>
<table width="120" cellspacing="2" cellpadding="2" align="left">
<tr>
<td><input align="left" type="text" value="Added successfully" readonly STYLE="color: black;background-color: cyan;border-color: cyan; border-style: solid;
border-top-width: 0 px; border-right-width: 0 px; border-bottom-width: 0
px; border-left-width: 0 px" size="50"></td>
</tr>
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
