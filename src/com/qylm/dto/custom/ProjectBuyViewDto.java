package com.qylm.dto.custom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qylm.entity.CustomInfo;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.ProjectBuyDetail;

/**
 * 保存项目购买管理画面需要的值
 * @author smj
 */
public class ProjectBuyViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6220413218062340867L;

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
	 * 购买时间
	 */
	private Date date;
	
	/**
	 * 套餐费用
	 */
	private BigDecimal money;
	
	/**
	 * 项目购买详细列表
	 */
	private List<ProjectBuyDetail> projectBuyDetailList;

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
	 * @return the projectBuyDetailList
	 */
	public List<ProjectBuyDetail> getProjectBuyDetailList() {
		return projectBuyDetailList;
	}

	/**
	 * @param projectBuyDetailList the projectBuyDetailList to set
	 */
	public void setProjectBuyDetailList(List<ProjectBuyDetail> projectBuyDetailList) {
		this.projectBuyDetailList = projectBuyDetailList;
	}

}
