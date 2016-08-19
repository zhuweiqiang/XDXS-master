package com.qylm.dto.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.User;

/**
 * 保存赠送体验卡管理画面需要的值
 * @author smj
 */
public class GiveExperienceCardDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3435982054545252973L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	private PersonnelInfo adviser;
	
	/**
	 * 赠送日期
	 */
	private Date date;
	
	/**
	 * 体验卡、体验卡、身体卷
	 */
	@ManyToOne(targetEntity = GiveInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "giveInfoId")
	private GiveInfo giveInfo;
	
	/**
	 * 卡额
	 */
	private BigDecimal money;
	
	/**
	 * 数量
	 */
	private Integer number;
	
	/**
	 * 购置的体验卡id
	 */
	private String[] experienceCardId;
	
	/**
	 * 购置的体验卡
	 */
	private SelectItem[] experienceCardItem;

	/**
	 * 客户的卡项列表
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

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
	 * @return the personnelInfo
	 */
	public PersonnelInfo getPersonnelInfo() {
		return personnelInfo;
	}

	/**
	 * @param personnelInfo the personnelInfo to set
	 */
	public void setPersonnelInfo(PersonnelInfo personnelInfo) {
		this.personnelInfo = personnelInfo;
	}

	/**
	 * @return the adviser
	 */
	public PersonnelInfo getAdviser() {
		return adviser;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setAdviser(PersonnelInfo adviser) {
		this.adviser = adviser;
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
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the experienceCardId
	 */
	public String[] getExperienceCardId() {
		return experienceCardId;
	}

	/**
	 * @param experienceCardId the experienceCardId to set
	 */
	public void setExperienceCardId(String[] experienceCardId) {
		this.experienceCardId = experienceCardId;
	}

	/**
	 * @return the experienceCardItem
	 */
	public SelectItem[] getExperienceCardItem() {
		return experienceCardItem;
	}

	/**
	 * @param experienceCardItem the experienceCardItem to set
	 */
	public void setExperienceCardItem(SelectItem[] experienceCardItem) {
		this.experienceCardItem = experienceCardItem;
	}

	/**
	 * @return the customLeaguerDetailList
	 */
	public List<CustomLeaguerDetail> getCustomLeaguerDetailList() {
		return customLeaguerDetailList;
	}

	/**
	 * @param customLeaguerDetailList the customLeaguerDetailList to set
	 */
	public void setCustomLeaguerDetailList(
			List<CustomLeaguerDetail> customLeaguerDetailList) {
		this.customLeaguerDetailList = customLeaguerDetailList;
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
