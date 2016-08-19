package com.qylm.service;

import com.qylm.entity.TreeItem;

public interface TreeItemService extends GenericService<TreeItem, Integer> {

	/**
	 * 删除父菜单时，删除对应的子菜单
	 * @param treeItem
	 */
	public void deleteTreeItem(TreeItem treeItem);
}
