package com.qylm.logic.prepareGoods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dao.AuditingSetDetailDao;
import com.qylm.dao.ProductStockDetailDao;
import com.qylm.dao.ShopAppleDao;
import com.qylm.dao.ShopAppleDetailDao;
import com.qylm.dao.ShopAuditingDao;
import com.qylm.entity.AuditingSet;
import com.qylm.entity.AuditingSetDetail;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.entity.ShopAuditing;

public class ShopAppleLogic {
	
	@Autowired
	private ShopAppleDao shopAppleDao;
	
	@Autowired
	private ShopAppleDetailDao shopAppleDetailDao;
	
	@Autowired
	private ShopAuditingDao shopAuditingDao;
	
	@Autowired
	private AuditingSetDetailDao auditingSetDetailDao;
	
	@Autowired
	private ProductStockDetailDao productStockDetailDao;
	
	public void saveShopApple(ShopApple shopApple,
			List<ShopAppleDetail> shopAppleDetailList) {
		shopAppleDao.saveEntity(shopApple);
		shopAppleDetailDao.saveEntityAll(shopAppleDetailList);
		apple(shopApple);
	}

	public void updateShopApple(ShopApple shopApple,
			List<ShopAppleDetail> shopAppleDetailList) {
		shopAppleDao.updateEntity(shopApple);
		shopAppleDetailDao.saveOrUpdateAll(shopAppleDetailList);
		apple(shopApple);
	}
	
	public void updateShopApple(ShopApple shopApple) {
		shopAppleDao.updateEntity(shopApple);
		apple(shopApple);
	}
	
	private void apple(ShopApple shopApple) {
		if (ShopApple.APPLE_STATE_2.equals(shopApple.getAppleState())) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AuditingSetDetail.class);
			detachedCriteria.createAlias(AuditingSetDetail.AUDITING_SET, AuditingSetDetail.AUDITING_SET, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(AuditingSetDetail.AUDITING_SET_APPLE_NUMBER, AuditingSet.APPLY_NUMBER_2));
			List<AuditingSetDetail> auditingSetDetailList = auditingSetDetailDao.getByDetachedCriteria(detachedCriteria);
			if (!auditingSetDetailList.isEmpty()) {
				List<ShopAuditing> shopAuditingList = new ArrayList<ShopAuditing>();
				ShopAuditing shopAuditing;
				for (AuditingSetDetail auditingSetDetail : auditingSetDetailList) {
					shopAuditing = new ShopAuditing();
					shopAuditing.setAuditor(auditingSetDetail.getAuditor());
					shopAuditing.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
					shopAuditing.setCreater(shopApple.getCreater());
					shopAuditing.setBelongingUser(shopApple.getBelongingUser());
					shopAuditing.setSequence(auditingSetDetail.getSequence());
					shopAuditing.setShopApple(shopApple);
					shopAuditing.setState(ShopAuditing.STATE_1);
					shopAuditingList.add(shopAuditing);
				}
				shopAuditingDao.saveEntityAll(shopAuditingList);
			} else {
				// 如果没有设定过审核流程，直接
				shopApple.setAppleState(ShopApple.APPLE_STATE_3);
			}
		} else if (ShopApple.APPLE_STATE_5.equals(shopApple.getAppleState())) {
			// 取出要入库的产品
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopAppleDetail.class);
			detachedCriteria.createAlias(ShopAppleDetail.PRODUCT_STOCK, ShopAppleDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ShopAppleDetail.SHOP_APPLE, ShopAppleDetail.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ShopAppleDetail.SHOP_APPLE, shopApple));
			shopApple.setShopAppleDetailList(shopAppleDetailDao.getByDetachedCriteria(detachedCriteria));
			
			List<ShopAppleDetail> shopAppleDetailList = shopApple.getShopAppleDetailList();
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			for (ShopAppleDetail shopAppleDetail : shopAppleDetailList) {
				productStockList.add(shopAppleDetail.getProductStock());
			}
			// 查询库存是否有数据，如果有更新，没有就新增
			detachedCriteria = DetachedCriteria.forClass(ProductStockDetail.class);
			detachedCriteria.createAlias(ProductStockDetail.PRODUCT_STOCK, ProductStockDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ProductStockDetail.DEPOT_INFO, ProductStockDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ProductStockDetail.DEPOT_INFO, shopApple.getDepotInfo()));
			detachedCriteria.add(Restrictions.in(ProductStockDetail.PRODUCT_STOCK, productStockList));
			List<ProductStockDetail> productStockDetailList = productStockDetailDao.getByDetachedCriteria(detachedCriteria);
			List<ProductStockDetail> saveDetailList = new ArrayList<ProductStockDetail>();
			for (ShopAppleDetail shopAppleDetail : shopAppleDetailList) {
				boolean state = false;
				for (ProductStockDetail productStockDetail : productStockDetailList) {
					if (shopAppleDetail.getProductStock().equals(productStockDetail.getProductStock())) {
						state = true;
						BigDecimal number = productStockDetail.getNumber();
						if (BigDecimalUtil.isNullOrZero(number)) {
							number = Constants.BIGDECIMAL_1_ZERO;
						}
						productStockDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
						productStockDetail.setNumber(BigDecimalUtil.add(number, shopAppleDetail.getRealityNumber()));
					}
				}
				if (!state) {
					ProductStockDetail detail = new ProductStockDetail();
					detail.setDepotInfo(shopApple.getDepotInfo());
					detail.setProductStock(shopAppleDetail.getProductStock());
					detail.setNumber(shopAppleDetail.getRealityNumber());
					detail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
					detail.setCreater(shopApple.getCreater());
					detail.setBelongingUser(shopApple.getBelongingUser());
					saveDetailList.add(detail);
				}
			}
			if (!productStockDetailList.isEmpty()) {
				productStockDetailDao.updateEntityAll(productStockDetailList);
			}
			if (!saveDetailList.isEmpty()) {
				productStockDetailDao.saveEntityAll(saveDetailList);
			}
		}
	}
	
}
