package com.qylm.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户与仓库之间的关系表
 * @author smj
 */
@Entity
@Table(uniqueConstraints = {}, name = "user_depot")
public class UserDepot extends BaseEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3440102175464656497L;

	/**
	 * 搜索条件：user
	 */
	public static final String USER	= "user";
	
	/**
	 * 搜索条件：depotInfo
	 */
	public static final String DEPOT_INFO	= "depotInfo";
	
	/**
	 * 搜索条件：depotInfo.id
	 */
	public static final String DEPOT_INFO_ID	= "depotInfo.id";
	
	/**
	 * 用户
	 */
	@ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	/**
	 * 仓库信息
	 */
	@ManyToOne(targetEntity = DepotInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "depotInfoId")
	private DepotInfo depotInfo;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the depotInfo
	 */
	public DepotInfo getDepotInfo() {
		return depotInfo;
	}

	/**
	 * @param depotInfo the depotInfo to set
	 */
	public void setDepotInfo(DepotInfo depotInfo) {
		this.depotInfo = depotInfo;
	}

}
