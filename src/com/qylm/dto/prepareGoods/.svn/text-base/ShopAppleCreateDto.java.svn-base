package com.qylm.dto.prepareGoods;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.ProductStock;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.entity.User;

/**
 * 保存店铺申请配货管理画面需要的值
 * @author smj
 */
public class ShopAppleCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4776162263357340136L;

	/**
	 * 编号
	 */
	private String number;
	
	/**
	 * 仓库
	 */
	private DepotInfo depotInfo;
	
	/**
	 * 申请日期
	 */
	private Date appleDate;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 申请状态
	 * 1：未申请
	 * 2：申请中
	 * 3：申请通过
	 * 4：申请未通过
	 * 5：完结入库
	 */
	private String appleState;
	
	/**
	 * 入库人
	 */
	private User user;
	
	/**
	 * 店铺申请配货详细列表
	 */
	private List<ShopAppleDetail> shopAppleDetailList;
	
	/**
	 * 产品库存详细列表
	 */
	private List<ProductStock> productStockList;
	
	/**
	 * 选中的产品库存详细列表
	 */
	private List<ProductStock> productList;
	
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
	private ShopApple transferShopApple;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
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
	 * @return the appleDate
	 */
	public Date getAppleDate() {
		return appleDate;
	}

	/**
	 * @param appleDate the appleDate to set
	 */
	public void setAppleDate(Date appleDate) {
		this.appleDate = appleDate;
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
	 * @return the appleState
	 */
	public String getAppleState() {
		return appleState;
	}

	/**
	 * @param appleState the appleState to set
	 */
	public void setAppleState(String appleState) {
		this.appleState = appleState;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the shopAppleDetailList
	 */
	public List<ShopAppleDetail> getShopAppleDetailList() {
		return shopAppleDetailList;
	}

	/**
	 * @param shopAppleDetailList the shopAppleDetailList to set
	 */
	public void setShopAppleDetailList(List<ShopAppleDetail> shopAppleDetailList) {
		this.shopAppleDetailList = shopAppleDetailList;
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
	 * @return the transferShopApple
	 */
	public ShopApple getTransferShopApple() {
		return transferShopApple;
	}

	/**
	 * @param transferShopApple the transferShopApple to set
	 */
	public void setTransferShopApple(ShopApple transferShopApple) {
		this.transferShopApple = transferShopApple;
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
