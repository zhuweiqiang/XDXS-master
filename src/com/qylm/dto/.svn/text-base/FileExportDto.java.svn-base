package com.qylm.dto;

import java.io.Serializable;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.common.expand.FileExportExtService;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileExport;

/**
 * 保存文件登录画面注入的值
 * @author smj
 */
public class FileExportDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8354101217632082779L;

	/**
	 * 文件夹
	 */
	private String folder;
	
	/**
	 * 修改时传值
	 */
	private String entityType;
	
	/**
	 * 文件控制业务类
	 */
	private FileExportExtService fileExportExtService;
	
	/**
	 * 文件集合
	 */
	private List<FileExport> fileExportList;
	
	/**
	 * 返回调用画面用工具类
	 */
	private Returner<?, ?, BaseEntity> returner;

	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

	/**
	 * @return the entityType
	 */
	public String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	/**
	 * @return the fileExportExtService
	 */
	public FileExportExtService getFileExportExtService() {
		return fileExportExtService;
	}

	/**
	 * @param fileExportExtService the fileExportExtService to set
	 */
	public void setFileExportExtService(FileExportExtService fileExportExtService) {
		this.fileExportExtService = fileExportExtService;
	}

	/**
	 * @return the fileExportList
	 */
	public List<FileExport> getFileExportList() {
		return fileExportList;
	}

	/**
	 * @param fileExportList the fileExportList to set
	 */
	public void setFileExportList(List<FileExport> fileExportList) {
		this.fileExportList = fileExportList;
	}

	/**
	 * @return the returner
	 */
	public Returner<?, ?, BaseEntity> getReturner() {
		return returner;
	}

	/**
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, BaseEntity> returner) {
		this.returner = returner;
	}

}
