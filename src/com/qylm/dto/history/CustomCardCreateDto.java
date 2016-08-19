package com.qylm.dto.history;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.Leaguer;
import com.qylm.entity.User;

/**
 * 客户卡项记录登录页面需要保存的值
 * @author smj
 */
public class CustomCardCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4300990176532338570L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 卡项
	 */
	private Leaguer leaguer;
	
	/**
	 * 赠送卡项
	 */
	private GiveInfo giveInfo;
	
	/**
	 * 卡项余额
	 */
	private BigDecimal money;
	
	/**
	 * 卡项折扣（百分比）
	 */
	private BigDecimal rebate;
	
	/**
	 * 购卡日期
	 */
	private Date createDate;
	
	/**
	 * 卡项下拉框列表
	 */
	private SelectItem[] leaguerItems;
	
	/**
	 * 卡项id
	 */
	private String leguerId;
	
	/**
	 * 卡项下拉框列表
	 */
	private SelectItem[] giveInfoItems;
	
	/**
	 * 卡项id
	 */
	private String giveInfoId;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 修改传值
	 */
	private CustomLeaguerDetail transferCustomLeaguerDetail;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;
	
	/**
	 * 标题显示
	 */
	private String title;

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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the leaguerItems
	 */
	public SelectItem[] getLeaguerItems() {
		return leaguerItems;
	}

	/**
	 * @param leaguerItems the leaguerItems to set
	 */
	public void setLeaguerItems(SelectItem[] leaguerItems) {
		this.leaguerItems = leaguerItems;
	}

	/**
	 * @return the leguerId
	 */
	public String getLeguerId() {
		return leguerId;
	}

	/**
	 * @param leguerId the leguerId to set
	 */
	public void setLeguerId(String leguerId) {
		this.leguerId = leguerId;
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

	/**
	 * @return the belongingUser
	 */
	public User getBelongingUser() {
		return belongingUser;
	}

	/**
	 * @param belongingUser the belongingUser to set
	 */
	public void setBelongingUser(User belongingUser) {
		this.belongingUser = belongingUser;
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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the giveInfoItems
	 */
	public SelectItem[] getGiveInfoItems() {
		return giveInfoItems;
	}

	/**
	 * @param giveInfoItems the giveInfoItems to set
	 */
	public void setGiveInfoItems(SelectItem[] giveInfoItems) {
		this.giveInfoItems = giveInfoItems;
	}

	/**
	 * @return the giveInfoId
	 */
	public String getGiveInfoId() {
		return giveInfoId;
	}

	/**
	 * @param giveInfoId the giveInfoId to set
	 */
	public void setGiveInfoId(String giveInfoId) {
		this.giveInfoId = giveInfoId;
	}

	/**
	 * @return the giveInfo
	 */
	public GiveInfo getGiveInfo() {
		return giveInfo;
	}

	/**
	 * @param giveInfo the giveInfo to set
	 */
	public void setGiveInfo(GiveInfo giveInfo) {
		this.giveInfo = giveInfo;
	}


}
