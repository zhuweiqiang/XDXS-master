package com.qylm.service;

import java.util.List;

import com.qylm.entity.ProjectOperation;
import com.qylm.entity.ProjectOperationDetail;

public interface ProjectOperationService extends GenericService<ProjectOperation, Integer> {

	/**
	 * 保存项目操作时，同时保存项目操作详细
	 * @param projectOperation 项目操作
	 * @param projectOperationDetailList 项目操作详细列表
	 */
	public void saveProjectOperation(ProjectOperation projectOperation, List<ProjectOperationDetail> projectOperationDetailList);
	
	/**
	 * 更新项目操作时，同时保存或更新项目操作详细
	 * @param projectOperation 项目操作
	 * @param projectOperationDetailList 项目操作详细列表
	 */
	public void updateProjectOperation(ProjectOperation projectOperation, List<ProjectOperationDetail> projectOperationDetailList);
}
