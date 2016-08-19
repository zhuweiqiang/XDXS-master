package com.qylm.bean.custom;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.custom.MealBuyRecordViewDto;
import com.qylm.dxo.MealBuyRecordViewDxo;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.MealBuyRecordService;

/**
 * 套餐购买记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class MealBuyRecordViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1104900982104569693L;

	/**
	 * 存放套餐购买记录登陆画面需要保存的值
	 */
	private MealBuyRecordViewDto mealBuyRecordViewDto = new MealBuyRecordViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordService}")
	private MealBuyRecordService mealBuyRecordService;
	
	/**
	 * 临时套餐详细业务类
	 */
	@ManagedProperty(value="#{mealBuyRecordDetailService}")
	private MealBuyRecordDetailService mealBuyRecordDetailService;
	
	/**
	 * 查看详细
	 * @param mealBuyRecord
	 * @return
	 */
	public String viewDetail(MealBuyRecord mealBuyRecord) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecord.class);
		detachedCriteria.createAlias(MealBuyRecord.CUSTOMINFO, MealBuyRecord.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.TEMPORARY_ACTIVITY, MealBuyRecord.TEMPORARY_ACTIVITY, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MealBuyRecord.CREATER, MealBuyRecord.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MealBuyRecord.BASE_ID, mealBuyRecord.getId()));
		List<MealBuyRecord> mealBuyRecordList = mealBuyRecordService.getByDetachedCriteria(detachedCriteria);
		if (!mealBuyRecordList.isEmpty()) {
			mealBuyRecord = mealBuyRecordList.get(0);
			MealBuyRecordViewDxo.entityToDto(mealBuyRecord, mealBuyRecordViewDto);
			detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
			detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD, mealBuyRecord));
			mealBuyRecordViewDto.setMealBuyRecordDetailList(mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.MEAL_BUY_RECORD_VIEW;
	}
	
	/**
	 * @param mealBuyRecordDetailService the mealBuyRecordDetailService to set
	 */
	public void setMealBuyRecordDetailService(
			MealBuyRecordDetailService mealBuyRecordDetailService) {
		this.mealBuyRecordDetailService = mealBuyRecordDetailService;
	}

	/**
	 * @param mealBuyRecordService the mealBuyRecordService to set
	 */
	public void setMealBuyRecordService(MealBuyRecordService mealBuyRecordService) {
		this.mealBuyRecordService = mealBuyRecordService;
	}

	/**
	 * @return the mealBuyRecordViewDto
	 */
	public MealBuyRecordViewDto getMealBuyRecordViewDto() {
		return mealBuyRecordViewDto;
	}

	/**
	 * @param mealBuyRecordViewDto the mealBuyRecordViewDto to set
	 */
	public void setMealBuyRecordViewDto(MealBuyRecordViewDto mealBuyRecordViewDto) {
		this.mealBuyRecordViewDto = mealBuyRecordViewDto;
	}

}
