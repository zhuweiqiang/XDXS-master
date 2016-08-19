package com.qylm.dto.company;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.qylm.bean.returner.Returner;
import com.qylm.entity.User;
import com.qylm.entity.UserDepot;
import com.qylm.entity.UserRole;

/**
 * 保存用户信息管理画面需要的值
 * @author smj
 */
public class UserCreateDto implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6595084921555852540L;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 用户名（登陆用）
	 */
	private String loginName;

	/**
	 * 用户密码（登陆用）
	 */
	private String password;
	
	/**
	 * 用户密码（登陆用）
	 */
	private String password1;

	/**
	 * 用户是否被禁止的标识
	 */
	private boolean stop;

	/**
	 * 电话号码
	 */
	private String userTel;

	/**
	 * 手机号码
	 */
	private String userMobile1;
	
	/**
	 * 上次登陆时间
	 */
	private Date lastLoginTime;
	
	/**
	 * 本次登陆时间
	 */
	private Date loginTime;
	
	/**
	 * 用户级别
	 * <ul>
	 * <li>1：超级管理员</li>
	 * <li>2：公司用户</li>
	 * <li>3：公司普通用户</li>
	 * <li>4：下属公司用户</li>
	 * <li>5：下属公司普通用户</li>
	 * </ul>
	 */
	private String userlevel;
	
	/**
	 * 下拉框
	 */
	private SelectItem[] userlevelItems;
	
	/**
	 * 上级
	 */
	private User belongingUser;

	/**
	 * 消费项目items
	 */
	private SelectItem[] roleItems;
	
	/**
	 * 消费项目
	 */
	private List<String> roleList;
	
	/**
	 * 用户与角色的关系表集合
	 */
	private List<UserRole> userRoleList;
	
	/**
	 * 仓库items
	 */
	private SelectItem[] depotItems;
	
	/**
	 * 仓库id
	 */
	private List<String> depotList;
	
	/**
	 * 用户与仓库的关系表集合
	 */
	private List<UserDepot> userDepotList;
	
	/**
	 * 创建用户
	 */
	private User creater;
	
	/**
	 * 修改传值
	 */
	private User transferUser;
	
	/**
	 * 返回共通方法
	 */
	private Returner<?, ?, ?> returner;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password1
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password1 the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	/**
	 * @return the stop
	 */
	public boolean isStop() {
		return stop;
	}

	/**
	 * @param stop the stop to set
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * @return the userTel
	 */
	public String getUserTel() {
		return userTel;
	}

	/**
	 * @param userTel the userTel to set
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	/**
	 * @return the userMobile1
	 */
	public String getUserMobile1() {
		return userMobile1;
	}

	/**
	 * @param userMobile1 the userMobile1 to set
	 */
	public void setUserMobile1(String userMobile1) {
		this.userMobile1 = userMobile1;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the userlevel
	 */
	public String getUserlevel() {
		return userlevel;
	}

	/**
	 * @param userlevel the userlevel to set
	 */
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}

	/**
	 * @return the userlevelItems
	 */
	public SelectItem[] getUserlevelItems() {
		return userlevelItems;
	}

	/**
	 * @param userlevelItems the userlevelItems to set
	 */
	public void setUserlevelItems(SelectItem[] userlevelItems) {
		this.userlevelItems = userlevelItems;
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
	 * @return the roleItems
	 */
	public SelectItem[] getRoleItems() {
		return roleItems;
	}

	/**
	 * @param roleItems the roleItems to set
	 */
	public void setRoleItems(SelectItem[] roleItems) {
		this.roleItems = roleItems;
	}

	/**
	 * @return the roleList
	 */
	public List<String> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	/**
	 * @return the userRoleList
	 */
	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	/**
	 * @param userRoleList the userRoleList to set
	 */
	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	/**
	 * @return the depotItems
	 */
	public SelectItem[] getDepotItems() {
		return depotItems;
	}

	/**
	 * @param depotItems the depotItems to set
	 */
	public void setDepotItems(SelectItem[] depotItems) {
		this.depotItems = depotItems;
	}

	/**
	 * @return the depotList
	 */
	public List<String> getDepotList() {
		return depotList;
	}

	/**
	 * @param depotList the depotList to set
	 */
	public void setDepotList(List<String> depotList) {
		this.depotList = depotList;
	}

	/**
	 * @return the userDepotList
	 */
	public List<UserDepot> getUserDepotList() {
		return userDepotList;
	}

	/**
	 * @param userDepotList the userDepotList to set
	 */
	public void setUserDepotList(List<UserDepot> userDepotList) {
		this.userDepotList = userDepotList;
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
	 * @return the transferUser
	 */
	public User getTransferUser() {
		return transferUser;
	}

	/**
	 * @param transferUser the transferUser to set
	 */
	public void setTransferUser(User transferUser) {
		this.transferUser = transferUser;
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
