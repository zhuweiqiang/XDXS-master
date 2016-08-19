package com.qylm.dxo;

import com.qylm.dto.history.CustomCardCreateDto;
import com.qylm.entity.CustomLeaguerDetail;

public final class CustomCardCreateDxo {

	public static void dtoToEntity(CustomCardCreateDto dto, CustomLeaguerDetail entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setLeaguer(dto.getLeaguer());
		entity.setMoney(dto.getMoney());
		entity.setRebate(dto.getRebate());
		entity.setCreateDate(dto.getCreateDate());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
		entity.setGiveInfo(dto.getGiveInfo());
	}

	public static void entityToDto(CustomLeaguerDetail entity, CustomCardCreateDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setLeaguer(entity.getLeaguer());
		dto.setMoney(entity.getMoney());
		dto.setRebate(entity.getRebate());
		dto.setCreateDate(entity.getCreateDate());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
		dto.setGiveInfo(entity.getGiveInfo());
	}

}
