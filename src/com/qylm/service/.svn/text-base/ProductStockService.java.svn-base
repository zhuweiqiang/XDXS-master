package com.qylm.service;

import java.util.List;

import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;

public interface ProductStockService extends GenericFileService<ProductStock, Integer> {

	/**
	 * 保存产品库存的时候，保存产品库存详细
	 * @param productStock 产品库存
	 * @param productStockDetailList 产品库存详细
	 */
	public void saveProductStock(ProductStock productStock, List<ProductStockDetail> productStockDetailList);
	
	/**
	 * 更新产品库存的时候，更新产品库存详细
	 * @param productStock 产品库存
	 * @param productStockDetailList 产品库存详细
	 */
	public void updateProductStock(ProductStock productStock, List<ProductStockDetail> productStockDetailList);
	
}
