package com.qylm.dto.baseSet;

import java.io.Serializable;

import com.qylm.entity.Brand;

/**
 * 保存系类管理画面需要的值
 * @author smj
 */
public class SeriesManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 641510394920647550L;
	
	/**
	 * 品牌
	 */
	private Brand brand;
	
	/**
	 * 系类名称
	 */
	private String name;

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
