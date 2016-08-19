package com.qylm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.envers.RevisionNumber;
import org.hibernate.search.annotations.DocumentId;

@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2214597757047342587L;

	/**
	 * 主键
	 */
	public static final String BASE_ID = "id";
	
	/**
	 * 创建时间
	 */
	public final static String CREATE_DATE = "createDate";
	
	/**
	 * 更新时间
	 */
	public final static String UPDATE_DATE = "updateDate";
	
	/**
	 * 创建
	 */
	public final static String CREATER = "creater";
	
	/**
	 * 创建者级别
	 */
	public final static String CREATER_USERLEVEL = "creater.userlevel";
	
	/**
	 * 创建者上级
	 */
	public final static String CREATER_BELONGING_USER = "creater.belongingUser";
	
	/**
	 * 别名，上级
	 */
	public final static String BELONGING_USER = "belongingUser";
	
	/**
	 * 别名，上级ID
	 */
	public final static String BELONGING_USER_ID = "belongingUser.id";
	
	/**
	 * 上级的用户级别
	 */
	public final static String USERLEVEL = "belongingUser.userlevel";
	
	/**
	 * 创建人ID
	 */
	public final static String CREATER_ID = "creater.id";
	
	/**
	 * 创建人名
	 */
	public final static String CREATER_USERNAME = "creater.username";
	
	/**
	 * 创建人名
	 */
	public final static String CREATER_REALNAME = "creater.realName";
	
	/**
	 * 版本
	 */
	public final static String VERSION = "version";
	
	/**
	 * 主键
	 */
	@Id
	@DocumentId
	@RevisionNumber
	@Access(AccessType.PROPERTY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	/**
	 * 记录的创建时间
	 */
	private Date createDate;
	
	/**
	 * 记录的更新时间
	 */
	private Date updateDate;

	/**
	 * 乐观锁
	 */
	@Version
	protected Integer version;
	
	/**
	 * 创建人
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "createrId")
	private User creater;
	
	/**
	 * 上级
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "belongingId")
	private User belongingUser;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}

	/**
	 * @param creater the creater to set
	 */
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
	/**
	 * @return the belongingUser
	 */
	public User getBelongingUser() {
		return belongingUser;
	}

	/**
	 * @param belongingUser the belongingUser to set
	 */
	public void setBelongingUser(User belongingUser) {
		this.belongingUser = belongingUser;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BaseEntity)) {
			return false;
		}
		BaseEntity other = (BaseEntity) object;
		return (this.id == null && other.id == null) ? super.equals(object)
				: (((this.id != null) || (other.id == null)) && ((this.id == null) || (this.id
						.equals(other.id))));
	}

}
