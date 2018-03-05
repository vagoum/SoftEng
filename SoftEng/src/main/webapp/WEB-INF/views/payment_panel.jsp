
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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

<!-- CSS files -->
<link rel="stylesheet" href="./css/index_carousel.css">
<link rel="stylesheet" href="./css/payment_panel.css">
<link rel="stylesheet" href="./css/index_footer.css">


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
    
	<!-- Payment -->
	<div class="container side-bordering">
		<div class="row">
			<div class="col-xs-12 col-md-4 col-md-offset-4 text-center">
				<h3 id="panel-title">Complete your Payment</h3>
				<h4>1€ = 1 point</h4>
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