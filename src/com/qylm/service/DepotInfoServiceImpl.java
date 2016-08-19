package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.DepotInfoDao;
import com.qylm.entity.DepotInfo;

@Service("depotInfoService")
public class DepotInfoServiceImpl extends GenericServiceImpl<DepotInfo, Integer> implements DepotInfoService {

	@Autowired
	protected DepotInfoServiceImpl(DepotInfoDao depotInfoDao) {
		super(depotInfoDao);
	}

}
