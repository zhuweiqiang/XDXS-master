package com.qylm.logic.company;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.RoleDao;
import com.qylm.dao.RoleDetailDao;
import com.qylm.entity.Role;
import com.qylm.entity.RoleDetail;

public class RoleLogic {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleDetailDao roleDetailDao;
	
	public void saveRole(Role role, List<RoleDetail> roleDetailList) {
		roleDao.saveEntity(role);
		if(roleDetailList != null && !roleDetailList.isEmpty()){
			roleDetailDao.saveEntityAll(roleDetailList);
		}
		
	}

	public void updateRole(Role role, List<RoleDetail> roleDetailList) {
		roleDao.updateEntity(role);
		String sql = "delete from role_detail where roleId={0}";
		roleDetailDao.bulkSQLUpdate(MessageFormat.format(sql, role.getId()));
		roleDetailDao.saveEntityAll(roleDetailList);
	}
}
