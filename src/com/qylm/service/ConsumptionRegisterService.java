package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import com.qylm.dto.myDesk.ShopCardDto;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.exception.ConsumptionException;

public interface ConsumptionRegisterService extends GenericService<ConsumptionRegister, Integer> {

	/**
	 * 保存个人消费登记时，同时保存个人消费登记详细
	 * @param consumptionRegister 个人消费登记
	 * @param consumptionRegisterDetailList 个人消费登记详细列表
	 */
	public void saveConsumptionRegister(ConsumptionRegister consumptionRegister, List<ConsumptionRegisterDetail> consumptionRegisterDetailList);
	
	/**
	 * 更新个人消费登记时，同时保存或更新个人消费登记详细
	 * @param consumptionRegister 个人消费登记
	 * @param consumptionRegisterDetailList 个人消费登记详细列表
	 */
	public void updateConsumptionRegister(ConsumptionRegister consumptionRegister, List<ConsumptionRegisterDetail> consumptionRegisterDetailList);
	
	/**
	 * 更新客户的金额消费情况，登记个人消费信息
	 * @param shopCardDto
	 */
	public void saveConsumptionRegister(ShopCardDto shopCardDto);
	
	/**
	 * 付款
	 * @param consumptionRegister 消费信息
	 * @param money 实收金额就是折后金额
	 * @param consumptionRegisterDetailList 消费项目列表
	 * @param balance 余额付款
	 * @param readyMoney 现金付款
	 * @param customLeaguerDetail 客户卡项
	 */
	public void savePay(ConsumptionRegister consumptionRegister, BigDecimal money, List<ConsumptionRegisterDetail> consumptionRegisterDetailList,
			BigDecimal balance, BigDecimal readyMoney, CustomLeaguerDetail customLeaguerDetail) throws ConsumptionException;
	
}
