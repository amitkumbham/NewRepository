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
<jsp:include page="UserServices.jsp"/>
</div>

<!-- content div -->
<div id="content">

<!--<div><span style="font-weight: bold; color: #95F11C;font-size: 30px;font-family: Verdana;"><marquee direction="left" >WELCOME TO <%=(String)request.getParameter("username").toUpperCase()%></marquee></span></div>-->

</div>

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->

</body>
</html>