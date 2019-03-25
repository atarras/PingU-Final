<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>PINGU Admin Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="resources/css/RequestWebpageStyle.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="<c:url value="resources/js/RequestWebpage.js" />"></script>
</head>
<%-- <jsp:include page="nav.jsp"> --%>
<body>
	<div id="requestContent"
		class="container-fluid table-responsive text-nowrap">
		<c:choose>
			<c:when test="${empty pendingRequests}">
				<div id="noRequests" class="alert alert-info text-center">
					<h1>
						<strong>No Pending Requests</strong>
					</h1>
				</div>
			</c:when>
			<c:otherwise>
				<table id="requestTable" class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Request #</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Type Of User</th>
							<th scope="col">Type Of Request</th>
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
								<td>${currRequest.getRequestType() }</td>
								<td>${currRequest.getComment() }</td>
								<td class="text-right row no-padding"><c:url
										value="approveRequest" var="approveRequestURL">
										<c:param name="requestID"
											value="${currRequest.getRequestId()}" />
									</c:url>
									<div class="btn-group" role="group">
										<div class="col-md-6">
											<button type="button"
												onclick="location.href='${approveRequestURL}' "
												class="btn btn-sm btn-success">APPROVE</button>
										</div>
										<div class="col-md-6">
											<button onclick="div_show()" class="btn btn-sm btn-danger">DENY</button>
										</div>
									</div></td>
							</tr>
							<div id="popUpArea">
								<div id="popUpDelete">
									<img src="" alt="CLOSE" onclick="div_hide()">
									<form action="denyRequest" method="post">
										<input type="hidden" name="requestID"
											value="${currRequest.getRequestId() }"> <input
											id="comment" name="denyComment"
											placeholder="Reason For Denial of Request" type=text
											autofocus>
										<button class="btn btn-primary" type="submit">CONFIRM</button>
									</form>
								</div>
							</div>
						</c:forEach>
					</tbody>

				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>