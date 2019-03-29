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
	  
	  
	  $("#greetings").append("<tr><td>" + "you: "+ messageInput.value +"("+n+":" + m +")"+"</td></tr>");
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

