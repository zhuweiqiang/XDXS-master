package com.qylm.dxo;

import com.qylm.dto.myDesk.ServiceConsumptionDto;
import com.qylm.entity.ConsumptionRegister;

public final class ServiceConsumptionDxo {

	public static void dtoToEntity(ServiceConsumptionDto dto, ConsumptionRegister entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setRealityMoney(dto.getRealityMoney());
		entity.setBalance(dto.getBalance());
		entity.setState(dto.isState());
		entity.setConsumptionRegisterDetailList(dto.getConsumptionRegisterDetailList());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(ConsumptionRegister entity, ServiceConsumptionDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setRealityMoney(entity.getRealityMoney());
		dto.setState(entity.isState());
		dto.setConsumptionRegisterDetailList(entity.getConsumptionRegisterDetailList());
		dto.setBalance(entity.getBalance());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
