package com.qylm.bean.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.dto.history.HistoryFeedbackRecordCreateDto;
import com.qylm.dxo.HistoryFeedbackRecordCreateDxo;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.FeedbackRecord;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.service.FeedbackRecordService;
import com.qylm.service.LargessRecordService;
import com.qylm.service.MealBuyRecordService;
import com.qylm.service.ProductStockService;
import com.qylm.service.ProjectBuyDetailService;
import com.qylm.service.TemporaryActivityDetailService;

/**
 * 客户反馈记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryFeedbackRecordCreateBean implements Serializable, CreateBean<FeedbackRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -305353080427327147L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(HistoryFeedbackRecordCreateBean.class);

	/**
	 * 存放客户反馈记录登陆画面需要保存的值
	 */
	private HistoryFeedbackRecordCreateDto historyFeedbackRecordCreateDto = new HistoryFeedbackRecordCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 客户反馈记录业务类
	 */
	@ManagedProperty(value="#{feedbackRecordService}")
	private FeedbackRecordService feedbackRecordService;
	
	/**
	 * 赠送项目记录业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 套餐购买记录业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordService}")
	private MealBuyRecordService mealBuyRecordService;
	
	/**
	 * 活动套餐详细记录业务类
	 */
	@ManagedProperty(value="#{temporaryActivityDetailService}")
	private TemporaryActivityDetailService temporaryActivityDetailService;
	
	/**
	 * 项目购买详细记录业务类
	 */
	@ManagedProperty(value="#{projectBuyDetailService}")
	private ProjectBuyDetailService projectBuyDetailService;
	
	/**
	 * 产品信息业务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 * 此方法绑定于客户反馈记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 客户反馈记录登陆画面
	 */
	public String newFeedbackRecord() {
		Tool.sendLog(LOG, userBean, "【客户反馈记录登陆画面_新建按钮】");
		historyFeedbackRecordCreateDto.setCustomInfo(null);
		historyFeedbackRecordCreateDto.setDate(DateUtil.getNowyyyymmdd());
		historyFeedbackRecordCreateDto.setRemark(null);
		historyFeedbackRecordCreateDto.setMarketingProject(null);
		historyFeedbackRecordCreateDto.setProductStock(null);
		historyFeedbackRecordCreateDto.setPersonnelInfo(null);
		historyFeedbackRecordCreateDto.setAdviser(null);
		historyFeedbackRecordCreateDto.setCreater(null);
		historyFeedbackRecordCreateDto.setBelongingUser(null);
		historyFeedbackRecordCreateDto.setTransferFeedbackRecord(null);
		return Navigation.HISTORY_FEEDBACK_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于客户反馈记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户反馈记录登陆画面_返回按钮】");
		return historyFeedbackRecordCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于客户反馈记录登陆画面的保存按钮 
	 * 实现功能：根据transferFeedbackRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveFeedbackRecord() {
		Tool.sendLog(LOG, userBean, "【客户反馈记录登陆画面_保存按钮】");
		FeedbackRecord transferFeedbackRecord = historyFeedbackRecordCreateDto.getTransferFeedbackRecord();
		if (transferFeedbackRecord == null) {
			transferFeedbackRecord = new FeedbackRecord();
			historyFeedbackRecordCreateDto.setCreater(userBean.getUser());
			historyFeedbackRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferFeedbackRecord);
			transferFeedbackRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			feedbackRecordService.saveEntity(transferFeedbackRecord);
			historyFeedbackRecordCreateDto.setTransferFeedbackRecord(transferFeedbackRecord);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferFeedbackRecord);
			transferFeedbackRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			feedbackRecordService.updateEntity(transferFeedbackRecord);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferFeedbackRecord
	 */
	private void create(FeedbackRecord transferFeedbackRecord) {
		HistoryFeedbackRecordCreateDxo.dtoToEntity(historyFeedbackRecordCreateDto, transferFeedbackRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		historyFeedbackRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		historyFeedbackRecordCreateDto.setCreater(userBean.getUser());
		historyFeedbackRecordCreateDto.setReturner(returner);
		return Navigation.HISTORY_FEEDBACK_RECORD_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, FeedbackRecord feedbackRecord) {
		historyFeedbackRecordCreateDto.setReturner(returner);
		historyFeedbackRecordCreateDto.setTransferFeedbackRecord(feedbackRecord);
		HistoryFeedbackRecordCreateDxo.entityToDto(feedbackRecord, historyFeedbackRecordCreateDto);
		return Navigation.HISTORY_FEEDBACK_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于客户反馈登陆画面的选择产品按钮 
	 * @return 画面不跳转
	 */
	public void findProductStock() {
		Tool.sendLog(LOG, userBean, "按下【客户反馈登陆画面_选择产品按钮】");
		select();
	}
	
	private void select() {
		CustomInfo customInfo = historyFeedbackRecordCreateDto.getCustomInfo();
		if (customInfo == null) {
			Tool.sendErrorMessage("客户档案必须选择");
			return;
		}
		// 查询出当前客户购买的产品记录
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		List<ProductStock> productStockList = productStockService.getByDetachedCriteria(detachedCriteria);
		historyFeedbackRecordCreateDto.setProductStockList(productStockList);
	}
	
	/**
	 * 此方法绑定于客户反馈登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findProductStocks(ProductStock productStock) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈登陆画面_选择按钮】");
		historyFeedbackRecordCreateDto.setProductStock(productStock);
	}
	
	/**
	 * 此方法绑定于客户反馈登陆画面的项目按钮 
	 * @return 画面不跳转
	 */
	public void findMarketingProject() {
		Tool.sendLog(LOG, userBean, "按下【客户反馈登陆画面_选择已购买的项目按钮】");
		CustomInfo customInfo = historyFeedbackRecordCreateDto.getCustomInfo();
		if (customInfo == null) {
			Tool.sendErrorMessage("客户档案必须选择");
			return;
		}
		Map<Integer, MarketingProject> maps = new HashMap<Integer, MarketingProject>();
		// 查询项目赠送记录
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(LargessRecord.CUSTOM_INFO, customInfo));
		List<LargessRecord> largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria);
		for (LargessRecord largessRecord : largessRecordList) {
			maps.put(largessRecord.getMarketingProject().getId(), largessRecord.getMarketingProject());
		}
		// 查询套餐购买记录
		detachedCriteria = DetachedCriteria.forClass(MealBuyRecord.class);
		detachedCriteria.createAlias(MealBuyRecord.CUSTOMINFO, MealBuyRecord.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.TEMPORARY_ACTIVITY, MealBuyRecord.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MealBuyRecord.CUSTOMINFO, customInfo));
		List<MealBuyRecord> mealBuyRecordList = mealBuyRecordService.getByDetachedCriteria(detachedCriteria);
		List<TemporaryActivity> temporaryActivityList = new ArrayList<TemporaryActivity>();
		
		if (!temporaryActivityList.isEmpty()) {
			for (MealBuyRecord mealBuyRecord : mealBuyRecordList) {
				temporaryActivityList.add(mealBuyRecord.getTemporaryActivity());
			}
			detachedCriteria = DetachedCriteria.forClass(TemporaryActivityDetail.class);
			detachedCriteria.createAlias(TemporaryActivityDetail.MARKETING_PROJECT, TemporaryActivityDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(TemporaryActivityDetail.TEMPORARY_ACTIVITY, TemporaryActivityDetail.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(TemporaryActivityDetail.TEMPORARY_ACTIVITY, temporaryActivityList));
			List<TemporaryActivityDetail> temporaryActivityDetailList = temporaryActivityDetailService.getByDetachedCriteria(detachedCriteria);
			for (TemporaryActivityDetail temporaryActivityDetail : temporaryActivityDetailList) {
				maps.put(temporaryActivityDetail.getMarketingProject().getId(), temporaryActivityDetail.getMarketingProject());
			}
		}
		
		// 项目购买记录
		detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, customInfo));
		List<ProjectBuyDetail> projectBuyDetailList = projectBuyDetailService.getByDetachedCriteria(detachedCriteria);
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			maps.put(projectBuyDetail.getMarketingProject().getId(), projectBuyDetail.getMarketingProject());
		}
		List<MarketingProject> marketingProjectList = new ArrayList<MarketingProject>();
		for (Entry<Integer, MarketingProject> map : maps.entrySet()) {
			marketingProjectList.add(map.getValue());
		}
		historyFeedbackRecordCreateDto.setMarketingProjectList(marketingProjectList);
	}
	
	/**
	 * 此方法绑定于客户反馈登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findMarketingProjects(MarketingProject marketingProject) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈登陆画面_选择按钮】");
		historyFeedbackRecordCreateDto.setMarketingProject(marketingProject);
	}
	
	/**
	 * @param productStockService the productStockService to set
	 */
	public void setProductStockService(ProductStockService productStockService) {
		this.productStockService = productStockService;
	}

	/**
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(
			ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * @param temporaryActivityDetailService the temporaryActivityDetailService to set
	 */
	public void setTemporaryActivityDetailService(
			TemporaryActivityDetailService temporaryActivityDetailService) {
		this.temporaryActivityDetailService = temporaryActivityDetailService;
	}

	/**
	 * @param mealBuyRecordService the mealBuyRecordService to set
	 */
	public void setMealBuyRecordService(MealBuyRecordService mealBuyRecordService) {
		this.mealBuyRecordService = mealBuyRecordService;
	}

	/**
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}

	/**
	 * set feedbackRecordService
	 * @param feedbackRecordService the feedbackRecordService to set
	 */
	public void setFeedbackRecordService(FeedbackRecordService feedbackRecordService) {
		this.feedbackRecordService = feedbackRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get historyFeedbackRecordCreateDto
	 * @return the historyFeedbackRecordCreateDto
	 */
	public HistoryFeedbackRecordCreateDto getHistoryFeedbackRecordCreateDto() {
		return historyFeedbackRecordCreateDto;
	}

	/**
	 * set historyFeedbackRecordCreateDto
	 * @param historyFeedbackRecordCreateDto the historyFeedbackRecordCreateDto to set
	 */
	public void setHistoryFeedbackRecordCreateDto(HistoryFeedbackRecordCreateDto historyFeedbackRecordCreateDto) {
		this.historyFeedbackRecordCreateDto = historyFeedbackRecordCreateDto;
	}

}
