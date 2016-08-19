package com.qylm.bean.history;

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
import com.qylm.bean.myDesk.ShopCardBean;
import com.qylm.bean.returner.history.CustomCardManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.history.CustomCardManageDto;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.service.CustomLeaguerDetailService;

/**
 * 历史购卡记录bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class CustomCardManageBean extends BasePagingBean{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7571029949446457473L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShopCardBean.class);
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 保存历史购卡记录画面需要保存的值
	 */
	private CustomCardManageDto customCardManageDto = new CustomCardManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
	/**
	 * 删除复选框选择的值
	 */
	private CustomLeaguerDetail[] selectedModels;

	/**
	 * 登记详细业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "【功能菜单_客户卡项记录菜单】");
		fetchData(0, true);
		return Navigation.CUSTOM_CARD_MANAGE;
	}
	
	public String getAllGiveInfo() {
		Tool.sendLog(LOG, userBean, "【功能菜单_客户体验卡记录菜单】");
		customCardManageDto.setType(GiveInfo.TYPE_1);
		fetchData(0, true);
		return Navigation.HISTORY_GIVE_INFO_MANAGE;
	}
	
	public String getAllCashRoll() {
		Tool.sendLog(LOG, userBean, "【功能菜单_客户现金卷记录菜单】");
		customCardManageDto.setType(GiveInfo.TYPE_2);
		fetchData(0, true);
		return Navigation.HISTORY_CASH_ROLL_MANAGE;
	}

	public String getAllBodyVolume() {
		Tool.sendLog(LOG, userBean, "【功能菜单_客户身体卷记录菜单】");
		customCardManageDto.setType(GiveInfo.TYPE_3);
		fetchData(0, true);
		return Navigation.HISTORY_BODY_VOLUME_MANAGE;
	}
	
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.BASE_ID));
		if (StringUtil.isBlank(customCardManageDto.getType())) {
			detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.LEAGUER));
		}
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String type = customCardManageDto.getType();
		if (StringUtil.isNotBlank(type)) {
			detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.GIVE_INFO_TYPE, type));
		}
		String name = customCardManageDto.getName();
		String leaguerNumber = customCardManageDto.getLeaguerNumber();
		Date beginDate = customCardManageDto.getBeginDate();
		Date endDate = customCardManageDto.getEndDate();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(CustomLeaguerDetail.CUSTOM_INFO_LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(CustomLeaguerDetail.CUSTOM_INFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(CustomLeaguerDetail.CREATE_DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(CustomLeaguerDetail.CREATE_DATE, endDate));
		}
		customLeaguerDetailList = customLeaguerDetailService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(customLeaguerDetailService.getRowCount(detachedCriteria));
		}
	}
	
	/**
	 * 此方法绑定于历史购卡记录画面的新建历史购卡按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 历史购卡记录管理画面
	 * 
	 */
	public String newCustomCard() {
		Tool.sendLog(LOG, userBean, "【购卡登陆画面_新建按钮】");
		if(customCardManageDto.getType()!=null){
				return Tool.getBackBean(CustomCardCreateBean.class).newCreate(new CustomCardManageReturner(customCardManageDto, currentPage),customCardManageDto.getType());}else{
		return Tool.getBackBean(CustomCardCreateBean.class).newCreate(new CustomCardManageReturner(customCardManageDto, currentPage));}
	}
	
	/**
	 * 此方法绑定于个人消费登记管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectCustomCard() {
		Tool.sendLog(LOG, userBean, "按下【历史购卡记录管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.CUSTOM_CARD_MANAGE;
	}
	
	/**
	 * 绑定于个人消费登记管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【历史购卡记录管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<CustomLeaguerDetail> asList = Arrays.asList(selectedModels);
				customLeaguerDetailService.deleteEntityAll(asList);
				customLeaguerDetailList.removeAll(asList);
				removeData(1, customLeaguerDetailList.isEmpty());
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
	public void deleteCustomLeaguerDetail(CustomLeaguerDetail transferCustomLeaguerDetail) {
		Tool.sendLog(LOG, userBean, "按下【历史购卡记录管理画面的_删除按钮】");
		try {
			customLeaguerDetailService.deleteEntity(transferCustomLeaguerDetail);
			customLeaguerDetailList.remove(transferCustomLeaguerDetail);
			removeData(1, customLeaguerDetailList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于客户反馈记录管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至客户反馈记录登陆画面
	 * @return 客户反馈记录登陆画面
	 */
	public String updateCustomLeaguerDetail(CustomLeaguerDetail transferCustomLeaguerDetail) {
		Tool.sendLog(LOG, userBean, "按下【客户反馈记录管理画面_修改按钮】");
		if (customCardManageDto.getType() != null) {
			return Tool.getBackBean(CustomCardCreateBean.class).updateDetail(
					new CustomCardManageReturner(customCardManageDto, currentPage), transferCustomLeaguerDetail,
					customCardManageDto.getType());
		} else {
			return Tool.getBackBean(CustomCardCreateBean.class).updateDetail(
					new CustomCardManageReturner(customCardManageDto, currentPage), transferCustomLeaguerDetail);
		}
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the customLeaguerDetailList
	 */
	public List<CustomLeaguerDetail> getCustomLeaguerDetailList() {
		return customLeaguerDetailList;
	}
	
	/**
	 * @param customLeaguerDetailList the customLeaguerDetailList to set
	 */
	public void setCustomLeaguerDetailList(
			List<CustomLeaguerDetail> customLeaguerDetailList) {
		this.customLeaguerDetailList = customLeaguerDetailList;
	}
	
	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}
	
	/**
	 * @return the customCardManageDto
	 */
	public CustomCardManageDto getCustomCardManageDto() {
		return customCardManageDto;
	}
	
	/**
	 * @param customCardManageDto the customCardManageDto to set
	 */
	public void setCustomCardManageDto(CustomCardManageDto customCardManageDto) {
		this.customCardManageDto = customCardManageDto;
	}
	
	/**
	 * @return the selectedModels
	 */
	public CustomLeaguerDetail[] getSelectedModels() {
		return selectedModels;
	}
	
	/**
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(CustomLeaguerDetail[] selectedModels) {
		this.selectedModels = selectedModels;
	}
}
