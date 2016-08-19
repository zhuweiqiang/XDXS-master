package com.qylm.dxo;

import com.qylm.dto.baseSet.GiveInfoViewDto;
import com.qylm.entity.GiveInfo;

public final class GiveInfoViewDxo {

	public static void dtoToEntity(GiveInfoViewDto dto, GiveInfo entity) {
		entity.setTitle(dto.getTitle());
		entity.setMoney(dto.getMoney());
		entity.setRebate(dto.getRebate());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(GiveInfo entity, GiveInfoViewDto dto) {
		dto.setTitle(entity.getTitle());
		dto.setMoney(entity.getMoney());
		dto.setRebate(entity.getRebate());
		dto.setCreater(entity.getCreater());
	}

}
