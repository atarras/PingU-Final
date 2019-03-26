<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"/>
		
	    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>"/>
	    <link rel="stylesheet" href="<c:url value='/resources/css/profile.css'/>"/>
	    
		
	</head>
	<jsp:include page="nav.jsp" />
	<body>
	  	<div class="container main-body">
			<jsp:include page="left.jsp" />
			<div class="container content">
				<div class="container left-form">
					<div class="card" style="width: 80%;">
						<div class="card-body">
							<h5 class="card-title">${profileUser.getFirstName()} ${profileUser.getLastName()}</h5>
						</div>
						<i class="fas fa-user-circle fa-10x"></i>
						<div class="card-body">
							<div id="edit-box">
								<h5 class="card-title">Developer: ${profileUser.getGroup().getGroupName().getName() } 
								<button class="btn btn-primary" id="role-title-submit" name="Submit-Description">Submit</button>
								<a href="#" id="role-title-button"><i class="far fa-edit user-edit"></i></a>
								</h5>
							</div>
							<div>
								<a href="#" id="description-button"><i class="far fa-edit user-edit"></i></a>
								<p id="description-text" class="card-text">
									${profileUser.getDescription() }
								</p>
								<button class="btn btn-primary" id="description-submit" name="Submit-Description" >Submit</button>
							</div>
							<div>	
								<p id="group-text" class="card-text">
									${profileUser.getGroup().getGroupName().getName() }
								</p>
								<a href="#" id="linkedin-link">${profileUser.getLinkedInUrl() }</a><a href="#" id="linkedin-button"><i class="far fa-edit user-edit"></i></a>
								<button class="btn btn-primary" id="linkedin-submit" name="Submit-Description">Submit</button>
							</div>
						</div>
					</div>
				</div>
				<div class="container right-form">
					<form class="form personal-info" action="${profileUser.getUserId() }" method="POST" id="registrationForm">
						<div class="form-group">
							<div class="form-group">
								<div class="col-xs-4">
									<label for="country"><h4>Country</h4></label>
									<p id="country">${profileUser.getCountry() }</p>
									<!--  <input type="text" class="form-control" name="country" id="countryInput" placeholder="${profileUser.getCountry() }" title="Your current country.">-->
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-4">
								<label for="city"><h4>City</h4></label>
								<p id="city">${profileUser.getCity() }</p>
								<!-- <input type="city" class="form-control" name="city" id="cityInput" placeholder="${profileUser.getCity() }" title="Your currrent city.">-->
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-4">
								<label for="phone"><h4>Phone</h4></label>
								<p id="phone">${profileUser.getPhoneNumber() }</p>
								<!--  <input type="phone" class="form-control" name="phone" id="phoneInput" placeholder="${profileUser.getPhoneNumber()}" title="Your phone number.">-->
							</div>
						</div>
						
						<div class="form-group">
							<a id="edit-button" href="#"><i class="fas fa-edit fa-2x" title="Edit fields."></i></a>
							<div class="col-xs-8">
								<button id="form-submit" class="btn btn-lg btn-success personal-button" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Submit</button>
								<button id="form-reset" class="btn btn-lg personal-button" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
							</div>
						</div>
	              	</form>
					<div class="accordion" id="searchAccordion">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#searchAccordion" href="#collapseOne">Password and Security  <i class="far fa-edit"></i></a>
							</div>
							<c:if test="${sessionScope.successPassword}">
                   				<div class="error-message">Password updated successfully.</div>
                			</c:if>
                			<c:if test="${sessionScope.samePassword}">
                   				<div class="error-message">Please enter a new password.</div>
                			</c:if>
                			<c:if test="${sessionScope.errorPassword}">
                   				<div class="error-message">Invalid current password.</div>
                			</c:if>
                			<c:if test="${sessionScope.newAnswer}">
                   				<div class="error-message">Security Answer is updated successfully.</div>
                			</c:if>
							<div id="collapseOne" class="accordion-body collapse in">
								<div class="accordion-inner">
									<form class="form security" action="password" method="POST" id="securityForm">
										<div class="form-group">
											<div class="form-group">
												<div class="col-xs-4">
													<label for="current-password"><h4>Current Password</h4></label>
													<!--<p id="country">Default Country</p>-->
													<input type="password" class="form-control" name="current-password" id="current-password" placeholder="Old Password" title="Your old password.">
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-4">
												<label for="new-password"><h4>New Password</h4></label>
												<!--<p id="city">Default City</p>-->
												<input type="password" class="form-control" id="new-password" name="new-password" placeholder="New Password" title="Your new password.">
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-4">
												<label for="confirm-password"><h4>Confirm New Password</h4></label>
												<!--<p id="phone">Default Phone	</p>-->
												<input type="password" class="form-control" name="confirm-password" id="confirm-password" placeholder="Confirm New Password" title="Your new password confirmation.">
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
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script src="<c:url value="/resources/js/profile.js" />"></script>
	</body>
</html>