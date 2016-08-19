package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.ProjectBuy;
import com.qylm.entity.ProjectBuyDetail;

public interface ProjectBuyService extends GenericService<ProjectBuy, Integer> {
	
	/**
	 * 保存项目购买时，同时保存项目购买详细
	 * @param projectBuy 项目购买
	 * @param projectBuyDetailList 项目购买详细列表
	 */
	public void saveProjectBuy(ProjectBuy projectBuy, List<ProjectBuyDetail> projectBuyDetailList);
	
	/**
	 * 更新项目购买时，同时保存或更新项目购买详细
	 * @param projectBuy 项目购买
	 * @param projectBuyDetailList 项目购买详细列表
	 */
	public void updateProjectBuy(ProjectBuy projectBuy, List<ProjectBuyDetail> projectBuyDetailList);
	
	/**
	 * 保存付款记录
	 * @param projectBuy 疗程购买记录
	 * @param balance 充值卡付款
	 * @param readyMoney 现金付款
	 * @param customLeaguerDetailList 卡项付款列表
	 * @param projectBuyDetailList 疗程购买记录详细
	 */
	public void savePay(ProjectBuy projectBuy, BigDecimal balance, BigDecimal readyMoney, List<CustomLeaguerDetail> customLeaguerDetailList, List<ProjectBuyDetail> projectBuyDetailList);
}
