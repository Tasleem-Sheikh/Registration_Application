<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG IN</title>
</head>
<body>
	<h2>LOGIN HERE</h2>
	<form action="Login" method="post">
		<table>
			<tr>
				<td>EMAIL</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="LOGIN" /></td>
			</tr>
		</table>
		<%
		if (request.getAttribute("error msg") != null) {
			out.println(request.getAttribute("error msg"));
		}
		%>
<%
		if (request.getAttribute("login again") != null) {
			out.println(request.getAttribute("login again"));
		}
		%>


	</form>
</body>
</html>