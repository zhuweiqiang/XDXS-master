package com.qylm.bean.baseSet;

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
import com.qylm.bean.returner.baseSet.GiveInfoManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.GiveInfoManageDto;
import com.qylm.entity.GiveInfo;
import com.qylm.service.GiveInfoService;

/**
 * 体验卡管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class GiveInfoManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4286248416011154702L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(GiveInfoManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private GiveInfoManageDto giveInfoManageDto = new GiveInfoManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<GiveInfo> giveInfoList;
	
	/**
	 * 删除复选框选择的值
	 */
	private GiveInfo[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_体验卡菜单】");
		giveInfoManageDto.setType(GiveInfo.TYPE_1);
		fetchData(0, true);
		return Navigation.GIVE_INFO_MANAGE;
	}
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAllCashRoll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_现金卷菜单】");
		giveInfoManageDto.setType(GiveInfo.TYPE_2);
		fetchData(0, true);
		return Navigation.GIVE_INFO_MANAGE;
	}
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAllBodyVolume() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_身体卷菜单】");
		giveInfoManageDto.setType(GiveInfo.TYPE_3);
		fetchData(0, true);
		return Navigation.GIVE_INFO_MANAGE;
	}
	
	/**
	 * 此方法绑定于体验卡管理画面的新建按钮 
	 * 实现功能：跳转至体验卡登陆画面，新建一家事件
	 * @return 体验卡登陆画面
	 */
	public String newGiveInfo() {
		Tool.sendLog(LOG, userBean, "按下【体验卡管理画面_新建按钮】");
		return Tool.getBackBean(GiveInfoCreateBean.class).newCreate(new GiveInfoManageReturner(giveInfoManageDto, currentPage), giveInfoManageDto.getType());
	}

	/**
	 * 此方法绑定于体验卡管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至体验卡登陆画面
	 * @return 体验卡登陆画面
	 */
	public String updateGiveInfo(GiveInfo transferGiveInfo) {
		Tool.sendLog(LOG, userBean, "按下【体验卡管理画面_修改按钮】");
		return Tool.getBackBean(GiveInfoCreateBean.class).updateDetail(new GiveInfoManageReturner(giveInfoManageDto, currentPage), transferGiveInfo);
	}
	
	/**
	 * 此方法绑定于体验卡管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectGiveInfo() {
		Tool.sendLog(LOG, userBean, "按下【体验卡管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于体验卡管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【体验卡管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<GiveInfo> asList = Arrays.asList(selectedModels);
				giveInfoService.deleteEntityAll(asList);
				giveInfoList.removeAll(asList);
				removeData(1, giveInfoList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于体验卡管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteGiveInfo(GiveInfo transferGiveInfo) {
		Tool.sendLog(LOG, userBean, "按下【体验卡管理画面的_删除按钮】");
		try {
			giveInfoService.deleteEntity(transferGiveInfo);
			giveInfoList.remove(transferGiveInfo);
			removeData(1, giveInfoList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(GiveInfo transferGiveInfo) {
		Tool.sendLog(LOG, userBean, "按下【体验卡管理画面的_视图按钮】");
		if (transferGiveInfo == null) {
			transferGiveInfo = giveInfoService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(GiveInfoViewBean.class).viewDetail(transferGiveInfo);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String title = giveInfoManageDto.getTitle();
		String type = giveInfoManageDto.getType();
		if (StringUtil.isNotBlank(title)) {
			detachedCriteria.add(Restrictions.like(GiveInfo.TITLE, title, MatchMode.ANYWHERE));
		}
		if (StringUtil.isNotBlank(type)) {
			detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, type));
		}
		giveInfoList = giveInfoService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(giveInfoService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.GIVE_INFO_MANAGE;
	}

	/**
	 * set giveInfoService
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get giveInfoManageDto
	 * @return the giveInfoManageDto
	 */
	public GiveInfoManageDto getGiveInfoManageDto() {
		return giveInfoManageDto;
	}

	/**
	 * set giveInfoManageDto
	 * @param giveInfoManageDto the giveInfoManageDto to set
	 */
	public void setGiveInfoManageDto(GiveInfoManageDto giveInfoManageDto) {
		this.giveInfoManageDto = giveInfoManageDto;
	}

	/**
	 * get giveInfoList
	 * @return the giveInfoList
	 */
	public List<GiveInfo> getGiveInfoList() {
		return giveInfoList;
	}

	/**
	 * set giveInfoList
	 * @param giveInfoList the giveInfoList to set
	 */
	public void setGiveInfoList(List<GiveInfo> giveInfoList) {
		this.giveInfoList = giveInfoList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public GiveInfo[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(GiveInfo[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
