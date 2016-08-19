package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ProductStockDao;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;
import com.qylm.logic.baseSet.ProductStockLogic;

@Service("productStockService")
public class ProductStockServiceImpl extends GenericFileServiceImpl<ProductStock, Integer> implements ProductStockService {
	
	@Autowired
	private ProductStockLogic productStockLogic;

	@Autowired
	protected ProductStockServiceImpl(ProductStockDao productStockDao) {
		super(productStockDao);
	}

	public void saveProductStock(ProductStock productStock,
			List<ProductStockDetail> productStockDetailList) {
		productStockLogic.saveProductStock(productStock, productStockDetailList);
	}

	public void updateProductStock(ProductStock productStock,
			List<ProductStockDetail> productStockDetailList) {
		productStockLogic.updateProductStock(productStock, productStockDetailList);
	}

}
