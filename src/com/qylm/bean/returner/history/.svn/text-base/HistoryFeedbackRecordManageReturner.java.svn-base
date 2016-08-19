package com.qylm.bean.returner.history;

import com.qylm.bean.history.HistoryFeedbackRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.history.HistoryFeedbackRecordManageDto;
import com.qylm.entity.FeedbackRecord;

public class HistoryFeedbackRecordManageReturner extends Returner<HistoryFeedbackRecordManageBean, HistoryFeedbackRecordManageDto, FeedbackRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3713202648542739018L;

	public HistoryFeedbackRecordManageReturner(HistoryFeedbackRecordManageDto historyHistoryFeedbackRecordManageDto, int currentPage) {
		super(historyHistoryFeedbackRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(HistoryFeedbackRecordManageBean backBean) {
		backBean.setHistoryFeedbackRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
