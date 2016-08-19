package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户与角色之间的关系表
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "user_role")
public class UserRole extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2390574834961392303L;

	/**
	 * 搜索条件：user
	 */
	public static final String USER	= "user";
	
	/**
	 * 搜索条件：role
	 */
	public static final String ROLE	= "role";
	
	/**
	 * 搜索条件：role.id
	 */
	public static final String ROLE_ID	= "role.id";
	
	/**
	 * 用户
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	/**
	 * 角色
	 */
	@ManyToOne(targetEntity = Role.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private Role role;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
