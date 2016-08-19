package com.qylm.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 产品库存持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "productstock")
@DiscriminatorValue(ProductStock.DISCRIMINATOR_PRODUCT_STOCK)
public class ProductStock extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9004651966635921317L;

	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_PRODUCT_STOCK = "productStock";
	
	/**
	 * 检索条件：产品名称
	 */
	public static final String NAME = "name";
	
	/**
	 * 检索条件：品牌
	 */
	public static final String BRAND = "brand";
	
	/**
	 * 检索条件：品牌.id
	 */
	public static final String BRAND_ID = "brand.id";
	
	/**
	 * 检索条件：系列
	 */
	public static final String SERIES = "series";
	
	/**
	 * 检索条件：系列
	 */
	public static final String SERIES_ID = "series.id";

	/**
	 * 产品名称
	 */
	private String name;
	
	/**
	 * 产品介绍
	 */
	private String introduce;
	
	/**
	 * 产品价格
	 */
	private BigDecimal money;
	
	/**
	 * 产品成本
	 */
	private BigDecimal cost;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 品牌
	 */
	@ManyToOne(targetEntity = Brand.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "brandId")
	private Brand brand;

	/**
	 * 系列
	 */
	@ManyToOne(targetEntity = Series.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "seriesId")
	private Series series;
	
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 产品库存详细列表
	 */
	@Transient
	private List<ProductStockDetail> productStockDetailList;
	
	/**
	 * 显示图片
	 */
	@Transient
	private FileControl fileControl;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
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
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the series
	 */
	public Series getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(Series series) {
		this.series = series;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the productStockDetailList
	 */
	public List<ProductStockDetail> getProductStockDetailList() {
		return productStockDetailList;
	}

	/**
	 * @param productStockDetailList the productStockDetailList to set
	 */
	public void setProductStockDetailList(
			List<ProductStockDetail> productStockDetailList) {
		this.productStockDetailList = productStockDetailList;
	}

	/**
	 * @return the fileControl
	 */
	public FileControl getFileControl() {
		return fileControl;
	}

	/**
	 * @param fileControl the fileControl to set
	 */
	public void setFileControl(FileControl fileControl) {
		this.fileControl = fileControl;
	}
	
}
