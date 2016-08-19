package com.qylm.dto.history;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.Brand;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.ProductStock;
import com.qylm.entity.User;

/**
 * 保存客户产品记录记录管理画面需要的值
 * @author smj
 */
public class HistoryMarketingRecordCreateDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1789951113612597759L;

	/**
	 * 客户档案
	 */
	private CustomInfo customInfo;
	
	/**
	 * 美容师
	 */
	private PersonnelInfo personnelInfo;
	
	/**
	 * 人事信息-顾问
	 */
	private PersonnelInfo adviser;
	
	/**
	 * 购买日期
	 */
	private Date date;
	
	/**
	 * 产品费用
	 */
	private BigDecimal money;
	
	/**
	 * 状态：true生效扣除库存，反之无效
	 */
	private boolean state;
	
	/**
	 * 客户产品记录记录详细列表
	 */
	private List<MarketingRecordDetail> marketingRecordDetailList;
	
	/**
	 * 产品库存详细列表
	 */
	private List<ProductStock> productStockList;
	
	/**
	 * 选中的产品库存详细列表
	 */
	private List<ProductStock> productList;
	
	/**
	 * 品牌
	 */
	private Brand brand;

	/**
	 * 系列id
	 */
	private String seriesId;
	
	/**
	 * 系列
	 */
	private SelectItem[] seriesItems;
	
	/**
	 * 搜索条件：产品名称
	 */
	private String productStockName;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 修改传值
	 */
	private MarketingRecord transferMarketingRecord;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * @return the customInfo
	 */
	public CustomInfo getCustomInfo() {
		return customInfo;
	}

	/**
	 * @param customInfo the customInfo to set
	 */
	public void setCustomInfo(CustomInfo customInfo) {
		this.customInfo = customInfo;
	}

	/**
	 * @return the personnelInfo
	 */
	public PersonnelInfo getPersonnelInfo() {
		return personnelInfo;
	}

	/**
	 * @param personnelInfo the personnelInfo to set
	 */
	public void setPersonnelInfo(PersonnelInfo personnelInfo) {
		this.personnelInfo = personnelInfo;
	}

	/**
	 * @return the adviser
	 */
	public PersonnelInfo getAdviser() {
		return adviser;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setAdviser(PersonnelInfo adviser) {
		this.adviser = adviser;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the money
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the marketingRecordDetailList
	 */
	public List<MarketingRecordDetail> getMarketingRecordDetailList() {
		return marketingRecordDetailList;
	}

	/**
	 * @param marketingRecordDetailList the marketingRecordDetailList to set
	 */
	public void setMarketingRecordDetailList(
			List<MarketingRecordDetail> marketingRecordDetailList) {
		this.marketingRecordDetailList = marketingRecordDetailList;
	}

	/**
	 * @return the productStockList
	 */
	public List<ProductStock> getProductStockList() {
		return productStockList;
	}

	/**
	 * @param productStockList the productStockList to set
	 */
	public void setProductStockList(List<ProductStock> productStockList) {
		this.productStockList = productStockList;
	}

	/**
	 * @return the productList
	 */
	public List<ProductStock> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<ProductStock> productList) {
		this.productList = productList;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the seriesId
	 */
	public String getSeriesId() {
		return seriesId;
	}

	/**
	 * @param seriesId the seriesId to set
	 */
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * @return the seriesItems
	 */
	public SelectItem[] getSeriesItems() {
		return seriesItems;
	}

	/**
	 * @param seriesItems the seriesItems to set
	 */
	public void setSeriesItems(SelectItem[] seriesItems) {
		this.seriesItems = seriesItems;
	}

	/**
	 * @return the productStockName
	 */
	public String getProductStockName() {
		return productStockName;
	}

	/**
	 * @param productStockName the productStockName to set
	 */
	public void setProductStockName(String productStockName) {
		this.productStockName = productStockName;
	}

	/**
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}

	/**
	 * @param creater the creater to set
	 */
	public void setCreater(User creater) {
		this.creater = creater;
	}

	/**
	 * @return the belongingUser
	 */
	public User getBelongingUser() {
		return belongingUser;
	}

	/**
	 * @param belongingUser the belongingUser to set
	 */
	public void setBelongingUser(User belongingUser) {
		this.belongingUser = belongingUser;
	}

	/**
	 * @return the transferMarketingRecord
	 */
	public MarketingRecord getTransferMarketingRecord() {
		return transferMarketingRecord;
	}

	/**
	 * @param transferMarketingRecord the transferMarketingRecord to set
	 */
	public void setTransferMarketingRecord(MarketingRecord transferMarketingRecord) {
		this.transferMarketingRecord = transferMarketingRecord;
	}

	/**
	 * @return the returner
	 */
	public Returner<?, ?, ?> getReturner() {
		return returner;
	}

	/**
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, ?> returner) {
		this.returner = returner;
	}

}
