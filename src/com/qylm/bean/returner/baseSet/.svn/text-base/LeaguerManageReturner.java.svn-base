package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.LeaguerManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.LeaguerManageDto;
import com.qylm.entity.Leaguer;

public class LeaguerManageReturner extends Returner<LeaguerManageBean, LeaguerManageDto, Leaguer> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5508929811145506547L;

	public LeaguerManageReturner(LeaguerManageDto leaguerManageDto, int currentPage) {
		super(leaguerManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(LeaguerManageBean backBean) {
		backBean.setLeaguerManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
