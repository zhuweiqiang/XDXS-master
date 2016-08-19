package com.qylm.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

/**
 * 提供DAO的基本CRUD操作，是所有DAO的父类
 * 
 * @author
 * 
 * @param <T>
 *            持久化类
 * @param <ID>
 *            主键
 */
@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	@Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
	
	/**
	 * AuditReader 历史数据
	 */
	//private AuditReader auditReader = AuditReaderFactory.get(getSession());

    /**
     * 当前session
     * @return
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    } 

	/**
	 * 持久化类的CLASS
	 */
	private Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	// -------------------- 基本检索、增加、修改、删除操作 --------------------
	/* 
	 * 用主键取得持久化类
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getById(java.io.Serializable)
	 */
	public T getById(final ID id) {
		return (T) getSession().get(persistentClass, id);
	}
	
	/*
	 * 根据主键获取实体并加锁。如果没有相应的实体，返回 null (non-Javadoc)
	 * 
	 * @see com.zhuhong.dao.GenericDao#getWithLock(java.io.Serializable,
	 * org.hibernate.LockMode)
	 */
	public T getWithLock(final ID id, final LockOptions lockOptions) {
		T t = (T) getSession().get(persistentClass, id, lockOptions);
		if (t != null) this.flush(); // 立即刷新，否则锁不会生效。
		return t;
	}

	/**
	 * 根据主键获取实体。如果没有相应的实体，抛出异常。
	 * 
	 * @param id
	 *            主键
	 * @return 持久化类
	 */
	public T loadById(final ID id) {
		return (T) getSession().load(persistentClass, id);
	}

	/*
	 * 根据主键获取实体并加锁。如果没有相应的实体，抛出异常。 (non-Javadoc)
	 * 
	 * @see com.zhuhong.dao.GenericDao#loadWithLock(java.io.Serializable,
	 * org.hibernate.LockMode)
	 */
	public T loadWithLock(final ID id, final LockOptions lockOptions) {
		T t = (T) getSession().load(persistentClass, id, lockOptions);
		if (t != null) {
			this.flush(); // 立即刷新，否则锁不会生效。
		}
		return t;
	}

	/*
	 * 取得所有持久化类。 (non-Javadoc)
	 * 
	 * @see com.zhuhong.dao.GenericDao#loadAll()
	 */
	public List<T> loadAll() {
		Criteria criteria = getSession().createCriteria(persistentClass);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<T>) criteria.list();
	}

	/**
	 * 取得所有持久化类
	 */
	public List<T> getAll() {
		return getSession().createCriteria(persistentClass).list();
	}

	/**
	 * 更新持久化类
	 * 
	 * @param entity
	 *            持久化类
	 */
	public void updateEntity(T entity) {
		getSession().update(entity);
	}

	/**
	 * 更新持久化类的Collection
	 * @param entities  持久化类的Collection
	 */
	public void updateEntityAll(Collection<T> entities) {
		for(T entity : entities)getSession().update(entity);
	}

	/*
	 * 增加或更新实体 (non-Javadoc)
	 * 
	 * @see com.zhuhong.dao.GenericDao#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	/*
	 * 增加或更新集合中的全部实体 (non-Javadoc)
	 * 
	 * @see com.zhuhong.dao.GenericDao#saveOrUpdateAll(java.util.Collection)
	 */
	public void saveOrUpdateAll(Collection<T> entities) {
		for(Iterator<T> localIterator = entities.iterator(); localIterator.hasNext(); ) { 
			Object entity = localIterator.next();
			getSession().saveOrUpdate(entity);
	    }
	}

	/**
	 * 插入持久化类
	 * 
	 * @param entity
	 *            持久化类
	 */
	public void saveEntity(T entity) {
		getSession().save(entity);
	}

	/**
	 * 插入持久化类的Collection
	 * 
	 * @param entities 持久化类的Collection
	 */
	public void saveEntityAll(Collection<T> entities) {
		for(T entity : entities)getSession().save(entity);
	}

	/**
	 * 删除持久化类
	 * @param entity  持久化类
	 */
	public void deleteEntity(T entity) {
		getSession().delete(entity);
	}

	/*
	 * 根据主键删除指定实体 (non-Javadoc)
	 * 
	 * @see com.zhuhong.dao.GenericDao#deleteByKey(java.io.Serializable)
	 */
	public void deleteEntityByID(final ID id) {
		this.deleteEntity(this.loadById(id));
	}

	/* 
	 * 删除集合中的全部实体 (non-Javadoc)
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#deleteEntityAll(java.util.Collection)
	 */
	public void deleteEntityAll(Collection<T> entities) {
		for(T entity : entities)getSession().delete(entity);
	}
	
	/* 
	 *  用主键取得持久化类，并判断是否存在
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getAndCheckExistById(java.io.Serializable)
	 */
	public boolean getAndCheckExistById(final ID id) {
		return ((Integer) getSession().createCriteria(persistentClass).add(
				Restrictions.idEq(id)).setProjection(Projections.rowCount())
				.uniqueResult()) == 1;
	}
	
	// -------------------- HSQL ----------------------------------------------

	/* (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#bulkUpdate(java.lang.String)
	 */
	public int bulkUpdate(final String queryString) {
		return bulkUpdate(queryString, null);
	}

	/* (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#bulkUpdate(java.lang.String, java.lang.Object[])
	 */
	public int bulkUpdate(final String queryString, final Object[] values) {
		Query queryObject = getSession().createQuery(queryString);
		 if (values != null) {
		     for (int i = 0; i < values.length; ++i) {
	           queryObject.setParameter(i, values[i]);
	         }
		  }
		return Integer.valueOf(queryObject.executeUpdate());
	}
	
	/* (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#bulkSQLUpdate(java.lang.String)
	 */
	public int bulkSQLUpdate(final String queryString){
		return bulkSQLUpdate(queryString, null);
	}
	
	/* (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#createSQLQuery(java.lang.String)
	 */
	public int bulkSQLUpdate(final String queryString, final Object[] values){
		SQLQuery queryObject = getSession().createSQLQuery(queryString);
		 if (values != null) {
		     for (int i = 0; i < values.length; ++i) {
	           queryObject.setParameter(i, values[i]);
	         }
		  }
		return Integer.valueOf(queryObject.executeUpdate());
	}

	/* 
	 * 使用HSQL语句检索数据
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByHql(java.lang.String)
	 */
	public List<T> getByHql(final String queryString) {
		return getByHqlParms(queryString, null);
	}

	/* 
	 * 使用带参数的HSQL语句检索数据
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByHqlParms(java.lang.String, java.lang.Object[])
	 */
	public List<T> getByHqlParms(final String queryString, final Object[] values) {
		Query queryObject = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; ++i) {
				queryObject.setParameter(i, values);
			}
		}
		return queryObject.list();
	}

	/* 
	 * 使用带命名的参数的HSQL语句检索数据
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<?> getByNamedParam(final String queryString,final String[] paramNames,
			final Object[] values) {
		if (paramNames.length != values.length) 
			 throw new IllegalArgumentException("Length of paramNames array must match length of values array");
		 Query queryObject = getSession().createQuery(queryString);
		 if (values != null) {
	          for (int i = 0; i < values.length; ++i) {
	             applyNamedParameterToQuery(queryObject, paramNames[i], values[i]);
	          }
	     }
		 return queryObject.list();
	}

	/* 
	 * 使用命名的HSQL语句检索数据
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByNamedQuery(java.lang.String)
	 */
	public List<T> getByNamedQuery(final String queryName) {
		return getByNamedQuery(queryName, null);
	}

	/* 
	 * 使用带参数的命名HSQL语句检索数据
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByNamedQuery(java.lang.String, java.lang.Object[])
	 */
	public List<T> getByNamedQuery(String queryName, Object[] values) {
		 Query queryObject = getSession().getNamedQuery(queryName);
		 if (values != null) {
           for (int i = 0; i < values.length; ++i) {
              queryObject.setParameter(i, values[i]);
           }
         }
		 return queryObject.list();
	}

	/* 
	 * 使用带命名参数的命名HSQL语句检索数据
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByNamedQueryAndNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<T> getByNamedQueryAndNamedParam(final String queryName,
			final String[] paramNames, final Object[] values) {
		if ((paramNames != null) && (values != null) && (paramNames.length != values.length)) {
			throw new IllegalArgumentException("Length of paramNames array must match length of values array");
		}
		 Query queryObject = getSession().getNamedQuery(queryName);
		 if (values != null) {
	           for (int i = 0; i < values.length; ++i) {
	             applyNamedParameterToQuery(queryObject, paramNames[i], values[i]);
	           }
		 }
		return queryObject.list();
	}

	/* 
	 * 使用HSQL语句检索数据，返回 Iterator
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getIterate(java.lang.String)
	 */
	public Iterator<T> getIterate(final String queryString) {
		return getIterate(queryString, null);
	}

	/* 
	 * 使用带参数HSQL语句检索数据，返回 Iterator
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getIterate(java.lang.String, java.lang.Object[])
	 */
	public Iterator<T> getIterate(final String queryString, final Object[] values) {
		Query queryObject = getSession().createQuery(queryString);
		if (values != null) {
		     for (int i = 0; i < values.length; ++i) {
		    	 queryObject.setParameter(i, values[i]);
		     }
		}
		return queryObject.iterate();
	}

	/* 
	 * 关闭检索返回的 Iterator
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#closeIterator(java.util.Iterator)
	 */
	public void closeIterator(Iterator<T> it) {
		try {
			 Hibernate.close(it);
		}catch (HibernateException ex) {
			throw SessionFactoryUtils.convertHibernateAccessException(ex);
		}
	}
	
	// -------------------------------- Criteria ------------------------------
	
	/* 
	 * 取得所有持久化类 start 开始位置 size 取得记录条数
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getAll(int, int)
	 */
	public List<T> getAll(final int first, final int max) {
		return getSession().createCriteria(persistentClass).setFirstResult(
				first).setMaxResults(max).list();
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<Object[]>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteriaForObject(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria){
		return getByDetachedCriteriaForObject(detachedCriteria, -1, -1);
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<Object[]>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteriaForObject(org.hibernate.criterion.DetachedCriteria, boolean)
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, final boolean cacheable){
		return getByDetachedCriteriaForObject(detachedCriteria, -1, -1, cacheable);
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<Object[]>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteriaForObject(org.hibernate.criterion.DetachedCriteria, int, int)
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, final int first, final int max){
		Criteria executableCriteria = detachedCriteria.getExecutableCriteria(getSession());
		if (first >= 0) executableCriteria.setFirstResult(first);
		if (max > 0) executableCriteria.setMaxResults(max);
		return executableCriteria.list();
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<Object[]>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteriaForObject(org.hibernate.criterion.DetachedCriteria, int, int, boolean)
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, final int first, final int max, final boolean cacheable){
		Criteria executableCriteria = detachedCriteria.getExecutableCriteria(getSession());
		executableCriteria.setCacheable(cacheable);//查询缓存
		if (first >= 0) executableCriteria.setFirstResult(first);
		if (max > 0) executableCriteria.setMaxResults(max);
		return executableCriteria.list();
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<T>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteria(org.hibernate.criterion.DetachedCriteria)
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria) {
		Criteria executableCriteria = detachedCriteria.getExecutableCriteria(getSession());
		return executableCriteria.list();
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<T>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, boolean)
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, final boolean cacheable) {
		Criteria executableCriteria = detachedCriteria.getExecutableCriteria(getSession());
		executableCriteria.setCacheable(cacheable);
		return executableCriteria.list();
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<T>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, int, int)
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, final int first, final int max) {
		Criteria executableCriteria = detachedCriteria.getExecutableCriteria(getSession());
		if (first >= 0) executableCriteria.setFirstResult(first);
		if (max > 0) executableCriteria.setMaxResults(max);
		return executableCriteria.list();
	}
	
	/* 
	 * 用DetachedCriteria取得持久化类的List<T>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByDetachedCriteria(org.hibernate.criterion.DetachedCriteria, int, int, boolean)
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, final int first, final int max, final boolean cacheable) {
		Criteria executableCriteria = detachedCriteria.getExecutableCriteria(getSession());
		executableCriteria.setCacheable(cacheable);
		if (first >= 0) executableCriteria.setFirstResult(first);
		if (max > 0) executableCriteria.setMaxResults(max);
		return executableCriteria.list();
	}
	
	/* 
	 * 用Example取得持久化类的List<T>
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByExample(java.lang.Object)
	 */
	public List<T> getByExample(final T exampleInstance) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(persistentClass);
		Example example = Example.create(exampleInstance);
		detachedCriteria.add(example);
		return getByDetachedCriteria(detachedCriteria);
	}

	/**
	 * 用Example取得持久化类的LIST
	 * 
	 * @param exampleInstance
	 * @param excludeProperty
	 * @return
	 */
	/* 
	 * 用Example取得持久化类的List<T> excludeProperty排除字段
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getByExample(java.lang.Object, java.lang.String[])
	 */
	public List<T> getByExample(final T exampleInstance, final String[] excludeProperty) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(persistentClass);
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) example.excludeProperty(exclude);
		detachedCriteria.add(example);
		return getByDetachedCriteria(detachedCriteria);
	}

	/*// 使用指定的实体及属性检索（满足除主键外属性＝实体值）数据
	public List<T> findEqualByEntity(T entity, String[] propertyNames) {
		Criteria criteria = this.createCriteria();
		Example exam = Example.create(entity);
		exam.excludeZeroes();
		String[] defPropertys = getSessionFactory().getClassMetadata(
				persistentClass).getPropertyNames();
		for (String defProperty : defPropertys) {
			int ii = 0;
			for (ii = 0; ii < propertyNames.length; ++ii) {
				if (defProperty.equals(propertyNames[ii])) {
					criteria.addOrder(Order.asc(defProperty));
					break;
				}
			}
			if (ii == propertyNames.length) {
				exam.excludeProperty(defProperty);
			}
		}
		criteria.add(exam);
		return (List<T>) criteria.list();
	}*/

	/* 
	 * 使用指定的检索标准获取满足标准的记录数
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getRowCount(org.hibernate.criterion.DetachedCriteria)
	 */
	public int getRowCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Object[]> list = this.getByDetachedCriteriaForObject(criteria, 0, 1);
		return Integer.valueOf(String.valueOf(list.get(0)));
	}
	
	/* 
	 * 实体类总记录数
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getRowCount()
	 */
	public int getRowCount() {
		return (Integer) getSession().createCriteria(persistentClass)
				.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	/* 
	 * 使用指定的检索标准检索数据，返回指定统计值(max,min,avg,sum)
	 * (non-Javadoc)
	 * @see com.sanli.dao.GenericDao#getStatValue(org.hibernate.criterion.DetachedCriteria, java.lang.String, java.lang.String)
	 */
	public Object getStatValue(DetachedCriteria criteria, final String propertyName, final String StatName) {
		if (StatName.toLowerCase().equals("max"))
			criteria.setProjection(Projections.max(propertyName));
		else if (StatName.toLowerCase().equals("min"))
			criteria.setProjection(Projections.min(propertyName));
		else if (StatName.toLowerCase().equals("avg"))
			criteria.setProjection(Projections.avg(propertyName));
		else if (StatName.toLowerCase().equals("sum"))
			criteria.setProjection(Projections.sum(propertyName));
		else
			return null;
		List<Object[]> list = this.getByDetachedCriteriaForObject(criteria, 0, 1);
		return list.get(0);
	}
	
	// -------------------------------- Others --------------------------------
	// 实体缓存
/*	public void cacheQueries(boolean cacheQueries) {
		getHibernateTemplate().setCacheQueries(cacheQueries);
	}

	// 加锁指定的实体
	public void lock(T entity, LockMode lock) {
		getHibernateTemplate().lock(entity, lock);
	}*/

	// 强制初始化指定的实体
	public void initialize(Object proxy) {
		try {
			Hibernate.initialize(proxy);
		}catch (HibernateException ex) {
			throw SessionFactoryUtils.convertHibernateAccessException(ex);
		}
	}

	// 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	public void flush() {
		getSession().flush();
	}
	
	// 清空缓存
	public void clear() {
		getSession().clear();
	}
	
	/**
	 * @param queryObject hql sql 语句
	 * @param paramName 参数占位符 或者 序列
	 * @param value 值
	 * @throws HibernateException
	 */
	protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value) throws HibernateException{
		if (value instanceof Collection) {
			 queryObject.setParameterList(paramName, (Collection<?>)value);
			}else if (value instanceof Object[]) {
			  queryObject.setParameterList(paramName, (Object[])value);
			}else{
			  queryObject.setParameter(paramName, value);
		}
	 }

}
