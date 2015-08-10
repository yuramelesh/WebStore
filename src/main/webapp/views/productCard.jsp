<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
<%@ page import="ua.lviv.melesh.domain.Product"%>
<%@ page import="ua.lviv.melesh.domain.ProductCategory"%>
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
<title>Card</title>
</head>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<h3>${product.name}-card</h3>
			<small><a href="products">back to product list</a></small>
			<table class="table table-striped">
				<tbody>
					<tr>
						<td>Id</td>
						<td>${product.id}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Name</td>
						<td>${product.name}</td>
						<form action="newProductName">
							<td><input type="text" class="form-control" name="newName"></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${product.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Price</td>
						<td>${product.price}</td>
						<form action="newProductPrice">
							<td><input type="text" class="form-control" name="newPrice"></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${product.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Category</td>
						<td>${product.category}</td>
						<td><form action="editingCategory">
								<select class="form-control" name="newCategory">
									<jstl:forEach items="${productCategory}" var="category">
										<option>${category.name}</option>
									</jstl:forEach>
								</select>
								<td><button type="submit" class="btn btn-warning" name="id"
										value="${product.id}">change</button></td>
							</form></td>
					</tr>
					<tr>
						<td>Main photo</td>
						<td>New photo url</td>
						<form action="newProductPhoto">
							<td><input type="text" class="form-control" name="newPhoto"></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${product.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Photo album</td>
						<td></td>
						<form action="photo">
							<td></td>
							<td><button type="submit" class="btn btn-warning" name="id"
									value="${product.id}">add photos</button></td>
						</form>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
