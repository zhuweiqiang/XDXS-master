package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.MarketingRecordDao;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.logic.custom.MarketingRecordLogic;

@Service("marketingRecordService")
public class MarketingRecordServiceImpl extends GenericServiceImpl<MarketingRecord, Integer> implements MarketingRecordService {

	@Autowired
	private MarketingRecordLogic marketingRecordLogic;
	
	@Autowired
	protected MarketingRecordServiceImpl(MarketingRecordDao marketingRecordDao) {
		super(marketingRecordDao);
	}
	
	public void saveMarketingRecord(MarketingRecord marketingRecord,
			List<MarketingRecordDetail> marketingRecordDetailList) {
		marketingRecordLogic.saveMarketingRecord(marketingRecord, marketingRecordDetailList);
	}

	public void updateMarketingRecord(MarketingRecord marketingRecord,
			List<MarketingRecordDetail> marketingRecordDetailList) {
		marketingRecordLogic.updateMarketingRecord(marketingRecord, marketingRecordDetailList);
	}

	public void savePay(MarketingRecord marketingRecord, BigDecimal money, BigDecimal balance,
			BigDecimal readyMoney,
			CustomLeaguerDetail customLeaguerDetail,
			List<MarketingRecordDetail> marketingRecordDetailList) {
		marketingRecordLogic.savePay(marketingRecord, money, balance, readyMoney, customLeaguerDetail, marketingRecordDetailList);
	}

}
