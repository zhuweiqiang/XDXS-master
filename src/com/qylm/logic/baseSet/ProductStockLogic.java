package com.qylm.logic.baseSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.ProductStockDao;
import com.qylm.dao.ProductStockDetailDao;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;

public class ProductStockLogic {
	
	@Autowired
	private ProductStockDao productStockDao;
	
	@Autowired
	private ProductStockDetailDao productStockDetailDao;
	
	public void saveProductStock(ProductStock productStock,
			List<ProductStockDetail> productStockDetailList) {
		productStockDao.saveEntity(productStock);
		productStockDetailDao.saveEntityAll(productStockDetailList);
	}

	public void updateProductStock(ProductStock productStock,
			List<ProductStockDetail> productStockDetailList) {
		productStockDao.updateEntity(productStock);
		productStockDetailDao.saveOrUpdateAll(productStockDetailList);
	}
	
}
