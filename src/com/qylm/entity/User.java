package com.qylm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户的持久化类
 * @author 盛民军
 */
@Entity
@Table(uniqueConstraints = {}, name = "user")
public class User extends BaseEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5884861011545875990L;
	
	/**
	 * 检索条件：userName
	 */
	public static final String USER_NAME = "userName";
	
	/**
	 * 检索条件：loginName
	 */
	public static final String LOGIN_NAME = "loginName";
	
	/**
	 * 用户级别
	 */
	public static final String USER_LEVEL = "userlevel";
	
	/**
	 * 用户状况
	 */
	public final static String STOP = "stop";
	
	/**
	 * 用户状况：新注册用户
	 */
	public final static String STOP_1 = "1";
	
	/**
	 * 用户状况：有效用户
	 */
	public final static String STOP_2 = "2";
	
	/**
	 * 用户状况：中止用户
	 */
	public final static String STOP_3 = "3";
	
	/**
	 * 用户状况：无效用户
	 */
	public final static String STOP_4 = "4";
	
	/**
	 * 用户级别：超级管理员
	 */
	public static final String USER_LEVEL_1 = "1";
	
	/**
	 * 用户级别：公司用户
	 */
	public static final String USER_LEVEL_2 = "2";
	
	/**
	 * 用户级别：公司普通用户
	 */
	public static final String USER_LEVEL_3 = "3";
	
	/**
	 * 用户级别：下属公司用户
	 */
	public static final String USER_LEVEL_4 = "4";
	
	/**
	 * 用户级别：下属公司普通用户
	 */
	public static final String USER_LEVEL_5 = "5";
	
	/**
	 * 自动创建用户时用到的默认密码
	 */
	public static final String DEFAULT_MM = "11";

	/**
	 * 上级
	 */
	public static final String BELONGING_USER = "belongingUser";

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
	 * 用户状态
	 * <ul>
	 * <li>1:新注册用户</li>
	 * <li>2:有效用户</li>
	 * <li>3:中止用户</li>
	 * <li>4:无效用户</li>
	 * </ul>
	 */
	private String stop;

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
	 * 角色
	 */
	@Transient
	private String roles;
	
	/**
	 * 存放用户所拥有的角色
	 */
	@Transient
	private List<RoleDetail> roleDetailList;
	
	/**
	 * 存放用户对于的仓库
	 */
	@Transient
	private List<DepotInfo> depotInfoList;
	
	/**
	 * 存放当前用户的下属id
	 */
	@Transient
	private List<User> subordinateList;

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
	 * @return the stop
	 */
	public String getStop() {
		return stop;
	}

	/**
	 * @param stop the stop to set
	 */
	public void setStop(String stop) {
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
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * @return the roleDetailList
	 */
	public List<RoleDetail> getRoleDetailList() {
		return roleDetailList;
	}

	/**
	 * @param roleDetailList the roleDetailList to set
	 */
	public void setRoleDetailList(List<RoleDetail> roleDetailList) {
		this.roleDetailList = roleDetailList;
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
	 * @return the depotInfoList
	 */
	public List<DepotInfo> getDepotInfoList() {
		return depotInfoList;
	}

	/**
	 * @param depotInfoList the depotInfoList to set
	 */
	public void setDepotInfoList(List<DepotInfo> depotInfoList) {
		this.depotInfoList = depotInfoList;
	}

	/**
	 * @return the subordinateList
	 */
	public List<User> getSubordinateList() {
		return subordinateList;
	}

	/**
	 * @param subordinateList the subordinateList to set
	 */
	public void setSubordinateList(List<User> subordinateList) {
		this.subordinateList = subordinateList;
	}

}
