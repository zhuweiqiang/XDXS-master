package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.qylm.entity.CustomInfo;
import com.qylm.entity.User;

/**
 * 保存会员充值记录管理画面需要的值
 * @author smj
 */
public class RechargeViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2158904141058793468L;

	/**
	 * 客户档案
	 */
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
	 * 创建事件
	 */
	private User creater;

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
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}

	/**
	 * @param creater the creater to set
	 */
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
}
