<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<script type="text/javascript" src="./js/payment_panel-controller.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- CSS files -->
<link rel="stylesheet" href="./css/index_carousel.css">
<link rel="stylesheet" href="./css/payment_panel.css">
<link rel="stylesheet" href="./css/index_footer.css">


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
							src="http://192.241.175.50/videos/boston.jpg" alt="First slide"
							style="width: 100%;">
						<div class="carousel-caption">
							<h3>Little Explorers</h3>
							<p>Adventures For Our Little Friends</p>
						</div>
					</div>

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

	<!-- Payment -->
	<div class="container side-bordering">
		<div class="row">
			<div class="col-xs-12 col-md-4 col-md-offset-4 text-center">
				<h3 id="panel-title">Complete your Payment</h3>
			</div>
			<div class="col-xs-12 col-md-4 col-md-offset-4">
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table" >
						<div class="row display-tr" >
							<h3 class="panel-title display-td">Payment Details</h3>
							<div class="display-td" >                            
								<img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
							</div>
						</div>                    
					</div>
					<div class="panel-body">
						<form id="payment-form">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="cardNumber">CARD NUMBER</label>
										<div class="input-group">
											<input type="tel" class="form-control" name="cardNumber" placeholder="Valid Card Number" autocomplete="cc-number"required autofocus/>
											<span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
										</div>
									</div>                            
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
										<input 
										type="date" 
										class="form-control" 
										name="cardExpiry"
										placeholder="MM / YY"
										autocomplete="cc-exp"
										required 
										/>
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label for="cardCVC">CV CODE</label>
										<input type="number" 
										class="form-control"
										name="cardCVC"
										placeholder="CVC"
										autocomplete="cc-csc"
										min="0"
										max="999"
										required
										/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="couponCode">NUMBER OF POINTS</label>
										<input type="number" class="form-control" name="number_of_points" min="1" max="1000" required/>
									</div>
								</div>                        
							</div>
							<div class="row">
								<div class="col-xs-12">
									<button type="submit" class="subscribe btn btn-success btn-lg btn-block" type="button" >Complete Payment</button>
								</div>
							</div>
							<div class="row" style="display:none;">
								<div class="col-xs-12">
									<p class="payment-errors"></p>
								</div>
							</div>
						</form>
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
									Join our newsletter<i class="fa fa-long-arrow-right"> </i>
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