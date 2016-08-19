package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.CustomLeaguerOperationDao;
import com.qylm.entity.CustomLeaguerOperation;
import com.qylm.logic.myDesk.CustomLeaguerOperationLogic;

@Service("customLeaguerOperationService")
public class CustomLeaguerOperationServiceImpl extends GenericServiceImpl<CustomLeaguerOperation, Integer> implements CustomLeaguerOperationService {

	@Autowired
	private CustomLeaguerOperationLogic customLeaguerOperationLogic;
	
	@Autowired
	protected CustomLeaguerOperationServiceImpl(CustomLeaguerOperationDao customLeaguerOperationDao) {
		super(customLeaguerOperationDao);
	}

	public void saveCustomLeaguerOperationTK(
			CustomLeaguerOperation customLeaguerOperation) {
		customLeaguerOperationLogic.saveCustomLeaguerOperationTK(customLeaguerOperation);
	}

	public void saveCustomLeaguerOperationZK(
			CustomLeaguerOperation customLeaguerOperation) {
		customLeaguerOperationLogic.saveCustomLeaguerOperationZK(customLeaguerOperation);
	}

}
