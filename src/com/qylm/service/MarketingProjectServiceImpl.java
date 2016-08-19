package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.MarketingProjectDao;
import com.qylm.entity.MarketingProject;

@Service("marketingProjectService")
public class MarketingProjectServiceImpl extends GenericServiceImpl<MarketingProject, Integer> implements MarketingProjectService {

	@Autowired
	protected MarketingProjectServiceImpl(MarketingProjectDao marketingProjectDao) {
		super(marketingProjectDao);
	}

}
