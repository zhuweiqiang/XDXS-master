package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.qylm.common.SelectItemCreator;

/**
 * 会员持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "leaguer")
public class Leaguer extends BaseEntity implements SelectItemCreator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 231965853753352762L;
	
	/**
	 * 查询条件：卡项级别
	 */
	public static final String LEVEL = "level";

	/**
	 * 卡项级别
	 */
	private String level;
	
	/**
	 * 卡项价格
	 */
	private BigDecimal money;
	
	/**
	 * 卡项折扣（百分比）
	 */
	private BigDecimal rebate;
	
	public String getValue() {
		return id.toString();
	}

	public String getLabel() {
		return level;
	}
	
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
	 * @return the money
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
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

}
