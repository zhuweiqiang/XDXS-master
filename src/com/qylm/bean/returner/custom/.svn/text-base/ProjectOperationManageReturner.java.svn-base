package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.ProjectOperationManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.ProjectOperationManageDto;
import com.qylm.entity.ConsumptionRegister;

public class ProjectOperationManageReturner extends Returner<ProjectOperationManageBean, ProjectOperationManageDto, ConsumptionRegister> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6950796093870259520L;

	public ProjectOperationManageReturner(ProjectOperationManageDto projectOperationManageDto, int currentPage) {
		super(projectOperationManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ProjectOperationManageBean backBean) {
		backBean.setProjectOperationManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
