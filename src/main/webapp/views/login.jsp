<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
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

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-3">

			<h3>Login form</h3>

			<jstl:if test="${error != null}">
				<p style="text-color: red;">${error}</p>
			</jstl:if>
			<form name='...' action='j_spring_security_check' method='POST'>

				Username<input class="form-control" type='text' name='username'
					value=''> Password<input class="form-control"
					type='password' name='password' /> <br>
				<button type="submit" class="btn btn-default">login</button>
				<p></p>
			</form>
		</div>
	</div>

</body>
</html>
