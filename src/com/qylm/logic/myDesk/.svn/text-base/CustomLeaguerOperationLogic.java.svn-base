package com.qylm.logic.myDesk;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dao.CustomInfoDao;
import com.qylm.dao.CustomLeaguerDetailDao;
import com.qylm.dao.CustomLeaguerOperationDao;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.CustomLeaguerOperation;

public class CustomLeaguerOperationLogic {
	
	@Autowired
	private CustomLeaguerOperationDao customLeaguerOperationDao;
	
	@Autowired
	private CustomLeaguerDetailDao customLeaguerDetailDao;
	
	@Autowired
	private CustomInfoDao customInfoDao;
	
	public void saveCustomLeaguerOperationTK(CustomLeaguerOperation customLeaguerOperation) {
		customLeaguerOperationDao.saveEntity(customLeaguerOperation);
		CustomLeaguerDetail customLeaguerDetail = customLeaguerOperation.getCustomLeaguerDetail();
		customLeaguerDetail.setMoney(Constants.BIGDECIMAL_ZERO);
		customLeaguerDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customLeaguerDetailDao.updateEntity(customLeaguerDetail);
		
		if (CustomLeaguerOperation.TYPE_1.equals(customLeaguerOperation.getType())) {
			CustomInfo customInfo = customLeaguerOperation.getCustomInfo();
			customInfo.setMoney(BigDecimalUtil.add(customInfo.getMoney(), customLeaguerOperation.getMoney()));
			customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			customInfoDao.updateEntity(customInfo);
		}
	}
	
	public void saveCustomLeaguerOperationZK(CustomLeaguerOperation customLeaguerOperation) {
		customLeaguerOperationDao.saveEntity(customLeaguerOperation);
		// 获取需要转的卡
		CustomLeaguerDetail customLeaguerDetail = customLeaguerOperation.getCustomLeaguerDetail();
		// 减去卡额
		customLeaguerDetail.setMoney(BigDecimalUtil.subtract(customLeaguerDetail.getMoney(), customLeaguerOperation.getMoney()));
		customLeaguerDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customLeaguerDetailDao.updateEntity(customLeaguerDetail);
		// 获取需要转入的卡
		CustomLeaguerDetail deposit = customLeaguerOperation.getDeposit();
		// 增加卡额
		deposit.setMoney(BigDecimalUtil.add(deposit.getMoney(), customLeaguerOperation.getMoney()));
		deposit.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		customLeaguerDetailDao.updateEntity(deposit);
	}
}
