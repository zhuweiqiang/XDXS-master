package com.qylm.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.entity.RoleDetail;
import com.qylm.entity.User;

/**
 * 用户信息managedBean
 * @author 
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6648855452594508987L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(UserBean.class);

	/**
	 * 用户
	 */
	private User user;
	
	/**
	 * 手机登录
	 */
	private boolean mobile;
	
	/**
	 * 退出
	 * @return
	 */
	public void loginOut() {
		Tool.sendLog(LOG, this, "退出");
		user = null;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/XDXS" + Navigation.EXCEPTION_HANDLER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 后台登录
	 * @param u
	 * @return
	 */
	public String login(User u) {
		user = u;
		Tool.sendLog(LOG, this, "成功登陆");
		return Navigation.MAIN;
	}
	
	public String getLoginErrorMessage() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if(sessionMap.containsKey(Constants.SESSION_TIME_OUT)){
			sessionMap.remove(Constants.SESSION_TIME_OUT);
			return "<span class='error'>因长时间未操作，您已退出本系统，请再次登陆</span>";
		} else if(sessionMap.containsKey(Constants.NOT_LOGIN)){
			sessionMap.remove(Constants.NOT_LOGIN);
			return "<span class='error'>您还没有登陆，请登陆</span>";
		}
		return null;
	}
	
	/**
	 * 根据输入的菜单节点和功能名称来验证页面的按钮显示状态
	 * @param nodeId 菜单节点
	 * @param functionName 功能名称
	 * @return
	 */
	public boolean isCheckPermission(String nodeId, String functionName) {
		// 系统管理员免验证
		if (User.USER_LEVEL_1.equals(user.getUserlevel())) {
			return true;
		}
		List<RoleDetail> roleDetailList = this.user.getRoleDetailList();
		boolean state = false;
		for (RoleDetail roleDetail : roleDetailList) {
			if (StringUtil.trim(roleDetail.getTreeItem().getNodeId()).equals(nodeId)) {
				if (roleDetail.getFunction() != null && StringUtil.trim(roleDetail.getFunction().getLabel()).equals(StringUtil.trim(functionName))) {
					return true;
				}
			}
		}
		return state;
	}
	
	/**
	 * get user
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * set user
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the mobile
	 */
	public boolean isMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

}
