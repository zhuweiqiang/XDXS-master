package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.qylm.common.utils.BigDecimalUtil;

/**
 * 产品销售记录详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "marketingrecord_detail")
@DiscriminatorValue(MarketingRecordDetail.DISCRIMINATOR_MARKETING_RECORD_DETAIL)
public class MarketingRecordDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3453527686794520399L;
	
	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_MARKETING_RECORD_DETAIL = "marketingRecordDetail";

	/**
	 * 查询条件：项目购买记录
	 */
	public static final String MARKETING_RECORD = "marketingRecord";
	
	/**
	 * 查询条件：项目购买记录.客户答案
	 */
	public static final String MARKETING_RECORD_CUSTOM_INFO = "marketingRecord.customInfo";

	/**
	 * 检索条件：产品
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 检索条件：产品.品牌
	 */
	public static final String PRODUCT_STOCK_BRAND = "productStock.brand";
	
	/**
	 * 检索条件：产品.系列
	 */
	public static final String PRODUCT_STOCK_SERIES = "productStock.series";
	
	/**
	 * 检索条件：仓库
	 */
	public static final String DEPOT_INFO = "depotInfo";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 项目购买记录
	 */
	@ManyToOne(targetEntity = MarketingRecord.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingRecordId")
	private MarketingRecord marketingRecord;
	
	/**
	 * 仓库
	 */
	@ManyToOne(targetEntity = DepotInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "depotInfoId")
	private DepotInfo depotInfo;
	
	/**
	 * 产品
	 */
	@ManyToOne(targetEntity = ProductStock.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "productStockId")
	private ProductStock productStock;
	
	/**
	 * 数量
	 */
	private Integer number;
	
	/**
	 * 费用
	 */
	private BigDecimal money;
	
	/**
	 * 折扣
	 */
	@Transient
	private BigDecimal rebate;
	
	/**
	 * 获取总金额
	 * @return
	 */
	public BigDecimal getSumMoney() {
		if (this.number == null) this.number = 1;
		BigDecimal num = new BigDecimal(number.toString());
		return BigDecimalUtil.multiply(money, num);
	}

	/**
	 * @return the marketingRecord
	 */
	public MarketingRecord getMarketingRecord() {
		return marketingRecord;
	}

	/**
	 * @param marketingRecord the marketingRecord to set
	 */
	public void setMarketingRecord(MarketingRecord marketingRecord) {
		this.marketingRecord = marketingRecord;
	}

	/**
	 * @return the depotInfo
	 */
	public DepotInfo getDepotInfo() {
		return depotInfo;
	}

	/**
	 * @param depotInfo the depotInfo to set
	 */
	public void setDepotInfo(DepotInfo depotInfo) {
		this.depotInfo = depotInfo;
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
