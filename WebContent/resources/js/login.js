$(document).ready(function() {
	
	$("#signup-usertype-field").on("change", function() {
		
		if ($("#signup-usertype-field :selected").text() == "Trainee") {
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
	/*$("input").keyup(function() {
		
		var id = $(this).attr("id");
		console.log($("#" + id));
		console.log($($("#" + id).prev()));
		
		if ($(this).val().length > 0) {
			$($("#" + id).prev()).css("display", "");
		} else {
			$($("#" + id).prev()).css("display", "none");
		}
		
	});*/
	
	/**
	 * Typing into the recover password username field will check whether it's a valid username
	 * then display the recover password fields
	 */
	$("#recover-password-username").keyup(function() {
		
		$.ajax({
			type: "GET",
			url: "user",
			data: {
				"username": $("#recover-password-username").val()
			},
			success: function(data) {
				if (data.length > 0) {
					$("#recover-password-fields").css("display", "");
					$("#rp-id").val(data);
				} else {
					$("#recover-password-fields").css("display", "none");
				}
			}
		});
		
	});
	
});