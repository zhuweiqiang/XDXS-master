package com.qylm.dto.history;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存客户产品记录记录管理画面需要的值
 * @author smj
 */
public class HistoryMarketingRecordManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3842778290739256343L;

	/**
	 * 客户姓名
	 */
	private String name;
	
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
