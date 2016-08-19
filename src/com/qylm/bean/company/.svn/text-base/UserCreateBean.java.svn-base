package com.qylm.bean.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.GenericCodeBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.CipherUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.SelectItemUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.company.UserCreateDto;
import com.qylm.dxo.UserCreateDxo;
import com.qylm.entity.DepotInfo;
import com.qylm.entity.Role;
import com.qylm.entity.User;
import com.qylm.entity.UserDepot;
import com.qylm.entity.UserRole;
import com.qylm.service.DepotInfoService;
import com.qylm.service.RoleService;
import com.qylm.service.UserDepotService;
import com.qylm.service.UserRoleService;
import com.qylm.service.UserService;

/**
 * 用户登陆画面bean
 * @author 
 */
/**
 * @author 盛民军
 *
 */
@ManagedBean
@RequestScoped
public class UserCreateBean implements CreateBean<User>, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5506422996436968912L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(UserCreateBean.class);

	/**
	 * 存放用户登陆画面需要保存的值
	 */
	private UserCreateDto userCreateDto = new UserCreateDto();

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 泛用code
	 */
	@ManagedProperty(value="#{genericCodeBean}")
	private GenericCodeBean genericCodeBean;
	
	/**
	 * 用户业务类
	 */
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	
	/**
	 * 用户与角色关系表业务类
	 */
	@ManagedProperty(value="#{userRoleService}")
	private UserRoleService userRoleService;
	
	/**
	 * 角色关系表业务类
	 */
	@ManagedProperty(value="#{roleService}")
	private RoleService roleService;
	
	/**
	 * 仓库信息业务类
	 */
	@ManagedProperty(value="#{depotInfoService}")
	private DepotInfoService depotInfoService;
	
	/**
	 * 用户与仓库关系表业务类
	 */
	@ManagedProperty(value="#{userDepotService}")
	private UserDepotService userDepotService;

	/**
	 * 此方法绑定于用户登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个用户
	 * @return 用户登陆画面
	 */
	public String newUser() {
		Tool.sendLog(LOG, userBean, "【用户登陆画面_新建按钮】");
		userCreateDto.setUserName(null);
		userCreateDto.setLoginName(null);
		userCreateDto.setPassword(null);
		userCreateDto.setPassword1(null);
		userCreateDto.setStop(false);
		userCreateDto.setUserTel(null);
		userCreateDto.setUserlevel(null);
		userCreateDto.setUserMobile1(null);
		userCreateDto.setLastLoginTime(null);
		userCreateDto.setLoginTime(null);
		userCreateDto.setBelongingUser(null);
		userCreateDto.setTransferUser(null);
		userCreateDto.setRoleList(null);
		userCreateDto.setDepotList(null);
		return Navigation.USER_CREATE;
	}
	
	/**
	 * 此方法绑定于用户登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		return userCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于用户登陆画面的保存按钮 
	 * 实现功能：根据transferUser对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveUser() {
		Tool.sendLog(LOG, userBean, "【用户登陆画面_保存按钮】");
		User transferUser = userCreateDto.getTransferUser();
		try {
			if (transferUser == null) {
				if (StringUtil.isBlank(userCreateDto.getPassword1())) {
					Tool.sendErrorMessage("用户密码必须输入！");
					return;
				}
				transferUser = new User();
				userCreateDto.setPassword(CipherUtil.DESEncrypt(userCreateDto.getPassword1(), CipherUtil.generateDESKey(userCreateDto.getLoginName())));
				userCreateDto.setCreater(userBean.getUser());
				userCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				create(transferUser);
				transferUser.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				userService.saveUser(transferUser, userCreateDto.getUserRoleList(), userCreateDto.getUserDepotList());
				userCreateDto.setTransferUser(transferUser);
				Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
			} else {
				if (StringUtil.isNotBlank(userCreateDto.getPassword1())) {
					userCreateDto.setPassword(CipherUtil.DESEncrypt(userCreateDto.getPassword1(), CipherUtil.generateDESKey(userCreateDto.getLoginName())));
				}
				create(transferUser);
				transferUser.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
				userService.updateUser(transferUser, userCreateDto.getUserRoleList(), userCreateDto.getUserDepotList());
				Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage("用户名：" + transferUser.getLoginName() + " 已存在，请重新输入！");
		}
		
	}
	
	/**
	 * 赋值
	 * @param transferUser
	 */
	private void create(User transferUser) {
		transferUser.setStop(userCreateDto.isStop() ? User.STOP_3 : User.STOP_2);
		List<String> roleList = userCreateDto.getRoleList();
		if (roleList != null && !roleList.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for (String string : roleList) {
				idList.add(Integer.valueOf(string));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
			detachedCriteria.add(Restrictions.in(Role.BASE_ID, idList));
			List<Role> list = roleService.getByDetachedCriteria(detachedCriteria);
			List<UserRole> userRoleList = userCreateDto.getUserRoleList();
			if (userRoleList == null) {
				userRoleList = new ArrayList<UserRole>();
				userCreateDto.setUserRoleList(userRoleList);
			}
			UserRole userRole;
			for (Role role : list) {
				userRole = new UserRole();
				userRole.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				userRole.setCreater(userBean.getUser());
				userRole.setUser(transferUser);
				userRole.setRole(role);
				userRoleList.add(userRole);
			}
		}
		List<String> depotList = userCreateDto.getDepotList();
		if (depotList != null && !depotList.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for (String string : depotList) {
				idList.add(Integer.valueOf(string));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepotInfo.class);
			detachedCriteria.add(Restrictions.in(DepotInfo.BASE_ID, idList));
			List<DepotInfo> depotInfoList = depotInfoService.getByDetachedCriteria(detachedCriteria);
			List<UserDepot> userDepotList = userCreateDto.getUserDepotList();
			if (userDepotList == null) {
				userDepotList = new ArrayList<UserDepot>();
				userCreateDto.setUserDepotList(userDepotList);
			}
			UserDepot userDepot;
			for (DepotInfo depotInfo : depotInfoList) {
				userDepot = new UserDepot();
				userDepot.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				userDepot.setCreater(userBean.getUser());
				userDepot.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				userDepot.setUser(transferUser);
				userDepot.setDepotInfo(depotInfo);
				userDepotList.add(userDepot);
			}
		}
		// 设定归属情况
		String userlevel = userBean.getUser().getUserlevel();
		if (User.USER_LEVEL_1.equals(userlevel)) {
			userCreateDto.setBelongingUser(userBean.getUser());
		} else if (User.USER_LEVEL_2.equals(userlevel)) {
			userCreateDto.setBelongingUser(userBean.getUser());
		} else if (User.USER_LEVEL_3.equals(userlevel)) {
			userCreateDto.setBelongingUser(userBean.getUser().getBelongingUser());
		} else if (User.USER_LEVEL_4.equals(userlevel)) {
			userCreateDto.setBelongingUser(userBean.getUser());
		} else {
			userCreateDto.setBelongingUser(userBean.getUser().getBelongingUser());
		}
		UserCreateDxo.dtoToEntity(userCreateDto, transferUser);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		userCreateDto.setReturner(returner);
		getRoleItems();
		getDepot();
		getUserLevelItem();
		return Navigation.USER_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, User user) {
		userCreateDto.setReturner(returner);
		UserCreateDxo.entityToDto(user, userCreateDto);
		userCreateDto.setTransferUser(user);
		getRoleItems();
		getUserRole();
		getDepot();
		getDepotItems();
		getUserLevelItem();
		return Navigation.USER_CREATE;
	}
	
	/**
	 * 显示状态
	 * @return true 显示，反之不显示
	 */
	public boolean isShowState() {
		boolean state = false;
		if (userCreateDto.getTransferUser() == null) {
			state = true;
		} else if (User.USER_LEVEL_1.equals(userCreateDto.getTransferUser().getUserlevel())) {
			state = false;
		} else if (User.USER_LEVEL_2.equals(userCreateDto.getTransferUser().getUserlevel())) {
			if (User.USER_LEVEL_2.equals(userBean.getUser().getUserlevel())) {
				state = false;
			} else {
				state = true;
			}
		} else {
			state = true;
		}
		return state;
	}
	
	/**
	 * 显示状态
	 * @return true 显示，反之不显示
	 */
	public boolean isShowDepot() {
		boolean state = true;
		if (User.USER_LEVEL_1.equals(userBean.getUser().getUserlevel())) {
			state = false;
		}
		return state;
	}
	
	/**
	 * 获取角色
	 */
	private void getRoleItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
		detachedCriteria.createAlias(Role.CREATER, Role.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Role.CREATER, userBean.getUser()));
		userCreateDto.setRoleItems(SelectItemUtil.createSelectItems(roleService.getByDetachedCriteria(detachedCriteria), false));
	}
	
	/**
	 * 获取到用户选择到的角色
	 */
	private void getUserRole() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserRole.class);
		detachedCriteria.createAlias(UserRole.ROLE, UserRole.ROLE, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(UserRole.USER, userCreateDto.getTransferUser()));
		List<UserRole> userRoleList = userRoleService.getByDetachedCriteria(detachedCriteria);
		List<String> roleList = new ArrayList<String>();
		userCreateDto.setRoleList(roleList);
		if (!userRoleList.isEmpty()) {
			for (UserRole userRole : userRoleList) {
				roleList.add(userRole.getRole().getValue());
			}
		}
	}
	
	/**
	 * 获取可以选择的仓库
	 */
	private void getDepot() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DepotInfo.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		userCreateDto.setDepotItems(SelectItemUtil.createSelectItems(depotInfoService.getByDetachedCriteria(detachedCriteria), false));
	}
	
	/**
	 * 获取选择的仓库
	 */
	private void getDepotItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserDepot.class);
		detachedCriteria.createAlias(UserDepot.USER, UserDepot.USER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(UserDepot.DEPOT_INFO, UserDepot.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(UserDepot.USER, userCreateDto.getTransferUser()));
		List<UserDepot> userDepotList = userDepotService.getByDetachedCriteria(detachedCriteria);
		if (!userDepotList.isEmpty()) {
			List<String> depotList = new ArrayList<String>();
			userCreateDto.setDepotList(depotList);
			for (UserDepot userDepot : userDepotList) {
				depotList.add(userDepot.getDepotInfo().getId().toString());
			}
		}
	}
	
	/**
	 * 获取用户级别下拉框列表
	 */
	private void getUserLevelItem() {
		// 获取下拉列表
		SelectItem[] c0501 = genericCodeBean.getC0501();
		// 根据用户的级别来设定下拉框
		String userlevel = userBean.getUser().getUserlevel();
		SelectItem[] userlevelItems;
		if (User.USER_LEVEL_1.equals(userlevel)) {
			userlevelItems = new SelectItem[1];
			userlevelItems[0] = c0501[1];
		} else if (User.USER_LEVEL_2.equals(userlevel)) {
			userlevelItems = new SelectItem[2];
			userlevelItems[0] = c0501[2];
			userlevelItems[1] = c0501[3];
		} else if (User.USER_LEVEL_3.equals(userlevel)) {
			userlevelItems = new SelectItem[2];
			userlevelItems[0] = c0501[2];
			userlevelItems[1] = c0501[3];
		} else if (User.USER_LEVEL_4.equals(userlevel)) {
			userlevelItems = new SelectItem[1];
			userlevelItems[0] = c0501[4];
		} else {
			userlevelItems = new SelectItem[1];
			userlevelItems[0] = c0501[4];
		}
		userCreateDto.setUserlevelItems(userlevelItems);
	}

	/**
	 * @param userDepotService the userDepotService to set
	 */
	public void setUserDepotService(UserDepotService userDepotService) {
		this.userDepotService = userDepotService;
	}

	/**
	 * @param depotInfoService the depotInfoService to set
	 */
	public void setDepotInfoService(DepotInfoService depotInfoService) {
		this.depotInfoService = depotInfoService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @param userRoleService the userRoleService to set
	 */
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	/**
	 * set userService
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @param genericCodeBean the genericCodeBean to set
	 */
	public void setGenericCodeBean(GenericCodeBean genericCodeBean) {
		this.genericCodeBean = genericCodeBean;
	}

	/**
	 * get userCreateDto
	 * @return the userCreateDto
	 */
	public UserCreateDto getUserCreateDto() {
		return userCreateDto;
	}

	/**
	 * set userCreateDto
	 * @param userCreateDto the userCreateDto to set
	 */
	public void setUserCreateDto(UserCreateDto userCreateDto) {
		this.userCreateDto = userCreateDto;
	}

}
