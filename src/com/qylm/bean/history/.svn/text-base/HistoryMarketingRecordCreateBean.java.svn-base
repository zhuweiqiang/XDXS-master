package com.qylm.bean.history;

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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.history.HistoryMarketingRecordCreateDto;
import com.qylm.dxo.HistoryMarketingRecordCreateDxo;
import com.qylm.entity.Brand;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.entity.ProductStock;
import com.qylm.entity.Series;
import com.qylm.service.MarketingRecordDetailService;
import com.qylm.service.MarketingRecordService;
import com.qylm.service.ProductStockService;
import com.qylm.service.SeriesService;

/**
 * 客户产品记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryMarketingRecordCreateBean implements Serializable, CreateBean<MarketingRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7855724059330514036L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(HistoryMarketingRecordCreateBean.class);

	/**
	 * 存放客户产品记录登陆画面需要保存的值
	 */
	private HistoryMarketingRecordCreateDto historyMarketingRecordCreateDto = new HistoryMarketingRecordCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 客户产品记录业务类
	 */
	@ManagedProperty(value="#{marketingRecordService}")
	private MarketingRecordService marketingRecordService;
	
	/**
	 * 客户产品记录详细业务类
	 */
	@ManagedProperty(value="#{marketingRecordDetailService}")
	private MarketingRecordDetailService marketingRecordDetailService;
	
	/**
	 * 产品库存业务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 * 系列业务类
	 */
	@ManagedProperty(value="#{seriesService}")
	private SeriesService seriesService;
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 客户产品记录登陆画面
	 */
	public String newMarketingRecord() {
		Tool.sendLog(LOG, userBean, "【客户产品记录登陆画面_新建按钮】");
		historyMarketingRecordCreateDto.setCustomInfo(null);
		historyMarketingRecordCreateDto.setPersonnelInfo(null);
		historyMarketingRecordCreateDto.setAdviser(null);
		historyMarketingRecordCreateDto.setDate(DateUtil.getNowyyyymmdd());
		historyMarketingRecordCreateDto.setMoney(null);
		historyMarketingRecordCreateDto.setState(false);
		historyMarketingRecordCreateDto.setMarketingRecordDetailList(null);
		historyMarketingRecordCreateDto.setProductStockList(null);
		historyMarketingRecordCreateDto.setProductList(null);
		historyMarketingRecordCreateDto.setBrand(null);
		historyMarketingRecordCreateDto.setSeriesId(null);
		historyMarketingRecordCreateDto.setSeriesItems(null);
		historyMarketingRecordCreateDto.setProductStockName(null);
		historyMarketingRecordCreateDto.setCreater(null);
		historyMarketingRecordCreateDto.setBelongingUser(null);
		historyMarketingRecordCreateDto.setTransferMarketingRecord(null);
		return Navigation.HISTORY_MARKETING_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户产品记录登陆画面_返回按钮】");
		return historyMarketingRecordCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于客户产品记录登陆画面的保存按钮 
	 * 实现功能：根据transferMarketingRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveMarketingRecord() {
		Tool.sendLog(LOG, userBean, "【客户产品记录登陆画面_保存按钮】");
		MarketingRecord transferMarketingRecord = historyMarketingRecordCreateDto.getTransferMarketingRecord();
		operate(transferMarketingRecord);
	}
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的确认钮 
	 * 实现功能：根据transferMarketingRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryMarketingRecord() {
		Tool.sendLog(LOG, userBean, "【客户产品记录登陆画面_确认按钮】");
		MarketingRecord transferMarketingRecord = historyMarketingRecordCreateDto.getTransferMarketingRecord();
		historyMarketingRecordCreateDto.setState(true);
		operate(transferMarketingRecord);
	}

	/**
	 * 进行保存或者更新操作
	 * @param transferMarketingRecord
	 */
	private void operate(MarketingRecord transferMarketingRecord) {
		List<MarketingRecordDetail> marketingRecordDetailList = historyMarketingRecordCreateDto.getMarketingRecordDetailList();
		if (marketingRecordDetailList == null || marketingRecordDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须设定活动项目！");
			return;
		}
		if (transferMarketingRecord == null) {
			transferMarketingRecord = new MarketingRecord();
			historyMarketingRecordCreateDto.setCreater(userBean.getUser());
			historyMarketingRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferMarketingRecord);
			transferMarketingRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			marketingRecordService.saveMarketingRecord(transferMarketingRecord, marketingRecordDetailList);
			historyMarketingRecordCreateDto.setTransferMarketingRecord(transferMarketingRecord);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferMarketingRecord);
			transferMarketingRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			marketingRecordService.updateMarketingRecord(transferMarketingRecord, marketingRecordDetailList);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	
	/**
	 * 赋值
	 * @param transferMarketingRecord
	 */
	private void create(MarketingRecord transferMarketingRecord) {
		List<MarketingRecordDetail> marketingRecordDetailList = historyMarketingRecordCreateDto.getMarketingRecordDetailList();
		for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
			marketingRecordDetail.setMarketingRecord(transferMarketingRecord);
			marketingRecordDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			marketingRecordDetail.setCreater(userBean.getUser());
			marketingRecordDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		}
		HistoryMarketingRecordCreateDxo.dtoToEntity(historyMarketingRecordCreateDto, transferMarketingRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		historyMarketingRecordCreateDto.setReturner(returner);
		historyMarketingRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.HISTORY_MARKETING_RECORD_CREATE;
	}
	
	public String updateDetail(Returner<?, ?, ?> returner, MarketingRecord marketingRecord) {
		historyMarketingRecordCreateDto.setReturner(returner);
		HistoryMarketingRecordCreateDxo.entityToDto(marketingRecord, historyMarketingRecordCreateDto);
		historyMarketingRecordCreateDto.setTransferMarketingRecord(marketingRecord);
		// 查询出客户产品记录详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingRecordDetail.class);
		detachedCriteria.createAlias(MarketingRecordDetail.MARKETING_RECORD, MarketingRecordDetail.MARKETING_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK, MarketingRecordDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK_BRAND, MarketingRecordDetail.PRODUCT_STOCK_BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK_SERIES, MarketingRecordDetail.PRODUCT_STOCK_SERIES, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.DEPOT_INFO, MarketingRecordDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MarketingRecordDetail.MARKETING_RECORD, marketingRecord));
		historyMarketingRecordCreateDto.setMarketingRecordDetailList(marketingRecordDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.HISTORY_MARKETING_RECORD_CREATE;
	}
	
	/**
	 * 用于选中品牌时获取到相对应的系列
	 */
	public void selectSeriesItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Series.class);
		detachedCriteria.createAlias(Series.BRAND, Series.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Series.BRAND, historyMarketingRecordCreateDto.getBrand()));
		List<Series> seriesList = seriesService.getByDetachedCriteria(detachedCriteria);
		if (!seriesList.isEmpty()) {
			int size = seriesList.size();
			SelectItem[] seriesItems = new SelectItem[size + 1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			for (int i = 0; i < size; i++) {
				Series series = seriesList.get(i);
				seriesItems[i+1] = new SelectItem(series.getId().toString(), series.getName());
			}
			historyMarketingRecordCreateDto.setSeriesItems(seriesItems);
		} else {
			SelectItem[] seriesItems = new SelectItem[1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			historyMarketingRecordCreateDto.setSeriesItems(seriesItems);
		}
		
	}
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteMarketingRecord(MarketingRecordDetail marketingRecordDetail) {
		Tool.sendLog(LOG, userBean, "【客户产品记录登陆画面_删除按钮】");
		if (marketingRecordDetail.getId() != null) {
			marketingRecordDetailService.deleteEntity(marketingRecordDetail);
		}
		historyMarketingRecordCreateDto.getMarketingRecordDetailList().remove(marketingRecordDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的选择产品按钮 
	 * @return 画面不跳转
	 */
	public void findProductStock() {
		Tool.sendLog(LOG, userBean, "按下【客户产品记录登陆画面_选择产品按钮】");
		historyMarketingRecordCreateDto.setBrand(null);
		historyMarketingRecordCreateDto.setSeriesId(null);
		historyMarketingRecordCreateDto.setProductStockName(null);
		select();
	}

	/**
	 * 此方法绑定于客户产品记录登陆画面的搜索按钮 
	 * @return 画面不跳转
	 */
	public void selectProductStock() {
		Tool.sendLog(LOG, userBean, "按下【客户产品记录登陆画面_搜索按钮】");
		select();
	}
	
	private void select() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		detachedCriteria.createAlias(ProductStock.BRAND, ProductStock.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductStock.SERIES, ProductStock.SERIES, JoinType.LEFT_OUTER_JOIN);
		Brand brand = historyMarketingRecordCreateDto.getBrand();
		String seriesId = historyMarketingRecordCreateDto.getSeriesId();
		String productStockName = historyMarketingRecordCreateDto.getProductStockName();
		List<ProductStock> productList = historyMarketingRecordCreateDto.getProductList();
		if (brand != null) {
			detachedCriteria.add(Restrictions.eq(ProductStock.BRAND, brand));
		}
		if (!StringUtil.isUnSelected(seriesId)) {
			detachedCriteria.add(Restrictions.eq(ProductStock.SERIES_ID, Integer.valueOf(seriesId)));
		}
		if (StringUtil.isNotBlank(productStockName)) {
			detachedCriteria.add(Restrictions.like(ProductStock.NAME, productStockName, MatchMode.ANYWHERE));
		}
		if (productList != null && !productList.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for (ProductStock productStock : productList) {
				idList.add(productStock.getId());
			}
			detachedCriteria.add(Restrictions.not(Restrictions.in(ProductStock.BASE_ID, idList)));
		}
		historyMarketingRecordCreateDto.setProductStockList(productStockService.getByDetachedCriteria(detachedCriteria, 0, 20));
	}
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findProductStocks(ProductStock productStock) {
		Tool.sendLog(LOG, userBean, "按下【客户产品记录登陆画面_选择按钮】");
		List<ProductStock> productList = historyMarketingRecordCreateDto.getProductList();
		if (productList == null) {
			productList = new ArrayList<ProductStock>();
			historyMarketingRecordCreateDto.setProductList(productList);
		}
		productList.add(productStock);
		historyMarketingRecordCreateDto.getProductStockList().remove(productStock);
	}
	
	/**
	 * 此方法绑定于客户产品记录登陆画面的确认并结束选择按钮 
	 * @return 画面不跳转
	 */
	public void queryCloce() {
		Tool.sendLog(LOG, userBean, "按下【客户产品记录登陆画面_确认并结束选择按钮】");
		List<ProductStock> productList = historyMarketingRecordCreateDto.getProductList();
		if (productList != null && !productList.isEmpty()) {
			List<MarketingRecordDetail> marketingRecordDetailList = historyMarketingRecordCreateDto.getMarketingRecordDetailList();
			if (marketingRecordDetailList == null) {
				marketingRecordDetailList = new ArrayList<MarketingRecordDetail>();
				historyMarketingRecordCreateDto.setMarketingRecordDetailList(marketingRecordDetailList);
			}
			MarketingRecordDetail marketingRecordDetail;
			if (marketingRecordDetailList.isEmpty()) {
				for (ProductStock productStock : productList) {
					marketingRecordDetail = new MarketingRecordDetail();
					marketingRecordDetail.setProductStock(productStock);
					marketingRecordDetail.setMoney(productStock.getMoney());
					marketingRecordDetail.setNumber(1);
					marketingRecordDetailList.add(marketingRecordDetail);
				}
			} else {
				for (ProductStock productStock : productList) {
					boolean state = false;
					for (MarketingRecordDetail detail : marketingRecordDetailList) {
						if (productStock.equals(detail.getProductStock())) {
							state = true;
						}
					}
					if (!state) {
						marketingRecordDetail = new MarketingRecordDetail();
						marketingRecordDetail.setProductStock(productStock);
						marketingRecordDetail.setMoney(productStock.getMoney());
						marketingRecordDetail.setNumber(1);
						marketingRecordDetailList.add(marketingRecordDetail);
					}
				}
			}
		}
	}

	/**
	 * @param seriesService the seriesService to set
	 */
	public void setSeriesService(SeriesService seriesService) {
		this.seriesService = seriesService;
	}

	/**
	 * @param productStockService the productStockService to set
	 */
	public void setProductStockService(ProductStockService productStockService) {
		this.productStockService = productStockService;
	}

	/**
	 * @param marketingRecordDetailService the marketingRecordDetailService to set
	 */
	public void setMarketingRecordDetailService(
			MarketingRecordDetailService marketingRecordDetailService) {
		this.marketingRecordDetailService = marketingRecordDetailService;
	}

	/**
	 * set marketingRecordService
	 * @param marketingRecordService the marketingRecordService to set
	 */
	public void setMarketingRecordService(MarketingRecordService marketingRecordService) {
		this.marketingRecordService = marketingRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get historyMarketingRecordCreateDto
	 * @return the historyMarketingRecordCreateDto
	 */
	public HistoryMarketingRecordCreateDto getHistoryMarketingRecordCreateDto() {
		return historyMarketingRecordCreateDto;
	}

	/**
	 * set historyMarketingRecordCreateDto
	 * @param historyMarketingRecordCreateDto the historyMarketingRecordCreateDto to set
	 */
	public void setHistoryMarketingRecordCreateDto(HistoryMarketingRecordCreateDto historyMarketingRecordCreateDto) {
		this.historyMarketingRecordCreateDto = historyMarketingRecordCreateDto;
	}

}
