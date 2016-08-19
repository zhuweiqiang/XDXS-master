package com.qylm.logic.custom;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dao.CustomInfoDao;
import com.qylm.dao.RechargeDao;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.Recharge;

public class RechargeLogic {
	
	@Autowired
	private RechargeDao rechargeDao;
	
	@Autowired
	private CustomInfoDao customInfoDao;
	
	public void updateQueryRecharge(Recharge recharge) {
		rechargeDao.saveOrUpdate(recharge);
		CustomInfo customInfo = recharge.getCustomInfo();
		BigDecimal money = customInfo.getMoney();
		if (money == null) {
			money = Constants.BIGDECIMAL_ZERO;
		}
		// 更新客户的金额
		customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customInfo.setMoney(BigDecimalUtil.add(money, recharge.getMoney()));
		customInfoDao.updateEntity(customInfo);
	}
}
