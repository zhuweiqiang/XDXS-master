package com.qylm.bean.custom;

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
import org.hibernate.sql.JoinType;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.CustomLeaguerDetailManageDto;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.Leaguer;
import com.qylm.service.CustomLeaguerDetailService;

/**
 * 客户卡项查询管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class CustomLeaguerDetailManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4082125971241058565L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(CustomLeaguerDetailManageBean.class);
	
	/**
	 * 保存事件管理画面需要保存的值
	 */
	private CustomLeaguerDetailManageDto customLeaguerDetailManageDto = new CustomLeaguerDetailManageDto();

	/**
	 * 事件列表（检索结果）
	 */
	private List<CustomLeaguerDetail> customLeaguerDetailList;
	
	/**
	 * 删除复选框选择的值
	 */
	private CustomLeaguerDetail[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 查询出所有事件列表
	 * @return 事件管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_客户卡项查询菜单】");
		fetchData(0, true);
		return Navigation.CUSTOM_LEAGUER_DETAIL_MANAGE;
	}
	
	/**
	 * 此方法绑定于客户卡项查询管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出事件
	 * @return 画面不跳转
	 */
	public void selectCustomLeaguerDetail() {
		Tool.sendLog(LOG, userBean, "按下【客户卡项查询管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于客户卡项查询管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【客户卡项查询管理画面_批量删除按钮】");
		if (selectedModels != null) {
			List<CustomLeaguerDetail> asList = Arrays.asList(selectedModels);
			customLeaguerDetailService.deleteEntityAll(asList);
			customLeaguerDetailList.removeAll(asList);
			removeData(1, customLeaguerDetailList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		}
	}

	/**
	 * 此方法绑定于客户卡项查询管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteCustomLeaguerDetail(CustomLeaguerDetail transferCustomLeaguerDetail) {
		Tool.sendLog(LOG, userBean, "按下【客户卡项查询管理画面的_删除按钮】");
		customLeaguerDetailService.deleteEntity(transferCustomLeaguerDetail);
		customLeaguerDetailList.remove(transferCustomLeaguerDetail);
		removeData(1, customLeaguerDetailList.isEmpty());
		Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
	}
	
	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.LEAGUER));
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		Leaguer leaguer = customLeaguerDetailManageDto.getLeaguer();
		String name = customLeaguerDetailManageDto.getName();
		if (leaguer != null) {
			detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.LEAGUER, leaguer));
		}
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(CustomLeaguerDetail.CUSTOM_INFO_NAME, name, MatchMode.ANYWHERE));
		}
		customLeaguerDetailList = customLeaguerDetailService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(customLeaguerDetailService.getRowCount(detachedCriteria));
		}
	}

	/**
	 * set customLeaguerDetailService
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get customLeaguerDetailManageDto
	 * @return the customLeaguerDetailManageDto
	 */
	public CustomLeaguerDetailManageDto getCustomLeaguerDetailManageDto() {
		return customLeaguerDetailManageDto;
	}

	/**
	 * set customLeaguerDetailManageDto
	 * @param customLeaguerDetailManageDto the customLeaguerDetailManageDto to set
	 */
	public void setCustomLeaguerDetailManageDto(CustomLeaguerDetailManageDto customLeaguerDetailManageDto) {
		this.customLeaguerDetailManageDto = customLeaguerDetailManageDto;
	}

	/**
	 * get customLeaguerDetailList
	 * @return the customLeaguerDetailList
	 */
	public List<CustomLeaguerDetail> getCustomLeaguerDetailList() {
		return customLeaguerDetailList;
	}

	/**
	 * set customLeaguerDetailList
	 * @param customLeaguerDetailList the customLeaguerDetailList to set
	 */
	public void setCustomLeaguerDetailList(List<CustomLeaguerDetail> customLeaguerDetailList) {
		this.customLeaguerDetailList = customLeaguerDetailList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public CustomLeaguerDetail[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(CustomLeaguerDetail[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
