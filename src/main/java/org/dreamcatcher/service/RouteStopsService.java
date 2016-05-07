package org.dreamcatcher.service;

import java.util.List;

import org.dreamcatcher.dto.RoutesStopsDTO;
import org.dreamcatcher.entity.RouteStops;


public interface RouteStopsService {
	List<RoutesStopsDTO> getRouteStopsByRouteId(int routesId);

}
