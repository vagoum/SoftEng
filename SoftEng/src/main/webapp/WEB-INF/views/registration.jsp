<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


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
	<link  rel="stylesheet" href="./css/validation.css">
	<link  rel="stylesheet" href="./css/index_carousel.css">
	<link  rel="stylesheet" href="./css/registration_panel.css">
	<link  rel="stylesheet" href="./css/index_footer.css">
	<title>Little Explorers</title>

	<!-- js files -->
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	<script type="text/javascript" src="./js/registration-controller.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUJOMB6wHxG1D4Y1ZCl3TXlH0NptQ8PWk&libraries=places"></script>
<script type="text/javascript" src="./js/jqeury.validate.js"></script>

</head>

<body>

  <input type="hidden" name="country1" value="Norway">
    <input type="hidden" name="country2" value="Norway">
      <input type="hidden" name="country3" value="Norway">

			    <!-- Generic Navbar -->
       
    <sec:authorize access="!hasRole('ROLE_ORGANIZER') and !hasRole('ROLE_PARENT')">
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
                        <li><a href="/index">Home</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/registration">Register</a></li>
 
                        <li class="dropdown">
                            <a href="http://www.jquery2dotnet.com" class="dropdown-toggle" data-toggle="dropdown">Sign in <b class="caret"></b></a>
                            <ul class="dropdown-menu" style="padding: 15px;min-width: 250px;">
                                <li>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form" role="form" method="post" action="/login" accept-charset="UTF-8" id="login-nav">
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
 												
                                                <input type="hidden" name="${_csrf.parameterName}"
                                                    value="${_csrf.token}" />
                                                <div class="form-group">
                                                    <button type="submit" class="btn btn-success btn-block">Sign
                                                        in</button>
                                                </div>
                                                <a href="/user/resetPassword">Forgot your password?</a>
                                            </form>
                                        </div>
                                    </div>
                                </li>
                            </ul></li>
                    </ul>
 
                </div>
                </nav>
            </div>
        </div>
    </sec:authorize>
   
   
    <!-- Parent Navbar -->
    <sec:authorize access="hasRole('ROLE_PARENT')">
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
                        <li><a href="/index">Home</a></li>
                    </ul>
 
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/parent">Profile</a></li>
                        <li><a href="/logout">Log Out</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    </sec:authorize>
 
 
 
    <!-- Organizer Navbar -->
    <sec:authorize access="hasRole('ROLE_ORGANIZER')">
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
                        <li><a href="/index">Home</a></li>
                        <li><a href="/activity_create">Create Activity</a></li>
                    </ul>
 
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/organizer">Profile</a></li>
                        <li><a href="/logout">Log Out</a></li>
                    </ul>
 
                </div>
            </nav>
        </div>
    </div>
    </sec:authorize>
          
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
								<form id="parent-registration-form" action="users/parents/registration.jsp" method="post" role="form" style="display: block;" onkeypress="if (event.keyCode ==13) {return false;}">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6 form-group">
												<label>First Name</label>
												<input type="text" placeholder="Enter your First Name" class="form-control" id="parent-first_name" name="parent-first_name">
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label>
												<input type="text" placeholder="Enter your Last Name" class="form-control" id="parent-last_name" name="parent-last_name">
											</div>
										</div>					
										<div class="form-group">
											<label>Address</label>
											<input type="text" placeholder="Enter your Address" class="form-control pac-input"  id="parent-address" name="parent-address">
										</div>
										<div class="map"></div>				
										<div class="form-group">
											<label>Phone Number</label>
											<input type="number" placeholder="Enter your Phone Number" class="form-control" id="parent-phone" name="parent-phone">
										</div>		
										<div class="form-group">
											<label>Email Address</label>
											<input type="text" placeholder="Enter your Email Address" class="form-control" id="parent-email" name="parent-email">
										</div>	
										<div class="form-group">
											<label>Password</label>
											<input type="password" placeholder="Enter your Password" class="form-control" id="parent-password" name="parent-password"/>
										</div>	
										<div class="form-group">
											<label>Password Again</label>
											<input  type="password" placeholder="Enter your Password Again" class="form-control" id="parentpasswordConfirm" name="parentpasswordConfirm"/>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<button id="register-parent_btn" tabindex="4" class="form-control btn btn-register">Register Now</button>
												</div>
											</div>
										</div>
														
									</div>
								</form>

								<!--Registration Form For Activity Organizers -->
								<form id="organizer-registration-form" action="users/organizers/registration.jsp" method="post" role="form" style="display: none;" onkeypress="if (event.keyCode ==13) {return false;}">
									<div class="col-sm-12">

										<div class="row">
											<div class="col-sm-6 form-group">
												<label>First Name</label>
												<input type="text" placeholder="Enter your First Name" class="form-control" id="organizer-first_name" name="organizer-first_name">
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label>
												<input type="text" placeholder="Enter your Last Name" class="form-control" id="organizer-last_name" name="organizer-last_name">
											</div>
										</div>		
										<div class="form-group">
											<label>Company Name</label>
											<input type="text" placeholder="Enter your Company Name" class="form-control" id="company_name" name="company_name">
										</div>
										<div class="form-group">
											<label>Company Details</label>
											<textarea placeholder="Please specify details about your organization" rows="3" class="form-control" id="company_details" name="company_details" style="resize: none;"></textarea>
										</div>
										<div class="form-group">
											<label>Address</label>
											<input type="text" placeholder="Enter your Address" class="form-control pac-input" id="organizer-address" name="organizer-address">
										</div>

										<div class="map"></div>

										<div class="form-group">
											<label>Phone Number</label>
											<input type="number" placeholder="Enter your Phone Number" class="form-control" id="organizer-phone" name="organizer-phone">
										</div>		
										<div class="form-group">
											<label>Email Address</label>
											<input type="text" placeholder="Enter your Email Address" class="form-control" id="organizer-email" name="organizer-email">
										</div>	
										<div class="form-group">
											<label>Password</label>
											<input type="password" placeholder="Enter your Password" class="form-control" id="organizer-password" name="organizer-password"/>
										</div>	
										<div class="form-group">
											<label>Password Again</label>
											<input  type="password" placeholder="Enter your Password Again" class="form-control" id="organizer-passwordConfirm" name="organizer-passwordConfirm"/>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<button name="register-submit" id="register-organizer_btn" tabindex="4" class="form-control btn btn-register">Register Now</button>
												</div>
											</div>
										</div>
														
									</div>
								</form>
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
</html>