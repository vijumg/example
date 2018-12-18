<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cg.btva.exception.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1  align="center" style="color:#0066CC">Bus Ticket View Application</h1>
</head>
<body>
	<h2>
		<c:if test="${not empty errorInfo}"><br>
		Exception raised at ${errorInfo.url}<br>
		
		 MESSAGE: ${errorInfo.message}
		</c:if>
	</h2>
</body>
</html>