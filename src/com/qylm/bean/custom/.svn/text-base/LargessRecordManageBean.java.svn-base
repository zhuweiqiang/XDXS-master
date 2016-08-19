package com.qylm.bean.custom;

import java.util.Arrays;
import java.util.Date;
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

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.LargessRecordManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.LargessRecordManageDto;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.Leaguer;
import com.qylm.service.LargessRecordService;

/**
 * 赠送项目记录管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class LargessRecordManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8477355715071276153L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(LargessRecordManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private LargessRecordManageDto largessRecordManageDto = new LargessRecordManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<LargessRecord> largessRecordList;
	
	/**
	 * 删除复选框选择的值
	 */
	private LargessRecord[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{largessRecordService}")
	private LargessRecordService largessRecordService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_赠送项目记录菜单】");
		fetchData(0, true);
		return Navigation.LARGESS_RECORD_MANAGE;
	}
	
	/**
	 * 此方法绑定于赠送项目记录管理画面的新建按钮 
	 * 实现功能：跳转至赠送项目记录登陆画面，新建一家事件
	 * @return 赠送项目记录登陆画面
	 */
	public String newLargessRecord() {
		Tool.sendLog(LOG, userBean, "按下【赠送项目记录管理画面_新建按钮】");
		return Tool.getBackBean(LargessRecordCreateBean.class).newCreate(new LargessRecordManageReturner(largessRecordManageDto, currentPage));
	}

	/**
	 * 此方法绑定于赠送项目记录管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至赠送项目记录登陆画面
	 * @return 赠送项目记录登陆画面
	 */
	public String updateLargessRecord(LargessRecord transferLargessRecord) {
		Tool.sendLog(LOG, userBean, "按下【赠送项目记录管理画面_修改按钮】");
		return Tool.getBackBean(LargessRecordCreateBean.class).updateDetail(new LargessRecordManageReturner(largessRecordManageDto, currentPage), transferLargessRecord);
	}
	
	/**
	 * 此方法绑定于赠送项目记录管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectLargessRecord() {
		Tool.sendLog(LOG, userBean, "按下【赠送项目记录管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于赠送项目记录管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【赠送项目记录管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<LargessRecord> asList = Arrays.asList(selectedModels);
			largessRecordService.deleteEntityAll(asList);
			largessRecordList.removeAll(asList);
			removeData(1, largessRecordList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于赠送项目记录管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteLargessRecord(LargessRecord transferLargessRecord) {
		Tool.sendLog(LOG, userBean, "按下【赠送项目记录管理画面的_删除按钮】");
		largessRecordService.deleteEntity(transferLargessRecord);
		largessRecordList.remove(transferLargessRecord);
		removeData(1, largessRecordList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(LargessRecord transferLargessRecord) {
		Tool.sendLog(LOG, userBean, "按下【赠送项目记录管理画面的_视图按钮】");
		if (transferLargessRecord == null) {
			transferLargessRecord = largessRecordService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(LargessRecordViewBean.class).viewDetail(transferLargessRecord);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
		detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.PERSONNEL_INFO_1, LargessRecord.PERSONNEL_INFO_1, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(LargessRecord.PERSONNEL_INFO_2, LargessRecord.PERSONNEL_INFO_2, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String leaguerNumber = largessRecordManageDto.getLeaguerNumber();
		String name = largessRecordManageDto.getName();
		Date beginDate = largessRecordManageDto.getBeginDate();
		Date endDate = largessRecordManageDto.getEndDate();
		if (StringUtil.isNotBlank(leaguerNumber)) {
			detachedCriteria.add(Restrictions.like(LargessRecord.CUSTOM_INFO_LEAGUER_NUMBER, leaguerNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(LargessRecord.CUSTOM_INFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(LargessRecord.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(LargessRecord.DATE, endDate));
		}
		largessRecordList = largessRecordService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(largessRecordService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.LARGESS_RECORD_MANAGE;
	}

	/**
	 * set largessRecordService
	 * @param largessRecordService the largessRecordService to set
	 */
	public void setLargessRecordService(LargessRecordService largessRecordService) {
		this.largessRecordService = largessRecordService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get largessRecordManageDto
	 * @return the largessRecordManageDto
	 */
	public LargessRecordManageDto getLargessRecordManageDto() {
		return largessRecordManageDto;
	}

	/**
	 * set largessRecordManageDto
	 * @param largessRecordManageDto the largessRecordManageDto to set
	 */
	public void setLargessRecordManageDto(LargessRecordManageDto largessRecordManageDto) {
		this.largessRecordManageDto = largessRecordManageDto;
	}

	/**
	 * get largessRecordList
	 * @return the largessRecordList
	 */
	public List<LargessRecord> getLargessRecordList() {
		return largessRecordList;
	}

	/**
	 * set largessRecordList
	 * @param largessRecordList the largessRecordList to set
	 */
	public void setLargessRecordList(List<LargessRecord> largessRecordList) {
		this.largessRecordList = largessRecordList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public LargessRecord[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(LargessRecord[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
