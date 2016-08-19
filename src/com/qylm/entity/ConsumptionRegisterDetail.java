package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.constants.Constants;

/**
 * 个人消费登记详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "consumptionregister_detail")
public class ConsumptionRegisterDetail extends BaseEntity {

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
	 * 检索条件：客户档案与卡项的关系 下的体验卷
	 */
	public static final String CUSTOMLEAGUER_DATEIL_GIVE_INFO = "customLeaguerDetail.giveInfo";
	
	/**
	 * 查询条件：产品
	 */
	public static final String PRODUCT_STOCK = "productStock";
	
	/**
	 * 查询条件：活动套餐
	 */
	public static final String TEMPORARY_ACTIVITY = "temporaryActivity";
	
	/**
	 * 查询条件：疗程购买详细
	 */
	public static final String PROJECT_BUY_DETAIL = "projectBuyDetail";
	
	/**
	 * 查询条件：别名.服务管理
	 */
	public static final String PROJECT_BUY_DETAIL_MARKETING_PROJECT = "projectBuyDetail.marketingProject";
	
	/**
	 * 查询条件：购买时间
	 */
	public static final String DATE = "date";
	
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
	 * 类型：转换的项目
	 */
	public static final Integer TYPE_5 = 5;
	
	/**
	 * 个人消费登记
	 */
	@ManyToOne(targetEntity = ConsumptionRegister.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "consumptionRegisterId")
	private ConsumptionRegister consumptionRegister;
	
	/**
	 * 服务管理
	 */
	@ManyToOne(targetEntity = MarketingProject.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 卡项
	 */
	@ManyToOne(targetEntity = CustomLeaguerDetail.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customLeaguerDetailId")
	private CustomLeaguerDetail customLeaguerDetail;
	
	/**
	 * 产品
	 */
	@ManyToOne(targetEntity = ProductStock.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "productStockId")
	private ProductStock productStock;
	
	/**
	 * 活动套餐
	 */
	@ManyToOne(targetEntity = TemporaryActivity.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "temporaryActivityId")
	private TemporaryActivity temporaryActivity;
	
	/**
	 * 疗程购买详细
	 */
	@ManyToOne(targetEntity = ProjectBuyDetail.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "projectBuyDetailId")
	private ProjectBuyDetail projectBuyDetail;
	
	/**
	 * 已付款
	 */
	private BigDecimal money;
	
	/**
	 * 消费数量
	 */
	private Integer number;
	
	/**
	 * 消耗次数
	 */
	private int consumptionNumber;
	
	/**
	 * 扣除的类型，多个就已“,”分开
	 * 2：赠送项目
	 * 3：购买的套餐项目
	 * 4：购买的项目
	 */
	private String types;
	
	/**
	 * 卡项折扣（百分比）
	 */
	@Transient
	private BigDecimal rebate;
	
	/**
	 * 数量X金额
	 * @return
	 */
	public BigDecimal getSumMoney() {
		BigDecimal money = Constants.BIGDECIMAL_ZERO;
		if (marketingProject != null) {
			if (number == null) number = 0;
			Integer s = number - consumptionNumber;
			money = marketingProject.getMoney();
			money = BigDecimalUtil.multiply(new BigDecimal(s.toString()), money);
		} else {
			money = this.money;
		}
		return money;
	}
	
	/**
	 * 获取消费项目名称
	 * @return
	 */
	public String getName() {
		String name = "";
		if (marketingProject != null) {
			name = marketingProject.getProject();
		}
		if (customLeaguerDetail != null) {
			Leaguer leaguer = customLeaguerDetail.getLeaguer();
			if (leaguer != null) {
				name = leaguer.getLabel();
			}
			GiveInfo giveInfo = customLeaguerDetail.getGiveInfo();
			if (giveInfo != null) {
				name = giveInfo.getLabel();
			}
		}
		if (productStock != null) {
			name = productStock.getName();
		}
		if (temporaryActivity != null) {
			name = temporaryActivity.getName();
		}
		if (projectBuyDetail != null) {
			name = projectBuyDetail.getMarketingProject().getProject();
		}
		return name;
	}
	
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
	 * @return the customLeaguerDetail
	 */
	public CustomLeaguerDetail getCustomLeaguerDetail() {
		return customLeaguerDetail;
	}

	/**
	 * @param customLeaguerDetail the customLeaguerDetail to set
	 */
	public void setCustomLeaguerDetail(CustomLeaguerDetail customLeaguerDetail) {
		this.customLeaguerDetail = customLeaguerDetail;
	}

	/**
	 * @return the productStock
	 */
	public ProductStock getProductStock() {
		return productStock;
	}

	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(ProductStock productStock) {
		this.productStock = productStock;
	}

	/**
	 * @return the temporaryActivity
	 */
	public TemporaryActivity getTemporaryActivity() {
		return temporaryActivity;
	}

	/**
	 * @param temporaryActivity the temporaryActivity to set
	 */
	public void setTemporaryActivity(TemporaryActivity temporaryActivity) {
		this.temporaryActivity = temporaryActivity;
	}

	/**
	 * @return the projectBuyDetail
	 */
	public ProjectBuyDetail getProjectBuyDetail() {
		return projectBuyDetail;
	}

	/**
	 * @param projectBuyDetail the projectBuyDetail to set
	 */
	public void setProjectBuyDetail(ProjectBuyDetail projectBuyDetail) {
		this.projectBuyDetail = projectBuyDetail;
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
	 * @return the consumptionNumber
	 */
	public int getConsumptionNumber() {
		return consumptionNumber;
	}

	/**
	 * @param consumptionNumber the consumptionNumber to set
	 */
	public void setConsumptionNumber(int consumptionNumber) {
		this.consumptionNumber = consumptionNumber;
	}

	/**
	 * @return the types
	 */
	public String getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
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

}
