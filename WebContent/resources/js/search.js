function getID(userId) {
	console.log(userId);
	document.getElementById('receiverId').value = userId;
//	document.getElementById('senderFirstName').value = firstname;
//	document.getElementById('senderLastName').value = lastname;
}

$(document).ready(function() {

	$(".mailButton").click(function() {
		var userId = $(".mailButton i").attr('id');
		console.log(userId);
	});
});