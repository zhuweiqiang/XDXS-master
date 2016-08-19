package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.FunctionDao;
import com.qylm.entity.Function;

@Service("functionService")
public class FunctionServiceImpl extends GenericServiceImpl<Function, Integer> implements FunctionService {

	@Autowired
	protected FunctionServiceImpl(FunctionDao functionDao) {
		super(functionDao);
	}

}
