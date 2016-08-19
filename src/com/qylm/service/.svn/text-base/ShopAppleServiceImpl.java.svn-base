package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.ShopAppleDao;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.logic.prepareGoods.ShopAppleLogic;

@Service("shopAppleService")
public class ShopAppleServiceImpl extends GenericServiceImpl<ShopApple, Integer> implements ShopAppleService {

	@Autowired
	private ShopAppleLogic shopAppleLogic;

	@Autowired
	protected ShopAppleServiceImpl(ShopAppleDao shopAppleDao) {
		super(shopAppleDao);
	}

	public void saveShopApple(ShopApple shopApple,
			List<ShopAppleDetail> shopAppleDetailList) {
		shopAppleLogic.saveShopApple(shopApple, shopAppleDetailList);
	}

	public void updateShopApple(ShopApple shopApple,
			List<ShopAppleDetail> shopAppleDetailList) {
		shopAppleLogic.updateShopApple(shopApple, shopAppleDetailList);
	}

	public void updateShopApple(ShopApple shopApple) {
		shopAppleLogic.updateShopApple(shopApple);
	}

}
