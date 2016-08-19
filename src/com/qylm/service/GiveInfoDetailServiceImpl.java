package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.GiveInfoDetailDao;
import com.qylm.entity.GiveInfoDetail;

@Service("giveInfoDetailService")
public class GiveInfoDetailServiceImpl extends GenericServiceImpl<GiveInfoDetail, Integer> implements GiveInfoDetailService {

	@Autowired
	protected GiveInfoDetailServiceImpl(GiveInfoDetailDao giveInfoDetailDao) {
		super(giveInfoDetailDao);
	}

}
