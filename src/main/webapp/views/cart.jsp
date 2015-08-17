<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
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
				<h3>Cart</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<jstl:forEach items="${cart}" var="product">
							<tr>
								<td><jstl:if test="${product.photo != null}">
										<img height="100" src="${product.photo}" />
									</jstl:if></td>
								<td><a href="productProfile?id=${product.id}">${product.name}</a></td>

								<td>${product.price}</td>

								<td><form action="removeFromCart">
										<button type="submit" class="btn btn-danger" name="id"
											value="${product.id}">remove</button>
									</form></td>
							</tr>
						</jstl:forEach>
						<tr>
							<td></td>
							<td>Total:</td>
							<td>${total}$</td>

							<td><form action="ordering" method="post" >
									<button type="submit" class="btn btn-warning">Order
										now!</button>
								</form></td>

						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
