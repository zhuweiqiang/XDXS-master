package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 产品库存详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "productstock_detail")
public class ProductStockDetail extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6518921088014651459L;
	
	/**
	 * 检索条件：仓库
	 */
	public static final String DEPOT_INFO = "depotInfo";
	
	/**
	 * 检索条件：产品库存
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 检索条件：产品库存.产品名称
	 */
	public static final String PRODUCT_STOCK_NAME = "productStock.name";
	
	/**
	 * 检索条件：产品库存.id
	 */
	public static final String PRODUCT_STOCK_ID = "productStock.id";

	/**
	 * 仓库
	 */
	@ManyToOne(targetEntity = DepotInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "depotInfoId")
	private DepotInfo depotInfo;

	/**
	 * 产品库存
	 */
	@ManyToOne(targetEntity = ProductStock.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "productStockId")
	private ProductStock productStock;
	
	/**
	 * 数量
	 */
	private BigDecimal number;

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
	public BigDecimal getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(BigDecimal number) {
		this.number = number;
	}

}
