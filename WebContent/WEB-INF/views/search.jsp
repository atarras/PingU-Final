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
									<a href="#" data-toggle="modal" data-target="#message-modal"><i class="far fa-envelope fa-2x"></i></a>
									<p class="card-text">${user.getDescription() }</p>
								</div>
							</div>
						</div>
		    		</c:forEach>
				</div>
			</div>
			<jsp:include page="right.jsp" />
		</div>
	</body>
</html>