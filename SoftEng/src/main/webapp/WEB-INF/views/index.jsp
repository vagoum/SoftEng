
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
<link rel="stylesheet" href="./css/index_album.css">
<link rel="stylesheet" href="./css/index_footer.css">
<link rel="stylesheet" href="./css/index_map.css">
<link rel="stylesheet" href="./css/ion.rangeSlider.css" />
<link rel="stylesheet" href="./css/ion.rangeSlider.skinHTML5.css" />

<link rel="stylesheet" href="./css/index_search.css">


<!-- js files -->
<script type="text/javascript" src="./js/index-controller.js"></script>
<script type="text/javascript" src="./js/index-sliders.js"></script>
<script type="text/javascript" src="./js/index-map.js"></script>

<script type="text/javascript" src="./js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="./js/ion.rangeSlider.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUJOMB6wHxG1D4Y1ZCl3TXlH0NptQ8PWk&libraries=places"></script>

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

					<div class="item active">
						<img class="first-slide"
							src="./images/kids-for_organizers.jpg"
							alt="First slide" style="width: 100%;">
						<div class="carousel-caption">
							<h3>Little Explorers</h3>
							<p>Adventures For Our Little Friends</p>
						</div>
					</div>

					<div class="item">
						<img class="second-slide"
							src="./images/kids-for_parents_1.jpg"
							alt="Second slide" style="width: 100%;">
						<div class="carousel-caption">
							<h3>For Parents</h3>
							<p>Explore Amazing Activies</p>
						</div>
					</div>

					<div class="item">
						<img class="third-slide"
							src="./images/kids-for_parents_3.jpg"
							alt="Third slide" style="width: 100%;">
						<div class="carousel-caption">
							<h3>For Activity Organizers</h3>
							<p>Create great experiences and adventures for amazing
								customers</p>
						</div>
					</div>
					<div class="item">
						<img class="third-slide"
							src="./images/kids-for_parents_2.jpg"
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
	
	
	<input type="hidden" id="longtitude-id" value="${longtitude}">
	<input type="hidden" id="latitude-id" value="${latitude}">
	
	<!-- Content -->
	<div class="container side-bordering">

		<!-- Header -->
		<div class="row ">
			<div id="search_title" class="text-center">
				<p class="h3">Explore Adventures for our little friends near you</p>
			</div>
		</div>

		<div class="container">
            <div class="row">
                <div
                    class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
                    <div class="input-group" id="adv-search">
                        <input type="text" id="free-search-text" class="form-control" placeholder="Search for snippets" />
                        <div class="input-group-btn">
                            <div class="btn-group" role="group">
                                <div class="dropdown dropdown-lg">
                                    <button type="button" class="btn btn-lg btn-block dropdown-toggle" style="height:34px"
                                        data-toggle="dropdown" aria-expanded="false">
                                        <span class="caret"></span>
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-right" role="menu">
                                        <form class="form-horizontal" role="form">
                                            <div class="form-group" style="margin-bottom: 25px">
                                                <label for="sort">Sort by</label> <select id="select-sort"
                                                    class="form-control">
                                                    <option value="0" selected>No Sort</option>
                                                    <option value="1">Alphabetical Order</option>
                                                    <option value="3">Date</option>
                                                    <option value="4">Cost</option>
                                                </select>
                                            </div>
                                           
                                            <div class="form-group" style="margin-bottom: 25px">
                                                <label for="categories">Choose Category</label> <select id="select-category"
                                                    class="form-control">
                                                    <option value="0" selected>Select no category</option>
                                                    <c:forEach items="${categories}" var="category"  varStatus="loop">
                                                    
                                                    <option value="${loop.index}">${category }</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            
                                            <div class="slider_container row" style="margin-bottom: 25px">
                                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-4"
                                                    style="margin-left: -15px;padding-top: 20px">
                                                    <label for="proximity_slider" class="slider_label">
                                                    <font size="2" face="verdana" color="black">Radius(km)</font></label>
                                                </div>
                                                <div
                                                    class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-xs-8">
                                                    <input type="text" id="range_distance" value="" name="range_distance" />
                                                </div>
                                            </div>
                                            <div class="slider_container row" style="margin-bottom: 25px">
                                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-4"
                                                    style="margin-left: -15px;padding-top: 20px">
                                                    <label for="proximity_slider" class="slider_label">
                                                    <font size="2" face="verdana" color="black">Age range</font></label>
                                                </div>
                                                <div
                                                    class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-xs-8">
                                                    <input type="text" id="range_age" value="" name="range_age" />
                                                </div>
                                            </div>
                                           
                                            <div class="slider_container row" style="margin-bottom: 5px">
                                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-4"
                                                    style="margin-left: -15px;padding-top: 20px">
                                                    <label for="proximity_slider" class="slider_label">
                                                    <font size="2" face="verdana" color="black">Cost range</font></label>
                                                </div>
                                                <div style="margin-bottom: 5px"
                                                    class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-xs-8">
                                                    <input type="text" id="range_cost" value="" name="range_cost" />
                                                </div>
                                                <div class="form-group"></div>
                                             </div>
                                           	<li class="divider"></li>
                                           	
                                             <div class="slider_container row">     
                                             
                                                <button type="button" id="search_button1" style="width:100px;height:30px"
                                                name="search_button1" class="btn btn-primary">
                                                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                                </button>                
                                               	<input type="hidden">
											</div>
                                        </form>
                                    </div>
                                </div>
                                <button type="button" id="search_button2" style="height:34px" name="search_button2" class="btn btn-primary">
                                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

	<br>
		<!-- Activities -->
		<div class="row">
			<div class="activities"></div>
		</div>
	<br>
		<div class="row">
			<div class="map"></div>
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