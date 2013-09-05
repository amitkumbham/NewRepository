
<%@page import="java.util.*,java.sql.*"%>
<%@page import="com.itp.cloud.dbhandler.DbHandler"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%><html>
<title>Server Details</title>
<body>
<table width=100% align="center" border=2>
<tr>
<td></td><td></td>
<td align="right"><a href="javascript: history.go(-1)">Back</a></td>
</tr>
<tr></tr>
<tr>
<%



String serverName=request.getParameter("serverName")+"";
	Connection con=null;
	ResultSetMetaData meta=null;
	List list=new ArrayList();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud","root","");
		String query="select * from "+serverName;
		System.out.println("inside select server");
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println("inside select server");
		ResultSet rs=ps.executeQuery();
		System.out.println("inside select server");
		 meta=(ResultSetMetaData)rs.getMetaData();
		System.out.println("inside select server");
		String firstCol=meta.getColumnName(1);
		String  secondColumn=meta.getColumnName(2);
		String Thirdcolumn=meta.getColumnName(3);
		System.out.println(firstCol+"   "+secondColumn+"  "+Thirdcolumn);
		while(rs.next())
		{
			Map  map=new HashMap();
			map.put(firstCol, rs.getString(1));
			System.out.println(rs.getString(1));
			map.put(secondColumn, rs.getString(2));
			System.out.println(rs.getString(2));
			map.put(Thirdcolumn, rs.getBinaryStream(3));
			list.add(map);
		}

	}
	catch(Exception ex){
		throw ex;
	}
	finally{
		if(con!=null)
		{
			try{
			}catch(Exception ex)
			{
				throw ex;
			}
		}
	}




System.out.println("data in list obj is   "+list);

if(list!=null && list.size()>0)
{
	System.out.println("inside of if block");
	Map map=(Map)list.get(0);
	System.out.println("data in map obj  "+map);
	List list1=new ArrayList();
	out.println("<tr>");
	int i=1;
	for(Object object  : map.keySet())
	{
		
		list1.add(object);
		
		if(i<4)
		{%>
		<th align="center">
		<%= meta.getColumnName(i) %>
		</th>
	<% }
	i++;}	
	%>
	</tr>
	<%
	for(int ii=0;ii<list.size();ii++)
	{
		
	map=(Map)list.get(ii);
	System.out.println("---------------------------------------------------------------------------");
	System.out.println("map obj data    "+map);
	%>
<tr>
<td align="center">
<%= map.get(list1.get(0)) %>
</td>
<td align="center">
<%= map.get(list1.get(1)) %>
</td>
<td align="center">
<a href="Controller?pageInfo=DownloadManager&serverName=<%= request.getParameter("serverName")%>&columnName=<%=list1.get(0) %>&id=<%=map.get(list1.get(0)) %>">click here to download</a>
</td>
</tr>		
		
		<%
	}
}

else
{
	out.println("No Data is Present");
}%>
</table>


</body>
</html>