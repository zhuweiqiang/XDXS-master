package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.UserDepotDao;
import com.qylm.entity.UserDepot;

@Service("userDepotService")
public class UserDepotServiceImpl extends GenericServiceImpl<UserDepot, Integer> implements UserDepotService {

	@Autowired
	protected UserDepotServiceImpl(UserDepotDao userDepotDao) {
		super(userDepotDao);
	}

}
