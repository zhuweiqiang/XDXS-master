package com.qylm.bean.baseSet;

import java.util.Arrays;
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
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.baseSet.TemporaryActivityManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.TemporaryActivityManageDto;
import com.qylm.entity.TemporaryActivity;
import com.qylm.service.TemporaryActivityService;

/**
 * 活动套餐管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class TemporaryActivityManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 594192172455995220L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(TemporaryActivityManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private TemporaryActivityManageDto temporaryActivityManageDto = new TemporaryActivityManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<TemporaryActivity> temporaryActivityList;
	
	/**
	 * 删除复选框选择的值
	 */
	private TemporaryActivity[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{temporaryActivityService}")
	private TemporaryActivityService temporaryActivityService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_活动套餐菜单】");
		fetchData(0, true);
		return Navigation.TEMPORARY_ACTIVITY_MANAGE;
	}

	/**
	 * 此方法绑定于活动套餐管理画面的新建按钮 
	 * 实现功能：跳转至活动套餐登陆画面，新建一家事件
	 * @return 活动套餐登陆画面
	 */
	public String newTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面_新建按钮】");
		return Tool.getBackBean(TemporaryActivityCreateBean.class).newCreate(new TemporaryActivityManageReturner(temporaryActivityManageDto, currentPage));
	}

	/**
	 * 此方法绑定于活动套餐管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至活动套餐登陆画面
	 * @return 活动套餐登陆画面
	 */
	public String updateTemporaryActivity(TemporaryActivity transferTemporaryActivity) {
		Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面_修改按钮】");
		return Tool.getBackBean(TemporaryActivityCreateBean.class).updateDetail(new TemporaryActivityManageReturner(temporaryActivityManageDto, currentPage), transferTemporaryActivity);
	}
	
	/**
	 * 此方法绑定于活动套餐管理画面的启用或者生效按钮 
	 * 实现功能：如果有效的就暂停，如果无效的就生效
	 */
	public void operationTemporaryActivity(TemporaryActivity transferTemporaryActivity) {
		if (transferTemporaryActivity.isState()) {
			Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面_暂停按钮】");
			transferTemporaryActivity.setState(false);
		} else {
			Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面_启用按钮】");
			transferTemporaryActivity.setState(true);
		}
		transferTemporaryActivity.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		temporaryActivityService.updateEntity(transferTemporaryActivity);
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}
	
	/**
	 * 此方法绑定于活动套餐管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于活动套餐管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<TemporaryActivity> asList = Arrays.asList(selectedModels);
				temporaryActivityService.deleteEntityAll(asList);
				temporaryActivityList.removeAll(asList);
				removeData(1, temporaryActivityList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于活动套餐管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteTemporaryActivity(TemporaryActivity transferTemporaryActivity) {
		Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面的_删除按钮】");
		try {
			temporaryActivityService.deleteEntity(transferTemporaryActivity);
			temporaryActivityList.remove(transferTemporaryActivity);
			removeData(1, temporaryActivityList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(TemporaryActivity transferTemporaryActivity) {
		Tool.sendLog(LOG, userBean, "按下【活动套餐管理画面的_视图按钮】");
		if (transferTemporaryActivity == null) {
			transferTemporaryActivity = temporaryActivityService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(TemporaryActivityViewBean.class).viewDetail(transferTemporaryActivity);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TemporaryActivity.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = temporaryActivityManageDto.getName();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(TemporaryActivity.NAME, name, MatchMode.ANYWHERE));
		}
		temporaryActivityList = temporaryActivityService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(temporaryActivityService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.TEMPORARY_ACTIVITY_MANAGE;
	}

	/**
	 * set temporaryActivityService
	 * @param temporaryActivityService the temporaryActivityService to set
	 */
	public void setTemporaryActivityService(TemporaryActivityService temporaryActivityService) {
		this.temporaryActivityService = temporaryActivityService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get temporaryActivityManageDto
	 * @return the temporaryActivityManageDto
	 */
	public TemporaryActivityManageDto getTemporaryActivityManageDto() {
		return temporaryActivityManageDto;
	}

	/**
	 * set temporaryActivityManageDto
	 * @param temporaryActivityManageDto the temporaryActivityManageDto to set
	 */
	public void setTemporaryActivityManageDto(TemporaryActivityManageDto temporaryActivityManageDto) {
		this.temporaryActivityManageDto = temporaryActivityManageDto;
	}

	/**
	 * get temporaryActivityList
	 * @return the temporaryActivityList
	 */
	public List<TemporaryActivity> getTemporaryActivityList() {
		return temporaryActivityList;
	}

	/**
	 * set temporaryActivityList
	 * @param temporaryActivityList the temporaryActivityList to set
	 */
	public void setTemporaryActivityList(List<TemporaryActivity> temporaryActivityList) {
		this.temporaryActivityList = temporaryActivityList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public TemporaryActivity[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(TemporaryActivity[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
