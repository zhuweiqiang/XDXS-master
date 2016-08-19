package com.qylm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 店铺配货审核
 * @author ShengMinJun
 */
@Entity
@Table(uniqueConstraints = {}, name = "shopauditing")
public class ShopAuditing extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5533808894273558802L;

	/**
	 * 店铺配货单
	 */
	public static final String SHOP_APPLE = "shopApple";
	
	/**
	 * 店铺配货单.编号
	 */
	public static final String SHOP_APPLE_NUMBER = "shopApple.number";
	
	/**
	 * 店铺配货单.申请仓库
	 */
	public static final String SHOP_APPLE_DEPOT_INFO = "shopApple.depotInfo";
	
	/**
	 * 店铺配货单.入库人
	 */
	public static final String SHOP_APPLE_USER = "shopApple.user";
	
	/**
	 * 审核员
	 */
	public static final String AUDITOR = "auditor";
	
	/**
	 * 等级顺序
	 */
	public static final String SEQUENCE = "sequence";
	
	/**
	 * 审核状态
	 */
	public static final String STATE = "state";
	
	/**
	 * 审核状态：审核中
	 */
	public static final String STATE_1 = "1";
	
	/**
	 * 审核状态：审核通过
	 */
	public static final String STATE_2 = "2";
	
	/**
	 * 审核状态：审核未通过
	 */
	public static final String STATE_3 = "3";
	
	/**
	 * 店铺配货单
	 */
	@ManyToOne(targetEntity = ShopApple.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "shopAppleId")
	private ShopApple shopApple;
	
	/**
	 * 审核员
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "auditorId")
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
	
}
