package com.qylm.dxo;

import com.qylm.dto.system.TreeItemManageDto;
import com.qylm.entity.TreeItem;

public final class TreeItemManageDxo {

	public static void dtoToEntity(TreeItemManageDto dto, TreeItem entity) {
		entity.setNodeId(dto.getNodeId());
		entity.setDisplayChildRen(dto.isDisplayChildRen());
		entity.setLabel(dto.getLabel());
		entity.setAction(dto.getAction());
		entity.setTarget(dto.getTarget());
		entity.setOrder(dto.getOrder());
		entity.setNodeType(dto.getNodeType());
	}

	public static void entityToDto(TreeItem entity, TreeItemManageDto dto) {
		dto.setNodeId(entity.getNodeId());
		dto.setDisplayChildRen(entity.isDisplayChildRen());
		dto.setLabel(entity.getLabel());
		dto.setAction(entity.getAction());
		dto.setTarget(entity.getTarget());
		dto.setOrder(entity.getOrder());
		dto.setNodeType(entity.getNodeType());
	}

}
