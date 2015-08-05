<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />'></script>
</head>
<body>
	<div>
		<h1>${User.name}`s profile</h1>
	</div>
	<jstl:if test="${user.photoUrl != null}">
		<img src="${user.photoUrl}" height="150" width="150">
	</jstl:if>
	
	<table border="1">
		<thead>
			<tr>
				<th>Books</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${books}" var="b">
				<tr>
					<td>${b.title}</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>
