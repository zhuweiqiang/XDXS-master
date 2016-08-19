package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;

public interface MarketingRecordService extends GenericService<MarketingRecord, Integer> {

	/**
	 * 保存产品销售时，同时保存产品销售详细
	 * @param marketingRecord 产品销售
	 * @param marketingRecordDetailList 产品销售详细列表
	 */
	public void saveMarketingRecord(MarketingRecord marketingRecord, List<MarketingRecordDetail> marketingRecordDetailList);
	
	/**
	 * 更新产品销售时，同时保存或更新产品销售详细
	 * @param marketingRecord 产品销售
	 * @param marketingRecordDetailList 产品销售详细列表
	 */
	public void updateMarketingRecord(MarketingRecord marketingRecord, List<MarketingRecordDetail> marketingRecordDetailList);
	
	/**
	 * 保存付款记录
	 * @param marketingRecord 套餐购买记录
	 * @param money 实付金额
	 * @param balance 充值卡付款
	 * @param readyMoney 现金付款
	 * @param customLeaguerDetail 卡项付款
	 * @param marketingRecordDetailList 购买的套餐记录详细
	 */
	public void savePay(MarketingRecord marketingRecord, BigDecimal money, BigDecimal balance, BigDecimal readyMoney, CustomLeaguerDetail customLeaguerDetail, List<MarketingRecordDetail> marketingRecordDetailList);
}
