package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.Recharge;
import com.qylm.entity.User;

/**
 * 保存会员充值记录管理画面需要的值
 * @author smj
 */
public class RechargeCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4869442814039980819L;

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
	 * 充值状态：true有效充值，反之无效充值
	 */
	private boolean state;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 修改传值
	 */
	private Recharge transferRecharge;
	
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
	 * @return the transferRecharge
	 */
	public Recharge getTransferRecharge() {
		return transferRecharge;
	}

	/**
	 * @param transferRecharge the transferRecharge to set
	 */
	public void setTransferRecharge(Recharge transferRecharge) {
		this.transferRecharge = transferRecharge;
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
