package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qylm.entity.User;

/**
 * 保存卡项管理画面需要的值
 * @author smj
 */
public class LeaguerViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7953149315220060288L;

	/**
	 * 卡项级别
	 */
	private String level;
	
	/**
	 * 卡项折扣（百分比）
	 */
	private BigDecimal rebate;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;

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

	/**
	 * @return the rebate
	 */
	public BigDecimal getRebate() {
		return rebate;
	}

	/**
	 * @param rebate the rebate to set
	 */
	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
	}

	/**
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}

	/**
	 * @param creater the creater to set
	 */
	public void setCreater(User creater) {
		this.creater = creater;
	}

	/**
	 * @return the belongingUser
	 */
	public User getBelongingUser() {
		return belongingUser;
	}

	/**
	 * @param belongingUser the belongingUser to set
	 */
	public void setBelongingUser(User belongingUser) {
		this.belongingUser = belongingUser;
	}

}
