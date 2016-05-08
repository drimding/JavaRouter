

var myCenter=new google.maps.LatLng(49.839186,24.020048);
var bounds = new google.maps.LatLngBounds();

var map;
function initialize() {
   var mapProp = {
    center:myCenter,
    zoom:13,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
 map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
flightPath = new google.maps.Polyline({
    geodesic: true,
    strokeColor: '#b10015',
    strokeOpacity: 0.6,
    strokeWeight: 5
});
flightPath2 = new google.maps.Polyline({
    geodesic: true,
    strokeColor: '#93e5f2',
    strokeOpacity: 0.7,
    strokeWeight: 5
});

function setroute(waypRoat){
	
var waypoints=[], waypoints2=[];
for (var i=0;i<waypRoat.length;i++ ){
         if (waypRoat[i].direction==false){
         var point=new google.maps.LatLng(waypRoat[i].lat,waypRoat[i].lon);
           waypoints.push(point);
         //  alert (point);
       } if (waypRoat[i].direction==true){var point=new google.maps.LatLng(waypRoat[i].lat,waypRoat[i].lon);
           waypoints2.push(point);
       }
     }
 var center=waypoints[Math.ceil(waypoints.length/2)];
 flightPath.setPath(waypoints);
 flightPath2.setPath(waypoints2);
 flightPath.setMap(map);
 flightPath2.setMap(map);
 map.setCenter(center);
 map.setZoom(12);
}
var markers=[];
function setMarker(locations){
    var imageRed = {
    url:window.location.pathname+'resources/img/pointRed.png',
    size:new google.maps.Size(12,12)
    //origin: new google.maps.Point(0, 0),
    //anchor: new google.maps.Point(0, 32)
    };
    var imageBlue = {
    url:window.location.pathname+'resources/img/pointBlue.png',
    size:new google.maps.Size(12,12)
    //origin: new google.maps.Point(0, 0),
    //anchor: new google.maps.Point(0, 32)
    };
    markers=[];
   var infowindow = new google.maps.InfoWindow();
   var marker, i;
   var contentString=[];
   for (i = 0; i < locations.length; i++) { 
       contentString.push('<a href=index.php?id=pStop&stationid=>'+locations[i].name+', '+locations[i].addrsuffix+'</a>');
       var position = new google.maps.LatLng(locations[i].lat, locations[i].lon);
       bounds.extend(position);
       if (locations[i].direction==false) { 
           if (locations[i].number==1){
               marker = new google.maps.Marker({
               position: position,
               map: map
            });
           }else{
        marker = new google.maps.Marker({
         
        icon: imageRed,
        position: position,
        map: map
        //title:locations[i].addr_name+', '+locations[i].addrsuffix
     });}} else {
     if (locations[i].number==true){
               marker = new google.maps.Marker({
               position: position,
               map: map
            });
           }else{
     marker = new google.maps.Marker({
    	 
        icon: imageBlue,
        position: position,
        map: map
        //title:locations[i].addr_name+', '+locations[i].addrsuffix
     });}}
     google.maps.event.addListener(marker,'click', (function(marker, i) {
         return function(){
     infowindow.setContent(contentString[i]);
     infowindow.open(map, marker);
         };
  })(marker, i));
      markers.push(marker);
      map.fitBounds(bounds);
   
  }
}
function DeleteMarkers() {
           if (markers.length>1) { 
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(null);
            }
            markers = [];
        }
    }
    
google.maps.event.addDomListener(window, 'load', initialize);
function clerroute(){
 flightPath.setMap(null);
 flightPath2.setMap(null);
}


function sendAjaxAPI(msg,idResult,processing) {

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {

   if (xhttp.readyState === 4 && xhttp.status === 200) {
      var result = JSON.parse(xhttp.responseText);
      var waypRoad=[], waypStop=[];
       
     DeleteMarkers();
     if (typeof result['waypStop'] != "undefined" && result['waypStop'] != null && result['waypStop'].length > 0 ){
     setMarker(result['waypStop']);
     }
     if (typeof result['waypRoute'] != "undefined" && result['waypRoute'] != null && result['waypRoute'].length > 0 ){
    	 setroute(result['waypRoute']);
         }
     
     
 } 
 };
    var token = $("meta[id='csrf']").attr("content");
    var header = $("meta[id='csrf_header']").attr("content");

xhttp.open("POST", window.location.pathname+'createRouteOnMap', true)
xhttp.setRequestHeader(header, token);
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send(msg);
}

