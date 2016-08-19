package com.qylm.dxo;

import com.qylm.dto.history.HistoryMarketingRecordViewDto;
import com.qylm.entity.MarketingRecord;

public final class HistoryMarketingRecordViewDxo {

	public static void dtoToEntity(HistoryMarketingRecordViewDto dto, MarketingRecord entity) {
		entity.setCustomInfo(dto.getCustomInfo());
		entity.setPersonnelInfo(dto.getPersonnelInfo());
		entity.setAdviser(dto.getAdviser());
		entity.setDate(dto.getDate());
		entity.setMoney(dto.getMoney());
		entity.setState(dto.isState());
		entity.setMarketingRecordDetailList(dto.getMarketingRecordDetailList());
	}

	public static void entityToDto(MarketingRecord entity, HistoryMarketingRecordViewDto dto) {
		dto.setCustomInfo(entity.getCustomInfo());
		dto.setPersonnelInfo(entity.getPersonnelInfo());
		dto.setAdviser(entity.getAdviser());
		dto.setDate(entity.getDate());
		dto.setMoney(entity.getMoney());
		dto.setState(entity.isState());
		dto.setMarketingRecordDetailList(entity.getMarketingRecordDetailList());
	}

}
