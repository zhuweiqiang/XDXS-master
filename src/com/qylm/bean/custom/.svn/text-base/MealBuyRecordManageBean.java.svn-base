package com.qylm.bean.custom;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.MealBuyRecordManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.MealBuyRecordManageDto;
import com.qylm.entity.MealBuyRecord;
import com.qylm.service.MealBuyRecordService;

/**
 * 套餐购买记录管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class MealBuyRecordManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2052593202108407875L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MealBuyRecordManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private MealBuyRecordManageDto mealBuyRecordManageDto = new MealBuyRecordManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<MealBuyRecord> mealBuyRecordList;
	
	/**
	 * 删除复选框选择的值
	 */
	private MealBuyRecord[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordService}")
	private MealBuyRecordService mealBuyRecordService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_套餐购买记录菜单】");
		fetchData(0, true);
		return Navigation.MEAL_BUY_RECORD_MANAGE;
	}
	
	/**
	 * 此方法绑定于套餐购买记录管理画面的新建按钮 
	 * 实现功能：跳转至套餐购买记录登陆画面，新建一家事件
	 * @return 套餐购买记录登陆画面
	 */
	public String newMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录管理画面_新建按钮】");
		return Tool.getBackBean(MealBuyRecordCreateBean.class).newCreate(new MealBuyRecordManageReturner(mealBuyRecordManageDto, currentPage));
	}
	
	/**
	 * 此方法绑定于套餐购买记录管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至套餐购买记录登陆画面
	 * @return 套餐购买记录登陆画面
	 */
	public String updateMealBuyRecord(MealBuyRecord transferMealBuyRecord) {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录管理画面_修改按钮】");
		return Tool.getBackBean(MealBuyRecordCreateBean.class).updateDetail(new MealBuyRecordManageReturner(mealBuyRecordManageDto, currentPage), transferMealBuyRecord);
	}
	
	/**
	 * 此方法绑定于套餐购买记录管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectMealBuyRecord() {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于套餐购买记录管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<MealBuyRecord> asList = Arrays.asList(selectedModels);
			mealBuyRecordService.deleteEntityAll(asList);
			mealBuyRecordList.removeAll(asList);
			removeData(1, mealBuyRecordList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于套餐购买记录管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteMealBuyRecord(MealBuyRecord transferMealBuyRecord) {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录管理画面的_删除按钮】");
		mealBuyRecordService.deleteEntity(transferMealBuyRecord);
		mealBuyRecordList.remove(transferMealBuyRecord);
		removeData(1, mealBuyRecordList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(MealBuyRecord transferMealBuyRecord) {
		Tool.sendLog(LOG, userBean, "按下【套餐购买记录管理画面的_视图按钮】");
		if (transferMealBuyRecord == null) {
			transferMealBuyRecord = mealBuyRecordService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(MealBuyRecordViewBean.class).viewDetail(transferMealBuyRecord);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecord.class);
		detachedCriteria.createAlias(MealBuyRecord.CUSTOMINFO, MealBuyRecord.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.PERSONNEL_INFO, MealBuyRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.ADVISER, MealBuyRecord.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.TEMPORARY_ACTIVITY, MealBuyRecord.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = mealBuyRecordManageDto.getName();
		String leaguerNumber = mealBuyRecordManageDto.getLeaguerNumber();
		Date beginDate = mealBuyRecordManageDto.getBeginDate();
		Date endDate = mealBuyRecordManageDto.getEndDate();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(MealBuyRecord.CUSTOMINFO_LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(MealBuyRecord.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(MealBuyRecord.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(MealBuyRecord.DATE, endDate));
		}
		mealBuyRecordList = mealBuyRecordService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(mealBuyRecordService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.MEAL_BUY_RECORD_MANAGE;
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
	 * get mealBuyRecordManageDto
	 * @return the mealBuyRecordManageDto
	 */
	public MealBuyRecordManageDto getMealBuyRecordManageDto() {
		return mealBuyRecordManageDto;
	}

	/**
	 * set mealBuyRecordManageDto
	 * @param mealBuyRecordManageDto the mealBuyRecordManageDto to set
	 */
	public void setMealBuyRecordManageDto(MealBuyRecordManageDto mealBuyRecordManageDto) {
		this.mealBuyRecordManageDto = mealBuyRecordManageDto;
	}

	/**
	 * get mealBuyRecordList
	 * @return the mealBuyRecordList
	 */
	public List<MealBuyRecord> getMealBuyRecordList() {
		return mealBuyRecordList;
	}

	/**
	 * set mealBuyRecordList
	 * @param mealBuyRecordList the mealBuyRecordList to set
	 */
	public void setMealBuyRecordList(List<MealBuyRecord> mealBuyRecordList) {
		this.mealBuyRecordList = mealBuyRecordList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public MealBuyRecord[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(MealBuyRecord[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
