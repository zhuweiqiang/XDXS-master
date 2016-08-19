package com.qylm.service;

import java.util.List;

import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;

public interface TemporaryActivityService extends GenericService<TemporaryActivity, Integer> {

	/**
	 * 保存活动套餐时，同时保存活动套餐详细
	 * @param temporaryActivity 活动套餐
	 * @param temporaryActivityDetailList 活动套餐详细列表
	 */
	public void saveTemporaryActivity(TemporaryActivity temporaryActivity, List<TemporaryActivityDetail> temporaryActivityDetailList);
	
	/**
	 * 更新活动套餐时，同时保存或更新活动套餐详细
	 * @param temporaryActivity 活动套餐
	 * @param temporaryActivityDetailList 活动套餐详细列表
	 */
	public void updateTemporaryActivity(TemporaryActivity temporaryActivity, List<TemporaryActivityDetail> temporaryActivityDetailList);
	
}
