package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ShopAppleDetailDao;
import com.qylm.entity.ShopAppleDetail;

@Service("shopAppleDetailService")
public class ShopAppleDetailServiceImpl extends GenericServiceImpl<ShopAppleDetail, Integer> implements ShopAppleDetailService {

	@Autowired
	protected ShopAppleDetailServiceImpl(ShopAppleDetailDao shopAppleDetailDao) {
		super(shopAppleDetailDao);
	}

}
