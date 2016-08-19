package com.qylm.dxo;

import com.qylm.dto.myDesk.CustomLeaguerOperationDto;
import com.qylm.entity.CustomLeaguerOperation;

public final class CustomLeaguerOperationDxo {

	public static void dtoToEntity(CustomLeaguerOperationDto dto, CustomLeaguerOperation entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setCustomLeaguerDetail(dto.getCustomLeaguerDetail());
		entity.setDeposit(dto.getDeposit());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setState(dto.isState());
		entity.setType(dto.getType());
		entity.setRemark(dto.getRemark());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(CustomLeaguerOperation entity, CustomLeaguerOperationDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setCustomLeaguerDetail(entity.getCustomLeaguerDetail());
		dto.setDeposit(entity.getDeposit());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setState(entity.isState());
		dto.setRemark(entity.getRemark());
		dto.setType(entity.getType());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
