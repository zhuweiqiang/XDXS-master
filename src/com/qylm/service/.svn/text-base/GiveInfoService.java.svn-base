package com.qylm.service;

import java.util.List;

import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;

public interface GiveInfoService extends GenericService<GiveInfo, Integer> {

	/**
	 * 保存体验卡时，同时保存体验卡详细
	 * @param giveInfo 体验卡
	 * @param giveInfoDetailList 体验卡详细列表
	 */
	public void saveGiveInfo(GiveInfo giveInfo, List<GiveInfoDetail> giveInfoDetailList);
	
	/**
	 * 更新体验卡时，同时保存或更新体验卡详细
	 * @param giveInfo 体验卡
	 * @param giveInfoDetailList 体验卡详细列表
	 */
	public void updateGiveInfo(GiveInfo giveInfo, List<GiveInfoDetail> giveInfoDetailList);
}
