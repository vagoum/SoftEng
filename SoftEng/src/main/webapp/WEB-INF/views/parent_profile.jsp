<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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
<link rel="stylesheet" href="./css/activity_view.css">
<link rel="stylesheet" href="./css/index_footer.css">
<link rel="stylesheet" href="./css/organizer_manage.css">

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

		<div class="row">
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">

				<h3 class="my-4" id="activity-details-title">Welcome:
					${parent.firstName} ${parent.lastName}</h3>

				<hr>
				<form action="users/changepassword.jsp" method="get"
					id="reset-pass_form">
					<label for="proirty">Change Password: </label>

					<button type="submit" form="reset-pass_form"
						class="btn btn-success" id="activity-details-book-btn"
						style="margin-left: 15px;">Change Password</button>
				</form>
				<hr>

				<h4 class="x-price" id="activity-details-price">Current Point
					Balance: ${parent.balance }</h4>

				<form action="/payment" method="get"
					id="booking_form">
					<label for="proirty">Add Points:</label>

					<button type="submit" form="booking_form" class="btn btn-success"
						id="activity-details-book-btn" style="margin-left: 15px;">More
						Points!</button>
				</form>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<figure class="pull-right">
					<img class="media-object img-rounded img-responsive activy-image"
						src="http://placehold.it/350x250">
				</figure>
			</div>
		</div>
		<br>

		<!-- Booked Activities -->
		<div class="row">
			<div class="well">
				<h1 class="text-center">Scheduled Activities</h1>
				<div class="list-group">
					<c:forEach var="activity" items="${scheduledBookings}">

						<div class="list-group-item">
							<div class="media col-md-3">
								<figure class="pull-left">
									<img
										class="media-object img-rounded img-responsive activy-image"
										src=${activity.thumbNail.url}>
								</figure>
							</div>
							<div class="col-md-6">
								<h3 class="list-group-item-heading activy-title">
									${activity.name}</h3>
								<p class="list-group-item-text activity-details">
									${activity.activityDescription}</p>
							</div>
							<div class="col-md-3 text-center">
								<a href="activity_view?id=${activity.activityId}" type="button" class="btn btn-success btn-lg btn-block book-btn">View</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<!-- Past Activities -->
		<div class="row">
			<div class="well">
				<h1 class="text-center">Past Activities</h1>
				<div class="list-group">

					<c:forEach var="activity" items="${completedBookings}">

						<div class="list-group-item">
							<div class="media col-md-3">
								<figure class="pull-left">
									<img
										class="media-object img-rounded img-responsive activy-image"
										src=${activity.thumbNail.url}>
								</figure>
							</div>
							<div class="col-md-6">
								<h3 class="list-group-item-heading activy-title">
									${activity.name}</h3>
								<p class="list-group-item-text activity-details">
									${activity.activityDescription}</p>
							</div>
							<div class="col-md-3 text-center">
							    <a href="/activity_view?id=${activity.activityId}" type="button" class="btn btn-success btn-lg btn-block book-btn">View</a>
							</div>
						</div>
					</c:forEach>

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