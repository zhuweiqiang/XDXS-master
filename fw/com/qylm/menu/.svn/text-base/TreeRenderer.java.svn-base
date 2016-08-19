package com.qylm.menu;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.apache.myfaces.component.html.ext.HtmlCommandLink;

import com.qylm.constants.Constants;
import com.qylm.entity.RoleDetail;
import com.qylm.entity.TreeItem;
import com.qylm.entity.User;

/**
 * menu的渲染类
 * @author
 */
public class TreeRenderer extends Renderer implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6969475927489584561L;
	
	/**
	 * 有绑定方法的item
	 */
	public static List<TreeItem> actionItems;
	
	/**
	 * 做两件事：1.为actionItems设定初始值
	 * 2.为所有节点排序
	 * @param type 1：前台，2：后台
	 * @return
	 */
	private List<TreeItem> getSortedTreeItems(String type){
		List<TreeItem> treeItemList = TreeItemData.treeItemList;
		int size = treeItemList.size();
		TreeItem item;
		ArrayList<TreeItem> list = new ArrayList<TreeItem>();
		for (int i = 0; i < size; i++) {
			item = treeItemList.get(i);
			if(item.getAction() != null){
				list.add(item);
			}
		}
		list.trimToSize();
		actionItems = list;
		int length;
		List<TreeItem> highList = new ArrayList<TreeItem>();
		List<TreeItem> middleList = new ArrayList<TreeItem>();
		List<TreeItem> lowList = new ArrayList<TreeItem>();
		for (int i = 0; i < size; i++) {
			item = treeItemList.get(i);
			length = item.getNodeId().split(Constants.UNDERLINE).length;
			if(length == 1){
				highList.add(item);
			}
			else if(length == 2){
				middleList.add(item);
			} 
			else{
				lowList.add(item);
			}
		}
		Comparator<TreeItem> comparator = new Comparator<TreeItem>(){
			public int compare(TreeItem item1,TreeItem item2){
			return item1.getOrder() - item2.getOrder();}
		};
		Collections.sort(highList, comparator);
		Collections.sort(middleList, comparator);
		Collections.sort(lowList, comparator);
		size = highList.size();
		length = middleList.size();
		TreeItem item2;
		List<TreeItem> children;
		for (int i = 0; i < size; i++) {
			item = highList.get(i);
			children = new ArrayList<TreeItem>();
			for (int j = 0; j < length; j++) {
				item2 = middleList.get(j);
				if(item.getNodeId().equals(item2.getNodeId().split(Constants.UNDERLINE)[0])){
					children.add(item2);
				}
			}
			if(children.size() != 0){
				item.setChildren(children);
			}
		}
		size = middleList.size();
		length = lowList.size();
		for (int i = 0; i < size; i++) {
			item = middleList.get(i);
			children = new ArrayList<TreeItem>();
			for (int j = 0; j < length; j++) {
				item2 = lowList.get(j);
				if(item.getNodeId().split(Constants.UNDERLINE)[1].equals(item2.getNodeId().split(Constants.UNDERLINE)[1])){
					children.add(item2);
				}
			}
			if(children.size() != 0){
				item.setChildren(children);
			}
		}
		// 根据类型取菜单
		int size3 = highList.size() - 1;
		for (int i = size3; i >= 0; i--) {
			TreeItem treeItem = highList.get(i);
			if ("1".equals(type) && TreeItem.NODE_TYPE_1.equals(treeItem.getNodeType())) {
				highList.remove(i);
			} else if ("2".equals(type) && TreeItem.NODE_TYPE_2.equals(treeItem.getNodeType())) {
				highList.remove(i);
			}
		}
		return highList;
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		super.encodeEnd(context, component);
		TreeComponent tree = (TreeComponent) component;
		User user = tree.getUser();
		if(user == null){
			return;
		}
		String type = tree.getType();
		if (type == null) {
			return;
		}
		ResponseWriter rw = context.getResponseWriter();
		List<TreeItem> items = getSortedTreeItems(type);
		TreeItem treeItem = new TreeItem();
		treeItem.setNodeId(tree.getId());
		treeItem.setChildrenStyleClass(tree.getStyleClass());
		renderTree(context, tree, context.getApplication().getExpressionFactory(), context.getELContext(), rw, items, treeItem, user, true);
	}

	/**
	 * 渲染TreeItem
	 */
	private void renderTree(FacesContext context, TreeComponent component, ExpressionFactory factory,
			ELContext eLContext, ResponseWriter rw, List<TreeItem> items, TreeItem treeItem,
			User user, boolean root) throws IOException {
		TreeItem item;
		String action;
		HtmlCommandLink commandLink;
		int length = items.size();
		List<TreeItem> children;
		rw.write("\n");
		rw.startElement("ul", component);
		if (root) {
			rw.writeAttribute("id", treeItem.getNodeId(), "id");
			rw.writeAttribute("style", "display:block;", null);
		} else {
			rw.writeAttribute("id", treeItem.getNodeId() + Constants.CHILDREN, "id");
			if (treeItem.isDisplayChildRen()) {
				rw.writeAttribute("style", "display:block;", null);
			} else {
				rw.writeAttribute("style", "display:none;", null);
			}
		}
		if(treeItem.getChildrenStyleClass() != null){
			rw.writeAttribute("class", treeItem.getChildrenStyleClass(), null);
		}
		rw.write("\n");
		for (int i = 0; i < length; i++) {
			item = items.get(i);
			if (!checkPermission(item, user)) {
				continue;
			}
			rw.startElement("li", component);
			rw.writeAttribute("id", item.getNodeId(), null);
			if(item.getStyleClass() != null){
				rw.writeAttribute("class", item.getStyleClass(), null);
			}
			action = item.getAction();
			if(action == null){
				rw.startElement("a", component);
				if(item.getLabelStyleClass() != null){
					rw.writeAttribute("class", item.getLabelStyleClass(), null);
				}
				rw.writeAttribute("href", "javascript:void(0)", null);
				rw.writeAttribute("onclick", "changeDisplayNode(this,'"+item.getNodeId()+Constants.CHILDREN+"');", null);
				rw.writeText(item.getLabel(), null);
				rw.endElement("a");
				children = item.getChildren();
				if(children != null){
					renderTree(context, component, factory, eLContext, rw, children, item, user, false);
				}
			} else {
//				encodeLink(context, component, item.getTreeItemId());
				commandLink = (HtmlCommandLink) context.getApplication().createComponent(HtmlCommandLink.COMPONENT_TYPE);
				commandLink.setActionExpression(factory.createMethodExpression(eLContext, item.getAction(), String.class, new Class[]{}));
				commandLink.setValue(item.getLabel());
				commandLink.setId(item.getNodeId()+Constants.ACTION);
				commandLink.setImmediate(true);
				commandLink.setTarget(item.getTarget());
				if(item.getActionStyelClass() != null){
					commandLink.setStyleClass(item.getActionStyelClass());
				}
				component.getChildren().add(commandLink);
				commandLink.encodeAll(context);
			}
			rw.endElement("li");
			rw.write("\n");
		}
		rw.endElement("ul");
		rw.write("\n");
	}
	
	/**
	 * 检查用户是否具有权限，系统管理员除外
	 * @param treeItem 菜单组件
	 * @param user 用户对象
	 * @return true OK false NG
	 */
	public static boolean checkPermission(TreeItem treeItem, User user) {
		if (User.USER_LEVEL_1.equals(user.getUserlevel())) {
			return true;
		}
		List<RoleDetail> roleDetailList = user.getRoleDetailList();
		if (roleDetailList != null && !roleDetailList.isEmpty()) {
			for (RoleDetail roleDetail : roleDetailList) {
				if (treeItem.getId().equals(roleDetail.getTreeItem().getId())) {
					return true;
				}
			}
		}
		return false;
	}
	
}
