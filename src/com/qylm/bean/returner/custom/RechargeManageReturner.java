package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.RechargeManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.RechargeManageDto;
import com.qylm.entity.Recharge;

public class RechargeManageReturner extends Returner<RechargeManageBean, RechargeManageDto, Recharge> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4193135577720054333L;

	public RechargeManageReturner(RechargeManageDto rechargeManageDto, int currentPage) {
		super(rechargeManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(RechargeManageBean backBean) {
		backBean.setRechargeManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
