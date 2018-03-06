$( document ).ready(function() {
	
	$('#submit_btn').click(function(e) {
		var password = $("input[name=password1").val();
		console.log(password);
		// var passwordConfirm = ;
		
	});
	
	 $("#password-form").validate({
	        rules: {
	            "password1": {
	            	required: true,
	                 minlength: 6,
	                 maxlength: 25,	  
	            },
	            "passwordConfirm": {
	            	required: true,
	                 equalTo: "#password1",
	                 minlength: 6,
	                 maxlength: 25,		            },
	        },
	        messages: {
	            "password1": {
	                required: "Please, enter a password",
                 minlength: "Password must be at least 6 characters",
                 maxlength: "Password must be less than 25 characters",

	            },
	            "passwordConfirm": {
	                required: "Please, confirm your password",
                 equalTo: "Password do not match",
                 minlength: "Password must be at least 6 characters",
                 maxlength: "Password must be less than 25 characters",
	            }
	        },
	       
	    });

});