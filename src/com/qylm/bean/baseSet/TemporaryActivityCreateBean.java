package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.baseSet.TemporaryActivityCreateDto;
import com.qylm.dxo.TemporaryActivityCreateDxo;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.service.TemporaryActivityDetailService;
import com.qylm.service.TemporaryActivityService;

/**
 * 活动套餐登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class TemporaryActivityCreateBean implements Serializable, CreateBean<TemporaryActivity> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4194757929088339481L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(TemporaryActivityCreateBean.class);

	/**
	 * 存放活动套餐登陆画面需要保存的值
	 */
	private TemporaryActivityCreateDto temporaryActivityCreateDto = new TemporaryActivityCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{temporaryActivityService}")
	private TemporaryActivityService temporaryActivityService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{temporaryActivityDetailService}")
	private TemporaryActivityDetailService temporaryActivityDetailService;
	
	/**
	 * 此方法绑定于活动套餐登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 活动套餐登陆画面
	 */
	public String newTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "【活动套餐登陆画面_新建按钮】");
		temporaryActivityCreateDto.setName(null);
		temporaryActivityCreateDto.setRemark(null);
		temporaryActivityCreateDto.setMoney(null);
		temporaryActivityCreateDto.setState(false);
		temporaryActivityCreateDto.setTemporaryActivityDetailList(null);
		temporaryActivityCreateDto.setSumYmoney(null);
		temporaryActivityCreateDto.setSumXmoney(null);
		temporaryActivityCreateDto.setCreater(null);
		temporaryActivityCreateDto.setBelongingUser(null);
		temporaryActivityCreateDto.setTransferTemporaryActivity(null);
		return Navigation.TEMPORARY_ACTIVITY_CREATE;
	}
	
	/**
	 * 此方法绑定于活动套餐登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【活动套餐登陆画面_返回按钮】");
		return temporaryActivityCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于活动套餐登陆画面的保存按钮 
	 * 实现功能：根据transferTemporaryActivity对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "【活动套餐登陆画面_保存按钮】");
		TemporaryActivity transferTemporaryActivity = temporaryActivityCreateDto.getTransferTemporaryActivity();
		operate(transferTemporaryActivity);
		sumMoney();
	}
	
	/**
	 * 此方法绑定于活动套餐登陆画面的确认按钮 
	 * 实现功能：根据transferTemporaryActivity对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "【活动套餐登陆画面_确认按钮】");
		TemporaryActivity transferTemporaryActivity = temporaryActivityCreateDto.getTransferTemporaryActivity();
		temporaryActivityCreateDto.setState(true);
		operate(transferTemporaryActivity);
	}

	/**
	 * 进行保存或者更新操作
	 * @param transferTemporaryActivity
	 */
	private void operate(TemporaryActivity transferTemporaryActivity) {
		List<TemporaryActivityDetail> temporaryActivityDetailList = temporaryActivityCreateDto.getTemporaryActivityDetailList();
		if (temporaryActivityDetailList == null || temporaryActivityDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须设定活动项目！");
			return;
		}
		if (transferTemporaryActivity == null) {
			transferTemporaryActivity = new TemporaryActivity();
			temporaryActivityCreateDto.setCreater(userBean.getUser());
			temporaryActivityCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferTemporaryActivity);
			transferTemporaryActivity.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			temporaryActivityService.saveTemporaryActivity(transferTemporaryActivity, temporaryActivityDetailList);
			temporaryActivityCreateDto.setTransferTemporaryActivity(transferTemporaryActivity);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferTemporaryActivity);
			transferTemporaryActivity.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			temporaryActivityService.updateTemporaryActivity(transferTemporaryActivity, temporaryActivityDetailList);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferTemporaryActivity
	 */
	private void create(TemporaryActivity transferTemporaryActivity) {
		List<TemporaryActivityDetail> temporaryActivityDetailList = temporaryActivityCreateDto.getTemporaryActivityDetailList();
		for (TemporaryActivityDetail temporaryActivityDetail : temporaryActivityDetailList) {
			temporaryActivityDetail.setTemporaryActivity(transferTemporaryActivity);
			temporaryActivityDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			temporaryActivityDetail.setCreater(userBean.getUser());
			temporaryActivityDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		}
		TemporaryActivityCreateDxo.dtoToEntity(temporaryActivityCreateDto, transferTemporaryActivity);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		temporaryActivityCreateDto.setReturner(returner);
		return Navigation.TEMPORARY_ACTIVITY_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, TemporaryActivity temporaryActivity) {
		temporaryActivityCreateDto.setReturner(returner);
		TemporaryActivityCreateDxo.entityToDto(temporaryActivity, temporaryActivityCreateDto);
		temporaryActivityCreateDto.setTransferTemporaryActivity(temporaryActivity);
		// 查询出活动套餐详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TemporaryActivityDetail.class);
		detachedCriteria.createAlias(TemporaryActivityDetail.TEMPORARY_ACTIVITY, TemporaryActivityDetail.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(TemporaryActivityDetail.MARKETING_PROJECT, TemporaryActivityDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(TemporaryActivityDetail.TEMPORARY_ACTIVITY, temporaryActivity));
		temporaryActivityCreateDto.setTemporaryActivityDetailList(temporaryActivityDetailService.getByDetachedCriteria(detachedCriteria));
		sumMoney();
		return Navigation.TEMPORARY_ACTIVITY_CREATE;
	}
	
	/**
	 * 此方法绑定于活动套餐登陆画面的增加一行活动项目按钮 
	 * @return 画面不跳转
	 */
	public void addTemporaryActivity() {
		Tool.sendLog(LOG, userBean, "【活动套餐登陆画面_增加一行活动项目按钮】");
		List<TemporaryActivityDetail> temporaryActivityDetailList = temporaryActivityCreateDto.getTemporaryActivityDetailList();
		if (temporaryActivityDetailList == null) {
			temporaryActivityDetailList = new ArrayList<TemporaryActivityDetail>();
			temporaryActivityCreateDto.setTemporaryActivityDetailList(temporaryActivityDetailList);
		}
		temporaryActivityDetailList.add(new TemporaryActivityDetail());
	}
	
	/**
	 * 此方法绑定于活动套餐登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteTemporaryActivity(TemporaryActivityDetail temporaryActivityDetail) {
		Tool.sendLog(LOG, userBean, "【活动套餐登陆画面_删除按钮】");
		if (temporaryActivityDetail.getId() != null) {
			temporaryActivityDetailService.deleteEntity(temporaryActivityDetail);
		}
		temporaryActivityCreateDto.getTemporaryActivityDetailList().remove(temporaryActivityDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 选择后，数量默认设定为一，并设定价值
	 * @param temporaryActivityDetail
	 */
	public void createMarketingProject(TemporaryActivityDetail temporaryActivityDetail) {
		temporaryActivityDetail.setMoney(temporaryActivityDetail.getMarketingProject().getMoney());
		temporaryActivityDetail.setNumber(1);
		sumMoney();
	}
	
	/**
	 * 自动计算总金额
	 */
	public void getSumMoney() {
		sumMoney();
	}
	
	/**
	 * 统计总金额
	 */
	private void sumMoney() {
		List<TemporaryActivityDetail> temporaryActivityDetailList = temporaryActivityCreateDto.getTemporaryActivityDetailList();
		// 累加现价格
		BigDecimal sumXmoney = Constants.BIGDECIMAL_ZERO;
		// 累加原价格
		BigDecimal sumYmoney = Constants.BIGDECIMAL_ZERO;
		for (TemporaryActivityDetail temporaryActivityDetail : temporaryActivityDetailList) {
			
			BigDecimal multiply = BigDecimalUtil.multiply(temporaryActivityDetail.getMoney(), BigDecimalUtil.toBigDecimal(temporaryActivityDetail.getNumber()));
			sumXmoney = BigDecimalUtil.add(sumXmoney, multiply);
			MarketingProject marketingProject = temporaryActivityDetail.getMarketingProject();
			multiply = BigDecimalUtil.multiply(marketingProject.getMoney(), BigDecimalUtil.toBigDecimal(temporaryActivityDetail.getNumber()));
			sumYmoney = BigDecimalUtil.add(sumYmoney, multiply);
		}
		temporaryActivityCreateDto.setSumXmoney(sumXmoney);
		temporaryActivityCreateDto.setSumYmoney(sumYmoney);
		temporaryActivityCreateDto.setMoney(sumXmoney);
	}
	
	/**
	 * @param temporaryActivityDetailService the temporaryActivityDetailService to set
	 */
	public void setTemporaryActivityDetailService(
			TemporaryActivityDetailService temporaryActivityDetailService) {
		this.temporaryActivityDetailService = temporaryActivityDetailService;
	}

	/**
	 * set temporaryActivityService
	 * @param temporaryActivityService the temporaryActivityService to set
	 */
	public void setTemporaryActivityService(TemporaryActivityService temporaryActivityService) {
		this.temporaryActivityService = temporaryActivityService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get temporaryActivityCreateDto
	 * @return the temporaryActivityCreateDto
	 */
	public TemporaryActivityCreateDto getTemporaryActivityCreateDto() {
		return temporaryActivityCreateDto;
	}

	/**
	 * set temporaryActivityCreateDto
	 * @param temporaryActivityCreateDto the temporaryActivityCreateDto to set
	 */
	public void setTemporaryActivityCreateDto(TemporaryActivityCreateDto temporaryActivityCreateDto) {
		this.temporaryActivityCreateDto = temporaryActivityCreateDto;
	}

}
