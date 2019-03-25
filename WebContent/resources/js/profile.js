$(document).ready(function() {
	
	var country = $("#country").text();
	var city = $("#city").text();
	var phone = $("#phone").text();
	
	$("#edit-button").click(function() {
		$(".personal-button").css("visibility", "visible");
		$(this).css("visibility", "hidden");
		
		console.log(city);
		
		$("#country").replaceWith("<input type='text' class='form-control' name='country' id='countryInput' placeholder='"+ country + "' title='Your current country.'>");
		$("#city").replaceWith("<input type='text' class='form-control' name='city' id='cityInput' placeholder='" + city + "' title='Your currrent city.'>");
		
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
	
	$("#form-reset").click(function() {
		$(".personal-button").css("visibility", "hidden");
		$("#edit-button").css("visibility", "visible");
		
		console.log(country);
		
		$("#countryInput").replaceWith("<p id='country'>" + country + "</p>");
		$("#cityInput").replaceWith("<p id='city'>" + city + "</p>");
		$("#phoneInput").replaceWith("<p id='phone'>" + phone + "</p>");
	})
});