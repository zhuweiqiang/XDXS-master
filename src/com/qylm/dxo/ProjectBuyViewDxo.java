package com.qylm.dxo;

import com.qylm.dto.custom.ProjectBuyViewDto;
import com.qylm.entity.ProjectBuy;

public final class ProjectBuyViewDxo {

	public static void dtoToEntity(ProjectBuyViewDto dto, ProjectBuy entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setProjectBuyDetailList(dto.getProjectBuyDetailList());
	}

	public static void entityToDto(ProjectBuy entity, ProjectBuyViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setProjectBuyDetailList(entity.getProjectBuyDetailList());
	}

}
