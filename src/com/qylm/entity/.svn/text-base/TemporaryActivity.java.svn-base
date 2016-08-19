package com.qylm.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 活动套餐持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "temporaryactivity")
public class TemporaryActivity extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -182573016151390281L;
	
	/**
	 * 检索条件：活动名称
	 */
	public static final String NAME = "name";
	
	/**
	 * 检索条件：有效状态
	 */
	public static final String STATE = "state";

	/**
	 * 活动名称
	 */
	private String name;
	
	/**
	 * 详细介绍
	 */
	private String remark;
	
	/**
	 * 套餐费用
	 */
	private BigDecimal money;
	
	/**
	 * 有效状态
	 * true：有效
	 * false：反之无效
	 */
	private boolean state;
	
	/**
	 * 活动套餐详细列表
	 */
	@Transient
	private List<TemporaryActivityDetail> temporaryActivityDetailList;

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

	/**
	 * @return the temporaryActivityDetailList
	 */
	public List<TemporaryActivityDetail> getTemporaryActivityDetailList() {
		return temporaryActivityDetailList;
	}

	/**
	 * @param temporaryActivityDetailList the temporaryActivityDetailList to set
	 */
	public void setTemporaryActivityDetailList(
			List<TemporaryActivityDetail> temporaryActivityDetailList) {
		this.temporaryActivityDetailList = temporaryActivityDetailList;
	}

}
