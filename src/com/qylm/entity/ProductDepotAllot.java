package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 库存调拨持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "productdepotallot")
public class ProductDepotAllot extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4622745983582548985L;
	
	/**
	 * 检索条件：原仓库
	 */
	public static final String DEPOT_INFO = "depotInfo";
	
	/**
	 * 检索条件：调往库存
	 */
	public static final String ALLOT_DEPOT_INFO = "allotDepotInfo";
	
	/**
	 * 检索条件：产品库存详细
	 */
	public static final String PRODUCT_STOCK_DETAIL = "productStockDetail";
	
	/**
	 * 检索条件：产品库存详细.产品库存
	 */
	public static final String PRODUCT_STOCK_DETAIL_PRODUCT_STOCK = "productStockDetail.productStock";
	
	/**
	 * 检索条件：别名.产品库存
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 检索条件：别名.产品库存.产品名称
	 */
	public static final String PRODUCT_STOCK_NAME = "productStock.name";
	
	/**
	 * 检索条件：调往产品库存详细
	 */
	public static final String ALLOT_PRODUCT_STOCK_DETAIL = "allotProductStockDetail";

	/**
	 * 原仓库
	 */
	@ManyToOne(targetEntity = DepotInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "depotInfoId")
	private DepotInfo depotInfo;

	/**
	 * 产品库存详细
	 */
	@ManyToOne(targetEntity = ProductStockDetail.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "productStockDetailId")
	private ProductStockDetail productStockDetail;
	
	/**
	 * 调往库存
	 */
	@ManyToOne(targetEntity = DepotInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "allotDepotInfoId")
	private DepotInfo allotDepotInfo;
	
	/**
	 * 调往产品库存详细
	 */
	@ManyToOne(targetEntity = ProductStockDetail.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "allotProductStockDetailId")
	private ProductStockDetail allotProductStockDetail;
	
	/**
	 * 调拨数量
	 */
	private BigDecimal number;
	
	/**
	 * 确认生效
	 * true:生效
	 * false：无效
	 */
	private boolean state;

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
	 * @return the allotDepotInfo
	 */
	public DepotInfo getAllotDepotInfo() {
		return allotDepotInfo;
	}

	/**
	 * @param allotDepotInfo the allotDepotInfo to set
	 */
	public void setAllotDepotInfo(DepotInfo allotDepotInfo) {
		this.allotDepotInfo = allotDepotInfo;
	}

	/**
	 * @return the allotProductStockDetail
	 */
	public ProductStockDetail getAllotProductStockDetail() {
		return allotProductStockDetail;
	}

	/**
	 * @param allotProductStockDetail the allotProductStockDetail to set
	 */
	public void setAllotProductStockDetail(
			ProductStockDetail allotProductStockDetail) {
		this.allotProductStockDetail = allotProductStockDetail;
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
