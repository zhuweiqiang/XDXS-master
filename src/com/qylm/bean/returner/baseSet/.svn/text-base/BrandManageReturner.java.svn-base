package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.BrandManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.BrandManageDto;
import com.qylm.entity.Brand;

public class BrandManageReturner extends Returner<BrandManageBean, BrandManageDto, Brand> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2676373681821790513L;

	public BrandManageReturner(BrandManageDto brandManageDto, int currentPage) {
		super(brandManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(BrandManageBean backBean) {
		backBean.setBrandManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
