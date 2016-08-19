package com.qylm.dto.auditing;

import java.io.Serializable;
import java.util.Date;

import com.qylm.entity.ShopApple;
import com.qylm.entity.User;

/**
 * 保存店铺配货审核管理画面需要的值
 * @author smj
 */
public class ShopAuditingViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5049231598908211956L;

	/**
	 * 店铺配货单
	 */
	private ShopApple shopApple;
	
	/**
	 * 审核员
	 */
	private User auditor;
	
	/**
	 * 审核情况
	 */
	private String remark;
	
	/**
	 * 审核时间
	 */
	private Date date;
	
	/**
	 * 审核状态
	 */
	private String state;
	
	/**
	 * 审核顺序
	 */
	private Integer sequence;
	
	/**
	 * 创建事件
	 */
	private User creater;

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
	 * @return the auditor
	 */
	public User getAuditor() {
		return auditor;
	}

	/**
	 * @param auditor the auditor to set
	 */
	public void setAuditor(User auditor) {
		this.auditor = auditor;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
