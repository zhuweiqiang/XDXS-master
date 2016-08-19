package com.qylm.dto.baseSet;

import java.io.Serializable;

/**
 * 保存品牌管理画面需要的值
 * @author smj
 */
public class BrandManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8638035745879247901L;
	
	/**
	 * 品牌名称
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
