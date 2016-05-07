package org.dreamcatcher.dao;

import java.util.List;

import org.dreamcatcher.entity.RouteWaypoints;

public interface RouteWaypointsDao {

	List<RouteWaypoints> findWaypointByRouteId(int routesId);
}
