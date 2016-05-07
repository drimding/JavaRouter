package org.dreamcatcher.service;

import java.util.List;

import org.dreamcatcher.entity.RouteWaypoints;

public interface RouteWaypointsService {
	List<RouteWaypoints> getWaypointByRouteId(int routesId);
}
