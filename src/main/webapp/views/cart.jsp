<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
<%@ page import="ua.lviv.melesh.domain.User"%>
<%@ page import="ua.lviv.melesh.domain.Product"%>
<%@ page import="ua.lviv.melesh.domain.ProductCategory"%>
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


	<table class="table table-striped">
		<thead>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Category</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td><img height="75" src="${product.photo}" /></td>
					<td>${product.name}</td>
					<td>${product.category}</td>
					<td>${product.price}</td>
				</tr>
		
			<td></td>
			<td></td>
			<td>Total:</td>
			<td></td>
			<tr>
			</tr>
		</tbody>
	</table>
</body>
</html>
