package com.qylm.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.utils.StringUtil;
import com.qylm.entity.BaseEntity;
import com.qylm.entity.TreeItem;
import com.qylm.entity.User;

/**
 * 共通方法
 * @author
 */
public class MothedUtil {
	
	/**
	 * 此方法用于构建dTree，在页面上必须有openCreatePage(id)的js
	 * @param obj 二维数组值序列{(本级)id, (上级)pid, (标题名称)name, url, title, target, (图标路径)icon, iconOpen, open}
	 * @return 字符串
	 */
	public static String getDtree(Object[][] obj) {
		return getDtree(obj, false, null, false);
	}
	
	/**
	 * 此方法用于构建带复选框的dTree
	 * @param obj 二维数组值序列{(本级)id, (上级)pid, (标题名称)name, url, title, target, (图标路径)icon, iconOpen, open}
	 * @return 字符串
	 */
	public static String getCheckboxesDtree(Object[][] obj) {
		return getDtree(obj, true, null, false);
	}
	
	/**
	 * 此方法用于构建带复选框的dTree，复选框普通选择
	 * @param obj 二维数组值序列{(本级)id, (上级)pid, (标题名称)name, url, title, target, (图标路径)icon, iconOpen, open}
	 * @return 字符串
	 */
	public static String getCommonCheckboxesDtree(Object[][] obj) {
		return getDtree(obj, true, null, true);
	}
	
	/**
	 * 此方法用于构建带复选框的dTree，并默认选中某些
	 * @param obj 二维数组值序列{(本级)id, (上级)pid, (标题名称)name, url, title, target, (图标路径)icon, iconOpen, open}
	 * @param idList 需要默认选中的报表ID集合
	 * @param commonChoice 复选框选择状态，true普通选择没有事件
	 * @return 字符串
	 */
	public static String getCheckboxesDtreeDefaultChoice(Object[][] obj, List<Object> idList, boolean commonChoice) {
		return getDtree(obj, true, idList, commonChoice);
	}
	
	/**
	 * @param treeItemllAllList 所有菜单集合
	 * @param idList 需要默认选中的报表ID集合
	 * 此方法用于构建dhtmlxtree
	 * @return 字符串
	 */
	public static String getDHTMLXTreeStr(List<TreeItem> treeItemllAllList, List<Object> idList, boolean commonChoice){
		StringBuffer sb = new StringBuffer();
		sb.append("\"<?xml version=\'1.0\' encoding=\'iso-8859-1\'?>");
		if (!treeItemllAllList.isEmpty()) {
			int size = treeItemllAllList.size();
			sb.append("<tree id=\'0\'>");
			TreeItem treeItem;
			List<TreeItem> treeItemllSonList;
			for (int i = 0; i < size; i++) { //拼接第一层菜单字符串
				treeItem = treeItemllAllList.get(i);
				sb.append("<item text=\'"+treeItem.getLabel()+"\' id=\'"+treeItem.getNodeId()+"\' open=\'0\' "+toTreeIttemTo(idList, treeItem)+">");
					treeItemllSonList = treeItem.getChildren();	
					if(treeItemllSonList != null){
						for (int j = 0; j < treeItemllSonList.size(); j++) {//拼接第二层菜单字符串
							TreeItem treeItemSon = treeItemllSonList.get(j);
							sb.append("<item text=\'"+treeItemSon.getLabel()+"\' id=\'"+treeItemSon.getNodeId()+"\' "+toTreeIttemTo(idList, treeItemSon)+">");
								if(treeItemSon.getChildren() != null){
									for (int jj = 0; jj < treeItemSon.getChildren().size(); jj++) {//拼接第三层菜单字符串
										TreeItem treeItemSons = treeItemSon.getChildren().get(jj);
										sb.append("<item text=\'"+treeItemSons.getLabel()+"\' id=\'"+treeItemSons.getId()+"=other"+"\' "+toTreeIttemTo(idList, treeItemSons)+">");
										sb.append("</item>");
									}
								}
								
							sb.append("</item>");
						}
					}
				sb.append("</item>");
			}
			sb.append("</tree>\"");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private static String toTreeIttemTo(List<Object> idList, TreeItem treeItem){
		String checkStr="";
		if (idList != null && !idList.isEmpty()) {
			for (int j = 0; j < idList.size(); j++) {
				Object one = idList.get(j);
				if(StringUtil.isEquals(one.toString(), treeItem.getNodeId().toString())){
					checkStr="checked=\'-1\'";
				}
			}
		}
		return checkStr;
	}
	
	/**
	 * 此方法用于构建dTree
	 * @param obj 二维数组值序列{(本级)id, (上级)pid, (标题名称)name, url, title, target, (图标路径)icon, iconOpen, open}
	 * @param chockBox 是否需要复选框 true 需要反之不需要
	 * @param idList 需要默认选中的报表ID
	 * @param commonChoice 复选框选择状态，true普通选择没有事件
	 * @return 字符串
	 */
	private static String getDtree(Object[][] obj, boolean chockBox, List<Object> idList, boolean commonChoice) {
		StringBuffer sb = new StringBuffer();
		sb.append("d=new dTree(\"d\");\n");
		if (chockBox) {
			sb.append("d.config.useCheckbox = true;");
		}
		if (commonChoice) {
			sb.append("d.config.useCheckboxState = true;");
		}
		if (obj != null) {
			int length = obj.length;
			Object[] object;
			sb.append("d.add(0, '-1', \"功能菜单列表\", \"javascript: openCreatePage('-1');\", \"\", \"\", \"\", \"\", \"\", \"\");");
			for (int i = 1; i < length; i++) {
				object = obj[i];
				sb.append("d.add(");
				Object obj2 = object[0];
				sb.append("'" + obj2 + "', '");
				if (StringUtil.isObjBlank(object[1])) {
					sb.append("', \"");
				} else {
					sb.append(object[1] + "', \"");
				}
				if (StringUtil.isObjBlank(object[2])) {
					sb.append("\", \"");
				} else {
					sb.append(object[2] + "\", \"");
				}
				if (!StringUtil.isObjBlank(object[3])) {
					sb.append(object[3]);
				}
				sb.append("\", \"" + object[4] + "\", \"" + object[5] + "\", \""
						+ object[6] + "\", \"" + object[7] + "\", \"" + object[8] + "\"");
				if (idList != null && !idList.isEmpty()) {
					int size = idList.size();
					Object id;
					boolean state = false;;
					for (int j = 0; j < size; j++) {
						id = idList.get(j);
						if (StringUtil.isEquals(obj2, id)) {
							sb.append(", true");
							state = true;
							break;
						}
					}
					if (!state) {
						sb.append(", \"\"");
					}
				} else {
					sb.append(", \"\"");
				}
				sb.append(");\n");
			}
			sb.append("document.write(d);");
		}
		return sb.toString();
	}
	
	/**
	 * 根据登录用户，获取到用户的上级
	 * @param user
	 * @param state true公司数据共享，反之不共享
	 * @return
	 */
	public static DetachedCriteria getBelongingUser(DetachedCriteria detachedCriteria, User user) {
		return getBelongingUser(detachedCriteria, user, true);
	}
	
	/**
	 * 根据登录用户，获取到用户的上级
	 * @param user
	 * @param state true公司数据共享，反之不共享
	 * @return
	 */
	public static DetachedCriteria getBelongingUser(DetachedCriteria detachedCriteria, User user, boolean state) {
		detachedCriteria.createAlias(BaseEntity.CREATER, BaseEntity.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(BaseEntity.BELONGING_USER, BaseEntity.BELONGING_USER, JoinType.LEFT_OUTER_JOIN);
		List<User> subordinateList = new ArrayList<User>();
		subordinateList.addAll(user.getSubordinateList());
		String userlevel = user.getUserlevel();
		// 如果是公司级别
		if (User.USER_LEVEL_2.equals(userlevel)) {
			subordinateList.add(user);
			detachedCriteria.add(Restrictions.in(BaseEntity.BELONGING_USER, subordinateList));
		} else if (User.USER_LEVEL_4.equals(userlevel)) {
			subordinateList.add(user);
			if (state) {
				subordinateList.add(user.getBelongingUser());
			}
			detachedCriteria.add(Restrictions.in(BaseEntity.BELONGING_USER, subordinateList));
		} else if (User.USER_LEVEL_3.equals(userlevel) || User.USER_LEVEL_5.equals(userlevel)) {
			
			detachedCriteria.add(Restrictions.in(BaseEntity.BELONGING_USER, subordinateList));
		}
		return detachedCriteria;
	}
	
	/**
	 * 根据用户进行，填写归属上级
	 * @param user
	 * @return
	 */
	public static User getBelongingUser(User user) {
		String userlevel = user.getUserlevel();
		if (User.USER_LEVEL_2.equals(userlevel) || User.USER_LEVEL_4.equals(userlevel)) {
			return user;
		}
		return user.getBelongingUser();
	}
	
	/**
	 * 是否可删除信息
	 * 是系统管理员，又是本人创建才可以删除
	 * true不可删除，反之可以
	 * @param user 登录用户
	 * @param Create 信息建立者
	 * @return
	 */
	public static boolean getDeleteInfo(User user, User create) {
		if (User.USER_LEVEL_3.equals(user.getUserlevel())) {
			return !user.getId().equals(create.getId());
		}
		return false;
	}
}
