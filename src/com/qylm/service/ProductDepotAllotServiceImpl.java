package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ProductDepotAllotDao;
import com.qylm.entity.ProductDepotAllot;
import com.qylm.exception.ProductDepotAllotException;
import com.qylm.logic.depot.ProductDepotAllotLogic;

@Service("productDepotAllotService")
public class ProductDepotAllotServiceImpl extends GenericServiceImpl<ProductDepotAllot, Integer> implements ProductDepotAllotService {

	@Autowired
	private ProductDepotAllotLogic productDepotAllotLogic;
	
	@Autowired
	protected ProductDepotAllotServiceImpl(ProductDepotAllotDao productDepotAllotDao) {
		super(productDepotAllotDao);
	}

	public void saveProductDepotAllot(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException {
		productDepotAllotLogic.saveProductDepotAllot(productDepotAllot);
	}

	public void updateProductDepotAllot(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException {
		productDepotAllotLogic.updateProductDepotAllot(productDepotAllot);
	}

}
