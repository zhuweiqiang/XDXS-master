package com.qylm.dxo;

import com.qylm.dto.company.RoleCreateDto;
import com.qylm.entity.Role;

public final class RoleCreateDxo {

	public static void dtoToEntity(RoleCreateDto dto, Role entity) {
		entity.setRoleName(dto.getRoleName());
		entity.setDescription(dto.getDescription());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(Role entity, RoleCreateDto dto) {
		dto.setRoleName(entity.getRoleName());
		dto.setDescription(entity.getDescription());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
