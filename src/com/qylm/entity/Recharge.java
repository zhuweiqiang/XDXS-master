package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 会员充值记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "recharge")
public class Recharge extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7036429519560270431L;
	
	/**
	 * 查询条件：客户档案
	 */
	public static final String CUSTOMINFO = "customInfo";
	
	/**
	 * 查询条件：客户档案.姓名
	 */
	public static final String CUSTOMINFO_NAME = "customInfo.name";
	
	/**
	 * 查询条件：客户档案.卡号
	 */
	public static final String CUSTOMINFO_LEAGUER_NUMBER = "customInfo.leaguerNumber";
	
	/**
	 * 查询条件：充值时间
	 */
	public static final String RECHARGE_DATE = "rechargeDate";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 充值时间
	 */
	private Date rechargeDate;
	
	/**
	 * 充值金额
	 */
	private BigDecimal money;
	
	/**
	 * 充值状态：true有效充值，反之无效充值
	 */
	private boolean state;

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
	 * @return the rechargeDate
	 */
	public Date getRechargeDate() {
		return rechargeDate;
	}

	/**
	 * @param rechargeDate the rechargeDate to set
	 */
	public void setRechargeDate(Date rechargeDate) {
		this.rechargeDate = rechargeDate;
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

}
