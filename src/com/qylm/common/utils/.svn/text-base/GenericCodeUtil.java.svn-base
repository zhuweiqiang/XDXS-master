package com.qylm.common.utils;

import javax.faces.model.SelectItem;

/**
 * 
 * @author ZhuHong
 * 
 */
public final class GenericCodeUtil {

	/**
	 * 以【值】取得对应的【标题】
	 * 
	 * @param items
	 *            选择项目数组
	 * @param value
	 *            值
	 * @return 【值】对应的【标题】
	 */
	public static String findLabel(SelectItem[] items, String value) {
		for (SelectItem item : items) {
			if (StringUtil.equalsIgnoreCase((CharSequence) item.getValue(),
					value)) {
				return item.getLabel();
			}
		}
		return null;
	}

	/**
	 * 以【标题】取得对应的【值】
	 * 
	 * @param items
	 *            选择项目数组
	 * @param label
	 *            标题
	 * @return 【标题】对应的【值】
	 */
	public static Object findValue(SelectItem[] items, String label) {
		for (SelectItem item : items) {
			if (StringUtil.equalsIgnoreCase((CharSequence) item.getLabel(),
					label)) {
				return item.getValue();
			}
		}
		return null;
	}

}
