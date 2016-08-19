package com.qylm.dxo;

import com.qylm.dto.auditing.ShopAuditingViewDto;
import com.qylm.entity.ShopAuditing;

public final class ShopAuditingViewDxo {

	public static void dtoToEntity(ShopAuditingViewDto dto, ShopAuditing entity) {
		entity.setShopApple(dto.getShopApple());
		entity.setAuditor(dto.getAuditor());
		entity.setRemark(dto.getRemark());
		entity.setDate(dto.getDate());
		entity.setState(dto.getState());
		entity.setSequence(dto.getSequence());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(ShopAuditing entity, ShopAuditingViewDto dto) {
		dto.setShopApple(entity.getShopApple());
		dto.setAuditor(entity.getAuditor());
		dto.setRemark(entity.getRemark());
		dto.setDate(entity.getDate());
		dto.setState(entity.getState());
		dto.setSequence(entity.getSequence());
		dto.setCreater(entity.getCreater());
	}

}
