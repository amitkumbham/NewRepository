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
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div -->
<div id="menu">
<jsp:include page="DataOwnerServices.jsp"/>
</div>

<!-- content div -->
<div id="content">

<div style="position: absolute; left: 500px; top: 400px;"><!-- heading div tag -->
<span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;"><%=getServletContext().getAttribute("uname")%>  USER DETAILS ARE SUCCESSFULLY MODIFIED....</span>
</div>

<!--<div style="position: absolute; left: 1100px; top: 230px;"> hyperlink image div tag 

<a href=Controller?pageInfo=sessionPage><img src="images/logout.jpg"/></a>
</div>-->

</div>

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->

</body>
</html>