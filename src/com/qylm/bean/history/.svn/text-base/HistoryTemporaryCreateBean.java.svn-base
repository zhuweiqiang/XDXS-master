package com.qylm.bean.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
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
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.history.HistoryTemporaryCreateDto;
import com.qylm.dxo.HistoryTemporaryCreateDxo;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.MealBuyRecordService;
import com.qylm.service.TemporaryActivityDetailService;
import com.qylm.service.TemporaryActivityService;

/**
 * 客户套餐记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryTemporaryCreateBean implements Serializable, CreateBean<MealBuyRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4326912858183823041L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(HistoryTemporaryCreateBean.class);

	/**
	 * 存放客户套餐记录登陆画面需要保存的值
	 */
	private HistoryTemporaryCreateDto historyTemporaryCreateDto = new HistoryTemporaryCreateDto();
	
	/**
	 * 临时套餐列表
	 */
	private List<TemporaryActivity> temporaryActivityList;
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 套餐购买业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordService}")
	private MealBuyRecordService mealBuyRecordService;
	
	/**
	 * 套餐购买详细业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordDetailService}")
	private MealBuyRecordDetailService mealBuyRecordDetailService;
	
	/**
	 * 临时套餐业务类
	 */
	@ManagedProperty(value="#{temporaryActivityService}")
	private TemporaryActivityService temporaryActivityService;
	
	/**
	 * 临时套餐详细业务类
	 */
	@ManagedProperty(value="#{temporaryActivityDetailService}")
	private TemporaryActivityDetailService temporaryActivityDetailService;
	
	/**
	 * 此方法绑定于客户套餐记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 客户套餐记录登陆画面
	 */
	public String newMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "【客户套餐记录登陆画面_新建按钮】");
		historyTemporaryCreateDto.setCustomInfo(null);
		historyTemporaryCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		historyTemporaryCreateDto.setPersonnelInfo(null);
		historyTemporaryCreateDto.setAdviser(null);
		historyTemporaryCreateDto.setNumber(null);
		historyTemporaryCreateDto.setRealityMoney(null);
		historyTemporaryCreateDto.setMealBuyRecordDetailList(null);
		historyTemporaryCreateDto.setCreater(null);
		historyTemporaryCreateDto.setBelongingUser(null);
		historyTemporaryCreateDto.setTemporaryActivity(null);
		historyTemporaryCreateDto.setTemporaryActivityName(null);
		historyTemporaryCreateDto.setTransferMealBuyRecord(null);
		historyTemporaryCreateDto.setState(false);
		return Navigation.HISTORY_TEMPORARY_CREATE;
	}
	
	/**
	 * 此方法绑定于客户套餐记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户套餐记录登陆画面_返回按钮】");
		return historyTemporaryCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于客户套餐记录登陆画面的保存按钮 
	 * 实现功能：根据transferMealBuyRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "【客户套餐记录登陆画面_保存按钮】");
		MealBuyRecord transferMealBuyRecord = historyTemporaryCreateDto.getTransferMealBuyRecord();
		if (transferMealBuyRecord == null) {
			transferMealBuyRecord = new MealBuyRecord();
			historyTemporaryCreateDto.setCreater(userBean.getUser());
			historyTemporaryCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferMealBuyRecord);
			transferMealBuyRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			mealBuyRecordService.saveMealBuyRecord(transferMealBuyRecord, historyTemporaryCreateDto.getMealBuyRecordDetailList());
			historyTemporaryCreateDto.setTransferMealBuyRecord(transferMealBuyRecord);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferMealBuyRecord);
			transferMealBuyRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			mealBuyRecordService.updateMealBuyRecord(transferMealBuyRecord, historyTemporaryCreateDto.getMealBuyRecordDetailList());
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferMealBuyRecord
	 */
	private void create(MealBuyRecord transferMealBuyRecord) {
		List<MealBuyRecordDetail> detailList = historyTemporaryCreateDto.getMealBuyRecordDetailList();
		if (detailList == null || detailList.isEmpty()) {
			Tool.sendErrorMessage("必须选择套餐");
			return;
		}
		for (MealBuyRecordDetail mealBuyRecordDetail : detailList) {
			mealBuyRecordDetail.setCreater(userBean.getUser());
			mealBuyRecordDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			mealBuyRecordDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			mealBuyRecordDetail.setMealBuyRecord(transferMealBuyRecord);
		}
		HistoryTemporaryCreateDxo.dtoToEntity(historyTemporaryCreateDto, transferMealBuyRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		historyTemporaryCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		historyTemporaryCreateDto.setCreater(userBean.getUser());
		historyTemporaryCreateDto.setReturner(returner);
		return Navigation.HISTORY_TEMPORARY_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, MealBuyRecord mealBuyRecord) {
		historyTemporaryCreateDto.setReturner(returner);
		historyTemporaryCreateDto.setTransferMealBuyRecord(mealBuyRecord);
		HistoryTemporaryCreateDxo.entityToDto(mealBuyRecord, historyTemporaryCreateDto);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD, mealBuyRecord));
		historyTemporaryCreateDto.setMealBuyRecordDetailList(mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.HISTORY_TEMPORARY_CREATE;
	}
	
	/**
	 * 此方法绑定于客户套餐记录登陆画面的选择临时套餐按钮 
	 * @return 画面不跳转
	 */
	public void findTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "【客户套餐记录登陆画面_选择临时套餐按钮】");
		selectTemporaryActivityInfo();
	}
	
	/**
	 * 此方法绑定于客户套餐记录登陆画面的搜索按钮 
	 * @return 画面不跳转
	 */
	public void select() {
		Tool.sendLog(LOG, userBean, "【客户套餐记录登陆画面_搜索按钮】");
		selectTemporaryActivityInfo();
	}
	
	/**
	 * 此方法绑定于客户套餐记录登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void selectTemporaryActivity(TemporaryActivity temporaryActivity) {
		Tool.sendLog(LOG, userBean, "【客户套餐记录登陆画面_选择按钮】");
		historyTemporaryCreateDto.setTemporaryActivity(temporaryActivity);
		getTemporaryActivityDetail(temporaryActivity);
		historyTemporaryCreateDto.setNumber(1);
	}

	/**
	 * 根据临时套餐记录查询出临时套餐详细
	 * @param temporaryActivity
	 */
	private void getTemporaryActivityDetail(TemporaryActivity temporaryActivity) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TemporaryActivityDetail.class);
		detachedCriteria.createAlias(TemporaryActivityDetail.TEMPORARY_ACTIVITY, TemporaryActivityDetail.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(TemporaryActivityDetail.MARKETING_PROJECT, TemporaryActivityDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(TemporaryActivityDetail.TEMPORARY_ACTIVITY, temporaryActivity));
		List<TemporaryActivityDetail> detailList = temporaryActivityDetailService.getByDetachedCriteria(detachedCriteria);
		List<MealBuyRecordDetail> mealBuyRecordDetailList = new ArrayList<MealBuyRecordDetail>();
		MealBuyRecordDetail mealBuyRecordDetail;
		for (TemporaryActivityDetail temporaryActivityDetail : detailList) {
			mealBuyRecordDetail = new MealBuyRecordDetail();
			mealBuyRecordDetail.setMarketingProject(temporaryActivityDetail.getMarketingProject());
			mealBuyRecordDetail.setMoney(temporaryActivityDetail.getMoney());
			mealBuyRecordDetail.setNumber(temporaryActivityDetail.getNumber());
			mealBuyRecordDetail.setSurplusNumber(temporaryActivityDetail.getNumber());
			mealBuyRecordDetailList.add(mealBuyRecordDetail);
		}
		historyTemporaryCreateDto.setMealBuyRecordDetailList(mealBuyRecordDetailList);
	}

	/**
	 * 查询出临时套餐信息，只取十条
	 */
	private void selectTemporaryActivityInfo() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TemporaryActivity.class);
		detachedCriteria.add(Restrictions.eq(TemporaryActivity.STATE, true));
		String temporaryActivityName = historyTemporaryCreateDto.getTemporaryActivityName();
		if (StringUtil.isNotBlank(temporaryActivityName)) {
			detachedCriteria.add(Restrictions.like(TemporaryActivity.NAME, temporaryActivityName, MatchMode.ANYWHERE));
		}
		temporaryActivityList = temporaryActivityService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		
	}
	
	/**
	 * @param temporaryActivityService the temporaryActivityService to set
	 */
	public void setTemporaryActivityService(
			TemporaryActivityService temporaryActivityService) {
		this.temporaryActivityService = temporaryActivityService;
	}

	/**
	 * @param temporaryActivityDetailService the temporaryActivityDetailService to set
	 */
	public void setTemporaryActivityDetailService(
			TemporaryActivityDetailService temporaryActivityDetailService) {
		this.temporaryActivityDetailService = temporaryActivityDetailService;
	}

	/**
	 * @param mealBuyRecordDetailService the mealBuyRecordDetailService to set
	 */
	public void setMealBuyRecordDetailService(
			MealBuyRecordDetailService mealBuyRecordDetailService) {
		this.mealBuyRecordDetailService = mealBuyRecordDetailService;
	}

	/**
	 * set mealBuyRecordService
	 * @param mealBuyRecordService the mealBuyRecordService to set
	 */
	public void setMealBuyRecordService(MealBuyRecordService mealBuyRecordService) {
		this.mealBuyRecordService = mealBuyRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the temporaryActivityList
	 */
	public List<TemporaryActivity> getTemporaryActivityList() {
		return temporaryActivityList;
	}

	/**
	 * @param temporaryActivityList the temporaryActivityList to set
	 */
	public void setTemporaryActivityList(
			List<TemporaryActivity> temporaryActivityList) {
		this.temporaryActivityList = temporaryActivityList;
	}

	/**
	 * get historyTemporaryCreateDto
	 * @return the historyTemporaryCreateDto
	 */
	public HistoryTemporaryCreateDto getHistoryTemporaryCreateDto() {
		return historyTemporaryCreateDto;
	}

	/**
	 * set historyTemporaryCreateDto
	 * @param historyTemporaryCreateDto the historyTemporaryCreateDto to set
	 */
	public void setHistoryTemporaryCreateDto(HistoryTemporaryCreateDto historyTemporaryCreateDto) {
		this.historyTemporaryCreateDto = historyTemporaryCreateDto;
	}

}
