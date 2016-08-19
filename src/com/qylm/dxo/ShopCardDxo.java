package com.qylm.dxo;

import com.qylm.dto.myDesk.ShopCardDto;
import com.qylm.entity.ConsumptionRegister;

public final class ShopCardDxo {

	public static void dtoToEntity(ShopCardDto dto, ConsumptionRegister entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setRealityMoney(dto.getRealityMoney());
		entity.setBalance(dto.getBalance());
		entity.setState(dto.isState());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(ConsumptionRegister entity, ShopCardDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setRealityMoney(entity.getRealityMoney());
		dto.setState(entity.isState());
		dto.setBalance(entity.getBalance());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
