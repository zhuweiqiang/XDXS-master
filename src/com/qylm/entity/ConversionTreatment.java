package com.qylm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 疗程转换记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "conversiontreatment")
public class ConversionTreatment extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5974454093532831531L;

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
	 * 查询条件：转换服务
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 查询条件：剩余次数
	 */
	public static final String SURPLUS_NUMBER = "surplusNumber";
	
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
	 * 转换日期
	 */
	private Date date;

	/**
	 * 状态：true生效扣除库存，反之无效
	 */
	private boolean state;
	
	/**
	 * 购买项目详细列表
	 */
	@Transient
	private List<ConversionTreatmentDetail> conversionTreatmentDetailList;
	
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
	 * @return the conversionTreatmentDetailList
	 */
	public List<ConversionTreatmentDetail> getConversionTreatmentDetailList() {
		return conversionTreatmentDetailList;
	}

	/**
	 * @param conversionTreatmentDetailList the conversionTreatmentDetailList to set
	 */
	public void setConversionTreatmentDetailList(List<ConversionTreatmentDetail> conversionTreatmentDetailList) {
		this.conversionTreatmentDetailList = conversionTreatmentDetailList;
	}

}
