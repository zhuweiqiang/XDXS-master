package com.qylm.bean.returner.history;

import com.qylm.bean.history.HistoryLargessRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.history.HistoryLargessRecordManageDto;
import com.qylm.entity.LargessRecord;

public class HistoryLargessRecordManageReturner extends Returner<HistoryLargessRecordManageBean, HistoryLargessRecordManageDto, LargessRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2480281217442645160L;

	public HistoryLargessRecordManageReturner(HistoryLargessRecordManageDto historyHistoryLargessRecordManageDto, int currentPage) {
		super(historyHistoryLargessRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(HistoryLargessRecordManageBean backBean) {
		backBean.setHistoryLargessRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
