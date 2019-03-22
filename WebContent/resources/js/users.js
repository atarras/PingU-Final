$(document).ready(function() {
	
	
	$(".action-button").on("click", function() {
		console.log("editing user...");
		
		/* Populate our edit trainee modal's input with this user's data */
		
		/* Get the text of each td in the row and use it as default value of our edit form */
		$(this).closest("tr").find("td").each(function() {
			var columnClass = $(this).attr("class");
			$("#edit-" + columnClass).val($(this).text());
		});
		
	});
	
//	var traineeFirstnameHidden = false;
//	$("#trainee-options").click(function() {
//		if (traineeFirstnameHidden) {
//			
//			$(".trainee-firstname").css("display", "");
//			traineeFirstnameHidden = false;
//		} else {
//			$(".trainee-firstname").css("display", "none");
//			traineeFirstnameHidden = true;
//		}
//	});
	
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
	
	/**
	 * Prompts whether you want to delete a user
	 */
	$(".delete-user").on("click", function() {
		console.log("prompt user deletion");
		$("#edit-trainee-body").css("display", "none");
		$("#delete-trainee-body").css("display", "");
	});
	
	
});