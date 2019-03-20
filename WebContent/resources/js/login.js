$(document).ready(function() {
	
	$("#sign-up-usertype-field").on("change", function() {
		
		if ($("#sign-up-usertype-field :selected").text() == "Trainee") {
			/* Hide fields for consultant and make them not required */
			$("#consultant-additional-fields").css("display", "none");
			$("#signup-title-field").prop("required", false);
			$("#signup-employer-field").prop("required", false);
			
			/* Extra fields for trainees */
			$("#signup-stream-field").prop("required", true);
			$("#trainee-additional-fields").css("display", "");
			
			/* Switch action */
			$("#signup-form").prop("action", "signup-t");
		} else {
			/* Hide fields for trainee and make them not required */
			$("#trainee-additional-fields").css("display", "none");
			$("#signup-stream-field").prop("required", false);
			
			/* Extra fields for consultants */
			$("#signup-title-field").prop("required", true);
			$("#signup-employer-field").prop("required", true);
			$("#consultant-additional-fields").css("display", "");
			
			/* Switch action */
			$("#signup-form").prop("action", "signup-c");
		}
		
	});
	
	/**
	 * When you start typing into an input field, display its label so the user can still tell what field they
	 * are typing in after placeholder is written over by their input.
	 * When the input field is empty, hide the label again.
	 */
	$("input").keyup(function() {
		
		var id = $(this).attr("id");
		
		if ($(this).val().length > 0) {
			
			console.log($("#" + id + " ~ label"));
		}
		console.log($(this).attr("id"));
	});
	
});