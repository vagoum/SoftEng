$( document ).ready(function() {

  $(".btn").on('click', function(){
  	//Get the data from the specific row, that was clicked
  	var clickedId = $(this).attr('id');
  	var currentTableRow = $(this).closest("tr");
    
  	var data = {
	  		"email" : currentTableRow.children("#user_email").html(),
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
  	
    //currentTableRow.children("#user_first-name").val();
    console.log(currentTableRow.children("#user_first-name").html());
  	//Notify the server about the taken action
    // $.ajax({
    //     type:"POST",
    //     url: "URL",
    //     data: data,
    //     contentType: "application/json; charset=utf-8",
    //     dataType: "json",
    //     success: function(message) {
    //       if(clickedId == "block_btn"){
    //         currentTableRow.children("#"+clickedId).addClass("disabled");
    //         console.log(currentTableRow.children("#"+clickedId).html());
    //         $(this).addClass("disabled");
    //       }else if(clickedId == "delete_btn"){
    //         currentTableRow.remove();
    //         //delete the current row, with animation
    //         //currentTableRow.hide('slow', function(){ currentTableRow.remove(); });
    //       }else if(clickedId == "verify_btn"){
    //        $(this).addClass("disabled");
    //         currentTableRow.children("#"+clickedId).addClass("disabled");
    //       }else if(clickedId == "reset_btn"){
    //       }
    //     },
    //     failure: function(message){
    //       alert("Something went wrong");
    //     }
    // });

  	$.post("/admin/manageUsers", data)
  		.done(function(responce){
        if(clickedId == "block_btn"){
          currentTableRow.children("#"+clickedId).addClass("disabled");
          console.log(currentTableRow.children("#"+clickedId).html());
          $(this).addClass("disabled");
        }else if(clickedId == "delete_btn"){
          currentTableRow.remove();
          //delete the current row, with animation
          //currentTableRow.hide('slow', function(){ currentTableRow.remove(); });
        }else if(clickedId == "verify_btn"){
         $(this).addClass("disabled");
          currentTableRow.children("#"+clickedId).addClass("disabled");
        }else if(clickedId == "reset_btn"){
        }
  		}).fail(function(){
  			alert("Something went wrong");
  	});
  });
  
});