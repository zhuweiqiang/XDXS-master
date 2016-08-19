package com.qylm.logic.custom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.MothedUtil;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.dao.MarketingRecordDao;
import com.qylm.dao.MarketingRecordDetailDao;
import com.qylm.dao.ProductStockDetailDao;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;

public class MarketingRecordLogic {
	
	@Autowired
	private MarketingRecordDao marketingRecordDao;
	
	@Autowired
	private MarketingRecordDetailDao marketingRecordDetailDao;
	
	@Autowired
	private ProductStockDetailDao productStockDetailDao;
	
	@Autowired
	private ConsumptionRegisterLogic consumptionRegisterLogic;
	
	public void saveMarketingRecord(MarketingRecord marketingRecord,
			List<MarketingRecordDetail> marketingRecordDetailList) {
		marketingRecordDao.saveEntity(marketingRecord);
		marketingRecordDetailDao.saveEntityAll(marketingRecordDetailList);
		operate(marketingRecord, marketingRecordDetailList);
	}

	public void updateMarketingRecord(MarketingRecord marketingRecord,
			List<MarketingRecordDetail> marketingRecordDetailList) {
		marketingRecordDao.updateEntity(marketingRecord);
		marketingRecordDetailDao.saveOrUpdateAll(marketingRecordDetailList);
		operate(marketingRecord, marketingRecordDetailList);
	}
	
	private void operate(MarketingRecord marketingRecord, List<MarketingRecordDetail> marketingRecordDetailList) {
		if (marketingRecord.isState() && marketingRecordDetailList != null && !marketingRecordDetailList.isEmpty()) {
			// 扣除产品库存
			List<DepotInfo> depotInfoList = new ArrayList<DepotInfo>();
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
				depotInfoList.add(marketingRecordDetail.getDepotInfo());
				productStockList.add(marketingRecordDetail.getProductStock());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStockDetail.class);
			detachedCriteria.createAlias(ProductStockDetail.DEPOT_INFO, ProductStockDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ProductStockDetail.PRODUCT_STOCK, ProductStockDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(ProductStockDetail.DEPOT_INFO, depotInfoList));
			detachedCriteria.add(Restrictions.in(ProductStockDetail.PRODUCT_STOCK, productStockList));
			List<ProductStockDetail> productStockDetailList = productStockDetailDao.getByDetachedCriteria(detachedCriteria);
			for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
				for (ProductStockDetail productStockDetail : productStockDetailList) {
					if (marketingRecordDetail.getDepotInfo().equals(productStockDetail.getDepotInfo())
							&& marketingRecordDetail.getProductStock().equals(productStockDetail.getProductStock())) {
						BigDecimal subtract = BigDecimalUtil.subtract(productStockDetail.getNumber(), BigDecimalUtil.toBigDecimal(marketingRecordDetail.getNumber()));
						productStockDetail.setNumber(subtract);
						break;
					}
				}
			}
			productStockDetailDao.updateEntityAll(productStockDetailList);
		}
	}
	
	public void savePay(MarketingRecord marketingRecord, BigDecimal money, BigDecimal balance,
			BigDecimal readyMoney,
			CustomLeaguerDetail customLeaguerDetail,
			List<MarketingRecordDetail> marketingRecordDetailList) {
		// 得到消费登记
		ConsumptionRegister consumptionRegister = consumptionRegisterLogic.getConsumptionRegister(marketingRecord.getCustomInfo(), marketingRecord.getPersonnelInfo(), marketingRecord.getAdviser(), marketingRecord.getDate(), marketingRecord.getMoney(), marketingRecord.getCreater());
		consumptionRegister.setType(ConsumptionRegister.TYPE_4);
		if (customLeaguerDetail != null) {
			consumptionRegister.setRebate(customLeaguerDetail.getRebate());
		} else {
			consumptionRegister.setRebate(new BigDecimal("10.0"));
		}
		// 得到消费登记详细
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = getConsumptionRegisterDetailList(consumptionRegister, marketingRecordDetailList);
		// 建立各个卡项的消费记录
		consumptionRegisterLogic.saveConsumptionRegisterDetail(marketingRecord.getCustomInfo(), marketingRecord.getDate(), money, balance, readyMoney, marketingRecord.getCreater(), customLeaguerDetail, consumptionRegister, consumptionRegisterDetailList);
		// 保存到记录
		marketingRecordDao.saveEntity(marketingRecord);
		marketingRecordDetailDao.saveOrUpdateAll(marketingRecordDetailList);
	}
	
	/**
	 * 保存购买的套餐信息
	 * @param consumptionRegister
	 * @param customLeaguerDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList(ConsumptionRegister consumptionRegister, List<MarketingRecordDetail> marketingRecordDetailList) {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
		ConsumptionRegisterDetail consumptionRegisterDetail;
		for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
			consumptionRegisterDetail = new ConsumptionRegisterDetail();
			consumptionRegisterDetail.setConsumptionRegister(consumptionRegister);
			consumptionRegisterDetail.setCreater(consumptionRegister.getCreater());
			consumptionRegisterDetail.setBelongingUser(MothedUtil.getBelongingUser(consumptionRegister.getCreater()));
			consumptionRegisterDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionRegisterDetail.setProductStock(marketingRecordDetail.getProductStock());
			consumptionRegisterDetail.setMoney(marketingRecordDetail.getMoney());
			consumptionRegisterDetailList.add(consumptionRegisterDetail);
		}
		return consumptionRegisterDetailList;
	}
	
}
