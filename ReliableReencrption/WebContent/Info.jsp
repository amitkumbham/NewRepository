<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

</div>


<!-- content div -->
<div id="content">

<div style="position: absolute; left: 500px; top: 240px;"><!-- heading div tag -->
<span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">WELCOME TO ACCESS CLOUD SERVICES</span>
</div>

<div style="position: absolute; left: 1100px; top: 230px;"><!-- hyperlink image div tag -->

<a href=Controller?pageInfo=sessionPage><img src="images/logout.jpg"/></a>
</div>

<div style="position: absolute; left: 650px; top: 300px;">

	
	<a class="boldbuttons" href="http://www.roseindia.net/"><span>JavaTutorial</span></a><br></br>
	<a class="boldbuttons" href="http://www.cricket.com/"><span>Cricket</span></a><br></br>
	<a class="boldbuttons" href="www.yupptv.com"><span>News Channels</span></a><br></br>
	<a class="boldbuttons" href="www.education.com/"><span>Education Info</span></a><br></br>
	<a class="boldbuttons" href="http://www.roseindia.net/"><span>JavaTutorial</span></a><br></br>
	<a class="boldbuttons" href="http://www.roseindia.net/"><span>JavaTutorial</span></a><br></br>
	
</div><!-- div tag for hyperlinks -->
</div><!-- end of the content div tag -->

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of the main div tag -->
</body>

</html>
