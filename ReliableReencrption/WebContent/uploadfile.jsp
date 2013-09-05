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
<div style="position: absolute; left: 530px; top: 400px;"><!-- heading div tag -->
<span style="font-weight: bold; color: BLUE;font-size: 20px;font-family: Verdana;">FILE UPLOAD</span>
</div>

	<div style="position: absolute; left: 450px; top: 450px;text-align : justify;text-transform : capitalize;font-family: bold;font-size:11pt;">
	<form action='Controller' method='get'>
	<input type=hidden name=pageInfo value=fileupload></input>
		<table>
			<tr><td>FILE NAME</td><td><input type='text' name='fname'/></td></tr>
			<tr><td>DOWNLOAD COST</td><td><input type='text' name='downcost'/></td></tr>
			<tr><td>RE-DOWNLOAD COST</td><td><input type='text' name='rdcost'/></td></tr>
			<tr><td>FILE</td><td><input type='file' name='ufile'/></td></tr>
			<TR></TR>
			<tr><td colspan='2'><cneter><input type='submit' name='upload' value='Upload'/></cneter></td></tr>
		</table>
		</form>
			
	</div>
</div>

<!-- footer div -->

<jsp:include page="Footer.html"/>

</div><!-- end of main div -->

</body>
</html>