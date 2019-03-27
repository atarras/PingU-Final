<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	</head>
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