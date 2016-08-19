package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 产品销售记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "marketingrecord")
public class MarketingRecord extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -684186243040730550L;

	/**
	 * 查询条件：客户档案
	 */
	public static final String CUSTOMINFO = "customInfo";

	/**
	 * 查询条件：客户档案.客户姓名
	 */
	public static final String CUSTOMINFO_NAME = "customInfo.name";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 查询条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 查询条件：顾问
	 */
	public static final String ADVISER = "adviser";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 美容师
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "personnelInfoId")
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "adviserId")
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
	 * 购买项目详细列表
	 */
	@Transient
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
	public void setMarketingRecordDetailList(List<MarketingRecordDetail> marketingRecordDetailList) {
		this.marketingRecordDetailList = marketingRecordDetailList;
	}

}
