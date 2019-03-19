<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link rel="stylesheet" href="<c:url value="resources/css/nav.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/right.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/left.css" />" />
    
    <script src="<c:url value="resources/js/nav.js" />"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- This is the right bar in potentially all the pages
	This contains a list of current online users with some placeholders -->
	<nav class="container sidebar right-sidebar">
		<div class="media border p-3">
			<i class="fas fa-user-circle fa-4x"></i>
			<div class="media-body">
				<p>John Doe</p>
				<a href="#" data-toggle="modal" data-target="#messageModal"><i class="far fa-envelope fa-2x"></i></a>
				<i class="fas fa-users fa-2x"></i>
			</div>
		</div>
		<div class="media border p-3">
			<i class="fas fa-user-circle fa-4x"></i>
			<div class="media-body">
				<p>John Doe</p>
				<i class="far fa-envelope fa-2x"></i>
				<i class="fas fa-users fa-2x"></i>
			</div>
		</div>
		<div class="media border p-3">
			<i class="fas fa-user-circle fa-4x"></i>
			<div class="media-body">
				<p>John Doe</p>
				<i class="far fa-envelope fa-2x"></i>
				<i class="fas fa-users fa-2x"></i>
			</div>
		</div>
	</nav>

	<!-- This is the modal for brining up a new message
	This needs to be styled and renamed for our purposes -->
	<!-- <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="messageModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form>
					<div class="form-group">
						<label for="formGroupExampleInput">Example label</label>
						<input type="text" class="form-control" id="formGroupExampleInput" placeholder="Example input">
					</div>
					<div class="form-group">
						<label for="formGroupExampleInput2">Another label</label>
						<input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input">
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div> -->
</body>
</html>