package com.qylm.bean.history;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.baseSet.CustomInfoCreateBean;
import com.qylm.bean.baseSet.CustomInfoViewBean;
import com.qylm.bean.returner.baseSet.CustomInfoManageReturner;
import com.qylm.bean.returner.history.HistoryArrearageManageReturner;
import com.qylm.bean.returner.history.HistoryTemporaryManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.history.HistoryArrearageManageDto;
import com.qylm.dto.history.HistoryTemporaryManageDto;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.User;
import com.qylm.service.CustomInfoService;
import com.qylm.service.MealBuyRecordService;
import com.qylm.service.UserService;

/**
 * 客户欠款记录管理
 * @author wk
 */
@ManagedBean
@RequestScoped
public class HistoryArrearageManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6793297631396928244L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(HistoryArrearageManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private HistoryArrearageManageDto historyArrearageManageDto = new HistoryArrearageManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<CustomInfo> customInfoList;
	
	/**
	 * 删除复选框选择的值
	 */
	private CustomInfo[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{customInfoService}")
	private CustomInfoService customInfoService;
	
	/**
	 * 用户业务类
	 */
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_客户欠款记录菜单】");
		fetchData(0, true);
		return Navigation.HISTORY_ARREARAGE_MANAGE;
	}
	
	/**
	 * 此方法绑定于客户档案管理画面的新建按钮 
	 * 实现功能：跳转至客户档案登陆画面，新建一家事件
	 * @return 客户档案登陆画面
	 */
	public String newCustomInfo() {
		Tool.sendLog(LOG, userBean, "按下【客户欠款管理画面_新建按钮】");
		return Tool.getBackBean(HistoryArrearageCreateBean.class).newCreate(new HistoryArrearageManageReturner(historyArrearageManageDto, currentPage));
	}

	/**
	 * 此方法绑定于客户档案管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至客户档案登陆画面
	 * @return 客户档案登陆画面
	 */
	public String updateCustomInfo(CustomInfo transferCustomInfo) {
		Tool.sendLog(LOG, userBean, "按下【客户欠款管理画面_修改按钮】");
		return Tool.getBackBean(HistoryArrearageCreateBean.class).updateDetail(new HistoryArrearageManageReturner(historyArrearageManageDto, currentPage), transferCustomInfo);	
		}
	
	/**
	 * 此方法绑定于客户档案管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectCustomInfo() {
		Tool.sendLog(LOG, userBean, "按下【客户欠款管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于客户档案管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【客户欠款管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<CustomInfo> asList = Arrays.asList(selectedModels);
			customInfoService.deleteEntityAll(asList);
			customInfoList.removeAll(asList);
			removeData(1, customInfoList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于客户档案管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteCustomInfo(CustomInfo transferCustomInfo) {
		Tool.sendLog(LOG, userBean, "按下【客户欠款管理画面的_删除按钮】");
		customInfoService.deleteEntity(transferCustomInfo);
		customInfoList.remove(transferCustomInfo);
		removeData(1, customInfoList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(CustomInfo transferCustomInfo) {
		Tool.sendLog(LOG, userBean, "按下【客户欠款管理画面的_视图按钮】");
		if (transferCustomInfo == null) {
			transferCustomInfo = customInfoService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(CustomInfoViewBean.class).viewDetail(transferCustomInfo);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomInfo.class);
		detachedCriteria.createAlias(CustomInfo.PERSONNEL_INFO_1, CustomInfo.PERSONNEL_INFO_1, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomInfo.PERSONNEL_INFO_2, CustomInfo.PERSONNEL_INFO_2, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser(), false);
		String leaguerNumber = historyArrearageManageDto.getLeaguerNumber();
		String name = historyArrearageManageDto.getName();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(CustomInfo.LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(CustomInfo.NAME, name, MatchMode.ANYWHERE));
		}
		customInfoList = customInfoService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(customInfoService.getRowCount(detachedCriteria));
		}
	}
	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.HISTORY_ARREARAGE_MANAGE;
	}
	
	/**
	 * 此方法绑定于客户档案管理画面的保存按钮 
	 * 实现功能：根据transferCustomInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveCustomInfo() {
		Tool.sendLog(LOG, userBean, "【客户档案管理画面的_保存按钮】");
		// 验证是否选择了用户
		if (StringUtil.isBlank(historyArrearageManageDto.getBelongingUserId())) {
			Tool.sendErrorMessage("必须要选择转入店铺！");
			return;
		}
		CustomInfo customInfo = historyArrearageManageDto.getTransferCustomInfo();
		customInfo.setBelongingUser(userService.getById(Integer.valueOf(historyArrearageManageDto.getBelongingUserId())));
		customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customInfoService.updateEntity(customInfo);
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}

	/**
	 * @return the historyArrearageManageDto
	 */
	public HistoryArrearageManageDto getHistoryArrearageManageDto() {
		return historyArrearageManageDto;
	}

	/**
	 * @param historyArrearageManageDto the historyArrearageManageDto to set
	 */
	public void setHistoryArrearageManageDto(
			HistoryArrearageManageDto historyArrearageManageDto) {
		this.historyArrearageManageDto = historyArrearageManageDto;
	}

	/**
	 * @return the customInfoList
	 */
	public List<CustomInfo> getCustomInfoList() {
		return customInfoList;
	}

	/**
	 * @param customInfoList the customInfoList to set
	 */
	public void setCustomInfoList(List<CustomInfo> customInfoList) {
		this.customInfoList = customInfoList;
	}

	/**
	 * @return the selectedModels
	 */
	public CustomInfo[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(CustomInfo[] selectedModels) {
		this.selectedModels = selectedModels;
	}

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}



}
