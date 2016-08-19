package com.qylm.bean.returner.history;

import com.qylm.bean.history.HistoryTemporaryManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.history.HistoryTemporaryManageDto;
import com.qylm.entity.MealBuyRecord;

public class HistoryTemporaryManageReturner extends Returner<HistoryTemporaryManageBean, HistoryTemporaryManageDto, MealBuyRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9154105230567774044L;

	public HistoryTemporaryManageReturner(HistoryTemporaryManageDto historyTemporaryManageDto, int currentPage) {
		super(historyTemporaryManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(HistoryTemporaryManageBean backBean) {
		backBean.setHistoryTemporaryManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
