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
			<a href="${newUser.getUserId()}">
				<svg xmlns="http://www.w3.org/2000/svg" width="110" height="112" viewBox="0 0 12 16">
					<path fill-rule="evenodd" d="M12 14.002a.998.998 0 0 1-.998.998H1.001A1 1 0 0 1 0 13.999V13c0-2.633 4-4 4-4s.229-.409 0-1c-.841-.62-.944-1.59-1-4 .173-2.413 1.867-3 3-3s2.827.586 3 3c-.056 2.41-.159 3.38-1 4-.229.59 0 1 0 1s4 1.367 4 4v1.002z"/>
				</svg>
			</a>
			<h6>${newUser.getFirstName() } ${newUser.getLastName() }</h6>	
			<h6>GROUP</h6>
		</div>
	</div>
</html>