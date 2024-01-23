<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h2>Register Here</h2>

<form action="Register" method="post" >
<table>
<tr>
<td>First Name</td>
<td><input type="text" name="firstname" /></td> 
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="lastname" /></td> 
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email" /></td> 
</tr>
<tr>
<td>location </td>
<td><input type="text" name="location" /></td> 
</tr>

<input type="submit" value="register" />
</table>



</form>
<% if(request.getAttribute("success")!=null){
	
	out.println(request.getAttribute("success"));
}


%>



</body>
</html>