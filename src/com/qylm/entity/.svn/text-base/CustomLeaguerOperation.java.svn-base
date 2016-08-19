package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 客户卡项操作持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "customleagueroperation")
public class CustomLeaguerOperation extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3167242358089716565L;

	/**
	 * 搜索条件：客户档案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 搜索条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 搜索条件：顾问
	 */
	public static final String ADVISER = "adviser";

	/**
	 * 搜索条件：客户卡项
	 */
	public static final String LEAGUER = "customLeaguerDetail";
	
	/**
	 * 搜索条件： 客户卡项-要转入的卡
	 */
	public static final String DEPOSIT = "deposit";
	
	/**
	 * 搜索条件： 类型
	 */
	public static final String TYPE = "type";
	
	/**
	 * 搜索条件： 退卡
	 */
	public static final String TYPE_1 = "1";
	
	/**
	 * 搜索条件： 转卡
	 */
	public static final String TYPE_2 = "2";
	
	/**
	 * 搜索条件： 退现金
	 */
	public static final String TYPE_3 = "3";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;

	/**
	 * 客户卡项-要转的卡/要退款的卡
	 */
	@ManyToOne(targetEntity = CustomLeaguerDetail.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customLeaguerDetailId")
	private CustomLeaguerDetail customLeaguerDetail;
	
	/**
	 * 客户卡项-要转入的卡
	 */
	@ManyToOne(targetEntity = CustomLeaguerDetail.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "depositId")
	private CustomLeaguerDetail deposit;
	
	/**
	 * 人事信息-美容师
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "personnelInfoId")
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "adviserId")
	private PersonnelInfo adviser;
	
	/**
	 * 退款/转款日期
	 */
	private Date date;

	/**
	 * 退款金额/转款金额
	 */
	private BigDecimal money;
	
	/**
	 * 有效情况
	 */
	private boolean state;
	
	/**
	 * 类型
	 * 1：退卡
	 * 2：转卡
	 * 3：退现金
	 */
	private String type;
	
	/**
	 * 原因
	 */
	private String remark;

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
	 * @return the customLeaguerDetail
	 */
	public CustomLeaguerDetail getCustomLeaguerDetail() {
		return customLeaguerDetail;
	}

	/**
	 * @param customLeaguerDetail the customLeaguerDetail to set
	 */
	public void setCustomLeaguerDetail(CustomLeaguerDetail customLeaguerDetail) {
		this.customLeaguerDetail = customLeaguerDetail;
	}

	/**
	 * @return the deposit
	 */
	public CustomLeaguerDetail getDeposit() {
		return deposit;
	}

	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(CustomLeaguerDetail deposit) {
		this.deposit = deposit;
	}

	/**
	 * @return the personnelInfo
	 */
	public PersonnelInfo getPersonnelInfo() {
		return personnelInfo;
	}

	/**
	 * @param personnelInfo the personnelInfo to set
	 */
	public void setPersonnelInfo(PersonnelInfo personnelInfo) {
		this.personnelInfo = personnelInfo;
	}

	/**
	 * @return the adviser
	 */
	public PersonnelInfo getAdviser() {
		return adviser;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setAdviser(PersonnelInfo adviser) {
		this.adviser = adviser;
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
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
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
	
}
