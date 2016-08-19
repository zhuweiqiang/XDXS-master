package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.LeaguerDao;
import com.qylm.entity.Leaguer;
import com.qylm.entity.LeaguerDetail;
import com.qylm.logic.baseSet.LeaguerLogic;

@Service("leaguerService")
public class LeaguerServiceImpl extends GenericServiceImpl<Leaguer, Integer> implements LeaguerService {

	@Autowired
	private LeaguerLogic leaguerLogic;
	
	@Autowired
	protected LeaguerServiceImpl(LeaguerDao leaguerDao) {
		super(leaguerDao);
	}
	
	public void saveLeaguer(Leaguer leaguer,
			List<LeaguerDetail> leaguerDetailList) {
		leaguerLogic.saveLeaguer(leaguer, leaguerDetailList);
	}

	public void updateLeaguer(Leaguer leaguer,
			List<LeaguerDetail> leaguerDetailList) {
		leaguerLogic.updateLeaguer(leaguer, leaguerDetailList);
	}

}
