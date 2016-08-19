package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 赠送项目记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "largessrecord")
@DiscriminatorValue(LargessRecord.DISCRIMINATOR_LARGESS_RECORD)
public class LargessRecord extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1125775165559288558L;
	
	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_LARGESS_RECORD = "largessRecord";
	
	/**
	 * 搜索条件：客户档案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 搜索条件：客户档案.客户姓名
	 */
	public static final String CUSTOM_INFO_NAME = "customInfo.name";
	
	/**
	 * 搜索条件：客户档案.卡项号
	 */
	public static final String CUSTOM_INFO_LEAGUER_NUMBER = "customInfo.leaguerNumber";
	
	/**
	 * 搜索条件：赠送时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 搜索条件：营业项目
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 搜索条件：顾问
	 */
	public static final String PERSONNEL_INFO_1 = "personnelInfo1";
	
	/**
	 * 搜索条件：美容师
	 */
	public static final String PERSONNEL_INFO_2 = "personnelInfo2";
	
	/**
	 * 查询条件：剩余次数
	 */
	public static final String SURPLUS_NUMBER = "surplusNumber";

	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 赠送时间
	 */
	private Date date;
	
	/**
	 * 营业项目
	 */
	@ManyToOne(targetEntity = MarketingProject.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 使用明细
	 */
	private String remark;
	
	/**
	 * 赠送次数
	 */
	private Integer number;
	
	/**
	 * 金额
	 */
	private BigDecimal money;
	
	/**
	 * 剩余次数
	 */
	private Integer surplusNumber;
	
	/**
	 * 余额
	 */
	private BigDecimal balance;
	
	/**
	 * 人事信息-美容师
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "personnelInfo1Id")
	private PersonnelInfo personnelInfo1;
	
	/**
	 * 人事信息-顾问
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "personnelInfo2Id")
	private PersonnelInfo personnelInfo2;

	/**
	 * @return the customInfo
	 */
	public CustomInfo getCustomInfo() {
		return customInfo;
	}

	/**
	 * @param customInfo the customInfo to set
	 */
	public void setCustomInfo(CustomInfo customInfo) {
		this.customInfo = customInfo;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return the personnelInfo1
	 */
	public PersonnelInfo getPersonnelInfo1() {
		return personnelInfo1;
	}

	/**
	 * @param personnelInfo1 the personnelInfo1 to set
	 */
	public void setPersonnelInfo1(PersonnelInfo personnelInfo1) {
		this.personnelInfo1 = personnelInfo1;
	}

	/**
	 * @return the personnelInfo2
	 */
	public PersonnelInfo getPersonnelInfo2() {
		return personnelInfo2;
	}

	/**
	 * @param personnelInfo2 the personnelInfo2 to set
	 */
	public void setPersonnelInfo2(PersonnelInfo personnelInfo2) {
		this.personnelInfo2 = personnelInfo2;
	}
	
}
