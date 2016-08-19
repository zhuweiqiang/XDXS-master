package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.RoleDao;
import com.qylm.entity.Role;
import com.qylm.entity.RoleDetail;
import com.qylm.logic.company.RoleLogic;

@Service("roleService")
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

	@Autowired
	private RoleLogic roleLogic;
	
	@Autowired
	protected RoleServiceImpl(RoleDao roleDao) {
		super(roleDao);
	}

	public void saveRole(Role role, List<RoleDetail> roleDetailList) {
		roleLogic.saveRole(role, roleDetailList);
	}

	public void updateRole(Role role, List<RoleDetail> roleDetailList) {
		roleLogic.updateRole(role, roleDetailList);
	}

}
