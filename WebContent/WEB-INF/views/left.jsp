<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link rel="stylesheet" href="<c:url value="/resources/css/left.css"/>" />
</head>
	<div class="sidebar left-sidebar">
		<div class="container sidebar-header">
			<a href="${newUser.getUserId()}"><i class="fas fa-user-circle fa-7x"></i></a>
			<h6>${newUser.getFirstName() } ${newUser.getLastName() }</h6>	
			<h6>GROUP</h6>
		</div>
	</div>
</html>