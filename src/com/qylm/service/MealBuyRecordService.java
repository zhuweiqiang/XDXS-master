package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;

public interface MealBuyRecordService extends GenericService<MealBuyRecord, Integer> {

	/**
	 * 保存套餐购买的时候，保存套餐购买详细
	 * @param mealBuyRecord 套餐购买
	 * @param mealBuyRecordDetailList 套餐购买详细
	 */
	public void saveMealBuyRecord(MealBuyRecord mealBuyRecord, List<MealBuyRecordDetail> mealBuyRecordDetailList);
	
	/**
	 * 更新套餐购买的时候，更新套餐购买详细
	 * @param mealBuyRecord 套餐购买
	 * @param mealBuyRecordDetailList 套餐购买详细
	 */
	public void updateMealBuyRecord(MealBuyRecord mealBuyRecord, List<MealBuyRecordDetail> mealBuyRecordDetailList);
	
	/**
	 * 保存付款记录
	 * @param mealBuyRecord 套餐购买记录
	 * @param balance 充值卡付款
	 * @param readyMoney 现金付款
	 * @param customLeaguerDetailList 卡项付款列表
	 * @param mealBuyRecordDetailList 购买的套餐记录详细
	 */
	public void savePay(MealBuyRecord mealBuyRecord, BigDecimal balance, BigDecimal readyMoney, List<CustomLeaguerDetail> customLeaguerDetailList, List<MealBuyRecordDetail> mealBuyRecordDetailList);
}
