<html>
<center>
<body bgcolor="cyan">
<h1> <font size="32" color="orange">delete Server</font></h1>
<form action="Controller" method="get">
<input type="hidden" name="pageInfo" value="deleteserver"></input> 
<tr>
<td>Servername</td>
<td><select name="servername">
<option value="server1">server1</option>
<option value="server2">server2</option>
<option value="server3">server3</option>
<option value="server4">server4</option>
<option value="server5">server5</option>

</select></td>
</tr>
<br></br>
<br></br>
<input type="submit" value="ok" onClick="dis()"/>
<script type="text/javascript">
function dis()
{
alert("Are you sure you want to delete server");
}
</script>
</form>
</body>
</center>
</html>