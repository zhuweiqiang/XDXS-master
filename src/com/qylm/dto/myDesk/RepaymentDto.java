package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存还款登陆画面需要的值
 * @author smj
 */
public class RepaymentDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8182512905057293781L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	private PersonnelInfo adviser;
	
	/**
	 * 登记日期
	 */
	private Date date;
	
	/**
	 * 还款金额
	 */
	private BigDecimal money;
	
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
	 * 余额支付
	 */
	private BigDecimal balance;
	
	/**
	 * 余额付款后的剩余金额
	 */
	private BigDecimal balanceSurplus;
	
	/**
	 * 现金
	 */
	private BigDecimal readyMoney;
	
	/**
	 * 现金付款后的剩余金额
	 */
	private BigDecimal readyMoneySurplus;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

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
	 * @return the balanceSurplus
	 */
	public BigDecimal getBalanceSurplus() {
		return balanceSurplus;
	}

	/**
	 * @param balanceSurplus the balanceSurplus to set
	 */
	public void setBalanceSurplus(BigDecimal balanceSurplus) {
		this.balanceSurplus = balanceSurplus;
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
	 * @return the readyMoneySurplus
	 */
	public BigDecimal getReadyMoneySurplus() {
		return readyMoneySurplus;
	}

	/**
	 * @param readyMoneySurplus the readyMoneySurplus to set
	 */
	public void setReadyMoneySurplus(BigDecimal readyMoneySurplus) {
		this.readyMoneySurplus = readyMoneySurplus;
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

	/**
	 * @return the belongingUser
	 */
	public User getBelongingUser() {
		return belongingUser;
	}

	/**
	 * @param belongingUser the belongingUser to set
	 */
	public void setBelongingUser(User belongingUser) {
		this.belongingUser = belongingUser;
	}

	/**
	 * @return the returner
	 */
	public Returner<?, ?, ?> getReturner() {
		return returner;
	}

	/**
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, ?> returner) {
		this.returner = returner;
	}

}
