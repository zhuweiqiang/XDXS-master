package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ConsumptionDetailDao;
import com.qylm.entity.ConsumptionDetail;

@Service("consumptionDetailService")
public class ConsumptionDetailServiceImpl extends GenericServiceImpl<ConsumptionDetail, Integer> implements ConsumptionDetailService {

	@Autowired
	protected ConsumptionDetailServiceImpl(ConsumptionDetailDao consumptionDetailDao) {
		super(consumptionDetailDao);
	}

}
