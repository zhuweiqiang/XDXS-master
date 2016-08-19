package com.qylm.bean.baseSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.baseSet.ProductStockManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.baseSet.ProductStockManageDto;
import com.qylm.entity.Brand;
import com.qylm.entity.FileControl;
import com.qylm.entity.ProductStock;
import com.qylm.entity.Series;
import com.qylm.service.FileControlService;
import com.qylm.service.ProductStockService;
import com.qylm.service.SeriesService;

/**
 * 产品管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ProductStockManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6788535220733677853L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProductStockManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private ProductStockManageDto productStockManageDto = new ProductStockManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<ProductStock> productStockList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ProductStock[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 * 文件业务类
	 */
	@ManagedProperty(value = "#{fileControlService}")
	private FileControlService fileControlService;
	
	/**
	 * 系列业务类
	 */
	@ManagedProperty(value="#{seriesService}")
	private SeriesService seriesService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_产品菜单】");
		fetchData(0, true);
		SelectItem[] seriesItems = new SelectItem[1];
		seriesItems[0] = Constants.UN_SELECT_ITEM;
		productStockManageDto.setSeriesItems(seriesItems);
		return Navigation.PRODUCT_STOCK_MANAGE;
	}
	
	/**
	 * 此方法绑定于产品管理画面的新建按钮 
	 * 实现功能：跳转至产品登陆画面，新建一家事件
	 * @return 产品登陆画面
	 */
	public String newProductStock() {
		Tool.sendLog(LOG, userBean, "按下【产品管理画面_新建按钮】");
		return Tool.getBackBean(ProductStockCreateBean.class).newCreate(new ProductStockManageReturner(productStockManageDto, currentPage));
	}
	
	/**
	 * 此方法绑定于产品管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至产品登陆画面
	 * @return 产品登陆画面
	 */
	public String updateProductStock(ProductStock transferProductStock) {
		Tool.sendLog(LOG, userBean, "按下【产品管理画面_修改按钮】");
		return Tool.getBackBean(ProductStockCreateBean.class).updateDetail(new ProductStockManageReturner(productStockManageDto, currentPage), transferProductStock);
	}
	
	/**
	 * 此方法绑定于产品管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectProductStock() {
		Tool.sendLog(LOG, userBean, "按下【产品管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 用于选中品牌时获取到相对应的系列
	 */
	public void selectSeriesItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Series.class);
		detachedCriteria.createAlias(Series.BRAND, Series.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Series.BRAND, productStockManageDto.getBrand()));
		List<Series> seriesList = seriesService.getByDetachedCriteria(detachedCriteria);
		if (!seriesList.isEmpty()) {
			int size = seriesList.size();
			SelectItem[] seriesItems = new SelectItem[size + 1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			for (int i = 0; i < size; i++) {
				Series series = seriesList.get(i);
				seriesItems[i+1] = new SelectItem(series.getId().toString(), series.getName());
			}
			productStockManageDto.setSeriesItems(seriesItems);
		} else {
			SelectItem[] seriesItems = new SelectItem[1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			productStockManageDto.setSeriesItems(seriesItems);
		}
		
	}
	
	/**
	 * 绑定于产品管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【产品管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ProductStock> asList = Arrays.asList(selectedModels);
				productStockService.deleteFileEntityAll(asList);
				productStockList.removeAll(asList);
				removeData(1, productStockList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于产品管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteProductStock(ProductStock transferProductStock) {
		Tool.sendLog(LOG, userBean, "按下【产品管理画面的_删除按钮】");
		try {
			productStockService.deleteFileEntity(transferProductStock);
			productStockList.remove(transferProductStock);
			removeData(1, productStockList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ProductStock transferProductStock) {
		Tool.sendLog(LOG, userBean, "按下【产品管理画面的_视图按钮】");
		if (transferProductStock == null) {
			transferProductStock = productStockService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ProductStockViewBean.class).viewDetail(transferProductStock);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		detachedCriteria.createAlias(ProductStock.BRAND, ProductStock.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductStock.SERIES, ProductStock.SERIES, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = productStockManageDto.getName();
		Brand brand = productStockManageDto.getBrand();
		String seriesId = productStockManageDto.getSeriesId();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(ProductStock.NAME, name, MatchMode.ANYWHERE));
		}
		if (brand != null) {
			detachedCriteria.add(Restrictions.eq(ProductStock.BRAND, brand));
		}
		if (!StringUtil.isUnSelected(seriesId)) {
			detachedCriteria.add(Restrictions.eq(ProductStock.SERIES_ID, Integer.valueOf(seriesId)));
		}
		productStockList = productStockService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(productStockService.getRowCount(detachedCriteria));
		}
		if (!productStockList.isEmpty()) {
			Map<Integer, FileControl> fileControlOneList = fileControlService.getFileControlOneList(productStockList);
			for (ProductStock productStock : productStockList) {
				for (Entry<Integer, FileControl> stock : fileControlOneList.entrySet()) {
					if (productStock.getId().equals(stock.getKey())) {
						productStock.setFileControl(stock.getValue());
						break;
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
		return Navigation.PRODUCT_STOCK_MANAGE;
	}

	/**
	 * @param seriesService the seriesService to set
	 */
	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	/**
	 * @param fileControlService the fileControlService to set
	 */
	public void setFileControlService(FileControlService fileControlService) {
		this.fileControlService = fileControlService;
	}

	/**
	 * set productStockService
	 * @param productStockService the productStockService to set
	 */
	public void setProductStockService(ProductStockService productStockService) {
		this.productStockService = productStockService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get productStockManageDto
	 * @return the productStockManageDto
	 */
	public ProductStockManageDto getProductStockManageDto() {
		return productStockManageDto;
	}

	/**
	 * set productStockManageDto
	 * @param productStockManageDto the productStockManageDto to set
	 */
	public void setProductStockManageDto(ProductStockManageDto productStockManageDto) {
		this.productStockManageDto = productStockManageDto;
	}

	/**
	 * get productStockList
	 * @return the productStockList
	 */
	public List<ProductStock> getProductStockList() {
		return productStockList;
	}

	/**
	 * set productStockList
	 * @param productStockList the productStockList to set
	 */
	public void setProductStockList(List<ProductStock> productStockList) {
		this.productStockList = productStockList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ProductStock[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ProductStock[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
