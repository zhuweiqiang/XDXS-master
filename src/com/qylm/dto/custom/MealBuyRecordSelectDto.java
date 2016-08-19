package com.qylm.dto.custom;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存套餐购买记录查询画面需要的值
 * @author smj
 */
public class MealBuyRecordSelectDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7932770694125015659L;

	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 套餐名称
	 */
	private String temporaryActivityName;
	
	/**
	 * 购买时间（开始）
	 */
	private Date beginDate;
	
	/**
	 * 购买时间（结束）
	 */
	private Date endDate;

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
	 * @return the temporaryActivityName
	 */
	public String getTemporaryActivityName() {
		return temporaryActivityName;
	}

	/**
	 * @param temporaryActivityName the temporaryActivityName to set
	 */
	public void setTemporaryActivityName(String temporaryActivityName) {
		this.temporaryActivityName = temporaryActivityName;
	}

	/**
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
