package com.qylm.bean.depot;

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
import com.qylm.bean.returner.depot.ProductDepotAllotManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.depot.ProductDepotAllotManageDto;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.ProductDepotAllot;
import com.qylm.exception.ProductDepotAllotException;
import com.qylm.service.ProductDepotAllotService;

/**
 * 仓库库存调拨管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ProductDepotAllotManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3202009289413681980L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProductDepotAllotManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ProductDepotAllotManageDto productDepotAllotManageDto = new ProductDepotAllotManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ProductDepotAllot> productDepotAllotList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ProductDepotAllot[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{productDepotAllotService}")
	private ProductDepotAllotService productDepotAllotService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_仓库库存调拨菜单】");
		fetchData(0, true);
		return Navigation.PRODUCT_DEPOT_ALLOT_MANAGE;
	}
	
	/**
	 * 此方法绑定于仓库库存调拨管理画面的新建按钮 
	 * 实现功能：跳转至仓库库存调拨登陆画面，新建一家事件
	 * @return 仓库库存调拨登陆画面
	 */
	public String newProductDepotAllot() {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面_新建按钮】");
		return Tool.getBackBean(ProductDepotAllotCreateBean.class).newCreate(new ProductDepotAllotManageReturner(productDepotAllotManageDto, currentPage));
	}

	/**
	 * 此方法绑定于仓库库存调拨管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至仓库库存调拨登陆画面
	 * @return 仓库库存调拨登陆画面
	 */
	public String updateProductDepotAllot(ProductDepotAllot transferProductDepotAllot) {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面_修改按钮】");
		return Tool.getBackBean(ProductDepotAllotCreateBean.class).updateDetail(new ProductDepotAllotManageReturner(productDepotAllotManageDto, currentPage), transferProductDepotAllot);
	}
	
	/**
	 * 此方法绑定于仓库库存调拨管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectProductDepotAllot() {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于仓库库存调拨管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ProductDepotAllot> asList = Arrays.asList(selectedModels);
				productDepotAllotService.deleteEntityAll(asList);
				productDepotAllotList.removeAll(asList);
				removeData(1, productDepotAllotList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于仓库库存调拨管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteProductDepotAllot(ProductDepotAllot transferProductDepotAllot) {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面的_删除按钮】");
		try {
			productDepotAllotService.deleteEntity(transferProductDepotAllot);
			productDepotAllotList.remove(transferProductDepotAllot);
			removeData(1, productDepotAllotList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 此方法绑定于仓库库存调拨管理画面的确认按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void queryProductDepotAllot(ProductDepotAllot transferProductDepotAllot) {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面的_确认按钮】");
		transferProductDepotAllot.setState(true);
		try {
			productDepotAllotService.updateProductDepotAllot(transferProductDepotAllot);
		} catch (ProductDepotAllotException e) {
			Tool.sendErrorMessage(e.getMessage());
		}
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ProductDepotAllot transferProductDepotAllot) {
		Tool.sendLog(LOG, userBean, "按下【仓库库存调拨管理画面的_视图按钮】");
		if (transferProductDepotAllot == null) {
			transferProductDepotAllot = productDepotAllotService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ProductDepotAllotViewBean.class).viewDetail(transferProductDepotAllot);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductDepotAllot.class);
		detachedCriteria.createAlias(ProductDepotAllot.DEPOT_INFO, ProductDepotAllot.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.ALLOT_DEPOT_INFO, ProductDepotAllot.ALLOT_DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.ALLOT_PRODUCT_STOCK_DETAIL, ProductDepotAllot.ALLOT_PRODUCT_STOCK_DETAIL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.PRODUCT_STOCK_DETAIL, ProductDepotAllot.PRODUCT_STOCK_DETAIL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.PRODUCT_STOCK_DETAIL_PRODUCT_STOCK, ProductDepotAllot.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String productName = productDepotAllotManageDto.getProductName();
		DepotInfo depotInfo = productDepotAllotManageDto.getDepotInfo();
		DepotInfo allotDepotInfo = productDepotAllotManageDto.getAllotDepotInfo();
		if (StringUtil.isNotBlank(productName)) {
			detachedCriteria.add(Restrictions.like(ProductDepotAllot.PRODUCT_STOCK_NAME, productName, MatchMode.ANYWHERE));
		}
		if (depotInfo != null) {
			detachedCriteria.add(Restrictions.eq(ProductDepotAllot.DEPOT_INFO, depotInfo));
		}
		if (allotDepotInfo != null) {
			detachedCriteria.add(Restrictions.eq(ProductDepotAllot.ALLOT_DEPOT_INFO, allotDepotInfo));
		}
		productDepotAllotList = productDepotAllotService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(productDepotAllotService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.PRODUCT_DEPOT_ALLOT_MANAGE;
	}

	/**
	 * set productDepotAllotService
	 * @param productDepotAllotService the productDepotAllotService to set
	 */
	public void setProductDepotAllotService(ProductDepotAllotService productDepotAllotService) {
		this.productDepotAllotService = productDepotAllotService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get productDepotAllotManageDto
	 * @return the productDepotAllotManageDto
	 */
	public ProductDepotAllotManageDto getProductDepotAllotManageDto() {
		return productDepotAllotManageDto;
	}

	/**
	 * set productDepotAllotManageDto
	 * @param productDepotAllotManageDto the productDepotAllotManageDto to set
	 */
	public void setProductDepotAllotManageDto(ProductDepotAllotManageDto productDepotAllotManageDto) {
		this.productDepotAllotManageDto = productDepotAllotManageDto;
	}

	/**
	 * get productDepotAllotList
	 * @return the productDepotAllotList
	 */
	public List<ProductDepotAllot> getProductDepotAllotList() {
		return productDepotAllotList;
	}

	/**
	 * set productDepotAllotList
	 * @param productDepotAllotList the productDepotAllotList to set
	 */
	public void setProductDepotAllotList(List<ProductDepotAllot> productDepotAllotList) {
		this.productDepotAllotList = productDepotAllotList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ProductDepotAllot[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ProductDepotAllot[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
