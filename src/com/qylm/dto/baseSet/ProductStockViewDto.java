package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qylm.entity.Brand;
import com.qylm.entity.Series;
import com.qylm.entity.User;

/**
 * 保存产品库存管理画面需要的值
 * @author smj
 */
public class ProductStockViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2163301693323435564L;

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
	private Brand brand;

	/**
	 * 系列
	 */
	private Series series;
	
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 创建事件
	 */
	private User creater;

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
