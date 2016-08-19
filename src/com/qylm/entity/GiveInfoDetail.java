package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 体验卡详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "giveinfo_detail")
public class GiveInfoDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3583472083605586393L;

	/**
	 * 查询条件：体验卡
	 */
	public static final String GIVE_INFO = "giveInfo";
	
	/**
	 * 查询条件：服务管理
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 查询条件：产品
	 */
	public static final String PRODUCT_STOCK_DETIAL = "productStockDetail";

	/**
	 * 体验卡
	 */
	@ManyToOne(targetEntity = GiveInfo.class, fetch = FetchType.LAZY)
	@JoinColumn(name="giveInfoId")
	private GiveInfo giveInfo;
	
	/**
	 * 服务管理
	 */
	@ManyToOne(targetEntity = MarketingProject.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 产品
	 */
	@ManyToOne(targetEntity = ProductStockDetail.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "productStockDetailId")
	private ProductStockDetail productStockDetail;
	
	/**
	 * 次数/数量
	 */
	private Integer number;

	/**
	 * @return the giveInfo
	 */
	public GiveInfo getGiveInfo() {
		return giveInfo;
	}

	/**
	 * @param giveInfo the giveInfo to set
	 */
	public void setGiveInfo(GiveInfo giveInfo) {
		this.giveInfo = giveInfo;
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
	 * @return the productStockDetail
	 */
	public ProductStockDetail getProductStockDetail() {
		return productStockDetail;
	}

	/**
	 * @param productStockDetail the productStockDetail to set
	 */
	public void setProductStockDetail(ProductStockDetail productStockDetail) {
		this.productStockDetail = productStockDetail;
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
	
}
