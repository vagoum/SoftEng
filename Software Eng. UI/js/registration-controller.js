$(document).ready(function() {

	var userData = {
		"first_name" : "",
		"last_name" : "",
		"address" : {
			"full" :"",
			"lat" : "",
			"lon" : ""
		},
		"phone" : "",
		"email" : ""
	};

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

          	userData.address.lat = place.geometry.location.lat();
          	userData.address.lon = place.geometry.location.lng(); 

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
	          // infowindowContent.children['place-name'].textContent = place.name;
	          // infowindowContent.children['place-address'].textContent = address;
	          infowindow.open(map, marker);
        });
      }

    //Initialize map view
	initMap($("#parent-registration-form"));

	//Handle Form selection clicks
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


	//register-submit
	$("#register-parent_btn").on("click",function(e){
		e.preventDefault();
		userData.first_name = $("input[name=parent-first_name]").val();
		userData.last_name = $("input[name=parent-last_name]").val();
		userData.address.full = $("input[name=parent-address]").val();
		userData.phone = $("input[name=parent-phone]").val();
		userData.email = $("input[name=parent-email]").val();

		$.post("users/parents/registration", userData)
  			.done(function(responce){
  				//redirect
  				window.location.href = "/index";
  		}).fail(function(){
  			alert("Something went wrong");
  		});
	});

	$("#register-organizer_btn").on("click",function(e){	
		e.preventDefault();
		userData.first_name = $("input[name=organizer-first_name]").val();
		userData.last_name = $("input[name=organizer-last_name]").val();
		userData.company_name = $("input[name=company_name]").val();
		userData.company_details = $("textarea[name=company_details]").val();
		userData.address.full = $("input[name=organizer-address]").val();
		userData.phone = $("input[name=organizer-phone]").val();
		userData.email = $("input[name=organizer-email]").val();

		$.post("users/organizers/registration", userData)
  			.done(function(responce){
  				//redirect
  				window.location.href = "/index";
  		}).fail(function(){
  			alert("Something went wrong");
  		});
	});


}); 