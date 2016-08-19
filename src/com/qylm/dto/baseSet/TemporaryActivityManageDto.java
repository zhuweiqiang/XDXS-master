package com.qylm.dto.baseSet;

import java.io.Serializable;

/**
 * 保存活动套餐管理画面需要的值
 * @author smj
 */
public class TemporaryActivityManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5401008288413305306L;
	
	/**
	 * 活动名称
	 */
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
