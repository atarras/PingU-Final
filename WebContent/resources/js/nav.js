$(document).ready(function() {
	$("#n").click(function() {
		console.log("n");
	})
	
	$("#userSearch").click(function(){
		 $(".searchField").attr('placeholder', 'User Search');
		 $(".searchField").attr('name', 'searchName');
		 $("#searchForm").attr('action', 'searchUsers'); 
	})
	
	$("#groupSearch").click(function(){
		 $(".searchField").attr('placeholder', 'Group Search');
		 $(".searchField").attr('name', 'gSearchName');
		 $("#searchForm").attr('action', 'findGroups'); 
	})
	
});