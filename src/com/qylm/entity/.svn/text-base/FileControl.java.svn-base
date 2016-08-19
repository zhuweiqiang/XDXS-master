package com.qylm.entity;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import com.qylm.common.PathUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;

/**
 * 文件管理实体化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "filecontrol")
public class FileControl extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8455776494721484551L;
	
	/**
	 * 分组查询条件
	 */
	public static final String CASUE_GROUP_SQL = "{alias}.entityType = ? group by {alias}.entityId,{alias}.entityType having max({alias}.entityId)";
	
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
	 * 检索条件：relativeUrl
	 */
	public static final String RELATIVE_URL = "relativeUrl";
	
	/**
	 * 检索条件：folder
	 */
	public static final String FOLDER = "folder";
	
	/**
	 * 检索条件：type
	 */
	public static final String TYPE = "type";
	
	/**
	 * 检索条件：TYPE_1
	 */
	public static final String TYPE_1 = "1";
	
	/**
	 * 检索条件：TYPE_2
	 */
	public static final String TYPE_2 = "2";
	
	/**
	 * 检索条件：DESCRIPTION_1
	 */
	public static final String DESCRIPTION_1 = "1";
	
	/**
	 * 检索条件：DESCRIPTION_2
	 */
	public static final String DESCRIPTION_2 = "2";
	
	/**
	 * 检索条件：DESCRIPTION_3
	 */
	public static final String DESCRIPTION_3 = "3";
	
	/**
	 * 检索条件：DESCRIPTION_4
	 */
	public static final String DESCRIPTION_4 = "4";
	
	/**
	 * 检索条件：DESCRIPTION_5
	 */
	public static final String DESCRIPTION_5 = "5";
	
	/**
	 * 检索条件：description
	 */
	public static final String DESCRIPTION = "description";
	
	

	/**
	 * 原始名称
	 */
	private String originalName;
	
	/**
	 * 当前名称
	 */
	private String currentName;
	
	/**
	 * 文件描述
	 * 车主信息审核时用于文件上传类型
	 * 1.车辆照片（车和人一起）
	 * 2.驾驶证（正本）
	 * 3.驾驶证（副本）
	 * 4.保险单（交强险）
	 * 5.保险单（商业险）
	 */
	private String description;
	
	/**
	 * 后缀名
	 */
	private String suffix;
	
	/**
	 * 文件夹
	 */
	private String folder;
	
	/**
	 * 文件类型
	 * 1.图片 图片用img显示
	 * 2.文件 文件用href显示
	 */
	private String type;
	
	/**
	 * 存放文件相对路径
	 */
	private String url;
	
	/**
	 * 文件大小
	 */
	private Long sizeLimit;
	
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
	 * 与改变账户明细相关的信息  企业信息营业执照
	 */
	@Any(metaColumn = @Column(name = "entityType"))
	@AnyMetaDef(idType = "integer", metaType = "string", metaValues = {
				@MetaValue(value = ProductStock.DISCRIMINATOR_PRODUCT_STOCK, targetEntity = com.qylm.entity.ProductStock.class),
				@MetaValue(value = Brand.DISCRIMINATOR_BRAND, targetEntity = com.qylm.entity.Brand.class)
		})
	@JoinColumn(name = "entityId")
	private BaseEntity entity;
	
	/**
	 * 方便查询 对应到@Any的属性
	 */
	@Column(insertable=false,updatable=false)
	private Integer entityId;
	
	/**
	 * 方便查询 对应到@Any的属性
	 */
	@Column(insertable=false,updatable=false)
	private String entityType;
	
	/**
	 * 默认状态，true为默认，在同一组内默认的只有一条
	 */
	private boolean defaultState;
	
	/**
     * 域对象ID（外键关联entityclass:id）
     */
    @ManyToOne(targetEntity = EntityClass.class)
    @JoinColumn(name = "entityclassId")
    private EntityClass entityclass;
    
    /**
     * 域对象的实例ID
     */
    @Column(name = "objectId")
    private Integer objectId;

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

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the sizeLimit
	 */
	public Long getSizeLimit() {
		return sizeLimit;
	}

	/**
	 * @param sizeLimit the sizeLimit to set
	 */
	public void setSizeLimit(Long sizeLimit) {
		this.sizeLimit = sizeLimit;
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
	 * @return the entity
	 */
	public BaseEntity getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}

	/**
	 * @return the entityId
	 */
	public Integer getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
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
	 * get defaultState
	 * @return the defaultState
	 */
	public boolean isDefaultState() {
		return defaultState;
	}

	/**
	 * set defaultState
	 * @param defaultState the defaultState to set
	 */
	public void setDefaultState(boolean defaultState) {
		this.defaultState = defaultState;
	}

	/**
	 * get entityclass
	 * @return the entityclass
	 */
	public EntityClass getEntityclass() {
		return entityclass;
	}

	/**
	 * get objectId
	 * @return the objectId
	 */
	public Integer getObjectId() {
		return objectId;
	}

	/**
	 * set entityclass
	 * @param entityclass the entityclass to set
	 */
	public void setEntityclass(EntityClass entityclass) {
		this.entityclass = entityclass;
	}

	/**
	 * set objectId
	 * @param objectId the objectId to set
	 */
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
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
			visitAddress = PathUtil.getStaffPhotoPath(url.substring(0, url.lastIndexOf(File.separator)), currentName);
		}
		return visitAddress;
	}

	/**
	 * @return the relativeVisit
	 */
	public String getRelativeVisit() {
		if(StringUtil.isNotBlank(url)){
			relativeVisit = url;
		}
		return relativeVisit;
	}
	
}
