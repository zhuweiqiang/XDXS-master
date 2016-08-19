package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存卡项操作登陆画面需要的值
 * @author smj
 */
public class CustomLeaguerOperationDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6632785908777164174L;
	
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
	 * 客户卡项
	 */
	private CustomLeaguerDetail customLeaguerDetail;
	
	/**
	 * 客户卡项-要转入的卡
	 */
	private CustomLeaguerDetail deposit;
	
	/**
	 * 退款/转款日期
	 */
	private Date date;

	/**
	 * 退款金额/转款金额
	 */
	private BigDecimal money;
	
	/**
	 * 是否成功
	 * true成功，反之失败
	 */
	private boolean state;
	
	/**
	 * 原因
	 */
	private String remark;
	
	/**
	 * 客户卡项Id
	 */
	private String customLeaguerDetailId;
	
	/**
	 * 客户已有卡项
	 */
	private SelectItem[] customLeaguerDetailItems;
	
	/**
	 * 客户需要转入的卡项Id
	 */
	private String depositId;
	
	/**
	 * 客户需要转入的卡项
	 */
	private SelectItem[] depositItems;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 类型
	 */
	private boolean types;
	
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
	 * @return the customLeaguerDetailId
	 */
	public String getCustomLeaguerDetailId() {
		return customLeaguerDetailId;
	}

	/**
	 * @param customLeaguerDetailId the customLeaguerDetailId to set
	 */
	public void setCustomLeaguerDetailId(String customLeaguerDetailId) {
		this.customLeaguerDetailId = customLeaguerDetailId;
	}

	/**
	 * @return the customLeaguerDetailItems
	 */
	public SelectItem[] getCustomLeaguerDetailItems() {
		return customLeaguerDetailItems;
	}

	/**
	 * @param customLeaguerDetailItems the customLeaguerDetailItems to set
	 */
	public void setCustomLeaguerDetailItems(SelectItem[] customLeaguerDetailItems) {
		this.customLeaguerDetailItems = customLeaguerDetailItems;
	}

	/**
	 * @return the depositId
	 */
	public String getDepositId() {
		return depositId;
	}

	/**
	 * @param depositId the depositId to set
	 */
	public void setDepositId(String depositId) {
		this.depositId = depositId;
	}

	/**
	 * @return the depositItems
	 */
	public SelectItem[] getDepositItems() {
		return depositItems;
	}

	/**
	 * @param depositItems the depositItems to set
	 */
	public void setDepositItems(SelectItem[] depositItems) {
		this.depositItems = depositItems;
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
	 * @return the types
	 */
	public boolean isTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(boolean types) {
		this.types = types;
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
