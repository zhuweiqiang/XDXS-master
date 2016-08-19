package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 功能管理
 * @author 
 */
@Entity
@Table(uniqueConstraints = {}, name = "function")
public class Function extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6659420066906769108L;
	
	/**
	 * 菜单
	 */
	public static final String TREE_ITEM = "treeItem";
	
	/**
	 * rank
	 */
	public static final String RANK = "rank";
	
	/**
	 * enable
	 */
	public static final String ENABLE = "enable";
	
	/**
	 * 菜单
	 */
	@ManyToOne(targetEntity = TreeItem.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "treeItemId")
	private TreeItem treeItem;
	
	/**
	 * 功能名称
	 */
	private String label;
	
	/**
	 * 是否启用
	 */
	private boolean enable;
	
	/**
	 * 顺序
	 */
	private Integer rank;

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
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the rank
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
}
