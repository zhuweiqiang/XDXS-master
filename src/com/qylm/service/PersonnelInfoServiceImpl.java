package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.PersonnelInfoDao;
import com.qylm.entity.PersonnelInfo;

@Service("personnelInfoService")
public class PersonnelInfoServiceImpl extends GenericServiceImpl<PersonnelInfo, Integer> implements PersonnelInfoService {

	@Autowired
	protected PersonnelInfoServiceImpl(PersonnelInfoDao personnelInfoDao) {
		super(personnelInfoDao);
	}

}
