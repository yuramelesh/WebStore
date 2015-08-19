<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<script src='<jstl:url value="/resources/js/main.js" />'></script>
<title>List of users</title>
</head>
<body>
	<div class="row" id="content">
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
						<td id="name">${user.name}</td>
						<form id="nameForm" method="post">
							<td><input id="username" type="text" class="form-control"
								name="newName">
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${user.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>E-mail</td>
						<td id="email">${user.email}</td>
						<form id="emailForm" method="post">
							<td><input id="useremail" type="email" class="form-control"
								name="newEmail"></td>
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${user.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Photo URL</td>
						<td id="photo">${user.photoUrl}</td>
						<form id="photoForm" method="post">
							<td><input id="userphoto" type="text" class="form-control"
								name="newPhoto"></td>
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${user.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Password</td>
						<td id="password">${user.password}</td>
						<form id="passwordForm" method="post">
							<td><input id="userpassword" type="text"
								class="form-control" name="newPassword"></td>
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${user.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Status</td>
						<td id="status"><jstl:if test="${user.active == true}">
								<p>Active</p>
							</jstl:if> <jstl:if test="${user.active == false}">
								<p>Non active</p>
							</jstl:if></td>
						<form id="statusForm" method="post">
							<td></td>
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${user.id}">change</button></td>
						</form>

					</tr>
					<tr>
						<td>Role</td>
						<td id="role">${user.role}</td>
						<form id="roleForm" method="post">
							<td></td>
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${user.id}">change</button></td>
						</form>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
