package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.GiveInfoDao;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;
import com.qylm.logic.baseSet.GiveInfoLogic;

@Service("giveInfoService")
public class GiveInfoServiceImpl extends GenericServiceImpl<GiveInfo, Integer> implements GiveInfoService {

	@Autowired
	private GiveInfoLogic giveInfoLogic;
	
	@Autowired
	protected GiveInfoServiceImpl(GiveInfoDao giveInfoDao) {
		super(giveInfoDao);
	}
	
	public void saveGiveInfo(GiveInfo giveInfo,
			List<GiveInfoDetail> giveInfoDetailList) {
		giveInfoLogic.saveGiveInfo(giveInfo, giveInfoDetailList);
	}

	public void updateGiveInfo(GiveInfo giveInfo,
			List<GiveInfoDetail> giveInfoDetailList) {
		giveInfoLogic.updateGiveInfo(giveInfo, giveInfoDetailList);
	}
}
