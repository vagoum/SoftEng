<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- jQuery core -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Bootstrap core -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- CSS files -->
<link rel="stylesheet" href="./css/index_carousel.css">
<link rel="stylesheet" href="./css/index_footer.css">

<!-- js files -->
<script type="text/javascript" src="./js/activity_create-controller.js"></script>

<title>Little Explorers</title>
</head>
<body>

	<div class="container">

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<div class="col-sm-4">

				<h2 class="form-signin-heading">Create your account</h2>
				<spring:bind path="email">
					<div class="col-6 form-group ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="email" class="form-control"
							placeholder="Email" autofocus="true"></form:input>
						<form:errors path="email"></form:errors>
					</div>
				</spring:bind>

				<spring:bind path="password">
					<div class="col-6 form-group ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="password" class="form-control"
							placeholder="Password"></form:input>
						<form:errors path="password"></form:errors>
					</div>
				</spring:bind>

				<div class="col-6 form-group ${status.error ? 'has-error' : ''}">
					<input type="password" id="passwordConfirm"
						placeholder="Password again" class="form-control">
				</div>

				<script>
				$("#passwordConfirm").on("change paste keyup", function() {
					var password = $("#password").val();
					var confirmPassword = $("#passwordConfirm").val();

					if (password != confirmPassword) {
						$("#register-submit").prop('disabled', true);
						$("#error").html("Passwords do not match!");
					} else {
						$("#register-submit").prop('disabled', false);
						$("#error").html("");
					}
				});
				function jsfunction() {
					//you code
					return false;
				}
			</script>

				<button class="btn btn-lg btn-primary btn-block" type="submit" id="register-submit" disabled>Submit</button>
				<a	href="<c:url value="/" />" class="btn btn-default">Cancel</a> 
			</div>

		</form:form>

	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
