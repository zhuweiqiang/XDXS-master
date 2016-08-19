package com.qylm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *  人事信息管理持久化类
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "personnelinfo")
public class PersonnelInfo extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6794455450562199952L;

	/**
	 * 检索条件：工号
	 */
	public static final String WORK_NUMBER = "workNumber";
	
	/**
	 * 检索条件：姓名
	 */
	public static final String NAME = "name";
	
	/**
	 * 检索条件：身份证号
	 */
	public static final String IDENTIFICATION = "identification";
	
	/**
	 * 检索条件：在职状态
	 */
	public static final String WORK_STATE = "workState";
	
	/**
	 * 检索条件：在职状态:在职
	 */
	public static final String WORK_STATE_1 = "1";
	
	/**
	 * 检索条件：在职状态：离职
	 */
	public static final String WORK_STATE_2 = "2";
	
	/**
	 * 检索条件：人员类型
	 */
	public static final String TYPE = "type";
	
	/**
	 * 检索条件：人员类型:美容师
	 */
	public static final String TYPE_1 = "1";
	
	/**
	 * 检索条件：人员类型：顾问
	 */
	public static final String TYPE_2 = "2";
	
	/**
	 * 检索条件：人员类型：店长
	 */
	public static final String TYPE_3 = "3";
	
	/**
	 * 检索条件：人员类型：前台
	 */
	public static final String TYPE_4 = "4";
	
	/**
	 * 检索条件：人员类型：学徒
	 */
	public static final String TYPE_5 = "5";

	/**
	 * 工号
	 */
	private String workNumber;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 在职状态
	 * <ul>
	 * <li>1:在职</li>
	 * <li>2:离职</li>
	 * </ul>
	 */
	private String workState;
	
	/**
	 * 性别
	 * <ul>
	 * <li>1：男</li>
	 * <li>2：女</li>
	 * </ul>
	 */
	private String sex;
	
	/**
	 * 出生日期
	 */
	private Date birthDate;
	
	/**
	 * 政治面貌
	 * <ul>
	 * <li>1：青年</li>
	 * <li>2：团员</li>
	 * <li>3：党员</li>
	 * </ul>
	 */
	private String politicalStatus;
	
	/**
	 * 民族
	 * <ul>
	 * <li>56个名族</li>
	 * </ul>
	 */
	private String nation;
	
	/**
	 * 婚否
	 * <ul>
	 * <li>1：已婚</li>
	 * <li>2：未婚</li>
	 * <li>3：离异</li>
	 * </ul>
	 */
	private String marriage;
	
	/**
	 * 身份证
	 */
	private String identification;
	
	/**
	 * 学历
	 * <ul>
	 * <li>1：小学</li>
	 * <li>2：初中</li>
	 * <li>3：高中</li>
	 * <li>4：大专</li>
	 * <li>5：本科</li>
	 * <li>6：研究生</li>
	 * <li>7：博士</li>
	 * </ul>
	 */
	private String formalSchooling;
	
	/**
	 * 人员信息类型
	 * 1：美容师
	 * 2：顾问
	 * 3：店长
	 * 4：前台
	 * 5：学徒
	 */
	private String type;
	
	/**
	 * 移动电话
	 */
	private String mobile;

	/**
	 * @return the workNumber
	 */
	public String getWorkNumber() {
		return workNumber;
	}

	/**
	 * @param workNumber the workNumber to set
	 */
	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
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
	 * @return the workState
	 */
	public String getWorkState() {
		return workState;
	}

	/**
	 * @param workState the workState to set
	 */
	public void setWorkState(String workState) {
		this.workState = workState;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the politicalStatus
	 */
	public String getPoliticalStatus() {
		return politicalStatus;
	}

	/**
	 * @param politicalStatus the politicalStatus to set
	 */
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the marriage
	 */
	public String getMarriage() {
		return marriage;
	}

	/**
	 * @param marriage the marriage to set
	 */
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	/**
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	/**
	 * @return the formalSchooling
	 */
	public String getFormalSchooling() {
		return formalSchooling;
	}

	/**
	 * @param formalSchooling the formalSchooling to set
	 */
	public void setFormalSchooling(String formalSchooling) {
		this.formalSchooling = formalSchooling;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
