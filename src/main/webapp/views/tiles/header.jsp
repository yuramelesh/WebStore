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
						WEB<small> <a href="welcome">store</a></small>
					</h1>
				</div>
			</div>
			<div class="col-md-2"></div>

			<div class="col-md-4" style="margin-top: 20px;">
				<div class="btn-group">

					<input type="text" class="btn btn-default"></input>

					<button type="button" class="btn btn-default">Search</button>
				</div>
			</div>

			<div class="col-md-2"></div>

			<div class="col-md-2" style="margin-top: 20px;">

				<div class="btn-group">

					<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
						<a href="login.jsp"><button type="button"
								class="btn btn-default">Log in</button></a>
						<a href="registration"><button type="submit"
								class="btn btn-default">Sign up</button></a>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<a href="cart">cart</a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<a href="logout"><button type="button" class="btn btn-default">logout</button></a>
					</sec:authorize>

				</div>

			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')"><p>
				<a href="addProduct">addProduct</a><a href="products">products</a><a
					href="userList">userList</a><a href="category">category</a>
			</p></sec:authorize>

		</div>
	</div>
</body>
</html>