package com.qylm.dto.baseSet;

import java.io.Serializable;

/**
 * 保存卡项管理画面需要的值
 * @author smj
 */
public class LeaguerManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7181861821991690418L;
	
	/**
	 * 卡项级别
	 */
	private String level;

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
}
