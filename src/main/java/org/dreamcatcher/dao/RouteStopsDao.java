package org.dreamcatcher.dao;

import java.util.List;

import org.dreamcatcher.dto.RoutesStopsDTO;
import org.dreamcatcher.entity.RouteStops;


public interface RouteStopsDao {
	List<RoutesStopsDTO> findRouteStopsByRouteId(int routesId);
}
