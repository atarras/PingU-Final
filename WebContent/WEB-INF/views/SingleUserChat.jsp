<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>PingU</title>


	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
		
	    <link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
</head>
<jsp:include page="nav.jsp" />

<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2>
</noscript>
    
    
 <div class="container main-body">
	  	<jsp:include page="left.jsp" />
		<div class="container content">
		
		
        
        <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">From:</label>
                    <input id="login" type="text" value="${sessionScope.newUser.getUsername()}"   />
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">To:</label>
                    <input type="text" id="name"  value="${userName}" >
                </div>
                <div class="form-group">
                    <label for="name">Message</label>
                    <input type="text" id="msg" name="messageToUser" placeholder="Your Message here..." autocomplete="off" class="form-control" />
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Messages</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>

  
</div>

<jsp:include page="right.jsp" />  
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">

var stompClient = null;


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/PingU/SingleUserChat');
    stompClient = Stomp.over(socket);
    stompClient.connect({
           "user" : document.getElementById("login").value
    }

    , function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/reply', function(greeting) {
                                                            showGreeting(JSON.parse(greeting.body).content);
                                                        });
    });
}



function sendName() {
		  
    stompClient.send("/app/message", {
    }, JSON.stringify({
        'name': $("#login").val(),
        'toUser' : $("#name").val(),
        'content' : $("#msg").val()
        
    }));
    showYourMessage();
   
  
}

function showYourMessage(){
	
	 var d = new Date();
	  var n = d.getHours();
	  var m = d.getMinutes();
	  var messageInput = document.querySelector('#msg');
	  
	  
	  $("#greetings").append("<tr><td>" + "you: "+ messageInput.value +" "+n+":" + m   +"</td></tr>");
	  document.getElementById('msg').value = "";
}


function showGreeting(message) {
	   
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
 
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    
     $( "#connect" ).click(function() { connect(); }); 

   
    $( "#send" ).click(function() { sendName(); });
});



</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>