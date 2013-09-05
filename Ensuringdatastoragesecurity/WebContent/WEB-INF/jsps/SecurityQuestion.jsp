<jsp:include page="Services\\Services.jsp"></jsp:include>
<td>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%>
<%@page import="java.util.List"%><td>
<table>
<form action="Controller">
<input type="hidden" name="pageInfo" value="checkAnswer"></input>
<tr>
<% 
List list=DbHandler.selectUser(request.getParameter("userName"));
if(list!=null && list.size()==0){
	out.println("no user exist with the Entered user name");
}
else{
%>
<tr>
<td> User Name</td>
<td><input type="text" name="userName" readonly="readonly" value="<%= list.get(0) %>"></input></td>
</tr>

<tr>
<td> Security question</td>
<td><input type="text" name="securityQuestion" readonly="readonly" value="<%= list.get(4) %>"></input></td>
</tr>
<tr>
<td> Answer</td>
<td><input type="text" name="securityAnswer"  ></input></td>
</tr>
<tr>
<td>
</td>
<td><input type="submit" ></input></td>
</tr>
<%
}
%>
</tr>
<tr>
<td><a href="javascript: history.go(-1)"> click here to go to Previous page</a></td>
</tr>
</form>
</table>

</td>