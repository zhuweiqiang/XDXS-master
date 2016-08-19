package com.qylm.bean.returner.baseSet;

import com.qylm.bean.baseSet.ProductStockCreateBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.baseSet.ProductStockCreateDto;
import com.qylm.entity.ProductStock;

public class ProductStockCreateReturner extends Returner<ProductStockCreateBean, ProductStockCreateDto, ProductStock> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8119800793683027258L;

	public ProductStockCreateReturner(ProductStockCreateDto productStockCreateDto) {
		super(productStockCreateDto);
	}
	
	@Override
	public String returnOnly(ProductStockCreateBean backBean) {
		backBean.setProductStockCreateDto(super.dto);
		return backBean.returner();
	}

}
