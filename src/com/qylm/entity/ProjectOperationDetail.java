package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 项目操作记录详细持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "projectoperation_detail")
public class ProjectOperationDetail extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7879276732486608791L;

	/**
	 * 查询条件：项目赠送记录
	 */
	public static final String PROJECT_OPERATION = "projectOperation";

	/**
	 * 检索条件：服务管理
	 */
	public static final String MARKETING_PROJECT = "marketingProject";
	
	/**
	 * 项目赠送记录
	 */
	@ManyToOne(targetEntity = ProjectOperation.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "projectOperationId")
	private ProjectOperation projectOperation;
	
	/**
	 * 服务管理
	 */
	@ManyToOne(targetEntity = MarketingProject.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "marketingProjectId")
	private MarketingProject marketingProject;
	
	/**
	 * 次数
	 */
	private Integer number;

	/**
	 * @return the projectOperation
	 */
	public ProjectOperation getProjectOperation() {
		return projectOperation;
	}

	/**
	 * @param projectOperation the projectOperation to set
	 */
	public void setProjectOperation(ProjectOperation projectOperation) {
		this.projectOperation = projectOperation;
	}

	/**
	 * @return the marketingProject
	 */
	public MarketingProject getMarketingProject() {
		return marketingProject;
	}

	/**
	 * @param marketingProject the marketingProject to set
	 */
	public void setMarketingProject(MarketingProject marketingProject) {
		this.marketingProject = marketingProject;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
