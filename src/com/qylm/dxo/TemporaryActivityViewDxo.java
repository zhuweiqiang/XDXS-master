package com.qylm.dxo;

import com.qylm.dto.baseSet.TemporaryActivityViewDto;
import com.qylm.entity.TemporaryActivity;

public final class TemporaryActivityViewDxo {

	public static void dtoToEntity(TemporaryActivityViewDto dto, TemporaryActivity entity) {
		entity.setName(dto.getName());
		entity.setRemark(dto.getRemark());
		entity.setMoney(dto.getMoney());
		entity.setState(dto.isState());
	}

	public static void entityToDto(TemporaryActivity entity, TemporaryActivityViewDto dto) {
		dto.setName(entity.getName());
		dto.setRemark(entity.getRemark());
		dto.setMoney(entity.getMoney());
		dto.setState(entity.isState());
	}

}
