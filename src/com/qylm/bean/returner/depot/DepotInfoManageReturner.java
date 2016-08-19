package com.qylm.bean.returner.depot;

import com.qylm.bean.depot.DepotInfoManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.depot.DepotInfoManageDto;
import com.qylm.entity.DepotInfo;

public class DepotInfoManageReturner extends Returner<DepotInfoManageBean, DepotInfoManageDto, DepotInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 90918482990528552L;

	public DepotInfoManageReturner(DepotInfoManageDto depotInfoManageDto, int currentPage) {
		super(depotInfoManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(DepotInfoManageBean backBean) {
		backBean.setDepotInfoManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
