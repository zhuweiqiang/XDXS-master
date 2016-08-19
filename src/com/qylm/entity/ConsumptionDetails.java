package com.qylm.entity;

import java.math.BigDecimal;

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
@Table(uniqueConstraints = {}, name = "consumptionregister_detail")
public class ConsumptionDetails extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4907807895624387088L;

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
	 * 查询条件：购买时间
	 */
	public static final String TYPE = "type";
	
	/**
	 * 类型：付款项目
	 */
	public static final Integer TYPE_1 = 1;
	
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
	 * 类型：余额支付
	 */
	public static final Integer TYPE_5 = 5;
	
	/**
	 * 类型：卡项支付
	 */
	public static final Integer TYPE_6 = 6;
	
	/**
	 * 类型：现金支付
	 */
	public static final Integer TYPE_7 = 7;
	
	/**
	 * 类型：体验卡支付
	 */
	public static final Integer TYPE_8 = 8;
	
	/**
	 * 个人消费登记
	 */
	@ManyToOne(targetEntity = ConsumptionRegister.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "consumptionRegisterId")
	private ConsumptionRegister consumptionRegister;
	
	/**
	 * 与改变账户明细相关的信息  企业信息营业执照
	 */
	@Any(metaColumn = @Column(name = "entityType"))
	@AnyMetaDef(idType = "integer", metaType = "string", metaValues = {
				@MetaValue(value = ProductStock.DISCRIMINATOR_PRODUCT_STOCK, targetEntity = com.qylm.entity.ProductStock.class),
				@MetaValue(value = Brand.DISCRIMINATOR_BRAND, targetEntity = com.qylm.entity.Brand.class)
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
	 * 已付款
	 */
	private BigDecimal money;
	
	/**
	 * 次数
	 */
	private Integer number;
	
}
