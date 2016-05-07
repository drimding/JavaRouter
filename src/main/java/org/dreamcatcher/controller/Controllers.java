package org.dreamcatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;


import java.util.HashMap;

import org.dreamcatcher.service.RouteStopsService;
import org.dreamcatcher.service.RouteWaypointsService;
import org.dreamcatcher.service.RoutesService;


@Controller
public class Controllers {
	
	@Autowired
	private RoutesService routesService;
	@Autowired
	private RouteWaypointsService waypointService;
	@Autowired
	private RouteStopsService routeStopsService;
	
	@RequestMapping(value ="/")
	public String home(Model model){
		
		model.addAttribute("tramways", routesService.getRoutesByTypeId(1));
		model.addAttribute("trolleybus", routesService.getRoutesByTypeId(2));
		model.addAttribute("buses", routesService.getRoutesByTypeName("buses"));
		return "home";
	}
	
	@RequestMapping(value ="/createRouteOnMap", method = RequestMethod.POST)
	
	@JsonView(Views.Public.class)
	public @ResponseBody HashMap ajaxTest(@RequestParam int routesId) {
		HashMap objMap = new HashMap();
		objMap.put("waypRoute", waypointService.getWaypointByRouteId(routesId));
		objMap.put("waypStop", routeStopsService.getRouteStopsByRouteId(routesId));
  	
        return objMap;
	}





}
