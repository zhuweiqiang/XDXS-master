package com.qylm.dxo;

import com.qylm.dto.company.UserCreateDto;
import com.qylm.entity.User;

public final class UserCreateDxo {

	public static void dtoToEntity(UserCreateDto dto, User entity) {
		entity.setUserName(dto.getUserName());
		entity.setLoginName(dto.getLoginName());
		entity.setPassword(dto.getPassword());
		entity.setUserTel(dto.getUserTel());
		entity.setUserMobile1(dto.getUserMobile1());
		entity.setLastLoginTime(dto.getLastLoginTime());
		entity.setLoginTime(dto.getLoginTime());
		entity.setUserlevel(dto.getUserlevel());
		entity.setBelongingUser(dto.getBelongingUser());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(User entity, UserCreateDto dto) {
		dto.setUserName(entity.getUserName());
		dto.setLoginName(entity.getLoginName());
		dto.setPassword(entity.getPassword());
		dto.setUserTel(entity.getUserTel());
		dto.setUserMobile1(entity.getUserMobile1());
		dto.setLastLoginTime(entity.getLastLoginTime());
		dto.setLoginTime(entity.getLoginTime());
		dto.setUserlevel(entity.getUserlevel());
		dto.setBelongingUser(entity.getBelongingUser());
		dto.setCreater(entity.getCreater());
	}

}
