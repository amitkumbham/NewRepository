
<%@page import="java.util.List"%>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%>
<%@page import="java.util.Map"%><html>
<body>
<tr>
<th colspan="2"> Active Servers</th>
<td></td>

</tr>
<tr>
<td></td><td>
<% List activeList=DbHandler.selectUserRequest("true");
if(activeList!=null  && activeList.size()>0)
{
	%>
	<table border=2>
	
	
	<%
for(int i=0;i<activeList.size();i++)
{
	Map map=(Map)activeList.get(i);
	
	%>
	<tr>
	<td>Server Name</td><td>User Name</td>
	</tr>
	<tr>
	<td><%= map.get("serverName")%></td>
	
	<td><%= map.get("userName") %></td>
	<td><a href="Controller?pageInfo=updateUserRequestStatus&serverName=<%=map.get("serverName") %>&userName=<%=map.get("userName") %>&status=false">Click to Inactive</a></td>
	</tr>
		<%
	}
	%>
	

	</table>
	<%
}
else
{
	out.println("No tables are present to active");
}
%>
</td>
<Br></br>
<th colspan="2"> In-Active Servers</th>
<td>
<% List inactiveList=DbHandler.selectUserRequest("false");
if(inactiveList!=null  && inactiveList.size()>0)
{
	%>
	<table border=2>
	<%
for(int i=0;i<inactiveList.size();i++)
{

	Map map1=(Map)inactiveList.get(i);
	%>
	<tr>
	<td>Server Name</td>
	<td>User Name</td>
	</tr>
	<tr>
	<td><%=map1.get("serverName")%></td>
	
	<td><%= map1.get("userName") %></td>
	<td><a href="Controller?pageInfo=updateUserRequestStatus&serverName=<%=map1.get("serverName") %>&userName=<%=map1.get("userName") %>&status=true">Click to Active</a></td>
	</tr>
		<%
	}
	%>
	

	</table>
	<%
}
else
{
	out.println("No tables are present to active");
}
%>

</td>
</tr>
<tr><th><a href="Controller?pageInfo=logout"/><font size="6" color="orange"><h3>LogOut</h3></font></a><br></br></th></tr>
</table>
</body>
</html>
