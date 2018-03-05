<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
	<link  rel="stylesheet" href="./css/index_carousel.css">
	<link  rel="stylesheet" href="./css/registration_panel.css">
	<link  rel="stylesheet" href="./css/index_footer.css">
	<title>Little Explorers</title>

	<!-- js files -->
	<script type="text/javascript" src="./js/registration-controller.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUJOMB6wHxG1D4Y1ZCl3TXlH0NptQ8PWk&libraries=places"></script>

</head>

<body>
	<!-- Carousel -->
	<div class="container">
		<div class="row">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="10000">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">


					<div class="item">
						<img class="second-slide" src="https://www.w3schools.com/w3images/workbench.jpg" alt="Second slide" style="width:100%;">
						<div class="carousel-caption">
							<h3>For Parents</h3>
							<p>Explore Amazing Activies</p>
						</div>
					</div>

					<div class="item">
						<img class="third-slide" src="https://www.w3schools.com/w3images/coffee.jpg" alt="Third slide" style="width:100%;">
						<div class="carousel-caption">
							<h3>For Activity Organizers</h3>
							<p>Create great experiences and adventures for amazing customers</p>
						</div>
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>

  <input type="hidden" name="country1" value="Norway">
    <input type="hidden" name="country2" value="Norway">
      <input type="hidden" name="country3" value="Norway">
      
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
												<input type="text" placeholder="Enter your First Name" class="form-control" name="parent-first_name">
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label>
												<input type="text" placeholder="Enter your Last Name" class="form-control" name="parent-last_name">
											</div>
										</div>					
										<div class="form-group">
											<label>Address</label>
											<input type="text" placeholder="Enter your Address" class="form-control pac-input" name="parent-address">
										</div>
										<div class="map"></div>				
										<div class="form-group">
											<label>Phone Number</label>
											<input type="number" placeholder="Enter your Phone Number" class="form-control" name="parent-phone">
										</div>		
										<div class="form-group">
											<label>Email Address</label>
											<input type="text" placeholder="Enter your Email Address" class="form-control" name="parent-email">
										</div>	
										<div class="form-group">
											<label>Password</label>
											<input type="password" placeholder="Enter your Password" class="form-control" name="parent-password"/>
										</div>	
										<div class="form-group">
											<label>Password Again</label>
											<input  type="password" placeholder="Enter your Password Again" class="form-control" name="parentpasswordConfirm"/>
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
												<input type="text" placeholder="Enter your First Name" class="form-control" name="organizer-first_name">
											</div>
											<div class="col-sm-6 form-group">
												<label>Last Name</label>
												<input type="text" placeholder="Enter your Last Name" class="form-control" name="organizer-last_name">
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
											<input type="text" placeholder="Enter your Address" class="form-control pac-input" name="organizer-address">
										</div>

										<div class="map"></div>

										<div class="form-group">
											<label>Phone Number</label>
											<input type="number" placeholder="Enter your Phone Number" class="form-control" name="organizer-phone">
										</div>		
										<div class="form-group">
											<label>Email Address</label>
											<input type="text" placeholder="Enter your Email Address" class="form-control" name="organizer-email">
										</div>	
										<div class="form-group">
											<label>Password</label>
											<input type="password" placeholder="Enter your Password" class="form-control" name="organizer-password"/>
										</div>	
										<div class="form-group">
											<label>Password Again</label>
											<input  type="password" placeholder="Enter your Password Again" class="form-control" name="organizer-passwordConfirm"/>
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