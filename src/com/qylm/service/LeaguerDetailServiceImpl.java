package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.LeaguerDetailDao;
import com.qylm.entity.LeaguerDetail;

@Service("leaguerDetailService")
public class LeaguerDetailServiceImpl extends GenericServiceImpl<LeaguerDetail, Integer> implements LeaguerDetailService {

	@Autowired
	protected LeaguerDetailServiceImpl(LeaguerDetailDao leaguerDetailDao) {
		super(leaguerDetailDao);
	}

}
