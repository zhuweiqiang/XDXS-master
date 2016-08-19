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
import com.qylm.bean.returner.baseSet.MarketingProjectManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.MarketingProjectManageDto;
import com.qylm.entity.MarketingProject;
import com.qylm.service.MarketingProjectService;

/**
 * 服务管理管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class MarketingProjectManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5835373821264068570L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MarketingProjectManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private MarketingProjectManageDto marketingProjectManageDto = new MarketingProjectManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<MarketingProject> marketingProjectList;
	
	/**
	 * 删除复选框选择的值
	 */
	private MarketingProject[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_服务管理菜单】");
		fetchData(0, true);
		return Navigation.MARKETING_PROJECT_MANAGE;
	}
	
	/**
	 * 此方法绑定于服务管理管理画面的新建按钮 
	 * 实现功能：跳转至服务管理登陆画面，新建一家事件
	 * @return 服务管理登陆画面
	 */
	public String newMarketingProject() {
		Tool.sendLog(LOG, userBean, "按下【服务管理管理画面_新建按钮】");
		return Tool.getBackBean(MarketingProjectCreateBean.class).newCreate(new MarketingProjectManageReturner(marketingProjectManageDto, currentPage));
	}

	/**
	 * 此方法绑定于服务管理管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至服务管理登陆画面
	 * @return 服务管理登陆画面
	 */
	public String updateMarketingProject(MarketingProject transferMarketingProject) {
		Tool.sendLog(LOG, userBean, "按下【服务管理管理画面_修改按钮】");
		return Tool.getBackBean(MarketingProjectCreateBean.class).updateDetail(new MarketingProjectManageReturner(marketingProjectManageDto, currentPage), transferMarketingProject);
	}
	
	/**
	 * 此方法绑定于服务管理管理画面的启用或者生效按钮 
	 * 实现功能：如果有效的就暂停，如果无效的就生效
	 */
	public void operationMarketingProject(MarketingProject transferMarketingProject) {
		if (transferMarketingProject.isState()) {
			Tool.sendLog(LOG, userBean, "按下【服务管理管理画面_暂停按钮】");
			transferMarketingProject.setState(false);
		} else {
			Tool.sendLog(LOG, userBean, "按下【服务管理管理画面_启用按钮】");
			transferMarketingProject.setState(true);
		}
		transferMarketingProject.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		marketingProjectService.updateEntity(transferMarketingProject);
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}
	
	/**
	 * 此方法绑定于服务管理管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectMarketingProject() {
		Tool.sendLog(LOG, userBean, "按下【服务管理管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于服务管理管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【服务管理管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<MarketingProject> asList = Arrays.asList(selectedModels);
				marketingProjectService.deleteEntityAll(asList);
				marketingProjectList.removeAll(asList);
				removeData(1, marketingProjectList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于服务管理管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteMarketingProject(MarketingProject transferMarketingProject) {
		Tool.sendLog(LOG, userBean, "按下【服务管理管理画面的_删除按钮】");
		try {
			marketingProjectService.deleteEntity(transferMarketingProject);
			marketingProjectList.remove(transferMarketingProject);
			removeData(1, marketingProjectList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(MarketingProject transferMarketingProject) {
		Tool.sendLog(LOG, userBean, "按下【服务管理管理画面的_视图按钮】");
		if (transferMarketingProject == null) {
			transferMarketingProject = marketingProjectService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(MarketingProjectViewBean.class).viewDetail(transferMarketingProject);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingProject.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String project = marketingProjectManageDto.getProject();
		if (StringUtil.isNotBlank(project)) {
			detachedCriteria.add(Restrictions.like(MarketingProject.PROJECT, project, MatchMode.ANYWHERE));
		}
		marketingProjectList = marketingProjectService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(marketingProjectService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.MARKETING_PROJECT_MANAGE;
	}

	/**
	 * set marketingProjectService
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get marketingProjectManageDto
	 * @return the marketingProjectManageDto
	 */
	public MarketingProjectManageDto getMarketingProjectManageDto() {
		return marketingProjectManageDto;
	}

	/**
	 * set marketingProjectManageDto
	 * @param marketingProjectManageDto the marketingProjectManageDto to set
	 */
	public void setMarketingProjectManageDto(MarketingProjectManageDto marketingProjectManageDto) {
		this.marketingProjectManageDto = marketingProjectManageDto;
	}

	/**
	 * get marketingProjectList
	 * @return the marketingProjectList
	 */
	public List<MarketingProject> getMarketingProjectList() {
		return marketingProjectList;
	}

	/**
	 * set marketingProjectList
	 * @param marketingProjectList the marketingProjectList to set
	 */
	public void setMarketingProjectList(List<MarketingProject> marketingProjectList) {
		this.marketingProjectList = marketingProjectList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public MarketingProject[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(MarketingProject[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
