package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.TemporaryActivityDao;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.logic.baseSet.TemporaryActivityLogic;

@Service("temporaryActivityService")
public class TemporaryActivityServiceImpl extends GenericServiceImpl<TemporaryActivity, Integer> implements TemporaryActivityService {

	@Autowired
	private TemporaryActivityLogic temporaryActivityLogic;
	
	@Autowired
	protected TemporaryActivityServiceImpl(TemporaryActivityDao temporaryActivityDao) {
		super(temporaryActivityDao);
	}

	public void saveTemporaryActivity(TemporaryActivity temporaryActivity,
			List<TemporaryActivityDetail> temporaryActivityDetailList) {
		temporaryActivityLogic.saveTemporaryActivity(temporaryActivity, temporaryActivityDetailList);
	}

	public void updateTemporaryActivity(TemporaryActivity temporaryActivity,
			List<TemporaryActivityDetail> temporaryActivityDetailList) {
		temporaryActivityLogic.updateTemporaryActivity(temporaryActivity, temporaryActivityDetailList);
	}

}
