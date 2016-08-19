package com.qylm.dto.auditing;

import java.io.Serializable;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.AuditingSet;
import com.qylm.entity.User;

/**
 * 用于保存审核设定审核设定登录画面信息
 * @author ShengMinJun
 */
public class AuditingSetCreateDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8323656187096529991L;

	/**
	 * 申请单编号
	 */
	private String applyNumber;
	
	/**
	 * 设定状态 true 已设定
	 */
	private boolean state;
	
	/**
	 * 根据顺序显示出审核的用户
	 */
	private String showUser;
	
	/**
	 * 创建者
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 修改保存值
	 */
	private AuditingSet transferAuditingSet;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * get applyNumber
	 * @return the applyNumber
	 */
	public String getApplyNumber() {
		return applyNumber;
	}

	/**
	 * set applyNumber
	 * @param applyNumber the applyNumber to set
	 */
	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}

	/**
	 * get state
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * set state
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * get showUser
	 * @return the showUser
	 */
	public String getShowUser() {
		return showUser;
	}

	/**
	 * set showUser
	 * @param showUser the showUser to set
	 */
	public void setShowUser(String showUser) {
		this.showUser = showUser;
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
	 * get transferAuditingSet
	 * @return the transferAuditingSet
	 */
	public AuditingSet getTransferAuditingSet() {
		return transferAuditingSet;
	}

	/**
	 * set transferAuditingSet
	 * @param transferAuditingSet the transferAuditingSet to set
	 */
	public void setTransferAuditingSet(AuditingSet transferAuditingSet) {
		this.transferAuditingSet = transferAuditingSet;
	}

	/**
	 * get returner
	 * @return the returner
	 */
	public Returner<?, ?, ?> getReturner() {
		return returner;
	}

	/**
	 * set returner
	 * @param returner the returner to set
	 */
	public void setReturner(Returner<?, ?, ?> returner) {
		this.returner = returner;
	}
	
}
