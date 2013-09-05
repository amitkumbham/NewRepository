<jsp:include page="Services\\Services.jsp"></jsp:include>
<%@page import="java.util.List"%>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%><html>
<head>
<title>
UPLOADING
</title>
</head>
<center>
<td>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">UPLOADING OF FILE</font></h1>
<form action="Controller" method="get">
<input type="hidden" name="pageInfo" value="uploading"></input>
<table>
<tr>
<td>userName:</td>
<td>
<input type="text" name="userName"></input></td>
</tr>

<tr>
<td>Please enter your token number</td>
<td>
<input type="text" name="token"></input>
<a href="Controller?pageInfo=ErrorRecoveryPage">forgot token?</a>
</td>

</tr>


<tr>
<td>Select Server</td>
<td><select name="serverName">
<%
List list=DbHandler.selectServerList("true");
if(list!=null && list.size()>0)
{
	for(int i=0;i<list.size();i++)
	{
%>
<option value="<%= list.get(i) %>"><%= list.get(i) %></option>
<%
}
}
%>
</select>
<a href="Controller?pageInfo=requestServerActivePage">request for Active inactive-servers</a>
</td>

</tr>



<tr>
<td>Select File to Upload</td>
<td><input type="file" name="fileName"/></td>
</tr>


<tr>
<td></td>
<td><input type="submit" value="submit"/>
<input type="reset" value="cancel"/></td>
</tr>
</table>
</form>
</body>
</td>
</tr>
</table>

</center>
</html>