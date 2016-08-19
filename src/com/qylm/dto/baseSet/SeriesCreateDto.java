package com.qylm.dto.baseSet;

import java.io.Serializable;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.Brand;
import com.qylm.entity.Series;
import com.qylm.entity.User;

/**
 * 保存系类管理画面需要的值
 * @author smj
 */
public class SeriesCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7645525670392281400L;

	/**
	 * 品牌
	 */
	private Brand brand;

	/**
	 * 系类名称
	 */
	private String name;
	
	/**
	 * 备注
	 */
	private String remark;
	
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
	private Series transferSeries;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

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
	 * @return the transferSeries
	 */
	public Series getTransferSeries() {
		return transferSeries;
	}

	/**
	 * @param transferSeries the transferSeries to set
	 */
	public void setTransferSeries(Series transferSeries) {
		this.transferSeries = transferSeries;
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
