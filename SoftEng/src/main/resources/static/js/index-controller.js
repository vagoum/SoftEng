$( document ).ready(function() {

	var appliedSearchFilters = {
		"text": "",
		"latitude":"",
		"longtitude":"",
		"proximity": "",
		"age_min": "",
		"age_max": "",
		"cost_min": "",
		"cost_max": "",
		"category":"",
		"sortBy":""
	};
	
	c_longtitude ="";
	c_latitude = "";
	
	var c_longtitude = parseFloat(document.getElementById("longtitude-id").value);
	var c_latitude = parseFloat(document.getElementById("latitude-id").value);
	console.log(c_longtitude);
	console.log(c_latitude);
	
	appliedSearchFilters.longtitude = c_longtitude;
	appliedSearchFilters.latitude =  c_latitude;
	
	$("#range_cost").ionRangeSlider({
	    type: "double",
	    grid: false,
	    min: 0,
	    max: 100,
	    from: 0,
	    to: 400,
	    prefix: "",
	    onChange: function (data) {
	    	appliedSearchFilters.cost_min = data.from;
	    	appliedSearchFilters.cost_max = data.to;
	    }
	});

	
	$("#range_distance").ionRangeSlider({
	    type: "single",
	    grid: false,
	    min: 0,
	    max: 200,
	    from: 0,
	    to: 200,
	    prefix: "",
	    onChange: function (data) {
	    	appliedSearchFilters.proximity = data.from;
	    }
	});

	$("#range_age").ionRangeSlider({
	    type: "double",
	    grid: false,
	    min: 3,
	    max: 16,
	    from: 3,
	    to: 16,
	    prefix: "",
	    onChange: function (data) {
	    	appliedSearchFilters.age_min  = data.from;
	    	appliedSearchFilters.age_max  = data.to;

	    }
	});

	
	// Initialize map view
    var map = initMap(c_latitude, c_longtitude);

    setInitialMarker(map, c_latitude, c_longtitude);
    
    // to do
    getDataIndex(function(activities) {
    	console.log(JSON.stringify(activities,null,2));


    	
    	for (var i=0; i<activities.length; i++) {
        	console.log(activities[i]);
    		createMarkerAndInfoWindow(map,activities[i]);
    		attachActivity(activities[i]);
    	}
    }, function(activities) {
    	console.log("error: "+activities);
    }); 
    
    
	// Handling Activity Category checkbox clicks
	$("#activity_categories-list>li").on('click', function() {
		var checkboxState = $(this).children().children("input").is(":checked");
		var ckeckboxValue = $(this).children().children("div").children("label").html();
		var index = appliedSearchFilters.categories.indexOf(ckeckboxValue);
		// check the ckeckbox state
		if(checkboxState){
			// check if the category is already in to the array
			if(index<=-1){
				appliedSearchFilters.categories.push(ckeckboxValue);
			}
		}else{
			if(index>-1){
				appliedSearchFilters.categories.splice(index, 1);
			}
		}
	});

	// Handling sorting buttons
	$(".sorting_btn").on("click", function(){
		appliedSearchFilters.sortBy = $(this).children("input").attr("id").toLowerCase();
	});

    // Handling Double clicks on the map
    google.maps.event.addListener(map, 'dblclick', function(e) {
        var positionDoubleclick = e.latLng;
        var activity = {
            "name":"Current User Location",
            "location":{
                "latitude": positionDoubleclick.lat(),
                "longtitude": positionDoubleclick.lng()
            }
        };
        appliedSearchFilters.latitude = activity.location.latitude;
        appliedSearchFilters.longtitude = activity.location.longtitude;

        var geocoder = new google.maps.Geocoder;
        geocoder.geocode({'location': positionDoubleclick}, function(results, status) {
          if (status === 'OK') {
            if (results[0]) { 
                // userInfoWindow.setContent(userInfoWindow.getContent() +
				// ":<br>" + results[0].formatted_address);
                activity.name =  activity.name + ":<br>" + results[0].formatted_address;
            }else{
                console.log(results);
            }
          }else{
            console.log(status);
          }
          createMarkerAndInfoWindow(map,activity);
        });

        // if you don't do this, the map will zoom in
        // e.stopPropagation();
    });

    var searchFlag = false;
	// Handling Search
	$("#search_button1").on("click",function(e){	
		e.preventDefault();
		
		// Handle Text input
		if($("#free-search-text").val() != ""){
			appliedSearchFilters.text = $("#free-search-text").val();
		}
		
		console.log(appliedSearchFilters);
		
	    getDataSearch(JSON.stringify(appliedSearchFilters), function(activities) {
	    	
	    	$('malakia').remove();

	    	
	    	for (var i=0; i<activities.length; i++) {
	    		attachActivity(activities[i]);
	    		createMarkerAndInfoWindow(map,activities[i]);
	    	}
	    }, function(data) {
	    	console.log("error: "+data);

	    });

	});

	$("#search_button2").on("click",function(e){	
		e.preventDefault();
		
		// Handle Text input
		if($("#free-search-text").val() != ""){
			appliedSearchFilters.text = $("#free-search-text").val();
		}
		
		console.log(appliedSearchFilters);
		
	    getDataSearch(JSON.stringify(appliedSearchFilters), function(activities) {
	    	
	    	$('malakia').remove();

	    	
	    	for (var i=0; i<activities.length; i++) {
	    		attachActivity(activities[i]);
	    		createMarkerAndInfoWindow(map,activities[i]);
	    	}
	    }, function(data) {
	    	console.log("error: "+data);

	    });

	});

	/*
	 * var activities = [ {"activityId":2,"name":"Play
	 * Football1","category":"","activityDescription":"Qui diam libris ei,
	 * vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo
	 * offendit ea mea. Nostro blandit
	 * sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2017","location":{"longtitude":23.734851,"latitude":37.975443}},
	 * {"activityId":6,"name":"Play
	 * Football2","category":"","activityDescription":"Qui diam libris ei,
	 * vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo
	 * offendit ea mea. Nostro blandit
	 * sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2017","location":{"longtitude":23.734862,"latitude":37.975543}},
	 * {"activityId":8,"name":"Play
	 * Football3","category":"","activityDescription":"Qui diam libris ei,
	 * vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo
	 * offendit ea mea. Nostro blandit
	 * sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2019","location":{"longtitude":23.734873,"latitude":37.975243}},
	 * {"activityId":10,"name":"Play
	 * Football4","category":"","activityDescription":"Qui diam libris ei,
	 * vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo
	 * offendit ea mea. Nostro blandit
	 * sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2019","location":{"longtitude":23.734894,"latitude":37.977543}} ];
	 * 
	 * 
	 * 
	 * for(var i=0;i<activities.length;i++){ attachActivity(activities[i]);
	 * createMarkerAndInfoWindow(map,activities[i]); }
	 */

});


function getDataSearch(data, success, failure){
	console.log(data);

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/search",
		processData : false,
		contentType : "application/json",
		data : data,
		success : function(result) {
			//console.log(result);
			success(result);
		},
		error : function(result) {
			failure(result);
		}
	});
}

function getDataIndex(success, failure){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/getActivities",
		processData : false,
		contentType : "json",
		success : function(result) {
			//console.log(result);
			success(result);
		},
		error : function(result) {
			failure(result);
		}
	});
}


function attachActivity(activity){
	console.log(activity);
	var actitiesDOM = $(".activities");
	var currentActivityCard = document.createElement('div');
	currentActivityCard = $(currentActivityCard);
	currentActivityCard.addClass("malakia");
	currentActivityCard.addClass("col-xl-2 col-lg-3 col-md-3 col-sm-4 col-xs-12");
	currentActivityCard.html($('<div class="card"><div class="card-header bg-transparent"><h4>' + activity.name +
	 	'</h4></div><div class="card-body"><img class="card-photo" src="'+ activity.thumbNail.url+
	 	'"><p class="card-text">'+activity.activityDescription+'</p></div><div class="card-footer"><a href="/activity_view?id='+activity.activityId
	 	+'" class="blue-button">Learn More</a></div></div>'));
	actitiesDOM.append(currentActivityCard);
}