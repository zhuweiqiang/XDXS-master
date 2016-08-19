package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 客户还款记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "repaymentrecord")
public class RepaymentRecord extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1468510676915645859L;

	/**
	 * 搜索条件：客户档案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 搜索条件：客户档案.客户姓名
	 */
	public static final String CUSTOM_INFO_NAME = "customInfo.name";
	
	/**
	 * 搜索条件：还款日期
	 */
	public static final String DATE = "date";
	
	/**
	 * 搜索条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 搜索条件：顾问
	 */
	public static final String ADVISER = "adviser";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
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
	 * 还款日期
	 */
	private Date date;
	
	/**
	 * 还款金额
	 */
	private BigDecimal money;
	
	/**
	 * 余额支付
	 */
	private BigDecimal balance;
	
	/**
	 * 现金
	 */
	private BigDecimal readyMoney;
	
	/**
	 * 是否成功
	 * true成功，反之失败
	 */
	private boolean state;
	
	/**
	 * 备注
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
	 * @return the readyMoney
	 */
	public BigDecimal getReadyMoney() {
		return readyMoney;
	}

	/**
	 * @param readyMoney the readyMoney to set
	 */
	public void setReadyMoney(BigDecimal readyMoney) {
		this.readyMoney = readyMoney;
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
