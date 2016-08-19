package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.ConsumptionRegisterDao;
import com.qylm.dto.myDesk.ShopCardDto;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.exception.ConsumptionException;
import com.qylm.logic.custom.ConsumptionRegisterLogic;

@Service("consumptionRegisterService")
public class ConsumptionRegisterServiceImpl extends GenericServiceImpl<ConsumptionRegister, Integer> implements ConsumptionRegisterService {

	@Autowired
	private ConsumptionRegisterLogic consumptionRegisterLogic;
	
	@Autowired
	protected ConsumptionRegisterServiceImpl(ConsumptionRegisterDao consumptionRegisterDao) {
		super(consumptionRegisterDao);
	}
	
	public void saveConsumptionRegister(ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		consumptionRegisterLogic.saveConsumptionRegister(consumptionRegister, consumptionRegisterDetailList);
	}

	public void updateConsumptionRegister(ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		consumptionRegisterLogic.updateConsumptionRegister(consumptionRegister, consumptionRegisterDetailList);
	}

	public void saveConsumptionRegister(ShopCardDto shopCardDto) {
		consumptionRegisterLogic.saveConsumptionRegister(shopCardDto);
	}

	public void savePay(ConsumptionRegister consumptionRegister, BigDecimal money, 
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList,
			BigDecimal balance, BigDecimal readyMoney,
			CustomLeaguerDetail customLeaguerDetail) throws ConsumptionException {
		consumptionRegisterLogic.savePay(consumptionRegister, money, consumptionRegisterDetailList, balance, readyMoney, customLeaguerDetail);
	}

}
