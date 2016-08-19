package com.qylm.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 提供Service的基本CRUD操作，是�?��Service的父类的接口
 * @author smj
 *
 * @param <T> 持久化类
 * @param <ID> 主键
 */
public interface GenericService<T, ID extends Serializable> {

	/**
	 * 用主键取得持久化�?
	 * @param id 主键
	 * @return 持久化类
	 */
	public T getById(ID id);
	
	/**
	 * 用主键取得持久化类，并判断是否存�?
	 * @param id 主键
	 * @return true 存在 false 不存�?
	 */
	public boolean getAndCheckExistById(ID id);
	
	/**
	 * 取得�?��持久化类
	 */
	public List<T> getAll();
	
	/**
	 * 取得�?��持久化类
	 * @param first �?��位置
	 * @param max 取得记录条数
	 * @return
	 */
	public List<T> getAll(int first, int max);
	
	/** 
	 * 使用指定的检索标准获取满足标准的记录�?
	 * 在不同会话中�?
	 * @return
	 */
	public int getRowCount(DetachedCriteria criteria);
	
	/**
	 * 取得结果的件�?
	 * @return
	 */
	public int getRowCount();
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, boolean cacheable);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, int first, int max);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, int first, int max, boolean cacheable);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, boolean cacheable);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, int first, int max);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, int first, int max, boolean cacheable);
	
	/**
	 * 用Example取得持久化类的LIST
	 * @param exampleInstance
	 * @return 持久化类的LIST
	 */
	public List<T> getByExample(T exampleInstance);
	
	/**
	 * 用Example取得持久化类的LIST
	 * @param exampleInstance
	 * @param excludeProperty
	 * @return
	 */
	public List<T> getByExample(T exampleInstance, String[] excludeProperty);
	
	/**
	 * 更新持久化类
	 * @param entity 持久化类
	 */
	public void updateEntity(T entity);
	
	/**
	 * 更新持久化类的Collection
	 * @param entities 持久化类的Collection
	 */
	public void updateEntityAll(Collection<T> entities);
	
	/**
	 * 增加或更新实�?(non-Javadoc)
	 * 
	 */
	public void saveOrUpdate(T entity);
	
	/**
	 * 增加或更新集�?
	 */
	public void saveOrUpdateAll(Collection<T> entities);
	
	/**
	 * 插入持久化类
	 * @param entity 持久化类
	 */
	public void saveEntity(T entity);
	
	/**
	 * 插入持久化类的Collection
	 * @param entities 持久化类的Collection
	 */
	public void saveEntityAll(Collection<T> entities);
	
	/**
	 * 删除持久化类
	 * @param entity 持久化类
	 */
	public void deleteEntity(T entity);
	
	/**
	 * 删除持久化类
	 * @param entities
	 */
	public void deleteEntityAll(Collection<T> entities);
	
	public Object getStatValue(DetachedCriteria criteria, String propertyName,String StatName);
	
	/* 
	 * 使用HSQL语句直接增加、更新�?删除实体
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#bulkUpdate(java.lang.String)
	 */
	public int bulkUpdate(String queryString);

	/* 使用带参数的HSQL语句增加、更新�?删除实体
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#bulkUpdate(java.lang.String, java.lang.Object[])
	 */
	public int bulkUpdate(String queryString, Object[] values);
	
	public int bulkSQLUpdate(final String queryString);
	
	public int bulkSQLUpdate(final String queryString, Object[] values);

	// 使用HSQL语句�?��数据
	/* (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#find(java.lang.String)
	 */
	public List<T> getByHql(String queryString);

	/**使用带参数的HSQL语句�?��数据
	 * @param queryString hql语句
	 * @param values 传入的参�?
	 * @return 集合
	 */
	public List<?> getByHqlParms(String queryString, Object[] values);

	/* 使用带命名的参数的HSQL语句�?��数据
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#findByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<?> getByNamedParam(String queryString, String[] paramNames,
			Object[] values);

	/* 使用命名的HSQL语句�?��数据
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#findByNamedQuery(java.lang.String)
	 */
	/**
	 * @param queryName
	 * @return
	 */
	public List<T> getByNamedQuery(String queryName);

	/**使用带参数的命名HSQL语句�?��数据
	 * @param queryName
	 * @param values
	 * @return
	 */
	public List<T> getByNamedQuery(String queryName, Object[] values);
	/**使用带命名参数的命名HSQL语句�?��数据
	 * @param queryName
	 * @param paramNames
	 * @param values
	 * @return
	 */
	public List<T> getByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values);
	
	// 实体缓存
	public void setCacheQueries(boolean cacheQueries);
	
	// 强制初始化指定的实体
	public void initialize(Object proxy);
	
	// 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	public void flush();

}
