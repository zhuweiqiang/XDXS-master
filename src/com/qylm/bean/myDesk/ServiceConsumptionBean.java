package com.qylm.bean.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.custom.ConsumptionRegisterProjectDto;
import com.qylm.dto.myDesk.ServiceConsumptionDto;
import com.qylm.dxo.ServiceConsumptionDxo;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.LeaguerDetail;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.exception.ConsumptionException;
import com.qylm.service.ConsumptionRegisterDetailService;
import com.qylm.service.ConsumptionRegisterService;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.LargessRecordService;
import com.qylm.service.LeaguerDetailService;
import com.qylm.service.MarketingProjectService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.ProjectBuyDetailService;

/**
 * 服务消费登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ServiceConsumptionBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1292085510013667488L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ServiceConsumptionBean.class);

	/**
	 * 存放服务消费登陆画面需要保存的值
	 */
	private ServiceConsumptionDto serviceConsumptionDto = new ServiceConsumptionDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterService}")
	private ConsumptionRegisterService consumptionRegisterService;
	
	/**
	 * 客户档案与卡项业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 服务项目业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterDetailService}")
	private ConsumptionRegisterDetailService consumptionRegisterDetailService;
	
	/**
	 * 赠送项目记录业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 套餐购买详细记录业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordDetailService}")
	private MealBuyRecordDetailService mealBuyRecordDetailService;
	
	/**
	 * 项目购买详细记录业务类
	 */
	@ManagedProperty(value="#{projectBuyDetailService}")
	private ProjectBuyDetailService projectBuyDetailService;
	
	/**
	 * 卡项详细业务类
	 */
	@ManagedProperty(value="#{leaguerDetailService}")
	private LeaguerDetailService leaguerDetailService;
	
	/**
	 * 此方法绑定于服务消费登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 服务消费登陆画面
	 */
	public String newServiceConsumption() {
		Tool.sendLog(LOG, userBean, "【服务消费登陆画面_新建按钮】");
		serviceConsumptionDto.setCustomInfo(null);
		serviceConsumptionDto.setPersonnelInfo(null);
		serviceConsumptionDto.setAdviser(null);
		serviceConsumptionDto.setDate(DateUtil.getNowyyyymmdd());
		serviceConsumptionDto.setMoney(null);
		serviceConsumptionDto.setArrearage(null);
		serviceConsumptionDto.setRealityMoney(null);
		serviceConsumptionDto.setState(false);
		serviceConsumptionDto.setCustomLeaguerDetailList(null);
		serviceConsumptionDto.setMarketingProjectList(null);
		serviceConsumptionDto.setMarketingProjectName(null);
		serviceConsumptionDto.setConsumptionRegisterDetailList(null);
		serviceConsumptionDto.setConsumptionRegisterProjectDtoList(null);
		serviceConsumptionDto.setCustomLeaguerDetailItems(null);
		serviceConsumptionDto.setCustomLeaguerDetailId(null);
		serviceConsumptionDto.setLeaguerMoney(null);
		serviceConsumptionDto.setLeaguerReadyMoney(null);
		serviceConsumptionDto.setRebate(null);
		serviceConsumptionDto.setRebateMoney(null);
		serviceConsumptionDto.setSumMoney(null);
		serviceConsumptionDto.setBalance(null);
		serviceConsumptionDto.setSurplusMoney(null);
		serviceConsumptionDto.setSumPayMoney(null);
		serviceConsumptionDto.setReadyMoney(null);
		serviceConsumptionDto.setCreater(null);
		serviceConsumptionDto.setBelongingUser(null);
		return Navigation.SERVICE_CONSUMPTION;
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【服务消费登陆画面_返回按钮】");
		return serviceConsumptionDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		serviceConsumptionDto.setReturner(returner);
		serviceConsumptionDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.SERVICE_CONSUMPTION;
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_选择付款按钮】");
		if (BigDecimalUtil.isNullOrZero(serviceConsumptionDto.getSumMoney())) {
			Tool.sendErrorMessage("请填写实收金额！");
			return;
		}
		serviceConsumptionDto.setLeaguerMoney(null);
		serviceConsumptionDto.setLeaguerReadyMoney(null);
		serviceConsumptionDto.setRebate(null);
		serviceConsumptionDto.setRebateMoney(null);
		serviceConsumptionDto.setBalance(null);
		// 获取需要付款的总金额
		serviceConsumptionDto.setRealityMoney(serviceConsumptionDto.getSumMoney());
		getSurplusMoney();
		queryMarketingProject();
		List<MarketingProject> marketingProjectList = new ArrayList<MarketingProject>();
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			consumptionRegisterDetail.setConsumptionNumber(0);
			consumptionRegisterDetail.setTypes(null);
			marketingProjectList.add(consumptionRegisterDetail.getMarketingProject());
		}
		// 获取下拉框
		List<CustomLeaguerDetail> customLeaguerDetailList = serviceConsumptionDto.getCustomLeaguerDetailList();
		if (customLeaguerDetailList != null && !customLeaguerDetailList.isEmpty()) {
			int size = customLeaguerDetailList.size();
			SelectItem[] customLeaguerDetailItems = new SelectItem[size];
			for (int i = 0; i < size; i++) {
				CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailList.get(i);
				String name = "";
				if (customLeaguerDetail.getLeaguer() != null) {
					name = customLeaguerDetail.getLeaguer().getLabel() + "-折扣：" + customLeaguerDetail.getRebate().toString() + "   卡余额：" + customLeaguerDetail.getMoney() + "￥";
				} else {
					name = customLeaguerDetail.getGiveInfo().getLabel() + "-折扣：" + (customLeaguerDetail.getRebate() == null ? "10.0" : customLeaguerDetail.getRebate().toEngineeringString()) + "   卡余额：" + customLeaguerDetail.getMoney() + "￥";
				}
				customLeaguerDetailItems[i] = new SelectItem(customLeaguerDetail.getId().toString(), name);
			}
			CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailList.get(0);
			serviceConsumptionDto.setLeaguerMoney(customLeaguerDetail.getMoney());
			// 获取卡项折扣
			
			BigDecimal rebate = customLeaguerDetail.getRebate();
			if (BigDecimalUtil.isNullOrZero(rebate)) {
				rebate = new BigDecimal("10.0");
			}
			BigDecimal rebateMoney = Constants.BIGDECIMAL_ZERO;
			if (customLeaguerDetail.getLeaguer() != null && !marketingProjectList.isEmpty()) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LeaguerDetail.class);
				detachedCriteria.createAlias(LeaguerDetail.MARKETING_PROJECT, LeaguerDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.eq(LeaguerDetail.LEAGUER, customLeaguerDetail.getLeaguer()));
				detachedCriteria.add(Restrictions.in(LeaguerDetail.MARKETING_PROJECT, marketingProjectList));
				List<LeaguerDetail> leaguerDetailList = leaguerDetailService.getByDetachedCriteria(detachedCriteria);
				for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
					for (LeaguerDetail leaguerDetail : leaguerDetailList) {
						if (consumptionRegisterDetail.getMarketingProject().equals(leaguerDetail.getMarketingProject())) {
							BigDecimal rebate2 = leaguerDetail.getRebate();
							if (BigDecimalUtil.isNullOrZero(rebate2)) {
								rebate2 = rebate;
							}
							consumptionRegisterDetail.setRebate(rebate2);
							break;
						}
					}
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(consumptionRegisterDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), consumptionRegisterDetail.getSumMoney()));
				}
			} else {
				for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
					consumptionRegisterDetail.setRebate(rebate);
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(consumptionRegisterDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), consumptionRegisterDetail.getSumMoney()));
				}
			}
			
			serviceConsumptionDto.setRebate(rebate);
			serviceConsumptionDto.setCustomLeaguerDetailId(customLeaguerDetail.getId().toString());
			serviceConsumptionDto.setCustomLeaguerDetailItems(customLeaguerDetailItems);
			
			serviceConsumptionDto.setRebateMoney(rebateMoney);
			
			serviceConsumptionDto.setSurplusMoney(serviceConsumptionDto.getRebateMoney());
		}
		// 清空必要的数据
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_确认付款按钮】");
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
		if (consumptionRegisterDetailList == null || consumptionRegisterDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须选择消费项目！");
			return;
		}
		// 验证不能多付款
		if (BigDecimalUtil.bigThan(serviceConsumptionDto.getSumPayMoney(), serviceConsumptionDto.getRebateMoney())) {
			Tool.sendErrorMessage("大于付款金额请确认！");
			return;
		}
		
		serviceConsumptionDto.setCreater(userBean.getUser());
		serviceConsumptionDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		serviceConsumptionDto.setState(true);
		ConsumptionRegister consumptionRegister = new ConsumptionRegister();
		ServiceConsumptionDxo.dtoToEntity(serviceConsumptionDto, consumptionRegister);
		consumptionRegister.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		consumptionRegister.setType(ConsumptionRegister.TYPE_5);
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			consumptionRegisterDetail.setConsumptionRegister(consumptionRegister);
			consumptionRegisterDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionRegisterDetail.setCreater(userBean.getUser());
			consumptionRegisterDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		}
		CustomLeaguerDetail customLeaguerDetail = null;
		if (StringUtil.isNotBlank(serviceConsumptionDto.getCustomLeaguerDetailId())) {
			customLeaguerDetail = customLeaguerDetailService.getById(Integer.valueOf(serviceConsumptionDto.getCustomLeaguerDetailId()));
			customLeaguerDetail.setReadyMoney(serviceConsumptionDto.getLeaguerReadyMoney());
			// 记录此次消费折扣
			consumptionRegister.setRebate(customLeaguerDetail.getRebate());
		} else {
			// 记录此次消费折扣
			consumptionRegister.setRebate(new BigDecimal("10.0"));
		}
		
		try {
			consumptionRegisterService.savePay(
					consumptionRegister,
					serviceConsumptionDto.getRebateMoney(),
					consumptionRegisterDetailList,
					serviceConsumptionDto.getBalance(),
					serviceConsumptionDto.getReadyMoney(),
					customLeaguerDetail);
		} catch (ConsumptionException e) {
			Tool.sendErrorMessage(e.getMessage());
			return;
		}
		newServiceConsumption();
		Tool.sendErrorMessage("付款成功！");
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		serviceConsumptionDto.setMoney(serviceConsumptionDto.getCustomInfo().getMoney());
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, serviceConsumptionDto.getCustomInfo()));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.LEAGUER));
		serviceConsumptionDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的选择服务项目按钮 
	 * @return 画面不跳转
	 */
	public void selectMarketingProject() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_选择服务项目按钮】");
		serviceConsumptionDto.setCurrentPage(1);
		fetchData(serviceConsumptionDto.getCurrentPage());
	}
	
	/**
	 * 上一页
	 */
	public void upPage() {
		int currentPage = serviceConsumptionDto.getCurrentPage(); 
		currentPage -= 1;
		fetchData(currentPage);
		serviceConsumptionDto.setCurrentPage(currentPage);
	}
	
	/**
	 * 下一页
	 */
	public void nextPage() {
		int currentPage = serviceConsumptionDto.getCurrentPage(); 
		currentPage += 1;
		fetchData(currentPage);
		serviceConsumptionDto.setCurrentPage(currentPage);
	}

	private void fetchData(int currentPage) {
		int start = (currentPage - 1) * serviceConsumptionDto.getOnePageCount();
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingProject.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String marketingProjectName = serviceConsumptionDto.getMarketingProjectName();
		if (StringUtil.isNotBlank(marketingProjectName)) {
			detachedCriteria.add(Restrictions.like(MarketingProject.PROJECT, marketingProjectName, MatchMode.ANYWHERE));
		}
		serviceConsumptionDto.setMarketingProjectList(marketingProjectService.getByDetachedCriteria(detachedCriteria, start, serviceConsumptionDto.getOnePageCount()));
		serviceConsumptionDto.init(marketingProjectService.getRowCount(detachedCriteria));
		System.out.println(serviceConsumptionDto.getDataCount());
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findMarketingProjects(MarketingProject marketingProject) {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_选择按钮】");
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
		if (consumptionRegisterDetailList == null) {
			consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
			ConsumptionRegisterDetail consumptionRegisterDetail = new ConsumptionRegisterDetail();
			consumptionRegisterDetail.setMarketingProject(marketingProject);
			consumptionRegisterDetail.setNumber(1);
			consumptionRegisterDetailList.add(consumptionRegisterDetail);
			serviceConsumptionDto.setConsumptionRegisterDetailList(consumptionRegisterDetailList);
		} else {
			boolean state = false;
			for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
				state = false;
				if (marketingProject.equals(consumptionRegisterDetail.getMarketingProject())) {
					state = true;
					break;
				}
			}
			if (!state) {
				ConsumptionRegisterDetail consumptionRegisterDetail = new ConsumptionRegisterDetail();
				consumptionRegisterDetail.setMarketingProject(marketingProject);
				consumptionRegisterDetail.setNumber(1);
				consumptionRegisterDetailList.add(consumptionRegisterDetail);
			}
		}
		serviceConsumptionDto.getMarketingProjectList().remove(marketingProject);
		getSumMoney();
	}
	
	/**
	 * 此方法绑定于服务消费登记登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteConsumptionRegister(ConsumptionRegisterDetail consumptionRegisterDetail) {
		Tool.sendLog(LOG, userBean, "【服务消费登记登陆画面_删除按钮】");
		if (consumptionRegisterDetail.getId() != null) {
			consumptionRegisterDetailService.deleteEntity(consumptionRegisterDetail);
		}
		serviceConsumptionDto.getConsumptionRegisterDetailList().remove(consumptionRegisterDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于确认并关闭按钮
	 */
	public void queryClose() {
		Tool.sendLog(LOG, userBean, "【服务消费登记登陆画面_确认并关闭按钮按钮】");
		getSumMoney();
	}
	
	/**
	 * 选择卡项后计算出的总金额
	 */
	public void getSumMoney() {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
		BigDecimal sum = Constants.BIGDECIMAL_ZERO;
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			consumptionRegisterDetail.setMoney(consumptionRegisterDetail.getSumMoney());
			sum = BigDecimalUtil.add(sum, consumptionRegisterDetail.getMoney());
		}
		serviceConsumptionDto.setRealityMoney(sum);
		serviceConsumptionDto.setSumMoney(sum);
	}
	
	/**
	 * 获取付款后，计算出还需要付款的金额
	 */
	public void getSurplusMoney() {
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		// 获取充值卡付款记录
		if (BigDecimalUtil.isNotNullOrZero(serviceConsumptionDto.getBalance())) {
			sumMoney = BigDecimalUtil.add(sumMoney, serviceConsumptionDto.getBalance());
		}
		// 获取现金付款记录
		if (BigDecimalUtil.isNotNullOrZero(serviceConsumptionDto.getReadyMoney())) {
			sumMoney = BigDecimalUtil.add(sumMoney, serviceConsumptionDto.getReadyMoney());
		}
		// 获取充值卡付款记录
		BigDecimal leaguerReadyMoney = serviceConsumptionDto.getLeaguerReadyMoney();
		if (BigDecimalUtil.isNotNullOrZero(leaguerReadyMoney)) {
			sumMoney = BigDecimalUtil.add(sumMoney, leaguerReadyMoney);
		}
		// 总金额-已经付款的金额=还需要支付的金额
		serviceConsumptionDto.setSumPayMoney(sumMoney);
		BigDecimal rebateMoney = serviceConsumptionDto.getRebateMoney();
		if (rebateMoney == null) rebateMoney = serviceConsumptionDto.getRealityMoney();
		serviceConsumptionDto.setSurplusMoney(BigDecimalUtil.subtract(rebateMoney, sumMoney));
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的扣除按钮
	 * 实现功能：使用已经拥有的服务项目进行消费扣除
	 */
	public void deductionMarketingProject(ConsumptionRegisterProjectDto consumptionRegisterProjectDto) {
		Tool.sendLog(LOG, userBean, "【服务消费登记登陆画面_扣除按钮】");
		if (consumptionRegisterProjectDto.getNumber() <= 0) {
			Tool.sendErrorMessage("次数已扣完！");
			return;
		}
		
		// 验证需要扣除的项目，是否已经扣除完成
		MarketingProject marketingProject = consumptionRegisterProjectDto.getMarketingProject();
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
		boolean state = false;
		ConsumptionRegisterDetail detail = null;
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			// 找到本次扣除的项目，验证次数是否都已经扣除完成
			if (consumptionRegisterDetail.getMarketingProject().equals(marketingProject)) {
				// 如何项目次数，大于已经扣除的项目次数，那就是代表还可以继续扣除
				if (consumptionRegisterDetail.getNumber() > consumptionRegisterDetail.getConsumptionNumber()) {
					state = true;
					detail = consumptionRegisterDetail;
					break;
				}
			}
		}
		if (state) {
			// 继续扣除项目
			consumptionRegisterProjectDto.setNumber(consumptionRegisterProjectDto.getNumber() - 1);
			int consumptionNumber = detail.getConsumptionNumber();
			consumptionNumber++;
			detail.setConsumptionNumber(consumptionNumber);
			String types = detail.getTypes();
			if (StringUtil.isBlank(types)) {
				detail.setTypes(consumptionRegisterProjectDto.getType().toString());
			} else {
				detail.setTypes(types + Constants.COMMA + consumptionRegisterProjectDto.getType().toString());
			}
			Tool.sendErrorMessage("扣除成功！");
		} else {
			Tool.sendErrorMessage("该项目已扣除，无需在进行扣除，请确认");
		}
		if (detail != null) {
			// 计算还需要付款的费用
			BigDecimal realityMoney = serviceConsumptionDto.getRealityMoney();
			realityMoney = BigDecimalUtil.subtract(realityMoney, detail.getMarketingProject().getMoney());
			serviceConsumptionDto.setRealityMoney(realityMoney);
			// 计算还需要支付的金额
			serviceConsumptionDto.setSurplusMoney(realityMoney);
			// 重新计算折扣金额
			if (!StringUtil.isUnSelected(serviceConsumptionDto.getCustomLeaguerDetailId())) {
				CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailService.getById(Integer.valueOf(serviceConsumptionDto.getCustomLeaguerDetailId()));
				serviceConsumptionDto.setLeaguerMoney(customLeaguerDetail.getMoney());
				serviceConsumptionDto.setRebate(customLeaguerDetail.getRebate() == null ? new BigDecimal("10") : customLeaguerDetail.getRebate());
				// 计算折后金额
				serviceConsumptionDto.setRebateMoney(BigDecimalUtil.multiply(serviceConsumptionDto.getRealityMoney(), BigDecimalUtil.divide(serviceConsumptionDto.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP)));
				
				serviceConsumptionDto.setSurplusMoney(serviceConsumptionDto.getRebateMoney());
			}
		}
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的已有服务扣除按钮 
	 * @return 画面不跳转
	 */
	private void queryMarketingProject() {
		List<ConsumptionRegisterProjectDto> list = new ArrayList<ConsumptionRegisterProjectDto>();
		ConsumptionRegisterProjectDto dto;
		// 获取所有当前客户已拥有的项目
		CustomInfo customInfo = serviceConsumptionDto.getCustomInfo();
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
		if (consumptionRegisterDetailList == null || consumptionRegisterDetailList.isEmpty()) {
			return;
		}
		List<MarketingProject> marketingProjectList = new ArrayList<MarketingProject>();
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			marketingProjectList.add(consumptionRegisterDetail.getMarketingProject());
		}
		// 查询项目赠送记录
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.gt(LargessRecord.SURPLUS_NUMBER, 0));
		detachedCriteria.add(Restrictions.in(LargessRecord.MARKETING_PROJECT, marketingProjectList));
		detachedCriteria.add(Restrictions.eq(LargessRecord.CUSTOM_INFO, customInfo));
		List<LargessRecord> largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria);
		// 重复累加
		Map<MarketingProject, Integer> largessRecordMaps = new HashMap<MarketingProject, Integer>();
		for (LargessRecord largessRecord : largessRecordList) {
			Integer sum = largessRecordMaps.get(largessRecord.getMarketingProject());
			if (sum == null) {
				largessRecordMaps.put(largessRecord.getMarketingProject(), largessRecord.getSurplusNumber());
			} else {
				largessRecordMaps.put(largessRecord.getMarketingProject(), (sum + largessRecord.getSurplusNumber()));
			}
		}
		for (Entry<MarketingProject, Integer> maps : largessRecordMaps.entrySet()) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setType(ConsumptionRegisterProjectDto.TYPE_2);
			dto.setMarketingProject(maps.getKey());
			dto.setNumber(maps.getValue());
			list.add(dto);
		}
		// 查询套餐购买记录
		detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.in(MealBuyRecordDetail.MARKETING_PROJECT, marketingProjectList));
		detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, customInfo));
		detachedCriteria.add(Restrictions.gt(MealBuyRecordDetail.SURPLUS_NUMBER, 0));
		List<MealBuyRecordDetail> mealBuyRecordDetailList = mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria);
		// 重复累加
		Map<MarketingProject, Integer> mealBuyRecordDetailMaps = new HashMap<MarketingProject, Integer>();
		for (MealBuyRecordDetail mealBuyRecordDetail : mealBuyRecordDetailList) {
			Integer sum = mealBuyRecordDetailMaps.get(mealBuyRecordDetail.getMarketingProject());
			if (sum == null) {
				mealBuyRecordDetailMaps.put(mealBuyRecordDetail.getMarketingProject(), mealBuyRecordDetail.getSurplusNumber());
			} else {
				mealBuyRecordDetailMaps.put(mealBuyRecordDetail.getMarketingProject(), (sum + mealBuyRecordDetail.getSurplusNumber()));
			}
		}
		for (Entry<MarketingProject, Integer> maps : mealBuyRecordDetailMaps.entrySet()) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setType(ConsumptionRegisterProjectDto.TYPE_3);
			dto.setMarketingProject(maps.getKey());
			dto.setNumber(maps.getValue());
			list.add(dto);
		}
		// 项目购买记录
		detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.in(ProjectBuyDetail.MARKETING_PROJECT, marketingProjectList));
		detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, customInfo));
		detachedCriteria.add(Restrictions.gt(ProjectBuyDetail.SURPLUS_NUMBER, 0));
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyDetailService.getByDetachedCriteria(detachedCriteria);
		// 重复累加
		Map<MarketingProject, Integer> projectBuyDetailMaps = new HashMap<MarketingProject, Integer>();
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			Integer sum = projectBuyDetailMaps.get(projectBuyDetail.getMarketingProject());
			if (sum == null) {
				projectBuyDetailMaps.put(projectBuyDetail.getMarketingProject(), projectBuyDetail.getSurplusNumber());
			} else {
				projectBuyDetailMaps.put(projectBuyDetail.getMarketingProject(), (sum + projectBuyDetail.getSurplusNumber()));
			}
		}
		for (Entry<MarketingProject, Integer> maps : projectBuyDetailMaps.entrySet()) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setType(ConsumptionRegisterProjectDto.TYPE_4);
			dto.setMarketingProject(maps.getKey());
			dto.setNumber(maps.getValue());
			list.add(dto);
		}
		serviceConsumptionDto.setConsumptionRegisterProjectDtoList(list);
	}
	
	/**
	 * 选择后付款的卡项后，获取到卡项的最大输入额度
	 */
	public void getLeaguerMoney() {
		String customLeaguerDetailId = serviceConsumptionDto.getCustomLeaguerDetailId();
		if (!StringUtil.isUnSelected(customLeaguerDetailId)) {
			CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailService.getById(Integer.valueOf(customLeaguerDetailId));
			
			// 获取卡项折扣
			BigDecimal rebate = customLeaguerDetail.getRebate();
			if (BigDecimalUtil.isNullOrZero(rebate)) {
				rebate = new BigDecimal("10.0");
			}
			BigDecimal rebateMoney = Constants.BIGDECIMAL_ZERO;
			
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList = serviceConsumptionDto.getConsumptionRegisterDetailList();
			List<MarketingProject> marketingProjectList = new ArrayList<MarketingProject>();
			for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
				marketingProjectList.add(consumptionRegisterDetail.getMarketingProject());
			}
			
			if (customLeaguerDetail.getLeaguer() != null && !marketingProjectList.isEmpty()) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LeaguerDetail.class);
				detachedCriteria.createAlias(LeaguerDetail.MARKETING_PROJECT, LeaguerDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.eq(LeaguerDetail.LEAGUER, customLeaguerDetail.getLeaguer()));
				detachedCriteria.add(Restrictions.in(LeaguerDetail.MARKETING_PROJECT, marketingProjectList));
				List<LeaguerDetail> leaguerDetailList = leaguerDetailService.getByDetachedCriteria(detachedCriteria);
				for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
					for (LeaguerDetail leaguerDetail : leaguerDetailList) {
						if (consumptionRegisterDetail.getMarketingProject().equals(leaguerDetail.getMarketingProject())) {
							BigDecimal rebate2 = leaguerDetail.getRebate();
							if (BigDecimalUtil.isNullOrZero(rebate2)) {
								rebate2 = rebate;
							}
							consumptionRegisterDetail.setRebate(rebate2);
							break;
						}
					}
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(consumptionRegisterDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), consumptionRegisterDetail.getSumMoney()));
				}
			} else {
				for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
					consumptionRegisterDetail.setRebate(rebate);
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(consumptionRegisterDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), consumptionRegisterDetail.getSumMoney()));
				}
			}
			
			
			serviceConsumptionDto.setRebate(rebate);
			serviceConsumptionDto.setLeaguerMoney(customLeaguerDetail.getMoney());
			// 计算折后金额
			serviceConsumptionDto.setRebateMoney(rebateMoney);
			serviceConsumptionDto.setSurplusMoney(serviceConsumptionDto.getRebateMoney());
		}
	}
	
	/**
	 * @param leaguerDetailService the leaguerDetailService to set
	 */
	public void setLeaguerDetailService(LeaguerDetailService leaguerDetailService) {
		this.leaguerDetailService = leaguerDetailService;
	}

	/**
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}

	/**
	 * @param mealBuyRecordDetailService the mealBuyRecordDetailService to set
	 */
	public void setMealBuyRecordDetailService(
			MealBuyRecordDetailService mealBuyRecordDetailService) {
		this.mealBuyRecordDetailService = mealBuyRecordDetailService;
	}

	/**
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(
			ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * @param consumptionRegisterDetailService the consumptionRegisterDetailService to set
	 */
	public void setConsumptionRegisterDetailService(
			ConsumptionRegisterDetailService consumptionRegisterDetailService) {
		this.consumptionRegisterDetailService = consumptionRegisterDetailService;
	}

	/**
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(
			MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * set consumptionRegisterService
	 * @param consumptionRegisterService the consumptionRegisterService to set
	 */
	public void setConsumptionRegisterService(ConsumptionRegisterService consumptionRegisterService) {
		this.consumptionRegisterService = consumptionRegisterService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get serviceConsumptionDto
	 * @return the serviceConsumptionDto
	 */
	public ServiceConsumptionDto getServiceConsumptionDto() {
		return serviceConsumptionDto;
	}

	/**
	 * set serviceConsumptionDto
	 * @param serviceConsumptionDto the serviceConsumptionDto to set
	 */
	public void setServiceConsumptionDto(ServiceConsumptionDto serviceConsumptionDto) {
		this.serviceConsumptionDto = serviceConsumptionDto;
	}

}
