<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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
<title>Web store</title>
</head>
<body>
	<div class="page-header" style="margin-top: 0px;">
		<div class="row">
			<div class="col-md-2">
				<div style="margin-left: 20px;">
					<h1>
						WEB<small> store</small>
					</h1>
				</div>
			</div>
			<div class="col-md-2"></div>

			<div class="col-md-4" style="margin-top: 20px;">
				<div class="btn-group">
					<form action="searching">
						<input type="text" class="btn btn-default" name="name"></input>
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
			</div>

			<div class="col-md-2"></div>

			<div class="col-md-2" style="margin-top: 20px;">

				<div class="btn-group">

					<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
						<a href="login"><button type="button" class="btn btn-default">Log
								in</button></a>
						<a href="registration"><button type="submit"
								class="btn btn-default">Sign up</button></a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<a href="logout"><button type="button" class="btn btn-default">logout</button></a>
					</sec:authorize>
					<br> Hello <sec:authentication
							property="name" /> !
				</div>
			</div>
		</div>
		<div class="btn-group" role="toolbar" style="margin-left: 20px;">
			<sec:authorize access="hasRole('ROLE_USER')">
			<a class="btn btn-warning" href="profile?name=<sec:authentication property='name'/>" role="button" >Profile</a>
				<a class="btn btn-warning" href="cart" role="button">Cart</a>
			</sec:authorize>
			<a class="btn btn-default" href="welcome" role="button">Home</a> <a
				class="btn btn-default" href="products" role="button">Products</a>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="btn btn-default" href="userList" role="button">User
					list</a>
				<a class="btn btn-default" href="category" role="button">Category</a>
				<a class="btn btn-default" href="addProduct" role="button">Add
					product</a>
			</sec:authorize>
		</div>
	</div>
</body>
</html>