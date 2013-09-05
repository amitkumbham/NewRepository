<jsp:include page="Services\\Services.jsp"></jsp:include>
<%@page import="java.util.List"%>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%><td>
<%
List list=DbHandler.selectServerList("true");
if(list.size()==0)
{
	out.println("No Servers are present");
	%>
	<a href="">request for server</a>
	
	<%
}
else
{
	
	%>
	<table border="2" align="center">
	<%for(int i=0;i<list.size();i++){ %>
	<tr>
	<td>
	<a href="Controller?pageInfo=serverDetailsDisplay&serverName=<%= list.get(i) %>" ><%= list.get(i) %></a>
	</td>
	</tr>
	<%} %>
	</table>
	<%
}

%>                



</td>