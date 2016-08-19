package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.ProjectBuyManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.ProjectBuyManageDto;
import com.qylm.entity.ProjectBuy;

public class ProjectBuyManageReturner extends Returner<ProjectBuyManageBean, ProjectBuyManageDto, ProjectBuy> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7510381520985999663L;

	public ProjectBuyManageReturner(ProjectBuyManageDto projectBuyManageDto, int currentPage) {
		super(projectBuyManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ProjectBuyManageBean backBean) {
		backBean.setProjectBuyManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
