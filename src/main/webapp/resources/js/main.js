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

		});