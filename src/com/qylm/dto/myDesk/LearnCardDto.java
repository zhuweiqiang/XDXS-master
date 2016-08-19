package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.util.Date;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;

/**
 * 保存消费登记管理画面需要的值
 * @author smj
 */
public class LearnCardDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8560690012662968267L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 登记日期（开始）
	 */
	private Date startDate;
	
	/**
	 * 登记日期（结束）
	 */
	private Date endDate;
	
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
