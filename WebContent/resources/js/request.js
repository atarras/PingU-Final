function div_show(){
	document.getElementById('popUpArea').style.display="block";
}

function div_hide(){
	document.getElementById('popUpArea').style.display="none";
}

function submitDenyMessage(requestId){
	var comment = prompt("Reason for Denial:");
	if(comment != null){
		document.write(requestId);
	}
	
}