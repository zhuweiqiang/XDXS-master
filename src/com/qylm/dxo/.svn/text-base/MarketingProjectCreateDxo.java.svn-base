package com.qylm.dxo;

import com.qylm.dto.baseSet.MarketingProjectCreateDto;
import com.qylm.entity.MarketingProject;

public final class MarketingProjectCreateDxo {

	public static void dtoToEntity(MarketingProjectCreateDto dto, MarketingProject entity) {
		entity.setProject(dto.getProject());
		entity.setType(dto.getType());
		entity.setMoney(dto.getMoney());
		entity.setRemark(dto.getRemark());
		entity.setState(dto.isState());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(MarketingProject entity, MarketingProjectCreateDto dto) {
		dto.setProject(entity.getProject());
		dto.setMoney(entity.getMoney());
		dto.setRemark(entity.getRemark());
		dto.setState(entity.isState());
		dto.setType(entity.getType());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
