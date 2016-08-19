package com.qylm.dto.baseSet;

import java.io.Serializable;

import javax.faces.model.SelectItem;

import com.qylm.entity.Brand;

/**
 * 保存产品库存管理画面需要的值
 * @author smj
 */
public class ProductStockManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3784960607200186218L;
	
	/**
	 * 产品名称
	 */
	private String name;
	
	/**
	 * 品牌
	 */
	private Brand brand;
	
	/**
	 * 系列id
	 */
	private String seriesId;
	
	/**
	 * 系列
	 */
	private SelectItem[] seriesItems;

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
	 * @return the seriesId
	 */
	public String getSeriesId() {
		return seriesId;
	}

	/**
	 * @param seriesId the seriesId to set
	 */
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * @return the seriesItems
	 */
	public SelectItem[] getSeriesItems() {
		return seriesItems;
	}

	/**
	 * @param seriesItems the seriesItems to set
	 */
	public void setSeriesItems(SelectItem[] seriesItems) {
		this.seriesItems = seriesItems;
	}

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

}
