package com.qylm.dxo;

import com.qylm.dto.system.FunctionManageDto;
import com.qylm.entity.Function;

public final class FunctionManageDxo {

	public static void dtoToEntity(FunctionManageDto dto, Function entity) {
		entity.setLabel(dto.getLabel());
		entity.setEnable(dto.isEnable());
		entity.setRank(dto.getRank());
	}

	public static void entityToDto(Function entity, FunctionManageDto dto) {
		dto.setLabel(entity.getLabel());
		dto.setEnable(entity.isEnable());
		dto.setRank(entity.getRank());
	}

}
