package com.qylm.bean.returner.company;

import com.qylm.bean.company.RoleManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.company.RoleManageDto;
import com.qylm.entity.Role;

public class RoleManageReturner extends Returner<RoleManageBean, RoleManageDto, Role> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4226942226752546121L;

	public RoleManageReturner(RoleManageDto roleManageDto, int currentPage) {
		super(roleManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(RoleManageBean backBean) {
		backBean.setRoleManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
