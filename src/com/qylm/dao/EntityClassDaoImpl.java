package com.qylm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.Cacheable;

import com.qylm.entity.EntityClass;

public class EntityClassDaoImpl extends GenericDaoImpl<EntityClass, Integer> implements EntityClassDao {

	/**
	 * 存在EntityClass检索并保存到缓存中，不存在创建
	 * @param entity 持久化类
	 */
	@Cacheable(value="entityClassCache",key="#cls", condition="#create")
	public EntityClass saveOrGetByCls(String cls,Boolean create) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(EntityClass.class);
		detachedCriteria.add(Restrictions.eq(EntityClass.CLS, cls));
		List<EntityClass> entityClassList = super.getByDetachedCriteria(detachedCriteria);
		EntityClass entityClass = null;
		if(!entityClassList.isEmpty()){
			entityClass = entityClassList.get(0);
		}else if(create){
			entityClass = new EntityClass();
			entityClass.setCls(cls);
			super.saveEntity(entityClass);
		} 
	    return entityClass;   
	}
}
