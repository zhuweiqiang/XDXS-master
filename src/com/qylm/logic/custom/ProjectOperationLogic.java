package com.qylm.logic.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.dao.ProjectOperationDao;
import com.qylm.dao.ProjectOperationDetailDao;
import com.qylm.entity.ProjectOperation;
import com.qylm.entity.ProjectOperationDetail;

public class ProjectOperationLogic {
	
	@Autowired
	private ProjectOperationDao projectOperationDao;
	
	@Autowired
	private ProjectOperationDetailDao projectOperationDetailDao;
	
	public void saveProjectOperation(ProjectOperation projectOperation,
			List<ProjectOperationDetail> projectOperationDetailList) {
		projectOperationDao.saveEntity(projectOperation);
		projectOperationDetailDao.saveEntityAll(projectOperationDetailList);
	}

	public void updateProjectOperation(ProjectOperation projectOperation,
			List<ProjectOperationDetail> projectOperationDetailList) {
		projectOperationDao.updateEntity(projectOperation);
		projectOperationDetailDao.saveOrUpdateAll(projectOperationDetailList);
	}
	
}
