package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qylm.entity.MarketingProject;

/**
 * 用于保存项目列表
 * @author smj
 */
public class ConsumptionRegisterProjectDto implements Serializable, Comparable<ConsumptionRegisterProjectDto> {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8472890037907243412L;
	
	/**
	 * 类型：付款项目
	 */
	public static final Integer TYPE_1 = 1;
	
	/**
	 * 类型：赠送项目
	 */
	public static final Integer TYPE_2 = 2;
	
	/**
	 * 类型：购买的套餐项目
	 */
	public static final Integer TYPE_3 = 3;
	
	/**
	 * 类型：购买的项目
	 */
	public static final Integer TYPE_4 = 4;
	
	/**
	 * 类型：转换的项目
	 */
	public static final Integer TYPE_5 = 5;

	/**
	 * 类型
	 * 1：付款项目
	 * 2：赠送项目
	 * 3：购买的套餐项目
	 * 4：购买的项目
	 */
	private Integer type;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 项目
	 */
	private MarketingProject marketingProject;
	
	/**
	 * 次数
	 */
	private Integer number;
	
	/**
	 * 购买价格
	 */
	private BigDecimal money;
	
	public int compareTo(ConsumptionRegisterProjectDto o) {
		return this.type.compareTo(o.type);
	}

	/**
	 * 用于获取类型名称
	 * @return
	 */
	public String getTypeLabel() {
		int intValue = this.type.intValue();
		String label = "";
		switch (intValue) {
		case 1:
			label = "付款项目";
			break;
		case 2:
			label = "赠送项目";
			break;
		case 3:
			label = "购买的套餐项目";
			break;
		case 4:
			label = "购买的项目";	
			break;
		default:
			label = "转换的项目";	
			break;
		}
		return label;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the marketingProject
	 */
	public MarketingProject getMarketingProject() {
		return marketingProject;
	}

	/**
	 * @param marketingProject the marketingProject to set
	 */
	public void setMarketingProject(MarketingProject marketingProject) {
		this.marketingProject = marketingProject;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
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

}
