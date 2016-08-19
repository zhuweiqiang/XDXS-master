package com.qylm.dxo;

import com.qylm.dto.custom.ConsumptionRegisterViewDto;
import com.qylm.entity.ConsumptionRegister;

public final class ConsumptionRegisterViewDxo {

	public static void dtoToEntity(ConsumptionRegisterViewDto dto, ConsumptionRegister entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setRealityMoney(dto.getRealityMoney());
		entity.setDebt(dto.getDebt());
		entity.setState(dto.isState());
		entity.setConsumptionRegisterDetailList(dto.getConsumptionRegisterDetailList());
	}

	public static void entityToDto(ConsumptionRegister entity, ConsumptionRegisterViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setRealityMoney(entity.getRealityMoney());
		dto.setDebt(entity.getDebt());
		dto.setState(entity.isState());
		dto.setConsumptionRegisterDetailList(entity.getConsumptionRegisterDetailList());
	}

}
