package com.qylm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.TreeItemDao;
import com.qylm.entity.TreeItem;

@Service("treeItemService")
public class TreeItemServiceImpl extends GenericServiceImpl<TreeItem, Integer> implements TreeItemService {

	@Autowired
	protected TreeItemServiceImpl(TreeItemDao treeItemDao) {
		super(treeItemDao);
	}

	public void deleteTreeItem(TreeItem treeItem) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
		detachedCriteria.add(Restrictions.like(TreeItem.NODE_ID, treeItem.getNodeId() + "_", MatchMode.START));
		List<TreeItem> treeItemList = super.getByDetachedCriteria(detachedCriteria);
		treeItemList.add(treeItem);
		super.deleteEntityAll(treeItemList);
	}

}
