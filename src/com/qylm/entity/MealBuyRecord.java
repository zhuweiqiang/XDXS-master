package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 套餐购买记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "mealbuyrecord")
public class MealBuyRecord extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1573865761287988871L;

	/**
	 * 查询条件：客户档案
	 */
	public static final String CUSTOMINFO = "customInfo";

	/**
	 * 查询条件：客户档案.客户姓名
	 */
	public static final String CUSTOMINFO_NAME = "customInfo.name";
	
	/**
	 * 查询条件：客户档案.卡项号
	 */
	public static final String CUSTOMINFO_LEAGUER_NUMBER = "customInfo.leaguerNumber";
	
	/**
	 * 查询条件：活动套餐
	 */
	public static final String TEMPORARY_ACTIVITY = "temporaryActivity";
	
	/**
	 * 查询条件：活动套餐.名称
	 */
	public static final String TEMPORARY_ACTIVITY_NAME = "temporaryActivity.name";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 查询条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 查询条件：人事信息-顾问
	 */
	public static final String ADVISER = "adviser";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 购买时间
	 */
	private Date date;
	
	/**
	 * 活动套餐
	 */
	@ManyToOne(targetEntity = TemporaryActivity.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "temporaryActivityId")
	private TemporaryActivity temporaryActivity;
	
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
	 * 套餐次数
	 */
	private Integer number;
	
	/**
	 * 实耗金额
	 */
	private BigDecimal realityMoney;
	
	/**
	 * 状态
	 */
	private boolean state;

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
	 * @return the temporaryActivity
	 */
	public TemporaryActivity getTemporaryActivity() {
		return temporaryActivity;
	}

	/**
	 * @param temporaryActivity the temporaryActivity to set
	 */
	public void setTemporaryActivity(TemporaryActivity temporaryActivity) {
		this.temporaryActivity = temporaryActivity;
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
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
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
	
}
