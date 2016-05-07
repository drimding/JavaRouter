<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
	
<aside>

<table class='table_routers'>
 <caption>Маршрутки</caption>
 	<tr>
 	<jstl:set var="column" value="0"/>
	<jstl:forEach items="${buses}" var="buses">
		<td class='table_routers_init' id='routesId-${buses.id}' onclick=sendAjaxAPI(Rdata(this.id),'table_routes_result')>${buses.name}</td>
		<jstl:set var="column" value="${column+1}"/>
		<jstl:if test="${column==5}">
			</tr><tr><jstl:set var="column" value="0"/>
			</jstl:if>
		
	</jstl:forEach>
	</tr>
	</table>
	

	 <table class='table_routers'>
	  <caption>Тролейбуси</caption>
 	<tr> 
 	<jstl:set var="column" value="0"/>
	<jstl:forEach items="${trolleybus}" var="trolleybus">
		<td class='table_routers_init' id='routesId-${trolleybus.id}' onclick=sendAjaxAPI(Rdata(this.id),'table_routes_result')>${trolleybus.name}</td>
		<jstl:set var="column" value="${column+1}"/>
		<jstl:if test="${column==5}">
			</tr><tr><jstl:set var="column" value="0"/>
			</jstl:if>
		
	</jstl:forEach>
	</tr>
	</table>
	 <table class='table_routers'>
	  <caption>Трамваї</caption>
 	<tr>
 	<jstl:set var="column" value="0"/>
	<jstl:forEach items="${tramways}" var="tramways">
		<td class='table_routers_init' id='routesId-${tramways.id}' onclick=sendAjaxAPI(Rdata(this.id),'table_routes_result')>${tramways.name}</td>
		<jstl:set var="column" value="${column+1}"/>
		<jstl:if test="${column==5}">
			</tr><tr><jstl:set var="column" value="0"/>
			</jstl:if>
		
	</jstl:forEach>
	</tr>
	</table>
	 
</aside>
<section id="Section">
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDXVDXSQArfBqK7cdIugGNzbKUVktWoHPw"></script>
<script src="<jstl:url value="resources/js/googleMap.js"/> "></script>
<div id="googleMap" ></div>
<div id="table_routes_result">
</div>
</section>



