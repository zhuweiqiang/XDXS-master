package com.qylm.dxo;

import com.qylm.dto.history.HistoryFeedbackRecordViewDto;
import com.qylm.entity.FeedbackRecord;

public final class HistoryFeedbackRecordViewDxo {

	public static void dtoToEntity(HistoryFeedbackRecordViewDto dto, FeedbackRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setDate(dto.getDate());
		entity.setRemark(dto.getRemark());
		entity.setMarketingProject(dto.getMarketingProject());
		entity.setProductStock(dto.getProductStock());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(FeedbackRecord entity, HistoryFeedbackRecordViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setDate(entity.getDate());
		dto.setRemark(entity.getRemark());
		dto.setMarketingProject(entity.getMarketingProject());
		dto.setProductStock(entity.getProductStock());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setCreater(entity.getCreater());
	}

}
