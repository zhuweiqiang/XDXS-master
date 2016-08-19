package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.GiveInfoManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.GiveInfoManageDto;
import com.qylm.entity.GiveInfo;

public class GiveInfoManageReturner extends Returner<GiveInfoManageBean, GiveInfoManageDto, GiveInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5572379070558114899L;

	public GiveInfoManageReturner(GiveInfoManageDto giveInfoManageDto, int currentPage) {
		super(giveInfoManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(GiveInfoManageBean backBean) {
		backBean.setGiveInfoManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
