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
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div>
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
					<jstl:if test="${products.isEmpty() == true}">
					<h1>No results!</h1>
					</jstl:if>
						<jstl:forEach items="${products}" var="product">
							<tr>
								<td><img height="100" src="${product.photo}" /></td>
								<td><a href="productProfile?id=${product.id}">${product.name}</a></td>
								<td>${product.category}</td>
								<td>${product.price}</td>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<td><form action="productCard?id=${product.id}">
											<button type="submit" class="btn btn-warning" name="id"
												value="${product.id}">edit</button>
										</form></td>
									<td><form action="removeProduct">
											<button type="submit" class="btn btn-danger" name="id"
												value="${product.id}">remove</button>
										</form></td>
								</sec:authorize>
							</tr>
						</jstl:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>