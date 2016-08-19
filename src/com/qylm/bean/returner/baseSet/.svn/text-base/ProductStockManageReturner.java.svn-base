package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.ProductStockManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.ProductStockManageDto;
import com.qylm.entity.ProductStock;

public class ProductStockManageReturner extends Returner<ProductStockManageBean, ProductStockManageDto, ProductStock> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3783113905956992210L;

	public ProductStockManageReturner(ProductStockManageDto productStockManageDto, int currentPage) {
		super(productStockManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ProductStockManageBean backBean) {
		backBean.setProductStockManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
