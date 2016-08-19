package com.qylm.service;

import java.util.List;
import java.util.Map;

import org.primefaces.model.UploadedFile;

import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.exception.FileControlLogicException;

public interface FileControlService extends GenericService<FileControl, Integer> {
	
	/**
	 * 根据继承的实体对象获取单个文件对象
	 * @param entity
	 * @return
	 */
	public FileControl getFileControlOne(BaseEntity entity);
	
	/**
	 * 根据继承的实体对象获取多个文件对象
	 * @param entity
	 * @return
	 */
	public List<FileControl> getFileControlList(BaseEntity entity);
	
	/**
	 * 批量获取文件信息，但是每个对象只获取一个
	 * @param entityList
	 * @return
	 */
	public Map<Integer,FileControl> getFileControlOneList(List<? extends BaseEntity> entityList);
	
	/**
	 * 批量获取文件信息，一对多
	 * @param entityList
	 * @return
	 */
	public Map<Integer,List<FileControl>> getFileControlManyList(List<? extends BaseEntity> entityList);
	
	/**
	 * 保存文件信息
	 * @param entity
	 * @param fileEntity
	 * @return
	 * @throws FileControlLogicException
	 */
	public FileControl saveEntity(BaseEntity entity, FileEntity fileEntity) throws FileControlLogicException;
	
	/**
	 * 更新文件信息
	 * @param entity
	 * @param fileEntity
	 * @return
	 * @throws FileControlLogicException
	 */
	public FileControl updateEntity(BaseEntity entity, FileEntity fileEntity) throws FileControlLogicException;
	
	/**
	 * 保存文件信息，并保存文件
	 * @param entity
	 * @param type
	 * @param uploadedFile
	 * @return
	 */
	public FileControl saveEntity(BaseEntity entity,String type,UploadedFile uploadedFile);
	
}
