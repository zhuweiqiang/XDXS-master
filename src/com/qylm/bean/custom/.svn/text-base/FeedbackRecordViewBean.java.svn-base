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
import com.qylm.dto.custom.FeedbackRecordViewDto;
import com.qylm.dxo.FeedbackRecordViewDxo;
import com.qylm.entity.FeedbackRecord;
import com.qylm.service.FeedbackRecordService;

/**
 * 客户反馈记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class FeedbackRecordViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7823685049735854474L;

	/**
	 * 存放客户反馈记录登陆画面需要保存的值
	 */
	private FeedbackRecordViewDto feedbackRecordViewDto = new FeedbackRecordViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{feedbackRecordService}")
	private FeedbackRecordService feedbackRecordService;
	
	/**
	 * 查看详细
	 * @param feedbackRecord
	 * @return
	 */
	public String viewDetail(FeedbackRecord feedbackRecord) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(FeedbackRecord.class);
		detachedCriteria.createAlias(FeedbackRecord.CUSTOM_INFO, FeedbackRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.MARKETING_PROJECT, FeedbackRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.PRODUCT_STOCK, FeedbackRecord.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.PERSONNEL_INFO, FeedbackRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(FeedbackRecord.CREATER, FeedbackRecord.CREATER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(FeedbackRecord.BASE_ID, feedbackRecord.getId()));
		List<FeedbackRecord> feedbackRecordList = feedbackRecordService.getByDetachedCriteria(detachedCriteria);
		if (!feedbackRecordList.isEmpty()) {
			feedbackRecord = feedbackRecordList.get(0);
			FeedbackRecordViewDxo.entityToDto(feedbackRecord, feedbackRecordViewDto);
		}
		return Navigation.FEEDBACK_RECORD_VIEW;
	}
	
	/**
	 * @param feedbackRecordService the feedbackRecordService to set
	 */
	public void setFeedbackRecordService(FeedbackRecordService feedbackRecordService) {
		this.feedbackRecordService = feedbackRecordService;
	}

	/**
	 * @return the feedbackRecordViewDto
	 */
	public FeedbackRecordViewDto getFeedbackRecordViewDto() {
		return feedbackRecordViewDto;
	}

	/**
	 * @param feedbackRecordViewDto the feedbackRecordViewDto to set
	 */
	public void setFeedbackRecordViewDto(FeedbackRecordViewDto feedbackRecordViewDto) {
		this.feedbackRecordViewDto = feedbackRecordViewDto;
	}

}
