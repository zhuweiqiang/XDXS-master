package com.qylm.bean.returner.company;

import com.qylm.bean.company.UserManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.company.UserManageDto;
import com.qylm.entity.User;

public class UserManageReturner extends Returner<UserManageBean, UserManageDto, User> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7293948998297622758L;

	public UserManageReturner(UserManageDto userManageDto, int currentPage) {
		super(userManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(UserManageBean backBean) {
		backBean.setUserManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
