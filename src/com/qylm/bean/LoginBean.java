package com.qylm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Message;
import com.qylm.common.Tool;
import com.qylm.common.utils.CipherUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.Role;
import com.qylm.entity.RoleDetail;
import com.qylm.entity.User;
import com.qylm.entity.UserRole;
//import com.qylm.service.DepotInfoService;
import com.qylm.service.RoleDetailService;
//import com.qylm.service.UserDepotService;
import com.qylm.service.UserRoleService;
import com.qylm.service.UserService;

/**
 * 用户登录
 * @author smj
 */
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2033126670636495850L;

	/**
	 * 密码
	 */
	private String loginPassword;

	/**
	 * 用户名
	 */
	private String loginName;
	
	/**
	 * 用户的业务类
	 */
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	/**
	 * 用户与角色的关系表的业务类
	 */
	@ManagedProperty(value = "#{userRoleService}")
	private UserRoleService userRoleService;
	
	/**
	 * 角色详细业务类
	 */
	@ManagedProperty(value = "#{roleDetailService}")
	private RoleDetailService roleDetailService;
	
//	/**
//	 * 用户与仓库的关系表的业务类
//	 */
//	@ManagedProperty(value = "#{userDepotService}")
//	private UserDepotService userDepotService;
//	
//	/**
//	 * 仓库信息业务类
//	 */
//	@ManagedProperty(value = "#{depotInfoService}")
//	private DepotInfoService depotInfoService;
	
	/**
	 * 登陆
	 * @return
	 */
	public String login() {
		User user = getUserByLoginName();
		if (user == null) {
			Tool.sendFormatedErrorMessage(Message.LOGINBEAN_USERNAME_NOTEXISTS, new String[] {loginName});
			return null;
		}
		if(!user.getPassword().equals(CipherUtil.DESEncrypt(loginPassword, CipherUtil.generateDESKey(loginName)))){
			Tool.sendErrorMessage(Message.LOGINBEAN_USERNAMEANDPASSWORD_ERROR);
			return null;
		}
		if (!User.STOP_2.equals(user.getStop())) {
			Tool.sendErrorMessage(Message.LOGINBEAN_THEACCOUNTISDISABLED_ERROR);
			return null;
		}
		user.setLoginTime(DateUtil.getNowyyyymmddhhmmss());
		userService.updateEntity(user);
		return Tool.getBackBean(UserBean.class).login(user);
	}
	
	/**
	 * 根据登录名查询到数据信息
	 * @return
	 */
	private User getUserByLoginName() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq(User.LOGIN_NAME, loginName));
		List<User> userList = userService.getByDetachedCriteria(detachedCriteria);
		if (!userList.isEmpty()) {
			User user = userList.get(0);
			detachedCriteria = DetachedCriteria.forClass(UserRole.class);
			detachedCriteria.createAlias(UserRole.ROLE, UserRole.ROLE, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(UserRole.USER, user));
			List<UserRole> userRoleList = userRoleService.getByDetachedCriteria(detachedCriteria);
			if (!userRoleList.isEmpty()) {
				List<Role> roleList = new ArrayList<Role>();
				for (UserRole userRole : userRoleList) {
					roleList.add(userRole.getRole());
				}
				detachedCriteria = DetachedCriteria.forClass(RoleDetail.class);
				detachedCriteria.createAlias(RoleDetail.TREE_ITEM, RoleDetail.TREE_ITEM, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.createAlias(RoleDetail.FUNCTION, RoleDetail.FUNCTION, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.in(RoleDetail.ROLE, roleList));
				List<RoleDetail> roleDetailList = roleDetailService.getByDetachedCriteria(detachedCriteria);
				if (!roleDetailList.isEmpty()) {
					user.setRoleDetailList(roleDetailList);
				}
			}
//			// 获取用户对于的仓库,系统管理员获取所有
//			if (User.USER_LEVEL_1.equals(user.getUserlevel())) {
//				user.setDepotInfoList(depotInfoService.getAll());
//			} else {
//				detachedCriteria = DetachedCriteria.forClass(UserDepot.class);
//				detachedCriteria.createAlias(UserDepot.DEPOT_INFO, UserDepot.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
//				detachedCriteria.createAlias(UserDepot.USER, UserDepot.USER, JoinType.LEFT_OUTER_JOIN);
//				detachedCriteria.add(Restrictions.eq(UserDepot.USER, user));
//				List<UserDepot> userDepotList = userDepotService.getByDetachedCriteria(detachedCriteria);
//				List<DepotInfo> depotInfoList = new ArrayList<DepotInfo>();
//				for (UserDepot userDepot : userDepotList) {
//					depotInfoList.add(userDepot.getDepotInfo());
//				}
//				user.setDepotInfoList(depotInfoList);
//			}
			// 获取当前用户的所有下级id
			detachedCriteria = DetachedCriteria.forClass(User.class);
			detachedCriteria.createAlias(BaseEntity.BELONGING_USER, BaseEntity.BELONGING_USER, JoinType.LEFT_OUTER_JOIN);
			Integer id = null;
			String userlevel = user.getUserlevel();
			String level = null;
			if (User.USER_LEVEL_1.equals(userlevel)) {
				level = User.USER_LEVEL_2;
			}
			if (User.USER_LEVEL_2.equals(userlevel)) {
				id = user.getId();
				level = User.USER_LEVEL_4;
			} else if (User.USER_LEVEL_3.equals(userlevel)) {
				id = user.getBelongingUser().getId();
			} else if (User.USER_LEVEL_4.equals(userlevel)) {
				id = user.getId();
				level = User.USER_LEVEL_4;
			} else if (User.USER_LEVEL_5.equals(userlevel)) {
				id = user.getBelongingUser().getId();
			}
			if (id != null) {
				detachedCriteria.add(Restrictions.eq(BaseEntity.BELONGING_USER_ID, id));
			}
			if (StringUtil.isNotBlank(level)) {
				detachedCriteria.add(Restrictions.eq(User.USER_LEVEL, level));
			}
			user.setSubordinateList(userService.getByDetachedCriteria(detachedCriteria));
			return user;
		}
		return null;
	}

//	/**
//	 * @param depotInfoService the depotInfoService to set
//	 */
//	public void setDepotInfoService(DepotInfoService depotInfoService) {
//		this.depotInfoService = depotInfoService;
//	}
//
//	/**
//	 * @param userDepotService the userDepotService to set
//	 */
//	public void setUserDepotService(UserDepotService userDepotService) {
//		this.userDepotService = userDepotService;
//	}

	/**
	 * @param roleDetailService the roleDetailService to set
	 */
	public void setRoleDetailService(RoleDetailService roleDetailService) {
		this.roleDetailService = roleDetailService;
	}

	/**
	 * @param userRoleService the userRoleService to set
	 */
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * get loginPassword
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * set loginPassword
	 * @param loginPassword the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * get loginName
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * set loginName
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
