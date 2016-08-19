package com.qylm.bean.custom;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.hibernate.criterion.Order;
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
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.custom.MarketingRecordCreateDto;
import com.qylm.dxo.MarketingRecordCreateDxo;
import com.qylm.entity.Brand;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.LeaguerDetail;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.entity.ProductStock;
import com.qylm.entity.Series;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.LeaguerDetailService;
import com.qylm.service.MarketingRecordDetailService;
import com.qylm.service.MarketingRecordService;
import com.qylm.service.ProductStockService;
import com.qylm.service.SeriesService;

/**
 * 产品销售登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class MarketingRecordCreateBean implements Serializable, CreateBean<MarketingRecord> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3972197373641299327L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(MarketingRecordCreateBean.class);

	/**
	 * 存放产品销售登陆画面需要保存的值
	 */
	private MarketingRecordCreateDto marketingRecordCreateDto = new MarketingRecordCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 产品销售业务类
	 */
	@ManagedProperty(value="#{marketingRecordService}")
	private MarketingRecordService marketingRecordService;
	
	/**
	 * 产品销售详细业务类
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
	 * 客户档案与卡项业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 卡项详细业务类
	 */
	@ManagedProperty(value="#{leaguerDetailService}")
	private LeaguerDetailService leaguerDetailService;
	
	/**
	 * 此方法绑定于产品销售登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 产品销售登陆画面
	 */
	public String newMarketingRecord() {
		Tool.sendLog(LOG, userBean, "【产品销售登陆画面_新建按钮】");
		marketingRecordCreateDto.setCustomInfo(null);
		marketingRecordCreateDto.setPersonnelInfo(null);
		marketingRecordCreateDto.setAdviser(null);
		marketingRecordCreateDto.setDate(DateUtil.getNowyyyymmdd());
		marketingRecordCreateDto.setMoney(null);
		marketingRecordCreateDto.setState(false);
		marketingRecordCreateDto.setBalance(null);
		marketingRecordCreateDto.setReadyMoney(null);
		marketingRecordCreateDto.setSumReadyMoney(null);
		marketingRecordCreateDto.setSurplusMoney(null);
		marketingRecordCreateDto.setCustomLeaguerDetailList(null);
		marketingRecordCreateDto.setMarketingRecordDetailList(null);
		marketingRecordCreateDto.setProductStockList(null);
		marketingRecordCreateDto.setProductList(null);
		marketingRecordCreateDto.setBrand(null);
		marketingRecordCreateDto.setSeriesId(null);
		marketingRecordCreateDto.setSeriesItems(null);
		marketingRecordCreateDto.setProductStockName(null);
		marketingRecordCreateDto.setCreater(null);
		marketingRecordCreateDto.setBelongingUser(null);
		marketingRecordCreateDto.setTransferMarketingRecord(null);
		return Navigation.MARKETING_RECORD_CREATE;
	}
	
	/**
	 * 此方法绑定于产品销售登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【产品销售登陆画面_返回按钮】");
		return marketingRecordCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于产品销售登陆画面的保存按钮 
	 * 实现功能：根据transferMarketingRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveMarketingRecord() {
		Tool.sendLog(LOG, userBean, "【产品销售登陆画面_保存按钮】");
		MarketingRecord transferMarketingRecord = marketingRecordCreateDto.getTransferMarketingRecord();
		operate(transferMarketingRecord);
	}
	
	/**
	 * 此方法绑定于产品销售登陆画面的确认钮 
	 * 实现功能：根据transferMarketingRecord对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void queryMarketingRecord() {
		Tool.sendLog(LOG, userBean, "【产品销售登陆画面_确认按钮】");
		MarketingRecord transferMarketingRecord = marketingRecordCreateDto.getTransferMarketingRecord();
		marketingRecordCreateDto.setState(true);
		operate(transferMarketingRecord);
	}

	/**
	 * 进行保存或者更新操作
	 * @param transferMarketingRecord
	 */
	private void operate(MarketingRecord transferMarketingRecord) {
		List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
		if (marketingRecordDetailList == null || marketingRecordDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须设定活动项目！");
			return;
		}
		if (transferMarketingRecord == null) {
			transferMarketingRecord = new MarketingRecord();
			marketingRecordCreateDto.setCreater(userBean.getUser());
			marketingRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferMarketingRecord);
			transferMarketingRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			marketingRecordService.saveMarketingRecord(transferMarketingRecord, marketingRecordDetailList);
			marketingRecordCreateDto.setTransferMarketingRecord(transferMarketingRecord);
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
		List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
		for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
			marketingRecordDetail.setMarketingRecord(transferMarketingRecord);
			marketingRecordDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			marketingRecordDetail.setCreater(userBean.getUser());
			marketingRecordDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		}
		MarketingRecordCreateDxo.dtoToEntity(marketingRecordCreateDto, transferMarketingRecord);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		marketingRecordCreateDto.setReturner(returner);
		marketingRecordCreateDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		return Navigation.MARKETING_RECORD_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, MarketingRecord marketingRecord) {
		marketingRecordCreateDto.setReturner(returner);
		MarketingRecordCreateDxo.entityToDto(marketingRecord, marketingRecordCreateDto);
		marketingRecordCreateDto.setTransferMarketingRecord(marketingRecord);
		// 查询出产品销售详细
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingRecordDetail.class);
		detachedCriteria.createAlias(MarketingRecordDetail.MARKETING_RECORD, MarketingRecordDetail.MARKETING_RECORD, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK, MarketingRecordDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK_BRAND, MarketingRecordDetail.PRODUCT_STOCK_BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK_SERIES, MarketingRecordDetail.PRODUCT_STOCK_SERIES, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecordDetail.DEPOT_INFO, MarketingRecordDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MarketingRecordDetail.MARKETING_RECORD, marketingRecord));
		marketingRecordCreateDto.setMarketingRecordDetailList(marketingRecordDetailService.getByDetachedCriteria(detachedCriteria));
		return Navigation.MARKETING_RECORD_CREATE;
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, marketingRecordCreateDto.getCustomInfo()));
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.LEAGUER));
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.LEAGUER));
		marketingRecordCreateDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
	}
	
	/**
	 * 用于选中品牌时获取到相对应的系列
	 */
	public void selectSeriesItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Series.class);
		detachedCriteria.createAlias(Series.BRAND, Series.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Series.BRAND, marketingRecordCreateDto.getBrand()));
		List<Series> seriesList = seriesService.getByDetachedCriteria(detachedCriteria);
		if (!seriesList.isEmpty()) {
			int size = seriesList.size();
			SelectItem[] seriesItems = new SelectItem[size + 1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			for (int i = 0; i < size; i++) {
				Series series = seriesList.get(i);
				seriesItems[i+1] = new SelectItem(series.getId().toString(), series.getName());
			}
			marketingRecordCreateDto.setSeriesItems(seriesItems);
		} else {
			SelectItem[] seriesItems = new SelectItem[1];
			seriesItems[0] = Constants.UN_SELECT_ITEM;
			marketingRecordCreateDto.setSeriesItems(seriesItems);
		}
		
	}
	
	/**
	 * 选择卡项后计算出的总金额
	 */
	public void getSumMoney() {
		List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
		BigDecimal sum = Constants.BIGDECIMAL_ZERO;
		for (MarketingRecordDetail MarketingRecordDetail : marketingRecordDetailList) {
			sum = BigDecimalUtil.add(sum, MarketingRecordDetail.getSumMoney());
		}
		marketingRecordCreateDto.setMoney(sum);
	}
	
	/**
	 * 此方法绑定于产品销售登陆画面的删除按钮 
	 * @return 画面不跳转
	 */
	public void deleteMarketingRecord(MarketingRecordDetail marketingRecordDetail) {
		Tool.sendLog(LOG, userBean, "【产品销售登陆画面_删除按钮】");
		if (marketingRecordDetail.getId() != null) {
			marketingRecordDetailService.deleteEntity(marketingRecordDetail);
		}
		marketingRecordCreateDto.getMarketingRecordDetailList().remove(marketingRecordDetail);
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 此方法绑定于产品销售登陆画面的选择产品按钮 
	 * @return 画面不跳转
	 */
	public void findProductStock() {
		Tool.sendLog(LOG, userBean, "按下【产品销售登陆画面_选择产品按钮】");
		marketingRecordCreateDto.setBrand(null);
		marketingRecordCreateDto.setSeriesId(null);
		marketingRecordCreateDto.setProductStockName(null);
		select();
	}

	/**
	 * 此方法绑定于产品销售登陆画面的搜索按钮 
	 * @return 画面不跳转
	 */
	public void selectProductStock() {
		Tool.sendLog(LOG, userBean, "按下【产品销售登陆画面_搜索按钮】");
		select();
	}
	
	private void select() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		detachedCriteria.createAlias(ProductStock.BRAND, ProductStock.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductStock.SERIES, ProductStock.SERIES, JoinType.LEFT_OUTER_JOIN);
		Brand brand = marketingRecordCreateDto.getBrand();
		String seriesId = marketingRecordCreateDto.getSeriesId();
		String productStockName = marketingRecordCreateDto.getProductStockName();
		List<ProductStock> productList = marketingRecordCreateDto.getProductList();
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
		marketingRecordCreateDto.setProductStockList(productStockService.getByDetachedCriteria(detachedCriteria, 0, 20));
	}
	
	/**
	 * 此方法绑定于产品销售登陆画面的选择按钮 
	 * @return 画面不跳转
	 */
	public void findProductStocks(ProductStock productStock) {
		Tool.sendLog(LOG, userBean, "按下【产品销售登陆画面_选择按钮】");
		List<ProductStock> productList = marketingRecordCreateDto.getProductList();
		if (productList == null) {
			productList = new ArrayList<ProductStock>();
			marketingRecordCreateDto.setProductList(productList);
		}
		productList.add(productStock);
		marketingRecordCreateDto.getProductStockList().remove(productStock);
	}
	
	/**
	 * 此方法绑定于产品销售登陆画面的确认并结束选择按钮 
	 * @return 画面不跳转
	 */
	public void queryCloce() {
		Tool.sendLog(LOG, userBean, "按下【产品销售登陆画面_确认并结束选择按钮】");
		List<ProductStock> productList = marketingRecordCreateDto.getProductList();
		if (productList != null && !productList.isEmpty()) {
			List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
			if (marketingRecordDetailList == null) {
				marketingRecordDetailList = new ArrayList<MarketingRecordDetail>();
				marketingRecordCreateDto.setMarketingRecordDetailList(marketingRecordDetailList);
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
			getSumMoney();
		}
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_选择付款按钮】");
		BigDecimal money = marketingRecordCreateDto.getCustomInfo().getMoney();
		if (BigDecimalUtil.bigThan(money, marketingRecordCreateDto.getMoney())) {
			marketingRecordCreateDto.setBalance(marketingRecordCreateDto.getMoney());
		} else {
			marketingRecordCreateDto.setBalance(money);
		}
		marketingRecordCreateDto.setLeaguerReadyMoney(null);
		marketingRecordCreateDto.setSumReadyMoney(null);
		getSurplusMoney();
		// 获取下拉框
		List<CustomLeaguerDetail> customLeaguerDetailList = marketingRecordCreateDto.getCustomLeaguerDetailList();
		
		if (customLeaguerDetailList != null && !customLeaguerDetailList.isEmpty()) {
			int size = customLeaguerDetailList.size();
			SelectItem[] customLeaguerDetailItems = new SelectItem[size];
			for (int i = 0; i < size; i++) {
				CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailList.get(i);
				String name = "";
				if (customLeaguerDetail.getLeaguer() != null) {
					name = customLeaguerDetail.getLeaguer().getLabel() + "-折扣：" + customLeaguerDetail.getRebate().toString() + "   卡余额：" + customLeaguerDetail.getMoney() + "￥";
				} else {
					name = customLeaguerDetail.getGiveInfo().getLabel() + "-折扣：" + (customLeaguerDetail.getRebate() == null ? "10.0" : customLeaguerDetail.getRebate().toEngineeringString()) + "   卡余额：" + customLeaguerDetail.getMoney() + "￥";
				}
				customLeaguerDetailItems[i] = new SelectItem(customLeaguerDetail.getId().toString(), name);
			}
			CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailList.get(0);
			marketingRecordCreateDto.setLeaguerMoney(customLeaguerDetail.getMoney());
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
			for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
				productStockList.add(marketingRecordDetail.getProductStock());
			}
			
			BigDecimal rebate = customLeaguerDetail.getRebate();
			if (BigDecimalUtil.isNullOrZero(rebate)) {
				rebate = new BigDecimal("10.0");
			}
			BigDecimal rebateMoney = Constants.BIGDECIMAL_ZERO;
			if (customLeaguerDetail.getLeaguer() != null && !productStockList.isEmpty()) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LeaguerDetail.class);
				detachedCriteria.createAlias(LeaguerDetail.PRODUCT_STOCK, LeaguerDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.eq(LeaguerDetail.LEAGUER, customLeaguerDetail.getLeaguer()));
				detachedCriteria.add(Restrictions.in(LeaguerDetail.PRODUCT_STOCK, productStockList));
				List<LeaguerDetail> leaguerDetailList = leaguerDetailService.getByDetachedCriteria(detachedCriteria);
				for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
					for (LeaguerDetail leaguerDetail : leaguerDetailList) {
						BigDecimal rebate2 = leaguerDetail.getRebate();
						if (marketingRecordDetail.getProductStock().equals(leaguerDetail.getProductStock())) {
							if (BigDecimalUtil.isNullOrZero(rebate2)) {
								rebate2 = rebate;
							}
							marketingRecordDetail.setRebate(rebate2);
							break;
						}
					}
					// 没有设定过，就取卡项折扣
					BigDecimal rebate2 = marketingRecordDetail.getRebate();
					if (BigDecimalUtil.isNullOrZero(rebate2)) {
						marketingRecordDetail.setRebate(customLeaguerDetail.getLeaguer().getRebate());
					}
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(marketingRecordDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), marketingRecordDetail.getSumMoney()));
				}
			} else {
				for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
					marketingRecordDetail.setRebate(rebate);
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(marketingRecordDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), marketingRecordDetail.getSumMoney()));
				}
			}
			marketingRecordCreateDto.setRebate(rebate);
			marketingRecordCreateDto.setCustomLeaguerDetailId(customLeaguerDetail.getId().toString());
			marketingRecordCreateDto.setCustomLeaguerDetailItems(customLeaguerDetailItems);
			// 计算折后金额
			marketingRecordCreateDto.setRebateMoney(rebateMoney);
			marketingRecordCreateDto.setSurplusMoney(marketingRecordCreateDto.getRebateMoney());
		}
	}
	
	/**
	 * 此方法绑定于服务消费登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【服务消费登陆画面_确认付款按钮】");
		List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
		if (marketingRecordDetailList == null || marketingRecordDetailList.isEmpty()) {
			Tool.sendErrorMessage("必须选择产品或者疗程明细列表");
			return;
		}
		// 验证付款金额是否超出了需要支付的金额
		if (BigDecimalUtil.bigThan(marketingRecordCreateDto.getSumReadyMoney(), marketingRecordCreateDto.getMoney())) {
			Tool.sendErrorMessage("多付钱了，请确认！");
			return;
		}
		marketingRecordCreateDto.setCreater(userBean.getUser());
		marketingRecordCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		marketingRecordCreateDto.setState(true);
		MarketingRecord marketingRecord = new MarketingRecord();
		create(marketingRecord);
		CustomLeaguerDetail customLeaguerDetail = null;
		if (StringUtil.isNotBlank(marketingRecordCreateDto.getCustomLeaguerDetailId())) {
			customLeaguerDetail = customLeaguerDetailService.getById(Integer.valueOf(marketingRecordCreateDto.getCustomLeaguerDetailId()));
			customLeaguerDetail.setReadyMoney(marketingRecordCreateDto.getLeaguerReadyMoney());
		}
		
		BigDecimal rebateMoney = marketingRecordCreateDto.getRebateMoney();
		if (rebateMoney == null) rebateMoney = marketingRecordCreateDto.getMoney();
		
		marketingRecordService.savePay(marketingRecord, rebateMoney, marketingRecordCreateDto.getBalance(), marketingRecordCreateDto.getReadyMoney(), customLeaguerDetail, marketingRecordCreateDto.getMarketingRecordDetailList());
		newMarketingRecord();
		Tool.sendErrorMessage("付款成功！");
	}
	
	/**
	 * 获取付款后，计算出还需要付款的金额
	 */
	public void getSurplusMoney() {
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		// 获取充值卡付款记录
		if (BigDecimalUtil.isNotNullOrZero(marketingRecordCreateDto.getBalance())) {
			sumMoney = BigDecimalUtil.add(sumMoney, marketingRecordCreateDto.getBalance());
		}
		// 获取现金付款记录
		if (BigDecimalUtil.isNotNullOrZero(marketingRecordCreateDto.getReadyMoney())) {
			sumMoney = BigDecimalUtil.add(sumMoney, marketingRecordCreateDto.getReadyMoney());
		}
		// 获取充值卡付款记录
		BigDecimal leaguerReadyMoney = marketingRecordCreateDto.getLeaguerReadyMoney();
		if (BigDecimalUtil.isNotNullOrZero(leaguerReadyMoney)) {
			sumMoney = BigDecimalUtil.add(sumMoney, leaguerReadyMoney);
		}
		// 总金额-已经付款的金额=还需要支付的金额
		marketingRecordCreateDto.setSumReadyMoney(sumMoney);
		BigDecimal rebateMoney = marketingRecordCreateDto.getRebateMoney();
		if (rebateMoney == null) rebateMoney = marketingRecordCreateDto.getMoney();
		marketingRecordCreateDto.setSurplusMoney(BigDecimalUtil.subtract(rebateMoney, sumMoney));
	}
	
	/**
	 * 选择后付款的卡项后，获取到卡项的最大输入额度
	 */
	public void getLeaguerMoney() {
		String customLeaguerDetailId = marketingRecordCreateDto.getCustomLeaguerDetailId();
		if (!StringUtil.isUnSelected(customLeaguerDetailId)) {
			CustomLeaguerDetail customLeaguerDetail = customLeaguerDetailService.getById(Integer.valueOf(customLeaguerDetailId));
			
			
			// 获取卡项折扣
			BigDecimal rebate = customLeaguerDetail.getRebate();
			if (BigDecimalUtil.isNullOrZero(rebate)) {
				rebate = new BigDecimal("10.0");
			}
			BigDecimal rebateMoney = Constants.BIGDECIMAL_ZERO;
			
			List<MarketingRecordDetail> marketingRecordDetailList = marketingRecordCreateDto.getMarketingRecordDetailList();
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
				productStockList.add(marketingRecordDetail.getProductStock());
			}
			
			if (customLeaguerDetail.getLeaguer() != null && !productStockList.isEmpty()) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LeaguerDetail.class);
				detachedCriteria.createAlias(LeaguerDetail.PRODUCT_STOCK, LeaguerDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.eq(LeaguerDetail.LEAGUER, customLeaguerDetail.getLeaguer()));
				detachedCriteria.add(Restrictions.in(LeaguerDetail.PRODUCT_STOCK, productStockList));
				List<LeaguerDetail> leaguerDetailList = leaguerDetailService.getByDetachedCriteria(detachedCriteria);
				for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
					for (LeaguerDetail leaguerDetail : leaguerDetailList) {
						if (marketingRecordDetail.getProductStock().equals(leaguerDetail.getProductStock())) {
							BigDecimal rebate2 = leaguerDetail.getRebate();
							if (BigDecimalUtil.isNullOrZero(rebate2)) {
								rebate2 = rebate;
							}
							marketingRecordDetail.setRebate(rebate2);
							break;
						}
					}
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(marketingRecordDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), marketingRecordDetail.getSumMoney()));
				}
			} else {
				for (MarketingRecordDetail marketingRecordDetail : marketingRecordDetailList) {
					marketingRecordDetail.setRebate(rebate);
					rebateMoney = BigDecimalUtil.add(rebateMoney, BigDecimalUtil.multiply(BigDecimalUtil.divide(marketingRecordDetail.getRebate(), new BigDecimal("10"), 2, BigDecimal.ROUND_HALF_UP), marketingRecordDetail.getSumMoney()));
				}
			}
			
			marketingRecordCreateDto.setRebate(rebate);
			marketingRecordCreateDto.setLeaguerMoney(customLeaguerDetail.getMoney());
			// 计算折后金额
			marketingRecordCreateDto.setRebateMoney(rebateMoney);
			marketingRecordCreateDto.setSurplusMoney(marketingRecordCreateDto.getRebateMoney());
		}
	}
	
	/**
	 * @param leaguerDetailService the leaguerDetailService to set
	 */
	public void setLeaguerDetailService(LeaguerDetailService leaguerDetailService) {
		this.leaguerDetailService = leaguerDetailService;
	}

	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
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
	 * get marketingRecordCreateDto
	 * @return the marketingRecordCreateDto
	 */
	public MarketingRecordCreateDto getMarketingRecordCreateDto() {
		return marketingRecordCreateDto;
	}

	/**
	 * set marketingRecordCreateDto
	 * @param marketingRecordCreateDto the marketingRecordCreateDto to set
	 */
	public void setMarketingRecordCreateDto(MarketingRecordCreateDto marketingRecordCreateDto) {
		this.marketingRecordCreateDto = marketingRecordCreateDto;
	}

}
