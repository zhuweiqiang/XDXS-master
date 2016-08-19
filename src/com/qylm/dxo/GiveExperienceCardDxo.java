package com.qylm.dxo;

import com.qylm.dto.myDesk.GiveExperienceCardDto;
import com.qylm.entity.CustomLeaguerDetail;

public final class GiveExperienceCardDxo {

	public static void dtoToEntity(GiveExperienceCardDto dto, CustomLeaguerDetail entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setGiveInfo(dto.getGiveInfo());
		entity.setMoney(dto.getMoney());
		entity.setNumber(dto.getNumber());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(CustomLeaguerDetail entity, GiveExperienceCardDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setGiveInfo(entity.getGiveInfo());
		dto.setMoney(entity.getMoney());
		dto.setNumber(entity.getNumber());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
