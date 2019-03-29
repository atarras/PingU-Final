<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    
	    <link rel="stylesheet" href="<c:url value="/resources/css/nav.css"/>" />
	</head>
		<!-- Navigation bar static throughout all our pages, the search bar will probably be made bigger,
		need to add potentially bigger buttons, a hover effect, dynamic pill icon for notifications -->
	<header class="container m-0 p-0">
		<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary">
			<a class="navbar-brand" href="requestAdmin">PingU</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item pr-2 active">
						<a class="nav-link" href="requestAdmin" title="Request Manager">
							<svg class="white-svg" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 16 16">
								<path fill-rule="evenodd" d="M16 9l-3-3V2h-2v2L8 1 0 9h2l1 5c0 .55.45 1 1 1h8c.55 0 1-.45 1-1l1-5h2zm-4 5H9v-4H7v4H4L2.81 7.69 8 2.5l5.19 5.19L12 14z"/>
							</svg>
						</a>
					</li>
					<li class="nav-item pr-2 active">
						<a class="nav-link" href="users" title="User Manager">
							<svg class="white-svg" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 12 16">
								<path fill-rule="evenodd" d="M12 14.002a.998.998 0 0 1-.998.998H1.001A1 1 0 0 1 0 13.999V13c0-2.633 4-4 4-4s.229-.409 0-1c-.841-.62-.944-1.59-1-4 .173-2.413 1.867-3 3-3s2.827.586 3 3c-.056 2.41-.159 3.38-1 4-.229.59 0 1 0 1s4 1.367 4 4v1.002z"/>
							</svg>
						</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="groups" title="Group Manager">
							<svg class="white-svg" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 16 16">
								<path fill-rule="evenodd" d="M16 12.999c0 .439-.45 1-1 1H7.995c-.539 0-.994-.447-.995-.999H1c-.54 0-1-.561-1-1 0-2.634 3-4 3-4s.229-.409 0-1c-.841-.621-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.442.58 2.5 3c.058 2.41-.159 2.379-1 3-.229.59 0 1 0 1s1.549.711 2.42 2.088C9.196 9.369 10 8.999 10 8.999s.229-.409 0-1c-.841-.62-1.058-.59-1-3 .058-2.419 1.367-3 2.5-3s2.437.581 2.495 3c.059 2.41-.158 2.38-1 3-.229.59 0 1 0 1s3.005 1.366 3.005 4z"/>
							</svg>
						</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="logOut" title="Logout">
							<svg class="white-svg" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 16 17">
								<path fill-rule="evenodd" d="M12 9V7H8V5h4V3l4 3-4 3zm-2 3H6V3L2 1h8v3h1V1c0-.55-.45-1-1-1H1C.45 0 0 .45 0 1v11.38c0 .39.22.73.55.91L6 16.01V13h4c.55 0 1-.45 1-1V8h-1v4z"/>
							</svg>
						</a>
					</li>
				</ul>
				<ul class="navbar-nav mr-auto navbar-right">
					<li class="nav-item active">
						<a class="nav-link" href="requestAdmin" title="${newUser.getUsername() }">
						<svg class="white-svg" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 12 16">
								<path fill-rule="evenodd" d="M12 14.002a.998.998 0 0 1-.998.998H1.001A1 1 0 0 1 0 13.999V13c0-2.633 4-4 4-4s.229-.409 0-1c-.841-.62-.944-1.59-1-4 .173-2.413 1.867-3 3-3s2.827.586 3 3c-.056 2.41-.159 3.38-1 4-.229.59 0 1 0 1s4 1.367 4 4v1.002z"/>
							</svg>
						${newUser.getUsername()}</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<body>
		<!-- The message modal, to be editted later -->
		<div class="modal fade" id="message-modal" tabindex="-1" role="dialog" aria-labelledby="new-message" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="new-message">New Message</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						  <span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="reciever" class="col-form-label">To:</label>
								<input type="text" class="form-control" id="reciever" placeholder="jdoe">
							</div>
							<div class="form-group">
								<label for="message-body">Message:</label>
								<textarea type="text" class="form-control" id="message-body" placeholder="Your message here"></textarea>
						</div>
						</form>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Discard</button>
							<button type="button" class="btn btn-primary">Send</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>