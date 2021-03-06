$(document).ready(function() {
	
	var country = $("#country").text();
	var city = $("#city").text();
	var phone = $("#phone").text();
	
	$("#edit-button").click(function() {
		$(".personal-button").css("visibility", "visible");
		$(this).css("visibility", "hidden");
		
		if(city == "")
		{
			$("#city").replaceWith("<input type='text' class='form-control' name='city' id='cityInput' placeholder='Enter your city' title='Your currrent city.'>");
		}
		else
		{
			$("#city").replaceWith("<input type='text' class='form-control' name='city' id='cityInput' placeholder='" + city + "' title='Your currrent city.'>");
		}
		
		if(country == "")
		{
			$("#country").replaceWith("<input type='text' class='form-control' name='country' id='countryInput' placeholder='Enter your county' title='Your current country.'>");
		}
		else
		{
			$("#country").replaceWith("<input type='text' class='form-control' name='country' id='countryInput' placeholder='"+ country + "' title='Your current country.'>");
		}
		
		if(phone == "")
		{
			$("#phone").replaceWith("<input type='text' class='form-control' name='phone' id='phoneInput' placeholder='Enter new number' title='Your phone number.'>");
		}
		else
		{
			$("#phone").replaceWith("<input type='text' class='form-control' name='phone' id='phoneInput' placeholder='" + phone + "' title='Your phone number.'>");
		}
		//$("#phone").empty().append("<input type='phone' class='form-control' name='phoneInput' id='phone' placeholder='" + phone + "' title='Your phone number.'>");
	})
	
	/*This function will toggle the description field to an input field with a placeholder equalling to what is in the the field in the first place
	 * It will also toggle the visibility of the submit button pressing this icon
	 * */
	$("#description-button").click(function(){
		if($("#description-submit").css("visibility") == "hidden")
		{
			$("#description-submit").css("visibility", "visible");
		}
		else
		{
			var userDescriptionPlaceholder = $("#description-input").attr('placeholder');
			$("#description-submit").css("visibility", "hidden");
			if(userDescriptionPlaceholder == "" || userDescriptionPlaceholder == undefined)
			{
				$("#description-input").replaceWith("<p id='description-text' class='card-text'></p>");
			}
			else
			{
				$("#description-input").replaceWith("<p id='description-text' class='card-text'>"+userDescriptionPlaceholder.trim()+"</p>");
			}
			return;
		}
		
		var userDescription = $("#description-text").text();
		if (((userDescription == "" || userDescription == undefined)) && ($("#description-submit").css("visibility") == "visible"))
		{
			$("#description-text").replaceWith("<input type='text' id='description-input' name='newDesc' title='User description.'>");
		}
		else
		{
			$("#description-text").replaceWith("<input type='text' id='description-input' name='newDesc' placeholder='"+userDescription.trim()+"' title='User description.'>");
		}
		
	})
	
	/*This function will toggle the linkedin link field to an input field with a placeholder equalling to what is in the the field in the first place
	 * It will also toggle the visibility of the submit button pressing this icon
	 * */
	$("#linkedin-button").click(function(){
		
		if($("#linkedin-submit").css("visibility") == "hidden")
		{
			var userLinkedIn = $("#linkedin-link").text();
			$("#linkedin-submit").css("visibility", "visible");
		}
		else
		{
			var userLinkedInPlaceholder = $("#linkedin-input").attr('placeholder');
			$("#linkedin-submit").css("visibility", "hidden");
			if(userLinkedInPlaceholder == "" || userLinkedInPlaceholder == undefined)
			{
				$("#linkedin-input").replaceWith("<a href='#' id='linkedin-link'></a>");
			}
			else
			{
				$("#linkedin-input").replaceWith("<a href='#' id='linkedin-link'>"+userLinkedInPlaceholder.trim()+"</a>");
			}
			return;
		}
		
		if (((userLinkedIn == "") || (userLinkedIn == undefined)) && ($("#linkedin-submit").css("visibility") == "visible"))
		{
			$("#linkedin-link").replaceWith("<input type='text' id='linkedin-input' name='newLinkedIn' title='Your linkedin.'>");
		}
		else
		{
			$("#linkedin-link").replaceWith("<input type='text' id='linkedin-input' name='newLinkedIn' placeholder='"+userLinkedIn.trim()+"' title='Your linkedin.'>");
		}
		
	})
	
	$("#role-button").click(function(){
		
		if($("#role-submit").css("visibility") == "hidden")
		{
			var userLinkedIn = $("#role-text").text();
			$("#role-submit").css("visibility", "visible");
		}
		else
		{
			var userRoleTitlePlaceholder = $("#role-input").attr('placeholder');
			$("#role-submit").css("visibility", "hidden");
			if(userRoleTitlePlaceholder == "" || userRoleTitlePlaceholder == undefined)
			{
				$("#role-input").replaceWith("<p href='#' id='role-text'></p>");
			}
			else
			{
				$("#role-input").replaceWith("<p href='#' id='role-text'>"+userRoleTitlePlaceholder.trim()+"</p>");
			}
			return;
		}
		
		if (((userLinkedIn == "") || (userLinkedIn ==undefined)) && ($("#role-submit").css("visibility") == "visible"))
		{
			$("#role-text").replaceWith("<input type='text' id='role-input' name='newJobTitle' placeholder='Your linkedin link' title='Your linkedin.'>");
		}
		else
		{
			$("#role-text").replaceWith("<input type='text' id='role-input' name='newJobTitle' placeholder='"+userLinkedIn.trim()+"' title='Your linkedin.'>");
		}
	})
	
	$("#employer-button").click(function(){
		
		console.log("changing employer" + $("#employer-text").text());
		
		var value = $("#employer-text").text();
		$("#edit-employer-text option[value='" + value + "'").prop("selected", "selected");
		
		$("#display-employer").css("display", "none");
		$("#edit-employer").css("display", "");
		
		/*if($("#employer-submit").css("visibility") == "hidden")
		{
			var userLinkedIn = $("#employer-text").text();
			$("#employer-submit").css("visibility", "visible");
		}
		else
		{
			//var userRoleTitlePlaceholder = $("#employer-input").attr('placeholder');
			$("#employer-submit").css("visibility", "hidden");
			//$("#employer-input").replaceWith("<p href='#' id='employer-text'>"+userRoleTitlePlaceholder.trim()+"</p>");
			$("#employer-input").replaceWith("<p href='#' id='employer-text'></p>");
			return;
		}
		
		if (((userLinkedIn == "") || (userLinkedIn =="undefined")) && ($("#employer-submit").css("visibility") == "visible"))
		{
			console.log("goodbye");
			
			var employers = $("#something").attr(n)
			
			//$("#employer-text").replaceWith("<input type='text' id='employer-input' name='newJobTitle' placeholder='Your linkedin link' title='Your linkedin.'>");
			$("#employer-text").replaceWith('<select id="employer-input" class="form-control edittable" name="employer">'+
												'<option value="">*** Select Option ***</option>'+
													'<c:forEach items="${employers}" var="employer">'+
														'<option value="${employer}">${employer}</option>'+
													'</c:forEach>'+
													'</select>');
		}
		else
		{
			//$("#employer-text").replaceWith("<input type='text' id='employer-input' name='newJobTitle' placeholder='"+userLinkedIn.trim()+"' title='Your linkedin.'>");
			$("#employer-text").replaceWith('<select id="employer-input" class="form-control edittable" name="employer">'+
					'<option value="">*** Select Option ***</option>'+
						'<c:forEach items="${employers}" var="employer">'+
							'<option value="${employer}">${employer}</option>'+
						'</c:forEach>'+
						'</select>');
		}*/
	});
	
	
	$("#form-reset").click(function() {
		$(".personal-button").css("visibility", "hidden");
		$("#edit-button").css("visibility", "visible");
		
		$("#countryInput").replaceWith("<p id='country'>" + country + "</p>");
		$("#cityInput").replaceWith("<p id='city'>" + city + "</p>");
		$("#phoneInput").replaceWith("<p id='phone'>" + phone + "</p>");
	});
});