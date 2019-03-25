<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
		
	    <link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
		<link rel="stylesheet" href="<c:url value="resources/css/home.css"/>"/>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	<jsp:include page="nav.jsp" />
	<body>
	  <div class="container main-body">
	  	<jsp:include page="left.jsp" />
		<div class="container content">
			<h1 class="welcome-header">
			Welcome ${newUser.getFirstName() } ${newUser.getLastName() }
			</h1>
			<div class="message-content">
				<ul class="nav nav-tabs">
				  <li class="active"><a class="nav-link active" data-toggle="tab" href="#allmsg">All</a></li>
				  <li><a class="nav-link" data-toggle="tab" href="#usermsg">User</a></li>
				  <li><a class="nav-link" data-toggle="tab" href="#groupmsg">Group</a></li>
				</ul>
				<div class="tab-content">
					<div id="allmsg" class="tab-pane fade in active show container messages all">
					</div>
					<div id="usermsg" class="tab-pane fade container messages user">
					</div>
					<div id="groupmsg" class="tab-pane fade container messages group">
						<!--  Message template -->	
						<div class="media border pt-4 p-3">
							<a href="${found.getUserByID()}" ><i class="fas fa-user-circle fa-4x pr-3"></i></a>
							<div class="media-body">
								<h5 class="mt-0">Message</h5>
								<p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	    <jsp:include page="right.jsp" />  
	  </div>
	</body>
</html>