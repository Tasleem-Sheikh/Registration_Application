<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> UPDATE RECORD </h2>
<form action="update" method="post" >
<table>
<tr>
<td>Email</td>
<td><input type="email" name="email" value="<%out.println(request.getAttribute("Oldemail")); %> " readonly></td>
</tr>
<tr>
<td>Location</td>
<td><input type="text" name="location"  value="<%out.println(request.getAttribute("oldlocation")); %> "></td>
</tr>


</table>
<tr> <input type="submit" value="UPDATE" ></tr>
</form>

</body>
</html>