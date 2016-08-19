package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.MarketingRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.MarketingRecordManageDto;
import com.qylm.entity.MarketingRecord;

public class MarketingRecordManageReturner extends Returner<MarketingRecordManageBean, MarketingRecordManageDto, MarketingRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7388413813240436687L;

	public MarketingRecordManageReturner(MarketingRecordManageDto marketingRecordManageDto, int currentPage) {
		super(marketingRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(MarketingRecordManageBean backBean) {
		backBean.setMarketingRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
