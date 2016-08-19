package com.qylm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;

/**
 * 保存文件登录画面注入的值
 * @author smj
 */
public class FileUploadDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -950611325382548286L;

	/**
	 * 上传文件基本信息
	 */
	private FileEntity fileEntity;
	
	/**
	 * 文件规范
	 */
	public Pattern pattern;
	
	/**
	 * 修改时传值
	 */
	private BaseEntity transferEntity;
	
	/**
	 * 文件集合
	 */
	private List<FileControl> fileControlList;
	
	/**
	 * 返回调用画面用工具类
	 */
	private Returner<?, ?, BaseEntity> returner;

	/**
	 * get fileEntity
	 * @return the fileEntity
	 */
	public FileEntity getFileEntity() {
		return fileEntity;
	}

	/**
	 * get pattern
	 * @return the pattern
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * get transferEntity
	 * @return the transferEntity
	 */
	public BaseEntity getTransferEntity() {
		return transferEntity;
	}

	/**
	 * get fileControlList
	 * @return the fileControlList
	 */
	public List<FileControl> getFileControlList() {
		return fileControlList;
	}

	/**
	 * get returner
	 * @return the returner
	 */
	public Returner<?, ?, BaseEntity> getReturner() {
		return returner;
	}

	/**
	 * set fileEntity
	 * @param fileEntity the fileEntity to set
	 */
	public void setFileEntity(FileEntity fileEntity) {
		this.fileEntity = fileEntity;
	}

	/**
	 * set pattern
	 * @param pattern the pattern to set
	 */
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	/**
	 * set transferEntity
	 * @param transferEntity the transferEntity to set
	 */
	public void setTransferEntity(BaseEntity transferEntity) {
		this.transferEntity = transferEntity;
	}

	/**
	 * set fileControlList
	 * @param fileControlList the fileControlList to set
	 */
	public void setFileControlList(List<FileControl> fileControlList) {
		this.fileControlList = fileControlList;
	}

	/**
	 * set returner
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, BaseEntity> returner) {
		this.returner = returner;
	}

}
