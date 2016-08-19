package com.qylm.dto.custom;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.ConversionTreatmentDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存疗程转换记录管理画面需要的值
 * @author smj
 */
public class ConversionTreatmentViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4175242574071111L;

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
	 * 转换日期
	 */
	private Date date;
	
	/**
	 * 转换服务
	 */
	private MarketingProject marketingProject;
	
	/**
	 * 状态：true生效扣除库存，反之无效
	 */
	private boolean state;
	
	/**
	 * 购买项目详细列表
	 */
	private List<ConversionTreatmentDetail> conversionTreatmentDetailList;
	
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
	private ConversionTreatment transferConversionTreatment;

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
	 * @return the marketingProject
	 */
	public MarketingProject getMarketingProject() {
		return marketingProject;
	}

	/**
	 * @param marketingProject the marketingProject to set
	 */
	public void setMarketingProject(MarketingProject marketingProject) {
		this.marketingProject = marketingProject;
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
	public void setConversionTreatmentDetailList(
			List<ConversionTreatmentDetail> conversionTreatmentDetailList) {
		this.conversionTreatmentDetailList = conversionTreatmentDetailList;
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
	 * @return the transferConversionTreatment
	 */
	public ConversionTreatment getTransferConversionTreatment() {
		return transferConversionTreatment;
	}

	/**
	 * @param transferConversionTreatment the transferConversionTreatment to set
	 */
	public void setTransferConversionTreatment(
			ConversionTreatment transferConversionTreatment) {
		this.transferConversionTreatment = transferConversionTreatment;
	}
	
}
