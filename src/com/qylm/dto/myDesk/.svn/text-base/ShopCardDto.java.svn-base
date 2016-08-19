package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存项目购买管理画面需要的值
 * @author smj
 */
public class ShopCardDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 865743302441318961L;
	
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
	 * 欠款
	 */
	private BigDecimal arrearage;
	
	/**
	 * 实耗金额
	 */
	private BigDecimal realityMoney;
	
	/**
	 * 有效状态
	 * true:有效，反之无效
	 */
	private boolean state;
	
	/**
	 * 购置卡项的id
	 */
	private String[] leaguerId;
	
	/**
	 * 购置的卡项
	 */
	private SelectItem[] leaguerItems;
	
	/**
	 * 购置的体验卡id
	 */
	private String[] experienceCardId;
	
	/**
	 * 购置的体验卡
	 */
	private SelectItem[] experienceCardItem;
	
	/**
	 * 选择卡项后计算出的总金额
	 */
	private BigDecimal sumLeaguerMoney;

	/**
	 * 客户的卡项列表
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
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
	 * @return the arrearage
	 */
	public BigDecimal getArrearage() {
		return arrearage;
	}

	/**
	 * @param arrearage the arrearage to set
	 */
	public void setArrearage(BigDecimal arrearage) {
		this.arrearage = arrearage;
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
	 * @return the leaguerId
	 */
	public String[] getLeaguerId() {
		return leaguerId;
	}

	/**
	 * @param leaguerId the leaguerId to set
	 */
	public void setLeaguerId(String[] leaguerId) {
		this.leaguerId = leaguerId;
	}

	/**
	 * @return the leaguerItems
	 */
	public SelectItem[] getLeaguerItems() {
		return leaguerItems;
	}

	/**
	 * @param leaguerItems the leaguerItems to set
	 */
	public void setLeaguerItems(SelectItem[] leaguerItems) {
		this.leaguerItems = leaguerItems;
	}

	/**
	 * @return the experienceCardId
	 */
	public String[] getExperienceCardId() {
		return experienceCardId;
	}

	/**
	 * @param experienceCardId the experienceCardId to set
	 */
	public void setExperienceCardId(String[] experienceCardId) {
		this.experienceCardId = experienceCardId;
	}

	/**
	 * @return the experienceCardItem
	 */
	public SelectItem[] getExperienceCardItem() {
		return experienceCardItem;
	}

	/**
	 * @param experienceCardItem the experienceCardItem to set
	 */
	public void setExperienceCardItem(SelectItem[] experienceCardItem) {
		this.experienceCardItem = experienceCardItem;
	}

	/**
	 * @return the sumLeaguerMoney
	 */
	public BigDecimal getSumLeaguerMoney() {
		return sumLeaguerMoney;
	}

	/**
	 * @param sumLeaguerMoney the sumLeaguerMoney to set
	 */
	public void setSumLeaguerMoney(BigDecimal sumLeaguerMoney) {
		this.sumLeaguerMoney = sumLeaguerMoney;
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
