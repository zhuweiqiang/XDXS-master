package com.qylm.bean.prepareGoods;

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
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.prepareGoods.ShopAppleManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.prepareGoods.ShopAppleManageDto;
import com.qylm.entity.ShopApple;
import com.qylm.entity.User;
import com.qylm.service.ShopAppleService;

/**
 * 店铺申请配货管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ShopAppleManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3034843730391157721L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShopAppleManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ShopAppleManageDto shopAppleManageDto = new ShopAppleManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ShopApple> shopAppleList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ShopApple[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{shopAppleService}")
	private ShopAppleService shopAppleService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_店铺申请配货菜单】");
		fetchData(0, true);
		return Navigation.SHOP_APPLE_MANAGE;
	}
	
	/**
	 * 此方法绑定于店铺申请配货管理画面的新建按钮 
	 * 实现功能：跳转至店铺申请配货登陆画面，新建一家事件
	 * @return 店铺申请配货登陆画面
	 */
	public String newShopApple() {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面_新建按钮】");
		return Tool.getBackBean(ShopAppleCreateBean.class).newCreate(new ShopAppleManageReturner(shopAppleManageDto, currentPage));
	}

	/**
	 * 此方法绑定于店铺申请配货管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至店铺申请配货登陆画面
	 * @return 店铺申请配货登陆画面
	 */
	public String updateShopApple(ShopApple transferShopApple) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面_修改按钮】");
		return Tool.getBackBean(ShopAppleCreateBean.class).updateDetail(new ShopAppleManageReturner(shopAppleManageDto, currentPage), transferShopApple);
	}
	
	/**
	 * 此方法绑定于店铺申请配货管理画面的提交申请按钮 
	 * @return 画面不跳转
	 */
	public void submitShopApple(ShopApple transferShopApple) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面_提交申请按钮】");
		transferShopApple.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		transferShopApple.setAppleState(ShopApple.APPLE_STATE_2);
		shopAppleService.updateShopApple(transferShopApple);
		Tool.sendErrorMessage("提交成功，进入审核！");
	}
	
	/**
	 * 此方法绑定于店铺申请配货管理画面的入库按钮 
	 * @return 画面不跳转
	 */
	public void storage(ShopApple transferShopApple) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面_入库按钮】");
		transferShopApple.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		transferShopApple.setAppleState(ShopApple.APPLE_STATE_5);
		shopAppleService.updateShopApple(transferShopApple);
		Tool.sendErrorMessage("提交成功，进入审核！");
	}
	
	/**
	 * 此方法绑定于店铺申请配货管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectShopApple() {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于店铺申请配货管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ShopApple> asList = Arrays.asList(selectedModels);
				shopAppleService.deleteEntityAll(asList);
				shopAppleList.removeAll(asList);
				removeData(1, shopAppleList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于店铺申请配货管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteShopApple(ShopApple transferShopApple) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面的_删除按钮】");
		try {
			shopAppleService.deleteEntity(transferShopApple);
			shopAppleList.remove(transferShopApple);
			removeData(1, shopAppleList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ShopApple transferShopApple) {
		Tool.sendLog(LOG, userBean, "按下【店铺申请配货管理画面的_视图按钮】");
		if (transferShopApple == null) {
			transferShopApple = shopAppleService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ShopAppleViewBean.class).viewDetail(transferShopApple);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopApple.class);
		detachedCriteria.createAlias(ShopApple.DEPOT_INFO, ShopApple.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopApple.USER, ShopApple.USER, JoinType.LEFT_OUTER_JOIN);
		User user = userBean.getUser();
		MothedUtil.getBelongingUser(detachedCriteria, user);
		if (!User.USER_LEVEL_1.equals(user.getUserlevel())) {
			detachedCriteria.add(Restrictions.or(Restrictions.eq(ShopApple.CREATER, user), Restrictions.eq(ShopApple.USER, user)));
		}
		String number = shopAppleManageDto.getNumber();
		String appleState = shopAppleManageDto.getAppleState();
		Date beginAppleDate = shopAppleManageDto.getBeginAppleDate();
		Date endAppleDate = shopAppleManageDto.getEndAppleDate();
		if (StringUtil.isNotBlank(number)) {
			detachedCriteria.add(Restrictions.like(ShopApple.NUMBER, number, MatchMode.ANYWHERE));
		}
		if (!StringUtil.isUnSelected(appleState)) {
			detachedCriteria.add(Restrictions.eq(ShopApple.APPLE_STATE, appleState));
		}
		if (beginAppleDate != null) {
			detachedCriteria.add(Restrictions.ge(ShopApple.APPLE_DATE, beginAppleDate));
		}
		if (endAppleDate != null) {
			detachedCriteria.add(Restrictions.le(ShopApple.APPLE_DATE, endAppleDate));
		}
		shopAppleList = shopAppleService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(shopAppleService.getRowCount(detachedCriteria));
		}
	}
	
	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.SHOP_APPLE_MANAGE;
	}

	/**
	 * set shopAppleService
	 * @param shopAppleService the shopAppleService to set
	 */
	public void setShopAppleService(ShopAppleService shopAppleService) {
		this.shopAppleService = shopAppleService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get shopAppleManageDto
	 * @return the shopAppleManageDto
	 */
	public ShopAppleManageDto getShopAppleManageDto() {
		return shopAppleManageDto;
	}

	/**
	 * set shopAppleManageDto
	 * @param shopAppleManageDto the shopAppleManageDto to set
	 */
	public void setShopAppleManageDto(ShopAppleManageDto shopAppleManageDto) {
		this.shopAppleManageDto = shopAppleManageDto;
	}

	/**
	 * get shopAppleList
	 * @return the shopAppleList
	 */
	public List<ShopApple> getShopAppleList() {
		return shopAppleList;
	}

	/**
	 * set shopAppleList
	 * @param shopAppleList the shopAppleList to set
	 */
	public void setShopAppleList(List<ShopApple> shopAppleList) {
		this.shopAppleList = shopAppleList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ShopApple[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ShopApple[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
