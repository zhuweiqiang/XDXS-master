package com.qylm.dxo;

import com.qylm.dto.custom.RechargeCreateDto;
import com.qylm.entity.Recharge;

public final class RechargeCreateDxo {

	public static void dtoToEntity(RechargeCreateDto dto, Recharge entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setRechargeDate(dto.getRechargeDate());
		entity.setMoney(dto.getMoney());
		entity.setState(dto.isState());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(Recharge entity, RechargeCreateDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setRechargeDate(entity.getRechargeDate());
		dto.setMoney(entity.getMoney());
		dto.setState(entity.isState());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
