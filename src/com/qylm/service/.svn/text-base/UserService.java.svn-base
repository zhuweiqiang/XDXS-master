package com.qylm.service;

import java.util.List;

import com.qylm.entity.User;
import com.qylm.entity.UserDepot;
import com.qylm.entity.UserRole;

public interface UserService extends GenericService<User, Integer> {

	/**
	 * 保存用户时，保存用户与角色之间的关系表
	 * @param user
	 * @param userRoleList
	 */
	public void saveUser(User user, List<UserRole> userRoleList, List<UserDepot> userDepotList);
	
	/**
	 * 更新用户时，保存用户与角色之间的关系表
	 * @param user
	 * @param userRoleList
	 */
	public void updateUser(User user, List<UserRole> userRoleList, List<UserDepot> userDepotList);
}
