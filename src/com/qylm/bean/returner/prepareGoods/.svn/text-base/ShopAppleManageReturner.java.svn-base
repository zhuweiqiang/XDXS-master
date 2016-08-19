package com.qylm.bean.returner.prepareGoods;

import com.qylm.bean.prepareGoods.ShopAppleManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.prepareGoods.ShopAppleManageDto;
import com.qylm.entity.ShopApple;

public class ShopAppleManageReturner extends Returner<ShopAppleManageBean, ShopAppleManageDto, ShopApple> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6292357377760027567L;

	public ShopAppleManageReturner(ShopAppleManageDto shopAppleManageDto, int currentPage) {
		super(shopAppleManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ShopAppleManageBean backBean) {
		backBean.setShopAppleManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
