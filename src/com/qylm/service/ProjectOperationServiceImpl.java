package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.ProjectOperationDao;
import com.qylm.entity.ProjectOperation;
import com.qylm.entity.ProjectOperationDetail;
import com.qylm.logic.custom.ProjectOperationLogic;

@Service("projectOperationService")
public class ProjectOperationServiceImpl extends GenericServiceImpl<ProjectOperation, Integer> implements ProjectOperationService {

	@Autowired
	private ProjectOperationLogic projectOperationLogic;
	
	@Autowired
	protected ProjectOperationServiceImpl(ProjectOperationDao projectOperationDao) {
		super(projectOperationDao);
	}
	
	public void saveProjectOperation(ProjectOperation projectOperation,
			List<ProjectOperationDetail> projectOperationDetailList) {
		projectOperationLogic.saveProjectOperation(projectOperation, projectOperationDetailList);
	}

	public void updateProjectOperation(ProjectOperation projectOperation,
			List<ProjectOperationDetail> projectOperationDetailList) {
		projectOperationLogic.updateProjectOperation(projectOperation, projectOperationDetailList);
	}

}
