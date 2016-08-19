package com.qylm.dxo;

import com.qylm.dto.custom.ConversionTreatmentCreateDto;
import com.qylm.entity.ConversionTreatment;

public final class ConversionTreatmentCreateDxo {

	public static void dtoToEntity(ConversionTreatmentCreateDto dto, ConversionTreatment entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setState(dto.isState());
		entity.setConversionTreatmentDetailList(dto.getConversionTreatmentDetailList());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(ConversionTreatment entity, ConversionTreatmentCreateDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setState(entity.isState());
		dto.setConversionTreatmentDetailList(entity.getConversionTreatmentDetailList());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
