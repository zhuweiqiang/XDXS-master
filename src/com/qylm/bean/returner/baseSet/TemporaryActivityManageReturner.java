package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.TemporaryActivityManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.TemporaryActivityManageDto;
import com.qylm.entity.TemporaryActivity;

public class TemporaryActivityManageReturner extends Returner<TemporaryActivityManageBean, TemporaryActivityManageDto, TemporaryActivity> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7502948907251496887L;

	public TemporaryActivityManageReturner(TemporaryActivityManageDto temporaryActivityManageDto, int currentPage) {
		super(temporaryActivityManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(TemporaryActivityManageBean backBean) {
		backBean.setTemporaryActivityManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
