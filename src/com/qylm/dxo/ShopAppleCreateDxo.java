package com.qylm.dxo;

import com.qylm.dto.prepareGoods.ShopAppleCreateDto;
import com.qylm.entity.ShopApple;

public final class ShopAppleCreateDxo {

	public static void dtoToEntity(ShopAppleCreateDto dto, ShopApple entity) {
		entity.setNumber(dto.getNumber());
		entity.setDepotInfo(dto.getDepotInfo());
		entity.setAppleDate(dto.getAppleDate());
		entity.setRemark(dto.getRemark());
		entity.setAppleState(dto.getAppleState());
		entity.setUser(dto.getUser());
		entity.setShopAppleDetailList(dto.getShopAppleDetailList());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(ShopApple entity, ShopAppleCreateDto dto) {
		dto.setNumber(entity.getNumber());
		dto.setDepotInfo(entity.getDepotInfo());
		dto.setAppleDate(entity.getAppleDate());
		dto.setRemark(entity.getRemark());
		dto.setAppleState(entity.getAppleState());
		dto.setUser(entity.getUser());
		dto.setShopAppleDetailList(entity.getShopAppleDetailList());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
