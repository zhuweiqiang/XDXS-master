package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.MarketingRecordDetailDao;
import com.qylm.entity.MarketingRecordDetail;

@Service("marketingRecordDetailService")
public class MarketingRecordDetailServiceImpl extends GenericServiceImpl<MarketingRecordDetail, Integer> implements MarketingRecordDetailService {

	@Autowired
	protected MarketingRecordDetailServiceImpl(MarketingRecordDetailDao marketingRecordDetailDao) {
		super(marketingRecordDetailDao);
	}

}
