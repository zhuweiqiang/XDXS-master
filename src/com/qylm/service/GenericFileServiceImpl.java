package com.qylm.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.GenericDao;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.exception.FileControlLogicException;
import com.qylm.logic.FileControlLogic;

/**
 * 提供Service的基本CRUD操作，是所有Service的父类
 * @author smj
 *
 * @param <T> 持久化类
 * @param <ID> 主键
 */
public class GenericFileServiceImpl<T, ID extends Serializable> extends GenericServiceImpl<T,ID> implements GenericFileService<T, ID>{
	
	@Autowired
	private FileControlLogic fileControlLogic;
	
	/**
	 * @param fileControlLogic the fileControlLogic to set
	 */
	public void setFileControlLogic(FileControlLogic fileControlLogic) {
		this.fileControlLogic = fileControlLogic;
	}

	protected GenericFileServiceImpl(GenericDao<T, ID> genericDAO) {
		super(genericDAO);
	}

	/*--------------------文件处理--------------------------*/
	/**
	 * 用主键取得持久化类
	 * @param id 主键
	 * @param fileControlList 单个持久类对应的文件
	 * @return 持久化类
	 */
	public List<FileControl> getFileByEntity(T entity){
		return fileControlLogic.getFileControlList((BaseEntity) entity);
	}
	
	/**
	 * 用主键取得持久化类
	 * @param id 主键
	 * @param fileControlList 单个持久类对应的文件
	 * @return 持久化类
	 */
	@SuppressWarnings("unchecked")
	public Map<Integer,List<FileControl>> getFileByEntity(List<T> entityList){
		return fileControlLogic.getFileControlManyList((List<? extends BaseEntity>) entityList);
	}
	
	/**
	 * 保存持久化类，保存文件
	 * @param entity 持久化类
	 * @param uploadedFile 上传文件
	 * @throws FileControlLogicException 
	 */
	public void saveFileEntity(T entity, FileEntity fileEntity) throws FileControlLogicException{
		genericDAO.saveEntity(entity);
		fileControlLogic.saveEntity((BaseEntity) entity, fileEntity);
	}
	
	/**
	 * 更新持久化类，保存文件
	 * @param entity 持久化类
	 * @param uploadedFile 上传文件
	 */
	public void updateFileEntity(T entity, FileEntity fileEntity) throws FileControlLogicException{
		genericDAO.updateEntity(entity);
		fileControlLogic.updateEntity((BaseEntity) entity, fileEntity);
	}
	
	/**
	 * 删除持久化类时，删除文件
	 * @param entity
	 */
	public void deleteFileEntity(T entity){
		List<FileControl> fileControlList = getFileByEntity(entity);
		genericDAO.deleteEntity(entity);
		for(FileControl fileControl : fileControlList){//统一删除文件
			fileControlLogic.deleteEntity(fileControl);
		}
	}
	
	/**
	 * 删除持久化类List时，删除文件
	 * @param entityList
	 */
	public void deleteFileEntityAll(List<T> entityList){
		for(T entity:entityList)deleteFileEntity(entity);
	}
	
	/* (non-Javadoc)
	 * @see com.sanli.service.GenericFileService#deleteFileControl(com.sanli.entity.FileControl)
	 */
	public void deleteFileControl(FileControl fileControl) {
		fileControlLogic.deleteEntity(fileControl);
	}

	/* (non-Javadoc)
	 * @see com.sanli.service.GenericFileService#deleteFileControlAll(java.util.Collection)
	 */
	public void deleteFileControlAll(Collection<FileControl> fileControls) {
		for(FileControl fileControl : fileControls)fileControlLogic.deleteEntity(fileControl);
	}
	
	/**
	 * 用DetachedCriteria取得持久化类的LIST
	 * @param detachedCriteria
	 * @param fileControlMap
	 * @param first
	 * @param max
	 * @return 持久化类的LIST
	 */
	public Map<T,List<FileControl>> getFileByDetachedCriteria(DetachedCriteria detachedCriteria, int first, int max){
		List<T> entityList = genericDAO.getByDetachedCriteria(detachedCriteria, first, max);
		Map<T,List<FileControl>> entityMap = new HashMap<T,List<FileControl>>();
		Map<Integer,List<FileControl>> fileControlListMap = getFileByEntity(entityList);
		for(T t : entityList)entityMap.put(t, fileControlListMap.get(((BaseEntity) t).getId()));
		return entityMap;
	}
	
}
