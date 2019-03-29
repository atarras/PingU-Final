<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>PingU</title>


	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
		
	    <link rel="stylesheet" href="<c:url value="resources/css/main.css"/>"/>
	    <link rel="stylesheet" href="<c:url value="resources/css/singleUserChat.css"/>"/>
	    
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
		
		
       <div id="mainContent">
        <div class="row">
        <div class="col-md-6">
            <form>
                <div class="form-group">
                
                    <%-- <label for="connect">From: &nbsp;&nbsp; </label>
                    <input id="login" type="text" value="${sessionScope.newUser.getUsername()}"   />
                                
                </div> --%>
                
                
                   <div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1" >From:</span>
					  </div>
					    <input id="login" type="text" class="form-control"  value="${sessionScope.newUser.getUsername()}"   />
					 </div> 
				</div>
            </form>
        </div>
        </div>
         <div class="row">
        <div class="col-md-6">
            <form>
             <%--     <div class="form-group">
                    <!-- <label for="name">To: </label> -->
                      <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1" >To:</span>
					  </div>
                   
                </div>  --%>
              <div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1" >To:</span>
					  </div>
					   <input type="text" id="name" class="form-control" value="${userName}" >
					</div> 
					
					
               <!--  <div class="form-group">
                    <label for="name">Message:   </label>
                    <input type="text" id="msg" name="messageToUser" placeholder="Your Message here..." autocomplete="off" class="form-control input-sm chat_input" />
	                    <span class="input-group-btn">
		               		 <button id="send" class="btn btn-primary btn-sm" type="submit">Send</button>
		                </span>
                </div> -->
                
                
                
                <div class="input-group">
					  <div class="input-group-prepend">
					    <span class="input-group-text">Message:</span>
					  </div>
					  <textarea id="msg" name="messageToUser" placeholder="Your Message here..." class="form-control input-sm chat_input"></textarea>
					
					</div>
				
				<div id="sendBtn">
                  <span class="input-group-btn" >
		               		 <button id="send" class="btn btn-primary btn-lg" type="submit">Send</button>
		                </span>
		            </div>
            </form>
        </div>
       </div>
    
   <!--  <div class="row " id="tables" >
        <div class="col-md-12">
            <table id="conversation" class="table">
                <thead>
                <tr >
                    <th></th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div> -->
    
    <div id="conversation">
	     <ul id="greetings" style="width: 50vw; height: 50vh; overflow: auto">
	
	     </ul>
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
	  
	  
/* 	  $("#greetings").append("<tr bgcolor='#e6f2ff'><td style='text-align:right'>" + "you: "+ messageInput.value +"("+n+":" + m +")"+"</td></tr>"); */
 
 
 	 $("#greetings").append("<li class='me' >" + "You: "+ messageInput.value +"("+n+":" + m +")"+"</li>");
	  document.getElementById('msg').value = "";
}


function showGreeting(message) {
	   
   /*  $("#greetings").append("<tr bgcolor='#b3d9ff'><td>" + message + "</td></tr>"); */
   
	 $("#greetings").append("<li class='him'>" + message + "</li>");
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    
     $( "#connect" ).click(function() { connect(); }); 

   
    $( "#send" ).click(function() { sendName(); });
});



$(document).ready(function() {
   
	
	connect();
    
});


</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>