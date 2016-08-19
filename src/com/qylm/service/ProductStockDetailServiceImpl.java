package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ProductStockDetailDao;
import com.qylm.entity.ProductStockDetail;

@Service("productStockDetailService")
public class ProductStockDetailServiceImpl extends GenericServiceImpl<ProductStockDetail, Integer> implements ProductStockDetailService {

	@Autowired
	protected ProductStockDetailServiceImpl(ProductStockDetailDao productStockDetailDao) {
		super(productStockDetailDao);
	}

}
