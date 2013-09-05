<!DOCTYPE html>

<%@page import="com.itp.rrencryptioninucloud.bean.UploadFilesDetails"%><html>
<%@page import="java.util.*,com.itp.rrencryptioninucloud.bean.*" %>
<head>
	<!-- Include css file  -->
	<link href="css/MyFileCss.css" rel="stylesheet" type="text/css" />
	
	<!--<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
	width:100%;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>-->
<style type="text/css">

	<style>
        #table1 { height:75px;position:relative;top:450px;padding:0px;table-layout:fixed;width:60%;  }
        #table1 td { width:150px; border:1px solid black; text-align: center;font-size:15px; }
        #table1 th { color:white;background-color:green;height:60px;font-size:15px; }
    </style>

</style>
	
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

		<br></br><br></br><br></br><br></br>
<!-- <form name="myform" action="Controller" method="get"> -->
<table id="table1">
			<tr><th>FILEID</th><th>FILE NAME</th><th>OWNER NAME</th><th>DOWNLOAD FILE</th></tr>		
		<!-- get the data -->
		<%
		
		ArrayList al=(ArrayList)request.getAttribute("ufd");
		
			for(int i=0;i<al.size();i++)
			{
				UploadFilesDetails ufd=(UploadFilesDetails)al.get(i);
				%>
				
				<tr>
				<td><%=ufd.getId()%></td>
				<td><%=ufd.getFilename()%></td>
				<td><%=ufd.getOwnername()%></td>
				
				<!--<td><a href="javascript: submitform()">DownLoad Link</a></td>-->
				<td><a href="Controller?id=<%=ufd.getKeyvalue()%>&pageInfo=downloadfile">DownLoad Link</a></td>
				<!-- <td><a><input type='submit' name='submit' value'Submit'></input></a></td> -->
				</tr>
				
			<%}al.clear();%>
			<!--<input type="hidden" name="pageInfo" value="datadisp"></input>-->
			
		</table>
		<!--</form>-->
		
</div>

<!-- footer div -->

<jsp:include page="Footer.html"/>

</div><!-- end of main div -->

</body>
</html>