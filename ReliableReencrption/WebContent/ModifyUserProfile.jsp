<html>
<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
</head>
<script>
function validate(){
	var valid=true;
	var fname=document.form1.fname.value;
	
	if(fname == null || fname ==""){
        alert("Enter Your First Name");
        valid = false;
     }
    
    return valid;
    
	}
	

</script>
<%@ page import="com.itp.rrencryptioninucloud.bean.*" %>
<body>
<!-- main div tag -->
<div id="container">

<!-- heading div tag -->
<div id="header">
<h1><jsp:include page="header.html"/></h1></div>

<!-- options div tag -->
<div id="menu">

</div>

<!-- body div tag -->
<div id="content">
<!--<div style="position: absolute; left: 205px; top: 200px;"><img src="images/registration.jpg"  width="1033" height="800"/></div>--><!-- image div tag -->

<div style="position: absolute; left: 490px; top: 210px;"><span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">WELCOME TO USER PROFILE CHANGE</span></div>


<div style="position: absolute; left: 500px; top: 260px;"><!-- form page related div tag -->
<form name=form1 method=get action=Controller onsubmit="return validate();">
<br></br>

<table align="center">
<tr><td></td></tr>

<td>
<input type=hidden name=pageInfo value=userModInfo></input>
<%
User user=(User)request.getAttribute("user");
 

%>
<table>
<tr><td></td></tr>


<tr><td>USER NAME:</td><td><input type=text name=user value=<%=user.getUsername()%> ></input></td></tr>
<tr><td>PASSWORD:</td><td><input type=password name=pwd value=<%=user.getPassword()%> readonly></input></td></tr>
<tr><td>PHONE NUMBER:</td><td><input type=text name=phno value=<%=user.getPhno()%>></input></td></tr>
<tr><td>EMAIL ID:</td><td><input type=text name=email value=<%=user.getEmailid()%> readonly></input></td></tr>
<tr><td>USER TYPE:</td><td><input type=text name=country value=<%=user.getUsertype()%> readonly></input></td></tr>

<tr><td><input type=submit value=submit></input></td></tr>
</table>
</td>
</tr>
</table>
</form>
</div>
</div>

<!-- footer div tag -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div>
</body>
</html>