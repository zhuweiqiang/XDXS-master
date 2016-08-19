package com.qylm.dto.baseSet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;
import com.qylm.entity.User;

/**
 * 保存 体验卡管理画面需要的值
 * @author smj
 */
public class GiveInfoCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4426419557681148829L;

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 价值
	 */
	private BigDecimal money;
	
	/**
	 * 消费折扣
	 */
	private BigDecimal rebate;
	
	/**
	 * 类型
	 * 1：体验卡
	 * 2：现金卷
	 * 3：身体卷
	 */
	private String type;
	
	/**
	 * 名称
	 */
	public String getName() {
		String name = "";
		if (GiveInfo.TYPE_1.equals(type)) {
			name = "体验卡";
		} else if (GiveInfo.TYPE_2.equals(type)) {
			name = "现金卷";
		} else {
			name = "身体卷";
		}
		return name;
	}
	
	/**
	 * 对应的打折项目
	 */
	private List<GiveInfoDetail> giveInfoDetailList;
	
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
	private GiveInfo transferGiveInfo;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the rebate
	 */
	public BigDecimal getRebate() {
		return rebate;
	}

	/**
	 * @param rebate the rebate to set
	 */
	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
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
	 * @return the giveInfoDetailList
	 */
	public List<GiveInfoDetail> getGiveInfoDetailList() {
		return giveInfoDetailList;
	}

	/**
	 * @param giveInfoDetailList the giveInfoDetailList to set
	 */
	public void setGiveInfoDetailList(List<GiveInfoDetail> giveInfoDetailList) {
		this.giveInfoDetailList = giveInfoDetailList;
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
	 * @return the transferGiveInfo
	 */
	public GiveInfo getTransferGiveInfo() {
		return transferGiveInfo;
	}

	/**
	 * @param transferGiveInfo the transferGiveInfo to set
	 */
	public void setTransferGiveInfo(GiveInfo transferGiveInfo) {
		this.transferGiveInfo = transferGiveInfo;
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
