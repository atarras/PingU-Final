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
	    <link rel="stylesheet" href="<c:url value="resources/css/profile.css"/>"/>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<jsp:include page="nav.jsp" />
	<body>
	  	<div class="container main-body">
			<jsp:include page="left.jsp" />
			<div class="container content">
				<div class="container left-form">
					<div class="card" style="width: 80%;">
						<div class="card-body">
							<h5 class="card-title">John Doe</h5>
						</div>
						<i class="fas fa-user-circle fa-10x"></i>
						<div class="card-body">
							<h5 class="card-title">Developer: FDM GROUP <i class="far fa-edit user-edit"></i></h5>
							<i class="far fa-edit user-edit"></i>
							<p class="card-text">
							John Doe is the standard name for a person that is
							unidentified.
						
							</p>
							<p class="card-text">
							Trainee Group
							</p>
							<a href="#">Link to a linkedin</a><i class="far fa-edit user-edit"></i>
						</div>
					</div>
				</div>
				<div class="container right-form">
					<form class="form personal-info" action="#" method="post" id="registrationForm">
						<div class="form-group">
							<div class="form-group">
								<div class="col-xs-4">
									<label for="country"><h4>Country</h4></label>
									<!--<p id="country">Default Country</p>-->
									<input type="text" class="form-control" name="country" id="country" placeholder="Country" title="Your current country.">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-4">
								<label for="city"><h4>City</h4></label>
								<!--<p id="city">Default City</p>-->
								<input type="city" class="form-control" id="city" placeholder="City" title="Your currrent city.">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-4">
								<label for="phone"><h4>Phone</h4></label>
								<!--<p id="phone">Default Phone	</p>-->
								<input type="phone" class="form-control" name="phone" id="phone" placeholder="Phone Number" title="Your phone number.">
							</div>
						</div>
						
						<div class="form-group">
							<i id="edit-button" class="fas fa-edit fa-2x" title="Edit fields."></i>
							<div class="col-xs-8">
								<button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Sumbit</button>
								<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
							</div>
						</div>
	              	</form>
					<div class="accordion" id="searchAccordion">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#searchAccordion" href="#collapseOne">Password and Security  <i class="far fa-edit"></i></a>
							</div>
							<div id="collapseOne" class="accordion-body collapse in">
								<div class="accordion-inner">
									<form class="form security" action="#" method="post" id="securityForm">
										<div class="form-group">
											<div class="form-group">
												<div class="col-xs-4">
													<label for="old-password"><h4>Current Password</h4></label>
													<!--<p id="country">Default Country</p>-->
													<input type="password" class="form-control" name="old-password" id="old-password" placeholder="Old Password" title="Your old password.">
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-4">
												<label for="new-password"><h4>New Password</h4></label>
												<!--<p id="city">Default City</p>-->
												<input type="password" class="form-control" id="new-password" placeholder="New Password" title="Your new password.">
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-4">
												<label for="new-password"><h4>Confirm New Password</h4></label>
												<!--<p id="phone">Default Phone	</p>-->
												<input type="password" class="form-control" name="new-password" id="new-password" placeholder="Confirm New Password" title="Your new password confirmation.">
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-4">
												<label for="security-answer"><h4>New Security Answer</h4></label>
												<!--<p id="phone">Default Phone	</p>-->
												<input type="text" class="form-control" name="security-answer" id="security-answer" placeholder="Security answer" title="Your new security answer.">
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-8">
											<br>
												<button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Sumbit</button>
												<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
											</div>
										</div>
									</form>
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