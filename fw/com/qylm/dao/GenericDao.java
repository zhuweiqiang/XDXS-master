package com.qylm.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.criterion.DetachedCriteria;

/**
 * 提供DAO的基本CRUD操作，是所有DAO的父类的接口
 * @author smj
 *
 * @param <T> 持久化类
 * @param <ID> 主键
 */
public interface GenericDao<T , ID extends Serializable> {

	// -------------------- 基本检索、增加、修改、删除操作 --------------------

	/**
	 * 用主键取得持久化类
	 * @param id 主键
	 * @return 持久化类
	 */
	public T getById(final ID id);
	
	/**
	 * 用主键取得持久化类，并判断是否存在
	 * @param id 主键
	 * @return true 存在 false 不存在
	 */
	public boolean getAndCheckExistById(final ID id);
	
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
	 * 根据主键获取实体并加锁。如果没有相应的实体，返回 null
	 * @param id
	 * @param lockOptions
	 * @return
	 */
	public T getWithLock(final ID id, final LockOptions lockOptions);

	/**
	 * 根据主键获取实体。如果没有相应的实体，抛出异常。
	 * 
	 * @param id
	 *            主键
	 * @return 持久化类
	 */
	public T loadById(final ID id);
	
	/**
	 * 取得所有持久化类
	 * @return 持久化类集合
	 */
	public List<T> loadAll();

	/**
	 * 增加或更新实体
	 * @param entity 持久化类
	 */
	public void saveOrUpdate(T entity);
	
	/**
	 * 增加或更新集合中的全部实体
	 * @param entities 持久化类集合
	 */
	public void saveOrUpdateAll(Collection<T> entities);

	/**
	 * 根据主键删除指定实体
	 * @param id
	 */
	public void deleteEntityByID(final ID id);

	/**
	 * 
	 * 删除集合中的全部实体
	 * @param entities 持久化类集合
	 */
	public void deleteEntityAll(Collection<T> entities);
	
	/**
	 * @param t 持久化类
	 * @return 获得持久化类ID
	 */
	//public ID getByBaseEntityId(T entity);
	
	// -------------------- HSQL ----------------------------------------------

	/**
	 * 使用HSQL语句直接增加、更新、删除实体
	 * @param queryString = HSQL
	 * @return 影响的行数
	 */
	public int bulkUpdate(final String queryString);

	/**
	 * 使用带参数的HSQL语句增加、更新、删除实体
	 * @param queryString = HSQL
	 * @param values 参数
	 * @return 影响的行数
	 */
	public int bulkUpdate(final String queryString, final Object[] values);
	
	/**
	 * 使用SQL语句直接增加、更新、删除实体
	 * @param queryString = SQL
	 * @return 影响的行数
	 */
	public int bulkSQLUpdate(final String queryString);
	
	/**
	 * 使用SQL语句直接增加、更新、删除实体
	 * @param queryString = SQL
	 * @param values 参数
	 * @return 影响的行数
	 */
	public int bulkSQLUpdate(final String queryString, final Object[] values);

	/**
	 * @param queryString 使用HSQL语句检索数据
	 * @return 持久化类集合
	 */
	public List<T> getByHql(final String queryString);

	/**
	 * 使用带参数的HSQL语句检索数据
	 * @param queryString hql语句
	 * @param values 传入的参数
	 * @return 集合
	 */
	public List<?> getByHqlParms(final String queryString,final Object[] values);

	/**
	 * 使用带命名的参数的HSQL语句检索数据
	 * @param queryString
	 * @param paramNames
	 * @param values
	 * @return
	 */
	public List<?> getByNamedParam(final String queryString, final String[] paramNames,final Object[] values);

	/**
	 * 使用命名的HSQL语句检索数据
	 * @param queryName hql
	 * @return
	 */
	public List<T> getByNamedQuery(final String queryName);

	/**使用带参数的命名HSQL语句检索数据
	 * @param queryName hql
	 * @param values 值
	 * @return
	 */
	public List<T> getByNamedQuery(final String queryName, final Object[] values);

	/**使用带命名参数的命名HSQL语句检索数据
	 * @param queryName hql
	 * @param paramNames 别名
	 * @param values 值
	 * @return
	 */
	public List<T> getByNamedQueryAndNamedParam(final String queryName,
			final String[] paramNames, final Object[] values) ;

	/**
	 * 使用HSQL语句检索数据，返回 Iterator
	 * @param queryString hql
	 * @return
	 */
	public Iterator<T> getIterate(final String queryString);

	/**
	 * 使用带参数HSQL语句检索数据，返回 Iterator
	 * @param queryString
	 * @param values
	 * @return
	 */
	public Iterator<T> getIterate(final String queryString, final Object[] values);

	/**
	 * 关闭检索返回的 Iterator
	 * @param it
	 */
	public void closeIterator(Iterator<T> it);
	
// -------------------------------- Criteria ------------------------------
	
	/**
	 * 
	 * @return 持久化类集合
	 */
	public List<T> getAll();
	
	/**
	 * 
	 * @param criteria 检索条件
	 * @return 满足检索条件记录数
	 */
	public int getRowCount(DetachedCriteria criteria);
	
	/**
	 * @return 记录数
	 */
	public int getRowCount();	
	
	/**
	 * 取得所有持久化类
	 * @param start 开始位置
	 * @param size 取得记录条数
	 * @return 持久化类集合
	 */
	public List<T> getAll(final int start, final int size);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @return 持久化类的LIST
	 */
	/**
	 * @param detachedCriteria 检索条件
	 * @return 对象集合
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria);
	
	/**
	 * @param detachedCriteria 检索条件
	 * @param cacheable 是否缓存
	 * @return 对象集合
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria,final boolean cacheable);
	
	/**
	 * @param detachedCriteria 检索条件
	 * @param first 开始行
	 * @param max 获得纪录条数
	 * @return 对象集合
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, final int first, final int max);
	
	/**
	 * @param detachedCriteria 检索条件
	 * @param first 开始行
	 * @param max 获得纪录条数
	 * @param cacheable 是否缓存
	 * @return 对象集合
	 */
	public List<Object[]> getByDetachedCriteriaForObject(DetachedCriteria detachedCriteria, final int first, final int max,final boolean cacheable);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param cacheable 是否缓存
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria,final boolean cacheable);
	
	/**
	 * @param detachedCriteria 检索条件
	 * @param first 开始行
	 * @param max 获得纪录条数
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, final int first, final int max);
	
	/**
	 * @param detachedCriteria 检索条件
	 * @param first 开始行
	 * @param max 获得纪录条数
	 * @param cacheable 是否缓存
	 * @return 持久化类的LIST
	 */
	public List<T> getByDetachedCriteria(DetachedCriteria detachedCriteria, final int first, final int max,final boolean cacheable);
	
	/**
	 * 用Example取得持久化类的LIST
	 * @param exampleInstance
	 * @return 持久化类的LIST
	 */
	public List<T> getByExample(final T exampleInstance);
	
	/**
	 * 用Example取得持久化类的LIST
	 * @param exampleInstance
	 * @param excludeProperty
	 * @return
	 */
	public List<T> getByExample(final T exampleInstance, final String[] excludeProperty);
	
	/**
	 * @param criteria 检索条件
	 * @param propertyName  持久类字段
	 * @param StatName 指定统计值(max,min,avg,sum)
	 * @return
	 */
	public Object getStatValue(DetachedCriteria criteria, final String propertyName,
			final String StatName);
	
	// -------------------------------- Others --------------------------------
	// 实体缓存
	//public void cacheQueries(boolean cacheQueries);

	// 加锁指定的实体
	//public void lock(T entity, LockMode lock);

	/**
	 * 强制初始化指定的实体
	 * @param proxy
	 */
	public void initialize(final Object proxy);

	/**
	 * 强制立即更新缓冲数据到数据库（否则仅在事务提交时才更新）
	 * 清空内存中缓冲
	 */
	public void flush();
	
}
