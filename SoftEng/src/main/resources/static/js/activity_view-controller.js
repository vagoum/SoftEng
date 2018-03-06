$(document).ready(function() {

	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	}


	var bookData = {
			ticketsBought: "",
			activityId : ""
	};

	$("#activity-details-title");

	$("#activity-details-text");

	$("#activity-details-list");

	$("#organizer-details-name");

	$("#organizer-details-text");

	$("#activity-details-book-btn").click(function(e){
        e.preventDefault();
		bookData.ticketsBought = $("input[id=activity-details-tickets]").val();
		bookData.activityId = $.urlParam('id');

		console.log(JSON.stringify(bookData));
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/book_activity",
			data : JSON.stringify(bookData),
			dataType : 'text',
			success : function(result) {
				console.log(JSON.stringify(result));
				if (result == "success") {
					swal("Booking completed!", "You will shortly receive an email with booking details and electronic ticket!", "success").then((value) => {
						window.location.href = "/parent";
					});
				}
				else if (result == "no tickets left"){
					 swal("No tickets left", "The event doesn't have the amount of requested tickets", "error");
				}
				else if (result == "not enough points"){
					 swal("Not enough points", "Not enough points", "error");
				}
			},
			error : function(e) {
				console.log(e);
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});


	});

});
