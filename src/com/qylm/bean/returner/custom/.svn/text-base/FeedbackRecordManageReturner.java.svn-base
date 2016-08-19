package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.FeedbackRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.FeedbackRecordManageDto;
import com.qylm.entity.FeedbackRecord;

public class FeedbackRecordManageReturner extends Returner<FeedbackRecordManageBean, FeedbackRecordManageDto, FeedbackRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3702503413316758601L;

	public FeedbackRecordManageReturner(FeedbackRecordManageDto feedbackRecordManageDto, int currentPage) {
		super(feedbackRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(FeedbackRecordManageBean backBean) {
		backBean.setFeedbackRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
