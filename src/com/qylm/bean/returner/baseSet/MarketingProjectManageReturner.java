package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.MarketingProjectManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.MarketingProjectManageDto;
import com.qylm.entity.MarketingProject;

public class MarketingProjectManageReturner extends Returner<MarketingProjectManageBean, MarketingProjectManageDto, MarketingProject> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6235894891021905478L;

	public MarketingProjectManageReturner(MarketingProjectManageDto marketingProjectManageDto, int currentPage) {
		super(marketingProjectManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(MarketingProjectManageBean backBean) {
		backBean.setMarketingProjectManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
