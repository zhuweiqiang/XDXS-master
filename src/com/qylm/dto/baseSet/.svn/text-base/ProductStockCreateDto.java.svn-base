package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.Brand;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.FileControl;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ProductStockDetail;
import com.qylm.entity.Series;
import com.qylm.entity.User;

/**
 * 保存产品库存管理画面需要的值
 * @author smj
 */
public class ProductStockCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5749748083361186246L;

	/**
	 * 产品名称
	 */
	private String name;
	
	/**
	 * 产品介绍
	 */
	private String introduce;
	
	/**
	 * 产品价格
	 */
	private BigDecimal money;
	
	/**
	 * 产品成本
	 */
	private BigDecimal cost;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 系列id
	 */
	private String seriesId;
	
	/**
	 * 系列
	 */
	private SelectItem[] seriesItems;
	
	/**
	 * 品牌
	 */
	private Brand brand;

	/**
	 * 系列
	 */
	private Series series;
	
	/**
	 * 单位
	 */
	private String unit;
	
	/**
	 * 产品库存详细列表
	 */
	private List<ProductStockDetail> productStockDetailList;
	
	/**
	 * 仓库（产品库存详细）
	 */
	private DepotInfo depotInfo;

	/**
	 * 数量（产品库存详细）
	 */
	private BigDecimal number;
	
	/**
	 * 文件
	 */
	private List<FileControl> fileControlList;
	
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
	private ProductStock transferProductStock;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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
	 * @return the cost
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the series
	 */
	public Series getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(Series series) {
		this.series = series;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the productStockDetailList
	 */
	public List<ProductStockDetail> getProductStockDetailList() {
		return productStockDetailList;
	}

	/**
	 * @param productStockDetailList the productStockDetailList to set
	 */
	public void setProductStockDetailList(
			List<ProductStockDetail> productStockDetailList) {
		this.productStockDetailList = productStockDetailList;
	}

	/**
	 * @return the depotInfo
	 */
	public DepotInfo getDepotInfo() {
		return depotInfo;
	}

	/**
	 * @param depotInfo the depotInfo to set
	 */
	public void setDepotInfo(DepotInfo depotInfo) {
		this.depotInfo = depotInfo;
	}

	/**
	 * @return the number
	 */
	public BigDecimal getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	/**
	 * @return the fileControlList
	 */
	public List<FileControl> getFileControlList() {
		return fileControlList;
	}

	/**
	 * @param fileControlList the fileControlList to set
	 */
	public void setFileControlList(List<FileControl> fileControlList) {
		this.fileControlList = fileControlList;
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
	 * @return the transferProductStock
	 */
	public ProductStock getTransferProductStock() {
		return transferProductStock;
	}

	/**
	 * @param transferProductStock the transferProductStock to set
	 */
	public void setTransferProductStock(ProductStock transferProductStock) {
		this.transferProductStock = transferProductStock;
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
