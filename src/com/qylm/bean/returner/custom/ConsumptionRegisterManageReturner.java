package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.ConsumptionRegisterManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.ConsumptionRegisterManageDto;
import com.qylm.entity.ConsumptionRegister;

public class ConsumptionRegisterManageReturner extends Returner<ConsumptionRegisterManageBean, ConsumptionRegisterManageDto, ConsumptionRegister> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1673444153222362654L;

	public ConsumptionRegisterManageReturner(ConsumptionRegisterManageDto consumptionRegisterManageDto, int currentPage) {
		super(consumptionRegisterManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ConsumptionRegisterManageBean backBean) {
		backBean.setConsumptionRegisterManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
