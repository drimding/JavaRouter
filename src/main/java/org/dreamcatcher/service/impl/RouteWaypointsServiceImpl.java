package org.dreamcatcher.service.impl;


import java.util.List;

import org.dreamcatcher.dao.RouteWaypointsDao;
import org.dreamcatcher.entity.RouteWaypoints;
import org.dreamcatcher.service.RouteWaypointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteWaypointsServiceImpl implements RouteWaypointsService {

	@Autowired
	private RouteWaypointsDao waypointsDao;
	
	
	public List<RouteWaypoints> getWaypointByRouteId(int routesId) {
		List<RouteWaypoints> allList = waypointsDao.findWaypointByRouteId(routesId);
			if (allList!=null){
				Double lat=0.0, lon=0.0;
				
				for (int i = 0; i<allList.size();i++){
					if (allList.get(i).getNumber()==1){
						 lat = allList.get(i).getLat();
						 lon = allList.get(i).getLon();
						 allList.get(i).setLat(49.839186+lat*2.0/1000000);
						 allList.get(i).setLon(24.020048+lon*2.0/1000000);
					}
					 lat += allList.get(i).getLat();
					 lon += allList.get(i).getLon();
					 allList.get(i).setLat(49.839186+lat*2.0/1000000);
					 allList.get(i).setLon(24.020048+lon*2.0/1000000);
				}
				return  allList;
			}else
			return null;
		
	}
	
}
