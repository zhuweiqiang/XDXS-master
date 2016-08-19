package com.qylm.dxo;

import com.qylm.dto.myDesk.RepaymentDto;
import com.qylm.entity.RepaymentRecord;

public final class RepaymentDxo {

	public static void dtoToEntity(RepaymentDto dto, RepaymentRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setBalance(dto.getBalance());
		entity.setReadyMoney(dto.getReadyMoney());
		entity.setState(dto.isState());
		entity.setRemark(dto.getRemark());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(RepaymentRecord entity, RepaymentDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setState(entity.isState());
		dto.setRemark(entity.getRemark());
		dto.setBalance(entity.getBalance());
		dto.setReadyMoney(entity.getReadyMoney());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
