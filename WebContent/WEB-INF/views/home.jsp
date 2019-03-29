<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>" />
<link rel="stylesheet" href="<c:url value="resources/css/home.css"/>" />
</head>
<jsp:include page="nav.jsp" />
<body>

	<div class="flex-wrapper">
		<div class="bg">
			<div class="container main-body">
				<jsp:include page="left.jsp" />
				<div class="container content">
					<c:if test="${not empty joinGroupPendingMsg}">
						<div>
							<h5 class="alert alert-info">${joinGroupPendingMsg}</h5>
						</div>
					</c:if>
					<h1 class="welcome-header">Welcome ${newUser.getFirstName() }
						${newUser.getLastName() }</h1>
					<div class="message-content">
						<ul class="nav nav-tabs">
							<li><a class="nav-link active" data-toggle="tab"
								href="#allmsg">All</a></li>
							<li><a class="nav-link" data-toggle="tab" href="#usermsg">User</a></li>
							<li><a class="nav-link" data-toggle="tab" href="#groupmsg">Group</a></li>
						</ul>
						<div class="tab-content">
							<div id="allmsg"
								class="tab-pane fade active show container messages all">
								<c:forEach items="${sessionScope.userMessages}" var="uMsg"
									varStatus="status">
									<div class="media border pt-4 p-3">
										<div class="profile-header-img">
											<a href="#" data-toggle="modal" data-target="#message-modal"
												onclick="getID('${uMsg.getSenderId()}')">${uMsg.getSenderName()}
												<!-- <i class="fas fa-user-circle fa-4x pr-3"></i> --> <img
												class="rounded-circle"
												src="https://thispersondoesnotexist.com/image#${uMsg.getSenderId()}">
											</a>
											<div class="modal fade" id="message-modal" tabindex="-1"
												role="dialog" aria-labelledby="new-message"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<form action="sendMessage" method="post">
																<input type="text" hidden="true" name="receiverId"
																	id="receiverId"></input> <input type="text"
																	value="${newUser.getFirstName() }" hidden="true"
																	name="senderFirstName" id="senderFirstName"></input> <input
																	type="text" value="${newUser.getLastName() }"
																	hidden="true" name="senderLastName" id="senderLastName"></input>
																<input type="text" value="${newUser.getUserId() }"
																	hidden="true" name="senderId" id="senderId"></input>
																<!-- 							<div class="form-group"> -->
																<!-- 								<label for="reciever" class="col-form-label">To:</label> -->
																<%-- 								<input type="text" class="form-control" id="reciever" placeholder="jdoe" value="${user.getFirstName() }" disabled="true"> --%>
																<!-- 							</div> -->
																<div class="form-group">
																	<label for="message-body">Message:</label>
																	<textarea type="text" class="form-control"
																		id="messageBody" placeholder="Your message here"
																		name="messageBody"></textarea>
																</div>


																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">Discard</button>
																	<button type="submit" class="btn btn-primary">Send</button>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
											<div class="media-body">
												<h5 class="mt-0">Message</h5>
												<p>${uMsg.getMsgBody() }</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<div id="usermsg" class="tab-pane fade container messages user">
								<c:forEach items="${sessionScope.userMessages}" var="uMsg"
									varStatus="status">
										<div class="media border pt-4 p-3">
										<div class="profile-header-img">
											<a href="#" data-toggle="modal" data-target="#message-modal"
												onclick="getID('${uMsg.getSenderId()}')">${uMsg.getSenderName()}
												<!-- <i class="fas fa-user-circle fa-4x pr-3"></i> --> <img
												class="rounded-circle"
												src="https://thispersondoesnotexist.com/image#${uMsg.getSenderId()}">
											</a>
											<div class="modal fade" id="message-modal" tabindex="-1"
												role="dialog" aria-labelledby="new-message"
												aria-hidden="true">
												<div class="modal-dialog" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<form action="sendMessage" method="post">
																<input type="text" hidden="true" name="receiverId"
																	id="receiverId"></input> <input type="text"
																	value="${newUser.getFirstName() }" hidden="true"
																	name="senderFirstName" id="senderFirstName"></input> <input
																	type="text" value="${newUser.getLastName() }"
																	hidden="true" name="senderLastName" id="senderLastName"></input>
																<input type="text" value="${newUser.getUserId() }"
																	hidden="true" name="senderId" id="senderId"></input>
																<!-- 							<div class="form-group"> -->
																<!-- 								<label for="reciever" class="col-form-label">To:</label> -->
																<%-- 								<input type="text" class="form-control" id="reciever" placeholder="jdoe" value="${user.getFirstName() }" disabled="true"> --%>
																<!-- 							</div> -->
																<div class="form-group">
																	<label for="message-body">Message:</label>
																	<textarea type="text" class="form-control"
																		id="messageBody" placeholder="Your message here"
																		name="messageBody"></textarea>
																</div>


																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">Discard</button>
																	<button type="submit" class="btn btn-primary">Send</button>
																</div>
															</form>
														</div>
													</div>
												</div>
											</div>
											<div class="media-body">
												<h5 class="mt-0">Message</h5>
												<p>${uMsg.getMsgBody() }</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<div id="groupmsg" class="tab-pane fade container messages group">
								<!--  Message template -->
								<c:forEach items="${sessionScope.groupMessages}" var="gMsg"
									varStatus="status">
									<div class="media border pt-4 p-3">
										<div class="profile-header-img">
											<a href="${gMsg.getSenderId()}">${gMsg.getSenderName()}
												<img class="rounded-circle"
												src="https://thispersondoesnotexist.com/image#${uMsg.getSenderId()}">
											</a>
										</div>
										<div class="media-body">
											<h5 class="mt-0">Message</h5>
											<p>${gMsg.getMsgBody() }</p>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>

					<button class="open-button" onclick="openForm()">Chat</button>

					<div class="chat-popup" id="myForm">
						<form action="/action_page.php" class="form-container">
							<h1>Chat</h1>

							<label for="msg"><b>Message</b></label>
							<textarea placeholder="Type message.." name="msg" required></textarea>

							<button type="submit" class="btn">Send</button>
							<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
						</form>
					</div>

				</div>
				<jsp:include page="right.jsp" />
			</div>
			<jsp:include page="footer.jsp" />
		</div>
	</div>
	<script src="<c:url value="/resources/js/search.js" />"></script>
</body>
<script>
	function openForm() {
		document.getElementById("myForm").style.display = "block";
	}

	function closeForm() {
		document.getElementById("myForm").style.display = "none";
	}
</script>
</html>