package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.qylm.common.SelectItemCreator;

/**
 * @author smj
 * 
 */
@Entity
@Table(uniqueConstraints = {}, name = "role")
public class Role extends BaseEntity implements SelectItemCreator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -874042631895248965L;
	
	/**
	 * roleName
	 */
	public static final String ROLE_NAME = "roleName";
	
	/**
	 * 企业权限
	 */
	public static final String ROLE_ENTERPRISE = "企业权限";
	
	/**
	 * 车主权限
	 */
	public static final String ROLE_CARGO_INFO = "车主权限";

	/**
	 * 权限,角色
	 */
	private String roleName;

	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 权限详细
	 */
	@Transient
	private String roles;
	
	public String getValue() {
		return this.id.toString();
	}

	public String getLabel() {
		return this.roleName;
	}
	
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
