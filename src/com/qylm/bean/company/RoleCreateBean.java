package com.qylm.bean.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.company.RoleCreateDto;
import com.qylm.dxo.RoleCreateDxo;
import com.qylm.entity.Function;
import com.qylm.entity.Role;
import com.qylm.entity.RoleDetail;
import com.qylm.entity.TreeItem;
import com.qylm.entity.User;
import com.qylm.service.FunctionService;
import com.qylm.service.RoleDetailService;
import com.qylm.service.RoleService;
import com.qylm.service.TreeItemService;

/**
 * 角色登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class RoleCreateBean implements CreateBean<Role>, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5506422996436968912L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(RoleCreateBean.class);

	/**
	 * 存放角色登陆画面需要保存的值
	 */
	private RoleCreateDto roleCreateDto = new RoleCreateDto();
	
	/**
	 * 功能列表
	 */
	private String posts;

	/**
	 * 角色bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 角色业务类
	 */
	@ManagedProperty(value="#{roleService}")
	private RoleService roleService;
	
	/**
	 * 角色业务详细类
	 */
	@ManagedProperty(value = "#{roleDetailService}")
	private RoleDetailService roleDetailService;
	
	/**
	 * 功能列表
	 */
	@ManagedProperty(value = "#{functionService}")
	private FunctionService functionService;
	
	/**
	 * 菜单列表
	 */
	@ManagedProperty(value = "#{treeItemService}")
	private TreeItemService treeItemService;

	/**
	 * 此方法绑定于角色登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个角色
	 * @return 角色登陆画面
	 */
	public String newRole() {
		Tool.sendLog(LOG, userBean, "【角色登陆画面_新建按钮】");
		roleCreateDto.setRoleName(null);
		roleCreateDto.setDescription(null);
		roleCreateDto.setCheck(null);
		roleCreateDto.setRoleDetailList(null);
		roleCreateDto.setCreater(null);
		roleCreateDto.setBelongingUser(null);
		roleCreateDto.setTransferRole(null);
		return Navigation.ROLE_CREATE;
	}
	
	/**
	 * 此方法绑定于角色登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【角色登陆画面_返回按钮】");
		return roleCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于角色登陆画面的保存按钮 
	 * 实现功能：根据transferRole对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveRole() {
		Tool.sendLog(LOG, userBean, "【角色登陆画面_保存按钮】");
		Role transferRole = roleCreateDto.getTransferRole();
		if (transferRole == null) {
			transferRole = new Role();
			roleCreateDto.setCreater(userBean.getUser());
			roleCreateDto.setBelongingUser(userBean.getUser().getBelongingUser());
			create(transferRole);
			transferRole.setCreateDate(DateUtil.getNowyyyymmdd());
			roleService.saveRole(transferRole, roleCreateDto.getRoleDetailList());
			roleCreateDto.setTransferRole(transferRole);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferRole);
			transferRole.setUpdateDate(DateUtil.getNowyyyymmdd());
			roleService.updateRole(transferRole, roleCreateDto.getRoleDetailList());
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
		getFunctions();
	}
	
	/**
	 * 赋值
	 * @param transferRole
	 */
	private void create(Role transferRole) {
		String check = roleCreateDto.getCheck();
		if (StringUtil.isNotBlank(check)) {
			String[] split = check.split(Constants.COMMA);
			// 解析角色权限，系统特定数字为功能，其他为菜单
			List<Integer> functionIdList = new ArrayList<Integer>();
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < split.length; i++) {
				if(!StringUtil.isBlank(split[i])){
					int nums = split[i].lastIndexOf(Constants.EQUAL);
					if(nums == -1){
						list.add(split[i]);
					}else{
						String id = split[i].substring(0, split[i].lastIndexOf(Constants.EQUAL));
						functionIdList.add(Integer.valueOf(id));
					}
				}
				
			}
			// 获取菜单
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
			detachedCriteria.add(Restrictions.in(TreeItem.NODE_ID, list));
			List<TreeItem> treeItemList = treeItemService.getByDetachedCriteria(detachedCriteria);
			// 获取功能
			List<Function> functionList = null;
			if(functionIdList != null && !functionIdList.isEmpty()){
				detachedCriteria = DetachedCriteria.forClass(Function.class);
				detachedCriteria.createAlias(Function.TREE_ITEM, Function.TREE_ITEM, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.in(Function.BASE_ID, functionIdList));
				functionList = functionService.getByDetachedCriteria(detachedCriteria);
			}
			
			if (!treeItemList.isEmpty()) {
				List<RoleDetail> roleDetailList = new ArrayList<RoleDetail>();
				roleCreateDto.setRoleDetailList(roleDetailList);
				RoleDetail roleDetail;
				for (TreeItem treeItem : treeItemList) {
					// 添加对应的功能
					boolean state = false;
					if (functionList != null && !functionList.isEmpty()) {
						for (Function function : functionList) {
							if (function.getTreeItem().getId().equals(treeItem.getId())) {
								roleDetail = new RoleDetail();
								roleDetail.setCreater(userBean.getUser());
								roleDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
								roleDetail.setTreeItem(treeItem);
								roleDetail.setRole(transferRole);
								roleDetail.setFunction(function);
								roleDetailList.add(roleDetail);
								state = true;
							}
						}
					}
					if (!state) {
						roleDetail = new RoleDetail();
						roleDetail.setCreater(userBean.getUser());
						roleDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
						roleDetail.setTreeItem(treeItem);
						roleDetail.setRole(transferRole);
						roleDetailList.add(roleDetail);
					}
				}
			}
		}
		RoleCreateDxo.dtoToEntity(roleCreateDto, transferRole);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		roleCreateDto.setReturner(returner);
		getFunctions();
		return Navigation.ROLE_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, Role role) {
		roleCreateDto.setReturner(returner);
		RoleCreateDxo.entityToDto(role, roleCreateDto);
		roleCreateDto.setTransferRole(role);
		getFunctions();
		return Navigation.ROLE_CREATE;
	}
	
	/**
	 * 获取到功能信息，并进行树形显示
	 */
	private void getFunctions() {
		// 本来存在什么权限就获取什么权限，除超级管理员外
		List<Integer> functionIdList = new ArrayList<Integer>();
		List<Integer> treeItemIdList = new ArrayList<Integer>();
		if (!User.USER_LEVEL_1.equals(userBean.getUser().getUserlevel())) {
			List<RoleDetail> roleDetailList = userBean.getUser().getRoleDetailList();
			List<Integer> idList = new ArrayList<Integer>();
			for (RoleDetail roleDetail : roleDetailList) {
				idList.add(roleDetail.getId());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(RoleDetail.class);
			detachedCriteria.add(Restrictions.in(RoleDetail.BASE_ID, idList));
			List<RoleDetail> detailList = roleDetailService.getByDetachedCriteria(detachedCriteria);
			for (RoleDetail roleDetail : detailList) {
				if (roleDetail.getFunction() != null) {
					functionIdList.add(roleDetail.getFunction().getId());
				}
				if (roleDetail.getTreeItem() != null) {
					treeItemIdList.add(roleDetail.getTreeItem().getId());
				}
			}
		}
		List<Function> functionList;
		List<TreeItem> treeItemList;
		if (User.USER_LEVEL_1.equals(userBean.getUser().getUserlevel())) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
			detachedCriteria.add(Restrictions.eq(Function.ENABLE, false));
			detachedCriteria.addOrder(Order.asc(Function.RANK));
			
			functionList = functionService.getByDetachedCriteria(detachedCriteria);
			detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
			detachedCriteria.add(Restrictions.eq(TreeItem.DISPLAY_CHILD_REN, false));
			detachedCriteria.addOrder(Order.asc(TreeItem.ORDER));
			treeItemList = treeItemService.getByDetachedCriteria(detachedCriteria);
		} else {
			if (functionIdList.isEmpty()) {
				functionList = new ArrayList<Function>();
			} else {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
				detachedCriteria.add(Restrictions.eq(Function.ENABLE, false));
				detachedCriteria.add(Restrictions.in(Function.BASE_ID, functionIdList));
				detachedCriteria.addOrder(Order.asc(Function.RANK));
				functionList = functionService.getByDetachedCriteria(detachedCriteria);
			}
			if (treeItemIdList.isEmpty()) {
				treeItemList = new ArrayList<TreeItem>();
			} else{
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
				detachedCriteria.add(Restrictions.eq(TreeItem.DISPLAY_CHILD_REN, false));
				detachedCriteria.add(Restrictions.in(TreeItem.BASE_ID, treeItemIdList));
				detachedCriteria.addOrder(Order.asc(TreeItem.ORDER));
				treeItemList = treeItemService.getByDetachedCriteria(detachedCriteria);
			}
		}
		
		int size = treeItemList.size();
		int postSize = functionList.size();
		TreeItem treeItem;
		TreeItem treeItemSon;
		//Object obj[][] = new Object[size + 1 + postSize][9];
		//obj[0] = new Object[]{ "0", "-1", "功能模块列表", "", "", "", "", "", ""};
		
		//
		List<TreeItem> treeItemallSon;
		List<TreeItem> treeItemallSonFunctionList;
		List<TreeItem> treeItemAll = new ArrayList<TreeItem>(); // 菜单总集合
		
		Function function;
		for (int i = 0; i < size; i++) {
			treeItem = treeItemList.get(i);
			String superiorId = null;
			if(StringUtil.isBlank(treeItem.getAction())){ //如果action为空 当前菜单就是第一层菜单
				treeItemAll.add(treeItem);
				treeItemallSon = new ArrayList<TreeItem>(); //子菜单
				for (int kk = 0; kk < size; kk++) {
					treeItemSon = treeItemList.get(kk);
					String nodeIdSon = treeItemSon.getNodeId();
					if(StringUtil.isNotBlank(treeItemSon.getAction())){ //如果action不为空 当前菜单就是子菜单
						superiorId = nodeIdSon.substring(0, nodeIdSon.lastIndexOf(Constants.UNDERLINE));
						if(StringUtil.isEquals(superiorId, treeItem.getNodeId())){ // 判断当前nodeid是否和父类相同，相同的话就添加到子项菜单集合中
							treeItemallSonFunctionList = new ArrayList<TreeItem>();
							for (int j = 0; j < postSize; j++) {
								function = functionList.get(j);
								if (treeItemSon.getId().intValue() == function.getTreeItem().getId().intValue()) {
									TreeItem treeItemSonFunction = new TreeItem();
									treeItemSonFunction.setLabel(function.getLabel());
									treeItemSonFunction.setId(function.getId());
//									treeItemSonFunction.setNodeId(superiorId);
									treeItemSonFunction.setNodeId(function.getId().toString());
									treeItemallSonFunctionList.add(treeItemSonFunction);
								}
							}
							treeItemSon.setChildren(treeItemallSonFunctionList);
							treeItemallSon.add(treeItemSon);
						}
					}
				}
				treeItem.setChildren(treeItemallSon);
			}
			/**
			if (nodeId.lastIndexOf(Constants.UNDERLINE) != -1) {
				superiorId = nodeId.substring(0, nodeId.lastIndexOf(Constants.UNDERLINE));
			}
			obj[k] = new Object[]{nodeId, superiorId, treeItem.getLabel(), 
					  "javascript: openMeun('"
					+ treeItem.getId() + Constants.EQUAL 
					+ treeItem.getLabel() + "');", "", "", "", "", ""};
			k++;
			for (int j = 0; j < postSize; j++) {
				function = functionList.get(j);
				if (treeItem.getId().equals(function.getTreeItem().getId())) {
					obj[k] = new Object[]{function.getId(), nodeId, function.getLabel(), 
							  "javascript: openCreatePage('" + function.getId() + "');", "", "", "", "", ""};
					k++;
				}
			}
			**/
			
		}
		if (roleCreateDto.getTransferRole() != null) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(RoleDetail.class);
			detachedCriteria.add(Restrictions.eq(RoleDetail.ROLE, roleCreateDto.getTransferRole()));
			detachedCriteria.createAlias(RoleDetail.TREE_ITEM, RoleDetail.TREE_ITEM, JoinType.LEFT_OUTER_JOIN);
			List<RoleDetail> roleDetailList = roleDetailService.getByDetachedCriteria(detachedCriteria);
			int c = roleDetailList.size();
			List<Object> strList = new ArrayList<Object>();
			for (int i = 0; i < c; i++) {
				RoleDetail roleDetail = roleDetailList.get(i);
				strList.add(roleDetail.getTreeItem().getNodeId());
				if (roleDetail.getFunction() != null) {
					strList.add(roleDetail.getFunction().getId());
				}
			}
			//posts = MothedUtil.getCheckboxesDtreeDefaultChoice(obj, strList, false);
			
			posts = MothedUtil.getDHTMLXTreeStr(treeItemAll, strList, false);
		} else {
//			posts = MothedUtil.getCheckboxesDtree(obj);
			posts = MothedUtil.getDHTMLXTreeStr(treeItemAll, null, false);
		}
		
	}

	/**
	 * @param functionService the functionService to set
	 */
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	/**
	 * @param treeItemService the treeItemService to set
	 */
	public void setTreeItemService(TreeItemService treeItemService) {
		this.treeItemService = treeItemService;
	}

	/**
	 * set roleService
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @param roleDetailService the roleDetailService to set
	 */
	public void setRoleDetailService(RoleDetailService roleDetailService) {
		this.roleDetailService = roleDetailService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get roleCreateDto
	 * @return the roleCreateDto
	 */
	public RoleCreateDto getRoleCreateDto() {
		return roleCreateDto;
	}

	/**
	 * set roleCreateDto
	 * @param roleCreateDto the roleCreateDto to set
	 */
	public void setRoleCreateDto(RoleCreateDto roleCreateDto) {
		this.roleCreateDto = roleCreateDto;
	}

	/**
	 * @return the posts
	 */
	public String getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(String posts) {
		this.posts = posts;
	}

}
