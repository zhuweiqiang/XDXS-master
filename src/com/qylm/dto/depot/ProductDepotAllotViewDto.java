package com.qylm.dto.depot;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qylm.entity.DepotInfo;
import com.qylm.entity.ProductStockDetail;
import com.qylm.entity.User;

/**
 * 保存仓库库存调拨管理画面需要的值
 * @author smj
 */
public class ProductDepotAllotViewDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 840699886830571538L;

	/**
	 * 原仓库
	 */
	private DepotInfo depotInfo;

	/**
	 * 产品库存详细
	 */
	private ProductStockDetail productStockDetail;
	
	/**
	 * 调往库存
	 */
	private DepotInfo allotDepotInfo;
	
	/**
	 * 调往产品库存详细
	 */
	private ProductStockDetail allotProductStockDetail;
	
	/**
	 * 调拨数量
	 */
	private BigDecimal number;
	
	/**
	 * 确认生效
	 * true:生效
	 * false：无效
	 */
	private boolean state;
	
	/**
	 * 创建事件
	 */
	private User creater;

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
	 * @return the productStockDetail
	 */
	public ProductStockDetail getProductStockDetail() {
		return productStockDetail;
	}

	/**
	 * @param productStockDetail the productStockDetail to set
	 */
	public void setProductStockDetail(ProductStockDetail productStockDetail) {
		this.productStockDetail = productStockDetail;
	}

	/**
	 * @return the allotDepotInfo
	 */
	public DepotInfo getAllotDepotInfo() {
		return allotDepotInfo;
	}

	/**
	 * @param allotDepotInfo the allotDepotInfo to set
	 */
	public void setAllotDepotInfo(DepotInfo allotDepotInfo) {
		this.allotDepotInfo = allotDepotInfo;
	}

	/**
	 * @return the allotProductStockDetail
	 */
	public ProductStockDetail getAllotProductStockDetail() {
		return allotProductStockDetail;
	}

	/**
	 * @param allotProductStockDetail the allotProductStockDetail to set
	 */
	public void setAllotProductStockDetail(
			ProductStockDetail allotProductStockDetail) {
		this.allotProductStockDetail = allotProductStockDetail;
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
	
}
