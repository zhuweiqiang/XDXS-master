package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author smj
 * 
 */
@Entity
@Table(uniqueConstraints = {}, name = "role_detail")
public class RoleDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2308186804708106162L;
	
	/**
	 * 搜索条件：role
	 */
	public static final String ROLE	= "role";
	
	/**
	 * 搜索条件：treeItem
	 */
	public static final String TREE_ITEM = "treeItem";
	
	/**
	 * 搜索条件：treeItem.action
	 */
	public static final String TREE_ITEM_ACTION = "treeItem.action";
	
	/**
	 * 搜索条件：function
	 */
	public static final String FUNCTION = "function";
	
	/**
	 * 角色
	 */
	@ManyToOne(targetEntity = Role.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private Role role;

	/**
	 * 菜单
	 */
	@ManyToOne(targetEntity = TreeItem.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "treeItemId")
	private TreeItem treeItem;
	
	/**
	 * 功能
	 */
	@ManyToOne(targetEntity = Function.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "functionId")
	private Function function;

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

	/**
	 * @return the treeItem
	 */
	public TreeItem getTreeItem() {
		return treeItem;
	}

	/**
	 * @param treeItem the treeItem to set
	 */
	public void setTreeItem(TreeItem treeItem) {
		this.treeItem = treeItem;
	}

	/**
	 * @return the function
	 */
	public Function getFunction() {
		return function;
	}

	/**
	 * @param function the function to set
	 */
	public void setFunction(Function function) {
		this.function = function;
	}

}
