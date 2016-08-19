package com.qylm.menu;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.qylm.entity.TreeItem;
import com.qylm.service.TreeItemService;
import com.qylm.spring.application.ApplicationContextHelper;

@ManagedBean
@ViewScoped
public class TreeItemData implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6940269677329438349L;
	
	/**
	 * 菜单集合
	 */
	public static List<TreeItem> treeItemList = getAllTreeItems();
	
	/**
	 * 查询出所有的菜单
	 * @return
	 */
	public static List<TreeItem> getAllTreeItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
		detachedCriteria.addOrder(Order.asc(TreeItem.ORDER));
		detachedCriteria.add(Restrictions.eq(TreeItem.DISPLAY_CHILD_REN, false));
		TreeItemService treeItemService = ApplicationContextHelper.getBean("treeItemService");
		List<TreeItem> treeItems = treeItemService.getByDetachedCriteria(detachedCriteria);
		// 设定样式级别
		for (TreeItem item : treeItems) {
			// 如果是模块（就是父类菜单）
			if (item.getNodeId() == null || isVerification(item, treeItems)) {
				item.setLabelStyleClass("labelStyleClass");
				item.setChildrenStyleClass("ulclass");
			} else {
				item.setActionStyelClass("actionStyelClass");
			}
			item.setStyleClass("liStyleClass");
		}
		return treeItems;
	}
	
	/**
	 * 检验是否存在有下级菜单
	 * @param item 本级菜单
	 * @param list 所有菜单集合
	 * @return true存在 反之不存在
	 */
	private static boolean isVerification(TreeItem item, List<TreeItem> list) {
		if (item.getNodeId() != null) {
			for (TreeItem treeItem : list) {
				// 拥有菜单命名规则，所以只需要这样的验证即可
				if ((treeItem.getNodeId().indexOf(item.getNodeId()) != -1) && !item.getId().equals(treeItem.getId())) {
					return true;
				}
			}
		}
		return false;
	}

}
