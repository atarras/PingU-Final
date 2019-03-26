$(document).ready(function() {
	
	/**
	 * When document loads, display the appropriate icons for status
	 * based on whether they are true/false
	 */
	$("tbody .group-status").each(function() {
		var isActive = $($(this).find("p")[0]).text().trim();
		
		if (isActive == "true") {
			$(this).append('<i class="fas fa-lock-open"></i>');
		} else {
			$(this).append('<i class="fas fa-lock"></i>');
		}
	});
	
	$("#confirm-edit-group").on("click", function(e) {
		e.preventDefault();
		
		var id = $("#edit-group-id").text();
		$.ajax({
			type: "POST",
			url: "group-edit?id=" + id + "&" + $("#edit-group").serialize(),
			success: function(data) {
				/* Redirect page since ajax calls seems to prevent our server from redirecting */
				window.location.replace(data);
			}
		});
		
	});
	
});