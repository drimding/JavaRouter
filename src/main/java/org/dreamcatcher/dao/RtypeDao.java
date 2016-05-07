package org.dreamcatcher.dao;

import org.dreamcatcher.entity.Rtype;

public interface RtypeDao {
	
	Rtype findRtypeById(int RtypeId);
	
	Rtype findRtypeByTypeName(String typeName);

}
