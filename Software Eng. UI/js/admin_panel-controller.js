$( document ).ready(function() {

  $(".btn").on('click', function(){
  	//Get the data from the specific row, that was clicked
  	var clickedId = $(this).attr('id');
  	var currentTableRow = $(this).closest("tr");
  	var data = {
  		"user":{
	  		"first_name" : currentTableRow.children("#user_first-name").html(),
	  		"last_name" : currentTableRow.children("#user_last-name").html(),
	  		"address" : currentTableRow.children("#user_address").html(),
	  		"email" : currentTableRow.children("#user_email").html()
  		},
  		"action": ""
  	};

  	//Check which button was clicked
  	if(clickedId == "block_btn"){
  		data.action = "block";
  	}else if(clickedId == "delete_btn"){
  		data.action = "delete";
  	}else if(clickedId == "verify_btn"){
  		data.action = "verify";
  	}else if(clickedId == "reset_btn"){
  		data.action = "reset";
  	}
  	
  	//Notify the server about the taken action
  	$.post("/admin/manageUsers.jsp", )
  		.done(function(responce){
		  	if(clickedId == "block_btn"){
			  	$(this).addClass("disabled");
		  	}else if(clickedId == "delete_btn"){
		  		currentTableRow.remove();
		  		//delete the current row, with animation
		  		//currentTableRow.hide('slow', function(){ currentTableRow.remove(); });
		  	}else if(clickedId == "verify_btn"){
		  		$(this).addClass("disabled");
		  	}else if(clickedId == "reset_btn"){
		  		//TODO
		  	}
  		}).fail(function(){
  			alert("Something went wrong");
  	});

  });
  
});