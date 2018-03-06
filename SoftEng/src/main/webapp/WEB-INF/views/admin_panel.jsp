<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">



<head>
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
<link rel="stylesheet" href="./css/admin_panel.css">
<link rel="stylesheet" href="./css/index_footer.css">

<!-- js files -->
<script type="text/javascript" src="./js/admin_panel-controller.js"></script>

<title>Little Explorers</title>
</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<div class="navbar-brand">
				<h2>Welcome Back Admin</h2>
			</div>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Admin User<b class="fa fa-angle-down"></b></a>
		</ul>

		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a href="admin_panel.html?manage=parents"><i
						class="fa fa-fw fa-user-plus"></i>Parents</a></li>
				<li><a href="admin_panel.html?manage=organizers"><i
						class="fa fa-fw fa-user-plus"></i>Organizers</a></li>
			</ul>
		</div>
		</nav>
		<c:set var="uc" value="${user_class}" />
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row" id="main">
					<div class="col-sm-12 col-md-12 well" id="content">
						<c:choose>
							<c:when test="${uc == 0}">
								<h3>Manage Parent Roles</h3>
							</c:when>
							<c:otherwise>
								<h3>Manage Organizer Roles</h3>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">

				<div class="col-md-12">
					<div class="table-responsive">
						<table id="mytable" class="table table-bordred table-striped">
							<c:choose>
								<c:when test="${uc == 0}">
									<thead>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Address</th>
										<th>Email</th>
										<th>Contact</th>
										<th>Block/Unblock</th>
										<th>Delete</th>
										<th>Password Reset</th>
									</thead>
								</c:when>
								<c:otherwise>
									<thead>
										<th>Company Name</th>
										<th>Email</th>
										<th>Address</th>
										<th>Contact</th>
										<th>Block/Unblock</th>
										<th>Password Reset</th>										
										<th>Verify</th>
									</thead>
								</c:otherwise>
							</c:choose>
							<tbody>
									<c:choose>
										<c:when test="${uc == 0}">
											<c:forEach items="${userList}" var="user">
												<tr>
												<td id="user_first-name">${user.firstName}</td>
												<td id="user_last-name">${user.lastName}</td>
												<td id="user_address">${user.location.address}</td>
												<td id="user_email">${user.email}</td>
												<td id="user_phone">${user.phone}</td>
												<td>
													<!-- Block Button -->
													<p data-placement="top" data-toggle="tooltip" title="Block">
														<button class="btn btn-warning btn-sm" id="block_btn"
															data-title="Block" data-toggle="modal"
															data-target="#block">
															<c:choose>
															<c:when test="${user.blocked}">
																<span class="glyphicon glyphicon-ok"></span>														
															</c:when>
															<c:otherwise>
																<span class="glyphicon glyphicon-ban-circle"></span>
															</c:otherwise>
															</c:choose>
														</button>
													</p>
												</td>

												<td>
													<!-- Delete Button -->
													<p data-placement="top" data-toggle="tooltip"
														title="Delete">
														<button class="btn btn-danger btn-sm" id="delete_btn"
															data-title="Delete" data-toggle="modal"
															data-target="#delete">
															<span class="glyphicon glyphicon-trash"></span>
														</button>
													</p>
												</td>

												<td>
													<!-- Password Reset Button -->
													<p data-placement="top" data-toggle="tooltip" title="Reset">
														<button class="btn btn-info btn-sm" id="reset_btn"
															data-title="Reset" data-toggle="modal"
															data-target="#reset">
															<span class="glyphicon glyphicon-refresh"></span>
														</button>
													</p>
												</td>
											</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach items="${userList}" var="user">
											<tr>
												<td id="user_company_name">${user.companyName}</td>
												<td id="user_email">${user.email}</td>
												<td id="user_address">${user.location.address}</td>									
                                                <td id="user_phone">${user.phone}</td>
												<td>
													<!-- Block Button -->
													<p data-placement="top" data-toggle="tooltip" title="Block">
														<button class="btn btn-warning btn-sm" id="block_btn"
															data-title="Block" data-toggle="modal"
															data-target="#block">
															<c:choose>
															<c:when test="${user.blocked}">
																<span class="glyphicon glyphicon-ok"></span>														
															</c:when>
															<c:otherwise>
																<span class="glyphicon glyphicon-ban-circle"></span>
															</c:otherwise>
															</c:choose>
														</button>
													</p>
												</td>

												<td>
												
													<!-- Password Reset Button -->
													<p data-placement="top" data-toggle="tooltip" title="Reset">
														<button class="btn btn-info btn-sm" id="reset_btn"
															data-title="Reset" data-toggle="modal"
															data-target="#reset">
															<span class="glyphicon glyphicon-refresh"></span>
														</button>
													</p>
												</td>												

												<td>
													<!-- Verify Button -->
													<p data-placement="top" data-toggle="tooltip"
														title="Verify">
														<c:if test="${!user.verified}">
														<button class="btn btn-success btn-sm" id="verify_btn"
															data-title="Verify" data-toggle="modal"
															data-target="#verify">
															<span class="glyphicon glyphicon-ok"></span>
														</button>														
														</c:if>
													</p>
												</td>

												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
							</tbody>

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>