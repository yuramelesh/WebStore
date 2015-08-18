<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
<%@ page import="ua.lviv.melesh.domain.User"%>
<%@ page import="ua.lviv.melesh.domain.UserOrder"%>
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
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-5">
			<div>
				<img height="200" src="${user.photoUrl}" />
			</div>
		</div>

		<div class="col-md-5">
			<h3></h3>
			<table class="table table-striped">
				<tr>
					<td>Name</td>
					<td>${user.name}</td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td>${user.email}</td>
				</tr>
			</table>
			<br> <b>Orders:</b>
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Number</td>
						<td>Summ</td>
						<td>Date</td>
					</tr>
				</thead>
				<tbody>
					<jstl:forEach items="${orders}" var="order">
						<tr>
							<td>${order.id}</td>
							<td>${order.summ}</td>
							<td>${order.date}</td>
						</tr>
					</jstl:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br>
</body>
</html>
