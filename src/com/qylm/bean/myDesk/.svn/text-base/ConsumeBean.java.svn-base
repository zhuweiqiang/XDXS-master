package com.qylm.bean.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.custom.ConsumptionRegisterProjectDto;
import com.qylm.dto.myDesk.ConsumeDto;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.FeedbackRecord;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.service.ConsumptionRegisterService;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.FeedbackRecordService;
import com.qylm.service.LargessRecordService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.ProjectBuyDetailService;

/**
 * 消费登记登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ConsumeBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2040497582627742403L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ConsumeBean.class);

	/**
	 * 存放消费登记登陆画面需要保存的值
	 */
	private ConsumeDto consumeDto = new ConsumeDto();
	
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
	 * 客户反馈业务类
	 */
	@ManagedProperty(value="#{feedbackRecordService}")
	private FeedbackRecordService feedbackRecordService;
	
	/**
	 * 此方法绑定于消费登记登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 消费登记登陆画面
	 */
	public String newConsume() {
		Tool.sendLog(LOG, userBean, "【消费登记登陆画面_新建按钮】");
		return Navigation.CONSUME;
	}
	
	/**
	 * 此方法绑定于消费登记登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【消费登记登陆画面_返回按钮】");
		return consumeDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		consumeDto.setReturner(returner);
		consumeDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.CONSUME;
	}
	
	/**
	 * 此方法绑定于消费登记登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【消费登记登陆画面_选择付款按钮】");
	}
	
	/**
	 * 此方法绑定于消费登记登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【消费登记登陆画面_确认付款按钮】");
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		CustomInfo customInfo = consumeDto.getCustomInfo();
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.addOrder(Order.asc(CustomLeaguerDetail.LEAGUER));
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, customInfo));
		consumeDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
		// 获取当前客户下所拥有的项目
		List<ConsumptionRegisterProjectDto> list = new ArrayList<ConsumptionRegisterProjectDto>();
		ConsumptionRegisterProjectDto dto;
		// 获取所有当前客户已拥有的项目
		// 查询项目赠送记录
		detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(LargessRecord.CUSTOM_INFO, customInfo));
		detachedCriteria.add(Restrictions.gt(LargessRecord.SURPLUS_NUMBER, 0));
		List<LargessRecord> largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria);
		for (LargessRecord largessRecord : largessRecordList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(largessRecord.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_2);
			dto.setMarketingProject(largessRecord.getMarketingProject());
			dto.setNumber(largessRecord.getSurplusNumber());
			list.add(dto);
		}
		// 查询套餐购买记录
		detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.gt(MealBuyRecordDetail.SURPLUS_NUMBER, 0));
		detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, customInfo));
		List<MealBuyRecordDetail> mealBuyRecordDetailList = mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria);
		for (MealBuyRecordDetail mealBuyRecordDetail : mealBuyRecordDetailList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(mealBuyRecordDetail.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_3);
			dto.setMarketingProject(mealBuyRecordDetail.getMarketingProject());
			dto.setNumber(mealBuyRecordDetail.getSurplusNumber());
			list.add(dto);
		}
		// 项目购买记录
		detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.gt(ProjectBuyDetail.SURPLUS_NUMBER, 0));
		detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, customInfo));
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyDetailService.getByDetachedCriteria(detachedCriteria);
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			dto = new ConsumptionRegisterProjectDto();
			dto.setId(projectBuyDetail.getId());
			dto.setType(ConsumptionRegisterProjectDto.TYPE_4);
			dto.setMarketingProject(projectBuyDetail.getMarketingProject());
			dto.setNumber(projectBuyDetail.getSurplusNumber());
			list.add(dto);
		}
		consumeDto.setConsumptionRegisterProjectDtoList(list);
		// 统计出年度消费
		detachedCriteria = DetachedCriteria.forClass(ConsumptionRegister.class);
		detachedCriteria.createAlias(ConsumptionRegister.CUSTOMINFO, ConsumptionRegister.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConsumptionRegister.CUSTOMINFO, customInfo));
		detachedCriteria.add(Restrictions.eq(ConsumptionRegister.STATE, true));
		List<ConsumptionRegister> consumptionRegisterList = consumptionRegisterService.getByDetachedCriteria(detachedCriteria);
		if (!consumptionRegisterList.isEmpty()) {
			BigDecimal sum = Constants.BIGDECIMAL_ZERO;
			for (ConsumptionRegister consumptionRegister : consumptionRegisterList) {
				sum = BigDecimalUtil.add(sum, consumptionRegister.getRealityMoney());
			}
			consumeDto.setYearSumMoney(sum);
		}
		
		// 统计出客户反馈信息
		detachedCriteria = DetachedCriteria.forClass(FeedbackRecord.class);
		detachedCriteria.createAlias(FeedbackRecord.CUSTOM_INFO, FeedbackRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.MARKETING_PROJECT, FeedbackRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.PRODUCT_STOCK, FeedbackRecord.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.PERSONNEL_INFO, FeedbackRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.ADVISER, FeedbackRecord.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(FeedbackRecord.CUSTOM_INFO, customInfo));
		consumeDto.setFeedbackRecordList(feedbackRecordService.getByDetachedCriteria(detachedCriteria));
		
	}
	
	/**
	 * @param feedbackRecordService the feedbackRecordService to set
	 */
	public void setFeedbackRecordService(FeedbackRecordService feedbackRecordService) {
		this.feedbackRecordService = feedbackRecordService;
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
	 * get consumeDto
	 * @return the consumeDto
	 */
	public ConsumeDto getConsumeDto() {
		return consumeDto;
	}

	/**
	 * set consumeDto
	 * @param consumeDto the consumeDto to set
	 */
	public void setConsumeDto(ConsumeDto consumeDto) {
		this.consumeDto = consumeDto;
	}

}
