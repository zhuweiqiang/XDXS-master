package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.qylm.entity.TemporaryActivityDetail;

/**
 * 保存活动套餐管理画面需要的值
 * @author smj
 */
public class TemporaryActivityViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7970900089863818808L;

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
