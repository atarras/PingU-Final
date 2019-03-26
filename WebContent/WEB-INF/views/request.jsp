<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
<link rel="stylesheet" href="resources/css/request.css">
<title>PINGU Admin Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<jsp:include page="navAdmin.jsp" />
<body>
	<div id="requestContent"
		class="container-fluid table-responsive text-nowrap">
		<c:choose>
			<c:when test="${empty pendingRequests}">
				<div id="noRequests" class="alert alert-info text-center">
					<h4>
						<strong>No Pending Requests</strong>
					</h4>
				</div>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty deniedRequestMsg}">
					<div id="deniedRequestMsg" class="alert alert-danger text-center">
						<h4>${deniedRequestMsg }</h4>
					</div>
				</c:if>
				<c:if test="${not empty approvedRequestMsg}">
					<div id="approvedRequestMsg"
						class="alert alert-success text-center">
						<h4>${approvedRequestMsg }</h4>
					</div>
				</c:if>
				<div class=tableDiv>
				<table border=0 id="requestTable" class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Request #</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Type Of User</th>
							<th scope="col">Type Of Request</th>
							<th scope="col">Approve/Deny</th>
						</tr>
					</thead>

					<tbody>
						<c:set var="count" value="0" scope="page" />
						<c:forEach items="${pendingRequests}" var="currRequest">
							<c:set var="count" value="${count + 1}" scope="page" />
							<tr>
								<th scope="row">${count}</th>
								<td>${currRequest.getRequestUser().getFirstName()}</td>
								<td>${currRequest.getRequestUser().getLastName()}</td>

								<c:choose>
									<c:when
										test="${currRequest.getRequestUserType() == 'Trainee' }">
										<td>Trainee</td>
									</c:when>
									<c:otherwise>
										<td>Consultant</td>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when
										test="${currRequest.getRequestType() == 'CHANGE_EMPLOYER'}">
										<td>Change Employer: ${currRequest.getComment() }</td>
									</c:when>
									<c:when
										test="${currRequest.getRequestType() == 'CHANGE_JOB_TITLE'}">
										<td>Change Job Title: ${currRequest.getComment() }</td>
									</c:when>
									<c:when
										test="${currRequest.getRequestType() == 'CREATE_USER' }">
										<td>Create User</td>
									</c:when>
									<c:otherwise>
										<td>Join Group: ${currRequest.getGroupId()}</td>
									</c:otherwise>
								</c:choose>

								<td class="text-left requestButtons">
									<c:url value="approveRequest" var="approveRequestURL">
										<c:param name="requestID"
											value="${currRequest.getRequestId()}" />
									</c:url>
									<div>
										<button type="button"
											onclick="location.href='${approveRequestURL}' "
											class="btn btn-sm btn-success">APPROVE</button>
									</div>
									<div class="text-left">
										<form action="denyRequest" method="post">
											<button type="submit" class="btn btn-sm btn-danger">DENY</button>
											<input type="hidden" name="requestID"
												value="${currRequest.getRequestId()}"> 
											<input type="text" name="denyComment"
												placeholder="Reason for Denial" required>
										</form>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="resources/js/request.js"/>"></script>
</body>
</html>