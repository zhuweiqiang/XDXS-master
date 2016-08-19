package com.qylm.logic.baseSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.TemporaryActivityDao;
import com.qylm.dao.TemporaryActivityDetailDao;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;

public class TemporaryActivityLogic {
	
	@Autowired
	private TemporaryActivityDao temporaryActivityDao;
	
	@Autowired
	private TemporaryActivityDetailDao temporaryActivityDetailDao;
	
	public void saveTemporaryActivity(TemporaryActivity temporaryActivity,
			List<TemporaryActivityDetail> temporaryActivityDetailList) {
		temporaryActivityDao.saveEntity(temporaryActivity);
		temporaryActivityDetailDao.saveEntityAll(temporaryActivityDetailList);
	}

	public void updateTemporaryActivity(TemporaryActivity temporaryActivity,
			List<TemporaryActivityDetail> temporaryActivityDetailList) {
		temporaryActivityDao.updateEntity(temporaryActivity);
		temporaryActivityDetailDao.saveOrUpdateAll(temporaryActivityDetailList);
	}
	
}
