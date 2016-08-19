package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ConsumptionRegisterDetailDao;
import com.qylm.entity.ConsumptionRegisterDetail;

@Service("consumptionRegisterDetailService")
public class ConsumptionRegisterDetailServiceImpl extends GenericServiceImpl<ConsumptionRegisterDetail, Integer> implements ConsumptionRegisterDetailService {

	@Autowired
	protected ConsumptionRegisterDetailServiceImpl(ConsumptionRegisterDetailDao consumptionRegisterDetailDao) {
		super(consumptionRegisterDetailDao);
	}

}
