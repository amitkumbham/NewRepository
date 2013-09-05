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


<p style='position:relative;top:330px;color:red;font-size:20px;font-family:bold;'> WELCOME TO DATA OWNER PAGE</p>

</div>

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->

</body>
</html>