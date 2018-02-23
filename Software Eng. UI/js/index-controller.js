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
});