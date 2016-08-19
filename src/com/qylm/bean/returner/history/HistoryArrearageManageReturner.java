package com.qylm.bean.returner.history;

import com.qylm.bean.history.HistoryArrearageManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.CustomInfoManageDto;
import com.qylm.dto.history.HistoryArrearageManageDto;
import com.qylm.entity.CustomInfo;


public class HistoryArrearageManageReturner extends Returner<HistoryArrearageManageBean,HistoryArrearageManageDto,CustomInfo>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7242229670896812276L;

	public HistoryArrearageManageReturner(HistoryArrearageManageDto historyArrearageManageDto, int currentPage) {
		super(historyArrearageManageDto, currentPage);
	}
	@Override
	public String returnOnly(HistoryArrearageManageBean backBean) {
		backBean.setHistoryArrearageManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
