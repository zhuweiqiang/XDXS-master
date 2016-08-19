package com.qylm.bean.custom;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.custom.ProjectBuyViewDto;
import com.qylm.dxo.ProjectBuyViewDxo;
import com.qylm.entity.ProjectBuy;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.service.ProjectBuyDetailService;
import com.qylm.service.ProjectBuyService;

/**
 * 项目购买登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProjectBuyViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5869501849878148662L;

	/**
	 * 存放项目购买登陆画面需要保存的值
	 */
	private ProjectBuyViewDto projectBuyViewDto = new ProjectBuyViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{projectBuyService}")
	private ProjectBuyService projectBuyService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{projectBuyDetailService}")
	private ProjectBuyDetailService projectBuyDetailService;
	
	/**
	 * 查看详细
	 * @param projectBuy
	 * @return
	 */
	public String viewDetail(ProjectBuy projectBuy) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuy.class);
		detachedCriteria.createAlias(ProjectBuy.CUSTOMINFO, ProjectBuy.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuy.PERSONNEL_INFO, ProjectBuy.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProjectBuy.ADVISER, ProjectBuy.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ProjectBuy.BASE_ID, projectBuy.getId()));
		List<ProjectBuy> projectBuyList = projectBuyService.getByDetachedCriteria(detachedCriteria);
		if (!projectBuyList.isEmpty()) {
			projectBuy = projectBuyList.get(0);
			ProjectBuyViewDxo.entityToDto(projectBuy, projectBuyViewDto);
			detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
			detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY, projectBuy));
			projectBuyViewDto.setProjectBuyDetailList(projectBuyDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.PROJECT_BUY_VIEW;
	}
	
	/**
	 * @param projectBuyDetailService the projectBuyDetailService to set
	 */
	public void setProjectBuyDetailService(
			ProjectBuyDetailService projectBuyDetailService) {
		this.projectBuyDetailService = projectBuyDetailService;
	}

	/**
	 * @param projectBuyService the projectBuyService to set
	 */
	public void setProjectBuyService(ProjectBuyService projectBuyService) {
		this.projectBuyService = projectBuyService;
	}

	/**
	 * @return the projectBuyViewDto
	 */
	public ProjectBuyViewDto getProjectBuyViewDto() {
		return projectBuyViewDto;
	}

	/**
	 * @param projectBuyViewDto the projectBuyViewDto to set
	 */
	public void setProjectBuyViewDto(ProjectBuyViewDto projectBuyViewDto) {
		this.projectBuyViewDto = projectBuyViewDto;
	}

}
