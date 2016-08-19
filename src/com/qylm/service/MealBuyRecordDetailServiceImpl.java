package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.MealBuyRecordDetailDao;
import com.qylm.entity.MealBuyRecordDetail;

@Service("mealBuyRecordDetailService")
public class MealBuyRecordDetailServiceImpl extends GenericServiceImpl<MealBuyRecordDetail, Integer> implements MealBuyRecordDetailService {

	@Autowired
	protected MealBuyRecordDetailServiceImpl(MealBuyRecordDetailDao mealBuyRecordDetailDao) {
		super(mealBuyRecordDetailDao);
	}

}
