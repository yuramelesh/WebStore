<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page import="java.util.List"%>
<%@ page import="ua.lviv.melesh.domain.Product"%>
<%@ page import="ua.lviv.melesh.domain.Photos"%>
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
		<div class="col-md-5">
			<div>
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${product.photo}" style="max-height: 300px;">
							<div class="carousel-caption"></div>
						</div>
						<jstl:forEach items="${photos}" var="photo">
							<div class="item">
								<img src="${photo.url}" style="max-height: 300px;">
								<div class="carousel-caption"></div>
							</div>
						</jstl:forEach>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>

		<div class="col-md-5">
			<h3>${product.name}</h3>
			<table class="table table-striped">
				<tr>
					<td>Product # ${product.id}</td>
				</tr>
				<tr>
					<td>Price:${product.price}$</td>
				</tr>
			</table>
		</div>
	</div>
	<br>


</body>
</html>
