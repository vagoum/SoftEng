$(document).ready(function(){

    var activityData ={
        "activityTitle":"",
        "activityDescription":"",
        "tickets":"",
        "ticket_price":"",
        "date":"",
        "category":"",
        "address":{
            "full":"",
            "lat":"",
            "lon":""
        }
        //TODO upload files
    };

    function initMap() {
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

        autocomplete.addListener('place_changed', function(e) {
            infowindow.close();
            marker.setVisible(false);
            var place = autocomplete.getPlace();

            activityData.address.lat = place.geometry.location.lat();
            activityData.address.lon = place.geometry.location.lng();

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
    initMap();

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
        
        var newEntry = $(topEntry.clone());
        newEntry.find('input').val(null)
            .find('btn')
            .addClass('btn-add')
            .addClass('btn-success');
        newEntry.appendTo(controlForm);        

        controlForm.find('.entry:not(:last) .btn-add')
            .removeClass('btn-add').addClass('btn-remove')
            .removeClass('btn-success').addClass('btn-danger')
            .html('<span class="glyphicon glyphicon-minus"></span>');
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

        activityData.activityTitle = $("#activity-form-title").val();
        activityData.activityDescription = $("#activity-form-description").val();
        activityData.tickets = $("#activity-form-ticket_number").val();
        activityData.ticket_price = $("#activity-form-ticket_price").val();
        activityData.date = $("#activity-form-date").val();
        activityData.address.full = $("#activity-form-address").val();

        
        console.log("Data: "+JSON.stringify(activityData, null, 2));

        //TODO add ajax method
    });

});