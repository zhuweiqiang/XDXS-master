package com.qylm.logic.depot;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dao.ProductDepotAllotDao;
import com.qylm.dao.ProductStockDetailDao;
import com.qylm.entity.ProductDepotAllot;
import com.qylm.entity.ProductStockDetail;
import com.qylm.exception.ProductDepotAllotException;

public class ProductDepotAllotLogic {
	
	@Autowired
	private ProductDepotAllotDao productDepotAllotDao;
	
	@Autowired
	private ProductStockDetailDao productStockDetailDao;
	
	public void saveProductDepotAllot(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException {
		operate(productDepotAllot);
		productDepotAllotDao.saveEntity(productDepotAllot);
	}

	public void updateProductDepotAllot(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException {
		operate(productDepotAllot);
		productDepotAllotDao.updateEntity(productDepotAllot);
	}
	
	private void operate(ProductDepotAllot productDepotAllot) throws ProductDepotAllotException {
		if (productDepotAllot.isState()) {
			// 查询出原数据，需要从原库存扣除数量
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStockDetail.class);
			detachedCriteria.createAlias(ProductStockDetail.DEPOT_INFO, ProductStockDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ProductStockDetail.DEPOT_INFO, productDepotAllot.getDepotInfo()));
			detachedCriteria.add(Restrictions.eq(ProductStockDetail.BASE_ID, productDepotAllot.getProductStockDetail().getId()));
			List<ProductStockDetail> detailYList = productStockDetailDao.getByDetachedCriteria(detachedCriteria);
			// 查询出调往的数据，需要从原库存扣除数量
			detachedCriteria = DetachedCriteria.forClass(ProductStockDetail.class);
			detachedCriteria.createAlias(ProductStockDetail.DEPOT_INFO, ProductStockDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ProductStockDetail.PRODUCT_STOCK, ProductStockDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ProductStockDetail.DEPOT_INFO, productDepotAllot.getAllotDepotInfo()));
			detachedCriteria.add(Restrictions.eq(ProductStockDetail.PRODUCT_STOCK, productDepotAllot.getProductStockDetail().getProductStock()));
			List<ProductStockDetail> detailDWList = productStockDetailDao.getByDetachedCriteria(detachedCriteria);
			if (!detailYList.isEmpty()) {
				ProductStockDetail productStockDetail = detailYList.get(0);
				// 验证库存是否充足
				if (BigDecimalUtil.bigThan(productStockDetail.getNumber(), productDepotAllot.getNumber())) {
					productStockDetail.setNumber(BigDecimalUtil.subtract(productStockDetail.getNumber(), productDepotAllot.getNumber()));
					ProductStockDetail detail;
					if (detailDWList.isEmpty()) {
						detail = new ProductStockDetail();
						detail.setCreater(productDepotAllot.getCreater());
						detail.setBelongingUser(productDepotAllot.getBelongingUser());
						detail.setDepotInfo(productDepotAllot.getAllotDepotInfo());
						detail.setProductStock(productDepotAllot.getProductStockDetail().getProductStock());
						detail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
						detail.setNumber(productDepotAllot.getNumber());
						productDepotAllot.setAllotProductStockDetail(productStockDetail);
					} else {
						detail = detailDWList.get(0);
						BigDecimal number = detail.getNumber();
						if (BigDecimalUtil.isNullOrZero(number)) {
							number = Constants.BIGDECIMAL_1_ZERO;
						}
						detail.setNumber(BigDecimalUtil.add(number, productDepotAllot.getNumber()));
						productDepotAllot.setAllotProductStockDetail(detail);
					}
					productStockDetailDao.updateEntity(productStockDetail);
					productStockDetailDao.saveOrUpdate(detail);
				} else {
					throw new ProductDepotAllotException("库存不足，不能完成更新！");
				}
				
			} else {
				throw new ProductDepotAllotException("数据被更新了，请重新操作！");
			}
		}
	}
	
}
