package com.qylm.bean.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.ConsumptionRegisterManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.ConsumptionRegisterManageDto;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.service.ConsumptionRegisterDetailService;
import com.qylm.service.ConsumptionRegisterService;

/**
 * 个人消费登记管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ConsumptionRegisterManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4108309786314728178L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ConsumptionRegisterManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ConsumptionRegisterManageDto consumptionRegisterManageDto = new ConsumptionRegisterManageDto();

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
		Tool.sendLog(LOG, userBean, "按下【功能菜单_个人消费登记菜单】");
		fetchData(0, true);
		return Navigation.CONSUMPTION_REGISTER_MANAGE;
	}
	
	/**
	 * 此方法绑定于个人消费登记管理画面的新建按钮 
	 * 实现功能：跳转至个人消费登记登陆画面，新建一家事件
	 * @return 个人消费登记登陆画面
	 */
	public String newConsumptionRegister() {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面_新建按钮】");
		return Tool.getBackBean(ConsumptionRegisterCreateBean.class).newCreate(new ConsumptionRegisterManageReturner(consumptionRegisterManageDto, currentPage));
	}

	/**
	 * 此方法绑定于个人消费登记管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至个人消费登记登陆画面
	 * @return 个人消费登记登陆画面
	 */
	public String updateConsumptionRegister(ConsumptionRegister transferConsumptionRegister) {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面_修改按钮】");
		return Tool.getBackBean(ConsumptionRegisterCreateBean.class).updateDetail(new ConsumptionRegisterManageReturner(consumptionRegisterManageDto, currentPage), transferConsumptionRegister);
	}
	
	/**
	 * 此方法绑定于个人消费登记管理画面的确认按钮 
	 * 实现功能：根据修改的对象，跳转至个人消费登记登陆画面
	 * @return 个人消费登记登陆画面
	 */
	public void queryConsumptionRegister(ConsumptionRegister transferConsumptionRegister) {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面_确认按钮】");
		transferConsumptionRegister.setState(true);
		transferConsumptionRegister.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		consumptionRegisterService.updateConsumptionRegister(transferConsumptionRegister, transferConsumptionRegister.getConsumptionRegisterDetailList());
		Tool.sendErrorMessage("消费成功！");
	}
	
	/**
	 * 此方法绑定于个人消费登记管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectConsumptionRegister() {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于个人消费登记管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ConsumptionRegister> asList = Arrays.asList(selectedModels);
				consumptionRegisterService.deleteEntityAll(asList);
				consumptionRegisterList.removeAll(asList);
				removeData(1, consumptionRegisterList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于个人消费登记管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteConsumptionRegister(ConsumptionRegister transferConsumptionRegister) {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面的_删除按钮】");
		try {
			consumptionRegisterService.deleteEntity(transferConsumptionRegister);
			consumptionRegisterList.remove(transferConsumptionRegister);
			removeData(1, consumptionRegisterList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ConsumptionRegister transferConsumptionRegister) {
		Tool.sendLog(LOG, userBean, "按下【个人消费登记管理画面的_视图按钮】");
		if (transferConsumptionRegister == null) {
			transferConsumptionRegister = consumptionRegisterService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ConsumptionRegisterViewBean.class).viewDetail(transferConsumptionRegister);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConsumptionRegister.class);
		detachedCriteria.createAlias(ConsumptionRegister.CUSTOMINFO, ConsumptionRegister.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegister.PERSONNEL_INFO, ConsumptionRegister.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConsumptionRegister.ADVISER, ConsumptionRegister.ADVISER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.addOrder(Order.desc(ConsumptionRegister.DATE));
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = consumptionRegisterManageDto.getName();
		String leaguerNumber = consumptionRegisterManageDto.getLeaguerNumber();
		Date beginDate = consumptionRegisterManageDto.getBeginDate();
		Date endDate = consumptionRegisterManageDto.getEndDate();
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
		return Navigation.CONSUMPTION_REGISTER_MANAGE;
	}

	/**
	 * @param consumptionRegisterDetailService the consumptionRegisterDetailService to set
	 */
	public void setConsumptionRegisterDetailService(
			ConsumptionRegisterDetailService consumptionRegisterDetailService) {
		this.consumptionRegisterDetailService = consumptionRegisterDetailService;
	}

	/**
	 * set consumptionRegisterService
	 * @param consumptionRegisterService the consumptionRegisterService to set
	 */
	public void setConsumptionRegisterService(ConsumptionRegisterService consumptionRegisterService) {
		this.consumptionRegisterService = consumptionRegisterService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get consumptionRegisterManageDto
	 * @return the consumptionRegisterManageDto
	 */
	public ConsumptionRegisterManageDto getConsumptionRegisterManageDto() {
		return consumptionRegisterManageDto;
	}

	/**
	 * set consumptionRegisterManageDto
	 * @param consumptionRegisterManageDto the consumptionRegisterManageDto to set
	 */
	public void setConsumptionRegisterManageDto(ConsumptionRegisterManageDto consumptionRegisterManageDto) {
		this.consumptionRegisterManageDto = consumptionRegisterManageDto;
	}

	/**
	 * get consumptionRegisterList
	 * @return the consumptionRegisterList
	 */
	public List<ConsumptionRegister> getConsumptionRegisterList() {
		return consumptionRegisterList;
	}

	/**
	 * set consumptionRegisterList
	 * @param consumptionRegisterList the consumptionRegisterList to set
	 */
	public void setConsumptionRegisterList(List<ConsumptionRegister> consumptionRegisterList) {
		this.consumptionRegisterList = consumptionRegisterList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ConsumptionRegister[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ConsumptionRegister[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
