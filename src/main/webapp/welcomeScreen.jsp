<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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
</head>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<table class="table table-striped">
				<tr>
					<td><a href="productProfile?id=${product1.id}">${product1.name}</a></td>
				</tr>
				<tr>
					<td><img height="100" src="${product1.photo}"></td>
				</tr>
				<tr>
					<td>${product1.price}$</td>
				</tr>
				<tr>
					<td><sec:authorize access="hasRole('ROLE_USER')">
							<form action="toCart">
								<button type="submit" class="btn btn-warning" name="id"
									value="${product1.id}">Add to cart</button>
							</form>
						</sec:authorize></td>
				</tr>
			</table>
		</div>

		<div class="col-md-2">
			<table class="table table-striped">
				<tr>
					<td><a href="productProfile?id=${product2.id}">${product2.name}</a></td>
				</tr>
				<tr>
					<td><img height="100" src="${product2.photo}"></td>
				</tr>
				<tr>
					<td>${product2.price}$</td>
				</tr>
				<tr>
					<td><sec:authorize access="hasRole('ROLE_USER')">
							<form action="toCart">
								<button type="submit" class="btn btn-warning" name="id"
									value="${product2.id}">Add to cart</button>
							</form>
						</sec:authorize></td>
				</tr>
			</table>
		</div>

		<div class="col-md-2">
			<table class="table table-striped">
				<tr>
					<td><a href="productProfile?id=${product3.id}">${product3.name}</a></td>
				</tr>
				<tr>
					<td><img height="100" src="${product3.photo}"></td>
				</tr>
				<tr>
					<td>${product3.price}$</td>
				</tr>
				<tr>
					<td><sec:authorize access="hasRole('ROLE_USER')">
							<form action="toCart">
								<button type="submit" class="btn btn-warning" name="id"
									value="${product3.id}">Add to cart</button>
							</form>
						</sec:authorize></td>
				</tr>
			</table>
		</div>

		<div class="col-md-2">
			<table class="table table-striped">
				<tr>
					<td><a href="productProfile?id=${product4.id}">${product4.name}</a></td>
				</tr>
				<tr>
					<td><img height="100" src="${product4.photo}"></td>
				</tr>
				<tr>
					<td>${product4.price}$</td>
				</tr>
				<tr>
					<td><sec:authorize access="hasRole('ROLE_USER')">
							<form action="toCart">
								<button type="submit" class="btn btn-warning" name="id"
									value="${product4.id}">Add to cart</button>
							</form>
						</sec:authorize></td>
				</tr>
			</table>
		</div>
		<div class="col-md-2">
			<table class="table table-striped">
				<tr>
					<td><a href="productProfile?id=${product5.id}">${product5.name}</a></td>
				</tr>
				<tr>
					<td><img height="100" src="${product5.photo}"></td>
				</tr>
				<tr>
					<td>${product5.price}$</td>
				</tr>
				<tr>
					<td><sec:authorize access="hasRole('ROLE_USER')">
							<form action="toCart">
								<button type="submit" class="btn btn-warning" name="id"
									value="${product5.id}">Add to cart</button>
							</form>
						</sec:authorize></td>
				</tr>
			</table>
		</div>
		<div class="col-md-1"></div>
	</div>

</body>
</html>