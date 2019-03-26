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
	
	$("#description-button").click(function(){
		//$(".personal-button").css("visibility", "visible");
		
		var userDescription = $("#description-text").text();
		
		$(this).css("visibility", "hidden");
		$("#description-text").replaceWith("<input id='description-input' placeholder='" + userDescription + "' title='User description.'>");
	})
	
	$("#form-reset").click(function() {
		$(".personal-button").css("visibility", "hidden");
		$("#edit-button").css("visibility", "visible");
		
		$("#countryInput").replaceWith("<p id='country'>" + country + "</p>");
		$("#cityInput").replaceWith("<p id='city'>" + city + "</p>");
		$("#phoneInput").replaceWith("<p id='phone'>" + phone + "</p>");
	})
});