package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 系列持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "series")
public class Series extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6873145387273907844L;

	/**
	 * 查询条件：品牌
	 */
	public static final String BRAND = "brand";
	
	/**
	 * 查询条件：卡项级别
	 */
	public static final String NAME = "name";
	
	/**
	 * 品牌
	 */
	@ManyToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
	@JoinColumn(name="brandId")
	private Brand brand;
	
	/**
	 * 系列名称
	 */
	private String name;
	
	/**
	 * 备注
	 */
	private String remark;

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
	
}
