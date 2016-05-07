package org.dreamcatcher.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.dreamcatcher.dao.RouteStopsDao;
import org.dreamcatcher.dto.RoutesStopsDTO;
import org.dreamcatcher.entity.RouteStops;
import org.dreamcatcher.entity.Stations;
import org.springframework.stereotype.Repository;

@Repository
public class RouteStopsDaoImpl implements RouteStopsDao{
	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	public List<RoutesStopsDTO> findRouteStopsByRouteId(int routesId) {
		try{
		return entityManager.createQuery("Select new org.dreamcatcher.dto.RoutesStopsDTO(a.number, a.direction, st.lat, st.lon, st.addrsuffix, st.name)  from RouteStops a join a.routes r join a.stations st where r.id= :routesId order by a.direction DESC, a.number ASC",
				RoutesStopsDTO.class).setParameter("routesId", routesId).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
		
			return null;
		}
	}
	
	
	
}
