
<head>

<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

	function validate(f1)
	{
		var sid=f1.t1.value;
		var title=f1.t2.value;
		var des=f1.t3.value;
		var oprice=f1.t4.value;
		//var uprice=f1.t5.value;

		//------------------------------------------------------------------------------
		if(sid=="")
		{
			alert("please enter serviceID");
			return false;
		}
		
		if(isNaN(sid))
		{
			alert("serviceid must be an integer");
			return false;
		}
		//------------------------------------------------------------------------------
		if(title=="")
		{
			alert("please enter title");
			return false;
		}
		if(!isNaN(title))
		{
			alert("title name must be alphabate");
			return false;
		}

		//------------------------------------------------------------------------------
		if(des=="")
		{
			alert("please enter description");
			return false;
		}

		//------------------------------------------------------------------------------
		if(oprice=="")
		{
			alert("please enter original price");
			return false;
		}
		if(isNaN(oprice))
		{
			alert("original price must be an integer");
			return false;
		}
		//------------------------------------------------------------------------------
		
		return true;
	}//vaidate(-)

</script>
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

<div style="position: absolute; left: 205px; top: 200px;"><img src="images/registration.jpg"  width="1033" height="800"/></div><!-- image div tag -->

<div style="position: absolute; left: 490px; top: 400px;"><!-- heading div tag -->
<span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">WELCOME TO ADD NEW CLOUD SERVICE</span>
</div>

<div style="position: absolute; left: 580px; top: 450px;">
<form name=form1 method=get action=Controller onsubmit="return validate(this);">

<table align="center">
<tr><td></td></tr>

<td>
<input type=hidden name=pageInfo value=addService></input>
<table>

<tr><td>ServiceID:</td><td><input type=text name=t1></input></td></tr>
<tr><td>Title:</td><td><input type=text name=t2></input></td></tr>
<tr><td>Discription:</td><td><textarea name=t3 rows=7 cols=20></textarea></td></tr>
<tr><td>Price:</td><td><input type=text name=t4></input></td></tr>


<tr><td><input type=submit value=submit></input></td></tr>
</table>
</td>
</tr>
</table>
</form>
</div><!-- form page close div tag -->
</div><!-- end of content div tag -->

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div tag -->
</body>
</html>
