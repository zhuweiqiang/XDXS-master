package com.qylm.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.ProjectBuyDao;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.ProjectBuy;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.logic.custom.ProjectBuyLogic;

@Service("projectBuyService")
public class ProjectBuyServiceImpl extends GenericServiceImpl<ProjectBuy, Integer> implements ProjectBuyService {

	@Autowired
	private ProjectBuyLogic projectBuyLogic;
	
	@Autowired
	protected ProjectBuyServiceImpl(ProjectBuyDao projectBuyDao) {
		super(projectBuyDao);
	}
	
	public void saveProjectBuy(ProjectBuy projectBuy,
			List<ProjectBuyDetail> projectBuyDetailList) {
		projectBuyLogic.saveProjectBuy(projectBuy, projectBuyDetailList);
	}

	public void updateProjectBuy(ProjectBuy projectBuy,
			List<ProjectBuyDetail> projectBuyDetailList) {
		projectBuyLogic.updateProjectBuy(projectBuy, projectBuyDetailList);
	}

	public void savePay(ProjectBuy projectBuy, BigDecimal balance,
			BigDecimal readyMoney,
			List<CustomLeaguerDetail> customLeaguerDetailList,
			List<ProjectBuyDetail> projectBuyDetailList) {
		projectBuyLogic.savePay(projectBuy, balance, readyMoney, customLeaguerDetailList, projectBuyDetailList);
	}

}
