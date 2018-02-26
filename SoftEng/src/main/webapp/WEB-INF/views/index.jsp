<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
	<link  rel="stylesheet" href="./css/index_search.css">
	<link  rel="stylesheet" href="./css/index_album.css">
	<link  rel="stylesheet" href="./css/index_footer.css">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">

	<!-- js files -->
	<script type="text/javascript" src="./js/index-controller.js"></script>
	<script type="text/javascript" src="./js/index-sliders.js"></script>

	<title>Little Explorers</title>
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

					<div class="item active">
						<img class="first-slide" src="https://www.w3schools.com/w3images/workbench.jpg" alt="First slide" style="width:100%;">
						<div class="carousel-caption">
							<h3>Little Explorers</h3>      
							<p>Adventures For Our Little Friends</p>
						</div>
					</div>

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
											<form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
												<div class="form-group">
													<label class="sr-only" for="exampleInputEmail2">Welcome Back!</label>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputEmail2">Email address</label>
													<input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputPassword2">Password</label>
													<input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
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

		<div class="row ">
			<div id="search_title" class="text-center">
				<p class="h3">Explore Adventures for our little friends near you</p>
			</div>
		</div>

		<!-- Search -->
		<div class="row">
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
				<div id="search-box"> 
					<form id="search-form" method="post">
						<fieldset>
							<input id='search-text' name='q' placeholder='Search' type='text'/>
							<button id='search-button' type='button'>                     
								<span>Search</span>
							</button>
						</fieldset>
					</form>
				</div>
			</div>

			<div id="search_criteria" class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">

				<div class="slider_container row">
					<div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-4" style="margin-left: -15px;">
						<label for="proximity_slider" class="slider_label">Proximity:</label>
					</div>
					<div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-xs-8">
						<input class="slider_range" id="proximity_slider" type="range" value="0" min="0" max="100" name="proximity_slider">
						<output for="proximity_slider" onforminput="value=proximity_slider.valueAsNumber;"></output>
					</div>
				</div>

				<div class="slider_container row">
					<div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-4" style="margin-left: -15px;">
						<label for="age_slider" class="slider_label">Age:</label>
					</div>
					<div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-xs-8">
						<input class="slider_range" id="age_slider-min" type="range" value="0" min="0" max="12" name="age_slider-min">
						<output for="age_slider-min" onforminput="value=age_slider-min.valueAsNumber;"></output>

						<input class="slider_range slider_double" id="age_slider-max" type="range" value="12" min="0" max="12" name="age_slider-max">
						<output for="age_slider-max" onforminput="value=age_slider-max.valueAsNumber;"></output>
					</div>
				</div>

				<div class="slider_container row">
					<div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-xs-4" style="margin-left: -15px;">
						<label for="cost_slider" class="slider_label">Cost:</label>
					</div>
					<div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-xs-8">
						<input class="slider_range" id="cost_slider-min" type="range" value="0" min="0" max="100" name="cost_slider-min">
						<output for="cost_slider-min" onforminput="value=cost_slider-min.valueAsNumber;"></output>

						<input class="slider_range slider_double" id="cost_slider-max" type="range" value="100" min="0" max="100" name="cost_slider-max">
						<output for="cost_slider-max" onforminput="value=cost_slider-max.valueAsNumber;"></output>
					</div>
				</div>
			</div>

			<div id="search_criteria" class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
				<div class="row">
					<div class="col-xl-6 col-lg-6 col-md-8 col-sm-10 col-xs-12">
						Sort By:
						<div id="sorting_tabs" class="btn-group"  data-toggle="buttons">
							<label class="btn btn-outline-info active sorting_btn">
						  		<input type="radio" name="options" id="Proximity" autocomplete="off" checked>Proximity
						  	</label>
						  	<label class="btn btn-outline-info sorting_btn">
						    	<input type="radio" name="options" id="Age" autocomplete="off">Age
						  	</label>
						  	<label class="btn btn-outline-info sorting_btn">
						    	<input type="radio" name="options" id="Cost" autocomplete="off">Cost
						  	</label>
						</div>
					</div>

					<div class="col-xl-1 col-lg-1 col-md-1 col-sm-2 col-xs-12 col-xl-offset-3 col-lg-offset-3 col-md-offset-1">
						<div class="btn-group pull-left" id="categories_group">
				          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				            Categories <span class="caret"></span>
				          </button>
				          <ul class="dropdown-menu" id="activity_categories-list" role="menu">

				            <li class="activity_list-item">
								<div class="pretty p-icon p-round p-smooth">
							        <input type="checkbox"/>
							        <div class="state p-success">
							            <i class="icon glyphicon glyphicon-ok"></i>
							            <label>Aquatics</label>
							        </div>
							    </div>
				            </li>

				            <li class="activity_list-item">
								<div class="pretty p-icon p-round p-smooth">
							        <input type="checkbox"/>
							        <div class="state p-success">
							            <i class="icon glyphicon glyphicon-ok"></i>
							            <label>Camps</label>
							        </div>
							    </div>
				            </li>

				            <li class="activity_list-item">
								<div class="pretty p-icon p-round p-smooth">
							        <input type="checkbox"/>
							        <div class="state p-success">
							            <i class="icon glyphicon glyphicon-ok"></i>
							            <label>Dance</label>
							        </div>
							    </div>
				            </li>

				          </ul>
				        </div>
					</div>

				</div>
			</div>
		</div>

		<!-- Activities -->
		<div class="row">
			<div class="activities">
				<c:forEach items="${activityDetails}" var="activity">
					<div class="col-xl-2 col-lg-3 col-md-3 col-sm-4 col-xs-12">
						<div class="card">
							<div class="card-header bg-transparent">
								<h4>${activity.name}</h4>
							</div>
							<div class="card-body">
								<img class="card-photo" src="${activity.thumbNail.url}">
								<p class="card-text">
									${activity.activityDescription}
								</p>
							</div>
							<div class="card-footer">
								<a href="/activity_view?id=${activity.activityId }" class="blue-button">Learn More</a>
							</div>
						</div>
					</div>
            	</c:forEach>
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