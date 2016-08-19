package com.qylm.bean.custom;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.custom.ProjectOperationViewDto;
import com.qylm.dxo.ProjectOperationViewDxo;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.service.ConsumptionRegisterDetailService;
import com.qylm.service.ConsumptionRegisterService;

/**
 * 项目操作登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProjectOperationViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 903986671566585694L;

	/**
	 * 存放项目操作登陆画面需要保存的值
	 */
	private ProjectOperationViewDto projectOperationViewDto = new ProjectOperationViewDto();
	
	/**
	 * 个人消费登记业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterService}")
	private ConsumptionRegisterService consumptionRegisterService;
	
	/**
	 * 个人消费登记详细业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterDetailService}")
	private ConsumptionRegisterDetailService consumptionRegisterDetailService;
	
	/**
	 * 查看详细
	 * @param projectOperation
	 * @return
	 */
	public String viewDetail(ConsumptionRegister consumptionRegister) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConsumptionRegister.class);
		detachedCriteria.createAlias(ConsumptionRegister.CUSTOMINFO, ConsumptionRegister.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegister.PERSONNEL_INFO, ConsumptionRegister.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegister.ADVISER, ConsumptionRegister.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConsumptionRegister.BASE_ID, consumptionRegister.getId()));
		List<ConsumptionRegister> consumptionRegisterList = consumptionRegisterService.getByDetachedCriteria(detachedCriteria);
		if (!consumptionRegisterList.isEmpty()) {
			consumptionRegister = consumptionRegisterList.get(0);
			ProjectOperationViewDxo.entityToDto(consumptionRegister, projectOperationViewDto);
			detachedCriteria = DetachedCriteria.forClass(ConsumptionRegisterDetail.class);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.CONSUMPTION_REGISTER, ConsumptionRegisterDetail.CONSUMPTION_REGISTER, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.MARKETING_PROJECT, ConsumptionRegisterDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.PRODUCT_STOCK, ConsumptionRegisterDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.TEMPORARY_ACTIVITY, ConsumptionRegisterDetail.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL, ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_LEAGUER, ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_LEAGUER, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_GIVE_INFO, ConsumptionRegisterDetail.CUSTOMLEAGUER_DATEIL_GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.PROJECT_BUY_DETAIL, ConsumptionRegisterDetail.PROJECT_BUY_DETAIL, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConsumptionRegisterDetail.PROJECT_BUY_DETAIL_MARKETING_PROJECT, ConsumptionRegisterDetail.PROJECT_BUY_DETAIL_MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ConsumptionRegisterDetail.CONSUMPTION_REGISTER, consumptionRegister));
			projectOperationViewDto.setConsumptionRegisterDetailList(consumptionRegisterDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.PROJECT_OPERATION_VIEW;
	}
	
	/**
	 * @param consumptionRegisterService the consumptionRegisterService to set
	 */
	public void setConsumptionRegisterService(
			ConsumptionRegisterService consumptionRegisterService) {
		this.consumptionRegisterService = consumptionRegisterService;
	}

	/**
	 * @param consumptionRegisterDetailService the consumptionRegisterDetailService to set
	 */
	public void setConsumptionRegisterDetailService(
			ConsumptionRegisterDetailService consumptionRegisterDetailService) {
		this.consumptionRegisterDetailService = consumptionRegisterDetailService;
	}

	/**
	 * @return the projectOperationViewDto
	 */
	public ProjectOperationViewDto getProjectOperationViewDto() {
		return projectOperationViewDto;
	}

	/**
	 * @param projectOperationViewDto the projectOperationViewDto to set
	 */
	public void setProjectOperationViewDto(ProjectOperationViewDto projectOperationViewDto) {
		this.projectOperationViewDto = projectOperationViewDto;
	}

}
