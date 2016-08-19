package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ShopAuditingDao;
import com.qylm.entity.ShopAuditing;
import com.qylm.logic.auditing.ShopAuditingLogic;

@Service("shopAuditingService")
public class ShopAuditingServiceImpl extends GenericServiceImpl<ShopAuditing, Integer> implements ShopAuditingService {

	@Autowired
	private ShopAuditingLogic shopAuditingLogic;
	
	@Autowired
	protected ShopAuditingServiceImpl(ShopAuditingDao shopAuditingDao) {
		super(shopAuditingDao);
	}

	public void updateShopAuditing(ShopAuditing shopAuditing) {
		shopAuditingLogic.updateShopAuditing(shopAuditing);
	}

}
