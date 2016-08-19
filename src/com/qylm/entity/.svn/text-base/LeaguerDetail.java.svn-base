package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 会员详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "leaguer_detail")
public class LeaguerDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8579505947932526035L;
	
	/**
	 * 搜索条件：leaguer
	 */
	public static final String LEAGUER = "leaguer";
	
	/**
	 * 搜索条件：marketingProject
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 搜索条件：productStock
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 搜索条件：giveInfo
	 */
	public static final String GIVE_INFO = "giveInfo";
	
	/**
	 * 搜索条件：state
	 */
	public static final String STATE = "state";

	/**
	 * 卡项
	 */
	@ManyToOne(targetEntity = Leaguer.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "leaguerId")
	private Leaguer leaguer;
	
	/**
	 * 项目
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
	 * 赠送现金卷、赠送身体卷
	 */
	@ManyToOne(targetEntity = GiveInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "giveInfoId")
	private GiveInfo giveInfo;
	
	/**
	 * true，赠送项目反之不是
	 */
	private boolean state;
	
	/**
	 * 赠送项目次数
	 */
	private Integer number;
	
	/**
	 * 项目价值
	 */
	private BigDecimal money;
	
	/**
	 * 折扣（百分比）
	 */
	private BigDecimal rebate;

	/**
	 * @return the leaguer
	 */
	public Leaguer getLeaguer() {
		return leaguer;
	}

	/**
	 * @param leaguer the leaguer to set
	 */
	public void setLeaguer(Leaguer leaguer) {
		this.leaguer = leaguer;
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
	 * @return the rebate
	 */
	public BigDecimal getRebate() {
		return rebate;
	}

	/**
	 * @param rebate the rebate to set
	 */
	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
	}
	
}
