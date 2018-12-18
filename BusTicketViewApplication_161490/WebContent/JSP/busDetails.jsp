<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
th {
	color: grey;
	font-size: 16pt;
}
</style>
</head>
<body>
<center>
<h1 style="color:#0066CC">
Bus Ticket View Application
</h1><br>
<h1>Bus booking List</h1>

<table border=1>
	<tr>
		<th bgcolor="bisque">Bus Id</th>
		<th bgcolor="bisque">Bus Travel Name</th>
		<th bgcolor="bisque">Source</th>
		<th bgcolor="bisque">Destination</th>
		<th bgcolor="bisque">Seats Availability</th>
		
	</tr>
	<c:forEach var="busList" items="${list}">
		<tr>
			<td>${busList.busId}</td>
			<td>${busList.busTravelName}</td>
			<td>${busList.source}</td>
			<td>${busList.destination}</td>
			<td>${busList.availableSeats}</td>
			
		</tr>
	</c:forEach>
	<tr>
			<td colspan="5" align="center"><a href="showHomePage.obj.obj">Click
			Here To Go to Home</a></td>
		</tr>
</table>
</center>
</body>
</html>