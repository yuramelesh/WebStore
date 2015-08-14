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
<script src='<jstl:url value="/resources/js/main.js" />'></script>
<title>Product card</title>
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
						<td id="name">${product.name}</td>
						<form id="producNameForm" method="post">
							<td><input id="productname" type="text" class="form-control"
								name="newName">
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${product.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Price</td>
						<td id="price">${product.price}</td>
						<form id="productPriceForm" method="post">
							<td><input id="productprice" type="text"
								class="form-control" name="newPrice"></td>
							<td><button id="id" type="submit" class="btn btn-warning"
									name="id" value="${product.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Category</td>
						<td id="category">${product.category}</td>
						<td><form id="productCategoryForm" method="post">
								<select id="productcategory" class="form-control"
									name="newCategory">
									<jstl:forEach items="${productCategory}" var="category">
										<option>${category.name}</option>
									</jstl:forEach>
								</select>
								<td><button id="id" type="submit" class="btn btn-warning"
										name="id" value="${product.id}">change</button></td>
							</form></td>
					</tr>
					<tr>
						<td>Main photo</td>
						<td id="photo">${product.photo}</td>
						<form id="productPhotoForm" method="post">
							<td><input id="productphoto" type="text" class="form-control" name="newPhoto"></td>
							<td><button id="id" type="submit" class="btn btn-warning" name="id"
									value="${product.id}">change</button></td>
						</form>
					</tr>
					<tr>
						<td>Description</td>
						<td id="description">${product.description}</td>
						<form id="productDescriptionForm" method="post">
							<td><input id="productdescription" type="text" maxlength="224"
								class="form-control" name="newDescription"></td>
							<td><button id="id" type="submit" class="btn btn-warning" name="id"
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
