package com.qylm.bean.custom;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.dto.custom.ProjectOperationCreateDto;
import com.qylm.dxo.ProjectOperationCreateDxo;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.service.ConsumptionRegisterDetailService;

/**
 * 项目操作登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProjectOperationCreateBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7589910639301978031L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProjectOperationCreateBean.class);

	/**
	 * 存放项目操作登陆画面需要保存的值
	 */
	private ProjectOperationCreateDto projectOperationCreateDto = new ProjectOperationCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 个人消费登记详细业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterDetailService}")
	private ConsumptionRegisterDetailService consumptionRegisterDetailService;
	
	/**
	 * 此方法绑定于项目操作登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【项目操作登陆画面_返回按钮】");
		return projectOperationCreateDto.getReturner().returnOnly();
	}

	public String updateDetail(Returner<?, ?, ?> returner, ConsumptionRegister consumptionRegister) {
		projectOperationCreateDto.setReturner(returner);
		ProjectOperationCreateDxo.entityToDto(consumptionRegister, projectOperationCreateDto);
		projectOperationCreateDto.setTransferConsumptionRegister(consumptionRegister);
		// 查询出个人消费登记详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConsumptionRegisterDetail.class);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.CONSUMPTION_REGISTER, ConsumptionRegisterDetail.CONSUMPTION_REGISTER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegisterDetail.MARKETING_PROJECT, ConsumptionRegisterDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConsumptionRegisterDetail.CONSUMPTION_REGISTER, consumptionRegister));
		projectOperationCreateDto.setConsumptionRegisterDetailList(consumptionRegisterDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.PROJECT_OPERATION_CREATE;
	}
	
	/**
	 * @param consumptionRegisterDetailService the consumptionRegisterDetailService to set
	 */
	public void setConsumptionRegisterDetailService(
			ConsumptionRegisterDetailService consumptionRegisterDetailService) {
		this.consumptionRegisterDetailService = consumptionRegisterDetailService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get projectOperationCreateDto
	 * @return the projectOperationCreateDto
	 */
	public ProjectOperationCreateDto getProjectOperationCreateDto() {
		return projectOperationCreateDto;
	}

	/**
	 * set projectOperationCreateDto
	 * @param projectOperationCreateDto the projectOperationCreateDto to set
	 */
	public void setProjectOperationCreateDto(ProjectOperationCreateDto projectOperationCreateDto) {
		this.projectOperationCreateDto = projectOperationCreateDto;
	}

}
