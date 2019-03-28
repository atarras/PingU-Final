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
		var userDescription = $("#description-text").text();
		if($("#description-submit").css("visibility") == "hidden")
		{
			$("#description-submit").css("visibility", "visible");
		}
		else
		{
			var userDescritionPlaceholder = $("#description-input").attr('placeholder');
			$("#description-submit").css("visibility", "hidden");
			$("#description-input").replaceWith("<p id='description-text' class='card-text'>"+userDescritionPlaceholder.trim()+"</p>");
			return;
		}
		
		if (((userDescription == "" || userDescription == "undefined")) && ($("#description-submit").css("visibility") == "visible"))
		{
			console.log("hello");
			$("#description-text").replaceWith("<input type='text' id='description-input' name='newDesc' placeholder='Add a user description' title='User description.'>");
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
			$("#linkedin-input").replaceWith("<a href='#' id='linkedin-link'>"+userLinkedInPlaceholder.trim()+"</a>");
			return;
		}
		
		if (((userLinkedIn == "") || (userLinkedIn =="undefined")) && ($("#linkedin-submit").css("visibility") == "visible"))
		{
			console.log("goodbye");
			$("#linkedin-link").replaceWith("<input type='text' id='linkedin-input' name='newLinkedIn' placeholder='Your linkedin link' title='Your linkedin.'>");
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
			$("#role-input").replaceWith("<p href='#' id='role-text'>"+userRoleTitlePlaceholder.trim()+"</p>");
			return;
		}
		
		if (((userLinkedIn == "") || (userLinkedIn =="undefined")) && ($("#role-submit").css("visibility") == "visible"))
		{
			console.log("goodbye");
			$("#role-text").replaceWith("<input type='text' id='role-input' name='newJobTitle' placeholder='Your linkedin link' title='Your linkedin.'>");
		}
		else
		{
			$("#role-text").replaceWith("<input type='text' id='role-input' name='newJobTitle' placeholder='"+userLinkedIn.trim()+"' title='Your linkedin.'>");
		}
	})
	
	
	$("#form-reset").click(function() {
		$(".personal-button").css("visibility", "hidden");
		$("#edit-button").css("visibility", "visible");
		
		$("#countryInput").replaceWith("<p id='country'>" + country + "</p>");
		$("#cityInput").replaceWith("<p id='city'>" + city + "</p>");
		$("#phoneInput").replaceWith("<p id='phone'>" + phone + "</p>");
	})
});