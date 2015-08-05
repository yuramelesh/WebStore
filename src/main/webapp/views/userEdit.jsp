<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
<%@ page import="ua.lviv.melesh.domain.User"%>
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
<title>List of users</title>
</head>
<body>

	<div class="row">
		<div class="col-md-1"></div>

		<div class="col-md-10">

			<h3>Edit ${user.name}`s profile</h3>
			<small><a href="userList">back to user list</a></small>

			<table class="table table-striped">
				<tbody>
					<tr>
						<td>Id</td>
						<td>${user.id}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Name</td>
						<td>${user.name}</td>
						<form action="editingName">
							<td><input type="text" class="form-control" name="newName"></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${user.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>E-mail</td>
						<td>${user.email}</td>
						<form action="editingEmail">
							<td><input type="email" class="form-control" name="newEmail"></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${user.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Password</td>
						<td>${user.password}</td>
						<form action="editingPassword">
							<td><input type="text" class="form-control"
								name="newPassword"></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${user.id}">change</button></td>
						</form>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
