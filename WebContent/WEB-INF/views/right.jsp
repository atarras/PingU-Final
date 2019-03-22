<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="<c:url value="resources/css/right.css"/>" />
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
					<i class="fas fa-user-circle fa-4x"></i>
					<div class="media-body">
						<p>${user.getFirstName()}  ${user.getLastName()}</p>
						<a href="#" data-toggle="modal" data-target="#exampleModal"><i class="far fa-envelope fa-2x"></i></a>
						<i class="fas fa-users fa-2x"></i>
					</div>
				</div>
    		</c:forEach>
		</div>
</html>