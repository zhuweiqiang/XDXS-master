package com.qylm.bean.auditing;

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
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.auditing.AuditingSetCreateDto;
import com.qylm.dxo.AuditingSetCreateDxo;
import com.qylm.entity.AuditingSet;
import com.qylm.entity.AuditingSetDetail;
import com.qylm.entity.User;
import com.qylm.service.AuditingSetDetailService;
import com.qylm.service.AuditingSetService;
import com.qylm.service.UserService;

/**
 * 审核设定登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class AuditingSetCreateBean implements CreateBean<AuditingSet>, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5886231499796256531L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(AuditingSetCreateBean.class);

	/**
	 * 存放审核设定登陆画面需要保存的值
	 */
	private AuditingSetCreateDto auditingSetCreateDto = new AuditingSetCreateDto();
	
	/**
	 * 用户列表
	 */
	private List<User> userList;
	
	/**
	 * 选中用户列表
	 */
	private List<User> users;
	
	/**
	 * 审核设定bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 审核设定业务类
	 */
	@ManagedProperty(value="#{auditingSetService}")
	private AuditingSetService auditingSetService;
	
	/**
	 * 审核设定详细业务类
	 */
	@ManagedProperty(value = "#{auditingSetDetailService}")
	private AuditingSetDetailService auditingSetDetailService;
	
	/**
	 * 用户业务类
	 */
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	/**
	 * 此方法绑定于审核设定登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个审核设定
	 * @return 审核设定登陆画面
	 */
	public String newAuditingSet() {
		Tool.sendLog(LOG, userBean, "【审核设定登陆画面_新建按钮】");
		clear();
		return Navigation.AUDITING_SET_CREATE;
	}
	
	/**
	 * 此方法绑定于审核设定登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【审核设定登陆画面_返回按钮】");
		return auditingSetCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于审核设定登陆画面的保存按钮 
	 * 实现功能：根据transferAuditingSet对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveAuditingSet() {
		Tool.sendLog(LOG, userBean, "【审核设定登陆画面_保存按钮】");
		try {
			if (StringUtil.isUnSelected(auditingSetCreateDto.getApplyNumber())) {
				Tool.sendErrorMessage("类型必须填写！");
				return;
			}
			AuditingSet transferAuditingSet = auditingSetCreateDto.getTransferAuditingSet();
			List<AuditingSetDetail> auditingSetDetailList = new ArrayList<AuditingSetDetail>();
			if (transferAuditingSet == null) {
				transferAuditingSet = new AuditingSet();
				auditingSetCreateDto.setCreater(userBean.getUser());
				auditingSetCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				create(transferAuditingSet, auditingSetDetailList);
				transferAuditingSet.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				auditingSetService.saveAuditingSet(transferAuditingSet, auditingSetDetailList);
				auditingSetCreateDto.setTransferAuditingSet(transferAuditingSet);
				Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
			} else {
				create(transferAuditingSet, auditingSetDetailList);
				transferAuditingSet.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
				auditingSetService.updateAuditingSet(transferAuditingSet, auditingSetDetailList);
				Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage("审核设定已存在，请确认！");
		}
	}
	
	/**
	 * 赋值
	 * @param transferAuditingSet
	 */
	private void create(AuditingSet transferAuditingSet, List<AuditingSetDetail> auditingSetDetailList) {
		AuditingSetCreateDxo.dtoToEntity(auditingSetCreateDto, transferAuditingSet);
		if (users != null && !users.isEmpty()) {
			int size = users.size();
			User user;
			AuditingSetDetail auditingSetDetail;
			for (int i = 0; i < size; i++) {
				user = users.get(i);
				auditingSetDetail = new AuditingSetDetail();
				auditingSetDetail.setAuditor(user);
				auditingSetDetail.setSequence(i+1);
				auditingSetDetail.setAuditingSet(transferAuditingSet);
				auditingSetDetail.setCreater(userBean.getUser());
				auditingSetDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				auditingSetDetailList.add(auditingSetDetail);
			}
		}
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		auditingSetCreateDto.setReturner(returner);
		return Navigation.AUDITING_SET_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, AuditingSet auditingSet) {
		auditingSetCreateDto.setReturner(returner);
		AuditingSetCreateDxo.entityToDto(auditingSet, auditingSetCreateDto);
		auditingSetCreateDto.setTransferAuditingSet(auditingSet);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AuditingSetDetail.class);
		detachedCriteria.createAlias(AuditingSetDetail.AUDITOR, AuditingSetDetail.AUDITOR, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(AuditingSetDetail.AUDITING_SET, auditingSet));
		detachedCriteria.addOrder(Order.asc(AuditingSetDetail.SEQUENCE));
		List<AuditingSetDetail> auditingSetDetailList = auditingSetDetailService.getByDetachedCriteria(detachedCriteria);
		if (!auditingSetDetailList.isEmpty()) {
			users = new ArrayList<User>();
			for (AuditingSetDetail auditingSetDetail : auditingSetDetailList) {
				users.add(auditingSetDetail.getAuditor());
			}
		}
		return Navigation.AUDITING_SET_CREATE;
	}
	
	/**
	 * 此方法绑定与审核设定登录画面的选择用户按钮
	 * 实现功能：查询出所有后台用户
	 */
	public void findUser() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		detachedCriteria.add(Restrictions.eq(User.STOP, User.STOP_2));
		if (users != null && !users.isEmpty()) {
			List<Integer> userIdList = new ArrayList<Integer>();
			for (User user : users) {
				userIdList.add(user.getId());
			}
			detachedCriteria.add(Restrictions.not(Restrictions.in(User.BASE_ID, userIdList)));
		}
		userList = userService.getByDetachedCriteria(detachedCriteria);
	}
	
	/**
	 * 此方法绑定与审核设定登录画面的选择用户画面的确认按钮
	 * 实现功能：获取到用户信息
	 */
	public void queryUser(User user) {
		if (users == null) {
			users = new ArrayList<User>();
		}
		users.add(user);
	}
	
	/**
	 * 获取到选择的用户列表
	 * @return 按顺序显示出审核人员列表
	 */
	public String getProcedUsers() {
		if (users == null || users.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int size = users.size();
		User user;
		for (int i = 0; i < size; i++) {
			user = users.get(i);
			sb.append(user.getUserName());
			if (size - 1 > i) {
				sb.append("-------");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 此方法绑定于审核设定登录画面的确认按钮
	 * 实现功能：如果为锁定将其锁定，如果锁定将其设置为未锁定
	 * @return
	 */
	public void query() {
		AuditingSet transferAuditingSet = auditingSetCreateDto.getTransferAuditingSet();
		transferAuditingSet.setState(auditingSetCreateDto.isState() ? false : true);
		auditingSetService.updateEntity(transferAuditingSet);
		auditingSetCreateDto.setState(transferAuditingSet.isState());
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}
	
	/**
	 * 此方法绑定于审核设定登录画面的下拉框选择按钮
	 * 实现功能：根据选择到的下拉框列表值，来获取到与其相对于的审核设定信息
	 */
	public void selectAuditingSet() {
		String applyNumber = auditingSetCreateDto.getApplyNumber();
		if (StringUtil.isUnSelected(applyNumber)) {
			clear();
		} else {
			// 查询出对应的审核信息
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AuditingSet.class);
			detachedCriteria.add(Restrictions.eq(AuditingSet.APPLY_NUMBER, applyNumber));
			List<AuditingSet> auditingSetList = auditingSetService.getByDetachedCriteria(detachedCriteria);
			if (auditingSetList.isEmpty()) {
				clear();
				auditingSetCreateDto.setApplyNumber(applyNumber);
			} else {
				AuditingSet auditingSet = auditingSetList.get(0);
				detachedCriteria = DetachedCriteria.forClass(AuditingSetDetail.class);
				detachedCriteria.createAlias(AuditingSetDetail.AUDITOR, AuditingSetDetail.AUDITOR, JoinType.LEFT_OUTER_JOIN);
				detachedCriteria.add(Restrictions.eq(AuditingSetDetail.AUDITING_SET, auditingSet));
				detachedCriteria.addOrder(Order.asc(AuditingSetDetail.SEQUENCE));
				List<AuditingSetDetail> auditingSetDetailList = auditingSetDetailService.getByDetachedCriteria(detachedCriteria);
				if (!auditingSetDetailList.isEmpty()) {
					users = new ArrayList<User>();
					for (AuditingSetDetail auditingSetDetail : auditingSetDetailList) {
						users.add(auditingSetDetail.getAuditor());
					}
				}
				auditingSetCreateDto.setTransferAuditingSet(auditingSet);
				auditingSetCreateDto.setState(auditingSet.isState());
				auditingSetCreateDto.setApplyNumber(auditingSet.getApplyNumber());
			}
		}
	}
	
	/**
	 * 清除数据
	 */
	private void clear() {
		auditingSetCreateDto.setApplyNumber(null);
		auditingSetCreateDto.setState(false);
		auditingSetCreateDto.setTransferAuditingSet(null);
		userList = null;
		users = null;
	}
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param auditingSetDetailService the auditingSetDetailService to set
	 */
	public void setAuditingSetDetailService(
			AuditingSetDetailService auditingSetDetailService) {
		this.auditingSetDetailService = auditingSetDetailService;
	}

	/**
	 * set auditingSetService
	 * @param auditingSetService the auditingSetService to set
	 */
	public void setAuditingSetService(AuditingSetService auditingSetService) {
		this.auditingSetService = auditingSetService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get auditingSetCreateDto
	 * @return the auditingSetCreateDto
	 */
	public AuditingSetCreateDto getAuditingSetCreateDto() {
		return auditingSetCreateDto;
	}

	/**
	 * set auditingSetCreateDto
	 * @param auditingSetCreateDto the auditingSetCreateDto to set
	 */
	public void setAuditingSetCreateDto(AuditingSetCreateDto auditingSetCreateDto) {
		this.auditingSetCreateDto = auditingSetCreateDto;
	}

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
