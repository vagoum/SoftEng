$( document ).ready(function() {

	var appliedSearchFilters = {
		"text": "",
		"proximity": "",
		"age":{
			"min":"",
			"max":""
		},
		"cost":{
			"min":"",
			"max":""
		},
		"categories":[],
		"sortBy":""
	};

	//Initialize map view
    var map = initMap();

	//Handling Activity Category checkbox clicks
	$("#activity_categories-list>li").on('click', function() {
		var checkboxState = $(this).children().children("input").is(":checked");
		var ckeckboxValue = $(this).children().children("div").children("label").html();
		var index = appliedSearchFilters.categories.indexOf(ckeckboxValue);
		//check the ckeckbox state
		if(checkboxState){
			//check if the category is already in to the array
			if(index<=-1){
				appliedSearchFilters.categories.push(ckeckboxValue);
			}
		}else{
			if(index>-1){
				appliedSearchFilters.categories.splice(index, 1);
			}
		}
	});

	//Handling sorting buttons
	$(".sorting_btn").on("click", function(){
		appliedSearchFilters.sortBy = $(this).children("input").attr("id").toLowerCase();
	});

    //Handling Double clicks on the map
    google.maps.event.addListener(map, 'dblclick', function(e) {
        var positionDoubleclick = e.latLng;
        var activity = {
            "name":"Current User Location",
            "location":{
                "latitude": positionDoubleclick.lat(),
                "longtitude": positionDoubleclick.lng()
            }
        };
        
        var geocoder = new google.maps.Geocoder;
        geocoder.geocode({'location': positionDoubleclick}, function(results, status) {
          if (status === 'OK') {
            if (results[0]) { 
                //userInfoWindow.setContent(userInfoWindow.getContent() + ":<br>" + results[0].formatted_address);
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

	//Handling Search
	$("#search-button").on('click', function() {
		//Handle Text input
		if($("#search-text").val() != ""){
			appliedSearchFilters.text = $("#search-text").val();
		}
		
		//Handling Slider input
		var proximitySlider = $("#proximity_slider");
		var ageSliderMin = $("#age_slider-min");
		var ageSliderMax = $("#age_slider-max");
		var costSliderMin= $("#cost_slider-min");
		var costSliderMax= $("#cost_slider-max");

		if(proximitySlider.val() != 0){
			appliedSearchFilters.proximity = proximitySlider.val();
		}

		if(ageSliderMin.val() != 0){
			appliedSearchFilters.age.min = ageSliderMin.val();
		}

		if(ageSliderMax.val() != ageSliderMax.attr("max")){
			appliedSearchFilters.age.max = ageSliderMax.val();
		}

		if(costSliderMin.val() != 0){
			appliedSearchFilters.cost.min = costSliderMin.val();
		}

		if(costSliderMax.val() != costSliderMax.attr("max")){
			appliedSearchFilters.cost.max = costSliderMax.val();
		}

		console.log(JSON.stringify(appliedSearchFilters, null, 2));

	});


	var activities = [
		{"activityId":2,"name":"Play Football1","category":"","activityDescription":"Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2017","location":{"longtitude":23.734851,"latitude":37.975443}},
		{"activityId":6,"name":"Play Football2","category":"","activityDescription":"Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2017","location":{"longtitude":23.734862,"latitude":37.975543}},
		{"activityId":8,"name":"Play Football3","category":"","activityDescription":"Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2019","location":{"longtitude":23.734873,"latitude":37.975243}},
		{"activityId":10,"name":"Play Football4","category":"","activityDescription":"Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea","thumbNail":{"name":"","image":"","createdAt":1520024509663,"url":"http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png","isThumbnail":null},"date":"05/02/2019","location":{"longtitude":23.734894,"latitude":37.977543}}
	];

	//todo AFTER THE AJAX CALL

	
	for(var i=0;i<activities.length;i++){
		attachActivity(activities[i]);
		createMarkerAndInfoWindow(map,activities[i]);
	}

});

function attachActivity(activity){
	var actitiesDOM = $(".activities");
	var currentActivityCard = document.createElement('div');
	currentActivityCard = $(currentActivityCard);
	currentActivityCard.addClass("col-xl-2 col-lg-3 col-md-3 col-sm-4 col-xs-12");
	currentActivityCard.html($('<div class="card"><div class="card-header bg-transparent"><h4>' + activity.name +
	 	'</h4></div><div class="card-body"><img class="card-photo" src="'+activity.thumbNail.url+
	 	'"><p class="card-text">'+activity.activityDescription+'</p></div><div class="card-footer"><a href="/activity_view?id='+activity.activityId
	 	+'" class="blue-button">Learn More</a></div></div>'));
	actitiesDOM.append(currentActivityCard);
}