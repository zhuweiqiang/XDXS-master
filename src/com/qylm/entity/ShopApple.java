package com.qylm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 店铺申请配货持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "shopapple")
public class ShopApple extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4414985637624512074L;

	/**
	 * 检索条件：编号
	 */
	public static final String NUMBER = "number";
	
	/**
	 * 检索条件：仓库
	 */
	public static final String DEPOT_INFO = "depotInfo";
	
	/**
	 * 检索条件：申请时间
	 */
	public static final String APPLE_DATE = "appleDate";
	
	/**
	 * 检索条件：申请状态
	 */
	public static final String APPLE_STATE = "appleState";
	
	/**
	 * 检索条件：未申请
	 */
	public static final String APPLE_STATE_1 = "1";
	
	/**
	 * 检索条件：申请中
	 */
	public static final String APPLE_STATE_2 = "2";
	
	/**
	 * 检索条件：申请通过
	 */
	public static final String APPLE_STATE_3 = "3";
	
	/**
	 * 检索条件：申请未通过
	 */
	public static final String APPLE_STATE_4 = "4";
	
	/**
	 * 检索条件：完结入库
	 */
	public static final String APPLE_STATE_5 = "5";
	
	/**
	 * 检索条件：入库人
	 */
	public static final String USER = "user";

	/**
	 * 编号
	 */
	private String number;
	
	/**
	 * 仓库
	 */
	@ManyToOne(targetEntity = DepotInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "depotInfoId")
	private DepotInfo depotInfo;
	
	/**
	 * 申请日期
	 */
	private Date appleDate;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 申请状态
	 * 1：未申请
	 * 2：申请中
	 * 3：申请通过
	 * 4：申请未通过
	 * 5：完结入库
	 */
	private String appleState;
	
	/**
	 * 入库人
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	/**
	 * 店铺申请配货详细列表
	 */
	@Transient
	private List<ShopAppleDetail> shopAppleDetailList;
	
	/**
	 * 显示入库按钮
	 * @return true 显示，反之不显示
	 */
	public boolean isShowRk() {
		return ShopApple.APPLE_STATE_3.equals(appleState);
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the depotInfo
	 */
	public DepotInfo getDepotInfo() {
		return depotInfo;
	}

	/**
	 * @param depotInfo the depotInfo to set
	 */
	public void setDepotInfo(DepotInfo depotInfo) {
		this.depotInfo = depotInfo;
	}

	/**
	 * @return the appleDate
	 */
	public Date getAppleDate() {
		return appleDate;
	}

	/**
	 * @param appleDate the appleDate to set
	 */
	public void setAppleDate(Date appleDate) {
		this.appleDate = appleDate;
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
	 * @return the appleState
	 */
	public String getAppleState() {
		return appleState;
	}

	/**
	 * @param appleState the appleState to set
	 */
	public void setAppleState(String appleState) {
		this.appleState = appleState;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the shopAppleDetailList
	 */
	public List<ShopAppleDetail> getShopAppleDetailList() {
		return shopAppleDetailList;
	}

	/**
	 * @param shopAppleDetailList the shopAppleDetailList to set
	 */
	public void setShopAppleDetailList(List<ShopAppleDetail> shopAppleDetailList) {
		this.shopAppleDetailList = shopAppleDetailList;
	}
	
}
