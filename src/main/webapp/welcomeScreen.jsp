<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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
	<div class="row">
		<div class="col-md-2">
			<form action="search">
				<div style="margin-left: 20px;" class="btn-group-vertical"
					role="group">

					<jstl:forEach items="${productCategory}" var="productCategory">

						<button type="submit" class="btn btn-default" name="category"
							value="${productCategory.name}">${productCategory.name}</button>

					</jstl:forEach>

				</div>
			</form>
		</div>
		<div class="col-md-9">
		<jstl:forEach items="${products}" var="product">
			<div class="col-md-3">
				<table class="table table-striped">
					<tr>
						<td><a href="productProfile?id=${product.id}">${product.name}</a></td>
					</tr>
					<tr>
						<td><img height="100" src="${product.photo}"></td>
					</tr>
					<tr>
						<td>${product.price}$</td>
					</tr>
					<tr>
						<td><sec:authorize access="hasRole('ROLE_USER')">
								<form action="toCart">
									<button type="submit" class="btn btn-warning" name="id"
										value="${product.id}">Add to cart</button>
								</form>
							</sec:authorize></td>
					</tr>
				</table>
			</div>
		</jstl:forEach>
		</div>
		<div class="col-md-1">
		</div>
	</div>
</body>
</html>