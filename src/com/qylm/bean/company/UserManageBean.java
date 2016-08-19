package com.qylm.bean.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.company.UserManageReturner;
import com.qylm.common.Message;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.company.UserManageDto;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.User;
import com.qylm.entity.UserRole;
import com.qylm.service.UserRoleService;
import com.qylm.service.UserService;

/**
 * 用户信息管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class UserManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1264166394459179267L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(UserManageBean.class);
	
	/**
	 * 保存用户管理画面需要保存的值
	 */
	private UserManageDto userManageDto = new UserManageDto();

	/**
	 * 用户列表（检索结果）
	 */
	private List<User> userList;
	
	/**
	 * 删除复选框选择的值
	 */
	private User[] selectedModels;

	/**
	 * 用户管理bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;

	/**
	 * 用户管理业务类
	 */
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	
	/**
	 * 用户与角色关系表业务类
	 */
	@ManagedProperty(value="#{userRoleService}")
	private UserRoleService userRoleService;

	/**
	 * 查询出所有用户列表
	 * 
	 * @return 用户管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_用户管理按钮】");
		fetchData(0, true);
		return Navigation.USER_MANAGE;
	}

	/**
	 * 此方法绑定于项目管理画面的新建按钮 
	 * 实现功能：跳转至用户登陆画面，新建一家用户
	 * @return 用户登陆画面
	 */
	public String newUser() {
		Tool.sendLog(LOG, userBean, "按下【用户管理画面_新建按钮】");
		return Tool.getBackBean(UserCreateBean.class).newCreate(new UserManageReturner(userManageDto, currentPage));
	}

	/**
	 * 此方法绑定于项目管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至用户登陆画面
	 * @return 用户登陆画面
	 */
	public String updateUser(User transferUser) {
		Tool.sendLog(LOG, userBean, "按下【用户管理画面_修改按钮】");
		return Tool.getBackBean(UserCreateBean.class).updateDetail(new UserManageReturner(userManageDto, currentPage), transferUser);
	}
	
	/**
	 * 此方法绑定于用户管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出用户
	 * @return 画面不跳转
	 */
	public void selectUser() {
		Tool.sendLog(LOG, userBean, "按下【用户管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于用户管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【用户管理画面_批量删除按钮】");
		List<User> asList = Arrays.asList(selectedModels);
		try {
			if (selectedModels != null) {
				userService.deleteEntityAll(asList);
			}
		} catch (DataIntegrityViolationException e) {
			for (User user : asList) {
				user.setStop(User.STOP_4);
			}
			userService.updateEntityAll(asList);
		}
		userList.removeAll(asList);
		removeData(1, userList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}

	/**
	 * 此方法绑定于用户管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteUser(User transferUser) {
		Tool.sendLog(LOG, userBean, "按下【用户管理画面的_删除按钮】");
		userList.remove(transferUser);
		try {
			userService.deleteEntity(transferUser);
		} catch (DataIntegrityViolationException e) {
			transferUser.setStop(User.STOP_4);
			userService.updateEntity(transferUser);
		}
		removeData(1, userList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.not(Restrictions.eq(User.STOP, User.STOP_4)));
		detachedCriteria.createAlias(BaseEntity.CREATER, BaseEntity.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(BaseEntity.BELONGING_USER, BaseEntity.BELONGING_USER, JoinType.LEFT_OUTER_JOIN);
		String userlevel = userBean.getUser().getUserlevel();
		
		if (User.USER_LEVEL_1.equals(userlevel) || User.USER_LEVEL_2.equals(userlevel) || User.USER_LEVEL_4.equals(userlevel) ) {
			detachedCriteria.add(Restrictions.or(Restrictions.eq(User.BASE_ID, userBean.getUser().getId()),Restrictions.eq(BaseEntity.BELONGING_USER, userBean.getUser())));
		} else {
			detachedCriteria.add(Restrictions.eq(BaseEntity.BELONGING_USER, userBean.getUser().getBelongingUser()));
		}
		
		String loginName = userManageDto.getLoginName();
		String userName = userManageDto.getUserName();
		List<String> userlevelList = new ArrayList<String>();
		// 根据用户级别查询
		if (User.USER_LEVEL_1.equals(userlevel)) {// 超级系统管理员
			detachedCriteria.add(Restrictions.or(Restrictions.eq(User.BASE_ID, userBean.getUser().getId()), Restrictions.eq(User.USER_LEVEL, User.USER_LEVEL_2)));
		} else if (User.USER_LEVEL_2.equals(userlevel)) {// 公司系统管理员
			userlevelList.add(User.USER_LEVEL_2);
			userlevelList.add(User.USER_LEVEL_3);
			userlevelList.add(User.USER_LEVEL_4);
			detachedCriteria.add(Restrictions.or(Restrictions.eq(User.BASE_ID, userBean.getUser().getId()), Restrictions.in(User.USER_LEVEL, userlevelList)));
		} else if (User.USER_LEVEL_3.equals(userlevel)) { // 公司普通用户
			userlevelList.add(User.USER_LEVEL_3);
			userlevelList.add(User.USER_LEVEL_4);
			detachedCriteria.add(Restrictions.in(User.USER_LEVEL, userlevelList));
		} else if (User.USER_LEVEL_4.equals(userlevel)) { // 下属公司管理员
			userlevelList.add(User.USER_LEVEL_5);
			detachedCriteria.add(Restrictions.or(Restrictions.eq(User.BASE_ID, userBean.getUser().getId()), Restrictions.eq(User.USER_LEVEL, User.USER_LEVEL_5)));
		} else {// 下属公司普通用户
			detachedCriteria.add(Restrictions.eq(User.USER_LEVEL, User.USER_LEVEL_5));
		}
		if (StringUtil.isNotBlank(loginName)) {
			detachedCriteria.add(Restrictions.like(User.LOGIN_NAME, loginName, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(userName)) {
			detachedCriteria.add(Restrictions.like(User.USER_NAME, userName, MatchMode.ANYWHERE));
		}
		userList = userService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(userService.getRowCount(detachedCriteria));
		}
		if (!userList.isEmpty()) {
			detachedCriteria = DetachedCriteria.forClass(UserRole.class);
			detachedCriteria.createAlias(UserRole.ROLE, UserRole.ROLE, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(UserRole.USER, UserRole.USER, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(UserRole.USER, userList));
			List<UserRole> userRoleList = userRoleService.getByDetachedCriteria(detachedCriteria);
			for (User user : userList) {
				StringBuilder sb = new StringBuilder();
				for (UserRole userRole : userRoleList) {
					if (user.getId().equals(userRole.getUser().getId())) {
						sb.append("【");
						sb.append(userRole.getRole().getLabel());
						sb.append("】");
					}
				}
				user.setRoles(sb.toString());
			}
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人用户管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.USER_MANAGE;
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
	 * get userManageDto
	 * @return the userManageDto
	 */
	public UserManageDto getUserManageDto() {
		return userManageDto;
	}

	/**
	 * set userManageDto
	 * @param userManageDto the userManageDto to set
	 */
	public void setUserManageDto(UserManageDto userManageDto) {
		this.userManageDto = userManageDto;
	}

	/**
	 * get userList
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * set userList
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the selectedModels
	 */
	public User[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(User[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
