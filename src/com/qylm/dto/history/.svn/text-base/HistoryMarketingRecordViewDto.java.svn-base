package com.qylm.dto.history;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.entity.CustomInfo;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.entity.PersonnelInfo;

/**
 * 保存客户产品记录记录管理画面需要的值
 * @author smj
 */
public class HistoryMarketingRecordViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6006629790446311755L;

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
	 * 购买日期
	 */
	private Date date;
	
	/**
	 * 产品费用
	 */
	private BigDecimal money;
	
	/**
	 * 状态：true生效扣除库存，反之无效
	 */
	private boolean state;
	
	/**
	 * 客户产品记录记录详细列表
	 */
	private List<MarketingRecordDetail> marketingRecordDetailList;

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
	
}
