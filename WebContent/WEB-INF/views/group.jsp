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
	    <link rel="stylesheet" href="<c:url value="resources/css/group.css"/>"/>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<jsp:include page="nav.jsp" />
	<body>
	  	<div class="container main-body">
	  	 	<jsp:include page="left.jsp" />
			<div class="container-fluid content">
				<c:choose>
				<c:when test="${not empty foundFromGroupMsg }">
					<form action="joinGroupRequest">
						<h1 class="welcome-header">
							<i class="fas fa-university fa-3x"></i>
							${groupPage.getGroupNameWithoutUnderscore()} <input type="hidden"
								name="userID" value="${newUser.getUserId()}"> <input
								type="hidden" name="groupID" value="${groupPage.getGroupId()}">
							<c:if test="${groupPage.getGroupId() != newUser.getGroup().getGroupId() }">							
								<button class="btn btn-primary header-button" type="submit">JOIN</button>
							</c:if>
						</h1>
					</form>

					<div class="group-description">
						${groupPage.getGroupDescription()}</div>
					<div class="search-result">${listOfMembers.size()}Members</div>

				</c:when>
				<c:when test="${empty newUser.getGroup()}">
				
					<div class="container-fluid">
						<h5 class="alert alert-info text-center">You are currently not in a group</h5>
						<c:url value="findGroups" var="findGroupsURL">
							<c:param name="gSearchName" value=""></c:param>
						</c:url>
						<a class="text-center" href="${findGroupsURL}">Click here to find a group to join</a>
					
					
					</div>
				
				</c:when>
				<c:otherwise>
				<h1 class="welcome-header">
					<i class="fas fa-university fa-3x"></i>
					${groupPage.getGroupNameWithoutUnderscore()} 
				</h1>
				<div class="group-description">
					${groupPage.getGroupDescription()}
				</div>
				<div class="search-result">
					${listOfMembers.size()} Members
				</div>
				<div class="card-group">
					<div class="card">
						<i class="fas fa-user-circle fa-4x"></i>
						<div class="card-body">
							<div class="card-block">
								<h5 class="card-title">Card title</h5>
								<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							</div>
						</div>
					</div>
				</div>
				</c:otherwise>
				</c:choose>
			</div>
			<jsp:include page="right.jsp" />
		</div>
	</body>
</html>