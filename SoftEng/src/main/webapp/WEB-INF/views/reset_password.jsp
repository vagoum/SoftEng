<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Bootstrap core -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<!-- CSS files -->
	<link  rel="stylesheet" href="./css/payment_panel.css">
	<link  rel="stylesheet" href="./css/index_footer.css">
	<link  rel="stylesheet" href="./css/validation.css">

	<!-- JS files -->
	<script type="text/javascript" src="./js/reset_password-controller.js"></script>
	
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	
	<title>Little Explorers</title>
</head>

<body>

	
	<!-- Password Reset -->
	<div class="container side-bordering">
		<div class="row">
			<div class="col-xs-12 col-md-4 col-md-offset-4 text-center">
				<h3><i class="glyphicon glyphicon-lock" style="font-size:2em;"></i></h3>
				<h2 id="panel-title">Reset your Password</h2>
			</div>
			<div class="col-xs-12 col-md-4 col-md-offset-4">
				<div class="panel panel-default credit-card-box">

					<div class="panel-body">
						<form:form id="password-form" modelAttribute="passwordForm" role="form"   action="/user/updatePassword?id=${param.id}&token=${param.token}" method="POST">

							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="Password1">New password</label>
										<div class="input-group">
	                                        <span class="input-group-addon">
	                                            <i class="glyphicon glyphicon-lock"></i>
	                                        </span>
											<form:input path="password" type="password" class="form-control" id="password1" name="password1" />
										</div>
									</div>
								</div>                        
							</div>

							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="Password2">Retype new password</label>
										<div class="input-group">
	                                        <span class="input-group-addon">
	                                            <i class="glyphicon glyphicon-lock"></i>
	                                        </span>
											<form:input path="passwordConfirm" type="password" class="form-control" id="password2" name="password2" />
										</div>
									</div>
								</div>                        
							</div>

							<div class="row">
								<div class="col-xs-12">
									<button class="subscribe btn btn-success btn-lg btn-block" type="submit" id="submit_btn">Change Password</button>
								</div>
							</div>

						</form:form>
					</div>
				</div>
			</div> 
		</div>
	</div> 

</body>