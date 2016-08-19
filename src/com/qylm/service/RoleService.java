package com.qylm.service;

import java.util.List;

import com.qylm.entity.Role;
import com.qylm.entity.RoleDetail;

public interface RoleService extends GenericService<Role, Integer> {

	/**
	 * 保存的同时保存角色详细
	 * @param role
	 * @param roleDetailList
	 */
	public void saveRole(Role role, List<RoleDetail> roleDetailList);
	
	/**
	 * 更新的同时保存角色详细
	 * @param role
	 * @param roleDetailList
	 */
	public void updateRole(Role role, List<RoleDetail> roleDetailList);
	
}
