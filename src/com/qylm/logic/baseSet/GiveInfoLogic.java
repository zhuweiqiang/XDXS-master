package com.qylm.logic.baseSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.GiveInfoDao;
import com.qylm.dao.GiveInfoDetailDao;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;

public class GiveInfoLogic {
	
	@Autowired
	private GiveInfoDao giveInfoDao;
	
	@Autowired
	private GiveInfoDetailDao giveInfoDetailDao;
	
	public void saveGiveInfo(GiveInfo giveInfo,
			List<GiveInfoDetail> giveInfoDetailList) {
		giveInfoDao.saveEntity(giveInfo);
		if (giveInfoDetailList != null && !giveInfoDetailList.isEmpty()) {
			giveInfoDetailDao.saveEntityAll(giveInfoDetailList);
		}
	}

	public void updateGiveInfo(GiveInfo giveInfo,
			List<GiveInfoDetail> giveInfoDetailList) {
		giveInfoDao.updateEntity(giveInfo);
		if (giveInfoDetailList != null && !giveInfoDetailList.isEmpty()) {
			giveInfoDetailDao.saveOrUpdateAll(giveInfoDetailList);
		}
	}
	
}
