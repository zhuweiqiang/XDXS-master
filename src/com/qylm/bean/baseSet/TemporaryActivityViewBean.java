package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.baseSet.TemporaryActivityViewDto;
import com.qylm.dxo.TemporaryActivityViewDxo;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.service.TemporaryActivityDetailService;
import com.qylm.service.TemporaryActivityService;

/**
 * 活动套餐登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class TemporaryActivityViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7434823441681489097L;

	/**
	 * 存放活动套餐登陆画面需要保存的值
	 */
	private TemporaryActivityViewDto temporaryActivityViewDto = new TemporaryActivityViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{temporaryActivityService}")
	private TemporaryActivityService temporaryActivityService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{temporaryActivityDetailService}")
	private TemporaryActivityDetailService temporaryActivityDetailService;
	
	/**
	 * 查看详细
	 * @param temporaryActivity
	 * @return
	 */
	public String viewDetail(TemporaryActivity temporaryActivity) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TemporaryActivity.class);
		detachedCriteria.add(Restrictions.eq(TemporaryActivity.BASE_ID, temporaryActivity.getId()));
		List<TemporaryActivity> temporaryActivityList = temporaryActivityService.getByDetachedCriteria(detachedCriteria);
		if (!temporaryActivityList.isEmpty()) {
			temporaryActivity = temporaryActivityList.get(0);
			TemporaryActivityViewDxo.entityToDto(temporaryActivity, temporaryActivityViewDto);
			detachedCriteria = DetachedCriteria.forClass(TemporaryActivityDetail.class);
			detachedCriteria.createAlias(TemporaryActivityDetail.TEMPORARY_ACTIVITY, TemporaryActivityDetail.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(TemporaryActivityDetail.MARKETING_PROJECT, TemporaryActivityDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(TemporaryActivityDetail.TEMPORARY_ACTIVITY, temporaryActivity));
			temporaryActivityViewDto.setTemporaryActivityDetailList(temporaryActivityDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.TEMPORARY_ACTIVITY_VIEW;
	}
	
	/**
	 * @param temporaryActivityDetailService the temporaryActivityDetailService to set
	 */
	public void setTemporaryActivityDetailService(
			TemporaryActivityDetailService temporaryActivityDetailService) {
		this.temporaryActivityDetailService = temporaryActivityDetailService;
	}

	/**
	 * @param temporaryActivityService the temporaryActivityService to set
	 */
	public void setTemporaryActivityService(TemporaryActivityService temporaryActivityService) {
		this.temporaryActivityService = temporaryActivityService;
	}

	/**
	 * @return the temporaryActivityViewDto
	 */
	public TemporaryActivityViewDto getTemporaryActivityViewDto() {
		return temporaryActivityViewDto;
	}

	/**
	 * @param temporaryActivityViewDto the temporaryActivityViewDto to set
	 */
	public void setTemporaryActivityViewDto(TemporaryActivityViewDto temporaryActivityViewDto) {
		this.temporaryActivityViewDto = temporaryActivityViewDto;
	}

}
