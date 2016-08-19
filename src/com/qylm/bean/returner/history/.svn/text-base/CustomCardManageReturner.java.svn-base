package com.qylm.bean.returner.history;

import com.qylm.bean.history.CustomCardManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.history.CustomCardManageDto;
import com.qylm.entity.CustomLeaguerDetail;

public class CustomCardManageReturner  extends Returner<CustomCardManageBean, CustomCardManageDto, CustomLeaguerDetail>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7770061020866822791L;
	
	public CustomCardManageReturner(CustomCardManageDto customCardManageDto, int currentPage) {
		super(customCardManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(CustomCardManageBean backBean) {
		backBean.setCustomCardManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
