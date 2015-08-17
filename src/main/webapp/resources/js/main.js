$(document).ready(
		function() {

			$('#nameForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newUserName",
							data : "name=" + $("#username").val() + "&id="
									+ $("#id").val(),
							success : function(name) {
								$("#name").text(name);
								$('#nameForm').trigger('reset');
							}
						});
						return false;
					});

			$('#emailForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newUserEmail",
							data : "email=" + $("#useremail").val() + "&id="
									+ $("#id").val(),
							success : function(email) {
								$("#email").text(email);
								$('#emailForm').trigger('reset');
							}
						});
						return false;
					});

			$('#photoForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newUserPhoto",
							data : "photo=" + $("#userphoto").val() + "&id="
									+ $("#id").val(),
							success : function(photo) {
								$("#photo").text(photo);
								$('#photoForm').trigger('reset');
							}
						});
						return false;
					});

			$('#passwordForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newUserPassword",
							data : "password=" + $("#userpassword").val()
									+ "&id=" + $("#id").val(),
							success : function(password) {
								$("#password").text(password);
								$('#passwordForm').trigger('reset');
							}
						});
						return false;
					});

			$('#statusForm').submit(function() {
				$.ajax({
					type : "POST",
					url : "newUserStatus",
					data : "id=" + $("#id").val(),
					success : function(msg) {
						$("#status").text(msg);
						$('#statusForm').trigger('reset');
					}
				});
				return false;
			});

			$('#roleForm').submit(function() {
				$.ajax({
					type : "POST",
					url : "newUserRole",
					data : "id=" + $("#id").val(),
					success : function(role) {
						$("#role").text(role);
						$('#roleForm').trigger('reset');
					}
				});
				return false;
			});

			$('#producNameForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newProductName",
							data : "name=" + $("#productname").val() + "&id="
									+ $("#id").val(),
							success : function(name) {
								$("#name").text(name);
								$('#producNameForm').trigger('reset');
							}
						});
						return false;
					});

			$('#productPriceForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newProductPrice",
							data : "price=" + $("#productprice").val() + "&id="
									+ $("#id").val(),
							success : function(price) {
								$("#price").text(price);
								$('#productPriceForm').trigger('reset');
							}
						});
						return false;
					});

			$('#productCategoryForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newProductCategory",
							data : "category=" + $("#productcategory").val()
									+ "&id=" + $("#id").val(),
							success : function(category) {
								$("#category").text(category);
								$('#productCategoryForm').trigger('reset');
							}
						});
						return false;
					});

			$('#productPhotoForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newProductPhoto",
							data : "photo=" + $("#productphoto").val() + "&id="
									+ $("#id").val(),
							success : function(photo) {
								$("#photo").text(photo);
								$('#productPhotoForm').trigger('reset');
							}
						});
						return false;
					});

			$('#productDescriptionForm').submit(
					function() {
						$.ajax({
							type : "POST",
							url : "newProductDescription",
							data : "description="
									+ $("#productdescription").val() + "&id="
									+ $("#id").val(),
							success : function(description) {
								$("#description").text(description);
								$('#productDescriptionForm').trigger('reset');
							}
						});
						return false;
					});
			
			var count = 4;

			var inProgress = false;
			
			$(window).scroll(function() {

		       if($(window).scrollTop() + $(window).height() >= $(document).height() - 200 && !inProgress) {

				$.ajax({
					type : 'POST',
					url : 'json',
					data : {"index": count},
					dataType : 'json',
					success : function(products) {
						var myTable = $('#test_table');
						var content = myTable.html();
						$(products).each(function(i) {
							content = content + 
							'<tr><td>'
							+ '<img height="100" src="' + products[i].photo + '"/>'
							+ '</td><td><a href="productProfile?id=' + products[i].id + '">'
							+ products[i].name
							+ '</a></td><td><a href="search?category=' + products[i].category + '">'
							+ products[i].category
							+ '</a></td><td>'
							+ products[i].price + '$'
							+'</td><td><sec:authorize access=\"hasRole(\'ROLE_USER\')\">'
							+'<form action="toCart" method="post">'
							+'<button type="submit" class="btn btn-warning" name="id" value="' + products[i].id + '">Add to cart</button>'
							+'</form></sec:authorize>'
							+'</td><td><sec:authorize access=\"hasRole(\'ROLE_ADMIN\')\">'
							+'<form action="productCard?id=' + products[i].id + '">'
							+'<button type="submit" class="btn btn-warning" name="id" value="' + products[i].id + '">Edit</button>'
							+'</form></sec:authorize>'
							+'</td><td><sec:authorize access=\"hasRole(\'ROLE_ADMIN\')\">'
							+'<form action="removeProduct">'
							+'<button type="submit" class="btn btn-danger" name="id" value="' + products[i].id + '">Remove</button>'
							+'</form></sec:authorize>'
							+'</td></tr>';
							myTable.html(content);
						});
						
					}
					
				});
				
				count += 4;
				return false;
		       }
			});
		});