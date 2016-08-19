package com.qylm.dto.custom;

import java.io.Serializable;
import java.util.Date;

import com.qylm.bean.returner.Returner;

/**
 * 保存项目购买查询画面需要的值
 * @author smj
 */
public class ProjectBuyDetailSelectDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 915777113500390663L;

	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 疗程名称
	 */
	private String projectName;
	
	/**
	 * 购买时间（开始）
	 */
	private Date beginDate;
	
	/**
	 * 购买时间（结束）
	 */
	private Date endDate;
	
	/**
	 * 返回方法
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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
