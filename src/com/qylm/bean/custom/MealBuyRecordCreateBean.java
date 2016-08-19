package com.qylm.bean.custom;

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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.custom.MealBuyRecordCreateDto;
import com.qylm.dxo.MealBuyRecordCreateDxo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.MealBuyRecordService;
import com.qylm.service.TemporaryActivityDetailService;
import com.qylm.service.TemporaryActivityService;

/**
 * 套餐购买记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class MealBuyRecordCreateBean implements Serializable, CreateBean<MealBuyRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4457576362917892172L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MealBuyRecordCreateBean.class);

	/**
	 * 存放套餐购买记录登陆画面需要保存的值
	 */
	private MealBuyRecordCreateDto mealBuyRecordCreateDto = new MealBuyRecordCreateDto();
	
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
	 * 客户档案与卡项业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 此方法绑定于套餐购买记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 套餐购买记录登陆画面
	 */
	public String newMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "【套餐购买记录登陆画面_新建按钮】");
		mealBuyRecordCreateDto.setCustomInfo(null);
		mealBuyRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		mealBuyRecordCreateDto.setPersonnelInfo(null);
		mealBuyRecordCreateDto.setAdviser(null);
		mealBuyRecordCreateDto.setNumber(null);
		mealBuyRecordCreateDto.setRealityMoney(null);
		mealBuyRecordCreateDto.setSumMoney(null);
		mealBuyRecordCreateDto.setMealBuyRecordDetailList(null);
		mealBuyRecordCreateDto.setTemporaryActivity(null);
		mealBuyRecordCreateDto.setTemporaryActivityName(null);
		mealBuyRecordCreateDto.setCreater(null);
		mealBuyRecordCreateDto.setBelongingUser(null);
		mealBuyRecordCreateDto.setTransferMealBuyRecord(null);
		mealBuyRecordCreateDto.setState(false);
		return Navigation.MEAL_BUY_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于套餐购买记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【套餐购买记录登陆画面_返回按钮】");
		return mealBuyRecordCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于套餐购买记录登陆画面的保存按钮 
	 * 实现功能：根据transferMealBuyRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "【套餐购买记录登陆画面_保存按钮】");
		MealBuyRecord transferMealBuyRecord = mealBuyRecordCreateDto.getTransferMealBuyRecord();
		if (transferMealBuyRecord == null) {
			transferMealBuyRecord = new MealBuyRecord();
			mealBuyRecordCreateDto.setCreater(userBean.getUser());
			mealBuyRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferMealBuyRecord);
			transferMealBuyRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			mealBuyRecordService.saveMealBuyRecord(transferMealBuyRecord, mealBuyRecordCreateDto.getMealBuyRecordDetailList());
			mealBuyRecordCreateDto.setTransferMealBuyRecord(transferMealBuyRecord);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferMealBuyRecord);
			transferMealBuyRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			mealBuyRecordService.updateMealBuyRecord(transferMealBuyRecord, mealBuyRecordCreateDto.getMealBuyRecordDetailList());
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferMealBuyRecord
	 */
	private void create(MealBuyRecord transferMealBuyRecord) {
		List<MealBuyRecordDetail> detailList = mealBuyRecordCreateDto.getMealBuyRecordDetailList();
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
		MealBuyRecordCreateDxo.dtoToEntity(mealBuyRecordCreateDto, transferMealBuyRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		mealBuyRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		mealBuyRecordCreateDto.setCreater(userBean.getUser());
		mealBuyRecordCreateDto.setReturner(returner);
		return Navigation.MEAL_BUY_RECORD_CREATE;
	}
	
	//跳转到客户历史套餐记录的页面
	public String newCreateC(Returner<?, ?, ?> returner) {
		mealBuyRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		mealBuyRecordCreateDto.setCreater(userBean.getUser());
		mealBuyRecordCreateDto.setReturner(returner);
		return Navigation.HISTORY_TEMPORARY_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, MealBuyRecord mealBuyRecord) {
		mealBuyRecordCreateDto.setReturner(returner);
		MealBuyRecordCreateDxo.entityToDto(mealBuyRecord, mealBuyRecordCreateDto);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
		detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD, mealBuyRecord));
		mealBuyRecordCreateDto.setMealBuyRecordDetailList(mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.MEAL_BUY_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于套餐购买记录登陆画面的选择临时套餐按钮 
	 * @return 画面不跳转
	 */
	public void findTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "【套餐购买记录登陆画面_选择临时套餐按钮】");
		selectTemporaryActivityInfo();
	}
	
	/**
	 * 此方法绑定于套餐购买记录登陆画面的搜索按钮 
	 * @return 画面不跳转
	 */
	public void select() {
		Tool.sendLog(LOG, userBean, "【套餐购买记录登陆画面_搜索按钮】");
		selectTemporaryActivityInfo();
	}
	
	/**
	 * 此方法绑定于套餐购买记录登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void selectTemporaryActivity(TemporaryActivity temporaryActivity) {
		Tool.sendLog(LOG, userBean, "【套餐购买记录登陆画面_选择按钮】");
		mealBuyRecordCreateDto.setTemporaryActivity(temporaryActivity);
		getTemporaryActivityDetail(temporaryActivity);
		mealBuyRecordCreateDto.setNumber(1);
		getSumMoney();
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
		mealBuyRecordCreateDto.setMealBuyRecordDetailList(mealBuyRecordDetailList);
	}

	/**
	 * 查询出临时套餐信息，只取十条
	 */
	private void selectTemporaryActivityInfo() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TemporaryActivity.class);
		detachedCriteria.add(Restrictions.eq(TemporaryActivity.STATE, true));
		String temporaryActivityName = mealBuyRecordCreateDto.getTemporaryActivityName();
		if (StringUtil.isNotBlank(temporaryActivityName)) {
			detachedCriteria.add(Restrictions.like(TemporaryActivity.NAME, temporaryActivityName, MatchMode.ANYWHERE));
		}
		temporaryActivityList = temporaryActivityService.getByDetachedCriteria(detachedCriteria, 0, 10);
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_选择付款按钮】");
		BigDecimal money = mealBuyRecordCreateDto.getCustomInfo().getMoney();
		if (BigDecimalUtil.bigThan(money, mealBuyRecordCreateDto.getRealityMoney())) {
			mealBuyRecordCreateDto.setBalance(mealBuyRecordCreateDto.getRealityMoney());
		} else {
			mealBuyRecordCreateDto.setBalance(money);
		}
		getSurplusMoney();
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_确认付款按钮】");
		List<MealBuyRecordDetail> mealBuyRecordDetailList = mealBuyRecordCreateDto.getMealBuyRecordDetailList();
		if (mealBuyRecordDetailList == null || mealBuyRecordDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须选择套餐");
			return;
		}
		// 验证付款金额是否超出了需要支付的金额
		if (BigDecimalUtil.bigThan(mealBuyRecordCreateDto.getSumReadyMoney(), mealBuyRecordCreateDto.getRealityMoney())) {
			Tool.sendErrorMessage("多付钱了，请确认！");
			return;
		}
		mealBuyRecordCreateDto.setCreater(userBean.getUser());
		mealBuyRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		mealBuyRecordCreateDto.setState(true);
		MealBuyRecord mealBuyRecord = new MealBuyRecord();
		MealBuyRecordCreateDxo.dtoToEntity(mealBuyRecordCreateDto, mealBuyRecord);
		for (MealBuyRecordDetail mealBuyRecordDetail : mealBuyRecordDetailList) {
			mealBuyRecordDetail.setCreater(userBean.getUser());
			mealBuyRecordDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			mealBuyRecordDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			mealBuyRecordDetail.setMealBuyRecord(mealBuyRecord);
		}
		mealBuyRecordService.savePay(mealBuyRecord,
				mealBuyRecordCreateDto.getBalance(),
				mealBuyRecordCreateDto.getReadyMoney(),
				mealBuyRecordCreateDto.getCustomLeaguerDetailList(),
				mealBuyRecordDetailList);
		newMealBuyRecord();
		Tool.sendErrorMessage("付款成功！");
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, mealBuyRecordCreateDto.getCustomInfo()));
		// 除体验卡、赠送现金卷、身体卷
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.LEAGUER));
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.LEAGUER));
		mealBuyRecordCreateDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
	}
	
	/**
	 * 选择卡项后计算出的总金额
	 */
	public void getSumMoney() {
		TemporaryActivity temporaryActivity = mealBuyRecordCreateDto.getTemporaryActivity();
		Integer number = mealBuyRecordCreateDto.getNumber() == null ? 1 : mealBuyRecordCreateDto.getNumber();
		BigDecimal sum = BigDecimalUtil.multiply(new BigDecimal(number.toString()), temporaryActivity.getMoney());
		mealBuyRecordCreateDto.setRealityMoney(sum);
		mealBuyRecordCreateDto.setSumMoney(sum);
	}
	
	/**
	 * 获取付款后，计算出还需要付款的金额
	 */
	public void getSurplusMoney() {
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		// 获取充值卡付款记录
		if (BigDecimalUtil.isNotNullOrZero(mealBuyRecordCreateDto.getBalance())) {
			sumMoney = BigDecimalUtil.add(sumMoney, mealBuyRecordCreateDto.getBalance());
		}
		// 获取现金付款记录
		if (BigDecimalUtil.isNotNullOrZero(mealBuyRecordCreateDto.getReadyMoney())) {
			sumMoney = BigDecimalUtil.add(sumMoney, mealBuyRecordCreateDto.getReadyMoney());
		}
		// 获取充值卡付款记录
		List<CustomLeaguerDetail> customLeaguerDetailList = mealBuyRecordCreateDto.getCustomLeaguerDetailList();
		for (CustomLeaguerDetail customLeaguerDetail : customLeaguerDetailList) {
			sumMoney = BigDecimalUtil.add(sumMoney, customLeaguerDetail.getReadyMoney());
		}
		// 总金额-已经付款的金额=还需要支付的金额
		mealBuyRecordCreateDto.setSumReadyMoney(sumMoney);
		mealBuyRecordCreateDto.setSurplusMoney(BigDecimalUtil.subtract(mealBuyRecordCreateDto.getRealityMoney(), sumMoney));
	}
	
	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
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
	 * get mealBuyRecordCreateDto
	 * @return the mealBuyRecordCreateDto
	 */
	public MealBuyRecordCreateDto getMealBuyRecordCreateDto() {
		return mealBuyRecordCreateDto;
	}

	/**
	 * set mealBuyRecordCreateDto
	 * @param mealBuyRecordCreateDto the mealBuyRecordCreateDto to set
	 */
	public void setMealBuyRecordCreateDto(MealBuyRecordCreateDto mealBuyRecordCreateDto) {
		this.mealBuyRecordCreateDto = mealBuyRecordCreateDto;
	}

}
