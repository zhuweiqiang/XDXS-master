package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qylm.common.utils.BigDecimalUtil;

/**
 * 疗程转换记录详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "conversiontreatment_detail")
public class ConversionTreatmentDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7204137653536115711L;

	/**
	 * 查询条件：疗程转换记录
	 */
	public static final String CONVERSION_TREATMENT = "conversionTreatment";
	
	/**
	 * 查询条件：疗程转换记录.客户答案
	 */
	public static final String CONVERSION_TREATMENT_CUSTOM_INFO = "conversionTreatment.customInfo";

	/**
	 * 检索条件：服务
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 检索条件：转换项目的ID
	 */
	public static final String TYPE_ID = "typeId";
	
	/**
	 * 类型：赠送项目
	 */
	public static final Integer TYPE_2 = 2;
	
	/**
	 * 类型：购买的套餐项目
	 */
	public static final Integer TYPE_3 = 3;
	
	/**
	 * 类型：购买的项目
	 */
	public static final Integer TYPE_4 = 4;
	
	/**
	 * 疗程转换记录
	 */
	@ManyToOne(targetEntity = ConversionTreatment.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "conversionTreatmentId")
	private ConversionTreatment conversionTreatment;
	
	/**
	 * 转换服务
	 */
	@ManyToOne(targetEntity = MarketingProject.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 转换项目的ID
	 */
	private Integer typeId;
	
	/**
	 * 类型
	 * 1：付款项目
	 * 2：赠送项目
	 * 3：购买的套餐项目
	 * 4：购买的项目
	 */
	private Integer type;
	
	/**
	 * 扣除数量
	 */
	private Integer number;
	
	/**
	 * 剩余次数
	 */
	private Integer surplusNumber;
	
	/**
	 * 转换时的费用
	 */
	private BigDecimal money;
	
	/**
	 * 获取总金额
	 * @return
	 */
	public BigDecimal getSumMoney() {
		if (this.number == null) this.number = 1;
		BigDecimal num = new BigDecimal(number.toString());
		return BigDecimalUtil.multiply(money, num);
	}
	
	/**
	 * 用于获取类型名称
	 * @return
	 */
	public String getTypeLabel() {
		int intValue = this.type.intValue();
		String label = "";
		switch (intValue) {
		case 1:
			label = "付款项目";
			break;
		case 2:
			label = "赠送项目";
			break;
		case 3:
			label = "购买的套餐项目";
			break;
		case 4:
			label = "购买的项目";	
			break;
		default:
			break;
		}
		return label;
	}

	/**
	 * @return the conversionTreatment
	 */
	public ConversionTreatment getConversionTreatment() {
		return conversionTreatment;
	}

	/**
	 * @param conversionTreatment the conversionTreatment to set
	 */
	public void setConversionTreatment(ConversionTreatment conversionTreatment) {
		this.conversionTreatment = conversionTreatment;
	}

	/**
	 * @return the marketingProject
	 */
	public MarketingProject getMarketingProject() {
		return marketingProject;
	}

	/**
	 * @param marketingProject the marketingProject to set
	 */
	public void setMarketingProject(MarketingProject marketingProject) {
		this.marketingProject = marketingProject;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * @return the surplusNumber
	 */
	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	/**
	 * @param surplusNumber the surplusNumber to set
	 */
	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
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

}
