package com.qylm.service;

import com.qylm.entity.EntityClass;

public interface EntityClassService extends GenericService<EntityClass, Integer> {
	
	public EntityClass saveOrGetByCls(String cls, Boolean create);

}
