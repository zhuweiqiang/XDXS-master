package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 个人消费登记持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "consumptionregister")
public class ConsumptionRegister extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8531931523638671917L;

	/**
	 * 查询条件：客户档案
	 */
	public static final String CUSTOMINFO = "customInfo";

	/**
	 * 查询条件：客户档案.客户姓名
	 */
	public static final String CUSTOMINFO_NAME = "customInfo.name";
	
	/**
	 * 查询条件：客户档案.卡项号
	 */
	public static final String CUSTOMINFO_LEAGUER_NUMBER = "customInfo.leaguerNumber";
	
	/**
	 * 查询条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 查询条件：顾问
	 */
	public static final String ADVISER = "adviser";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 查询条件：状态
	 */
	public static final String STATE = "state";
	
	/**
	 * 查询条件：消费类型
	 */
	public static final String TYPE = "type";
	
	/**
	 * 查询条件：消费类型:购卡
	 */
	public static final String TYPE_1 = "1";
	
	/**
	 * 查询条件：消费类型:购买套餐
	 */
	public static final String TYPE_2 = "2";
	
	/**
	 * 查询条件：消费类型:购买疗程
	 */
	public static final String TYPE_3 = "3";
	
	/**
	 * 查询条件：消费类型:购买产品
	 */
	public static final String TYPE_4 = "4";
	
	/**
	 * 查询条件：消费类型:服务消费
	 */
	public static final String TYPE_5 = "5";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 美容师
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
	 * 登记日期
	 */
	private Date date;
	
	/**
	 * 已付款
	 */
	private BigDecimal money;
	
	/**
	 * 实耗金额
	 */
	private BigDecimal realityMoney;
	
	/**
	 * 欠款
	 */
	private BigDecimal debt;
	
	/**
	 * 此次余额
	 */
	private BigDecimal balance;
	
	/**
	 * 还款
	 */
	private BigDecimal repayment;
	
	/**
	 * true有效，反之无效
	 */
	private boolean state;
	
	/**
	 * 消费类型
	 * 1：购卡
	 * 2：购买套餐
	 * 3：购买疗程
	 * 4：购买产品
	 * 5：服务消费
	 */
	private String type;
	
	/**
	 * 消费折扣
	 */
	private BigDecimal rebate;
	
	/**
	 *个人消费登记详细列表
	 */
	@Transient
	private List<ConsumptionRegisterDetail> consumptionRegisterDetailList;
	
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
	 * @return the realityMoney
	 */
	public BigDecimal getRealityMoney() {
		return realityMoney;
	}

	/**
	 * @param realityMoney the realityMoney to set
	 */
	public void setRealityMoney(BigDecimal realityMoney) {
		this.realityMoney = realityMoney;
	}

	/**
	 * @return the debt
	 */
	public BigDecimal getDebt() {
		return debt;
	}

	/**
	 * @param debt the debt to set
	 */
	public void setDebt(BigDecimal debt) {
		this.debt = debt;
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
	 * @return the repayment
	 */
	public BigDecimal getRepayment() {
		return repayment;
	}

	/**
	 * @param repayment the repayment to set
	 */
	public void setRepayment(BigDecimal repayment) {
		this.repayment = repayment;
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
	 * @return the consumptionRegisterDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList() {
		return consumptionRegisterDetailList;
	}

	/**
	 * @param consumptionRegisterDetailList the consumptionRegisterDetailList to set
	 */
	public void setConsumptionRegisterDetailList(List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		this.consumptionRegisterDetailList = consumptionRegisterDetailList;
	}
	
}
