package org.dreamcatcher.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.dreamcatcher.dao.RtypeDao;
import org.dreamcatcher.entity.Rtype;
import org.springframework.stereotype.Repository;

@Repository
public class RtypeDaoImpl implements RtypeDao {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;
	
	public Rtype findRtypeById(int RtypeId) {
		try{
		return entityManager.find(Rtype.class, RtypeId);
		}catch(Exception e)
		{
			System.out.println(e);
			
			return null;
		}
	}

	public Rtype findRtypeByTypeName(String typeName) {
		try{
		return entityManager.createQuery(
				"SELECT t FROM Rtype t WHERE t.type_name like :typeName",
				Rtype.class).setParameter("typeName", typeName).getSingleResult();
		}catch(Exception e)
		{
			System.out.println(e);
		
			return null;
		}
	}

}
