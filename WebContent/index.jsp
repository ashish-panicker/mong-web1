<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>

	<h1>Zip codes</h1>
	
	<table>
		<tr>
			<td>City</td><td>Population</td><td>State</td>
		</tr>
		<c:forEach var="zip" items="${list}">
			<tr>
				<td>${zip.city}</td>
				<td>${zip.pop}</td>
				<td>${zip.state}</td>
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>