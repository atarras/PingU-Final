$(document).ready(function() {
	
	/**
	 * When clicking on the edit button in the last column
	 */
	$(".action-button").on("click", function() {
		var userType = $(this).closest("div").attr("id");
		
		/* Populate our edit trainee modal's input with this user's data */
		
		/* Get the text of each td in the row and use it as default value of our edit form */
		$(this).closest("tr").find("td").each(function() {
			var columnClass = $(this).attr("class");
			var value = $(this).text().trim();
			
			/* if it is a select element, select the corresponding option with our value */
			if ($("#edit-" + columnClass).is("select")) {
				$("#edit-" + columnClass + " option[value='" + value + "']").attr("selected", "selected");
			} else {
				$("#edit-" + columnClass).val(value);
				$("#edit-" + columnClass).text(value);
			}
			
			$("#edit-" + columnClass).attr("data-original-value", value);
			
		});
		
		/* Set the starting version of status toggle */
		if ($("#edit-" + userType + "-status").val() == "true") {
			$(".status-open").css("display", "");
			$(".status-close").css("display", "none");
			
		} else {
			$(".status-open").css("display", "none");
			$(".status-close").css("display", "");

		}
		
		/* Set starting version of visibility toggle */
		if ($("#edit-" + userType + "-visibility").val() == "true") {
			$(".set-visible").css("display", "");
			$(".set-invisible").css("display", "none");
			
		} else {
			$(".set-visible").css("display", "none");
			$(".set-invisible").css("display", "");
		}
		
	});
	
	/**
	 * Clicking on status open
	 */
	$(".status-open").on("click", function() {
		var statusCloseButton = $(this).next();
		$(this).css("display", "none");
		statusCloseButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("false");
	});
	
	/**
	 * Clicking on status close
	 */
	$(".status-close").on("click", function() {
		var statusOpenButton = $(this).prev();
		$(this).css("display", "none");
		statusOpenButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("true");
	});
	
	/**
	 * Clicking on set visible
	 */
	$(".set-visible").on("click", function() {
		var setInvisibleButton = $(this).next();
		$(this).css("display", "none");
		setInvisibleButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("false");
	});
	
	/**
	 * Clicking on set invisible
	 */
	$(".set-invisible").on("click", function() {
		var setVisibleButton = $(this).prev();
		$(this).css("display", "none");
		setVisibleButton.css("display", "");
		
		$($(this).siblings("input")[0]).val("true");
	});
	
	
	/**
	 * Toggling a icon button should mark its group as editted
	 */
	$("button.edittable").on("click", function() {
		$(this).parent().find("button").addClass("editted");
	});
	
	/**
	 * Changing the value of an edittable input should mark it as editted
	 */
	$("input.edittable").on("blur", function() {
		/* Mark input as editted if its value has changed from original */
		if ($(this).val() != $(this).attr("data-original-value")) {
			$(this).addClass("editted");
		} else {
			console.log("false");
			$(this).removeClass("editted");
		}
		
	});
	
	/**
	 * Closing the edit modal should remove all color-coded editted fields
	 */
	$(".edit-modal").on("hidden.bs.modal", function () {
		$(this).find("button, input").removeClass("editted");
	});
	
	/* ==== Password confirmation check ==== */
	/**
	 * If password and confirm password do not match when unfocusing, then give them an error
	 */
	$(".password, .confirm-password").blur(function() {
		
		var thisPasswordElement = $(this);
		var otherPasswordElement;
		var thisPassword = thisPasswordElement.val();
		var otherPassword;
		var isConfirmPasswordElement = false;
		
		if ($(this).hasClass("password")) {
			otherPasswordElement = $(this).closest("form").find(".confirm-password");
			isConfirmPasswordElement = false;
		} else {
			otherPasswordElement = $(this).closest("form").find(".password");
			isConfirmPasswordElement = true;
		}
		otherPassword = otherPasswordElement.val();
		if (thisPassword != otherPassword && thisPassword != "" && otherPassword != "") {
			console.log("hi");
			if (isConfirmPasswordElement) {
				thisPasswordElement.addClass("invalid-input");
			} else {
				otherPasswordElement.addClass("invalid-input");
				
			}
		} else {
			thisPasswordElement.removeClass("invalid-input");
			otherPasswordElement.removeClass("invalid-input");
		}
		
	});
	
	/**
	 * If there is invalid input within the form, prevent submission of the form
	 */
	$(".submit-button").click(function(e) {
		var invalidInputs = $(this).closest("form").find(".invalid-input");
		if (invalidInputs.length != 0) {
			e.preventDefault();
		}
	});
	
	
});