package com.qylm.dxo;

import com.qylm.dto.history.HistoryLargessRecordCreateDto;
import com.qylm.entity.LargessRecord;

public final class HistoryLargessRecordCreateDxo {

	public static void dtoToEntity(HistoryLargessRecordCreateDto dto, LargessRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setDate(dto.getDate());
		entity.setMarketingProject(dto.getMarketingProject());
		entity.setRemark(dto.getRemark());
		entity.setNumber(dto.getNumber());
		entity.setMoney(dto.getMoney());
		entity.setSurplusNumber(dto.getSurplusNumber());
		entity.setBalance(dto.getBalance());
		entity.setPersonnelInfo1(dto.getPersonnelInfo1());
		entity.setPersonnelInfo2(dto.getPersonnelInfo2());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(LargessRecord entity, HistoryLargessRecordCreateDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setDate(entity.getDate());
		dto.setMarketingProject(entity.getMarketingProject());
		dto.setRemark(entity.getRemark());
		dto.setNumber(entity.getNumber());
		dto.setMoney(entity.getMoney());
		dto.setSurplusNumber(entity.getSurplusNumber());
		dto.setBalance(entity.getBalance());
		dto.setPersonnelInfo1(entity.getPersonnelInfo1());
		dto.setPersonnelInfo2(entity.getPersonnelInfo2());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
