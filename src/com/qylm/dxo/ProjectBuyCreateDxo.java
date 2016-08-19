package com.qylm.dxo;

import com.qylm.dto.custom.ProjectBuyCreateDto;
import com.qylm.entity.ProjectBuy;

public final class ProjectBuyCreateDxo {

	public static void dtoToEntity(ProjectBuyCreateDto dto, ProjectBuy entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setState(dto.isState());
		entity.setProjectBuyDetailList(dto.getProjectBuyDetailList());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(ProjectBuy entity, ProjectBuyCreateDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setState(entity.isState());
		dto.setProjectBuyDetailList(entity.getProjectBuyDetailList());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
