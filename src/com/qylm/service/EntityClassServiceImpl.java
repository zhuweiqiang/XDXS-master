package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.EntityClassDao;
import com.qylm.entity.EntityClass;

@Service("entityClassService")
public class EntityClassServiceImpl extends GenericServiceImpl<EntityClass, Integer> implements EntityClassService {
	
	private EntityClassDao entityClassDao;

	@Autowired
	protected EntityClassServiceImpl(EntityClassDao entityClassDao) {
		super(entityClassDao);
		this.entityClassDao = entityClassDao;
	}
	
	public EntityClass saveOrGetByCls(String cls, Boolean create) {
		return entityClassDao.saveOrGetByCls(cls,create);
	}

}
