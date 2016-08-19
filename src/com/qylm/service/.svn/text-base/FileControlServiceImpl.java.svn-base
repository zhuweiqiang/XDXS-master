package com.qylm.service;

import java.util.List;
import java.util.Map;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.FileControlDao;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.exception.FileControlLogicException;
import com.qylm.logic.FileControlLogic;

@Service("fileControlService")
public class FileControlServiceImpl extends GenericServiceImpl<FileControl, Integer> implements FileControlService {
	
	@Autowired
	protected FileControlServiceImpl(FileControlDao fileControlDao) {
		super(fileControlDao);
	}
	
	@Autowired
	private FileControlLogic fileControlLogic;
	
	/**
	 * @param entityClass 持久化类class名称
	 * @param entity 持久化类
	 * @return 持久化类对应文件
	 */
	public FileControl getFileControlOne(BaseEntity entity){
		return fileControlLogic.getFileControlOne(entity);
	}

	/**
	 * @param entityClass 持久化类class名称
	 * @param entity 持久化类
	 * @return 持久化类对应文件
	 */
	public List<FileControl> getFileControlList(BaseEntity entity){
		return fileControlLogic.getFileControlList(entity);
	}
	
	/**
	 * @param entity 上传文件对应哪个持久化类
	 * @param fileEntity 文件信息
	 * @return 文件控件
	 * @throws FileControlLogicException 
	 */
	public FileControl saveEntity(BaseEntity entity, FileEntity fileEntity) throws FileControlLogicException{
		return fileControlLogic.saveEntity(entity, fileEntity);
	}
	
	/**
	 * @param entity 上传文件对应哪个持久化类
	 * @param fileEntity 文件信息
	 * @return 文件控件
	 * @throws FileControlLogicException 
	 */
	public FileControl updateEntity(BaseEntity entity, FileEntity fileEntity) throws FileControlLogicException{
		return fileControlLogic.updateEntity(entity, fileEntity);
	}
	
	@Override
	public void deleteEntity(FileControl fileControl){
		fileControlLogic.deleteEntity(fileControl);
	}

	public Map<Integer, FileControl> getFileControlOneList(List<? extends BaseEntity> entityList) {
		return fileControlLogic.getFileControlOneList(entityList);
	}

	public Map<Integer, List<FileControl>> getFileControlManyList(List<? extends BaseEntity> entityList) {
		return fileControlLogic.getFileControlManyList(entityList);
	}

	/**
	 * @param fileControlLogic the fileControlLogic to set
	 */
	public void setFileControlLogic(FileControlLogic fileControlLogic) {
		this.fileControlLogic = fileControlLogic;
	}

	public FileControl saveEntity(BaseEntity entity, String type, UploadedFile uploadedFile) {
		return fileControlLogic.saveEntity(entity, type, uploadedFile);
	}

}
