$(document).ready(function() {

	var proximitySlider = $("#proximity_slider");
	var ageSliderMin = $("#age_slider-min");
	var ageSliderMax = $("#age_slider-max");
	var costSliderMin= $("#cost_slider-min");
	var costSliderMax= $("#cost_slider-max");
	
	//Handling Proximity Slider Events
	proximitySlider.on("input", function() {
		var offset = 15;

		var ratio = ((proximitySlider.width()-25)/(proximitySlider.attr("max") - proximitySlider.attr("min")));
		//Move element
		proximitySlider.next("output").css({
	   		marginLeft: (proximitySlider.val()*ratio)+offset
	   	}).text(proximitySlider.val());
	}).trigger('input');

	//Handling Age Slider Events
	ageSliderMin.on("input", function(e) {
		var offset = 15;

		var ratio = ((ageSliderMin.width()-25)/(ageSliderMin.attr("max") - ageSliderMin.attr("min")));
		//Move element
		ageSliderMin.next("output").css({
		   	marginLeft: (ageSliderMin.val()*ratio)+offset
		}).text(ageSliderMin.val());		
	}).trigger('input');

	ageSliderMax.on("input", function() {
		var offset = 15;

		var ratio = ((ageSliderMax.width()-25)/(ageSliderMax.attr("max") - ageSliderMax.attr("min")));
		//Move element
		ageSliderMax.next("output").css({
	   		marginLeft: (ageSliderMax.val()*ratio)+offset
	   	}).text(ageSliderMax.val());
	}).trigger('input');

	//Handling Cost Slider Events
	costSliderMin.on("input", function() {
		var offset = 15;

		var ratio = ((costSliderMin.width()-25)/(costSliderMin.attr("max") - costSliderMin.attr("min")));
		//Move element
		costSliderMin.next("output").css({
	   		marginLeft: (costSliderMin.val()*ratio)+offset
	   	}).text(costSliderMin.val());
	}).trigger('input');

	costSliderMax.on("input", function() {
		var offset = 15;

		var ratio = ((costSliderMax.width()-25)/(costSliderMax.attr("max") - costSliderMax.attr("min")));
		//Move element
		costSliderMax.next("output").css({
	   		marginLeft: (costSliderMax.val()*ratio)+offset
	   	}).text(costSliderMax.val());
	}).trigger('input');

}); 