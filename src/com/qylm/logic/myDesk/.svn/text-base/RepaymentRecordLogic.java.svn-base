package com.qylm.logic.myDesk;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.dao.CustomInfoDao;
import com.qylm.dao.RepaymentRecordDao;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.RepaymentRecord;

public class RepaymentRecordLogic {
	
	@Autowired
	private RepaymentRecordDao repaymentRecordDao;
	
	@Autowired
	private CustomInfoDao customInfoDao;
	
	public void saveRepaymentRecord(RepaymentRecord repaymentRecord) {
		repaymentRecordDao.saveEntity(repaymentRecord);
		CustomInfo customInfo = repaymentRecord.getCustomInfo();
		if (BigDecimalUtil.isNotNullOrZero(repaymentRecord.getBalance())) {
			customInfo.setMoney(BigDecimalUtil.subtract(customInfo.getMoney(), repaymentRecord.getBalance()));
			customInfo.setArrearage(BigDecimalUtil.subtract(customInfo.getArrearage(), repaymentRecord.getBalance()));
		}
		if (BigDecimalUtil.isNotNullOrZero(repaymentRecord.getReadyMoney())) {
			customInfo.setArrearage(BigDecimalUtil.subtract(customInfo.getArrearage(), repaymentRecord.getReadyMoney()));
		}
		customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customInfoDao.updateEntity(customInfo);
	}
}
