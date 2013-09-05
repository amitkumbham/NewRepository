
<%@page import="java.util.List"%>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%>


<%@page import="java.util.ArrayList"%>
<jsp:include page="..\\Services\\Services.jsp"></jsp:include>
<td>
<table>
<tr>
<th colspan="1"> Active Servers</th>
<td></td>
<th colspan="1"> In-Active Servers</th>
</tr>
<tr>
<td>
<% List activeList=DbHandler.selectServerList("true");

if(activeList!=null  && activeList.size()>0)
{
	%>
	<table>
	
	
	<%
for(int i=0;i<activeList.size();i++)
{
	%>
	<tr>
	<td><%=activeList.get(i) %></td>
	
	<td><a href="Controller?pageInfo=updateStatusStore&serverName=<%=activeList.get(i) %>&userName=<%=request.getSession(true).getAttribute("userName") %>&status=true">Click to Inactive</a></td>
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
<td></td>
<td>
<% List inactiveList=DbHandler.selectServerList("false");
if(inactiveList!=null  && inactiveList.size()>0)
{
	%>
	<table>
	<%
for(int i=0;i<inactiveList.size();i++)
{
	%>
	<tr>
	<td><%=inactiveList.get(i) %></td>

	<td><a href="Controller?pageInfo=updateStatusStore&serverName=<%=inactiveList.get(i) %>&userName=<%=request.getSession(true).getAttribute("userName") %>&status=false">Click to Active</a></td>
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

</table>

</td>