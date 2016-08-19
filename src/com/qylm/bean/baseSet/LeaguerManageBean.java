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
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.baseSet.LeaguerManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.baseSet.LeaguerManageDto;
import com.qylm.entity.Leaguer;
import com.qylm.service.LeaguerService;

/**
 * 卡项管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class LeaguerManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4286248416011154702L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(LeaguerManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private LeaguerManageDto leaguerManageDto = new LeaguerManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<Leaguer> leaguerList;
	
	/**
	 * 删除复选框选择的值
	 */
	private Leaguer[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_卡项菜单】");
		fetchData(0, true);
		return Navigation.LEAGUER_MANAGE;
	}
	
	/**
	 * 此方法绑定于卡项管理画面的新建按钮 
	 * 实现功能：跳转至卡项登陆画面，新建一家事件
	 * @return 卡项登陆画面
	 */
	public String newLeaguer() {
		Tool.sendLog(LOG, userBean, "按下【卡项管理画面_新建按钮】");
		return Tool.getBackBean(LeaguerCreateBean.class).newCreate(new LeaguerManageReturner(leaguerManageDto, currentPage));
	}

	/**
	 * 此方法绑定于卡项管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至卡项登陆画面
	 * @return 卡项登陆画面
	 */
	public String updateLeaguer(Leaguer transferLeaguer) {
		Tool.sendLog(LOG, userBean, "按下【卡项管理画面_修改按钮】");
		return Tool.getBackBean(LeaguerCreateBean.class).updateDetail(new LeaguerManageReturner(leaguerManageDto, currentPage), transferLeaguer);
	}
	
	/**
	 * 此方法绑定于卡项管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectLeaguer() {
		Tool.sendLog(LOG, userBean, "按下【卡项管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于卡项管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【卡项管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<Leaguer> asList = Arrays.asList(selectedModels);
				leaguerService.deleteEntityAll(asList);
				leaguerList.removeAll(asList);
				removeData(1, leaguerList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
		
	}

	/**
	 * 此方法绑定于卡项管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteLeaguer(Leaguer transferLeaguer) {
		Tool.sendLog(LOG, userBean, "按下【卡项管理画面的_删除按钮】");
		try {
			leaguerService.deleteEntity(transferLeaguer);
			leaguerList.remove(transferLeaguer);
			removeData(1, leaguerList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(Leaguer transferLeaguer) {
		Tool.sendLog(LOG, userBean, "按下【卡项管理画面的_视图按钮】");
		if (transferLeaguer == null) {
			transferLeaguer = leaguerService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(LeaguerViewBean.class).viewDetail(transferLeaguer);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String level = leaguerManageDto.getLevel();
		if (StringUtil.isNotBlank(level)) {
			detachedCriteria.add(Restrictions.eq(Leaguer.LEVEL, level));
		}
		leaguerList = leaguerService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(leaguerService.getRowCount(detachedCriteria));
		}
		
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人事件管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.LEAGUER_MANAGE;
	}

	/**
	 * set leaguerService
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get leaguerManageDto
	 * @return the leaguerManageDto
	 */
	public LeaguerManageDto getLeaguerManageDto() {
		return leaguerManageDto;
	}

	/**
	 * set leaguerManageDto
	 * @param leaguerManageDto the leaguerManageDto to set
	 */
	public void setLeaguerManageDto(LeaguerManageDto leaguerManageDto) {
		this.leaguerManageDto = leaguerManageDto;
	}

	/**
	 * get leaguerList
	 * @return the leaguerList
	 */
	public List<Leaguer> getLeaguerList() {
		return leaguerList;
	}

	/**
	 * set leaguerList
	 * @param leaguerList the leaguerList to set
	 */
	public void setLeaguerList(List<Leaguer> leaguerList) {
		this.leaguerList = leaguerList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public Leaguer[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(Leaguer[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
