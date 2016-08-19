package com.qylm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 菜单
 * @author 
 */
@Entity
@Table(uniqueConstraints = {}, name = "treeitem")
public class TreeItem extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6659420066906769108L;
	
	/**
	 * 节点顺序
	 */
	public static final String ORDER = "order";
	
	/**
	 * 是否显示
	 */
	public static final String DISPLAY_CHILD_REN = "displayChildRen";
	
	/**
	 * 节点ID
	 */
	public static final String NODE_ID = "nodeId";
	
	/**
	 * 菜单类型
	 */
	public static final String NODE_TYPE ="nodeType";
	
	/**
	 * 菜单类型:后台菜单
	 */
	public static final String NODE_TYPE_1 ="1";
	
	/**
	 * 菜单类型：前台菜单
	 */
	public static final String NODE_TYPE_2 ="2";
	
	/**
	 * 菜单类型：无线端菜单
	 */
	public static final String NODE_TYPE_3 ="3";
	
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
	 * 菜单类型
	 *<ul>
	 * <li>1:后台菜单</li>
	 * <li>2:前台菜单</li>
	 * <li>3:无线端菜单(安卓、iso、)</li>
	 * </ul>
	 */
	private String nodeType;
	
	/**
	 * 节点的顺序，父子节点的分开算
	 */
	@Column(name="sequence")
	private Integer order;
	
	/**
	 * 节点的css class
	 */
	@Transient
	private String labelStyleClass;
	
	/**
	 * 事件节点的css class
	 */
	@Transient
	private String actionStyelClass;
	
	/**
	 * css class
	 */
	@Transient
	private String styleClass;
	
	/**
	 * 子节点css class
	 */
	@Transient
	private String childrenStyleClass;
	
	/**
	 * 子节点数组
	 */
	@Transient
	private List<TreeItem> children;
	
	/**
	 * 能够看到这个节点的用户的权限
	 */
	@Transient
	private int[] permissionLevel;
	
	/**
	 * 转化permissions为int数组
	 * @param permissions
	 */
	public void setPermissions(String permissions) {
		
	}
	
	/**
	 * 取得节点所要求的用户权限
	 * @return 节点所要求的用户权限
	 */
	public int[] getPermissionLevel(){
		return permissionLevel;
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
	 * @return the labelStyleClass
	 */
	public String getLabelStyleClass() {
		return labelStyleClass;
	}

	/**
	 * @param labelStyleClass the labelStyleClass to set
	 */
	public void setLabelStyleClass(String labelStyleClass) {
		this.labelStyleClass = labelStyleClass;
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
	 * @return the actionStyelClass
	 */
	public String getActionStyelClass() {
		return actionStyelClass;
	}

	/**
	 * @param actionStyelClass the actionStyelClass to set
	 */
	public void setActionStyelClass(String actionStyelClass) {
		this.actionStyelClass = actionStyelClass;
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
	 * @return the styleClass
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * @param styleClass the styleClass to set
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * @return the childrenStyleClass
	 */
	public String getChildrenStyleClass() {
		return childrenStyleClass;
	}

	/**
	 * @param childrenStyleClass the childrenStyleClass to set
	 */
	public void setChildrenStyleClass(String childrenStyleClass) {
		this.childrenStyleClass = childrenStyleClass;
	}

	/**
	 * @param permissionLevel the permissionLevel to set
	 */
	public void setPermissionLevel(int[] permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	/**
	 * @return the children
	 */
	public List<TreeItem> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeItem> children) {
		this.children = children;
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
