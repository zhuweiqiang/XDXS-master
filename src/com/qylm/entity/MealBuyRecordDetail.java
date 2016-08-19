package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 活动套餐详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "mealbuyrecord_detail")
public class MealBuyRecordDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -952285676501616972L;

	/**
	 * 检索条件：活动套餐
	 */
	public static final String MEAL_BUY_RECORD = "mealBuyRecord";
	
	/**
	 * 查询条件：活动套餐.客户档案
	 */
	public static final String MEAL_BUY_RECORD_CUSTOMINFO = "mealBuyRecord.customInfo";
	
	/**
	 * 查询条件：别名.客户档案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 检索条件：服务管理
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 查询条件：剩余次数
	 */
	public static final String SURPLUS_NUMBER = "surplusNumber";

	/**
	 * 套餐购买记录
	 */
	@ManyToOne(targetEntity = MealBuyRecord.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "mealBuyRecordId")
	private MealBuyRecord mealBuyRecord;
	
	/**
	 * 服务管理
	 */
	@ManyToOne(targetEntity = MarketingProject.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 次数
	 */
	private Integer number;
	
	/**
	 * 剩余次数
	 */
	private Integer surplusNumber;
	
	/**
	 * 费用
	 */
	private BigDecimal money;

	/**
	 * @return the mealBuyRecord
	 */
	public MealBuyRecord getMealBuyRecord() {
		return mealBuyRecord;
	}

	/**
	 * @param mealBuyRecord the mealBuyRecord to set
	 */
	public void setMealBuyRecord(MealBuyRecord mealBuyRecord) {
		this.mealBuyRecord = mealBuyRecord;
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
	 * @return the surplusNumber
	 */
	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	/**
	 * @param surplusNumber the surplusNumber to set
	 */
	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
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
