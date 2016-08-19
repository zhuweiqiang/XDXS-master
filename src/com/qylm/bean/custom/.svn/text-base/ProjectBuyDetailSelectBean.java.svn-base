package com.qylm.bean.custom;

import java.util.Date;
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

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.ProjectBuyDetailSelectDto;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.service.ProjectBuyDetailService;

/**
 * 项目购买查询
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ProjectBuyDetailSelectBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2267960541992529730L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProjectBuyDetailSelectBean.class);
	
	/**
	 * 保存事件查询画面需要保存的值
	 */
	private ProjectBuyDetailSelectDto projectBuyDetailSelectDto = new ProjectBuyDetailSelectDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ProjectBuyDetail> projectBuyDetailList;
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件查询业务类
	 */
	@ManagedProperty(value="#{projectBuyDetailService}")
	private ProjectBuyDetailService projectBuyDetailService;
	
	/**
	 * 此方法绑定于项目购买查询画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectProjectBuyDetail() {
		Tool.sendLog(LOG, userBean, "按下【项目购买查询画面_检索按钮】");
		fetchData(0, true);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = projectBuyDetailSelectDto.getName();
		String projectName = projectBuyDetailSelectDto.getProjectName();
		Date beginDate = projectBuyDetailSelectDto.getBeginDate();
		Date endDate = projectBuyDetailSelectDto.getEndDate();
		if (StringUtil.isNotBlank(projectName)) {
			detachedCriteria.add(Restrictions.like(ProjectBuyDetail.MARKETING_PROJECT_PROJECT, projectName, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(ProjectBuyDetail.CUSTOM_INFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(ProjectBuyDetail.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(ProjectBuyDetail.DATE, endDate));
		}
		projectBuyDetailList = projectBuyDetailService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(projectBuyDetailService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件查询画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.PROJECT_BUY_MANAGE;
	}

	/**
	 * set projectBuyDetailService
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get projectBuyDetailSelectDto
	 * @return the projectBuyDetailSelectDto
	 */
	public ProjectBuyDetailSelectDto getProjectBuyDetailSelectDto() {
		return projectBuyDetailSelectDto;
	}

	/**
	 * set projectBuyDetailSelectDto
	 * @param projectBuyDetailSelectDto the projectBuyDetailSelectDto to set
	 */
	public void setProjectBuyDetailSelectDto(ProjectBuyDetailSelectDto projectBuyDetailSelectDto) {
		this.projectBuyDetailSelectDto = projectBuyDetailSelectDto;
	}

	/**
	 * get projectBuyDetailList
	 * @return the projectBuyDetailList
	 */
	public List<ProjectBuyDetail> getProjectBuyDetailList() {
		return projectBuyDetailList;
	}

	/**
	 * set projectBuyDetailList
	 * @param projectBuyDetailList the projectBuyDetailList to set
	 */
	public void setProjectBuyDetailList(List<ProjectBuyDetail> projectBuyDetailList) {
		this.projectBuyDetailList = projectBuyDetailList;
	}

}
