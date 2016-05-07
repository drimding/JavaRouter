package org.dreamcatcher.service.impl;

import java.util.List;

import org.dreamcatcher.dao.RoutesDao;
import org.dreamcatcher.entity.Routes;
import org.dreamcatcher.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutesServiceImpl implements RoutesService
{
	@Autowired
	private RoutesDao routesDao;
	

	public List<Routes> getAllRoutes() {
		
		return routesDao.findAllRoutes();
	}

	public List<Routes> getRoutesByTypeId(int typeID) {
		
		
		return routesDao.findRoutesByTypeId(typeID);
	}

	public List<Routes> getRoutesByTypeName(String typeName) {
	
		return routesDao.findRoutesByTypeName(typeName);
	}





}
