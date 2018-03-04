$(document).ready(function() {

	$("#payment-form").on('submit', function(e){
		e.preventDefault();

		//TODO add the validators
		$("input[name=cardNumber]");
		$("input[name=cardExpiry]");
		$("input[name=cardCVC]");
		$("input[name=number_of_points]");

		var data = {
			"points" : $("input[name=number_of_points]").val()
		};
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/user/payment",
			data : JSON.stringify(data),
			dataType : 'text',
			success : function(result) {
				if (result == "success") {
					window.location.href = "/parent";
				}
				else {
					alert("Error!")
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