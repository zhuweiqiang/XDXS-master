package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
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
@Table(uniqueConstraints = {}, name = "temporaryactivity_detail")
@DiscriminatorValue(TemporaryActivityDetail.DISCRIMINATOR_TEMPORARY_ACTIVITY_DETAIL)
public class TemporaryActivityDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9078902375806791940L;
	
	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_TEMPORARY_ACTIVITY_DETAIL = "temporaryActivityDetail";
	
	/**
	 * 检索条件：活动套餐
	 */
	public static final String TEMPORARY_ACTIVITY = "temporaryActivity";
	
	/**
	 * 检索条件：服务管理
	 */
	public static final String MARKETING_PROJECT = "marketingProject";

	/**
	 * 活动套餐
	 */
	@ManyToOne(targetEntity = TemporaryActivity.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "temporaryActivityId")
	private TemporaryActivity temporaryActivity;
	
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
	 * 费用
	 */
	private BigDecimal money;

	/**
	 * @return the temporaryActivity
	 */
	public TemporaryActivity getTemporaryActivity() {
		return temporaryActivity;
	}

	/**
	 * @param temporaryActivity the temporaryActivity to set
	 */
	public void setTemporaryActivity(TemporaryActivity temporaryActivity) {
		this.temporaryActivity = temporaryActivity;
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
