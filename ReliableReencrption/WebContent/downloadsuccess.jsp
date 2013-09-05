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
<br></br>
	<p style='float:left'> <a class="boldbuttons" href='index.jsp'>Logout</a></p>
	<p style='position:relative;top:100px;'><b>File is Downloaded Successfully</b><!--<br></br
	<p style='position:relative;top:200px;'><a href="UserPage.jsp">Click here to go to Download page</a></p>
--></div>

<!-- footer div -->

<jsp:include page="Footer.html"/>

</div><!-- end of main div -->

</body>
</html>