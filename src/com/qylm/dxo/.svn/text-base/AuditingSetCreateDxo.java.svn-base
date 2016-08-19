package com.qylm.dxo;

import com.qylm.dto.auditing.AuditingSetCreateDto;
import com.qylm.entity.AuditingSet;

public final class AuditingSetCreateDxo {

	public static void dtoToEntity(AuditingSetCreateDto dto, AuditingSet entity) {
		entity.setApplyNumber(dto.getApplyNumber());
		entity.setState(dto.isState());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(AuditingSet entity, AuditingSetCreateDto dto) {
		dto.setApplyNumber(entity.getApplyNumber());
		dto.setState(entity.isState());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
