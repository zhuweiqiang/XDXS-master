package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.FeedbackRecordDao;
import com.qylm.entity.FeedbackRecord;

@Service("feedbackRecordService")
public class FeedbackRecordServiceImpl extends GenericServiceImpl<FeedbackRecord, Integer> implements FeedbackRecordService {

	@Autowired
	protected FeedbackRecordServiceImpl(FeedbackRecordDao feedbackRecordDao) {
		super(feedbackRecordDao);
	}

}
