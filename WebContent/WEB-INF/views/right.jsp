<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="<c:url value="/resources/css/right.css"/>" />
	</head>
		<div class="container sidebar right-sidebar">
			<!-- template for making new users on the side
			<div class="media border p-3">
				<i class="fas fa-user-circle fa-4x"></i>
				<div class="media-body">
					<p>John Doe</p>
					<a href="#" data-toggle="modal" data-target="#exampleModal"><i class="far fa-envelope fa-2x"></i></a>
					<i class="fas fa-users fa-2x"></i>
				</div>
			</div>-->
			
			<c:forEach items="${loggedInUsers}" var="user" varStatus="status">
				<div class="media border p-3">
					<a href="${user.value.getUserId()}">
						<svg xmlns="http://www.w3.org/2000/svg" width="64" height="62" viewBox="0 0 12 16">
							<path fill-rule="evenodd" d="M12 14.002a.998.998 0 0 1-.998.998H1.001A1 1 0 0 1 0 13.999V13c0-2.633 4-4 4-4s.229-.409 0-1c-.841-.62-.944-1.59-1-4 .173-2.413 1.867-3 3-3s2.827.586 3 3c-.056 2.41-.159 3.38-1 4-.229.59 0 1 0 1s4 1.367 4 4v1.002z"/>
						</svg>
					</a>
					<div class="media-body">
						<p>${user.value.getFirstName()}  ${user.value.getLastName()}</p>
						
						<c:url value="SingleUserChat" var="toUserName">
										<c:param name="userName"
											value="${user.value.getUsername()}" />
						</c:url>
						<a href="${toUserName}"  >
							<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 14 16">
							
							<path fill-rule="evenodd" d="M0 4v8c0 .55.45 1 1 1h12c.55 0 1-.45 1-1V4c0-.55-.45-1-1-1H1c-.55 0-1 .45-1 1zm13 0L7 9 1 4h12zM1 5.5l4 3-4 3v-6zM2 12l3.5-3L7 10.5 8.5 9l3.5 3H2zm11-.5l-4-3 4-3v6z"/>
							</svg>
						</a>
						
						<a href="${user.value.getUserId()}">
							<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 16 16">
								<path fill-rule="evenodd" d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4z"/>
							</svg>
						</a>
					</div>
				</div>
    		</c:forEach>
		</div>
</html>