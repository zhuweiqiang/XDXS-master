package com.qylm.bean.returner.history;

import com.qylm.bean.history.HistoryMarketingRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.history.HistoryMarketingRecordManageDto;
import com.qylm.entity.MarketingRecord;

public class HistoryMarketingRecordManageReturner extends Returner<HistoryMarketingRecordManageBean, HistoryMarketingRecordManageDto, MarketingRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3306962002152902044L;

	public HistoryMarketingRecordManageReturner(HistoryMarketingRecordManageDto historyMarketingRecordManageDto, int currentPage) {
		super(historyMarketingRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(HistoryMarketingRecordManageBean backBean) {
		backBean.setHistoryMarketingRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
