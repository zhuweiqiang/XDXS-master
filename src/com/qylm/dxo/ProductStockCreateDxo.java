package com.qylm.dxo;

import com.qylm.dto.baseSet.ProductStockCreateDto;
import com.qylm.entity.ProductStock;

public final class ProductStockCreateDxo {

	public static void dtoToEntity(ProductStockCreateDto dto, ProductStock entity) {
		entity.setName(dto.getName());
		entity.setIntroduce(dto.getIntroduce());
		entity.setMoney(dto.getMoney());
		entity.setCost(dto.getCost());
		entity.setRemark(dto.getRemark());
		entity.setBrand(dto.getBrand());
		entity.setSeries(dto.getSeries());
		entity.setUnit(dto.getUnit());
		entity.setProductStockDetailList(dto.getProductStockDetailList());
		entity.setCreater(dto.getCreater());
		entity.setBelongingUser(dto.getBelongingUser());
	}

	public static void entityToDto(ProductStock entity, ProductStockCreateDto dto) {
		dto.setName(entity.getName());
		dto.setIntroduce(entity.getIntroduce());
		dto.setMoney(entity.getMoney());
		dto.setCost(entity.getCost());
		dto.setRemark(entity.getRemark());
		dto.setBrand(entity.getBrand());
		dto.setSeries(entity.getSeries());
		dto.setUnit(entity.getUnit());
		dto.setProductStockDetailList(entity.getProductStockDetailList());
		dto.setCreater(entity.getCreater());
		dto.setBelongingUser(entity.getBelongingUser());
	}

}
