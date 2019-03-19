<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link rel="stylesheet" href="<c:url value="resources/css/nav.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/right.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/left.css" />" />
    
    <script src="<c:url value="resources/js/nav.js" />"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title>Hello, world!</title>
</head>
<body>
	<!-- Navigation bar static throughout all our pages, the search bar will probably be made bigger,
	need to add potentially bigger buttons, a hover effect, dynamic pill icon for notifications -->
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">PingU</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item pr-2 active">
					<a class="nav-link" href="#"><i class="fas fa-home"></i></a>
				</li>
				<li class="nav-item pr-2 active">
					<a class="nav-link" href="#"><i class="fas fa-user"></i></a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="#"><i class="fas fa-users"></i></a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2	 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</body>
</html>