package org.dreamcatcher.service.impl;

import java.util.List;

import org.dreamcatcher.dao.RouteStopsDao;
import org.dreamcatcher.dto.RoutesStopsDTO;
import org.dreamcatcher.entity.RouteStops;
import org.dreamcatcher.service.RouteStopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RouteStopsServiceImpl implements RouteStopsService {

	@Autowired
	private RouteStopsDao routeStopsDao;
	public List<RoutesStopsDTO> getRouteStopsByRouteId(int routesId) {
		List<RoutesStopsDTO> routeStops = routeStopsDao.findRouteStopsByRouteId(routesId);
		if (routeStops!=null){
		for (int i =0; i<routeStops.size(); i++) {
			double lat = routeStops.get(i).getLat();
			double lon = routeStops.get(i).getLon();
			routeStops.get(i).setLat(49.839186+lat*2.0/1000000);
			routeStops.get(i).setLon(24.020048+lon*2.0/1000000);
			}
		return routeStops;
		}else
			return null;
		
	}

}
