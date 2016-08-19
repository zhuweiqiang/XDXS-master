package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.ConsumptionRegisterProjectDto;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.FeedbackRecord;
import com.qylm.entity.User;

/**
 * 保存消费登记管理画面需要的值
 * @author smj
 */
public class ConsumeDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1298308114863492720L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 登记日期
	 */
	private Date date;
	
	/**
	 * 年度总消费
	 */
	private BigDecimal yearSumMoney;
	
	/**
	 * 当前客户下的卡项
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
	/**
	 * 已拥有的项目
	 */
	private List<ConsumptionRegisterProjectDto> consumptionRegisterProjectDtoList;
	
	/**
	 * 客户反馈记录
	 */
	private List<FeedbackRecord> feedbackRecordList;
	
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
	 * @return the yearSumMoney
	 */
	public BigDecimal getYearSumMoney() {
		return yearSumMoney;
	}

	/**
	 * @param yearSumMoney the yearSumMoney to set
	 */
	public void setYearSumMoney(BigDecimal yearSumMoney) {
		this.yearSumMoney = yearSumMoney;
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
	 * @return the consumptionRegisterProjectDtoList
	 */
	public List<ConsumptionRegisterProjectDto> getConsumptionRegisterProjectDtoList() {
		return consumptionRegisterProjectDtoList;
	}

	/**
	 * @param consumptionRegisterProjectDtoList the consumptionRegisterProjectDtoList to set
	 */
	public void setConsumptionRegisterProjectDtoList(
			List<ConsumptionRegisterProjectDto> consumptionRegisterProjectDtoList) {
		this.consumptionRegisterProjectDtoList = consumptionRegisterProjectDtoList;
	}

	/**
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}

	/**
	 * @return the feedbackRecordList
	 */
	public List<FeedbackRecord> getFeedbackRecordList() {
		return feedbackRecordList;
	}

	/**
	 * @param feedbackRecordList the feedbackRecordList to set
	 */
	public void setFeedbackRecordList(List<FeedbackRecord> feedbackRecordList) {
		this.feedbackRecordList = feedbackRecordList;
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
