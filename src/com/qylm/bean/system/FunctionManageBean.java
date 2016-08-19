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
import com.qylm.constants.Constants;
import com.qylm.dto.system.FunctionManageDto;
import com.qylm.dxo.FunctionManageDxo;
import com.qylm.entity.Function;
import com.qylm.entity.TreeItem;
import com.qylm.service.FunctionService;
import com.qylm.service.TreeItemService;

/**
 * 功能管理画面managedBean
 * @author 
 */
@ManagedBean
@RequestScoped
public class FunctionManageBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5973883638808046368L;
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(FunctionManageBean.class);
	
	/**
	 * 功能管理画面的bean
	 */
	private FunctionManageDto functionManageDto = new FunctionManageDto();

	/**
	 * 功能列表（检索结果）
	 */
	private List<Function> functionList;
	
	/**
	 * 功能列表
	 */
	private String posts;
	
	/**
	 * 登陆用户信息
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;

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
	 * 取得功能的第一页信息和部门下拉框，岗位下拉框
	 * 
	 * @return
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能功能_功能管理】按钮");
		getFunctions();
		return Navigation.FUNCTION_MANAGE;
	}

	/**
	 * 功能管理的新建按钮
	 * @return
	 */
	public void createFunction() {
		Tool.sendLog(LOG, userBean, "按下【功能管理画面_新建】按钮");
		functionManageDto.setFunctionId(null);
		functionManageDto.setLabel(null);
		functionManageDto.setEnable(false);
		functionManageDto.setRank(null);
	}
	
	/**
	 * 功能管理的修改按钮
	 * @return
	 */
	public void upateFunction() {
		Tool.sendLog(LOG, userBean, "按下【功能管理画面_修改】按钮");
	}
	
	/**
	 * 功能管理的保存按钮
	 * @return
	 */
	public void saveFunction() {
		Tool.sendLog(LOG, userBean, "按下【功能管理画面_新建】按钮");
		Function function;
		Integer functionId = functionManageDto.getFunctionId();
		if (functionId == null) {
			function = new Function();
			FunctionManageDxo.dtoToEntity(functionManageDto, function);
			function.setCreateDate(DateUtil.getNowyyyymm());
			function.setCreater(userBean.getUser());
			function.setTreeItem(treeItemService.getById(functionManageDto.getTreeItemId()));
			functionService.saveEntity(function);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			function = functionService.getById(functionId);
			FunctionManageDxo.dtoToEntity(functionManageDto, function);
			functionService.updateEntity(function);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
		getFunctions();
	}

	/**
	 * 删除按钮
	 * @return 画面不跳转
	 */
	public void deleteFunction() {
		Tool.sendLog(LOG, userBean, "按下【功能管理画面_删除】按钮");
		if (functionManageDto.getFunctionId() != null) {
			functionService.deleteEntity(functionService.getById(functionManageDto.getFunctionId()));
			getFunctions();
			create();
		}
	}

	/**
	 * 获取到功能信息，并进行树形显示
	 */
	private void getFunctions() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
		detachedCriteria.addOrder(Order.asc(Function.RANK));
		List<Function> functionList = functionService.getByDetachedCriteria(detachedCriteria);
		detachedCriteria = DetachedCriteria.forClass(TreeItem.class);
		detachedCriteria.addOrder(Order.asc(TreeItem.ORDER));
		List<TreeItem> treeItemList = treeItemService.getByDetachedCriteria(detachedCriteria);
		int size = treeItemList.size();
		int postSize = functionList.size();
		TreeItem treeItem;
		Object obj[][] = new Object[size + 1 + postSize][9];
		obj[0] = new Object[]{ "0", "-1", "功能模块列表", "", "", "", "", "", ""};
		int k = 1;
		Function function;
		for (int i = 0; i < size; i++) {
			treeItem = treeItemList.get(i);
			String nodeId = treeItem.getNodeId();
			String superiorId = null;
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
							  "javascript: openCreatePage('" 
							+ function.getId() + Constants.EQUAL
							+ function.getLabel() + Constants.EQUAL
							+ function.isEnable() + Constants.EQUAL
							+ function.getRank() + Constants.EQUAL 
							+ treeItem.getLabel() + "');", "", "", "", "", ""};
					k++;
				}
			}
		}
		posts = MothedUtil.getDtree(obj);
	}
	
	/**
	 * 清空信息
	 */
	private void create() {
		functionManageDto.setTreeItemId(null);
		functionManageDto.setFunctionId(null);
		functionManageDto.setLabel(null);
		functionManageDto.setEnable(false);
		functionManageDto.setRank(null);
		functionManageDto.setTreeItemName(null);
	}
	
	/**
	 * @param treeItemService the treeItemService to set
	 */
	public void setTreeItemService(TreeItemService treeItemService) {
		this.treeItemService = treeItemService;
	}

	/**
	 * set functionService
	 * @param functionService the functionService to set
	 */
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
 
	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get functionList
	 * @return the functionList
	 */
	public List<Function> getFunctionList() {
		return functionList;
	}

	/**
	 * set functionList
	 * @param functionList the functionList to set
	 */
	public void setFunctionList(List<Function> functionList) {
		this.functionList = functionList;
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

	/**
	 * @return the functionManageDto
	 */
	public FunctionManageDto getFunctionManageDto() {
		return functionManageDto;
	}

	/**
	 * @param functionManageDto the functionManageDto to set
	 */
	public void setFunctionManageDto(FunctionManageDto functionManageDto) {
		this.functionManageDto = functionManageDto;
	}

}
