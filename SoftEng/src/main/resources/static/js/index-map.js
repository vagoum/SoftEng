function initMap(latitude, longtitude) {
	
	
    var map = new google.maps.Map($(".map").get(0), {
        center: {lat: latitude, lng: longtitude},
        zoom: 14,
        disableDoubleClickZoom: false
    });
    return map;
}

function createMarkerAndInfoWindow(map, activity){
    var activityInfoWindow = new google.maps.InfoWindow({
        content: activity.name,
        maxWidth: 200
    });

    var userMarker = new google.maps.Marker({
        map: map,
        anchorPoint: new google.maps.Point(0, -29)
    });
    userMarker.setPosition({lat:activity.location.latitude, lng: activity.location.longtitude});
    activityInfoWindow.open(map, userMarker);
    return userMarker;
}

function setInitialMarker(map, latitude, longtitude){
    var activityInfoWindow = new google.maps.InfoWindow({
        content: "Location",
        maxWidth: 200
    });

    var userMarker = new google.maps.Marker({
        map: map,
        anchorPoint: new google.maps.Point(0, -29)
    });
    userMarker.setPosition({lat:latitude, lng: longtitude});
    activityInfoWindow.open(map, userMarker);
    return userMarker;
}