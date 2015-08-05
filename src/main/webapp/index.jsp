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
				<div class="btn-group" role="group">

					<button class="btn btn-default" type="button" id="dropdownMenu1"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						Category <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li><a href="#">Separated link</a></li>
					</ul>

					<input type="text" class="btn btn-default"></input>

					<button type="button" class="btn btn-default">Search</button>
				</div>
			</div>

			<div class="col-md-2"></div>
			<div class="col-md-2" style="margin-top: 20px;">

				<div class="btn-group">
					<button type="button" class="btn btn-default">Log in</button>

					<a href="registration"><button type="submit"
							class="btn btn-default">Sign up</button></a>

				</div>

			</div>
		</div>
	</div>

	<table border="2">
		<thead>
			<tr>
				<th>Navigation</th>
			</tr>

			<tr>
				<th><a href="registration"> - Register user</a></th>
			</tr>
			<tr>
				<th><a href="userList"> - Show all user</a></th>
			</tr>
			<tr>
				<th><a href="addProduct"> - Add product</a></th>
			</tr>

			<tr>
				<th><a href="products"> - List products</a></th>
			</tr>
			<tr>
				<th><a href="category"> - Categories</a></th>
			</tr>
		</thead>
	</table>
	<div class="panel panel-default">
		<center>
			<div class="panel-body">Melesh &#169 2015</div>
		</center>
	</div>
</body>
</html>