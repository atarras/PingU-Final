<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
		
	    <link rel="stylesheet" href="<c:url value="resources/css/main.css"/>" />
		<link rel="stylesheet" href="<c:url value="resources/css/search.css" />" />
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	<jsp:include page="nav.jsp" />
	<body>
		<div class="container main-body">
			<jsp:include page="left.jsp" />
			<div class="container-fluid content">
				<div class="search-result">
				${foundUsers.size()} search results
				</div>
				<div class="card-group">
				<!-- search result template -->
					<c:forEach items="${foundUsers}" var="user" varStatus="status">
						<div class="card">
							<a href="${user.getUserId()}" ><i class="fas fa-user-circle fa-4x"></i></a>
							<div class="card-body">
								<div class="card-block">
									<h5 class="card-title">${user.getFirstName() } ${user.getLastName() } </h5>
									
									<p class="card-text">${user.getDescription() }</p>
									<a href="#" data-toggle="modal" data-target="#message-modal" onclick="getID('${user.getUserId()}')" class="${user.getUserId()}"><i class="far fa-envelope fa-2x" id="${user.getUserId()}"></i></a>
									<div class="modal fade" id="message-modal" tabindex="-1" role="dialog" aria-labelledby="new-message" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="new-message">New Message</h5>
						<button type="button"  class="close" data-dismiss="modal" aria-label="Close">
						  <span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="sendMessage" method="post">
						<input type="text" hidden="true" name="receiverId" id="receiverId"></input>
						<input type="text" value="${newUser.getFirstName() }" hidden="true" name="senderFirstName" id="senderFirstName"></input>
						<input type="text" value="${newUser.getLastName() }" hidden="true" name="senderLastName" id="senderLastName"></input>
						<input type="text" value="${newUser.getUserId() }" hidden="true" name="senderId" id="senderId"></input>
<!-- 							<div class="form-group"> -->
<!-- 								<label for="reciever" class="col-form-label">To:</label> -->
<%-- 								<input type="text" class="form-control" id="reciever" placeholder="jdoe" value="${user.getFirstName() }" disabled="true"> --%>
<!-- 							</div> -->
							<div class="form-group">
								<label for="message-body">Message:</label>
								<textarea type="text" class="form-control" id="messageBody" placeholder="Your message here" name="messageBody"></textarea>
						</div>
						
						
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Discard</button>
							<button type="submit" class="btn btn-primary">Send</button>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
								</div>
							</div>
						</div>
		    		</c:forEach>
				</div>
			</div>
			<jsp:include page="right.jsp" />
		</div>
		<script src="<c:url value="/resources/js/search.js" />"></script>
	</body>
</html>