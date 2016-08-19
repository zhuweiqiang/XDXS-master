package com.qylm.dto.personnel;

import java.io.Serializable;

/**
 * 保存人事信息管理画面需要的值
 * @author smj
 */
public class PersonnelInfoManageDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6384083348297280559L;

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
	 * 身份证
	 */
	private String identification;
	
	/**
	 * 人事类型
	 */
	private String type;
	
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

}
