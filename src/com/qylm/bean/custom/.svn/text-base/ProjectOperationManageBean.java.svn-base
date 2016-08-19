package com.qylm.bean.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.ProjectOperationManageReturner;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.ProjectOperationManageDto;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.service.ConsumptionRegisterDetailService;
import com.qylm.service.ConsumptionRegisterService;

/**
 * 项目操作管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ProjectOperationManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9214449331213135955L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProjectOperationManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ProjectOperationManageDto projectOperationManageDto = new ProjectOperationManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ConsumptionRegister> consumptionRegisterList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ConsumptionRegister[] selectedModels;
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
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
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_项目操作菜单】");
		fetchData(0, true);
		return Navigation.PROJECT_OPERATION_MANAGE;
	}
	
	/**
	 * 此方法绑定于项目操作管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至项目操作登陆画面
	 * @return 项目操作登陆画面
	 */
	public String updateProjectOperation(ConsumptionRegister transferConsumptionRegister) {
		Tool.sendLog(LOG, userBean, "按下【项目操作管理画面_修改按钮】");
		return Tool.getBackBean(ProjectOperationCreateBean.class).updateDetail(new ProjectOperationManageReturner(projectOperationManageDto, currentPage), transferConsumptionRegister);
	}
	
	/**
	 * 此方法绑定于项目操作管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectProjectOperation() {
		Tool.sendLog(LOG, userBean, "按下【项目操作管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ConsumptionRegister transferConsumptionRegister) {
		Tool.sendLog(LOG, userBean, "按下【项目操作管理画面的_视图按钮】");
		if (transferConsumptionRegister == null) {
			transferConsumptionRegister = consumptionRegisterService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ProjectOperationViewBean.class).viewDetail(transferConsumptionRegister);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConsumptionRegister.class);
		detachedCriteria.createAlias(ConsumptionRegister.CUSTOMINFO, ConsumptionRegister.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegister.PERSONNEL_INFO, ConsumptionRegister.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegister.ADVISER, ConsumptionRegister.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConsumptionRegister.STATE, true));
		detachedCriteria.add(Restrictions.eq(ConsumptionRegister.TYPE, ConsumptionRegister.TYPE_5));
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = projectOperationManageDto.getName();
		String leaguerNumber = projectOperationManageDto.getLeaguerNumber();
		Date beginDate = projectOperationManageDto.getBeginDate();
		Date endDate = projectOperationManageDto.getEndDate();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(ConsumptionRegister.CUSTOMINFO_LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(ConsumptionRegister.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(ConsumptionRegister.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(ConsumptionRegister.DATE, endDate));
		}
		consumptionRegisterList = consumptionRegisterService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(consumptionRegisterService.getRowCount(detachedCriteria));
		}
		if (!consumptionRegisterList.isEmpty()) {
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
			detachedCriteria.add(Restrictions.in(ConsumptionRegisterDetail.CONSUMPTION_REGISTER, consumptionRegisterList));
			List<ConsumptionRegisterDetail> detailList = consumptionRegisterDetailService.getByDetachedCriteria(detachedCriteria);
			for (ConsumptionRegister consumptionRegister : consumptionRegisterList) {
				List<ConsumptionRegisterDetail> consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
				consumptionRegister.setConsumptionRegisterDetailList(consumptionRegisterDetailList);
				for (ConsumptionRegisterDetail consumptionRegisterDetail : detailList) {
					if (consumptionRegister.equals(consumptionRegisterDetail.getConsumptionRegister())) {
						consumptionRegisterDetailList.add(consumptionRegisterDetail);
					}
				}
			}
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.PROJECT_OPERATION_MANAGE;
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
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get projectOperationManageDto
	 * @return the projectOperationManageDto
	 */
	public ProjectOperationManageDto getProjectOperationManageDto() {
		return projectOperationManageDto;
	}

	/**
	 * set projectOperationManageDto
	 * @param projectOperationManageDto the projectOperationManageDto to set
	 */
	public void setProjectOperationManageDto(ProjectOperationManageDto projectOperationManageDto) {
		this.projectOperationManageDto = projectOperationManageDto;
	}

	/**
	 * @return the consumptionRegisterList
	 */
	public List<ConsumptionRegister> getConsumptionRegisterList() {
		return consumptionRegisterList;
	}

	/**
	 * @param consumptionRegisterList the consumptionRegisterList to set
	 */
	public void setConsumptionRegisterList(
			List<ConsumptionRegister> consumptionRegisterList) {
		this.consumptionRegisterList = consumptionRegisterList;
	}

	/**
	 * @return the selectedModels
	 */
	public ConsumptionRegister[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ConsumptionRegister[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
