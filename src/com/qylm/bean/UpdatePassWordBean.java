package com.qylm.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qylm.common.Tool;
import com.qylm.common.utils.CipherUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.entity.User;
import com.qylm.service.UserService;

/**
 * 修改密码bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class UpdatePassWordBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2085533553806409631L;

	/**
	 * LOG 日志
	 */
	private static final Log LOG = LogFactory.getLog(UpdatePassWordBean.class);
	
	/**
	 * 用户
	 */
	private User user;
	
	/**
	 * 原密码
	 */
	private String password;
	
	/**
	 * 新密码
	 */
	private String password1;
	
	/**
	 * 登陆用户信息
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 用户业务类
	 */
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	
	/**
	 * 修改账号密码密码
	 * @return
	 */
	public void viewUserPassword(ActionEvent event){
		user = userBean.getUser();
	}
	
	/**
	 * 保存
	 * @return
	 */
	public void save() {
		Tool.sendLog(LOG, userBean, "【密码修改画面_保存按钮】");
		// 验证密码是否相同
		if (!user.getPassword().equals(CipherUtil.DESEncrypt(password, CipherUtil.generateDESKey(user.getLoginName())))) {
			Tool.sendErrorMessage("原密码输入错误，请确认！");
			return;
		}
		user.setPassword(CipherUtil.DESEncrypt(password1, CipherUtil.generateDESKey(user.getLoginName())));
		user.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		userService.updateEntity(user);
		Tool.sendErrorMessage("密码更改成功");
	}
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @return the password1
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password1 the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

}
