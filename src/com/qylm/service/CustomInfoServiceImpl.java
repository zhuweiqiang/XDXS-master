package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.CustomInfoDao;
import com.qylm.entity.CustomInfo;

@Service("customInfoService")
public class CustomInfoServiceImpl extends GenericServiceImpl<CustomInfo, Integer> implements CustomInfoService {

	@Autowired
	protected CustomInfoServiceImpl(CustomInfoDao customInfoDao) {
		super(customInfoDao);
	}

}
