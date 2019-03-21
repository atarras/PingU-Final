$(document).ready(function() {
	
	
	$(".action-button").on("click", function() {
		console.log("editing user...");
		
		/* Populate our edit trainee modal's input with this user's data */
		var id = $(this).closest("tr").attr("id");
		console.log(id);
		console.log($($(this).closest("tr").find(".trainee-firstname")[0]).text());
		$("#edit-firstname-field").val($($(this).closest("tr").find(".trainee-firstname")[0]).text());
		$("#edit-lastname-field").val($($(this).closest("tr").find(".trainee-lastname")[0]).text());
		
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
	
});