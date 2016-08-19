package com.qylm.bean.returner.auditing;

import com.qylm.bean.auditing.ShopAuditingManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.auditing.ShopAuditingManageDto;
import com.qylm.entity.ShopAuditing;

public class ShopAuditingManageReturner extends Returner<ShopAuditingManageBean, ShopAuditingManageDto, ShopAuditing> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7952709520614625050L;

	public ShopAuditingManageReturner(ShopAuditingManageDto shopAuditingManageDto, int currentPage) {
		super(shopAuditingManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ShopAuditingManageBean backBean) {
		backBean.setShopAuditingManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
