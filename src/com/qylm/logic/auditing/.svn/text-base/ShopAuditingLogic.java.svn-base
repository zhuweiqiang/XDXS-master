package com.qylm.logic.auditing;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.DateUtil;
import com.qylm.dao.ShopAppleDao;
import com.qylm.dao.ShopAppleDetailDao;
import com.qylm.dao.ShopAuditingDao;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.entity.ShopAuditing;

public class ShopAuditingLogic {

	@Autowired
	private ShopAuditingDao shopAuditingDao;
	
	@Autowired
	private ShopAppleDao shopAppleDao;
	
	@Autowired
	private ShopAppleDetailDao shopAppleDetailDao;
	
	public void updateShopAuditing(ShopAuditing shopAuditing) {
		ShopApple shopApple = shopAuditing.getShopApple();
		// 查询是否都已经审核完毕，都审核成功，更改店铺配货申请的申请状态为审核成功，如果有一个或者多个不通过审核就更改为审核未通过
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopAuditing.class);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE, ShopAuditing.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ShopAuditing.SHOP_APPLE, shopApple));
		detachedCriteria.add(Restrictions.not(Restrictions.eq(ShopAuditing.BASE_ID, shopAuditing.getId())));
		List<ShopAuditing> shopAuditingList = shopAuditingDao.getByDetachedCriteria(detachedCriteria);
		// 如果只有一个审核人员，就直接进行操作
		if (shopAuditingList.isEmpty()) {
			shopApple.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			if (ShopAuditing.STATE_2.equals(shopAuditing.getState())) {
				shopApple.setAppleState(ShopApple.APPLE_STATE_3);
			} else {
				shopApple.setAppleState(ShopApple.APPLE_STATE_4);
			}
			shopAppleDao.updateEntity(shopApple);
		} else {
			ShopApple apple = shopAuditingList.get(0).getShopApple();
			shopAuditingList.add(shopAuditing);
			List<String> stateList = new ArrayList<String>();
			for (int i = 0; i < shopAuditingList.size(); i++) {
				stateList.add(shopAuditingList.get(i).getState());
			}
			boolean state = false;
			apple.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			if (stateList.contains(ShopAuditing.STATE_1)) {
				state = true;
			} 
			if (!state) {
				if (stateList.contains(ShopAuditing.STATE_3)) {
					apple.setAppleState(ShopApple.APPLE_STATE_4);
				} else {
					apple.setAppleState(ShopApple.APPLE_STATE_3);
				}
				shopAppleDao.updateEntity(apple);
			}
		}
		shopAuditingDao.updateEntity(shopAuditing);
		// 更新店铺配货申请的详细表
		List<ShopAppleDetail> shopAppleDetailList = shopApple.getShopAppleDetailList();
		for (ShopAppleDetail shopAppleDetail : shopAppleDetailList) {
			shopAppleDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		}
		shopAppleDetailDao.updateEntityAll(shopAppleDetailList);
	}
	
}
