package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 客户档案与卡项的关系持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "customleaguer_detail")
@DiscriminatorValue(CustomLeaguerDetail.DISCRIMINATOR_CUSTOM_LEAGUER_DATEAL)
public class CustomLeaguerDetail extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5488684199583997176L;
	
	/**
	 * @DiscriminatorValue
	 */
	public static final String DISCRIMINATOR_CUSTOM_LEAGUER_DATEAL = "customLeaguerDetail";
	
	/**
	 * 搜索条件：客户档案
	 */
	public static final String CUSTOM_INFO = "customInfo";
	
	/**
	 * 搜索条件：客户档案.客户姓名
	 */
	public static final String CUSTOM_INFO_NAME = "customInfo.name";
	
	/**
	 * 搜索条件：客户档案.客户姓名
	 */
	public static final String CUSTOM_INFO_LEAGUER_NUMBER = "customInfo.leaguerNumber";
	
	/**
	 * 搜索条件：卡项
	 */
	public static final String LEAGUER = "leaguer";
	
	/**
	 * 搜索条件：体验卡
	 */
	public static final String GIVE_INFO = "giveInfo";
	
	/**
	 * 搜索条件：体验卡.类型
	 */
	public static final String GIVE_INFO_TYPE = "giveInfo.type";
	
	/**
	 * 搜索条件：卡额
	 */
	public static final String MONEY = "money";

	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;

	/**
	 * 卡项级别
	 */
	@ManyToOne(targetEntity = Leaguer.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "leaguerId")
	private Leaguer leaguer;
	
	/**
	 * 体验卡、现金卷、身体卷
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
	 * 卡项折扣（百分比）
	 */
	private BigDecimal rebate;
	
	/**
	 * 此次支付金额
	 */
	@Transient
	private BigDecimal readyMoney;
	
	/**
	 * 卡额付款后的剩余金额
	 */
	@Transient
	private BigDecimal readyMoneySurplus;
	
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
	 * @return the readyMoney
	 */
	public BigDecimal getReadyMoney() {
		return readyMoney;
	}

	/**
	 * @param readyMoney the readyMoney to set
	 */
	public void setReadyMoney(BigDecimal readyMoney) {
		this.readyMoney = readyMoney;
	}

	/**
	 * @return the readyMoneySurplus
	 */
	public BigDecimal getReadyMoneySurplus() {
		return readyMoneySurplus;
	}

	/**
	 * @param readyMoneySurplus the readyMoneySurplus to set
	 */
	public void setReadyMoneySurplus(BigDecimal readyMoneySurplus) {
		this.readyMoneySurplus = readyMoneySurplus;
	}
	
}
