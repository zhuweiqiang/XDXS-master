package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.RepaymentRecordDao;
import com.qylm.entity.RepaymentRecord;
import com.qylm.logic.myDesk.RepaymentRecordLogic;

@Service("repaymentRecordService")
public class RepaymentRecordServiceImpl extends GenericServiceImpl<RepaymentRecord, Integer> implements RepaymentRecordService {
	
	@Autowired
	private RepaymentRecordLogic repaymentRecordLogic;

	@Autowired
	protected RepaymentRecordServiceImpl(RepaymentRecordDao repaymentRecordDao) {
		super(repaymentRecordDao);
	}

	public void saveRepaymentRecord(RepaymentRecord repaymentRecord) {
		repaymentRecordLogic.saveRepaymentRecord(repaymentRecord);
	}

}
