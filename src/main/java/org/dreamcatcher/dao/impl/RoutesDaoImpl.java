package org.dreamcatcher.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.dreamcatcher.dao.RoutesDao;
import org.dreamcatcher.entity.Routes;
import org.springframework.stereotype.Repository;

@Repository
public class RoutesDaoImpl implements RoutesDao{
	
	
	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;
	

	public void insertRoute(Routes routes) {
		try{
		entityManager.persist(routes);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			entityManager.close();
		}
	}

	
	public List<Routes> findAllRoutes() {
		try{
		return entityManager.createQuery("select a from Routes a ", Routes.class).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List<Routes> findRoutesByTypeName(String typeName) {
		try{
		return entityManager.createQuery(
				"select a from Routes a inner join a.type t  where t.type_name = :typeName ",
				Routes.class).setParameter("typeName", typeName).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
			
			return null;
		}
	}

	public List<Routes> findRoutesByTypeId(Integer typeID) {
		try{
			
		 return entityManager.createQuery(
				"select a from Routes a inner join a.type t  where t.id = :typeID ",
				Routes.class).setParameter("typeID", typeID).getResultList();
		 
		}catch(Exception e)
		{
			System.out.println(e);
			
			return null;
		}
	}
	
	

}
