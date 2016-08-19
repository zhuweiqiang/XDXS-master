package com.qylm.service;

import com.qylm.entity.Recharge;

public interface RechargeService extends GenericService<Recharge, Integer> {

	/**
	 * 确认充值时调用此方法
	 * @param recharge 充值信息
	 */
	public void updateQueryRecharge(Recharge recharge);
	
}
