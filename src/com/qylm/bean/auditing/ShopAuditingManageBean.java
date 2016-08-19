package com.qylm.bean.auditing;

import java.util.Arrays;
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
import com.qylm.bean.returner.auditing.ShopAuditingManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.auditing.ShopAuditingManageDto;
import com.qylm.entity.ShopAuditing;
import com.qylm.service.ShopAuditingService;

/**
 * 店铺配货审核管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ShopAuditingManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8970765243338511928L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShopAuditingManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ShopAuditingManageDto shopAuditingManageDto = new ShopAuditingManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ShopAuditing> shopAuditingList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ShopAuditing[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{shopAuditingService}")
	private ShopAuditingService shopAuditingService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_店铺配货审核菜单】");
		fetchData(0, true);
		return Navigation.SHOP_AUDITING_MANAGE;
	}
	
	/**
	 * 此方法绑定于店铺配货审核管理画面的新建按钮 
	 * 实现功能：跳转至店铺配货审核登陆画面，新建一家事件
	 * @return 店铺配货审核登陆画面
	 */
	public String newShopAuditing() {
		Tool.sendLog(LOG, userBean, "按下【店铺配货审核管理画面_新建按钮】");
		return Tool.getBackBean(ShopAuditingCreateBean.class).newCreate(new ShopAuditingManageReturner(shopAuditingManageDto, currentPage));
	}

	/**
	 * 此方法绑定于店铺配货审核管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至店铺配货审核登陆画面
	 * @return 店铺配货审核登陆画面
	 */
	public String updateShopAuditing(ShopAuditing transferShopAuditing) {
		Tool.sendLog(LOG, userBean, "按下【店铺配货审核管理画面_修改按钮】");
		return Tool.getBackBean(ShopAuditingCreateBean.class).updateDetail(new ShopAuditingManageReturner(shopAuditingManageDto, currentPage), transferShopAuditing);
	}
	
	/**
	 * 此方法绑定于店铺配货审核管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectShopAuditing() {
		Tool.sendLog(LOG, userBean, "按下【店铺配货审核管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于店铺配货审核管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【店铺配货审核管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ShopAuditing> asList = Arrays.asList(selectedModels);
				shopAuditingService.deleteEntityAll(asList);
				shopAuditingList.removeAll(asList);
				removeData(1, shopAuditingList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于店铺配货审核管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteShopAuditing(ShopAuditing transferShopAuditing) {
		Tool.sendLog(LOG, userBean, "按下【店铺配货审核管理画面的_删除按钮】");
		try {
			shopAuditingService.deleteEntity(transferShopAuditing);
			shopAuditingList.remove(transferShopAuditing);
			removeData(1, shopAuditingList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ShopAuditing transferShopAuditing) {
		Tool.sendLog(LOG, userBean, "按下【店铺配货审核管理画面的_视图按钮】");
		if (transferShopAuditing == null) {
			transferShopAuditing = shopAuditingService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ShopAuditingViewBean.class).viewDetail(transferShopAuditing);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopAuditing.class);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE, ShopAuditing.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE_DEPOT_INFO, ShopAuditing.SHOP_APPLE_DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE_USER, ShopAuditing.SHOP_APPLE_USER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAuditing.AUDITOR, ShopAuditing.AUDITOR, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ShopAuditing.AUDITOR, userBean.getUser()));
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String number = shopAuditingManageDto.getNumber();
		if (StringUtil.isNotBlank(number)) {
			detachedCriteria.add(Restrictions.like(ShopAuditing.SHOP_APPLE_NUMBER, number, MatchMode.ANYWHERE));
		}
		shopAuditingList = shopAuditingService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(shopAuditingService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.SHOP_AUDITING_MANAGE;
	}

	/**
	 * set shopAuditingService
	 * @param shopAuditingService the shopAuditingService to set
	 */
	public void setShopAuditingService(ShopAuditingService shopAuditingService) {
		this.shopAuditingService = shopAuditingService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get shopAuditingManageDto
	 * @return the shopAuditingManageDto
	 */
	public ShopAuditingManageDto getShopAuditingManageDto() {
		return shopAuditingManageDto;
	}

	/**
	 * set shopAuditingManageDto
	 * @param shopAuditingManageDto the shopAuditingManageDto to set
	 */
	public void setShopAuditingManageDto(ShopAuditingManageDto shopAuditingManageDto) {
		this.shopAuditingManageDto = shopAuditingManageDto;
	}

	/**
	 * get shopAuditingList
	 * @return the shopAuditingList
	 */
	public List<ShopAuditing> getShopAuditingList() {
		return shopAuditingList;
	}

	/**
	 * set shopAuditingList
	 * @param shopAuditingList the shopAuditingList to set
	 */
	public void setShopAuditingList(List<ShopAuditing> shopAuditingList) {
		this.shopAuditingList = shopAuditingList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ShopAuditing[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ShopAuditing[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
