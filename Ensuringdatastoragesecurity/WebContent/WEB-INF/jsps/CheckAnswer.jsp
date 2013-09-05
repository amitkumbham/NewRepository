
<%@page import="com.itp.cloud.dbhandler.DbHandler"%><jsp:include page="Services\\Services.jsp"></jsp:include>

<td align="center">
<% 
String token=DbHandler.checkAnswer(request.getParameter("userName"),request.getParameter("securityQuestion"),request.getParameter("securityAnswer"));
if(token!=null)
{
	out.println("token number is  "+token);
}
else
	out.println("wrong answer please try again");
%>
</td>