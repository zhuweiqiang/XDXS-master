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
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.bean.returner.custom.ProjectBuyManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.ProjectBuyManageDto;
import com.qylm.entity.ProjectBuy;
import com.qylm.service.ProjectBuyService;

/**
 * 项目购买管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ProjectBuyManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4108309786314728178L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProjectBuyManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ProjectBuyManageDto projectBuyManageDto = new ProjectBuyManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ProjectBuy> projectBuyList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ProjectBuy[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{projectBuyService}")
	private ProjectBuyService projectBuyService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_项目购买菜单】");
		fetchData(0, true);
		return Navigation.PROJECT_BUY_MANAGE;
	}
	
	/**
	 * 此方法绑定于项目购买管理画面的新建按钮 
	 * 实现功能：跳转至项目购买登陆画面，新建一家事件
	 * @return 项目购买登陆画面
	 */
	public String newProjectBuy() {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面_新建按钮】");
		return Tool.getBackBean(ProjectBuyCreateBean.class).newCreate(new ProjectBuyManageReturner(projectBuyManageDto, currentPage));
	}

	/**
	 * 此方法绑定于项目购买管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至项目购买登陆画面
	 * @return 项目购买登陆画面
	 */
	public String updateProjectBuy(ProjectBuy transferProjectBuy) {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面_修改按钮】");
		return Tool.getBackBean(ProjectBuyCreateBean.class).updateDetail(new ProjectBuyManageReturner(projectBuyManageDto, currentPage), transferProjectBuy);
	}
	
	/**
	 * 此方法绑定于项目购买管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectProjectBuy() {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 此方法绑定于项目购买管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public String selectProjectBuy(Returner<?, ?, ?> returner) {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面_检索按钮】");
		projectBuyManageDto.setReturner(returner);
		fetchData(0, true);
		return Navigation.PROJECT_BUY_MANAGE;
	}
	
	/**
	 * 返回
	 * @return
	 */
	public String back() {
		return projectBuyManageDto.getReturner().returnOnly();
	}
	
	/**
	 * 绑定于项目购买管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ProjectBuy> asList = Arrays.asList(selectedModels);
				projectBuyService.deleteEntityAll(asList);
				projectBuyList.removeAll(asList);
				removeData(1, projectBuyList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于项目购买管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteProjectBuy(ProjectBuy transferProjectBuy) {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面的_删除按钮】");
		try {
			projectBuyService.deleteEntity(transferProjectBuy);
			projectBuyList.remove(transferProjectBuy);
			removeData(1, projectBuyList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ProjectBuy transferProjectBuy) {
		Tool.sendLog(LOG, userBean, "按下【项目购买管理画面的_视图按钮】");
		if (transferProjectBuy == null) {
			transferProjectBuy = projectBuyService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ProjectBuyViewBean.class).viewDetail(transferProjectBuy);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuy.class);
		detachedCriteria.createAlias(ProjectBuy.CUSTOMINFO, ProjectBuy.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuy.PERSONNEL_INFO, ProjectBuy.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuy.ADVISER, ProjectBuy.ADVISER, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = projectBuyManageDto.getName();
		String leaguerNumber = projectBuyManageDto.getLeaguerNumber();
		Date beginDate = projectBuyManageDto.getBeginDate();
		Date endDate = projectBuyManageDto.getEndDate();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(ProjectBuy.CUSTOMINFO_LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(ProjectBuy.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(ProjectBuy.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(ProjectBuy.DATE, endDate));
		}
		projectBuyList = projectBuyService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(projectBuyService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.PROJECT_BUY_MANAGE;
	}

	/**
	 * set projectBuyService
	 * @param projectBuyService the projectBuyService to set
	 */
	public void setProjectBuyService(ProjectBuyService projectBuyService) {
		this.projectBuyService = projectBuyService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get projectBuyManageDto
	 * @return the projectBuyManageDto
	 */
	public ProjectBuyManageDto getProjectBuyManageDto() {
		return projectBuyManageDto;
	}

	/**
	 * set projectBuyManageDto
	 * @param projectBuyManageDto the projectBuyManageDto to set
	 */
	public void setProjectBuyManageDto(ProjectBuyManageDto projectBuyManageDto) {
		this.projectBuyManageDto = projectBuyManageDto;
	}

	/**
	 * get projectBuyList
	 * @return the projectBuyList
	 */
	public List<ProjectBuy> getProjectBuyList() {
		return projectBuyList;
	}

	/**
	 * set projectBuyList
	 * @param projectBuyList the projectBuyList to set
	 */
	public void setProjectBuyList(List<ProjectBuy> projectBuyList) {
		this.projectBuyList = projectBuyList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ProjectBuy[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ProjectBuy[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
