package com.qylm.bean.custom;

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
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.RechargeManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.RechargeManageDto;
import com.qylm.entity.Recharge;
import com.qylm.service.RechargeService;

/**
 * 会员充值记录管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class RechargeManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4360058941263540589L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(RechargeManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private RechargeManageDto rechargeManageDto = new RechargeManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<Recharge> rechargeList;
	
	/**
	 * 删除复选框选择的值
	 */
	private Recharge[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{rechargeService}")
	private RechargeService rechargeService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_会员充值记录菜单】");
		fetchData(0, true);
		return Navigation.RECHARGE_MANAGE;
	}
	
	/**
	 * 此方法绑定于会员充值记录管理画面的新建按钮 
	 * 实现功能：跳转至会员充值记录登陆画面，新建一家事件
	 * @return 会员充值记录登陆画面
	 */
	public String newRecharge() {
		Tool.sendLog(LOG, userBean, "按下【会员充值记录管理画面_新建按钮】");
		return Tool.getBackBean(RechargeCreateBean.class).newCreate(new RechargeManageReturner(rechargeManageDto, currentPage));
	}

	/**
	 * 此方法绑定于会员充值记录管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至会员充值记录登陆画面
	 * @return 会员充值记录登陆画面
	 */
	public String updateRecharge(Recharge transferRecharge) {
		Tool.sendLog(LOG, userBean, "按下【会员充值记录管理画面_修改按钮】");
		return Tool.getBackBean(RechargeCreateBean.class).updateDetail(new RechargeManageReturner(rechargeManageDto, currentPage), transferRecharge);
	}
	
	/**
	 * 此方法绑定于会员充值记录管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectRecharge() {
		Tool.sendLog(LOG, userBean, "按下【会员充值记录管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于会员充值记录管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【会员充值记录管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<Recharge> asList = Arrays.asList(selectedModels);
			rechargeService.deleteEntityAll(asList);
			rechargeList.removeAll(asList);
			removeData(1, rechargeList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于会员充值记录管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteRecharge(Recharge transferRecharge) {
		Tool.sendLog(LOG, userBean, "按下【会员充值记录管理画面的_删除按钮】");
		rechargeService.deleteEntity(transferRecharge);
		rechargeList.remove(transferRecharge);
		removeData(1, rechargeList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(Recharge transferRecharge) {
		Tool.sendLog(LOG, userBean, "按下【会员充值记录管理画面的_视图按钮】");
		if (transferRecharge == null) {
			transferRecharge = rechargeService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(RechargeViewBean.class).viewDetail(transferRecharge);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Recharge.class);
		detachedCriteria.createAlias(Recharge.CUSTOMINFO, Recharge.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String leaguerNumber = rechargeManageDto.getLeaguerNumber();
		String name = rechargeManageDto.getName();
		Date beginRechargeDate = rechargeManageDto.getBeginRechargeDate();
		Date endRechargeDate = rechargeManageDto.getEndRechargeDate();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(Recharge.CUSTOMINFO_LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(Recharge.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginRechargeDate != null) {
			detachedCriteria.add(Restrictions.ge(Recharge.RECHARGE_DATE, beginRechargeDate));
		}
		if (endRechargeDate != null) {
			detachedCriteria.add(Restrictions.le(Recharge.RECHARGE_DATE, endRechargeDate));
		}
		rechargeList = rechargeService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(rechargeService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.RECHARGE_MANAGE;
	}

	/**
	 * set rechargeService
	 * @param rechargeService the rechargeService to set
	 */
	public void setRechargeService(RechargeService rechargeService) {
		this.rechargeService = rechargeService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get rechargeManageDto
	 * @return the rechargeManageDto
	 */
	public RechargeManageDto getRechargeManageDto() {
		return rechargeManageDto;
	}

	/**
	 * set rechargeManageDto
	 * @param rechargeManageDto the rechargeManageDto to set
	 */
	public void setRechargeManageDto(RechargeManageDto rechargeManageDto) {
		this.rechargeManageDto = rechargeManageDto;
	}

	/**
	 * get rechargeList
	 * @return the rechargeList
	 */
	public List<Recharge> getRechargeList() {
		return rechargeList;
	}

	/**
	 * set rechargeList
	 * @param rechargeList the rechargeList to set
	 */
	public void setRechargeList(List<Recharge> rechargeList) {
		this.rechargeList = rechargeList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public Recharge[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(Recharge[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
