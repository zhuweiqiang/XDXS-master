package com.qylm.service;

import com.qylm.entity.ProductDepotAllot;
import com.qylm.exception.ProductDepotAllotException;

public interface ProductDepotAllotService extends GenericService<ProductDepotAllot, Integer> {

	/**
	 * 保存产品库存调拨数据，但是如果数据中是state为true时，更新产品库存
	 * @param productDepotAllot
	 */
	public void saveProductDepotAllot(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException;
	
	/**
	 * 保存产品库存调拨数据，但是如果数据中是state为true时，更新产品库存
	 * @param productDepotAllot
	 */
	public void updateProductDepotAllot(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException;
}
