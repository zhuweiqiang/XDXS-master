package com.qylm.dxo;

import com.qylm.dto.custom.MarketingRecordViewDto;
import com.qylm.entity.MarketingRecord;

public final class MarketingRecordViewDxo {

	public static void dtoToEntity(MarketingRecordViewDto dto, MarketingRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setMarketingRecordDetailList(dto.getMarketingRecordDetailList());
		entity.setCreater(dto.getCreater());
	}

	public static void entityToDto(MarketingRecord entity, MarketingRecordViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setMarketingRecordDetailList(entity.getMarketingRecordDetailList());
		dto.setCreater(entity.getCreater());
	}

}
