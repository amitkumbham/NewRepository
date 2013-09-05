<html>
<%@page import="java.util.*,com.itp.rrencryptioninucloud.bean.*" %>
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

<!--<div style="position: absolute; left: 580px; top: 350px;"><span style="font-weight: bold; color: #95F11C;font-size: 20px;font-family: Verdana;">Select Server</span></div>-->

<div style="position: absolute; left: 450px; top: 400px;"><img src="images/login.jpg"  width="600" height="300"/>

	
</div>

<p style="position:relative;top:350px;font-size:15px;"><b></b></p>
<form action="Controller" method="get">
<table border=1 style="position:relative;top:350px;">
				<tr><td><b>Serve Name</b></td><td><select name='t2'>
<option value=''>--SelectServer--</option>	
		<!-- get the data -->
		<%
		ArrayList al=new ArrayList();
		 al=(ArrayList)request.getAttribute("id");
		
		
			for(int i=0;i<al.size();i++)
			{
				User user=(User)al.get(i);
				%>
				
				
				
  <option value=<%=user.getEmailid() %>><%=user.getId()%></option>
    

				
				
				<!--<td><a href="javascript: submitform()">DownLoad Link</a></td>-->
				
					
			<%}al.clear();%>
			</select></td></tr>
			<tr><td colspan=2><input type='submit' name=enablesite value=Submit></input></td>
				<!-- <td><a><input type='submit' name='submit' value'Submit'></input></a></td> -->
				</tr>
			<input type="hidden" name="pageInfo" value="uploadedfiles"></input>
			
			
		</table>
		</form>
</div><!-- end of content div -->

<!-- footer div -->
<div id="footer">
<jsp:include page="Footer.html"/></div>

</div><!-- end of main div -->
</body>

</html>
