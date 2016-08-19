package com.qylm.logic.company;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.UserDao;
import com.qylm.dao.UserDepotDao;
import com.qylm.dao.UserRoleDao;
import com.qylm.entity.User;
import com.qylm.entity.UserDepot;
import com.qylm.entity.UserRole;

public class UserLogic {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private UserDepotDao userDepotDao;
	
	public void saveUser(User user, List<UserRole> userRoleList, List<UserDepot> userDepotList) {
		userDao.saveEntity(user);
		if (userRoleList != null && !userRoleList.isEmpty()) {
			userRoleDao.saveEntityAll(userRoleList);
		}
		if (userDepotList != null && !userDepotList.isEmpty()) {
			userDepotDao.saveEntityAll(userDepotList);
		}
	}

	public void updateUser(User user, List<UserRole> userRoleList, List<UserDepot> userDepotList) {
		userDao.updateEntity(user);
		String sql;
		if (userRoleList != null && !userRoleList.isEmpty()) {
			sql = "delete from user_role where userId={0}";
			userRoleDao.bulkSQLUpdate(MessageFormat.format(sql, user.getId()));
			if (userRoleList != null && !userRoleList.isEmpty()) {
				userRoleDao.saveEntityAll(userRoleList);
			}
		}
		if (userDepotList != null && !userDepotList.isEmpty()) {
			sql = "delete from user_depot where userId={0}";
			userDepotDao.bulkSQLUpdate(MessageFormat.format(sql, user.getId()));
			if (userDepotList != null && !userDepotList.isEmpty()) {
				userDepotDao.saveEntityAll(userDepotList);
			}
		}
	}
}
