package com.qylm.bean.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.company.RoleManageReturner;
import com.qylm.common.Message;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.company.RoleManageDto;
import com.qylm.entity.Role;
import com.qylm.entity.RoleDetail;
import com.qylm.service.RoleDetailService;
import com.qylm.service.RoleService;

/**
 * 角色信息管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class RoleManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1264166394459179267L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(RoleManageBean.class);
	
	/**
	 * 保存角色管理画面需要保存的值
	 */
	private RoleManageDto roleManageDto = new RoleManageDto();

	/**
	 * 角色列表（检索结果）
	 */
	private List<Role> roleList;
	
	/**
	 * 删除复选框选择的值
	 */
	private Role[] selectedModels;

	/**
	 * 角色管理bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;

	/**
	 * 角色管理业务类
	 */
	@ManagedProperty(value="#{roleService}")
	private RoleService roleService;
	
	/**
	 * 角色详细业务类
	 */
	@ManagedProperty(value="#{roleDetailService}")
	private RoleDetailService roleDetailService;

	/**
	 * 查询出所有角色列表
	 * 
	 * @return 角色管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_角色管理按钮】");
		fetchData(0, true);
		return Navigation.ROLE_MANAGE;
	}

	/**
	 * 此方法绑定于项目管理画面的新建按钮 
	 * 实现功能：跳转至角色登陆画面，新建一家角色
	 * @return 角色登陆画面
	 */
	public String newRole() {
		Tool.sendLog(LOG, userBean, "按下【角色管理画面_新建按钮】");
		return Tool.getBackBean(RoleCreateBean.class).newCreate(new RoleManageReturner(roleManageDto, currentPage));
	}

	/**
	 * 此方法绑定于项目管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至角色登陆画面
	 * @return 角色登陆画面
	 */
	public String updateRole(Role transferRole) {
		Tool.sendLog(LOG, userBean, "按下【角色管理画面_修改按钮】");
		return Tool.getBackBean(RoleCreateBean.class).updateDetail(new RoleManageReturner(roleManageDto, currentPage), transferRole);
	}
	
	/**
	 * 此方法绑定于角色管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出角色
	 * @return 画面不跳转
	 */
	public void selectRole() {
		Tool.sendLog(LOG, userBean, "按下【角色管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于角色管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【角色管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<Role> asList = Arrays.asList(selectedModels);
			roleService.deleteEntityAll(asList);
			roleList.removeAll(asList);
			removeData(1, roleList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于角色管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteRole(Role transferRole) {
		Tool.sendLog(LOG, userBean, "按下【角色管理画面的_删除按钮】");
		roleService.deleteEntity(transferRole);
		roleList.remove(transferRole);
		removeData(1, roleList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
		detachedCriteria.createAlias(Role.CREATER, Role.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(Role.CREATER, userBean.getUser()));
		String roleName = roleManageDto.getRoleName();
		if (StringUtil.isNotBlank(roleName)) {
			detachedCriteria.add(Restrictions.like(Role.ROLE_NAME, roleName, MatchMode.ANYWHERE));
		}
		roleList = roleService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(roleService.getRowCount(detachedCriteria));
		}
		if (!roleList.isEmpty()) {
			detachedCriteria = DetachedCriteria.forClass(RoleDetail.class);
			detachedCriteria.createAlias(RoleDetail.ROLE, RoleDetail.ROLE, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(RoleDetail.TREE_ITEM, RoleDetail.TREE_ITEM, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(RoleDetail.FUNCTION, RoleDetail.FUNCTION, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(RoleDetail.ROLE, roleList));
			detachedCriteria.addOrder(Order.desc(RoleDetail.TREE_ITEM_ACTION));
			List<RoleDetail> roleDetailList = roleDetailService.getByDetachedCriteria(detachedCriteria);
			// 去除重复的菜单，并进行整合
			Map<String, List<String>> treeMaps = new HashMap<String, List<String>>();
			for (RoleDetail roleDetail : roleDetailList) {
				Integer roleId = roleDetail.getRole().getId();
				List<String> list = new ArrayList<String>();
				if (roleDetail.getFunction() != null) {
					for (RoleDetail detail : roleDetailList) {
						if (roleId.equals(detail.getRole().getId()) && roleDetail.getTreeItem().getId().equals(detail.getTreeItem().getId())) {
							list.add(detail.getFunction().getLabel());
						}
					}
				} else {
					if (roleDetail.getFunction() != null) {
						list.add(roleDetail.getFunction().getLabel());
					}
				}
				treeMaps.put(roleId + Constants.COMMA + roleDetail.getTreeItem().getLabel() + Constants.COMMA + roleDetail.getTreeItem().getId(), list);
			}
			for (Role role : roleList) {
				StringBuilder sb = new StringBuilder();
				for (Entry<String, List<String>> roleDetail : treeMaps.entrySet()) {
					String[] split = roleDetail.getKey().split(Constants.COMMA);
					if (split[0].equals(role.getId().toString())) {
						sb.append("【");
						sb.append(split[1]);
						if (!roleDetail.getValue().isEmpty()) {
							sb.append("：（");
							sb.append(StringUtil.join(roleDetail.getValue().toArray(), Constants.COMMA));
							sb.append("）");
						}
						sb.append("】");
					}
				}
				role.setRoles(sb.toString());
			}
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人角色管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.ROLE_MANAGE;
	}

	/**
	 * set roleDetailService
	 * @param roleDetailService the roleDetailService to set
	 */
	public void setRoleDetailService(RoleDetailService roleDetailService) {
		this.roleDetailService = roleDetailService;
	}

	/**
	 * set roleService
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get roleManageDto
	 * @return the roleManageDto
	 */
	public RoleManageDto getRoleManageDto() {
		return roleManageDto;
	}

	/**
	 * set roleManageDto
	 * @param roleManageDto the roleManageDto to set
	 */
	public void setRoleManageDto(RoleManageDto roleManageDto) {
		this.roleManageDto = roleManageDto;
	}

	/**
	 * get roleList
	 * @return the roleList
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * set roleList
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public Role[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(Role[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
