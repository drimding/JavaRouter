package org.dreamcatcher.dao;

import java.util.List;

import org.dreamcatcher.entity.Routes;

public interface RoutesDao {
	void insertRoute (Routes routes);
	
	List<Routes> findAllRoutes();

	List<Routes> findRoutesByTypeName(String typeID);
	
	List<Routes> findRoutesByTypeId(Integer typeID);
	

}
