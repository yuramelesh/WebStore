<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
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

<title></title>
</head>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<h3>Add product</h3>
		</div>
		<div class="col-md-1"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<form action="products" method="POST">
			<div class="col-md-4">
				Name <input class="form-control" type="text" name="name"> <br>
				Category <select class="form-control" name="category">
					<jstl:forEach items="${productCategory}" var="category">
						<option>${category.name}</option>
					</jstl:forEach>
				</select><br> Price
				<div class="input-group">
					<div class="input-group-addon">$</div>
					<input type="text" class="form-control" placeholder="Price"
						name="price">
					<div class="input-group-addon">.00</div>
				</div>
				<br>
				<div>
					<button type="submit" class="btn btn-default">Add product</button>
				</div>
				<br>
			</div>
			<div class="col-md-4">
				Photo<input type="text" class="form-control" name="productPhoto">
			</div>
			<div class="col-md-4">
			<br>
				Description<textarea class="form-control" rows="5"  maxlength="224" class="form-control" name="productDescription">
				</textarea>
			</div>
		</form>
		<div class="col-md-1"></div>
	</div>
</body>
</html>