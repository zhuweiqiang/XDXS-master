package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.ProjectBuy;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.entity.User;

/**
 * 保存项目购买管理画面需要的值
 * @author smj
 */
public class ProjectBuyCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8776227401663413012L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 购买时间
	 */
	private Date date;
	
	/**
	 * 项目费用
	 */
	private BigDecimal money;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	private PersonnelInfo adviser;
	
	/**
	 * 状态
	 */
	private boolean state;
	
	/**
	 * 余额支付
	 */
	private BigDecimal balance;
	
	/**
	 * 付款后还需要支付金额
	 */
	private BigDecimal surplusMoney;
	
	/**
	 * 计算出已支付的金额
	 */
	private BigDecimal sumMoney;
	
	/**
	 * 现金
	 */
	private BigDecimal readyMoney;
	
	/**
	 * 客户的卡项列表
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;

	/**
	 * 项目购买详细列表
	 */
	private List<ProjectBuyDetail> projectBuyDetailList;
	
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
	private ProjectBuy transferProjectBuy;
	
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
	 * @return the surplusMoney
	 */
	public BigDecimal getSurplusMoney() {
		return surplusMoney;
	}

	/**
	 * @param surplusMoney the surplusMoney to set
	 */
	public void setSurplusMoney(BigDecimal surplusMoney) {
		this.surplusMoney = surplusMoney;
	}

	/**
	 * @return the sumMoney
	 */
	public BigDecimal getSumMoney() {
		return sumMoney;
	}

	/**
	 * @param sumMoney the sumMoney to set
	 */
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
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
	 * @return the customLeaguerDetailList
	 */
	public List<CustomLeaguerDetail> getCustomLeaguerDetailList() {
		return customLeaguerDetailList;
	}

	/**
	 * @param customLeaguerDetailList the customLeaguerDetailList to set
	 */
	public void setCustomLeaguerDetailList(
			List<CustomLeaguerDetail> customLeaguerDetailList) {
		this.customLeaguerDetailList = customLeaguerDetailList;
	}

	/**
	 * @return the projectBuyDetailList
	 */
	public List<ProjectBuyDetail> getProjectBuyDetailList() {
		return projectBuyDetailList;
	}

	/**
	 * @param projectBuyDetailList the projectBuyDetailList to set
	 */
	public void setProjectBuyDetailList(List<ProjectBuyDetail> projectBuyDetailList) {
		this.projectBuyDetailList = projectBuyDetailList;
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
	 * @return the transferProjectBuy
	 */
	public ProjectBuy getTransferProjectBuy() {
		return transferProjectBuy;
	}

	/**
	 * @param transferProjectBuy the transferProjectBuy to set
	 */
	public void setTransferProjectBuy(ProjectBuy transferProjectBuy) {
		this.transferProjectBuy = transferProjectBuy;
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
