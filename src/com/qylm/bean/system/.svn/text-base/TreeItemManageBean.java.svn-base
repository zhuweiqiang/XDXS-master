package com.qylm.bean.system;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.qylm.bean.UserBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.system.TreeItemManageDto;
import com.qylm.dxo.TreeItemManageDxo;
import com.qylm.entity.TreeItem;
import com.qylm.menu.TreeItemData;
import com.qylm.service.TreeItemService;

/**
 * 菜单管理画面managedBean
 * @author 
 */
@ManagedBean
@RequestScoped
public class TreeItemManageBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5973883638808046368L;
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(TreeItemManageBean.class);
	
	/**
	 * 菜单管理画面的bean
	 */
	private TreeItemManageDto treeItemManageDto = new TreeItemManageDto();

	/**
	 * 菜单列表（检索结果）
	 */
	private List<TreeItem> treeItemList;
	
	/**
	 * 菜单列表
	 */
	private String meuns;
	
	/**
	 * 登陆用户信息
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;

	/**
	 * 菜单列表
	 */
	@ManagedProperty(value = "#{treeItemService}")
	private TreeItemService treeItemService;
	
	/**
	 * 取得菜单的第一页信息和部门下拉框，岗位下拉框
	 * 
	 * @return
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_菜单管理】按钮");
		getTreeItems();
		return Navigation.TREE_ITEM_MANAGE;
	}

	/**
	 * 菜单管理的新建按钮
	 * @return
	 */
	public void createTreeItem() {
		Tool.sendLog(LOG, userBean, "按下【菜单管理画面_新建】按钮");
		treeItemManageDto.setAction(null);
		treeItemManageDto.setTreeItemId(null);
		treeItemManageDto.setDisplayChildRen(false);
		treeItemManageDto.setLabel(null);
		treeItemManageDto.setOrder(null);
		treeItemManageDto.setTarget(null);
		treeItemManageDto.setSuperiorNodeId(treeItemManageDto.getNodeId());
		treeItemManageDto.setNodeId(null);
		treeItemManageDto.setNodeType("1");
	}
	
	/**
	 * 菜单管理的保存按钮
	 * @return
	 */
	public void saveTreeItem() {
		Tool.sendLog(LOG, userBean, "按下【菜单管理画面_新建】按钮");
		TreeItem treeItem;
		Integer treeItemId = treeItemManageDto.getTreeItemId();
		if (treeItemId == null) {
			treeItem = new TreeItem();
			TreeItemManageDxo.dtoToEntity(treeItemManageDto, treeItem);
			treeItem.setCreateDate(DateUtil.getNowyyyymm());
			treeItem.setCreater(userBean.getUser());
			treeItem.setNodeType(treeItemManageDto.getNodeType());
			// 上级id不为空
			if (StringUtil.isNotBlank(treeItemManageDto.getSuperiorNodeId())) {
				treeItem.setNodeId(treeItemManageDto.getSuperiorNodeId() + Constants.UNDERLINE + treeItemManageDto.getNodeId());
			}
			if (StringUtil.isBlank(treeItem.getAction())) {
				treeItem.setAction(null);
			}
			treeItemService.saveEntity(treeItem);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			treeItem = treeItemService.getById(treeItemId);
			TreeItemManageDxo.dtoToEntity(treeItemManageDto, treeItem);
			if (StringUtil.isBlank(treeItem.getAction())) {
				treeItem.setAction(null);
			}
			treeItemService.updateEntity(treeItem);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
		getTreeItems();
		// 为TreeItemData内的treeItemList重新赋值
		TreeItemData.treeItemList = TreeItemData.getAllTreeItems();
	}

	/**
	 * 删除按钮
	 * @return 画面不跳转
	 */
	public void deleteTreeItem() {
		Tool.sendLog(LOG, userBean, "按下【菜单管理画面_删除】按钮");
		if (treeItemManageDto.getTreeItemId() != null) {
			treeItemService.deleteTreeItem(treeItemService.getById(treeItemManageDto.getTreeItemId()));
			getTreeItems();
			create();
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 获取到菜单信息，并进行树形显示
	 */
	private void getTreeItems() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
		detachedCriteria.addOrder(Order.asc(TreeItem.ORDER));
		treeItemList = treeItemService.getByDetachedCriteria(detachedCriteria);
		int size = treeItemList.size();
		Object obj[][] = new Object[size + 1][9];
		obj[0] = new Object[]{};
		int k = 1;
		TreeItem treeItem;
		for (int i = 0; i < size; i++) {
			treeItem = treeItemList.get(i);
			String nodeId = treeItem.getNodeId();
			String superiorId = null;
			if (nodeId.lastIndexOf(Constants.UNDERLINE) != -1) {
				superiorId = nodeId.substring(0, nodeId.lastIndexOf(Constants.UNDERLINE));
			}
			obj[k] = new Object[]{nodeId, superiorId, treeItem.getLabel(), 
					  "javascript: openCreatePage('" + choickValue(treeItem, superiorId) + "');", "", "", "", "", ""};
			k++;
		}
		meuns = MothedUtil.getDtree(obj);
	}
	
	/**
	 * 拼接出事件值
	 * @param treeItem
	 * @param superiorId
	 * @return
	 */
	private String choickValue(TreeItem treeItem, String superiorId) {
		StringBuilder sb = new StringBuilder(128);
		sb.append(treeItem.getId() + Constants.EQUAL);
		sb.append(StringUtil.toStringCheckNull(treeItem.getNodeId()) + Constants.EQUAL);
		sb.append(StringUtil.toStringCheckNull(superiorId) + Constants.EQUAL);
		sb.append(StringUtil.toStringCheckNull(treeItem.getLabel()) + Constants.EQUAL);
		sb.append(StringUtil.toStringCheckNull(treeItem.getTarget()) + Constants.EQUAL);
		sb.append(StringUtil.toStringCheckNull(treeItem.getAction()) + Constants.EQUAL);
		sb.append(StringUtil.toStringCheckNull(treeItem.getOrder())+ Constants.EQUAL);
		sb.append(treeItem.isDisplayChildRen()+ Constants.EQUAL);
		sb.append(treeItem.getNodeType());
		return sb.toString();
	}
	
	/**
	 * 清空信息
	 */
	private void create() {
		treeItemManageDto.setAction(null);
		treeItemManageDto.setTreeItemId(null);
		treeItemManageDto.setDisplayChildRen(false);
		treeItemManageDto.setLabel(null);
		treeItemManageDto.setOrder(null);
		treeItemManageDto.setTarget(null);
		treeItemManageDto.setSuperiorNodeId(null);
		treeItemManageDto.setNodeId(null);
		treeItemManageDto.setNodeType("1");
	}
	
	/**
	 * set treeItemService
	 * @param treeItemService the treeItemService to set
	 */
	public void setTreeItemService(TreeItemService treeItemService) {
		this.treeItemService = treeItemService;
	}
 
	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get treeItemList
	 * @return the treeItemList
	 */
	public List<TreeItem> getTreeItemList() {
		return treeItemList;
	}

	/**
	 * set treeItemList
	 * @param treeItemList the treeItemList to set
	 */
	public void setTreeItemList(List<TreeItem> treeItemList) {
		this.treeItemList = treeItemList;
	}

	/**
	 * @return the meuns
	 */
	public String getMeuns() {
		return meuns;
	}

	/**
	 * @param meuns the meuns to set
	 */
	public void setMeuns(String meuns) {
		this.meuns = meuns;
	}

	/**
	 * @return the treeItemManageDto
	 */
	public TreeItemManageDto getTreeItemManageDto() {
		return treeItemManageDto;
	}

	/**
	 * @param treeItemManageDto the treeItemManageDto to set
	 */
	public void setTreeItemManageDto(TreeItemManageDto treeItemManageDto) {
		this.treeItemManageDto = treeItemManageDto;
	}

}
