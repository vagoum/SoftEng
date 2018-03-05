<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
<link rel="stylesheet" href="./css/index_search.css">
<link rel="stylesheet" href="./css/index_album.css">
<link rel="stylesheet" href="./css/index_footer.css">
<title>Little Explorers</title>
</head>

<body>
	
		<!-- Generic Navbar -->
		
	<sec:authorize access="!hasRole('ROLE_ORGANIZER') and !hasRole('ROLE_PARENT')">
		<div class="container side-bordering">

			<div class="row ">
				<div id="search_title" class="text-center">
					<p class="h3">For Generic Users</p>
				</div>
			</div>

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
								<li><a href="#">Explore Activities</a></li>
								<li><a href="#">Manage Activities</a></li>
								<li><a href="#">Profile</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">For
								Organizers<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Explore Activities</a></li>
								<li><a href="#">Create Activity</a></li>
								<li><a href="#">Manage Activities</a></li>
								<li><a href="#">Profile</a></li>
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
										<div class="col-md-12" >
											<form method="POST" class="form" role="form"
												action="/login" accept-charset="UTF-8" id="login-nav">

												<div class="form-group">
													<label class="sr-only" for="exampleInputEmail2">Welcome
														Back!</label>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputEmail2">Email
														address</label> <input type="email" class="form-control"
														name="email" placeholder="Email address" required>
												</div>
												<div class="form-group">
													<label class="sr-only" for="exampleInputPassword2">Password</label>
													<input type="password" class="form-control"
														placeholder="Password" required name="password">
												</div>
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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

		<div class="row ">
			<div id="search_title" class="text-center">
				<p class="h3">For Parents</p>
			</div>
		</div>

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
					<li><a href="#">Explore Activities</a></li>
					<li><a href="#">Manage Activities</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Welcome back,
							${pageContext.request.userPrincipal.name}</a></li>
				</ul>

			</div>
			</nav>
		</div>
	</div>
	</sec:authorize>

	<!-- Organizer Navbar -->
	<sec:authorize access="hasRole('ROLE_ORGANIZER')">
	<div class="container side-bordering">

		<div class="row ">
			<div id="search_title" class="text-center">
				<p class="h3">For Organizers</p>
			</div>
		</div>

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
					<li><a href="#">Explore Activities</a></li>
					<li><a href="#">Create Activity</a></li>
					<li><a href="#">Manage Activities</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Welcome back USERNAME</a></li>
				</ul>

			</div>
			</nav>
		</div>
	</div>
	</sec:authorize>

</body>
</html>