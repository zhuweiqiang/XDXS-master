package com.qylm.bean.auditing;

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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.auditing.AuditingSetManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.dto.auditing.AuditingSetManageDto;
import com.qylm.entity.AuditingSet;
import com.qylm.entity.AuditingSetDetail;
import com.qylm.entity.User;
import com.qylm.service.AuditingSetDetailService;
import com.qylm.service.AuditingSetService;

/**
 * 审核设定管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class AuditingSetManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6422477489121065360L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(AuditingSetManageBean.class);
	
	/**
	 * 保存审核设定管理画面需要保存的值
	 */
	private AuditingSetManageDto auditingSetManageDto = new AuditingSetManageDto();

	/**
	 * 审核设定列表（检索结果）
	 */
	private List<AuditingSet> auditingSetList;
	
	/**
	 * 删除复选框选择的值
	 */
	private AuditingSet[] selectedModels;

	/**
	 * 审核设定管理bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;

	/**
	 * 审核设定管理业务类
	 */
	@ManagedProperty(value="#{auditingSetService}")
	private AuditingSetService auditingSetService;
	
	/**
	 * 审核设定详细业务类
	 */
	@ManagedProperty(value="#{auditingSetDetailService}")
	private AuditingSetDetailService auditingSetDetailService;
	
	/**
	 * 查询出所有审核设定列表
	 * 
	 * @return 审核设定管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_审核设定管理按钮】");
		fetchData(0, true);
		return Navigation.AUDITING_SET_MANAGE;
	}

	/**
	 * 此方法绑定于项目管理画面的新建按钮 
	 * 实现功能：跳转至审核设定登陆画面，新建一家审核设定
	 * @return 审核设定登陆画面
	 */
	public String newAuditingSet() {
		Tool.sendLog(LOG, userBean, "按下【审核设定管理画面_新建按钮】");
		return Tool.getBackBean(AuditingSetCreateBean.class).newCreate(new AuditingSetManageReturner(auditingSetManageDto, currentPage));
	}

	/**
	 * 此方法绑定于项目管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至审核设定登陆画面
	 * @return 审核设定登陆画面
	 */
	public String updateAuditingSet(AuditingSet transferAuditingSet) {
		Tool.sendLog(LOG, userBean, "按下【审核设定管理画面_修改按钮】");
		return Tool.getBackBean(AuditingSetCreateBean.class).updateDetail(new AuditingSetManageReturner(auditingSetManageDto, currentPage), transferAuditingSet);
	}
	
	/**
	 * 此方法绑定于审核设定管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出审核设定
	 * @return 画面不跳转
	 */
	public void selectAuditingSet() {
		Tool.sendLog(LOG, userBean, "按下【审核设定管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于审核设定管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【审核设定管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<AuditingSet> asList = Arrays.asList(selectedModels);
			auditingSetList.removeAll(asList);
			auditingSetService.deleteEntityAll(asList);
			removeData(1, auditingSetList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于审核设定管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteAuditingSet(AuditingSet transferAuditingSet) {
		Tool.sendLog(LOG, userBean, "按下【审核设定管理画面的_删除按钮】");
		auditingSetList.remove(transferAuditingSet);
		auditingSetService.deleteEntity(transferAuditingSet);
		removeData(1, auditingSetList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(AuditingSet.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		auditingSetList = auditingSetService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(auditingSetService.getRowCount(detachedCriteria));
		}
		if (!auditingSetList.isEmpty()) {
			detachedCriteria = DetachedCriteria.forClass(AuditingSetDetail.class);
			detachedCriteria.createAlias(AuditingSetDetail.AUDITOR, AuditingSetDetail.AUDITOR, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(AuditingSetDetail.AUDITING_SET, AuditingSetDetail.AUDITING_SET, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(AuditingSetDetail.AUDITING_SET, auditingSetList));
			detachedCriteria.addOrder(Order.asc(AuditingSetDetail.SEQUENCE));
			List<AuditingSetDetail> auditingSetDetailList = auditingSetDetailService.getByDetachedCriteria(detachedCriteria);
			if (!auditingSetDetailList.isEmpty()) {
				List<User> userList;
				int size = auditingSetDetailList.size();
				AuditingSetDetail auditingSetDetail;
				User user;
				for (AuditingSet auditingSet : auditingSetList) {
					userList = new ArrayList<User>();
					for (int i = 0; i < size; i++) {
						auditingSetDetail = auditingSetDetailList.get(i);
						if (auditingSet.getId().equals(auditingSetDetail.getAuditingSet().getId())) {
							userList.add(auditingSetDetail.getAuditor());
						}
					}
					StringBuilder sb = new StringBuilder();
					int userListSize = userList.size();
					for (int i = 0; i < userListSize; i++) {
						user = userList.get(i);
						sb.append(user.getUserName());
						if (size - 1 > i) {
							sb.append("-------");
						}
					}
					auditingSet.setShowName(sb.toString());
				}
			}
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人审核设定管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.AUDITING_SET_MANAGE;
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
	 * get auditingSetManageDto
	 * @return the auditingSetManageDto
	 */
	public AuditingSetManageDto getAuditingSetManageDto() {
		return auditingSetManageDto;
	}

	/**
	 * set auditingSetManageDto
	 * @param auditingSetManageDto the auditingSetManageDto to set
	 */
	public void setAuditingSetManageDto(AuditingSetManageDto auditingSetManageDto) {
		this.auditingSetManageDto = auditingSetManageDto;
	}

	/**
	 * get auditingSetList
	 * @return the auditingSetList
	 */
	public List<AuditingSet> getAuditingSetList() {
		return auditingSetList;
	}

	/**
	 * set auditingSetList
	 * @param auditingSetList the auditingSetList to set
	 */
	public void setAuditingSetList(List<AuditingSet> auditingSetList) {
		this.auditingSetList = auditingSetList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public AuditingSet[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(AuditingSet[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
