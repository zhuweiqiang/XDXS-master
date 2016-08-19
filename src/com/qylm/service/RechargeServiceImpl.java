package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.RechargeDao;
import com.qylm.entity.Recharge;
import com.qylm.logic.custom.RechargeLogic;

@Service("rechargeService")
public class RechargeServiceImpl extends GenericServiceImpl<Recharge, Integer> implements RechargeService {

	@Autowired
	private RechargeLogic rechargeLogic;
	
	@Autowired
	protected RechargeServiceImpl(RechargeDao rechargeDao) {
		super(rechargeDao);
	}

	public void updateQueryRecharge(Recharge recharge) {
		rechargeLogic.updateQueryRecharge(recharge);
	}

}
