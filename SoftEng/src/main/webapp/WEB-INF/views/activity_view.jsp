<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
<link rel="stylesheet" href="./css/activity_view.css">
<link rel="stylesheet" href="./css/index_footer.css">

<!-- js files -->
<script type="text/javascript" src="./js/activity_view-controller.js"></script>
<script type="text/javascript"
	src="./js/activity_view-calendar_controller.js"></script>

<title>Little Explorers</title>
</head>

<body>
	<!-- Carousel -->
	<div class="container">
		<div class="row">
			<div id="myCarousel" class="carousel slide" data-ride="carousel"
				data-interval="10000">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item">
						<img class="second-slide"
							src="https://www.w3schools.com/w3images/workbench.jpg"
							alt="Second slide" style="width: 100%;">
						<div class="carousel-caption">
							<h3>For Parents</h3>
							<p>Explore Amazing Activies</p>
						</div>
					</div>

					<div class="item">
						<img class="third-slide"
							src="https://www.w3schools.com/w3images/coffee.jpg"
							alt="Third slide" style="width: 100%;">
						<div class="carousel-caption">
							<h3>For Activity Organizers</h3>
							<p>Create great experiences and adventures for amazing
								customers</p>
						</div>
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>

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
							<ul class="dropdown-menu"
								style="padding: 15px; min-width: 250px;">
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
		<div class="row">
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<h3 class="my-4" id="activity-details-title">${activity.name}</h3>

				<div>
					<!-- class="col-md-4" -->
					<h4 class="my-3" style="padding-top: 20px;">Activity
						Description</h4>
					<hr>
					<div id="activity-details-text">
						${activity.activityDescription}</div>

					<h4 class="my-3" style="padding-top: 20px;">Activity Details</h4>
					<hr>
					<ul id="activity-details-list">
						<li>Lorem Ipsum</li>
						<li>${activity.category}</li>
					</ul>
					<br>
					<div
						class="col-xl-8 col-lg-8 col-md-10 col-sm-12 col-xs-12 activity-tickets">
						<h4 class="x-price" id="activity-details-price">Price per
							Ticket: ${activity.cost} Activity Points</h4>

						<form action="/activities/book.jsp" method="post"
							id="booking_form">
							<label for="proirty">Number of Tickets:</label> <input
								type="number" class="form-control" id="activity-details-tickets"
								name="ticket_price" min="1" max="50" placeholder="2" required
								style="width: 60px; display: inline-block;">
							<button type="submit" form="booking_form" class="btn btn-success"
								id="activity-details-book-btn" style="margin-left: 15px;">Book
								Now</button>
						</form>
					</div>
				</div>
			</div>

			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div
					class="col-xl-8 col-lg-9 col-md-10 col-sm-10 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-1 col-sm-offset-1">

					<div class="row">
						<div class="carousel slide main-carousel" id="main-carousel">

							<!-- Main Carousel items -->
							<div class="carousel-inner main-carousel-inner">
								<div class="main-carousel-item item active"
									data-slide-number="0">
									<img src=${thumbnail.url}>
								</div>
								<c:forEach var="photo" items="${photos}" varStatus="loop">

									<div class="main-carousel-item item" data-slide-number=${loop.index}>
										<img src=${photo.url}>
									</div>

								</c:forEach>
							</div>

							<!-- Main Carousel nav -->
							<a class="left carousel-control" href="#main-carousel"
								role="button" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control" href="#main-carousel"
								role="button" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

					<div class="row">
						<div class="carousel slide thumbnail-carousel"
							id="thumbnail-carousel">

							<!-- Thumbnail Carousel items -->
							<div class="carousel-inner thumbnail-carousel-inner">

								<div class="thumbnail-carousel-item item active">
									<div class="row">
										<div class="col-md-4 col-xs-4">
											<a class="thumbnail" href=""><img alt=""
												src=${thumbnail.url}></a>
										</div>
										<c:forEach var="photo" items="${photos}" varStatus="loop">
											<div class="col-md-4 col-xs-4">
											<a class="thumbnail" href=""><img alt=""
												src==${photo.url}></a>
										</div>
										</c:forEach>
									</div>
								</div>

							<!-- Thumbnail Carousel nav -->
							<a class="left carousel-control" href="#thumbnail-carousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#thumbnail-carousel" data-slide="next">›</a>

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row event-address-date">
			<h4>Event Date & Address</h4>
			<div
				class="col-xl-2 col-lg-3 col-md-3 col-sm-4 col-xs-12 well pull-right-lg"
				style="border: 0px solid">
				<div class="calendar-wrapper">
					<div id="calendar" data-year="${year}" data-month="${month}"
						data-day="${day}"></div>
				</div>
				<br>
				<h4>Time: ${activity.time}</h4>
			</div>

			<div
				class="col-xl-2 col-lg-3 col-md-3 col-sm-3 col-xs-12 col-xl-offset-2">
				<address class="event-address">
					<h3>Snail mail</h3>
					<strong>Hythe Window Cleaning</strong><br> ${location.address}<br>
					Hythe<br> Kent<br> United Kingdon<br> CT21 5SH<br>
					<abbr title="Phone">P:</abbr> 01234 567 890
				</address>
			</div>

			<div class="col-xl-8 col-lg-6 col-md-6 col-sm-5 col-xs-12">
				<iframe width="100%" height="250" frameborder="0" scrolling="no"
					marginheight="0" marginwidth="0"
					src="https://maps.google.com/maps?q=${location.latitude},${location.longtitude}&hl=es;z=14&output=embed"
					style="padding-left: 0px;"></iframe>
			</div>
		</div>

		<div class="row">
			<div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-xs-12">
				<div class="card card-outline-secondary organizer-details">
					<div class="card-header">
						<h4>About The Organizer:</h4>
						<h4 id="organizer-details-name"></h4>
					</div>
					<hr>
					<div class="card-body" id="organizer-details-text">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
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