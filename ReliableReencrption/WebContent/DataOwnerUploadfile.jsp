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


<p style='position:relative;top:330px;color:red;font-size:20px;font-family:bold;'>Upload File Into Server(only .doc files)</p>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
	<center><p style='position:relative;top:330px;'><table>
		<tr><td><b>File Name</b></td><td><input type=text name=name></input></td></tr>
		<tr><td><b>Browse File</b></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=file name=bfile></input></td></tr>
		<tr height='20'></tr>
		<tr><td colspan='3'><input type='submit' name='upload' value='Upload'></input></td></tr>
	</table></p></center>
	<input type=hidden name=pageInfo value=uploadfile></input>
</form>

<!--<form action="UploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>-->

</div>

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->

</body>
</html>