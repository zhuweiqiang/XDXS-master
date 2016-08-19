package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.User;

/**
 * 保存服务管理管理画面需要的值
 * @author smj
 */
public class MarketingProjectCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3052530989683316946L;

	/**
	 * 项目
	 */
	private String project;
	
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
	 * 项目类型
	 * 1：面部资料
	 * 2：身体资料
	 */
	private String type;
	
	/**
	 * 创建事件
	 */
	private User creater;
	
	/**
	 * 上级
	 */
	private User belongingUser;
	
	/**
	 * 修改传值
	 */
	private MarketingProject transferMarketingProject;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

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
	 * @return the transferMarketingProject
	 */
	public MarketingProject getTransferMarketingProject() {
		return transferMarketingProject;
	}

	/**
	 * @param transferMarketingProject the transferMarketingProject to set
	 */
	public void setTransferMarketingProject(
			MarketingProject transferMarketingProject) {
		this.transferMarketingProject = transferMarketingProject;
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
