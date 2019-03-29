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
							<c:choose>
							<c:when test="${groupPage.getGroupCategory() == 'BANKING'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 14 16"><path fill-rule="evenodd" d="M9 4V3c0-.55-.45-1-1-1H6c-.55 0-1 .45-1 1v1H1c-.55 0-1 .45-1 1v8c0 .55.45 1 1 1h12c.55 0 1-.45 1-1V5c0-.55-.45-1-1-1H9zM6 3h2v1H6V3zm7 6H8v1H6V9H1V5h1v3h10V5h1v4z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'INSURANCE'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M16 14v1H0V0h1v14h15zM5 13H3V8h2v5zm4 0H7V3h2v10zm4 0h-2V6h2v7z"/></svg>						
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'GOVERNMENT'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 14 16"><path fill-rule="evenodd" d="M7 4c-.83 0-1.5-.67-1.5-1.5S6.17 1 7 1s1.5.67 1.5 1.5S7.83 4 7 4zm7 6c0 1.11-.89 2-2 2h-1c-1.11 0-2-.89-2-2l2-4h-1c-.55 0-1-.45-1-1H8v8c.42 0 1 .45 1 1h1c.42 0 1 .45 1 1H3c0-.55.58-1 1-1h1c0-.55.58-1 1-1h.03L6 5H5c0 .55-.45 1-1 1H3l2 4c0 1.11-.89 2-2 2H2c-1.11 0-2-.89-2-2l2-4H1V5h3c0-.55.45-1 1-1h4c.55 0 1 .45 1 1h3v1h-1l2 4zM2.5 7L1 10h3L2.5 7zM13 10l-1.5-3-1.5 3h3z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'RETAIL'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 15 16"><path fill-rule="evenodd" d="M7.73 1.73C7.26 1.26 6.62 1 5.96 1H3.5C2.13 1 1 2.13 1 3.5v2.47c0 .66.27 1.3.73 1.77l6.06 6.06c.39.39 1.02.39 1.41 0l4.59-4.59a.996.996 0 0 0 0-1.41L7.73 1.73zM2.38 7.09c-.31-.3-.47-.7-.47-1.13V3.5c0-.88.72-1.59 1.59-1.59h2.47c.42 0 .83.16 1.13.47l6.14 6.13-4.73 4.73-6.13-6.15zM3.01 3h2v2H3V3h.01z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'HEALTHCARE'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M9 2c-.97 0-1.69.42-2.2 1-.51.58-.78.92-.8 1-.02-.08-.28-.42-.8-1-.52-.58-1.17-1-2.2-1-1.632.086-2.954 1.333-3 3 0 .52.09 1.52.67 2.67C1.25 8.82 3.01 10.61 6 13c2.98-2.39 4.77-4.17 5.34-5.33C11.91 6.51 12 5.5 12 5c-.047-1.69-1.342-2.913-3-3z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'PROFESSIONAL_SERVICE_PROVIDER' }">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 14 16"><path fill-rule="evenodd" d="M14 6l-4.9-.64L7 1 4.9 5.36 0 6l3.6 3.26L2.67 14 7 11.67 11.33 14l-.93-4.74L14 6z"/></svg>
							</c:when>
							</c:choose>
							${groupPage.getGroupNameWithoutUnderscore()} 
							
							<input type="hidden"
								name="userID" value="${newUser.getUserId()}"> <input
								type="hidden" name="groupID" value="${groupPage.getGroupId()}">
							<c:if test="${groupPage.getGroupId() != newUser.getGroup().getGroupId() }">							
								<button class="btn btn-primary header-button" type="submit">JOIN</button>
							</c:if>
						</h1>
					</form>

					<div class="group-description">
						${groupPage.getGroupDescription()}</div>
					<div class="search-result">
						<c:choose>
						<c:when test="${empty listOfMembers}">
							0 Members
						</c:when>
						<c:otherwise>
							${listOfMembers.size()} Member(s)
						</c:otherwise>
					</c:choose>
					</div>

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
						<c:choose>
							<c:when test="${groupPage.getGroupCategory() == 'BANKING'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 14 16"><path fill-rule="evenodd" d="M9 4V3c0-.55-.45-1-1-1H6c-.55 0-1 .45-1 1v1H1c-.55 0-1 .45-1 1v8c0 .55.45 1 1 1h12c.55 0 1-.45 1-1V5c0-.55-.45-1-1-1H9zM6 3h2v1H6V3zm7 6H8v1H6V9H1V5h1v3h10V5h1v4z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'INSURANCE'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M16 14v1H0V0h1v14h15zM5 13H3V8h2v5zm4 0H7V3h2v10zm4 0h-2V6h2v7z"/></svg>						
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'GOVERNMENT'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 14 16"><path fill-rule="evenodd" d="M7 4c-.83 0-1.5-.67-1.5-1.5S6.17 1 7 1s1.5.67 1.5 1.5S7.83 4 7 4zm7 6c0 1.11-.89 2-2 2h-1c-1.11 0-2-.89-2-2l2-4h-1c-.55 0-1-.45-1-1H8v8c.42 0 1 .45 1 1h1c.42 0 1 .45 1 1H3c0-.55.58-1 1-1h1c0-.55.58-1 1-1h.03L6 5H5c0 .55-.45 1-1 1H3l2 4c0 1.11-.89 2-2 2H2c-1.11 0-2-.89-2-2l2-4H1V5h3c0-.55.45-1 1-1h4c.55 0 1 .45 1 1h3v1h-1l2 4zM2.5 7L1 10h3L2.5 7zM13 10l-1.5-3-1.5 3h3z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'RETAIL'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 15 16"><path fill-rule="evenodd" d="M7.73 1.73C7.26 1.26 6.62 1 5.96 1H3.5C2.13 1 1 2.13 1 3.5v2.47c0 .66.27 1.3.73 1.77l6.06 6.06c.39.39 1.02.39 1.41 0l4.59-4.59a.996.996 0 0 0 0-1.41L7.73 1.73zM2.38 7.09c-.31-.3-.47-.7-.47-1.13V3.5c0-.88.72-1.59 1.59-1.59h2.47c.42 0 .83.16 1.13.47l6.14 6.13-4.73 4.73-6.13-6.15zM3.01 3h2v2H3V3h.01z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'HEALTHCARE'}">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M9 2c-.97 0-1.69.42-2.2 1-.51.58-.78.92-.8 1-.02-.08-.28-.42-.8-1-.52-.58-1.17-1-2.2-1-1.632.086-2.954 1.333-3 3 0 .52.09 1.52.67 2.67C1.25 8.82 3.01 10.61 6 13c2.98-2.39 4.77-4.17 5.34-5.33C11.91 6.51 12 5.5 12 5c-.047-1.69-1.342-2.913-3-3z"/></svg>
							</c:when>
							<c:when test="${groupPage.getGroupCategory() == 'PROFESSIONAL_SERVICE_PROVIDER' }">
								<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 14 16"><path fill-rule="evenodd" d="M14 6l-4.9-.64L7 1 4.9 5.36 0 6l3.6 3.26L2.67 14 7 11.67 11.33 14l-.93-4.74L14 6z"/></svg>
							</c:when>
						</c:choose>
						${groupPage.getGroupNameWithoutUnderscore()} 
				</h1>
				<div class="group-description">
					${groupPage.getGroupDescription()}
				</div>
				<div class="search-result">
					<c:choose>
						<c:when test="${empty listOfMembers}">
							0 Members
						</c:when>
						<c:otherwise>
							${listOfMembers.size()} Member(s)
						
						</c:otherwise>
					</c:choose>
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