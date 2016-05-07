package org.dreamcatcher.service;

import java.util.List;

import org.dreamcatcher.entity.Routes;

public interface RoutesService {
	
	
	List<Routes> getAllRoutes();

	List<Routes> getRoutesByTypeId(int typeID);
	List<Routes> getRoutesByTypeName(String typeName);
	
	
	

}
