package com.qylm.dto.system;

import java.io.Serializable;

/**
 * 保存菜单管理画面需要的值
 * @author smj
 */
public class TreeItemManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3750496898790364514L;
	
	/**
	 * ID，值有id就是修改，没有id就是保存
	 */
	private Integer treeItemId;
	
	/**
	 * 上级节点ID
	 * <p>※以nodeIdA(父)<B>:</B>nodeIdB(子)的形式来确定父子节点
	 */
	private String superiorNodeId;

	/**
	 * 节点ID
	 * <p>※以nodeIdA(父)<B>:</B>nodeIdB(子)的形式来确定父子节点
	 */
	private String nodeId;
	
	/**
	 * 初始状态子节点是否显示
	 */
	private boolean displayChildRen;
	
	/**
	 * 节点名
	 */
	private String label;
	
	/**
	 * 节点事件
	 */
	private String action;
	
	/**
	 * 目标frame
	 */
	private String target;
	
	/**
	 * 节点的顺序，父子节点的分开算
	 */
	private Integer order;
	
	/**
	 * 菜单类型
	 *<ul>
	 * <li>1:后台菜单</li>
	 * <li>2:前台菜单</li>
	 * <li>3:无线端菜单(安卓、iso、)</li>
	 * </ul>
	 */
	private String nodeType;

	/**
	 * @return the treeItemId
	 */
	public Integer getTreeItemId() {
		return treeItemId;
	}

	/**
	 * @param treeItemId the treeItemId to set
	 */
	public void setTreeItemId(Integer treeItemId) {
		this.treeItemId = treeItemId;
	}

	/**
	 * @return the superiorNodeId
	 */
	public String getSuperiorNodeId() {
		return superiorNodeId;
	}

	/**
	 * @param superiorNodeId the superiorNodeId to set
	 */
	public void setSuperiorNodeId(String superiorNodeId) {
		this.superiorNodeId = superiorNodeId;
	}

	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}

	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return the displayChildRen
	 */
	public boolean isDisplayChildRen() {
		return displayChildRen;
	}

	/**
	 * @param displayChildRen the displayChildRen to set
	 */
	public void setDisplayChildRen(boolean displayChildRen) {
		this.displayChildRen = displayChildRen;
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * @return the nodeType
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * @param nodeType the nodeType to set
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

}
