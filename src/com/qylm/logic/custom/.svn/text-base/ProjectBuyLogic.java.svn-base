package com.qylm.logic.custom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.MothedUtil;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.dao.ProjectBuyDao;
import com.qylm.dao.ProjectBuyDetailDao;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.ProjectBuy;
import com.qylm.entity.ProjectBuyDetail;

public class ProjectBuyLogic {
	
	@Autowired
	private ProjectBuyDao projectBuyDao;
	
	@Autowired
	private ProjectBuyDetailDao projectBuyDetailDao;
	
	@Autowired
	private ConsumptionRegisterLogic consumptionRegisterLogic;
	
	public void saveProjectBuy(ProjectBuy projectBuy,
			List<ProjectBuyDetail> projectBuyDetailList) {
		projectBuyDao.saveEntity(projectBuy);
		projectBuyDetailDao.saveEntityAll(projectBuyDetailList);
	}

	public void updateProjectBuy(ProjectBuy projectBuy,
			List<ProjectBuyDetail> projectBuyDetailList) {
		projectBuyDao.updateEntity(projectBuy);
		projectBuyDetailDao.saveOrUpdateAll(projectBuyDetailList);
	}
	
	public void savePay(ProjectBuy projectBuy, BigDecimal balance,
			BigDecimal readyMoney,
			List<CustomLeaguerDetail> customLeaguerDetailList,
			List<ProjectBuyDetail> projectBuyDetailList) {
		// 得到消费登记
		ConsumptionRegister consumptionRegister = consumptionRegisterLogic.getConsumptionRegister(projectBuy.getCustomInfo(), projectBuy.getPersonnelInfo(), projectBuy.getAdviser(), projectBuy.getDate(), projectBuy.getMoney(), projectBuy.getCreater());
		consumptionRegister.setType(ConsumptionRegister.TYPE_3);
		// 得到消费登记详细
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = getConsumptionRegisterDetailList(consumptionRegister, projectBuyDetailList);
		// 建立各个卡项的消费记录
		consumptionRegisterLogic.saveConsumptionRegisterDetail(projectBuy.getCustomInfo(), projectBuy.getDate(), projectBuy.getMoney(), balance, readyMoney, projectBuy.getCreater(), customLeaguerDetailList, consumptionRegister, consumptionRegisterDetailList);
		// 保存到记录
		projectBuyDao.saveEntity(projectBuy);
		projectBuyDetailDao.saveEntityAll(projectBuyDetailList);
	}
	
	/**
	 * 保存购买的套餐信息
	 * @param consumptionRegister
	 * @param customLeaguerDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList(ConsumptionRegister consumptionRegister, List<ProjectBuyDetail> projectBuyDetailList) {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
		ConsumptionRegisterDetail consumptionRegisterDetail;
		for (ProjectBuyDetail projectBuyDetail : projectBuyDetailList) {
			consumptionRegisterDetail = new ConsumptionRegisterDetail();
			consumptionRegisterDetail.setConsumptionRegister(consumptionRegister);
			consumptionRegisterDetail.setCreater(consumptionRegister.getCreater());
			consumptionRegisterDetail.setBelongingUser(MothedUtil.getBelongingUser(consumptionRegister.getCreater()));
			consumptionRegisterDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			// 次数乘以费用
			consumptionRegisterDetail.setMoney(BigDecimalUtil.multiply(projectBuyDetail.getMoney(), new BigDecimal(projectBuyDetail.getNumber().toString())));
			consumptionRegisterDetail.setProjectBuyDetail(projectBuyDetail);
			consumptionRegisterDetailList.add(consumptionRegisterDetail);
		}
		return consumptionRegisterDetailList;
	}
	
}
