package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.common.Navigation;
import com.qylm.dto.baseSet.MarketingProjectViewDto;
import com.qylm.dxo.MarketingProjectViewDxo;
import com.qylm.entity.MarketingProject;
import com.qylm.service.MarketingProjectService;

/**
 * 服务管理登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class MarketingProjectViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7258444404377893251L;

	/**
	 * 存放服务管理登陆画面需要保存的值
	 */
	private MarketingProjectViewDto marketingProjectViewDto = new MarketingProjectViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{marketingProjectService}")
	private MarketingProjectService marketingProjectService;
	
	/**
	 * 查看详细
	 * @param marketingProject
	 * @return
	 */
	public String viewDetail(MarketingProject marketingProject) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingProject.class);
		detachedCriteria.add(Restrictions.eq(MarketingProject.BASE_ID, marketingProject.getId()));
		List<MarketingProject> marketingProjectList = marketingProjectService.getByDetachedCriteria(detachedCriteria);
		if (!marketingProjectList.isEmpty()) {
			marketingProject = marketingProjectList.get(0);
			MarketingProjectViewDxo.entityToDto(marketingProject, marketingProjectViewDto);
		}
		return Navigation.MARKETING_PROJECT_VIEW;
	}
	
	/**
	 * @param marketingProjectService the marketingProjectService to set
	 */
	public void setMarketingProjectService(MarketingProjectService marketingProjectService) {
		this.marketingProjectService = marketingProjectService;
	}

	/**
	 * @return the marketingProjectViewDto
	 */
	public MarketingProjectViewDto getMarketingProjectViewDto() {
		return marketingProjectViewDto;
	}

	/**
	 * @param marketingProjectViewDto the marketingProjectViewDto to set
	 */
	public void setMarketingProjectViewDto(MarketingProjectViewDto marketingProjectViewDto) {
		this.marketingProjectViewDto = marketingProjectViewDto;
	}

}
