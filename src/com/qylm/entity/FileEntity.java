package com.qylm.entity;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.primefaces.model.UploadedFile;

/**
 * @author ThinkPad
 *
 */
public class FileEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6828084588018434006L;
	
	public FileEntity(){}
	
	/**
	 * @param baseEntity
	 */
	public FileEntity(BaseEntity baseEntity){
		this(baseEntity, false);
	}
	
	/**
	 * @param uploadedFile
	 * @param folder
	 */
	public FileEntity(UploadedFile uploadedFile, String folder){
		this.uploadedFile = uploadedFile;
		this.folder = folder;
	}
	
	/**
	 * @param baseEntity
	 * @param encryption 是否加密
	 */
	public FileEntity(BaseEntity baseEntity, boolean encryption){
		this.baseEntity = baseEntity;
		this.encryption = encryption;
	}
	
	/**
	 * @param baseEntity
	 * @param encryptionPass 是否加密
	 */
	public FileEntity(BaseEntity baseEntity, String encryptionPass){
		this(baseEntity,encryptionPass,null);
	}
	
	/**
	 * @param baseEntity
	 * @param folder 文件夹
	 */
	public FileEntity(BaseEntity baseEntity, String encryptionPass, String folder){
		this(baseEntity,folder,false);
		this.encryptionPass = encryptionPass;
	}
	
	/**
	 * @param baseEntity
	 * @param folder 文件夹
	 * @param encryption 加密
	 */
	public FileEntity(BaseEntity baseEntity, String folder, boolean encryption){
		this.baseEntity = baseEntity;
		this.folder = folder;
		this.encryption = encryption;
	}
	
	/**
	 * @param baseEntity
	 * @param folder 文件夹
	 * @param encryption 加密
	 * @param deleteFile 是否删除已上传的文件
	 */
	public FileEntity(BaseEntity baseEntity, String folder, boolean encryption, boolean deleteFile){
		this.baseEntity = baseEntity;
		this.folder = folder;
		this.encryption = encryption;
		this.deleteFile = deleteFile;
	}
	
	/**
	 * baseEntity
	 */
	private BaseEntity baseEntity;

	/**
	 * 上传文件
	 */
	private UploadedFile uploadedFile;
	
	/**
	 * 上传文件规则
	 */
	private Pattern pattern;
	
	/**
	 * 存放文件夹
	 */
	private String folder;
	
	/**
	 * 更新时是否删除原文件
	 */
	private boolean deleteFile;
	
	/**
	 * 是否加密
	 */
	private boolean encryption;
	
	/**
	 * 加密类型
	 */
	private String encryptionType;
	
	/**
	 * 加密密码
	 */
	private String encryptionPass;
	
	/**
	 * 车主信息审核时用于文件上传类型
	 * 1.车辆照片（车和人一起）
	 * 2.驾驶证（正本）
	 * 3.驾驶证（副本）
	 * 4.保险单（交强险）
	 * 5.保险单（商业险）
	 */
	private String description;
	
	/**
	 * @return the baseEntity
	 */
	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	/**
	 * @param baseEntity the baseEntity to set
	 */
	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}

	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/**
	 * @return the pattern
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

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
	 * @return the deleteFile
	 */
	public boolean isDeleteFile() {
		return deleteFile;
	}

	/**
	 * @param deleteFile the deleteFile to set
	 */
	public void setDeleteFile(boolean deleteFile) {
		this.deleteFile = deleteFile;
	}

	/**
	 * @return the encryption
	 */
	public boolean isEncryption() {
		return encryption;
	}

	/**
	 * @param encryption the encryption to set
	 */
	public void setEncryption(boolean encryption) {
		this.encryption = encryption;
	}

	/**
	 * @return the encryptionType
	 */
	public String getEncryptionType() {
		return encryptionType;
	}

	/**
	 * @param encryptionType the encryptionType to set
	 */
	public void setEncryptionType(String encryptionType) {
		this.encryptionType = encryptionType;
	}

	/**
	 * @return the encryptionPass
	 */
	public String getEncryptionPass() {
		return encryptionPass;
	}

	/**
	 * @param encryptionPass the encryptionPass to set
	 */
	public void setEncryptionPass(String encryptionPass) {
		this.encryptionPass = encryptionPass;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
