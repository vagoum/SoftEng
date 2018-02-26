$( document ).ready(function() {
	var form = $("#password-form");
	$("#submit_btn").on('click', function(e){
		e.preventDefault();

		var pass1 = $('input[name=password1]').val();
		var pass2 = $('input[name=password2]').val();

		if(pass1 == pass2){
			form.submit();
		}else{
			alert("The provided passwords dont match");
		}
  	});

});