package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存项目操作记录管理画面需要的值
 * @author smj
 */
public class ProjectOperationCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 969387728805271491L;

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
	 * 有效状态
	 * true:有效，反之无效
	 */
	private boolean state;

	/**
	 * 项目购买详细列表
	 */
	private List<ConsumptionRegisterDetail> consumptionRegisterDetailList;
	
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
	private ConsumptionRegister transferConsumptionRegister;
	
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
	 * @return the consumptionRegisterDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList() {
		return consumptionRegisterDetailList;
	}

	/**
	 * @param consumptionRegisterDetailList the consumptionRegisterDetailList to set
	 */
	public void setConsumptionRegisterDetailList(
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		this.consumptionRegisterDetailList = consumptionRegisterDetailList;
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
	 * @return the transferConsumptionRegister
	 */
	public ConsumptionRegister getTransferConsumptionRegister() {
		return transferConsumptionRegister;
	}

	/**
	 * @param transferConsumptionRegister the transferConsumptionRegister to set
	 */
	public void setTransferConsumptionRegister(
			ConsumptionRegister transferConsumptionRegister) {
		this.transferConsumptionRegister = transferConsumptionRegister;
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
