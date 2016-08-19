package com.qylm.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.qylm.common.SelectItemCreator;

/**
 * 品牌持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "brand")
@DiscriminatorValue(Brand.DISCRIMINATOR_BRAND)
public class Brand extends BaseEntity implements SelectItemCreator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -312024959129743946L;
	
	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_BRAND = "brand";

	/**
	 * 查询条件：卡项级别
	 */
	public static final String NAME = "name";

	/**
	 * 品牌名称
	 */
	private String name;
	
	/**
	 * 备注
	 */
	private String remark;
	
	public String getValue() {
		return id.toString();
	}

	public String getLabel() {
		return name;
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
