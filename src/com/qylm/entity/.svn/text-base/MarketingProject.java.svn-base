package com.qylm.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 服务管理持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "marketingproject")
public class MarketingProject extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -613767052862853746L;
	
	/**
	 * 检索条件：项目
	 */
	public static final String PROJECT = "project";

	/**
	 * 项目
	 */
	private String project;
	
	/**
	 * 项目类型
	 * 1：面部资料
	 * 2：身体资料
	 */
	private String type;

	/**
	 * 费用
	 */
	private BigDecimal money;
	
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 有效状态
	 * true：有效
	 * false：反之无效
	 */
	private boolean state;

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

}
