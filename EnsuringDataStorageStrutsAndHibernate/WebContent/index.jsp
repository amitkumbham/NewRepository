<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application </title>
</head>
 
<body>
<h2>Struts 2 - Login Application</h2>
<s:actionerror />
<s:form action="login" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    
    
    
    <s:select label="Choose ID" list="{'amin','user'}" name="myChoice">
    </s:select>
    <s:submit method="execute" key="label.login" align="center" ></s:submit>
  
  
  <s:a href="registration">Sign Up</s:a>
  
</s:form>


</body>
</html>