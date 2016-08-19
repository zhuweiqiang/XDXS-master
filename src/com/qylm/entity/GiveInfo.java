package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.qylm.common.SelectItemCreator;

/**
 * 体验卡持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "giveinfo")
public class GiveInfo extends BaseEntity implements SelectItemCreator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5411541411447147200L;

	/**
	 * 查询条件：标题
	 */
	public static final String TITLE = "title";
	
	/**
	 * 查询条件：类型
	 */
	public static final String TYPE = "type";
	
	/**
	 * 查询条件：体验卡
	 */
	public static final String TYPE_1 = "1";
	
	/**
	 * 查询条件：现金卷
	 */
	public static final String TYPE_2 = "2";
	
	/**
	 * 查询条件：身体卷
	 */
	public static final String TYPE_3 = "3";

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 价值
	 */
	private BigDecimal money;
	
	/**
	 * 消费折扣
	 */
	private BigDecimal rebate;
	
	/**
	 * 类型
	 * 1：体验卡
	 * 2：现金卷
	 * 3：身体卷
	 */
	private String type;
	
	public String getValue() {
		return id.toString();
	}

	public String getLabel() {
		return title;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
