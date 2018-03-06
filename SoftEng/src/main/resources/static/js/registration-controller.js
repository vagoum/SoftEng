$(document).ready(function() {

	
	var userData = {
			firstName : "",
			lastName : "",
			phone : "",
			email : "",
			password : "",
			passwordConfirm: "",
			location : {
				address :"",
				latitude : "",
				longtitude : ""
			}
	};
	
	
	 $("#parent-registration-form").validate({
	        rules: {
	            "parent-first_name": {
	                required: true,
	            },
	            "parent-last_name": {
	                required: true,
	            },

	            "parent-address": {
	                required: true,
	            },
	            "parent-email": {
	                required: true,
	                email: true
	            },
	            "parent-password": {
	                required: true,
                    minlength: 6,
                    maxlength: 25,

	            },
	            "parentpasswordConfirm": {
	                required: true,
                    equalTo: "#parent-password",
                    minlength: 6,
                    maxlength: 25,
	            },
	        },
	        messages: {
	            "parent-first_name": {
	                required: "Please, enter a firstname"
	            },
	            "parent-last_name": {
	                required: "Please, enter a lastname"
	            },
	            "parent-address": {
	                required: "Please, enter a lastname"
	            },
	            "parent-password": {
	                required: "Please, enter a password",
                    minlength: "Password must be at least 6 characters",
                    maxlength: "Password must be less than 25 characters",

	            },
	            "parentpasswordConfirm": {
	                required: "Please, confirm your password",
                    equalTo: "Password do not match",
                    minlength: "Password must be at least 6 characters",
                    maxlength: "Password must be less than 25 characters",
	            },
	            
	            "parent-email": {
	                required: "Please, enter an email",
	                email: "Email is invalid"
	            }
	        },
	        invalidHandler: function(event, validator) {
	            // 'this' refers to the form
	            var errors = validator.numberOfInvalids();
	            if (errors) {
	              var message = 'Invalid form';
	              $("div.error span").html(message);
	              $("div.error").show();
	            } else {
	              $("div.error").hide();
	            }
	          }
	    });
	 
	 
	 
	 $("#organizer-registration-form").validate({
	        rules: {
	            "organizer-first_name": {
	                required: true,
	            },
	            "organizer-last_name": {
	                required: true,
	            },
	            "organizer-address": {
	                required: true,
	            },
	            "organizer-email": {
	                required: true,
	                email: true
	            },
	            "company_name": {
	                required: true,
	            },
	            "company_details": {
	                required: true,
	            },
	            "organizer-password": {
	                required: true,
                 minlength: 6,
                 maxlength: 25,

	            },
	            "organizer-passwordConfirm": {
	                required: true,
                 equalTo: "#organizer-password",
                 minlength: 6,
                 maxlength: 25,
	            },
	        },
	        messages: {
	            "organizer-first_name": {
	                required: "Please, enter a firstname"
	            },
	            "organizer-last_name": {
	                required: "Please, enter a lastname"
	            },
	            "organizer-address": {
	                required: "Please, enter an address"
	            },
	            "organizer-password": {
	                required: "Please, enter a password",
                 minlength: "Password must be at least 6 characters",
                 maxlength: "Password must be less than 25 characters",

	            },
	            "organizer-passwordConfirm": {
	                required: "Please, confirm your password",
                 equalTo: "Password do not match",
                 minlength: "Password must be at least 6 characters",
                 maxlength: "Password must be less than 25 characters",
	            },
	            "organizer-email": {
	                required: "Please, enter an email",
	                email: "Email is invalid"
	            },
	            "company_name": {
	                required: "Please enter a company name",
	            },
	            "company_details": {
	                required: "Please enter details for your company",
	            },
	        },
	        invalidHandler: function(event, validator) {
	            // 'this' refers to the form
	            var errors = validator.numberOfInvalids();
	            if (errors) {
	              var message = 'Invalid form';
	              $("div.error span").html(message);
	              $("div.error").show();
	            } else {
	              $("div.error").hide();
	            }
	          }
	    });
	 
	
	function initMap(currentForm) {

        var map = new google.maps.Map(currentForm.find($(".map")).get(0), {
        	center: {lat: 37.98, lng: 23.72},
        	zoom: 14,
        	disableDoubleClickZoom: false,
        	draggable: false,
    		scrollwheel: false,
    		panControl: false
        });

        google.maps.event.addListener(map, 'dblclick', function(e) {
        var positionDoubleclick = e.latLng;
        marker.setPosition(positionDoubleclick);
        // if you don't do this, the map will zoom in
        // e.stopPropagation();
        });

        var input = currentForm.find(".pac-input").get(0);
        var autocomplete = new google.maps.places.Autocomplete(input);
        // Bind the map's bounds (viewport) property to the autocomplete object,
        // so that the autocomplete requests use the current map bounds for the
        // bounds option in the request.
        autocomplete.bindTo('bounds', map);

        var infowindow = new google.maps.InfoWindow();
        var infowindowContent = document.getElementById('infowindow-content');
        infowindow.setContent(infowindowContent);

        var marker = new google.maps.Marker({
          map: map,
          anchorPoint: new google.maps.Point(0, -29)
        });

        autocomplete.addListener('place_changed', function(e) {
        	infowindow.close();
        	marker.setVisible(false);
          	var place = autocomplete.getPlace();

          	userData.location.latitude = place.geometry.location.lat();
          	userData.location.longtitude = place.geometry.location.lng(); 

          	if (!place.geometry) {
            	// User entered the name of a Place that was not suggested and
            	// pressed the Enter key, or the Place Details request failed.
            	window.alert("No details available for input: '" + place.name + "'");
            	return;
          	}

          	// If the place has a geometry, then present it on a map.
          	if (place.geometry.viewport) {
            	map.fitBounds(place.geometry.viewport);
          	} else {
            	map.setCenter(place.geometry.location);
            	map.setZoom(17);  // Why 17? Because it looks good.
          	}
          	marker.setPosition(place.geometry.location);
          	marker.setVisible(true);

          	var address = '';
          	if(place.address_components) {
            	address = [
              		(place.address_components[0] && place.address_components[0].short_name || ''),
              		(place.address_components[1] && place.address_components[1].short_name || ''),
              		(place.address_components[2] && place.address_components[2].short_name || '')
            	].join(' ');
          	}
	          // infowindowContent.children['place-icon'].src = place.icon;
	          // infowindowContent.children['place-name'].textContent =
				// place.name;
	          // infowindowContent.children['place-address'].textContent =
				// address;
	          infowindow.open(map, marker);
        });
      }

    // Initialize map view
	initMap($("#parent-registration-form"));

	// Handle Form selection clicks
	$('#parent-registration-form-link').click(function(e) {
		$("#parent-registration-form").delay(100).fadeIn(100);
		$("#organizer-registration-form").fadeOut(100);
		$('#organizer-registration-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		initMap($("#parent-registration-form"));
	});

	$('#organizer-registration-form-link').click(function(e) {
		$("#organizer-registration-form").delay(100).fadeIn(100);
		$("#parent-registration-form").fadeOut(100);
		$('#parent-registration-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		initMap($("#organizer-registration-form"));
	});


	// register-submit
	$("#register-parent_btn").on("click",function(e){
		e.preventDefault();
		userData.firstName = $("input[name=parent-first_name]").val();
		userData.lastName = $("input[name=parent-last_name]").val();
		userData.location.address = $("input[name=parent-address]").val();
		userData.phone = $("input[name=parent-phone]").val();
		userData.email = $("input[name=parent-email]").val();
		userData.password = $("input[name=parent-password]").val();
		userData.passwordConfirm = $("input[name=parentpasswordConfirm]").val();

		console.log(JSON.stringify(userData));
		
		 if ($("#parent-registration-form").valid()) {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/parent_registration",
			data : JSON.stringify(userData),
			dataType : 'text',
			success : function(result) {
				if (result == "success")
					window.location.href = "/index";
				else {
					swal("Mail already used")
				}
			},
			error : function(e) {
				console.log(e);
				alert("Error!")
				console.log("ERROR: ", e);
			}
			});
		 }
		
	});

	$("#register-organizer_btn").on("click",function(e){	
		e.preventDefault();
		userData.firstName = $("input[name=organizer-first_name]").val();
		userData.lastName = $("input[name=organizer-last_name]").val();
		userData.companyName = $("input[name=company_name]").val();
		userData.companyDetails = $("textarea[name=company_details]").val();
		userData.location.address = $("input[name=organizer-address]").val();
		userData.phone = $("input[name=organizer-phone]").val();
		userData.email = $("input[name=organizer-email]").val();
		userData.password = $("input[name=organizer-password]").val();
		userData.passwordConfirm = $("input[name=organizer-passwordConfirm]").val();

		
		 if ($("#organizer-registration-form").valid()) {

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/organizer_registration",
			data : JSON.stringify(userData),
			dataType : 'text',
			success : function(result) {
				if (result == "success")
					window.location.href = "/index";
				else {
					swal("Mail already used")
				}
			},
			error : function(e) {
				console.log(e);
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
		 }

	});
		

}); 