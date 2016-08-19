package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.UserRoleDao;
import com.qylm.entity.UserRole;

@Service("userRoleService")
public class UserRoleServiceImpl extends GenericServiceImpl<UserRole, Integer> implements UserRoleService {

	@Autowired
	protected UserRoleServiceImpl(UserRoleDao userRoleDao) {
		super(userRoleDao);
	}

}
