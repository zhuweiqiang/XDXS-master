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
import com.qylm.dto.history.HistoryFeedbackRecordViewDto;
import com.qylm.dxo.HistoryFeedbackRecordViewDxo;
import com.qylm.entity.FeedbackRecord;
import com.qylm.service.FeedbackRecordService;

/**
 * 客户反馈记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryFeedbackRecordViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7603324174270735793L;

	/**
	 * 存放客户反馈记录登陆画面需要保存的值
	 */
	private HistoryFeedbackRecordViewDto historyHistoryFeedbackRecordViewDto = new HistoryFeedbackRecordViewDto();
	
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
			HistoryFeedbackRecordViewDxo.entityToDto(feedbackRecord, historyHistoryFeedbackRecordViewDto);
		}
		return Navigation.HISTORY_FEEDBACK_RECORD_VIEW;
	}
	
	/**
	 * @param feedbackRecordService the feedbackRecordService to set
	 */
	public void setFeedbackRecordService(FeedbackRecordService feedbackRecordService) {
		this.feedbackRecordService = feedbackRecordService;
	}

	/**
	 * @return the historyHistoryFeedbackRecordViewDto
	 */
	public HistoryFeedbackRecordViewDto getHistoryFeedbackRecordViewDto() {
		return historyHistoryFeedbackRecordViewDto;
	}

	/**
	 * @param historyHistoryFeedbackRecordViewDto the historyHistoryFeedbackRecordViewDto to set
	 */
	public void setHistoryFeedbackRecordViewDto(HistoryFeedbackRecordViewDto historyHistoryFeedbackRecordViewDto) {
		this.historyHistoryFeedbackRecordViewDto = historyHistoryFeedbackRecordViewDto;
	}

}
