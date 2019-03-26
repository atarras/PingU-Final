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
				$(this).append('<i class="fas fa-lock-open"></i>');
			} else {
				$(this).append('<i class="fas fa-lock"></i>');
			}
		});
		
		/**
		 * When document loads, display the appropriate icons for visibility
		 * based on whether they are true/false
		 */
		$("tbody ." + userTypes[i] + "-visibility").each(function() {
			var isVisible = $($(this).find("p")[0]).text().trim();
			
			if (isVisible == "true") {
				$(this).append('<i class="fas fa-eye"></i>');
			} else {
				$(this).append('<i class="fas fa-eye-slash"></i>');
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