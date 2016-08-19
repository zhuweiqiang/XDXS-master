package com.qylm.dxo;

import com.qylm.dto.baseSet.SeriesViewDto;
import com.qylm.entity.Series;

public final class SeriesViewDxo {

	public static void dtoToEntity(SeriesViewDto dto, Series entity) {
		entity.setBrand(dto.getBrand());
		entity.setName(dto.getName());
		entity.setRemark(dto.getRemark());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(Series entity, SeriesViewDto dto) {
		dto.setBrand(entity.getBrand());
		dto.setName(entity.getName());
		dto.setRemark(entity.getRemark());
		dto.setCreater(entity.getCreater());
	}

}
