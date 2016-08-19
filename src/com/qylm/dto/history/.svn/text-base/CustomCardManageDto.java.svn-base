package com.qylm.dto.history;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.Leaguer;

/**
 * 保存历史购卡记录管理画面需要的值
 * @author smj
 */
public class CustomCardManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3496516076216381154L;

	/**
	 * 卡项级别
	 */
	private Leaguer leaguer;
	
	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 卡项号
	 */
	private String leaguerNumber;
	
	/**
	 * 余额
	 */
	private BigDecimal money;
	
	/**
	 * 卡项折扣（百分比）
	 */
	private BigDecimal rebate;
	
	/**
	 * 修改传值
	 */
	private CustomLeaguerDetail transferCustomLeaguerDetail;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;
	
	/**
	 * 检索开始日期
	 */
	private Date beginDate;

	/**
	 * 检索结束日期
	 */
	private Date endDate;
	
	/**
	 * 检索姓名
	 */
	private String name;
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 名称
	 */
	public String getGiveInfoName() {
		String name = "";
		if (GiveInfo.TYPE_1.equals(type)) {
			name = "体验卡";
		} else if (GiveInfo.TYPE_2.equals(type)) {
			name = "现金卷";
		} else {
			name = "身体卷";
		}
		return name;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return the customInfo
	 */
	public CustomInfo getCustomInfo() {
		return customInfo;
	}

	/**
	 * @param customInfo the customInfo to set
	 */
	public void setCustomInfo(CustomInfo customInfo) {
		this.customInfo = customInfo;
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
	 * @return the rebate
	 */
	public BigDecimal getRebate() {
		return rebate;
	}

	/**
	 * @param rebate the rebate to set
	 */
	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
	}

	/**
	 * @return the transferCustomLeaguerDetail
	 */
	public CustomLeaguerDetail getTransferCustomLeaguerDetail() {
		return transferCustomLeaguerDetail;
	}

	/**
	 * @param transferCustomLeaguerDetail the transferCustomLeaguerDetail to set
	 */
	public void setTransferCustomLeaguerDetail(
			CustomLeaguerDetail transferCustomLeaguerDetail) {
		this.transferCustomLeaguerDetail = transferCustomLeaguerDetail;
	}

	/**
	 * @return the returner
	 */
	public Returner<?, ?, ?> getReturner() {
		return returner;
	}

	/**
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, ?> returner) {
		this.returner = returner;
	}

}
