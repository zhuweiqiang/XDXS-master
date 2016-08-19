package com.qylm.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

/**
 * 个人消费详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "consumption_detail")
public class ConsumptionDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 650766323134381821L;

	/**
	 * 查询条件：个人消费登记
	 */
	public static final String CONSUMPTION_REGISTER = "consumptionRegister";
	
	/**
	 * 查询条件：个人消费登记.客户答案
	 */
	public static final String CONSUMPTION_REGISTER_CUSTOM_INFO = "consumptionRegister.customInfo";
	
	/**
	 * 查询条件：别名.客户答案
	 */
	public static final String CUSTOM_INFO = "customInfo";

	/**
	 * 检索条件：服务管理
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 检索条件：客户档案与卡项的关系
	 */
	public static final String CUSTOMLEAGUER_DATEIL = "customLeaguerDetail";
	
	/**
	 * 检索条件：客户档案与卡项的关系 下的卡项
	 */
	public static final String CUSTOMLEAGUER_DATEIL_LEAGUER = "customLeaguerDetail.leaguer";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 个人消费登记
	 */
	@ManyToOne(targetEntity = ConsumptionRegister.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "consumptionRegisterId")
	private ConsumptionRegister consumptionRegister;
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 与改变账户明细相关的信息  企业信息营业执照
	 */
	@Any(metaColumn = @Column(name = "entityType"))
	@AnyMetaDef(idType = "integer", metaType = "string", metaValues = {
				@MetaValue(value = CustomInfo.DISCRIMINATOR_CUSTOM_INFO, targetEntity = com.qylm.entity.CustomInfo.class),
				@MetaValue(value = CustomLeaguerDetail.DISCRIMINATOR_CUSTOM_LEAGUER_DATEAL, targetEntity = com.qylm.entity.CustomLeaguerDetail.class),
				@MetaValue(value = LargessRecord.DISCRIMINATOR_LARGESS_RECORD, targetEntity = com.qylm.entity.LargessRecord.class),
				@MetaValue(value = MarketingRecordDetail.DISCRIMINATOR_MARKETING_RECORD_DETAIL, targetEntity = com.qylm.entity.MarketingRecordDetail.class),
				@MetaValue(value = ProjectBuyDetail.DISCRIMINATOR_PROJECT_BUY_DETAIL, targetEntity = com.qylm.entity.ProjectBuyDetail.class),
				@MetaValue(value = TemporaryActivityDetail.DISCRIMINATOR_TEMPORARY_ACTIVITY_DETAIL, targetEntity = com.qylm.entity.TemporaryActivityDetail.class)
		})
	@JoinColumn(name = "entityId")
	private BaseEntity entity;
	
	/**
	 * 方便查询 对应到@Any的属性
	 */
	@Column(insertable=false,updatable=false)
	private Integer entityId;
	
	/**
	 * 方便查询 对应到@Any的属性
	 */
	@Column(insertable=false,updatable=false)
	private String entityType;
	
	/**
	 * 消费日期
	 */
	private Date date;
	
	/**
	 * 已付款
	 */
	private BigDecimal money;
	
	/**
	 * 次数
	 */
	private Integer number;

	/**
	 * @return the consumptionRegister
	 */
	public ConsumptionRegister getConsumptionRegister() {
		return consumptionRegister;
	}

	/**
	 * @param consumptionRegister the consumptionRegister to set
	 */
	public void setConsumptionRegister(ConsumptionRegister consumptionRegister) {
		this.consumptionRegister = consumptionRegister;
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
	 * @return the entity
	 */
	public BaseEntity getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(BaseEntity entity) {
		this.entity = entity;
	}

	/**
	 * @return the entityId
	 */
	public Integer getEntityId() {
		return entityId;
	}

	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the entityType
	 */
	public String getEntityType() {
		return entityType;
	}

	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
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
	
}
