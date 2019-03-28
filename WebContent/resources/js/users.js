$(document).ready(function() {
	
	/**
	 * Dynamically generate column toggles for all types of users
	 */
	var userTypes = ["trainee", "consultant", "admin"];
	for (var i = 0; i < userTypes.length; i++) {
		
		/**
		 * When document loads, add each column in userType to options
		 */
		$("#" + userTypes[i] + " thead > tr > th").each(function() {
			
			var id = "show-" + $(this).attr("class");
			var label = $(this).text();
			
			$("#" + userTypes[i] + "-column-toggles").append(
					'<div class="form-check">' +
			          '<input class="form-check-input column-toggle" type="checkbox" id="' + id + '">' +
			          '<label class="form-check-label" for="' + id + '">' +
			          	label +
			          '</label>' +
	            	'</div>');
			
		});
		
		/**
		 * Check specific userType columns to be shown by default
		 */
		$("#show-" + userTypes[i] + "-id").prop("checked", true);
		$("#show-" + userTypes[i] + "-username").prop("checked", true);
		$("#show-" + userTypes[i] + "-status").prop("checked", true);
		$("#show-" + userTypes[i] + "-actions").prop("checked", true);
		
		if (userTypes[i] != "admin") {
			$("#show-" + userTypes[i] + "-firstname").prop("checked", true);
			$("#show-" + userTypes[i] + "-lastname").prop("checked", true);
			$("#show-" + userTypes[i] + "-city").prop("checked", true);
			$("#show-" + userTypes[i] + "-country").prop("checked", true);
			$("#show-" + userTypes[i] + "-visibility").prop("checked", true);
			
			if (userTypes[i] == "trainee") {
				$("#show-" + userTypes[i] + "-stream").prop("checked", true);
			} else {
				$("#show-" + userTypes[i] + "-title").prop("checked", true);
				$("#show-" + userTypes[i] + "-employer").prop("checked", true);
			}
		}
		
		/**
		 * When document loads, display the appropriate icons for status
		 * based on whether they are true/false
		 */
		$("tbody ." + userTypes[i] + "-status").each(function() {
			var isActive = $($(this).find("p")[0]).text().trim();
			
			if (isActive == "true") {
				$(this).append('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/></svg>');
			} else {
				$(this).append('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>');
			}	
		});
		
		/**
		 * When document loads, display the appropriate icons for visibility
		 * based on whether they are true/false
		 */
		$("tbody ." + userTypes[i] + "-visibility").each(function() {
			var isVisible = $($(this).find("p")[0]).text().trim();
			
			if (isVisible == "true") {
				$(this).append('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M8.06 2C3 2 0 8 0 8s3 6 8.06 6C13 14 16 8 16 8s-3-6-7.94-6zM8 12c-2.2 0-4-1.78-4-4 0-2.2 1.8-4 4-4 2.22 0 4 1.8 4 4 0 2.22-1.78 4-4 4zm2-4c0 1.11-.89 2-2 2-1.11 0-2-.89-2-2 0-1.11.89-2 2-2 1.11 0 2 .89 2 2z"/></svg>');
			} else {
				$(this).append('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 14"><path fill-rule="evenodd" d="M14.822.854a.5.5 0 1 0-.707-.708l-2.11 2.11C10.89 1.483 9.565.926 8.06.926c-5.06 0-8.06 6-8.06 6s1.162 2.323 3.258 4.078l-2.064 2.065a.5.5 0 1 0 .707.707L14.822.854zM4.86 9.403L6.292 7.97A1.999 1.999 0 0 1 6 6.925c0-1.11.89-2 2-2 .384 0 .741.106 1.045.292l1.433-1.433A3.98 3.98 0 0 0 8 2.925c-2.2 0-4 1.8-4 4 0 .938.321 1.798.859 2.478zm7.005-3.514l1.993-1.992A14.873 14.873 0 0 1 16 6.925s-3 6-7.94 6a6.609 6.609 0 0 1-2.661-.57l1.565-1.566c.33.089.678.136 1.036.136 2.22 0 4-1.78 4-4 0-.358-.047-.705-.136-1.036zM9.338 8.415l.152-.151a1.996 1.996 0 0 1-.152.151z"/></svg>');
			}
		});
	
	}
	
	/**
	 * When document loads, make sure to hide any unchecked option by default 
	 */
	$(".column-toggle").each(function() {
		if (!$(this).is(":checked")) {
			var columnClass = $(this).attr("id").replace("show-", "");
			$("." + columnClass).css("display", "none");
		}
	});
	
	
	/**
	 * Clicking on a checkbox in trainee options will toggle a column on/off
	 */
	$(".column-toggle").on("click", function() {
		
		/* Our toggles have an id of show-{corresponding class name} */
		var columnClass = $(this).attr("id").replace("show-", "");
		
		/* Show/hide appropriate column based on whether this its corresponding controller is checked */
		if ($(this).is(":checked")) {
			$("." + columnClass).css("display", "");
		} else {
			$("." + columnClass).css("display", "none");
		}
	});
	
	$("#confirm-edit-trainee").on("click", function(e) {
		e.preventDefault();
		
		var id = $("#edit-trainee-id").text();
		$.ajax({
			type: "POST",
			url: "user?id=" + id + "&" + $("#edit-trainee").serialize(),
			success: function(data) {
				/* Redirect page since ajax calls seems to prevent our server from redirecting */
				window.location.replace(data);
			}
		});
		
	});
	
	$("#confirm-edit-consultant").on("click", function(e) {
		e.preventDefault();
		
		var id = $("#edit-consultant-id").text();
		$.ajax({
			type: "POST",
			url: "user?id=" + id + "&" + $("#edit-consultant").serialize(),
			success: function(data) {
				/* Redirect page since ajax calls seems to prevent our server from redirecting */
				window.location.replace(data);
			}
		});
		
	});
	
	$("#confirm-edit-admin").on("click", function(e) {
		e.preventDefault();
		
		var id = $("#edit-admin-id").text();
		$.ajax({
			type: "POST",
			url: "user?id=" + id + "&" + $("#edit-admin").serialize(),
			success: function(data) {
				/* Redirect page since ajax calls seems to prevent our server from redirecting */
				window.location.replace(data);
			}
		});
		
	});
	
	
	
	
//	/**
//	 * Prompts whether you want to delete a user.
//	 * Switch out the edit form for a confirm delete form
//	 */
//	$("#delete-trainee").on("click", function() {
//		$("#edit-trainee-body").css("display", "none");
//		$("#delete-trainee-body").css("display", "");
//	});
//	
//	/**
//	 * Closing the edit trainee modal should switch back to original edit form
//	 */
//	$("#edit-trainee-modal").on("hidden.bs.modal", function () {
//		$("#edit-trainee-body").css("display", "");
//		$("#delete-trainee-body").css("display", "none");
//	});
//	
//	/**
//	 * Revert back to edit form
//	 */
//	$("#cancel-delete-trainee").on("click", function() {
//		$("#edit-trainee-body").css("display", "");
//		$("#delete-trainee-body").css("display", "none");
//	});
//	
//	/**
//	 * Delete the trainee in the database
//	 */
//	$("#confirm-delete-trainee").on("click", function() {
//		console.log("deleting traine...");
//		
//		var id = $("#edit-trainee-id").text();
//		console.log(id);
//		
//		$.ajax({
//			type: "DELETE",
//			url: "user?id=" + id,
//			success: function() {
//				console.log("deleted " + id);
//			}
//			
//		});
//	});
	
	
});