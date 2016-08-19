package com.qylm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 项目操作记录持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "projectoperation")
public class ProjectOperation extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7824028818898181807L;

	/**
	 * 查询条件：客户档案
	 */
	public static final String CUSTOMINFO = "customInfo";

	/**
	 * 查询条件：客户档案.客户姓名
	 */
	public static final String CUSTOMINFO_NAME = "customInfo.name";
	
	/**
	 * 查询条件：客户档案.卡项号
	 */
	public static final String CUSTOMINFO_LEAGUER_NUMBER = "customInfo.leaguerNumber";
	
	/**
	 * 查询条件：客户档案.卡项级别
	 */
	public static final String CUSTOMINFO_LEAGUER = "customInfo.leaguer";
	
	/**
	 * 查询条件：操作时间
	 */
	public static final String DATE = "date";
	
	/**
	 * 查询条件：美容师
	 */
	public static final String PERSONNEL_INFO = "personnelInfo";
	
	/**
	 * 客户档案
	 */
	@ManyToOne(targetEntity = CustomInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "customInfoId")
	private CustomInfo customInfo;
	
	/**
	 * 操作时间
	 */
	private Date date;
	
	/**
	 * 美容师
	 */
	@ManyToOne(targetEntity = PersonnelInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "personnelInfoId")
	private PersonnelInfo personnelInfo;
	
	/**
	 * 操作项目详细列表
	 */
	@Transient
	private List<ProjectOperationDetail> projectOperationDetailList;

	/**
	 * @return the customInfo
	 */
	public CustomInfo getCustomInfo() {
		return customInfo;
	}

	/**
	 * @param customInfo the customInfo to set
	 */
	public void setCustomInfo(CustomInfo customInfo) {
		this.customInfo = customInfo;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the personnelInfo
	 */
	public PersonnelInfo getPersonnelInfo() {
		return personnelInfo;
	}

	/**
	 * @param personnelInfo the personnelInfo to set
	 */
	public void setPersonnelInfo(PersonnelInfo personnelInfo) {
		this.personnelInfo = personnelInfo;
	}

	/**
	 * @return the projectOperationDetailList
	 */
	public List<ProjectOperationDetail> getProjectOperationDetailList() {
		return projectOperationDetailList;
	}

	/**
	 * @param projectOperationDetailList the projectOperationDetailList to set
	 */
	public void setProjectOperationDetailList(
			List<ProjectOperationDetail> projectOperationDetailList) {
		this.projectOperationDetailList = projectOperationDetailList;
	}
	
}
