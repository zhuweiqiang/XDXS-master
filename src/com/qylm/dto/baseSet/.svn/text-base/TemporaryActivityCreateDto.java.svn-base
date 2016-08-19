package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.entity.User;

/**
 * 保存活动套餐管理画面需要的值
 * @author smj
 */
public class TemporaryActivityCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7186714093462711996L;

	/**
	 * 活动名称
	 */
	private String name;
	
	/**
	 * 详细介绍
	 */
	private String remark;
	
	/**
	 * 套餐费用
	 */
	private BigDecimal money;
	
	/**
	 * 有效状态
	 * true：有效
	 * false：反之无效
	 */
	private boolean state;
	
	/**
	 * 活动套餐详细列表
	 */
	private List<TemporaryActivityDetail> temporaryActivityDetailList;
	
	/**
	 * 总原价格
	 */
	private BigDecimal sumYmoney;
	
	/**
	 * 总现价格
	 */
	private BigDecimal sumXmoney;
	
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
	private TemporaryActivity transferTemporaryActivity;
	
	/**
	 * 返回共通方法
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
	 * @return the temporaryActivityDetailList
	 */
	public List<TemporaryActivityDetail> getTemporaryActivityDetailList() {
		return temporaryActivityDetailList;
	}

	/**
	 * @param temporaryActivityDetailList the temporaryActivityDetailList to set
	 */
	public void setTemporaryActivityDetailList(
			List<TemporaryActivityDetail> temporaryActivityDetailList) {
		this.temporaryActivityDetailList = temporaryActivityDetailList;
	}

	/**
	 * @return the sumYmoney
	 */
	public BigDecimal getSumYmoney() {
		return sumYmoney;
	}

	/**
	 * @param sumYmoney the sumYmoney to set
	 */
	public void setSumYmoney(BigDecimal sumYmoney) {
		this.sumYmoney = sumYmoney;
	}

	/**
	 * @return the sumXmoney
	 */
	public BigDecimal getSumXmoney() {
		return sumXmoney;
	}

	/**
	 * @param sumXmoney the sumXmoney to set
	 */
	public void setSumXmoney(BigDecimal sumXmoney) {
		this.sumXmoney = sumXmoney;
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
	 * @return the transferTemporaryActivity
	 */
	public TemporaryActivity getTransferTemporaryActivity() {
		return transferTemporaryActivity;
	}

	/**
	 * @param transferTemporaryActivity the transferTemporaryActivity to set
	 */
	public void setTransferTemporaryActivity(
			TemporaryActivity transferTemporaryActivity) {
		this.transferTemporaryActivity = transferTemporaryActivity;
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
