package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 项目购买记录详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "projectbuy_detail")
@DiscriminatorValue(ProjectBuyDetail.DISCRIMINATOR_PROJECT_BUY_DETAIL)
public class ProjectBuyDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9047896459965132644L;
	
	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_PROJECT_BUY_DETAIL = "projectBuyDetail";

	/**
	 * 查询条件：项目购买记录
	 */
	public static final String PROJECT_BUY = "projectBuy";
	
	/**
	 * 查询条件：项目购买记录.客户答案
	 */
	public static final String PROJECT_BUY_CUSTOM_INFO = "projectBuy.customInfo";
	
	/**
	 * 查询条件：别名.客户答案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 查询条件：别名客户答案.客户名称
	 */
	public static final String CUSTOM_INFO_NAME = "customInfo.name";

	/**
	 * 检索条件：服务管理
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 检索条件：服务管理.服务名称
	 */
	public static final String MARKETING_PROJECT_PROJECT = "marketingProject.project";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 查询条件：剩余次数
	 */
	public static final String SURPLUS_NUMBER = "surplusNumber";
	
	/**
	 * 项目购买记录
	 */
	@ManyToOne(targetEntity = ProjectBuy.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "projectBuyId")
	private ProjectBuy projectBuy;
	
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
	 * @return the projectBuy
	 */
	public ProjectBuy getProjectBuy() {
		return projectBuy;
	}

	/**
	 * @param projectBuy the projectBuy to set
	 */
	public void setProjectBuy(ProjectBuy projectBuy) {
		this.projectBuy = projectBuy;
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
