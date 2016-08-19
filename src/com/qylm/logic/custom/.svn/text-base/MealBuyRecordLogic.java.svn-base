package com.qylm.logic.custom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.MothedUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.dao.MealBuyRecordDao;
import com.qylm.dao.MealBuyRecordDetailDao;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;

public class MealBuyRecordLogic {
	
	@Autowired
	private MealBuyRecordDao mealBuyRecordDao;
	
	@Autowired
	private MealBuyRecordDetailDao mealBuyRecordDetailDao;
	
	@Autowired
	private ConsumptionRegisterLogic consumptionRegisterLogic;
	
	public void saveMealBuyRecord(MealBuyRecord mealBuyRecord,
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		mealBuyRecordDao.saveEntity(mealBuyRecord);
		mealBuyRecordDetailDao.saveEntityAll(mealBuyRecordDetailList);
	}

	public void updateMealBuyRecord(MealBuyRecord mealBuyRecord,
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		mealBuyRecordDao.updateEntity(mealBuyRecord);
		mealBuyRecordDetailDao.saveOrUpdateAll(mealBuyRecordDetailList);
	}
	
	public void savePay(MealBuyRecord mealBuyRecord, 
			BigDecimal balance, BigDecimal readyMoney,
			List<CustomLeaguerDetail> customLeaguerDetailList,
			List<MealBuyRecordDetail> mealBuyRecordDetailList) {
		// 得到消费登记
		ConsumptionRegister consumptionRegister = consumptionRegisterLogic.getConsumptionRegister(mealBuyRecord.getCustomInfo(), mealBuyRecord.getPersonnelInfo(), mealBuyRecord.getAdviser(), mealBuyRecord.getDate(), mealBuyRecord.getRealityMoney(), mealBuyRecord.getCreater());
		consumptionRegister.setType(ConsumptionRegister.TYPE_2);
		// 得到消费登记详细
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = getConsumptionRegisterDetailList(consumptionRegister, mealBuyRecord);
		// 建立各个卡项的消费记录
		consumptionRegisterLogic.saveConsumptionRegisterDetail(mealBuyRecord.getCustomInfo(), mealBuyRecord.getDate(), mealBuyRecord.getRealityMoney(), balance, readyMoney, mealBuyRecord.getCreater(), customLeaguerDetailList, consumptionRegister, consumptionRegisterDetailList);
		// 保存到记录
		mealBuyRecordDao.saveEntity(mealBuyRecord);
		mealBuyRecordDetailDao.saveOrUpdateAll(mealBuyRecordDetailList);
	}

	/**
	 * 保存购买的套餐信息
	 * @param consumptionRegister
	 * @param customLeaguerDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList(ConsumptionRegister consumptionRegister, MealBuyRecord mealBuyRecord) {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
		ConsumptionRegisterDetail consumptionRegisterDetail = new ConsumptionRegisterDetail();
		consumptionRegisterDetail.setConsumptionRegister(consumptionRegister);
		consumptionRegisterDetail.setCreater(consumptionRegister.getCreater());
		consumptionRegisterDetail.setBelongingUser(MothedUtil.getBelongingUser(consumptionRegister.getCreater()));
		consumptionRegisterDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		consumptionRegisterDetail.setTemporaryActivity(mealBuyRecord.getTemporaryActivity());
		consumptionRegisterDetail.setMoney(mealBuyRecord.getTemporaryActivity().getMoney());
		consumptionRegisterDetailList.add(consumptionRegisterDetail);
		return consumptionRegisterDetailList;
	}
	
}
