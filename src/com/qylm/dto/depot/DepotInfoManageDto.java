package com.qylm.dto.depot;

import java.io.Serializable;

/**
 * 保存仓库信息管理画面需要的值
 * @author smj
 */
public class DepotInfoManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5293224168473113465L;
	
	/**
	 * 仓库名
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
