package com.qylm.common.utils;

import java.util.Collection;

import javax.faces.model.SelectItem;

import com.qylm.common.SelectItemCreator;
import com.qylm.constants.Constants;

/**
 * 下拉框工具类
 * @author 
 *
 */
public final class SelectItemUtil {

	/**
	 * 根据实体类的集合构建下拉框元素
	 * @param col 实体类集合
	 * @param needUnSelect 是否需要【未选择】
	 * @return 下拉框元素
	 */
	public static SelectItem[] createSelectItems(Collection<? extends SelectItemCreator> col,
			boolean needUnSelect) {
		int size = col.size();
		SelectItem[] items;
		int i = 0;
		if (needUnSelect) {
			items = new SelectItem[size + 1];
			items[0] = Constants.UN_SELECT_ITEM;
			i = 1;
		} else {
			items = new SelectItem[size];
		}
		for (SelectItemCreator creator : col) {
			items[i] = new SelectItem(creator.getValue(), creator.getLabel());
			i++;
		}
		return items;
	}
	
}
