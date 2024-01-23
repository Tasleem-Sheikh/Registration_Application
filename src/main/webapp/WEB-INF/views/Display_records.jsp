<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Location</th>
			<th>Delete Record</th>
			<th>Update Record</th>
		</tr>


		<%
		ResultSet result = (ResultSet) request.getAttribute("results");

		while (result.next()) {
		%>

		<tr>
			<td>
				<%
				out.println(result.getString(1));
				%>
			</td>
			<td>
				<%
				out.println(result.getString(2));
				%>
			</td>
			<td>
				<%
				out.println(result.getString(3));
				%>
			</td>
			<td>
				<%
				out.println(result.getString(4));
				%>
			</td>
			<td><a href="delete?email=<%out.println(result.getString(3));%>" >DELETE </a></td>
			<td><a
				href="update?email=<%out.println(result.getString(3));%>&location=<%out.println(result.getString(4));%>" >Update </a></td>
		</tr>

		<%
		}
		%>

	</table>

	<%
	if (request.getAttribute("deletemsg") != null) {

		out.println(request.getAttribute("deletemsg"));

	}
	%>
	
	<%
	if (request.getAttribute("update_msg") != null) {

		out.println(request.getAttribute("update_msg"));

	}
	%>

</body>
</html>