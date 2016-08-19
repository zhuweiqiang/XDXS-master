package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.qylm.common.SelectItemCreator;

/**
 * 仓库管理持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "depotinfo")
public class DepotInfo extends BaseEntity implements SelectItemCreator {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 884211604736216251L;

	/**
	 * 查询条件：仓库名
	 */
	public static final String NAME = "name";

	/**
	 * 仓库名
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
