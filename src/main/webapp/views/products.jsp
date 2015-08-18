<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
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
<script src='<jstl:url value="/resources/js/main.js" />'></script>
<title>List of users</title>
</head>
<script>
var role = '<sec:authentication property='authorities'/>'.toString();

	$(document).ready(function() {
		$.ajax({
				type : 'POST',
				url : 'json',
				data : {'index' : 0, 'name' : role},
				dataType : 'json',
				success : function(products) {
					$(products).each(function(i) {
							$('#test_table').append(
									'<tr><td>'
											+ '<img height="100" src="' + products[i].photo + '"/>'
											+ '</td><td><a href="productProfile?id=' + products[i].id + '">'
											+ products[i].name
											+ '</a></td><td><a href="search?category=' + products[i].category + '">'
											+ products[i].category
											+ '</a></td><td>'
											+ products[i].price + '$'
											+'</td><td><sec:authorize access="hasRole('ROLE_USER')">'
											+'<form action="toCart" method="post">'
											+'<button type="submit" class="btn btn-warning" name="id" value="' + products[i].id + '">Add to cart</button>'
											+'</form></sec:authorize>'
											+'</td><td><sec:authorize access="hasRole('ROLE_ADMIN')">'
											+'<form action="productCard?id=' + products[i].id + '">'
											+'<button type="submit" class="btn btn-warning" name="id" value="' + products[i].id + '">Edit</button>'
											+'</form></sec:authorize>'
											+'</td><td><sec:authorize access="hasRole('ROLE_ADMIN')">'
											+'<form action="removeProduct">'
											+'<button type="submit" class="btn btn-danger" name="id" value="' + products[i].id + '">Remove</button>'
											+'</form></sec:authorize>'
											+'</td></tr>'
											);
					});
				}
		});
		
		});
</script>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div>
				<h3>Product list</h3>
				<div id='results'></div>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<div class="col-md-1">
						<form action="addProduct">
							<button type="submit" class="btn btn-warning">add
								product</button>
						</form>
					</div>
				</sec:authorize>
				<table id="test_table" class="table table-striped">
				</table>
			</div>
		</div>
	</div>
</body>
</html>