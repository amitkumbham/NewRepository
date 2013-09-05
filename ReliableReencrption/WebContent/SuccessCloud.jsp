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
<jsp:include page="AdminServices.jsp"/>
</div>

<!-- content div -->
<div id="content">
<br></br>

<p style='position:relative;font-size:25px;top:300px;color:red;font-weight:bold;'>Sit Hosted Successfully</p>
	
		</div>
	
	</div>

<!-- footer div -->

<jsp:include page="Footer.html"/>

</div><!-- end of main div -->

</body>
</html>