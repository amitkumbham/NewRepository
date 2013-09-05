


<%@page import="java.util.List"%>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%><html>
<head>
<title>server details</title></head>
<center>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">server details</font></h1>
<form action="Controller" method="get">
<input type="hidden" name="pageInfo" value="serverdetails"></input>
<body>
<%
List list=DbHandler.selectServerList("true");
if(list.size()==0)
{
	response.sendRedirect("ServerInfo.jsp");
}
else
{
	
	%>
	<table border="2">
	<%for(int i=0;i<list.size();i++){ %>
	<tr>
	<td>
	<a href="Controller?pageInfo=serverDetailsDisplay&serverName=<%= list.get(i) %>" ><%= list.get(i) %></a>
	</td>
	<td>
	<a href="Controller?pageInfo=deleteServer&serverName=<%= list.get(i) %>">  Click here to Delete</a>
	</td>
	</tr>
	<%} %>
	</table>
	<%
}

%>                
<br>
<br>
<br>
<a href="Controller?pageInfo=AddServerPage"/><font size="6" color="orange">Add a new Server</font></a><br></br>
<a href="Controller?pageInfo=userRequests"/>User Requests</a><br></br>
<a href="Controller?pageInfo=logout"/><font size="6" color="orange"><h3>LogOut</h3></font></a><br></br>


</center>

</body>


</html>