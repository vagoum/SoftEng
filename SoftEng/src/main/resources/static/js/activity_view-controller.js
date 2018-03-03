$(document).ready(function() {

	var bookData = {
			activityId : "",
			ticketsBought: 1
	};
	
	$("#activity-details-title");

	$("#activity-details-text");

	$("#activity-details-list");

	$("#organizer-details-name");

	$("#organizer-details-text");

	$("#activity-details-book-btn").click(function(e){
        e.preventDefault();
		bookData.ticketsBought = $("input[name=activity-details-tickets]").val();


		
		/*
		$.ajax({
			type : "POST",
			url : "/activity/create",
			processData : false,
			contentType : false,
			data : formData,
			success : function(result) {
				console.log(result);
				window.location.href = "/activity_view?id=" + result;
			},
			error : function(data) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
		*/
	});

});