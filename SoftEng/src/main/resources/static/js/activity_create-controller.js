$(document).ready(function(){

    var activityData ={
        name:"",
        activityDescription:"",
        ticketNumber:"",
        cost: "",
        date:"",
        time:"",
        ageMin:"",   //new
        ageMax:"",   //new
        category:"",
        location : {
			address :"",
			latitude : "",
			longtitude : ""
		}
    };
    
    markersArray = []
    
    $("#activity-form").validate({
        rules: {
            "activity_title": {
                required: true,
            },
            "activity_description": {
                required: true,
            },
            "ticket_number": {
                range: [1,10000],
                integer: true,
            },
            "ticket_price": {
                range: [1,1000],
                integer: true,
                required: true,
            },
            "age_max" : {
            	range: [3,18],
            	integer: true,
            	required: true,
            },
            "age_min" : {
            	range: [3,18],
            	integer: true,
            	required: true,
            },
            "date": {
                required: true,
                date: true,
            },
            "address": {
                required: true,
            }
        },
        messages: {
            "activity_title": {
                required: "Please, enter an activity title"
            },
            "activity_description": {
                required: "Please, enter description"
            },
            "ticket_number": {
                required: "Please, enter a number of tickets",
                range: "Please, enter a valid ticket number",
            },
            "ticket_price": {
                required: "Please, enter a price",
                range: "Please, enter a valid ticket price",
            },
            "age_min": {
            	range: "Must be in range 3-18",
                required: "Please, enter a minimum age",
            },
            "age_max": {
            	range: "Must be in range 3-18",
                required: "Please, enter a maximum age",
            },
            "date": {
                required: "Please, enter a date",
                date: "Please insert a valid date",
            },
            "address": {
                required: "Please, enter an address",
            }, 
        }
    });
    
    

    function initMap(currentForm) {
        var map = new google.maps.Map($(".map").get(0), {
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

        var input = $(".pac-input").get(0);
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

        google.maps.event.addListener(map, 'click', function(e) {
        	
        	console.log("clicked");
        	clearOverlays(markersArray);

            var positionDoubleclick = e.latLng;
            var activity = {
                "name":"Current User Location",
                "location":{
                    "latitude": positionDoubleclick.lat(),
                    "longtitude": positionDoubleclick.lng()
                }
            };
            activityData.location.latitude = activity.location.latitude;
            activityData.location.longtitude = activity.location.longtitude;

            var geocoder = new google.maps.Geocoder;
            var address = ""
            geocoder.geocode({'location': positionDoubleclick}, function(results, status) {
              if (status === 'OK') {
                if (results[0]) { 
                    activity.name =  activity.name + ":<br>" + results[0].formatted_address;
                    address = results[0].formatted_address;
                    console.log(address);
                   //  $('#activity-form-address input').val(address);
                    $('input[name="address"').val(address);

                }else{
                    console.log(results);
                }
              }else{
                console.log(status);
              }
              var marker = createMarkerAndInfoWindow(map,activity);
             markersArray.push(marker);
              
            });
        });
        
        autocomplete.addListener('place_changed', function(e) {
            infowindow.close();
            marker.setVisible(false);
            var place = autocomplete.getPlace();

            activityData.location.latitude = place.geometry.location.lat();
            activityData.location.longtitude = place.geometry.location.lng();

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
	initMap($("#activity-form"));
	//Initialize date and time picker
    $("#datetimepicker").datetimepicker({viewMode:'years'});
    //Handle File Upload UI
    var controlForm = $('.controls:first');
    controlForm.on("click", ".btn-add", function(e){
        e.preventDefault();

        var topEntry = $(this).parents('.entry:first');
        //Check if the user has selected a photo
        if(topEntry.find("input[name=photo_file]").val() == ""){
            alert("Please select at least one photo");
            return false;
        }
        var imageFile = topEntry.find("input[name=photo_file]")[0].files[0];
        console.log(imageFile);
        if (imageFile.size > 4000000) {
        	swal("Image more than 4MB")
        }
        else {
        var newEntry = $(topEntry.clone());
        newEntry.find('input').val(null)
            .find('btn')
            .addClass('btn-add')
            .addClass('btn-success');
        newEntry.appendTo(controlForm);        
        console.log(newEntry)
        controlForm.find('.entry:not(:last) .btn-add')
            .removeClass('btn-add').addClass('btn-remove')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
        }
    });

    controlForm.on("click", ".btn-remove",function(e){
        e.preventDefault();
        $(this).parents('.entry:first').remove();
        return false;
    });

    //Handle Address Type & Dynamic Map Display
    var typedAddress = $("#activity-form-address");
    var googleMap = $("#activity-form-map");
    typedAddress.on('keyup paste', function(){
        googleMap.attr("src", "https://maps.google.co.uk/maps?&source=s_q&hl=en&geocode=&q="+
        encodeURIComponent(typedAddress.val())+"&aq=t&ie=UTF8&output=embed");
    });

    //Handle Category Selection
    $("#activity_categories-list>li").on('click', function() {
        var checkboxState = $(this).children().children("input").is(":checked");
        var ckeckboxValue = $(this).children().children("div").children("label").html();

        //check the ckeckbox state
        if(checkboxState){
            activityData.category = ckeckboxValue;
        }else{
            activityData.category = "";
        }
    });    

    //Handle Form Submition
    $("#activity-form-submit").click(function(e){
        e.preventDefault();
        if(activityData.category == "") alert("Please specify a valid category for you activity");
        else {
        activityData.name = $("#activity-form-title").val();
        activityData.activityDescription = $("#activity-form-description").val();
        activityData.ticketNumber = $("#activity-form-ticket_number").val();
        activityData.cost = $("#activity-form-ticket_price").val();
        activityData.location.address = $("#activity-form-address").val();
        console.log(activityData.cost)
        var timeAndDate = $("#activity-form-date").val().split(" ");
        activityData.date = timeAndDate[0];
        activityData.time = timeAndDate[1]+" "+timeAndDate[2];
        console.log(activityData.time);
        activityData.ageMin = $("#activity-form-age_min").val();   //new
        activityData.ageMax = $("#activity-form-age_max").val();   //new
        
        
        var form = $('#activity-form')[0];
        var d = new FormData(form);

        console.log(JSON.stringify(activityData));

        var formData = new FormData();
        
        formData.append('activityData', new Blob([JSON.stringify(activityData)], {
            type: "application/json"
        }));
        
        var numFiles =  $('input[type=file]').length;

        for (var i = 0; i < numFiles; i++) {
        	console.log($('input[type=file]')[i].files[0]);
        	formData.append('files', $('input[type=file]')[i].files[0]);
        }
        
        
        console.log(JSON.stringify(formData));
        if ($("#activity-form").valid()) {
        $.ajax({
			type : "POST",
			url : "/activity/create",
	        processData: false,
	        contentType: false,
			data : formData,
			dataType : 'text',
			success : function(result) {
				console.log(result);
  				window.location.href = "/activity_view?id=" + result;
			},
			error : function(data) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
        }

        }
       });
    
	function clearOverlays(markersArray) {
		  for (var i = 0; i < markersArray.length; i++ ) {
		   markersArray[i].setMap(null);
		  }
		}

});
/*
$.validator.addMethod('filesize', function (value, element, param) {
    return this.optional(element) || (element.files[0].size <= param)
}, 'File size must be less than {0}');
*/
