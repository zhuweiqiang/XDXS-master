package com.qylm.service;

import java.util.List;

import com.qylm.entity.Leaguer;
import com.qylm.entity.LeaguerDetail;

public interface LeaguerService extends GenericService<Leaguer, Integer> {
	
	/**
	 * 保存卡项时，同时保存卡项详细
	 * @param leaguer 卡项
	 * @param leaguerDetailList 卡项详细列表
	 */
	public void saveLeaguer(Leaguer leaguer, List<LeaguerDetail> leaguerDetailList);
	
	/**
	 * 更新卡项时，同时保存或更新卡项详细
	 * @param leaguer 卡项
	 * @param leaguerDetailList 卡项详细列表
	 */
	public void updateLeaguer(Leaguer leaguer, List<LeaguerDetail> leaguerDetailList);
}
