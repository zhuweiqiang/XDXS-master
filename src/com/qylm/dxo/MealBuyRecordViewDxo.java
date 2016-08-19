package com.qylm.dxo;

import com.qylm.dto.custom.MealBuyRecordViewDto;
import com.qylm.entity.MealBuyRecord;

public final class MealBuyRecordViewDxo {

	public static void dtoToEntity(MealBuyRecordViewDto dto, MealBuyRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setDate(dto.getDate());
		entity.setTemporaryActivity(dto.getTemporaryActivity());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(MealBuyRecord entity, MealBuyRecordViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setDate(entity.getDate());
		dto.setTemporaryActivity(entity.getTemporaryActivity());
		dto.setCreater(entity.getCreater());
	}

}
