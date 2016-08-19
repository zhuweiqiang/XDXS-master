package com.qylm.dxo;

import com.qylm.dto.history.HistoryTemporaryViewDto;
import com.qylm.entity.MealBuyRecord;

public final class HistoryTemporaryViewDxo {

	public static void dtoToEntity(HistoryTemporaryViewDto dto, MealBuyRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setDate(dto.getDate());
		entity.setTemporaryActivity(dto.getTemporaryActivity());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setNumber(dto.getNumber());
		entity.setRealityMoney(dto.getRealityMoney());
		entity.setState(dto.isState());
	}

	public static void entityToDto(MealBuyRecord entity, HistoryTemporaryViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setDate(entity.getDate());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setNumber(entity.getNumber());
		dto.setRealityMoney(entity.getRealityMoney());
		dto.setState(entity.isState());
		dto.setTemporaryActivity(entity.getTemporaryActivity());
	}

}
