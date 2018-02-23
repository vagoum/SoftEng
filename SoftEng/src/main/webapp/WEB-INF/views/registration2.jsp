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
	<link  rel="stylesheet" href="./css/index_carousel.css">
	<link  rel="stylesheet" href="./css/registration_panel.css">
	<link  rel="stylesheet" href="./css/index_footer.css">
	<title>Little Explorers</title>

	<script type="text/javascript">
		$(function() {
			$('#parent-registration-form-link').click(function(e) {
				$("#parent-registration-form").delay(100).fadeIn(100);
				$("#organizer-registration-form").fadeOut(100);
				$('#organizer-registration-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});
			$('#organizer-registration-form-link').click(function(e) {
				$("#organizer-registration-form").delay(100).fadeIn(100);
				$("#parent-registration-form").fadeOut(100);
				$('#parent-registration-form-link').removeClass('active');
				$(this).addClass('active');
				e.preventDefault();
			});

		});
	</script>

</head>

<body>



	<!-- Navbar -->
	<div class="container side-bordering">
		<div class="row">
			<nav class="navbar navbar-inverse">
				<div class="navbar-header">
					<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand visible-xs-block" href="#">Menu</a>
				</div>

				<div class="collapse navbar-collapse js-navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">For Parents<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">For Organizers<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Register</a></li>

						<li class="dropdown">
							<a href="http://www.jquery2dotnet.com" class="dropdown-toggle" data-toggle="dropdown">Sign in <b class="caret"></b></a>
							<ul class="dropdown-menu" style="padding: 15px;min-width: 250px;">
								<li>
									<div class="row">
										<div class="col-md-12">
											<form class="form" role="form" method="post" action="users/login.jsp" accept-charset="UTF-8" id="login-nav">
												<div class="form-group">
													<label class="sr-only" for="exampleInputEmail2">Welcome Back!</label>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputEmail2">Email address</label>
													<input type="email" class="form-control" name="email"placeholder="Email address" required>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputPassword2">Password</label>
													<input type="password" class="form-control"placeholder="Password" required name="password">
												</div>
												<div class="form-group">
													<button type="submit" class="btn btn-success btn-block">Sign in</button>
												</div>
											</form>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<input class="btn btn-primary btn-block" type="button" id="sign-in-google" value="Sign In with Google">
									<input class="btn btn-primary btn-block" type="button" id="sign-in-twitter" value="Sign In with Twitter">
								</li>
							</ul>
						</li>
					</ul>

				</div>
			</nav>
		</div>
	</div>

	<!-- Content -->
	<div class="container side-bordering">
		<!-- Sign-In or Register -->
		<div class="row">
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="parent-registration-form-link">For Parents</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="organizer-registration-form-link">For Activity Organizers</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">

								<!--Registration Form For Parents -->
								<form:form modelAttribute="parentForm" id="parent-registration-form" action="users/parents/registration" method="post" role="form" style="display: block;">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6 form-group">
												<label>First Name</label>
												<form:input path="firstName" type="text" placeholder="Enter your First Name" class="form-control" name="firstName"/>
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label>
												<form:input path="lastName" type="text" placeholder="Enter your Last Name" class="form-control" name="lastName"/>
											</div>
										</div>					
										<div class="form-group">
											<label>Address</label>
											<input type="text" placeholder="Enter your Address" class="form-control" name="address">
										</div>					
										<div class="form-group">
											<label>Phone Number</label>
											<form:input path="phone" type="text" placeholder="Enter your Phone Number" class="form-control" name="phone"/>
										</div>		
										<div class="form-group">
											<label>Email Address</label>
											<form:input path="email" type="text" placeholder="Enter your Email Address" class="form-control" name="email"/>
										</div>	
										<div class="form-group">
											<label>Password</label>
											<form:input path="password" type="password" placeholder="Enter your Password" class="form-control" name="password"/>
											<form:errors path="password"></form:errors>					
										</div>	
										<div class="form-group">
											<label>Password Again</label>
											<form:input path="passwordConfirm" type="password" placeholder="Enter your Password Again" class="form-control" name="passwordConfirm"/>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="register-submit" id="register-submit" disabled tabindex="4" class="form-control btn btn-register" value="Register Now">
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
											</div>
										</div>
														
									</div>
								</form:form>

								<!--Registration Form For Activity Organizers -->
								<form:form modelAttribute="organizerForm" id="organizer-registration-form" action="users/organizers/registration" method="post" role="form" style="display: none;">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6 form-group">
												<label>First Name</label>
												<input  type="text" placeholder="Enter your First Name" class="form-control" name="firstName">
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label>
												<input type="text" placeholder="Enter your Last Name" class="form-control" name="lastName">
											</div>
										</div>					
										<div class="form-group">
											<label>Company Name</label>
											<input type="text" placeholder="Enter your Company Name" class="form-control" name="company_name">
										</div>
										<div class="form-group">
											<label>Company Details</label>
											<textarea placeholder="Please specify details about your organization" rows="3" class="form-control" name="company_details" style="resize: none;"></textarea>
										</div>
										<div class="form-group">
											<label>Address</label>
											<input type="text" placeholder="Enter your Address" class="form-control" name="address">
										</div>	

										<div class="form-group">
											<label>Phone Number</label>
											<form:input path="phone" type="text" placeholder="Enter your Phone Number" class="form-control" name="phone"/>
										</div>		
										<div class="form-group">
											<label>Email Address</label>
											<form:input path="email" type="text" placeholder="Enter your Email Address" class="form-control" name="email"/>
										</div>	
										<div class="form-group">
											<label>Password</label>
											<form:input path="password" id="password2" type="password" placeholder="Enter your Password" class="form-control" name="password2"/>
											<form:errors path="password"></form:errors>						
										</div>	
										<div class="form-group">
											<label>Password Again</label>
											<form:input path="passwordConfirm" id="passwordConfirm2" type="password" placeholder="Enter your Password Again" class="form-control" name="passwordConfirm2"/>
										</div>	

										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="register-submit2" id="register-submit2" disabled tabindex="4" class="form-control btn btn-register" value="Register Now">
												</div>
				<script>
				$("#passwordConfirm2").on("change paste keyup", function() {
					var password = $("#password2").val();
					var confirmPassword = $("#passwordConfirm2").val();

					if (password != confirmPassword) {
						$("#register-submit2").prop('disabled', true);
						$("#error").html("Passwords do not match!");
					} else {
						$("#register-submit2").prop('disabled', false);
						$("#error").html("");
					}
				});
			</script>
											</div>
										</div>
											
		
									</div>
								</form:form>


							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Footer -->
	<div class="container side-bordering">
		<footer>
			<div class="footer" id="footer">
				<div class="row">
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-12">
						<h4>Company</h4>
						<ul>
							<li> <a href="#">Team</a></li>
							<li> <a href="#">FAQ</a></li>
							<li> <a href="#">Terms and Conditions</a></li>
						</ul>
					</div>
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-12">
						<h4>For Parents</h4>
						<ul>
							<li> <a href="#">Discover Activities</a> </li>
							<li> <a href="#">Manage your Activities</a> </li>
						</ul>
					</div>
					<div class="col-lg-2  col-md-2 col-sm-4 col-xs-12">
						<h4>For Organizers</h4>
						<ul>
							<li> <a href="#">Create Activities</a></li>
							<li> <a href="#">Manage your Activities</a></li>
						</ul>
					</div>
					<div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 pull-right">
						<h4>Stay Up to Date</h4>
						<ul>
							<li>
								<div class="input-append newsletter-box text-center">
									<input type="text" class="full text-center" placeholder="example@email.com">
									
									<button class="btn  bg-gray" type="button">Join our newslater<i class="fa fa-long-arrow-right"> </i> </button>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<!--/.row--> 
			</div>
			<div class="footer-bottom">
				<div class="container">
					<p class="pull-left"> Copyright 2017. All rights reserved.</p>
				</div>
			</div>
		</footer>
		<!--/.footer --> 
	</div>

</body>