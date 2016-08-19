package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.UserDao;
import com.qylm.entity.User;
import com.qylm.entity.UserDepot;
import com.qylm.entity.UserRole;
import com.qylm.logic.company.UserLogic;

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {
	
	@Autowired
	private UserLogic userLogic;

	@Autowired
	protected UserServiceImpl(UserDao userDao) {
		super(userDao);
	}

	public void saveUser(User user, List<UserRole> userRoleList, List<UserDepot> userDepotList) {
		userLogic.saveUser(user, userRoleList, userDepotList);
	}

	public void updateUser(User user, List<UserRole> userRoleList, List<UserDepot> userDepotList) {
		userLogic.updateUser(user, userRoleList, userDepotList);
	}

}
