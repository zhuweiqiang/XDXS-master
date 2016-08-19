package com.qylm.bean.returner.custom;

import com.qylm.bean.custom.MealBuyRecordManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.custom.MealBuyRecordManageDto;
import com.qylm.entity.MealBuyRecord;

public class MealBuyRecordManageReturner extends Returner<MealBuyRecordManageBean, MealBuyRecordManageDto, MealBuyRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7946072717685759983L;

	public MealBuyRecordManageReturner(MealBuyRecordManageDto mealBuyRecordManageDto, int currentPage) {
		super(mealBuyRecordManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(MealBuyRecordManageBean backBean) {
		backBean.setMealBuyRecordManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
