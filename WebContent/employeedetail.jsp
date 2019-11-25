<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<h2> ${firstName}, </h2><br/>
	<p> ${message} </p><br />
	<h2>Retrieve employees from the database</h2>
	<table>
		<tr>
			<td>First name</td>
			<td>Last name</td>
			<td>Username</td>
			<td>Address</td>
			<td>Contact</td>
		<tr>
			<td>${firstName}</td>
			<td>${lastName}</td>
			<td>${username}</td>
			<td>${address}</td>
			<td>${contact}</td>	
		</tr>
	</table>

</body>
</html>