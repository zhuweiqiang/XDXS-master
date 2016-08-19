package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.MealBuyRecordDao;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.logic.custom.MealBuyRecordLogic;

@Service("mealBuyRecordService")
public class MealBuyRecordServiceImpl extends GenericServiceImpl<MealBuyRecord, Integer> implements MealBuyRecordService {

	@Autowired
	private MealBuyRecordLogic mealBuyRecordLogic;

	@Autowired
	protected MealBuyRecordServiceImpl(MealBuyRecordDao mealBuyRecordDao) {
		super(mealBuyRecordDao);
	}

	public void saveMealBuyRecord(MealBuyRecord mealBuyRecord,
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		mealBuyRecordLogic.saveMealBuyRecord(mealBuyRecord, mealBuyRecordDetailList);
	}

	public void updateMealBuyRecord(MealBuyRecord mealBuyRecord,
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		mealBuyRecordLogic.updateMealBuyRecord(mealBuyRecord, mealBuyRecordDetailList);
	}

	public void savePay(MealBuyRecord mealBuyRecord,
			BigDecimal balance, BigDecimal readyMoney, 
			List<CustomLeaguerDetail> customLeaguerDetailList,
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		mealBuyRecordLogic.savePay(mealBuyRecord, balance, readyMoney, customLeaguerDetailList, mealBuyRecordDetailList);
	}

}
