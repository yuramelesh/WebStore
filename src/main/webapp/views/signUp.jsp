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

<title>Registration</title>
</head>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div>
				<h3>Register new user</h3>
			</div>

			<div class="row">
				<div class="col-md-4">
					<form action="userList" method="POST">
						<div class="form-group">
							<label for="inputName">User name</label> <input type="text"
								class="form-control" name="name">
						</div>
						<div class="form-group">
							<label for="inputEmail">Email address</label> <input type="email"
								class="form-control" name="email">
						</div>
						<div class="form-group">
							<label for="inputPassword">Password</label> <input
								type="password" class="form-control" name="password">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>