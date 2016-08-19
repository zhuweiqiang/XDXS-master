package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.ConversionTreatmentManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.ConversionTreatmentManageDto;
import com.qylm.entity.ConversionTreatment;

public class ConversionTreatmentManageReturner extends Returner<ConversionTreatmentManageBean, ConversionTreatmentManageDto, ConversionTreatment> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3966720778468165493L;

	public ConversionTreatmentManageReturner(ConversionTreatmentManageDto conversionTreatmentManageDto, int currentPage) {
		super(conversionTreatmentManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ConversionTreatmentManageBean backBean) {
		backBean.setConversionTreatmentManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
