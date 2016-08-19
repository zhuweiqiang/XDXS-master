package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 店铺申请配货详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "shopapple_detail")
public class ShopAppleDetail extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4875413564501455444L;

	/**
	 * 检索条件：店铺申请配货
	 */
	public static final String SHOP_APPLE = "shopApple";
	
	/**
	 * 检索条件：产品名称
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 店铺申请配货
	 */
	@ManyToOne(targetEntity = ShopApple.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "shopAppleId")
	private ShopApple shopApple;
	
	/**
	 * 产品
	 */
	@ManyToOne(targetEntity = ProductStock.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "productStockId")
	private ProductStock productStock;
	
	/**
	 * 需求数量
	 */
	private BigDecimal number;
	
	/**
	 * 实际数量
	 */
	private BigDecimal realityNumber;

	/**
	 * @return the shopApple
	 */
	public ShopApple getShopApple() {
		return shopApple;
	}

	/**
	 * @param shopApple the shopApple to set
	 */
	public void setShopApple(ShopApple shopApple) {
		this.shopApple = shopApple;
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

	/**
	 * @return the realityNumber
	 */
	public BigDecimal getRealityNumber() {
		return realityNumber;
	}

	/**
	 * @param realityNumber the realityNumber to set
	 */
	public void setRealityNumber(BigDecimal realityNumber) {
		this.realityNumber = realityNumber;
	}

}
