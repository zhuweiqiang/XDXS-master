package com.qylm.dto.custom;

import java.io.Serializable;
import java.util.Date;

import com.qylm.entity.CustomInfo;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.ProductStock;
import com.qylm.entity.User;

/**
 * 保存客户反馈记录管理画面需要的值
 * @author smj
 */
public class FeedbackRecordViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 515187091955982105L;

	/**
	 * 客户档案
	 */
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
	private MarketingProject marketingProject;
	
	/**
	 * 产品
	 */
	private ProductStock productStock;
	
	/**
	 * 人事信息-美容师
	 */
	private PersonnelInfo personnelInfo;
	
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
