package com.qylm.bean.personnel;

import java.util.Arrays;
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
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.personnel.PersonnelInfoManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.personnel.PersonnelInfoManageDto;
import com.qylm.entity.PersonnelInfo;
import com.qylm.service.PersonnelInfoService;

/**
 * 人事信息管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class PersonnelInfoManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5721829402235170132L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(PersonnelInfoManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private PersonnelInfoManageDto personnelInfoManageDto = new PersonnelInfoManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<PersonnelInfo> personnelInfoList;
	
	/**
	 * 删除复选框选择的值
	 */
	private PersonnelInfo[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{personnelInfoService}")
	private PersonnelInfoService personnelInfoService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_人事信息菜单】");
		fetchData(0, true);
		return Navigation.PERSONNEL_INFO_MANAGE;
	}
	
	/**
	 * 此方法绑定于人事信息管理画面的新建按钮 
	 * 实现功能：跳转至人事信息登陆画面，新建一家事件
	 * @return 人事信息登陆画面
	 */
	public String newPersonnelInfo() {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面_新建按钮】");
		return Tool.getBackBean(PersonnelInfoCreateBean.class).newCreate(new PersonnelInfoManageReturner(personnelInfoManageDto, currentPage));
	}

	/**
	 * 此方法绑定于人事信息管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至人事信息登陆画面
	 * @return 人事信息登陆画面
	 */
	public String updatePersonnelInfo(PersonnelInfo transferPersonnelInfo) {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面_修改按钮】");
		return Tool.getBackBean(PersonnelInfoCreateBean.class).updateDetail(new PersonnelInfoManageReturner(personnelInfoManageDto, currentPage), transferPersonnelInfo);
	}
	
	/**
	 * 此方法绑定于人事信息管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectPersonnelInfo() {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于人事信息管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<PersonnelInfo> asList = Arrays.asList(selectedModels);
				personnelInfoService.deleteEntityAll(asList);
				personnelInfoList.removeAll(asList);
				removeData(1, personnelInfoList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于人事信息管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deletePersonnelInfo(PersonnelInfo transferPersonnelInfo) {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面的_删除按钮】");
		try {
			personnelInfoService.deleteEntity(transferPersonnelInfo);
			personnelInfoList.remove(transferPersonnelInfo);
			removeData(1, personnelInfoList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 此方法绑定于人事信息管理画面的操作按钮 
	 * @return 画面不跳转
	 */
	public void operatePersonnelInfo(PersonnelInfo transferPersonnelInfo) {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面的_操作按钮】");
		if (PersonnelInfo.WORK_STATE_1.equals(transferPersonnelInfo.getWorkState())) {
			transferPersonnelInfo.setWorkState(PersonnelInfo.WORK_STATE_2);
		} else {
			transferPersonnelInfo.setWorkState(PersonnelInfo.WORK_STATE_1);
		}
		transferPersonnelInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
		personnelInfoService.updateEntity(transferPersonnelInfo);
		Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(PersonnelInfo transferPersonnelInfo) {
		Tool.sendLog(LOG, userBean, "按下【人事信息管理画面的_视图按钮】");
		if (transferPersonnelInfo == null) {
			transferPersonnelInfo = personnelInfoService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(PersonnelInfoViewBean.class).viewDetail(transferPersonnelInfo);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonnelInfo.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String workNumber = personnelInfoManageDto.getWorkNumber();
		String name = personnelInfoManageDto.getName();
		String identification = personnelInfoManageDto.getIdentification();
		String workState = personnelInfoManageDto.getWorkState();
		if (StringUtil.isNotBlank(workNumber)) {
			detachedCriteria.add(Restrictions.like(PersonnelInfo.WORK_NUMBER, workNumber, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(PersonnelInfo.NAME, name, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(identification)) {
			detachedCriteria.add(Restrictions.like(PersonnelInfo.IDENTIFICATION, identification, MatchMode.ANYWHERE));
		}
		if (!StringUtil.isUnSelected(workState)) {
			detachedCriteria.add(Restrictions.like(PersonnelInfo.WORK_STATE, workState));
		}
		if (!StringUtil.isUnSelected(personnelInfoManageDto.getType())) {
			detachedCriteria.add(Restrictions.eq(PersonnelInfo.TYPE, personnelInfoManageDto.getType()));
		}
		personnelInfoList = personnelInfoService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(personnelInfoService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.PERSONNEL_INFO_MANAGE;
	}

	/**
	 * set personnelInfoService
	 * @param personnelInfoService the personnelInfoService to set
	 */
	public void setPersonnelInfoService(PersonnelInfoService personnelInfoService) {
		this.personnelInfoService = personnelInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get personnelInfoManageDto
	 * @return the personnelInfoManageDto
	 */
	public PersonnelInfoManageDto getPersonnelInfoManageDto() {
		return personnelInfoManageDto;
	}

	/**
	 * set personnelInfoManageDto
	 * @param personnelInfoManageDto the personnelInfoManageDto to set
	 */
	public void setPersonnelInfoManageDto(PersonnelInfoManageDto personnelInfoManageDto) {
		this.personnelInfoManageDto = personnelInfoManageDto;
	}

	/**
	 * get personnelInfoList
	 * @return the personnelInfoList
	 */
	public List<PersonnelInfo> getPersonnelInfoList() {
		return personnelInfoList;
	}

	/**
	 * set personnelInfoList
	 * @param personnelInfoList the personnelInfoList to set
	 */
	public void setPersonnelInfoList(List<PersonnelInfo> personnelInfoList) {
		this.personnelInfoList = personnelInfoList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public PersonnelInfo[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(PersonnelInfo[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
