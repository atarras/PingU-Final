$(document).ready(function() {
	
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
	 * When document loads, display the appropriate icons for status
	 * based on whether they are true/false
	 */
	$("tbody .trainee-status").each(function() {
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
	$("tbody .trainee-visibility").each(function() {
		var isVisible = $($(this).find("p")[0]).text().trim();
		
		if (isVisible == "true") {
			$(this).append('<i class="fas fa-eye"></i>');
		} else {
			$(this).append('<i class="fas fa-eye-slash"></i>');
		}
	});
	
	
	/**
	 * When clicking on the edit button in the last column
	 */
	$(".action-button").on("click", function() {
		console.log("editing user...");
		
		/* Populate our edit trainee modal's input with this user's data */
		
		/* Get the text of each td in the row and use it as default value of our edit form */
		$(this).closest("tr").find("td").each(function() {
			var columnClass = $(this).attr("class");
			$("#edit-" + columnClass).val($(this).text().trim());
			$("#edit-" + columnClass).text($(this).text().trim());
		});
		
		/* Set the starting version of trainee status toggle */
		if ($("#edit-trainee-status").val() == "true") {
			console.log("status true");
			
			$("#trainee-status-open").css("display", "");
			$("#trainee-status-close").css("display", "none");
			
		} else {
			console.log("status false");
			
			$("#trainee-status-open").css("display", "none");
			$("#trainee-status-close").css("display", "");

		}
		
		/* Set starting version of trainee visibility toggle */
		if ($("#edit-trainee-visibility").val() == "true") {
			console.log("visibility true");
			$("#trainee-set-visible").css("display", "");
			$("#trainee-set-invisible").css("display", "none");
			
		} else {
			console.log("visibility false");
			$("#trainee-set-visible").css("display", "none");
			$("#trainee-set-invisible").css("display", "");
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
		console.log($("#edit-trainee").serialize());
		
		$.ajax({
			type: "POST",
			url: "user?id=" + id + "&" + $("#edit-trainee").serialize(),
			success: function(data) {
				/* Redirect page since ajax calls seems to prevent our server from redirecting */
				window.location.replace(data);
			}
		});
		
	});
	
	/**
	 * Clicking on status open
	 */
	$("#trainee-status-open").on("click", function() {
		var statusCloseButton = $(this).next();
		$(this).css("display", "none");
		statusCloseButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("false");
	});
	
	/**
	 * Clicking on status close
	 */
	$("#trainee-status-close").on("click", function() {
		var statusOpenButton = $(this).prev();
		$(this).css("display", "none");
		statusOpenButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("true");
	});
	
	/**
	 * Clicking on set visible
	 */
	$("#trainee-set-visible").on("click", function() {
		var setInvisibleButton = $(this).next();
		$(this).css("display", "none");
		setInvisibleButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("false");
	});
	
	/**
	 * Clicking on set invisible
	 */
	$("#trainee-set-invisible").on("click", function() {
		var setVisibleButton = $(this).prev();
		$(this).css("display", "none");
		setVisibleButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("true");
	});
	
	$("button.edittable").on("click", function() {
		$(this).parent().find("button").addClass("editted");
	});
	
	
	/**
	 * Closing the edit modal should remove all color-coded editted fields
	 */
	$("#edit-trainee-modal").on("hidden.bs.modal", function () {
		$(this).find("button").removeClass("editted");
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