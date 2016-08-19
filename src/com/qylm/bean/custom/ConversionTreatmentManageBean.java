package com.qylm.bean.custom;

import java.util.ArrayList;
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
import org.springframework.dao.DataIntegrityViolationException;

import com.qylm.bean.BasePagingBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.returner.custom.ConversionTreatmentManageReturner;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.StringUtil;
import com.qylm.dto.custom.ConversionTreatmentManageDto;
import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.ConversionTreatmentDetail;
import com.qylm.service.ConversionTreatmentDetailService;
import com.qylm.service.ConversionTreatmentService;

/**
 * 疗程转换管理
 * @author qylm
 */
@ManagedBean
@RequestScoped
public class ConversionTreatmentManageBean extends BasePagingBean {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1165992667478622520L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ConversionTreatmentManageBean.class);
	
	/**
	 * 保存疗程转换管理画面需要保存的值
	 */
	private ConversionTreatmentManageDto conversionTreatmentManageDto = new ConversionTreatmentManageDto();

	/**
	 * 疗程转换列表（检索结果）
	 */
	private List<ConversionTreatment> conversionTreatmentList;
	
	/**
	 * 删除复选框选择的值
	 */
	private ConversionTreatment[] selectedModels;

	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 疗程转换记录业务类
	 */
	@ManagedProperty(value="#{conversionTreatmentService}")
	private ConversionTreatmentService conversionTreatmentService;
	
	/**
	 * 疗程转换记录详细业务类
	 */
	@ManagedProperty(value="#{conversionTreatmentDetailService}")
	private ConversionTreatmentDetailService conversionTreatmentDetailService;
	
	/**
	 * 查询出所有疗程转换列表
	 * @return 疗程转换管理画面
	 */
	public String getAll() {
		Tool.sendLog(LOG, userBean, "按下【功能菜单_疗程转换菜单】");
		fetchData(0, true);
		return Navigation.CONVERSION_TREATMENT_MANAGE;
	}
	
	/**
	 * 此方法绑定于疗程转换管理画面的新建按钮 
	 * 实现功能：跳转至疗程转换登陆画面，新建一家疗程转换
	 * @return 疗程转换登陆画面
	 */
	public String newConversionTreatment() {
		Tool.sendLog(LOG, userBean, "按下【疗程转换管理画面_新建按钮】");
		return Tool.getBackBean(ConversionTreatmentCreateBean.class).newCreate(new ConversionTreatmentManageReturner(conversionTreatmentManageDto, currentPage));
	}

	/**
	 * 此方法绑定于疗程转换管理画面的修改按钮 
	 * 实现功能：根据修改的对象，跳转至疗程转换登陆画面
	 * @return 疗程转换登陆画面
	 */
	public String updateConversionTreatment(ConversionTreatment transferConversionTreatment) {
		Tool.sendLog(LOG, userBean, "按下【疗程转换管理画面_修改按钮】");
		return Tool.getBackBean(ConversionTreatmentCreateBean.class).updateDetail(new ConversionTreatmentManageReturner(conversionTreatmentManageDto, currentPage), transferConversionTreatment);
	}
	
	/**
	 * 此方法绑定于疗程转换管理画面的检索按钮 
	 * 实现功能：根据检索条件，检索出疗程转换
	 * @return 画面不跳转
	 */
	public void selectConversionTreatment() {
		Tool.sendLog(LOG, userBean, "按下【疗程转换管理画面_检索按钮】");
		fetchData(0, true);
	}
	
	/**
	 * 绑定于疗程转换管理画面的全选删除按钮
	 * @param event
	 */
	public void deleteMul(ActionEvent event) {
		Tool.sendLog(LOG, userBean, "按下【疗程转换管理画面_批量删除按钮】");
		try {
			if (selectedModels != null) {
				List<ConversionTreatment> asList = Arrays.asList(selectedModels);
				conversionTreatmentService.deleteEntityAll(asList);
				conversionTreatmentList.removeAll(asList);
				removeData(1, conversionTreatmentList.isEmpty());
				Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
			}
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}

	/**
	 * 此方法绑定于疗程转换管理画面的删除按钮 
	 * 实现功能：先移除集合内的数据，在移除数据库内的数据
	 * @return 画面不跳转
	 */
	public void deleteConversionTreatment(ConversionTreatment transferConversionTreatment) {
		Tool.sendLog(LOG, userBean, "按下【疗程转换管理画面的_删除按钮】");
		try {
			conversionTreatmentService.deleteEntity(transferConversionTreatment);
			conversionTreatmentList.remove(transferConversionTreatment);
			removeData(1, conversionTreatmentList.isEmpty());
			Tool.sendErrorMessage(Message.GENERAL_DELETESUCCESS);
		} catch (DataIntegrityViolationException e) {
			Tool.sendErrorMessage(Message.GENERAL_DELETE_ERROR);
		}
	}
	
	/**
	 * 绑定于客户记录管理页面的视图按钮 客户记录视图画面
	 */
	public String viewDetail(ConversionTreatment transferConversionTreatment) {
		Tool.sendLog(LOG, userBean, "按下【疗程转换管理画面的_视图按钮】");
		if (transferConversionTreatment == null) {
			transferConversionTreatment = conversionTreatmentService.getById(Integer.valueOf(super.modelId));
		}
		return Tool.getBackBean(ConversionTreatmentViewBean.class).viewDetail(transferConversionTreatment);
	}

	@Override
	protected void fetchData(int start, boolean needInit) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConversionTreatment.class);
		detachedCriteria.createAlias(ConversionTreatment.CUSTOMINFO, ConversionTreatment.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConversionTreatment.PERSONNEL_INFO, ConversionTreatment.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConversionTreatment.ADVISER, ConversionTreatment.ADVISER, JoinType.LEFT_OUTER_JOIN);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		String name = conversionTreatmentManageDto.getName();
		Date beginDate = conversionTreatmentManageDto.getBeginDate();
		Date endDate = conversionTreatmentManageDto.getEndDate();
		if (StringUtil.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.like(ConversionTreatment.CUSTOMINFO_NAME, name, MatchMode.ANYWHERE));
		}
		if (beginDate != null) {
			detachedCriteria.add(Restrictions.ge(ConversionTreatment.DATE, beginDate));
		}
		if (endDate != null) {
			detachedCriteria.add(Restrictions.le(ConversionTreatment.DATE, endDate));
		}
		conversionTreatmentList = conversionTreatmentService.getByDetachedCriteria(detachedCriteria, start, onePageCount);
		if (needInit) {
			init(conversionTreatmentService.getRowCount(detachedCriteria));
		}
		if (!conversionTreatmentList.isEmpty()) {
			detachedCriteria = DetachedCriteria.forClass(ConversionTreatmentDetail.class);
			detachedCriteria.createAlias(ConversionTreatmentDetail.MARKETING_PROJECT, ConversionTreatmentDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConversionTreatmentDetail.CONVERSION_TREATMENT, ConversionTreatmentDetail.CONVERSION_TREATMENT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(ConversionTreatmentDetail.CONVERSION_TREATMENT, conversionTreatmentList));
			List<ConversionTreatmentDetail> detialList = conversionTreatmentDetailService.getByDetachedCriteria(detachedCriteria);
			for (ConversionTreatment conversionTreatment : conversionTreatmentList) {
				List<ConversionTreatmentDetail> conversionTreatmentDetailList = new ArrayList<ConversionTreatmentDetail>();
				for (ConversionTreatmentDetail conversionTreatmentDetail : detialList) {
					if (conversionTreatment.equals(conversionTreatmentDetail.getConversionTreatment())) {
						conversionTreatmentDetailList.add(conversionTreatmentDetail);
					}
				}
				conversionTreatment.setConversionTreatmentDetailList(conversionTreatmentDetailList);
			}
		}
	}

	/**
	 * 需要返回本画面时都调用此共通方法
	 * @param currentPage 当前页数
	 * @return 个人疗程转换管理画面
	 */
	public String back(int currentPage) {
		reflushCurrentPage(currentPage);
		return Navigation.CONVERSION_TREATMENT_MANAGE;
	}

	/**
	 * @param conversionTreatmentDetailService the conversionTreatmentDetailService to set
	 */
	public void setConversionTreatmentDetailService(
			ConversionTreatmentDetailService conversionTreatmentDetailService) {
		this.conversionTreatmentDetailService = conversionTreatmentDetailService;
	}

	/**
	 * set conversionTreatmentService
	 * @param conversionTreatmentService the conversionTreatmentService to set
	 */
	public void setConversionTreatmentService(ConversionTreatmentService conversionTreatmentService) {
		this.conversionTreatmentService = conversionTreatmentService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get conversionTreatmentManageDto
	 * @return the conversionTreatmentManageDto
	 */
	public ConversionTreatmentManageDto getConversionTreatmentManageDto() {
		return conversionTreatmentManageDto;
	}

	/**
	 * set conversionTreatmentManageDto
	 * @param conversionTreatmentManageDto the conversionTreatmentManageDto to set
	 */
	public void setConversionTreatmentManageDto(ConversionTreatmentManageDto conversionTreatmentManageDto) {
		this.conversionTreatmentManageDto = conversionTreatmentManageDto;
	}

	/**
	 * get conversionTreatmentList
	 * @return the conversionTreatmentList
	 */
	public List<ConversionTreatment> getConversionTreatmentList() {
		return conversionTreatmentList;
	}

	/**
	 * set conversionTreatmentList
	 * @param conversionTreatmentList the conversionTreatmentList to set
	 */
	public void setConversionTreatmentList(List<ConversionTreatment> conversionTreatmentList) {
		this.conversionTreatmentList = conversionTreatmentList;
	}

	/**
	 * get selectedModels
	 * @return the selectedModels
	 */
	public ConversionTreatment[] getSelectedModels() {
		return selectedModels;
	}

	/**
	 * set selectedModels
	 * @param selectedModels the selectedModels to set
	 */
	public void setSelectedModels(ConversionTreatment[] selectedModels) {
		this.selectedModels = selectedModels;
	}

}
