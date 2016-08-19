package com.qylm.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.qylm.dao.GenericDao;

/**
 * 提供Service的基本CRUD操作，是�?��Service的父�?
 * @author smj
 *
 * @param <T> 持久化类
 * @param <ID> 主键
 */
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID>{
	
	/**
	 * 共�?Dao
	 */
	protected GenericDao<T, ID> genericDAO;
	
	protected GenericServiceImpl(GenericDao<T, ID> genericDAO){
		this.genericDAO = genericDAO;
	}
	
	/**
	 * 用主键取得持久化�?
	 * @param id 主键
	 * @return 持久化类
	 */
	public T getById(ID id) {
	    return genericDAO.getById(id);   
	}
	
	/**
	 * 用主键取得持久化类，并判断是否存�?
	 * @param id 主键
	 * @return true 存在 false 不存�?
	 */
	public boolean getAndCheckExistById(ID id){
		return genericDAO.getAndCheckExistById(id);
	}
	
	/**
	 * 取得�?��持久化类
	 */
	public List<T> getAll(){
		return genericDAO.getAll();
	}
	
	/**
	 * 取得�?��持久化类
	 * @param first �?��位置
	 * @param max 取得记录条数
	 * @return
	 */
	public List<T> getAll(int first, int max) {
		return genericDAO.getAll(first, max);
	}
	
	/** 
	 * 使用指定的检索标准获取满足标准的记录�?
	 * 在不同会话中�?
	 * @return
	 */
	public int getRowCount(DetachedCriteria criteria){
		return genericDAO.getRowCount(criteria);
	}
	
	/**
	 * 取得结果的件�?
	 * @return
	 */
	public int getRowCount(){
		return genericDAO.getRowCount();
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria){
		return genericDAO.getByDetachedCriteriaForObject(detachedCriteria);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, boolean cacheable){
		return genericDAO.getByDetachedCriteriaForObject(detachedCriteria, cacheable);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, int first, int max){
		return genericDAO.getByDetachedCriteriaForObject(detachedCriteria, first, max);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, int first, int max, boolean cacheable){
		return genericDAO.getByDetachedCriteriaForObject(detachedCriteria, first, max, cacheable);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria){
		return genericDAO.getByDetachedCriteria(detachedCriteria);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, boolean cacheable){
		return genericDAO.getByDetachedCriteria(detachedCriteria, cacheable);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, int first, int max){
		return genericDAO.getByDetachedCriteria(detachedCriteria, first, max);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param first
	 * @param max
	 * @param cacheable
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, int first, int max, boolean cacheable){
		return genericDAO.getByDetachedCriteria(detachedCriteria, first, max, cacheable);
	}
	
	/**
	 * 用Example取得持久化类的LIST
	 * @param exampleInstance
	 * @return 持久化类的LIST
	 */
	public List<T> getByExample(T exampleInstance) {
		return genericDAO.getByExample(exampleInstance);
	}
	
	/**
	 * 用Example取得持久化类的LIST
	 * @param exampleInstance
	 * @param excludeProperty
	 * @return
	 */
	public List<T> getByExample(T exampleInstance, String[] excludeProperty) {
		return genericDAO.getByExample(exampleInstance, excludeProperty);
	}
	
	/**
	 * 更新持久化类
	 * @param entity 持久化类
	 */
	public void updateEntity(T entity){
		genericDAO.updateEntity(entity);
	}
	
	/**
	 * 更新持久化类的Collection
	 * @param entities 持久化类的Collection
	 */
	public void updateEntityAll(Collection<T> entities){
		genericDAO.updateEntityAll(entities);
	}
	
	/**
	 * 增加或更新实�?
	 * @param entity 持久化类
	 */
	public void saveOrUpdate(T entity) {
		genericDAO.saveOrUpdate(entity);
	}

	/**
	 * 增加或更新集合中的全部实�?
	 * @param entities 持久化类的LIST
	 */
	public void saveOrUpdateAll(Collection<T> entities) {
		genericDAO.saveOrUpdateAll(entities);
	}
	
	/**
	 * 插入持久化类
	 * @param entity 持久化类
	 */
	public void saveEntity(T entity) {
		genericDAO.saveEntity(entity);
	}
	
	/**
	 * 插入持久化类的Collection
	 * @param entities 持久化类的Collection
	 */
	public void saveEntityAll(Collection<T> entities){
		genericDAO.saveEntityAll(entities);
	}
	
	/**
	 * 删除持久化类
	 * @param entity 持久化类
	 */
	public void deleteEntity(T entity){
		genericDAO.deleteEntity(entity);
	}
	
	/**
	 * 删除集合中的全部实体 (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#deleteAll(java.util.Collection)
	 */
	public void deleteEntityAll(Collection<T> entities) {
		genericDAO.deleteEntityAll(entities);
	}
	
	public Object getStatValue(DetachedCriteria criteria, String propertyName,String StatName){
		return genericDAO.getStatValue(criteria, propertyName, StatName);
	}
	// -------------------- HSQL ----------------------------------------------

	/* 
	 * 使用HSQL语句直接增加、更新�?删除实体
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#bulkUpdate(java.lang.String)
	 */
	public int bulkUpdate(String queryString) {
		return genericDAO.bulkUpdate(queryString);
	}

	/* 使用带参数的HSQL语句增加、更新�?删除实体
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#bulkUpdate(java.lang.String, java.lang.Object[])
	 */
	public int bulkUpdate(String queryString, Object[] values) {
		return genericDAO.bulkUpdate(queryString, values);
	}
	
	public int bulkSQLUpdate(final String queryString){
		return genericDAO.bulkSQLUpdate(queryString);
	}
	
	public int bulkSQLUpdate(final String queryString, Object[] values){
		return genericDAO.bulkSQLUpdate(queryString,values);
	}

	// 使用HSQL语句�?��数据
	/* (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#find(java.lang.String)
	 */
	public List<T> getByHql(String queryString) {
		return genericDAO.getByHql(queryString);
	}

	/**使用带参数的HSQL语句�?��数据
	 * @param queryString hql语句
	 * @param values 传入的参�?
	 * @return 集合
	 */
	/**
	 * @param queryString
	 * @param values
	 * @return
	 */
	public List<?> getByHqlParms(String queryString, Object[] values) {
		return genericDAO.getByHqlParms(queryString, values);
	}

	/* 使用带命名的参数的HSQL语句�?��数据
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#findByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<?> getByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		return genericDAO.getByNamedParam(queryString, paramNames,
				values);
	}

	/* 使用命名的HSQL语句�?��数据
	 * (non-Javadoc)
	 * @see com.zhuhong.dao.GenericDao#findByNamedQuery(java.lang.String)
	 */
	/**
	 * @param queryName
	 * @return
	 */
	public List<T> getByNamedQuery(String queryName) {
		return genericDAO.getByNamedQuery(queryName);
	}

	/**使用带参数的命名HSQL语句�?��数据
	 * @param queryName
	 * @param values
	 * @return
	 */
	public List<T> getByNamedQuery(String queryName, Object[] values) {
		return genericDAO.getByNamedQuery(queryName, values);
	}

	/**使用带命名参数的命名HSQL语句�?��数据
	 * @param queryName
	 * @param paramNames
	 * @param values
	 * @return
	 */
	public List<T> getByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) {
		return genericDAO.getByNamedQueryAndNamedParam(queryName,
				paramNames, values);
	}
	
	// 实体缓存
	public void setCacheQueries(boolean cacheQueries){
		//genericDAO.cacheQueries(cacheQueries);
	}
	
	// 强制初始化指定的实体
	public void initialize(Object proxy) {
		genericDAO.initialize(proxy);
	}
	
	// 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	public void flush(){
		genericDAO.flush();
	}
	
}
