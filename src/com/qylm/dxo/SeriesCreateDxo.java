package com.qylm.dxo;

import com.qylm.dto.baseSet.SeriesCreateDto;
import com.qylm.entity.Series;

public final class SeriesCreateDxo {

	public static void dtoToEntity(SeriesCreateDto dto, Series entity) {
		entity.setBrand(dto.getBrand());
		entity.setName(dto.getName());
		entity.setRemark(dto.getRemark());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(Series entity, SeriesCreateDto dto) {
		dto.setBrand(entity.getBrand());
		dto.setName(entity.getName());
		dto.setRemark(entity.getRemark());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
