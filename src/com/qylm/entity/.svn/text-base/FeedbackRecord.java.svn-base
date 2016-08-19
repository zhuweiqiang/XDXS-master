package com.qylm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 客户反馈记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "feedbackrecord")
public class FeedbackRecord extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7038331713102097713L;

	/**
	 * 搜索条件：客户档案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 搜索条件：客户档案.客户姓名
	 */
	public static final String CUSTOM_INFO_NAME = "customInfo.name";
	
	/**
	 * 搜索条件：反馈日期
	 */
	public static final String DATE = "date";
	
	/**
	 * 搜索条件：营业项目
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 搜索条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 搜索条件：顾问
	 */
	public static final String ADVISER = "adviser";
	
	/**
	 * 搜索条件：产品
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 反馈日期
	 */
	private Date date;
	
	/**
	 * 反馈内容
	 */
	private String remark;
	
	/**
	 * 营业项目
	 */
	@ManyToOne(targetEntity = MarketingProject.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 产品
	 */
	@ManyToOne(targetEntity = ProductStock.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "productStockId")
	private ProductStock productStock;
	
	/**
	 * 人事信息-美容师
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
	 * @return the productStock
	 */
	public ProductStock getProductStock() {
		return productStock;
	}

	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(ProductStock productStock) {
		this.productStock = productStock;
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
	
}
