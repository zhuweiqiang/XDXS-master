package com.qylm.bean.depot;

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
import com.qylm.bean.returner.depot.DepotInfoManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.depot.DepotInfoManageDto;
import com.qylm.entity.DepotInfo;
import com.qylm.service.DepotInfoService;

/**
 * 仓库信息管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class DepotInfoManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7638307280223660707L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(DepotInfoManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private DepotInfoManageDto depotInfoManageDto = new DepotInfoManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<DepotInfo> depotInfoList;
	
	/**
	 * 删除复选框选择的值
	 */
	private DepotInfo[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{depotInfoService}")
	private DepotInfoService depotInfoService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_仓库信息菜单】");
		fetchData(0, true);
		return Navigation.DEPOT_INFO_MANAGE;
	}
	
	/**
	 * 此方法绑定于仓库信息管理画面的新建按钮 
	 * 实现功能：跳转至仓库信息登陆画面，新建一家事件
	 * @return 仓库信息登陆画面
	 */
	public String newDepotInfo() {
		Tool.sendLog(LOG, userBean, "按下【仓库信息管理画面_新建按钮】");
		return Tool.getBackBean(DepotInfoCreateBean.class).newCreate(new DepotInfoManageReturner(depotInfoManageDto, currentPage));
	}

	/**
	 * 此方法绑定于仓库信息管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至仓库信息登陆画面
	 * @return 仓库信息登陆画面
	 */
	public String updateDepotInfo(DepotInfo transferDepotInfo) {
		Tool.sendLog(LOG, userBean, "按下【仓库信息管理画面_修改按钮】");
		return Tool.getBackBean(DepotInfoCreateBean.class).updateDetail(new DepotInfoManageReturner(depotInfoManageDto, currentPage), transferDepotInfo);
	}
	
	/**
	 * 此方法绑定于仓库信息管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectDepotInfo() {
		Tool.sendLog(LOG, userBean, "按下【仓库信息管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于仓库信息管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【仓库信息管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<DepotInfo> asList = Arrays.asList(selectedModels);
				depotInfoService.deleteEntityAll(asList);
				depotInfoList.removeAll(asList);
				removeData(1, depotInfoList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于仓库信息管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteDepotInfo(DepotInfo transferDepotInfo) {
		Tool.sendLog(LOG, userBean, "按下【仓库信息管理画面的_删除按钮】");
		try {
			depotInfoService.deleteEntity(transferDepotInfo);
			depotInfoList.remove(transferDepotInfo);
			removeData(1, depotInfoList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(DepotInfo transferDepotInfo) {
		Tool.sendLog(LOG, userBean, "按下【仓库信息管理画面的_视图按钮】");
		if (transferDepotInfo == null) {
			transferDepotInfo = depotInfoService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(DepotInfoViewBean.class).viewDetail(transferDepotInfo);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepotInfo.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = depotInfoManageDto.getName();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(DepotInfo.NAME, name, MatchMode.ANYWHERE));
		}
		depotInfoList = depotInfoService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(depotInfoService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.DEPOT_INFO_MANAGE;
	}

	/**
	 * set depotInfoService
	 * @param depotInfoService the depotInfoService to set
	 */
	public void setDepotInfoService(DepotInfoService depotInfoService) {
		this.depotInfoService = depotInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get depotInfoManageDto
	 * @return the depotInfoManageDto
	 */
	public DepotInfoManageDto getDepotInfoManageDto() {
		return depotInfoManageDto;
	}

	/**
	 * set depotInfoManageDto
	 * @param depotInfoManageDto the depotInfoManageDto to set
	 */
	public void setDepotInfoManageDto(DepotInfoManageDto depotInfoManageDto) {
		this.depotInfoManageDto = depotInfoManageDto;
	}

	/**
	 * get depotInfoList
	 * @return the depotInfoList
	 */
	public List<DepotInfo> getDepotInfoList() {
		return depotInfoList;
	}

	/**
	 * set depotInfoList
	 * @param depotInfoList the depotInfoList to set
	 */
	public void setDepotInfoList(List<DepotInfo> depotInfoList) {
		this.depotInfoList = depotInfoList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public DepotInfo[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(DepotInfo[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
