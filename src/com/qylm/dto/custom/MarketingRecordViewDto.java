package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.entity.CustomInfo;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存产品销售记录管理画面需要的值
 * @author smj
 */
public class MarketingRecordViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3908406107857565814L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 购买日期
	 */
	private Date date;
	
	/**
	 * 产品费用
	 */
	private BigDecimal money;
	
	/**
	 * 产品销售记录详细列表
	 */
	private List<MarketingRecordDetail> marketingRecordDetailList;
	
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
	 * @return the marketingRecordDetailList
	 */
	public List<MarketingRecordDetail> getMarketingRecordDetailList() {
		return marketingRecordDetailList;
	}

	/**
	 * @param marketingRecordDetailList the marketingRecordDetailList to set
	 */
	public void setMarketingRecordDetailList(
			List<MarketingRecordDetail> marketingRecordDetailList) {
		this.marketingRecordDetailList = marketingRecordDetailList;
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
