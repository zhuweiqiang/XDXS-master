package com.qylm.bean.baseSet;

import java.util.Arrays;
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
import com.qylm.bean.returner.baseSet.CustomInfoManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.CustomInfoManageDto;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.User;
import com.qylm.service.CustomInfoService;
import com.qylm.service.UserService;

/**
 * 客户档案管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class CustomInfoManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7459818383855240151L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(CustomInfoManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private CustomInfoManageDto customInfoManageDto = new CustomInfoManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<CustomInfo> customInfoList;
	
	/**
	 * 删除复选框选择的值
	 */
	private CustomInfo[] selectedModels;
	
	/**
	 * 转店列表
	 */
	private SelectItem[] userItems;

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
		Tool.sendLog(LOG, userBean, "按下【功能菜单_客户档案菜单】");
		fetchData(0, true);
		return Navigation.CUSTOM_INFO_MANAGE;
	}
	
	/**
	 * 此方法绑定于客户档案管理画面的新建按钮 
	 * 实现功能：跳转至客户档案登陆画面，新建一家事件
	 * @return 客户档案登陆画面
	 */
	public String newCustomInfo() {
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面_新建按钮】");
		return Tool.getBackBean(CustomInfoCreateBean.class).newCreate(new CustomInfoManageReturner(customInfoManageDto, currentPage));
	}

	/**
	 * 此方法绑定于客户档案管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至客户档案登陆画面
	 * @return 客户档案登陆画面
	 */
	public String updateCustomInfo(CustomInfo transferCustomInfo) {
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面_修改按钮】");
		return Tool.getBackBean(CustomInfoCreateBean.class).updateDetail(new CustomInfoManageReturner(customInfoManageDto, currentPage), transferCustomInfo);	
		}
	
	/**
	 * 此方法绑定于客户档案管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectCustomInfo() {
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于客户档案管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面_批量删除按钮】");
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
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面的_删除按钮】");
		customInfoService.deleteEntity(transferCustomInfo);
		customInfoList.remove(transferCustomInfo);
		removeData(1, customInfoList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(CustomInfo transferCustomInfo) {
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面的_视图按钮】");
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
		String leaguerNumber = customInfoManageDto.getLeaguerNumber();
		String name = customInfoManageDto.getName();
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
		return Navigation.CUSTOM_INFO_MANAGE;
	}
	
	/**
	 * 此方法绑定于客户档案管理画面的转店按钮 
	 * 实现功能：跳转到修改页面进行修改
	 * @return 个人事件管理画面
	 */
	public void changeCustomInfo(CustomInfo transferCustomInfo) {
		Tool.sendLog(LOG, userBean, "按下【客户档案管理画面的_转店按钮】");
		customInfoManageDto.setTransferCustomInfo(transferCustomInfo);
		// 获取到对应的店铺名称
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		//系统管理员可以管理全部转店需求
		if(userBean.getUser().getId()!=1){
		detachedCriteria.add(Restrictions.eq(User.BELONGING_USER, userBean.getUser()));
		detachedCriteria.add(Restrictions.eq(User.USER_LEVEL, User.USER_LEVEL_4));}else{
			detachedCriteria.add(Restrictions.eq(User.USER_LEVEL, User.USER_LEVEL_4));
		}
		List<User> userList = userService.getByDetachedCriteria(detachedCriteria);
		if (!userList.isEmpty()) {
			int size = userList.size();
			userItems = new SelectItem[size];
			for (int i = 0; i < size; i++) {
				User user = userList.get(i);
				userItems[i] = new SelectItem(user.getId().toString(), user.getUserName());
			}
		}
	}
	
	/**
	 * 此方法绑定于客户档案管理画面的保存按钮 
	 * 实现功能：根据transferCustomInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveCustomInfo() {
		Tool.sendLog(LOG, userBean, "【客户档案管理画面的_保存按钮】");
		// 验证是否选择了用户
		if (StringUtil.isBlank(customInfoManageDto.getBelongingUserId())) {
			Tool.sendErrorMessage("必须要选择转入店铺！");
			return;
		}
		CustomInfo customInfo = customInfoManageDto.getTransferCustomInfo();
		customInfo.setBelongingUser(userService.getById(Integer.valueOf(customInfoManageDto.getBelongingUserId())));
		customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customInfoService.updateEntity(customInfo);
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * set customInfoService
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get customInfoManageDto
	 * @return the customInfoManageDto
	 */
	public CustomInfoManageDto getCustomInfoManageDto() {
		return customInfoManageDto;
	}

	/**
	 * set customInfoManageDto
	 * @param customInfoManageDto the customInfoManageDto to set
	 */
	public void setCustomInfoManageDto(CustomInfoManageDto customInfoManageDto) {
		this.customInfoManageDto = customInfoManageDto;
	}

	/**
	 * get customInfoList
	 * @return the customInfoList
	 */
	public List<CustomInfo> getCustomInfoList() {
		return customInfoList;
	}

	/**
	 * set customInfoList
	 * @param customInfoList the customInfoList to set
	 */
	public void setCustomInfoList(List<CustomInfo> customInfoList) {
		this.customInfoList = customInfoList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public CustomInfo[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(CustomInfo[] selectedModels) {
		this.selectedModels = selectedModels;
	}

	/**
	 * @return the userItems
	 */
	public SelectItem[] getUserItems() {
		return userItems;
	}

	/**
	 * @param userItems the userItems to set
	 */
	public void setUserItems(SelectItem[] userItems) {
		this.userItems = userItems;
	}

}
