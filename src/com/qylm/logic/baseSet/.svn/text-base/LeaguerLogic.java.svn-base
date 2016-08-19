package com.qylm.logic.baseSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.LeaguerDao;
import com.qylm.dao.LeaguerDetailDao;
import com.qylm.entity.Leaguer;
import com.qylm.entity.LeaguerDetail;

public class LeaguerLogic {
	
	@Autowired
	private LeaguerDao leaguerDao;
	
	@Autowired
	private LeaguerDetailDao leaguerDetailDao;
	
	public void saveLeaguer(Leaguer leaguer,
			List<LeaguerDetail> leaguerDetailList) {
		leaguerDao.saveEntity(leaguer);
		if (!leaguerDetailList.isEmpty()) {
			leaguerDetailDao.saveEntityAll(leaguerDetailList);
		}
	}

	public void updateLeaguer(Leaguer leaguer,
			List<LeaguerDetail> leaguerDetailList) {
		leaguerDao.updateEntity(leaguer);
		if (!leaguerDetailList.isEmpty()) {
			leaguerDetailDao.saveOrUpdateAll(leaguerDetailList);
		}
	}
	
}
