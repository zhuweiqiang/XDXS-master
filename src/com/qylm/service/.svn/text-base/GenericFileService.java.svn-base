package com.qylm.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.exception.FileControlLogicException;

/**
 * 提供Service的基本CRUD操作，是所有Service的父类的接口
 * @author smj
 *
 * @param <T> 持久化类
 * @param <ID> 主键
 */
public interface GenericFileService<T, ID extends Serializable> extends GenericService<T,ID> {

	/*--------------------文件处理--------------------------*/
	/**
	 * @param entity 主键
	 * @return 持久化类
	 */
	public List<FileControl> getFileByEntity(T entity);
	
	/**
	 * @param entityList 持久类集合
	 * @return 持久化类Id对应的文件集合
	 */
	public Map<Integer,List<FileControl>> getFileByEntity(List<T> entityList);
	
	/**
	 * 保存持久化类，保存文件
	 * @param entity 持久化类
	 * @param fileEntity 上传文件
	 */
	public void saveFileEntity(T entity, FileEntity fileEntity) throws FileControlLogicException;
	
	/**
	 * 更新持久化类，保存文件
	 * @param entity 持久化类
	 * @param fileEntity 上传文件
	 */
	public void updateFileEntity(T entity, FileEntity fileEntity) throws FileControlLogicException;
	
	/**
	 * 删除持久化类时，删除文件
	 * @param entity
	 */
	public void deleteFileEntity(T entity);
	
	/**
	 * 删除持久化类List时，删除文件
	 * @param entityList
	 */
	public void deleteFileEntityAll(List<T> entityList);
	
	/**
	 * 删除单个文件
	 * @param fileControl
	 */
	public void deleteFileControl(FileControl fileControl);
	
	/**
	 * 删除单个文件
	 * @param fileControls
	 */
	public void deleteFileControlAll(Collection<FileControl> fileControls);
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param fileControlMap
	 * @param first
	 * @param max
	 * @return 持久化类的LIST
	 */
	public Map<T,List<FileControl>> getFileByDetachedCriteria(DetachedCriteria detachedCriteria, int first, int max);
	
}
