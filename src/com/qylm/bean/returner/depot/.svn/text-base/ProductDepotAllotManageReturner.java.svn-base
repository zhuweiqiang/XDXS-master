package com.qylm.bean.returner.depot;

import com.qylm.bean.depot.ProductDepotAllotManageBean;
import com.qylm.bean.returner.Returner;
import com.qylm.dto.depot.ProductDepotAllotManageDto;
import com.qylm.entity.ProductDepotAllot;

public class ProductDepotAllotManageReturner extends Returner<ProductDepotAllotManageBean, ProductDepotAllotManageDto, ProductDepotAllot> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8521632308971085918L;

	public ProductDepotAllotManageReturner(ProductDepotAllotManageDto productDepotAllotManageDto, int currentPage) {
		super(productDepotAllotManageDto, currentPage);
	}
	
	@Override
	public String returnOnly(ProductDepotAllotManageBean backBean) {
		backBean.setProductDepotAllotManageDto(super.dto);
		return backBean.back(currentPage);
	}

}
