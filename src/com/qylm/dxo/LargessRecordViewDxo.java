package com.qylm.dxo;

import com.qylm.dto.custom.LargessRecordViewDto;
import com.qylm.entity.LargessRecord;

public final class LargessRecordViewDxo {

	public static void dtoToEntity(LargessRecordViewDto dto, LargessRecord entity) {
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
	}

	public static void entityToDto(LargessRecord entity, LargessRecordViewDto dto) {
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
	}

}
