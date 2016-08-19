package com.qylm.dto.custom;

import java.io.Serializable;
import java.util.Date;

import com.qylm.entity.Leaguer;

/**
 * 保存会员充值记录管理画面需要的值
 * @author smj
 */
public class RechargeManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1934667662157177054L;

	/**
	 * 卡项级别
	 */
	private Leaguer leaguer;
	
	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 卡项号
	 */
	private String leaguerNumber;
	
	/**
	 * 充值时间（开始）
	 */
	private Date beginRechargeDate;
	
	/**
	 * 充值时间（结束）
	 */
	private Date endRechargeDate;

	/**
	 * @return the leaguer
	 */
	public Leaguer getLeaguer() {
		return leaguer;
	}

	/**
	 * @param leaguer the leaguer to set
	 */
	public void setLeaguer(Leaguer leaguer) {
		this.leaguer = leaguer;
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
	 * @return the leaguerNumber
	 */
	public String getLeaguerNumber() {
		return leaguerNumber;
	}

	/**
	 * @param leaguerNumber the leaguerNumber to set
	 */
	public void setLeaguerNumber(String leaguerNumber) {
		this.leaguerNumber = leaguerNumber;
	}

	/**
	 * @return the beginRechargeDate
	 */
	public Date getBeginRechargeDate() {
		return beginRechargeDate;
	}

	/**
	 * @param beginRechargeDate the beginRechargeDate to set
	 */
	public void setBeginRechargeDate(Date beginRechargeDate) {
		this.beginRechargeDate = beginRechargeDate;
	}

	/**
	 * @return the endRechargeDate
	 */
	public Date getEndRechargeDate() {
		return endRechargeDate;
	}

	/**
	 * @param endRechargeDate the endRechargeDate to set
	 */
	public void setEndRechargeDate(Date endRechargeDate) {
		this.endRechargeDate = endRechargeDate;
	}
	
}
