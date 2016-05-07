 "use strict";
 
var flightPath;
var routers={ 
Bus20:{
		name:"20",
		property:["вул.Польова", "вул.Ковельська", "вул.Кукурудзяна", "вул.Б.Хмельницького", "вул.Гайдамацька", "вул.Замарстинівська", "вул.Під Дубом", "вул.П.Куліша", "вул.Шевченка", "вул.Городоцька",
		"вул.Сяйво", "вул.Широка", "вул.Суботівська"]},
Bus21:{
		name:"21",
		property:["вул.Городоцька", "вул.Ряшівська", "вул.Патона", "вул.І.Виговського", "вул.Кн.Ольги", "вул.Сахарова", "вул.Коперника"]},
Bus22:{ 
		name:"22",
		property:["смт.Брюховичі", "вул.Замарстинівська", "пр.В.Чорновола", "пл.Святого Теодора"]},
Bus23:{
		name:"23",
		property:["вул.Суботівська", "вул.Широка", "вул.Сяйво", "вул.Городоцька", "вул.І.Виговського", "вул.Кульпарківська", "вул.Наукова", "вул.Хуторівка", "пр.Ч.Калини", 
		"вул.Сихівська", "вул.Зелена", "вул.Дж.Вашингтона", "вул.Пасічна", "вул.Личаківська", "вул.Глинянський Тракт"]}
}

function rCreate(route){
	var li="<li><a>";
	var liend="</a></li>";
	var content=li+route.property[0]+liend;
for (var i=1; i<=route.property.length-1;i++){
	content=content+li+route.property[i]+liend;
} 

document.getElementById("Section").innerHTML = "<h3 class='rAnim1'>Схема маршруту №"+route.name+"</h3><ul>"+content+"</ul>";


}

function sendAjax(msg,idResult,processing) {
  $("#"+idResult).empty();
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
   if (xhttp.readyState == 4 && xhttp.status == 200) {
      var result = xhttp.responseText;
        document.getElementById(idResult).innerHTML = result;
    }
 };
 
xhttp.open("POST", processing, true);
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send(msg);
}


function Rdata (data){
        data=(data.split('-'));
        data=data[0]+'='+data[1];
        
        return data;
}

function Latlng(lat,lng){
    this._lat=lat;
    this._lng=lng;
}


