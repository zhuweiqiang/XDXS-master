package com.qylm.dto.custom;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存疗程转换记录管理画面需要的值
 * @author smj
 */
public class ConversionTreatmentManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4475174495758625933L;

	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 转换日期（开始）
	 */
	private Date beginDate;
	
	/**
	 * 转换日期（结束）
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
