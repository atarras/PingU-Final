$(document).ready(function() {
	
	/**
	 * When document loads, display the appropriate icons for status
	 * based on whether they are true/false
	 */
	$("tbody .group-status").each(function() {
		var isActive = $($(this).find("p")[0]).text().trim();
		
		if (isActive == "true") {
			$(this).append('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 12 16">'+
                  	'<path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/>'+
	                      '</svg>');
		} else {
			$(this).append('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 12 16">'+
                      		'<path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/>'+
                      	'</svg>');
		}
	});
	
	$("#confirm-edit-group").on("click", function(e) {
		e.preventDefault();
		var id = $("#edit-group-id").text();
		console.log("editGroup?id=" + id + "&" + $("#edit-group").serialize());
		$.ajax({
			type: "POST",
			url: "editGroup?id=" + id + "&" + $("#edit-group").serialize(),
			success: function(data) {
				console.log("success");
				/* Redirect page since ajax calls seems to prevent our server from redirecting*/ 
				//location.reload();
				window.location.replace(data);
			}
		});
		
	});
	
});