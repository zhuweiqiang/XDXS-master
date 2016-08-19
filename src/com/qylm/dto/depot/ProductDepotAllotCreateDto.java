package com.qylm.dto.depot;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.ProductDepotAllot;
import com.qylm.entity.ProductStockDetail;
import com.qylm.entity.User;

/**
 * 保存仓库库存调拨管理画面需要的值
 * @author smj
 */
public class ProductDepotAllotCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3141428502945749387L;

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
	 * 产品库存详细列表
	 */
	private List<ProductStockDetail> productStockDetailList;
	
	/**
	 * 产品名称
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
	private ProductDepotAllot transferProductDepotAllot;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

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
	 * @return the transferProductDepotAllot
	 */
	public ProductDepotAllot getTransferProductDepotAllot() {
		return transferProductDepotAllot;
	}

	/**
	 * @param transferProductDepotAllot the transferProductDepotAllot to set
	 */
	public void setTransferProductDepotAllot(
			ProductDepotAllot transferProductDepotAllot) {
		this.transferProductDepotAllot = transferProductDepotAllot;
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
