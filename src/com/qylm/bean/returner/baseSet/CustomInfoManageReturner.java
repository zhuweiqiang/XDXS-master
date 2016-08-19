package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.CustomInfoManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.CustomInfoManageDto;
import com.qylm.entity.CustomInfo;

public class CustomInfoManageReturner extends Returner<CustomInfoManageBean, CustomInfoManageDto, CustomInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1562870811821693640L;

	public CustomInfoManageReturner(CustomInfoManageDto customInfoManageDto, int currentPage) {
		super(customInfoManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(CustomInfoManageBean backBean) {
		backBean.setCustomInfoManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
