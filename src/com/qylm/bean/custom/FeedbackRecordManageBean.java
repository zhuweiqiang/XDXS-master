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
import com.qylm.bean.returner.custom.FeedbackRecordManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.FeedbackRecordManageDto;
import com.qylm.entity.FeedbackRecord;
import com.qylm.service.FeedbackRecordService;

/**
 * 客户反馈记录管理
 * @author qylm
 */
@ManagedBean
@RequestScoped



public class FeedbackRecordManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5400493602888147383L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(FeedbackRecordManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private FeedbackRecordManageDto feedbackRecordManageDto = new FeedbackRecordManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<FeedbackRecord> feedbackRecordList;
	
	/**
	 * 删除复选框选择的值
	 */
	private FeedbackRecord[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{feedbackRecordService}")
	private FeedbackRecordService feedbackRecordService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_客户反馈记录菜单】");
		fetchData(0, true);
		return Navigation.FEEDBACK_RECORD_MANAGE;
	}
	
	/**
	 * 此方法绑定于客户反馈记录管理画面的新建按钮 
	 * 实现功能：跳转至客户反馈记录登陆画面，新建一家事件
	 * @return 客户反馈记录登陆画面
	 */
	public String newFeedbackRecord() {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面_新建按钮】");
		return Tool.getBackBean(FeedbackRecordCreateBean.class).newCreate(new FeedbackRecordManageReturner(feedbackRecordManageDto, currentPage));
	}

	/**
	 * 此方法绑定于客户反馈记录管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至客户反馈记录登陆画面
	 * @return 客户反馈记录登陆画面
	 */
	public String updateFeedbackRecord(FeedbackRecord transferFeedbackRecord) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面_修改按钮】");
		return Tool.getBackBean(FeedbackRecordCreateBean.class).updateDetail(new FeedbackRecordManageReturner(feedbackRecordManageDto, currentPage), transferFeedbackRecord);
	}
	
	/**
	 * 此方法绑定于客户反馈记录管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectFeedbackRecord() {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于客户反馈记录管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<FeedbackRecord> asList = Arrays.asList(selectedModels);
			feedbackRecordService.deleteEntityAll(asList);
			feedbackRecordList.removeAll(asList);
			removeData(1, feedbackRecordList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于客户反馈记录管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteFeedbackRecord(FeedbackRecord transferFeedbackRecord) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面的_删除按钮】");
		feedbackRecordService.deleteEntity(transferFeedbackRecord);
		feedbackRecordList.remove(transferFeedbackRecord);
		removeData(1, feedbackRecordList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(FeedbackRecord transferFeedbackRecord) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面的_视图按钮】");
		if (transferFeedbackRecord == null) {
			transferFeedbackRecord = feedbackRecordService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(FeedbackRecordViewBean.class).viewDetail(transferFeedbackRecord);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FeedbackRecord.class);
		detachedCriteria.createAlias(FeedbackRecord.CUSTOM_INFO, FeedbackRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.MARKETING_PROJECT, FeedbackRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.PRODUCT_STOCK, FeedbackRecord.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.PERSONNEL_INFO, FeedbackRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.ADVISER, FeedbackRecord.ADVISER, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = feedbackRecordManageDto.getName();
		Date beginDate = feedbackRecordManageDto.getBeginDate();
		Date endDate = feedbackRecordManageDto.getEndDate();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(FeedbackRecord.CUSTOM_INFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(FeedbackRecord.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(FeedbackRecord.DATE, endDate));
		}
		feedbackRecordList = feedbackRecordService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(feedbackRecordService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.FEEDBACK_RECORD_MANAGE;
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
	 * get feedbackRecordManageDto
	 * @return the feedbackRecordManageDto
	 */
	public FeedbackRecordManageDto getFeedbackRecordManageDto() {
		return feedbackRecordManageDto;
	}

	/**
	 * set feedbackRecordManageDto
	 * @param feedbackRecordManageDto the feedbackRecordManageDto to set
	 */
	public void setFeedbackRecordManageDto(FeedbackRecordManageDto feedbackRecordManageDto) {
		this.feedbackRecordManageDto = feedbackRecordManageDto;
	}

	/**
	 * get feedbackRecordList
	 * @return the feedbackRecordList
	 */
	public List<FeedbackRecord> getFeedbackRecordList() {
		return feedbackRecordList;
	}

	/**
	 * set feedbackRecordList
	 * @param feedbackRecordList the feedbackRecordList to set
	 */
	public void setFeedbackRecordList(List<FeedbackRecord> feedbackRecordList) {
		this.feedbackRecordList = feedbackRecordList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public FeedbackRecord[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(FeedbackRecord[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
