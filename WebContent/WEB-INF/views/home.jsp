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
			<c:if test="${not empty joinGroupPendingMsg}">
			<div>
				<h5 class="alert alert-info">${joinGroupPendingMsg}</h5>
			</div>
			</c:if>
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
					<c:forEach items="${sessionScope.userMessages}" var="uMsg" varStatus="status">	
						<div class="media border pt-4 p-3">
							<a href="${uMsg.getSenderId()}" >${uMsg.getSenderName()}
								<i class="fas fa-user-circle fa-4x pr-3"></i>
							</a>
							<div class="media-body">
								<h5 class="mt-0">Message</h5>
								<p>${uMsg.getMsgBody() }</p>
							</div>
						</div>
						</c:forEach>
					</div>
					<div id="usermsg" class="tab-pane fade container messages user">
					<c:forEach items="${sessionScope.userMessages}" var="uMsg" varStatus="status">	
						<div class="media border pt-4 p-3">
							<a href="${uMsg.getSenderId()}" >${uMsg.getSenderName()}
								<i class="fas fa-user-circle fa-4x pr-3"></i>
							</a>
							<div class="media-body">
								<h5 class="mt-0">Message</h5>
								<p>${uMsg.getMsgBody() }</p>
							</div>
						</div>
						</c:forEach>
					</div>
					<div id="groupmsg" class="tab-pane fade container messages group">
						<!--  Message template -->	
						<c:forEach items="${sessionScope.groupMessages}" var="gMsg" varStatus="status">	
						<div class="media border pt-4 p-3">
							<a href="${gMsg.getSenderId()}" >${gMsg.getSenderName()}
								<i class="fas fa-user-circle fa-4x pr-3"></i>
							</a>
							<div class="media-body">
								<h5 class="mt-0">Message</h5>
								<p>${gMsg.getMsgBody() }</p>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	    <jsp:include page="right.jsp" />  
	  </div>
	</body>
</html>