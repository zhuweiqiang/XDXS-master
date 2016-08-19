package com.qylm.entity;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.qylm.common.PathUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;

/**
 * 文件导入实体化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "fileexport")
public class FileExport extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5172295884927552283L;
	
	/**
	 * 检索条件：entity
	 */
	public static final String ENTITY = "entity";
	
	/**
	 * 检索条件：entityId
	 * 
	 */
	public static final String ENTITY_ID = "entityId";
	
	/**
	 * 检索条件：entityType
	 */
	public static final String ENTITY_TYPE = "entityType";

	/**
	 * 原始名称
	 */
	private String originalName;
	
	/**
	 * 当前名称
	 */
	private String currentName;
	
	/**
	 * 文件夹
	 */
	private String folder;
	
	/**
	 * 存放文件相对路径
	 */
	private String url;
	
	/**
	 * 方便查询 对应到@Any的属性
	 */
	private String entityType;
	
	/**
	 * 用于存放文件绝对路径，与数据库无关
	 */
	@Transient
	private String absoluteUrl;
	
	/**
	 * 用于存放文件绝对访问地址，与数据库无关
	 */
	@Transient
	private String visitAddress;
	
	/**
	 * 用于存放文件相对访问地址，与数据库无关
	 */
	@Transient
	private String relativeVisit;
	
	/**
	 * @return the originalName
	 */
	public String getOriginalName() {
		return originalName;
	}

	/**
	 * @param originalName the originalName to set
	 */
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	/**
	 * @return the currentName
	 */
	public String getCurrentName() {
		return currentName;
	}

	/**
	 * @param currentName the currentName to set
	 */
	public void setCurrentName(String currentName) {
		this.currentName = currentName;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the absoluteUrl
	 */
	public String getAbsoluteUrl() {
		if(StringUtil.isNotBlank(url)){
			absoluteUrl = Constants.fileStorePath + url;
		}
		return absoluteUrl;
	}

	/**
	 * @return the visitAddress
	 */
	public String getVisitAddress() {
		if(StringUtil.isNotBlank(url)){
			visitAddress = PathUtil.getStaffPhotoPath(url.substring(0, url.lastIndexOf(File.separator)), currentName);visitAddress = PathUtil.getStaffPhotoPath(url.substring(0, url.lastIndexOf(File.separator)), currentName);
		}
		return visitAddress;
	}

	/**
	 * @return the relativeVisit
	 */
	public String getRelativeVisit() {
		if(StringUtil.isNotBlank(url)){
			relativeVisit = "/zjby/" + url;
		}
		return relativeVisit;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof FileExport)) {
			return false;
		}
		FileExport other = (FileExport) object;
		return (this.id == null && other.id == null) ? super.equals(object)
				: (((this.id != null) || (other.id == null)) && ((this.id == null) || (this.id
						.equals(other.id))));
	}
	
}
