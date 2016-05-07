package org.dreamcatcher.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.dreamcatcher.dao.RouteWaypointsDao;
import org.dreamcatcher.entity.RouteWaypoints;
import org.springframework.stereotype.Repository;

@Repository
public class RouteWaypointsDaoImpl implements RouteWaypointsDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;
	
	public List<RouteWaypoints> findWaypointByRouteId(int routesId) {
		try{
			
		return entityManager.createQuery("select w from RouteWaypoints w join w.routes r where r.id= :routesId order by w.direction DESC, w.number ASC",
				RouteWaypoints.class).setParameter("routesId", routesId).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
			
			return null;
		}
	}
	
	
}
