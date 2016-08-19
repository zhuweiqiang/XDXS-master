package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.FileUploadBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.bean.returner.baseSet.ProductStockCreateReturner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.baseSet.ProductStockCreateDto;
import com.qylm.dxo.ProductStockCreateDxo;
import com.qylm.entity.FileControl;
import com.qylm.entity.FileEntity;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;
import com.qylm.entity.Series;
import com.qylm.service.FileControlService;
import com.qylm.service.ProductStockDetailService;
import com.qylm.service.ProductStockService;
import com.qylm.service.SeriesService;

/**
 * 产品登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProductStockCreateBean implements Serializable, CreateBean<ProductStock> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7872347407532967397L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ProductStockCreateBean.class);

	/**
	 * 存放产品登陆画面需要保存的值
	 */
	private ProductStockCreateDto productStockCreateDto = new ProductStockCreateDto();
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 产品业务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 * 产品详细业务类
	 */
	@ManagedProperty(value="#{productStockDetailService}")
	private ProductStockDetailService productStockDetailService;
	
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
	 * 此方法绑定于产品登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 产品登陆画面
	 */
	public String newProductStock() {
		Tool.sendLog(LOG, userBean, "【产品登陆画面_新建按钮】");
		productStockCreateDto.setName(null);
		productStockCreateDto.setIntroduce(null);
		productStockCreateDto.setMoney(null);
		productStockCreateDto.setCost(null);
		productStockCreateDto.setRemark(null);
		productStockCreateDto.setSeriesId(null);
		SelectItem[] seriesItems = new SelectItem[1];
		seriesItems[0] = Constants.UN_SELECT_ITEM;
		productStockCreateDto.setSeriesItems(seriesItems);
		productStockCreateDto.setBrand(null);
		productStockCreateDto.setSeries(null);
		productStockCreateDto.setUnit(null);
		productStockCreateDto.setProductStockDetailList(null);
		productStockCreateDto.setDepotInfo(null);
		productStockCreateDto.setNumber(null);
		productStockCreateDto.setFileControlList(null);
		productStockCreateDto.setCreater(null);
		productStockCreateDto.setBelongingUser(null);
		productStockCreateDto.setTransferProductStock(null);
		return Navigation.PRODUCT_STOCK_CREATE;
	}
	
	/**
	 * 此方法绑定于产品登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【产品登陆画面_返回按钮】");
		return productStockCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于产品登陆画面的保存按钮 
	 * 实现功能：根据transferProductStock对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveProductStock() {
		Tool.sendLog(LOG, userBean, "按下【产品登陆画面_保存按钮】");
		ProductStock transferProductStock = productStockCreateDto.getTransferProductStock();
		if (transferProductStock == null) {
			transferProductStock = new ProductStock();
			productStockCreateDto.setCreater(userBean.getUser());
			productStockCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferProductStock);
			transferProductStock.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			productStockService.saveEntity(transferProductStock);
			productStockCreateDto.setTransferProductStock(transferProductStock);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferProductStock);
			transferProductStock.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			productStockService.updateEntity(transferProductStock);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferProductStock
	 */
	private void create(ProductStock transferProductStock) {
		if (!StringUtil.isUnSelected(productStockCreateDto.getSeriesId())) {
			productStockCreateDto.setSeries(seriesService.getById(Integer.valueOf(productStockCreateDto.getSeriesId())));
		}
		ProductStockCreateDxo.dtoToEntity(productStockCreateDto, transferProductStock);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		productStockCreateDto.setReturner(returner);
		SelectItem[] seriesItems = new SelectItem[1];
		seriesItems[0] = Constants.UN_SELECT_ITEM;
		productStockCreateDto.setSeriesItems(seriesItems);
		return Navigation.PRODUCT_STOCK_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, ProductStock productStock) {
		productStockCreateDto.setReturner(returner);
		ProductStockCreateDxo.entityToDto(productStock, productStockCreateDto);
		if (productStockCreateDto.getSeries() != null) {
			productStockCreateDto.setSeriesId(productStockCreateDto.getSeries().getId().toString());
		}
		selectSeriesItems();
		productStockCreateDto.setTransferProductStock(productStock);
		return Navigation.PRODUCT_STOCK_CREATE;
	}
	
	/**
	 * 用于选中品牌时获取到相对应的系列
	 */
	public void selectSeriesItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Series.class);
		detachedCriteria.createAlias(Series.BRAND, Series.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Series.BRAND, productStockCreateDto.getBrand()));
		List<Series> seriesList = seriesService.getByDetachedCriteria(detachedCriteria);
		if (!seriesList.isEmpty()) {
			int size = seriesList.size();
			SelectItem[] seriesItems = new SelectItem[size + 1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			for (int i = 0; i < size; i++) {
				Series series = seriesList.get(i);
				seriesItems[i+1] = new SelectItem(series.getId().toString(), series.getName());
			}
			productStockCreateDto.setSeriesItems(seriesItems);
		} else {
			SelectItem[] seriesItems = new SelectItem[1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			productStockCreateDto.setSeriesItems(seriesItems);
		}
		
	}
	
	/**
	 * 此方法绑定于产品登陆画面的增加产品按钮 
	 * @return 画面不跳转
	 */
	public void addProductStock() {
		Tool.sendLog(LOG, userBean, "按下【产品登陆画面_增加产品按钮】");
		productStockCreateDto.setDepotInfo(null);
		productStockCreateDto.setNumber(null);
	}
	
	/**
	 * 此方法绑定于产品登陆画面的修改按钮 
	 * @return 画面不跳转
	 */
	public void updateProductStockDetail(ProductStockDetail productStockDetail) {
		Tool.sendLog(LOG, userBean, "按下【产品登陆画面_修改按钮】");
		productStockCreateDto.setDepotInfo(productStockDetail.getDepotInfo());
		productStockCreateDto.setNumber(productStockDetail.getNumber());
	}
	
	/**
	 * 此方法绑定于产品登陆画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteProductStockDetail(ProductStockDetail productStockDetail) {
		Tool.sendLog(LOG, userBean, "按下【产品登陆画面_删除按钮】");
		try {
			if (productStockDetail.getId() != null) {
				productStockDetailService.deleteEntity(productStockDetail);
			}
			List<ProductStockDetail> productStockDetailList = productStockCreateDto.getProductStockDetailList();
			productStockDetailList.remove(productStockDetail);
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 此方法绑定于产品登陆画面的保存按钮 
	 * @return 画面不跳转
	 */
	public void saveProductStockDetail() {
		Tool.sendLog(LOG, userBean, "按下【产品登陆画面_保存按钮】");
		List<ProductStockDetail> productStockDetailList = productStockCreateDto.getProductStockDetailList();
		if (productStockDetailList == null) {
			productStockDetailList = new ArrayList<ProductStockDetail>();
			productStockCreateDto.setProductStockDetailList(productStockDetailList);
		}
		ProductStockDetail productStockDetail = new ProductStockDetail();
		// 如果新增加的，仓库内已经存在就更新
		for (ProductStockDetail detail : productStockDetailList) {
			if (detail.getDepotInfo().equals(productStockCreateDto.getDepotInfo())) {
				productStockDetail = detail;
				productStockDetail.setDepotInfo(productStockCreateDto.getDepotInfo());
				productStockDetail.setNumber(BigDecimalUtil.add(productStockDetail.getNumber(), productStockCreateDto.getNumber()));
				break;
			}
		}
		if (productStockDetail.getDepotInfo() == null) {
			productStockDetail.setDepotInfo(productStockCreateDto.getDepotInfo());
			productStockDetail.setNumber(productStockCreateDto.getNumber());
			productStockDetailList.add(productStockDetail);
		}
		
	}
	
	/**
	 * 设置为默认
	 * @param event
	 */
	public void defaultFielControl(FileControl fileControl) {
		Tool.sendLog(LOG, userBean, "【配件登陆画面_默认显示按钮】");
		List<FileControl> fileControlList = productStockCreateDto.getFileControlList();
		for (FileControl control : fileControlList) {
			control.setDefaultState(false);
		}
		fileControl.setDefaultState(true);
		fileControlService.updateEntityAll(fileControlList);
	}
	
	/**
	 * 文件删除
	 * @param event
	 */
	public void deleteFileControl(FileControl fileControl) {
		Tool.sendLog(LOG, userBean, "【配件登陆画面_文件删除按钮】");
		productStockCreateDto.getFileControlList().remove(fileControl);
		fileControlService.deleteEntity(fileControl);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 上传文件
	 * @return
	 */
	public String uploadFile() {
		Tool.sendLog(LOG, userBean, "【配件登陆画面_上传文件按钮】");
		ProductStockCreateReturner productStockCreateReturner = new ProductStockCreateReturner(productStockCreateDto);
		return Tool.getBackBean(FileUploadBean.class).infoFileUpload(productStockCreateReturner, new FileEntity(productStockCreateDto.getTransferProductStock()));
	}
	
	/**
	 * 返回到本画面
	 * @return
	 */
	public String returner() {
		productStockCreateDto.setFileControlList(fileControlService.getFileControlList(productStockCreateDto.getTransferProductStock()));
		return Navigation.PRODUCT_STOCK_CREATE;
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
	 * @param productStockDetailService the productStockDetailService to set
	 */
	public void setProductStockDetailService(
			ProductStockDetailService productStockDetailService) {
		this.productStockDetailService = productStockDetailService;
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
	 * get productStockCreateDto
	 * @return the productStockCreateDto
	 */
	public ProductStockCreateDto getProductStockCreateDto() {
		return productStockCreateDto;
	}

	/**
	 * set productStockCreateDto
	 * @param productStockCreateDto the productStockCreateDto to set
	 */
	public void setProductStockCreateDto(ProductStockCreateDto productStockCreateDto) {
		this.productStockCreateDto = productStockCreateDto;
	}

}
