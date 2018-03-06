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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!-- Bootstrap core -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<!-- CSS files -->
		<link  rel="stylesheet" href="./css/validation.css">
	<link  rel="stylesheet" href="./css/index_carousel.css">
	<link  rel="stylesheet" href="./css/activity_create.css">
	<link  rel="stylesheet" href="./css/index_footer.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
<!-- Date and Time picker Core -->	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
	<!-- js files -->
		<script type="text/javascript" src="./js/index-map.js"></script>

	<script type="text/javascript" src="./js/activity_create-controller.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	<script type="text/javascript" src="./js/registration-controller.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUJOMB6wHxG1D4Y1ZCl3TXlH0NptQ8PWk&libraries=places"></script>
<script type="text/javascript" src="./js/jqeury.validate.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<title>Little Explorers</title>
</head>

<body>
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

		<div class="row ">
			<div id="search_title" class="text-center">
				<p class="h3">Create a new Activity</p>
			</div>
		</div>

		<div class="row">
			<form id="activity-form" action="activities/create.jsp" method="post" role="form" style="display: block;">

				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="col-6 form-group">
						<label><h4 class="my-4" id="activity-details-title">Activity Title</h4></label>
						<input type="text" class="form-control" id="activity-form-title" name="activity_title" placeholder="Enter the activity name" required onkeypress="if (event.keyCode ==13) {return false;}">
					</div>

					<div class="form-group" style="padding-top: 10px;">
						<label><h4 class="my-3">Activity Description</h4></label>
						<textarea type="text" class="form-control" id="activity-form-description" name="activity_description" placeholder="Enter the activity description" rows="3"></textarea required>
					</div>

					<div class="form-group" style="padding-top: 10px; margin-left: -14px; margin-right: -10px;">
						<div class="col-sm-4">
							<label><h4 class="my-3">Minimum age</h4></label>
							<input type="number" class="form-control" id="activity-form-age_min" name="age_min" style="width:160px" placeholder="3" required onkeypress="if (event.keyCode ==13) {return false;}">
						</div> 

						<div class="col-sm-4">
							<label><h4 class="my-3">Maximum age</h4></label>
							<input type="number" class="form-control" id="activity-form-age_max" name="age_max" style="width:160px" placeholder="16" required onkeypress="if (event.keyCode ==13) {return false;}">
						</div>
					</div>
					
					<div class="form-group" style="padding-top: 20px; margin-left: -15px; margin-right: -10px;">
						<div class="col-sm-4">
							<label><h4 class="my-3">Number of Tickets</h4></label>
							<input type="number" class="form-control" id="activity-form-ticket_number" name="ticket_number" style="width:160px" placeholder="100" required onkeypress="if (event.keyCode ==13) {return false;}">
						</div> 

						<div class="col-sm-4">
							<label><h4 class="my-3">Ticket Price</h4></label>
							<input type="number" class="form-control" id="activity-form-ticket_price" name="ticket_price" style="width:160px" placeholder="10" required onkeypress="if (event.keyCode ==13) {return false;}">
						</div>

						<div class="col-sm-4">
							<h4 class="my-3" style="padding-bottom: 5px;">Select Category</h4>

							<div class="btn-group pull-left" id="categories_group">
							  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" id="activity_categories-list" role="menu">
							<c:forEach items="${categories}" var="category">
								
							    <li class="activity_list-item">
									<div class="pretty p-icon p-round p-smooth">
								        <input type="radio" name="icon_solid"/>
								        <div class="state p-success">
								            <i class="icon glyphicon glyphicon-ok"></i>
								            <label>${category}</label>
								        </div>
								    </div>
							    </li>
							</c:forEach>
							  </ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<h4 class="my-4" id="activity-photos-title">Select and Upload your photos</h4>
				
						<div class="controls">
							<div class="entry input-group col-xs-3" style="padding-bottom: 7px;">

								<input class="btn btn-primary" name="photo_file" type="file" accept="image/*" onkeypress="if (event.keyCode ==13) {return false;}"/>
								<span class="input-group-btn">
									<button class="btn btn-success btn-add" type="button">
										<span class="glyphicon glyphicon-plus"></span>
									</button>
								</span>

							</div>
						</div>

					<div class="form-group" style="padding-top: 20px; width: 50%">
						<label><h4 class="my-4" id="activity-date-title">Select Date & Time</h4></label>
						<div class="form-group">
				            <div class='input-group date' id='datetimepicker'>
				                <input type='text' class="form-control" id="activity-form-date" name="date" required onkeypress="if (event.keyCode ==13) {return false;}">
				                <span class="input-group-addon">
				                    <span class="glyphicon glyphicon-calendar">
				                    </span>
				                </span>
				            </div>
				        </div>
				     </div>

					<div class="form-group" style="width: 50%">
						<label><h4 class="my-4" id="activity-address-title">Select Place</h4></label>
						<input type="text" class="form-control pac-input" id="activity-form-address" name="address" placeholder="Enter the event address" required onkeypress="if (event.keyCode ==13) {return false;}">
					</div>
					<div class="map"></div>	

					<div class="form-group text-right" style="padding-top: 10px; padding-right: 10px;">
						<button class="btn btn-success" id="activity-form-submit">Create Activity</button>
					</div>
				</div>

			</form>

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