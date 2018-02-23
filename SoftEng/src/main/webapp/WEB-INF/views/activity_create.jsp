<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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



	<!-- Navbar -->
	<div class="container side-bordering">
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target=".js-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand visible-xs-block" href="#">Menu</a>
			</div>

			<div class="collapse navbar-collapse js-navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">For
							Parents<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">For
							Organizers<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Register</a></li>

					<li class="dropdown"><a href="http://www.jquery2dotnet.com"
						class="dropdown-toggle" data-toggle="dropdown">Sign in <b
							class="caret"></b></a>
						<ul class="dropdown-menu" style="padding: 15px; min-width: 250px;">
							<li>
								<div class="row">
									<div class="col-md-12">
										<form class="form" role="form" method="post" action="login"
											accept-charset="UTF-8" id="login-nav">
											<div class="form-group">
												<label class="sr-only" for="exampleInputEmail2">Welcome
													Back!</label>
											</div>
											<div class="form-group">
												<label class="sr-only" for="exampleInputEmail2">Email
													address</label> <input type="email" class="form-control"
													id="exampleInputEmail2" placeholder="Email address"
													required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="exampleInputPassword2">Password</label>
												<input type="password" class="form-control"
													id="exampleInputPassword2" placeholder="Password" required>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-success btn-block">Sign
													in</button>
											</div>
										</form>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li><input class="btn btn-primary btn-block" type="button"
								id="sign-in-google" value="Sign In with Google"> <input
								class="btn btn-primary btn-block" type="button"
								id="sign-in-twitter" value="Sign In with Twitter"></li>
						</ul></li>
				</ul>

			</div>
			</nav>
		</div>
	</div>

	<!-- Content -->
	<div class="container side-bordering">

		<div class="row ">
			<div id="search_title" class="text-center">
				<p class="h3">Create a new Activity</p>
			</div>
		</div>
		<div class="row">

			<form:form action="activity_create" method="post"
				modelAttribute="activityDetails" enctype="multipart/form-data">

				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">

					<div class="col-6 form-group">
						<form:label path="name">
							<h4 class="my-4" id="activity-details-title">Activity Title</h4>
						</form:label>
						<form:input path="name" name="name" type="text"
							id="activity-form-title" placeholder="" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>

					<div class="form-group" style="padding-top: 10px;">
					<form:label path="description">
							<h4 class="my-4" id="activity-details-title">Activity Description</h4>
						</form:label>
						<form:textarea path="description" name="description" type="text"
							id="activity-form-title" placeholder="" class="form-control" />
						<form:errors path="description" class="text-danger" />
					</div>

					<div class="form-group"
						style="padding-top: 10px; margin-left: -10px; margin-right: -10px;">
						<div class="col-sm-6">
							<form:label path="ticketNumber">
								<h4 class="my-3">Number of Tickets</h4>
							</form:label>
							<form:input path="ticketNumber" type="number"
								id="activity-form-ticket_number" name="ticketNumber"
								placeholder="20" class="form-control" />
							<form:errors path="ticketNumber" class="text-danger" />

						</div>

						<div class="col-sm-6">
							<label><h4 class="my-3">Ticket Price</h4></label>
							<form:input path="cost" type="number"
								id="activity-form-ticket_price" name="cost" placeholder="8"
								class="form-control" />
							<form:errors path="cost" class="text-danger" />

						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<h4 class="my-4" id="activity-details-title">Select and Upload
						your photos</h4>
					<div class="controls">
						<div class="entry input-group col-xs-3"
							style="padding-bottom: 7px;">

							<input class="btn btn-primary" name="file" type="file" onchange="ValidateSingleInput(this);"/> <span
								class="input-group-btn">
								<button class="btn btn-success btn-add" type="button">
									<span class="glyphicon glyphicon-plus"></span>
								</button>
							</span>
							

						</div>
					</div>

					<div class="form-group" style="padding-top: 20px; width: 50%">
						<label><h4 class="my-4" id="activity-details-title">Select
								Date</h4></label>
						<form:input path="date" type="date" id="activity-form-date"
							name="date" placeholder="Enter the activity name"
							class="form-control" />
						<form:errors path="date" class="text-danger" />
						
					</div>

					<div class="form-group" style="width: 50%">
						<label><h4 class="my-4" id="activity-details-title">Select
								Place</h4></label>
						<form:input path="address" type="text" id="activity-form-address"
							placeholder="Enter the event address" class="form-control" />
					</div>

					<div>
						<iframe width="100%" height="250" frameborder="0" scrolling="no"
							marginheight="0" marginwidth="0" id="activity-form-map"
							src="https://maps.google.co.uk/maps?f=q&source=s_q&hl=en&geocode=&q=15+Springfield+Way,+Hythe,+CT21+5SH&aq=t&sll=52.8382,-2.327815&sspn=8.047465,13.666992&ie=UTF8&hq=&hnear=15+Springfield+Way,+Hythe+CT21+5SH,+United+Kingdom&t=m&z=14&ll=51.077429,1.121722&output=embed"></iframe>
					</div>

					<div class="form-group text-right"
						style="padding-top: 10px; padding-right: 10px;">
						<input class="btn btn-success" type="submit"
							value="Create Activity" id="activity-form-submit">
					</div>
				</div>

			</form:form>

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
						<li><a href="#">Team</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Terms and Conditions</a></li>
					</ul>
				</div>
				<div class="col-lg-2  col-md-2 col-sm-4 col-xs-12">
					<h4>For Parents</h4>
					<ul>
						<li><a href="#">Discover Activities</a></li>
						<li><a href="#">Manage your Activities</a></li>
					</ul>
				</div>
				<div class="col-lg-2  col-md-2 col-sm-4 col-xs-12">
					<h4>For Organizers</h4>
					<ul>
						<li><a href="#">Create Activities</a></li>
						<li><a href="#">Manage your Activities</a></li>
					</ul>
				</div>
				<div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 pull-right">
					<h4>Stay Up to Date</h4>
					<ul>
						<li>
							<div class="input-append newsletter-box text-center">
								<input type="text" class="full text-center"
									placeholder="example@email.com">

								<button class="btn  bg-gray" type="button">
									Join our newslater<i class="fa fa-long-arrow-right"> </i>
								</button>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!--/.row-->
		</div>
		<div class="footer-bottom">
			<div class="container">
				<p class="pull-left">Copyright 2017. All rights reserved.</p>
			</div>
		</div>
		</footer>
		<!--/.footer -->
	</div>

</body>
</html>