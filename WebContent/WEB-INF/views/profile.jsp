<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
	    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>"/>
        <script src="<c:url value="resources/js/main.js" />"></script>
	    <link rel="stylesheet" href="<c:url value='/resources/css/profile.css'/>"/>
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script src="<c:url value="/resources/js/profile.js" />"></script>
		
	</head>
	<jsp:include page="nav.jsp" />
	<body>
	  	<div class="container main-body">
			<jsp:include page="left.jsp" />
			<div class="container content">
				<div class="container left-form">
					<div class="card" style="width: 80%;">
						<div class="card-body">
							<h5 class="card-title custom-title">${profileUser.getFirstName()} ${profileUser.getLastName()}</h5>
							<h5 class="card-title custom-title">Group: ${profileUser.getGroup().getGroupNameWithoutUnderscore() }</h5>
						</div>
							<!-- <svg class="user-svg" xmlns="http://www.w3.org/2000/svg" width="155" height="160" viewBox="0 0 12 16" preserveAspectRatio="xMidYMid meet">
								<path fill-rule="evenodd" d="M12 14.002a.998.998 0 0 1-.998.998H1.001A1 1 0 0 1 0 13.999V13c0-2.633 4-4 4-4s.229-.409 0-1c-.841-.62-.944-1.59-1-4 .173-2.413 1.867-3 3-3s2.827.586 3 3c-.056 2.41-.159 3.38-1 4-.229.59 0 1 0 1s4 1.367 4 4v1.002z"/>
							</svg> -->
                            <div class="profile-header-img center">
                              <img id="profile-pic" class="rounded-circle" src="https://thispersondoesnotexist.com/image">
                            </div>
						<div class="card-body">
							<form id="employer-request" class="form security" action="changeEmployerRequest" method="GET">
    							<input type="hidden" name="userID" value="${profileUser.getUserId()}"/>
                  
                                <div class="form-group">
                                  <!-- <input type="text" id="edit-consultant-employer" class="form-control edittable" name="employer" placeholder="Employer" /> -->
                                  
                                  <div id="edit-employer" style="display:none">
                                    <select id="edit-employer-text" class="form-control" name="newEmployer">
                                      <option value="">*** Select Option ***</option>
                                      <c:forEach items="${employers}" var="employer">
                                        <option value="${employer}">${employer}</option>
                                      </c:forEach>
                                    </select>
                                    <button type="submit" class="btn btn-primary" id="employer-submit">Request</button>
                                  </div>
                                  
                                  <div id="display-employer">
                                    <c:if test="${profileUser.getUserId() == newUser.getUserId() }">
                                      <c:if test="${newUser.getDiscriminatorValue() != 'Trainee'}">
                                        <a href="#" id="employer-button">
                                            <svg class="svg-pencil" xmlns="http://www.w3.org/2000/svg" width="14" height="16" viewBox="0 0 14 16">
                                                <path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/>
                                            </svg>
                                        </a>
                                      </c:if>
                                    </c:if>
        							<div class="card-title">Employer: <span id="employer-text"">${profileUser.getEmployer()}</span></div>
                                  </div>
                                </div>
                  
    							<c:if test="${sessionScope.successRequest}">
                  					<div class="success-message">Your request has been submitted.</div>
                    			</c:if>
                  				<c:if test="${sessionScope.errorRequest}">
                  					<div class="error-message">Your request had an issue, please consult an admin.</div>
               					</c:if>
							</form>
							<form id="edit-box role-request" class="form security" action="changeJobTitleRequest" method="GET">
								<input type="hidden" name="userID" value="${profileUser.getUserId()}"/>
							<c:if test="${profileUser.getUserId() == newUser.getUserId() }">
								<c:if test="${newUser.getDiscriminatorValue() != 'Trainee'}">
									<a href="#" id="role-button">
										<svg class="svg-pencil" xmlns="http://www.w3.org/2000/svg" width="14" height="16" viewBox="0 0 14 16">
											<path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/>
										</svg>
									</a>
								</c:if>
							</c:if>
								<p class="card-title role-text" id="role-text">Title: ${profileUser.getCurrentTitle()}</p>
								<button class="btn btn-primary" type="submit" id="role-submit" name="Submit-Description">Request</button>
								<c:if test="${sessionScope.successRoleRequest}">
                   					<div class="success-message">Your request has been submitted.</div>
                				</c:if>
                				<c:if test="${sessionScope.errorRoleRequest}">
                   					<div class="error-message">Your request had an issue, please consult an admin.</div>
                				</c:if>
							</form>
								<form id="edit-box decription-form" class="form security" action="description" method="POST">
									<input type="hidden" name="userID" value="${profileUser.getUserId()}"/>
								<c:if test="${profileUser.getUserId() == newUser.getUserId() }">
									<a href="#" id="description-button" >
										<svg class="svg-pencil" xmlns="http://www.w3.org/2000/svg" width="14" height="16" viewBox="0 0 14 16">
											<path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/>
										</svg>
									</a>
								</c:if>
									<p id="description-text" class="card-text">
										${profileUser.getDescription() }
									</p>
									<button class="btn btn-primary" id="description-submit" type="submit" name="Submit-Description" >Submit</button>
								</form>
							<form id="edit-box linkedin-form" class="form security" action="linkedin" method="POST">
								<input type="hidden" name="userID" value="${profileUser.getUserId()}"/>
								<p id="group-text" class="card-text">
									${profileUser.getGroup().getGroupNameWithoutUnderscore() }
								</p>
							<c:if test="${profileUser.getUserId() == newUser.getUserId() }">
								<a href="#" id="linkedin-link">${profileUser.getLinkedInUrl() }</a><a href="#" id="linkedin-button">
									<svg class="svg-pencil" xmlns="http://www.w3.org/2000/svg" width="14" height="16" viewBox="0 0 14 16">
										<path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/>
									</svg>
								</a>
							</c:if>
								<button class="btn btn-primary" id="linkedin-submit" type="submit" name="Submit-Description">Submit</button>
							</form>
						</div>
					</div>
				</div>
				<div class="container right-form">
					<form class="form personal-info" action="${profileUser.getUserId() }" method="POST" id="registrationForm">
						<div class="form-group">
							<div class="form-group">
								<div class="col-xs-4">
								<c:if test="${profileUser.getUserId() == newUser.getUserId() }">
									<a id="edit-button" href="#">Edit Address
										<svg class="svg-pencil" xmlns="http://www.w3.org/2000/svg" width="28" height="32" viewBox="0 0 14 16">
											<path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/>
										</svg>
									</a>
								</c:if>
									<label id="country-label" for="country">
										<h4>Country</h4>
									</label>
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
							<div class="col-xs-8">
								<button id="form-submit" class="btn btn-lg btn-success personal-button" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Submit</button>
								<button id="form-reset" class="btn btn-lg personal-button" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
							</div>
						</div>
	              	</form>
					<c:if test="${profileUser.getUserId() == newUser.getUserId() }">
					<div class="accordion" id="searchAccordion">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#searchAccordion" href="#collapseOne">Password and Security  
									<svg class="svg-pencil-add" xmlns="http://www.w3.org/2000/svg" width="21" height="24" viewBox="0 0 14 18">
										<path fill-rule="evenodd" d="M0 12v3h3l8-8-3-3-8 8zm3 2H1v-2h1v1h1v1zm10.3-9.3L12 6 9 3l1.3-1.3a.996.996 0 0 1 1.41 0l1.59 1.59c.39.39.39 1.02 0 1.41z"/>
									</svg>
								</a>
							</div>
							<c:if test="${sessionScope.successPassword}">
                   				<div>Password updated successfully.</div>
                			</c:if>
                			<c:if test="${sessionScope.samePassword}">
                   				<div class="error-message">Please enter a new password.</div>
                			</c:if>
                			<c:if test="${sessionScope.errorPassword}">
                   				<div class="error-message">Invalid current password.</div>
                			</c:if>
                			<c:if test="${sessionScope.newAnswer}">
                   				<div>Security Answer is updated successfully.</div>
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
												<input type="password" class="form-control password" id="new-password" name="new-password" placeholder="New Password" title="Your new password.">
											</div>
										</div>
										<div class="form-group">
											<div class="col-xs-4">
												<label for="confirm-password"><h4>Confirm New Password</h4></label>
												<!--<p id="phone">Default Phone	</p>-->
												<input type="password" class="form-control confirm-password" name="confirm-password" id="confirm-password" placeholder="Confirm New Password" title="Your new password confirmation.">
											</div>
										</div>
										<h4>Security Question</h4>
						                  <select class="form-control" name="security-question">
						                    <option>What high school did you attend?</option>
						                    <option>What is your mother's maiden name?</option>
						                    <option>What was the name of your first pet?</option>
						                    <option>Who is your childhood superhero?</option>
						                  </select>
						                  <br/>
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
												<button class="btn btn-lg btn-success submit-button" type="submit"><i class="glyphicon glyphicon-ok-sign"></i>Submit</button>
												<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</c:if>
					</div>
				</div>
			</div>
			<jsp:include page="right.jsp" />
		</div>
	</body>
</html>