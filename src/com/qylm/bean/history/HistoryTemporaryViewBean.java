package com.qylm.bean.history;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.history.HistoryTemporaryViewDto;
import com.qylm.dxo.HistoryTemporaryViewDxo;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.MealBuyRecordService;

/**
 * 客户套餐记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryTemporaryViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3799015749882894166L;

	/**
	 * 存放客户套餐记录登陆画面需要保存的值
	 */
	private HistoryTemporaryViewDto historyTemporaryViewDto = new HistoryTemporaryViewDto();
	
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
			HistoryTemporaryViewDxo.entityToDto(mealBuyRecord, historyTemporaryViewDto);
			detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
			detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD, mealBuyRecord));
			historyTemporaryViewDto.setMealBuyRecordDetailList(mealBuyRecordDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.HISTORY_TEMPORARY_VIEW;
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
	 * @return the historyTemporaryViewDto
	 */
	public HistoryTemporaryViewDto getHistoryTemporaryViewDto() {
		return historyTemporaryViewDto;
	}

	/**
	 * @param historyTemporaryViewDto the historyTemporaryViewDto to set
	 */
	public void setHistoryTemporaryViewDto(HistoryTemporaryViewDto historyTemporaryViewDto) {
		this.historyTemporaryViewDto = historyTemporaryViewDto;
	}

}
