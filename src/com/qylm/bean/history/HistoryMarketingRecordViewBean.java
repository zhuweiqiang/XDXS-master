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
import com.qylm.dto.history.HistoryMarketingRecordViewDto;
import com.qylm.dxo.HistoryMarketingRecordViewDxo;
import com.qylm.entity.MarketingRecord;
import com.qylm.entity.MarketingRecordDetail;
import com.qylm.service.MarketingRecordDetailService;
import com.qylm.service.MarketingRecordService;

/**
 * 客户产品记录登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryMarketingRecordViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7015412521893536135L;

	/**
	 * 存放客户产品记录登陆画面需要保存的值
	 */
	private HistoryMarketingRecordViewDto historyMarketingRecordViewDto = new HistoryMarketingRecordViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{marketingRecordService}")
	private MarketingRecordService marketingRecordService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{marketingRecordDetailService}")
	private MarketingRecordDetailService marketingRecordDetailService;
	
	/**
	 * 查看详细
	 * @param marketingRecord
	 * @return
	 */
	public String viewDetail(MarketingRecord marketingRecord) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MarketingRecord.class);
		detachedCriteria.createAlias(MarketingRecord.CUSTOMINFO, MarketingRecord.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(MarketingRecord.PERSONNEL_INFO, MarketingRecord.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(MarketingRecord.BASE_ID, marketingRecord.getId()));
		List<MarketingRecord> marketingRecordList = marketingRecordService.getByDetachedCriteria(detachedCriteria);
		if (!marketingRecordList.isEmpty()) {
			marketingRecord = marketingRecordList.get(0);
			HistoryMarketingRecordViewDxo.entityToDto(marketingRecord, historyMarketingRecordViewDto);
			detachedCriteria = DetachedCriteria.forClass(MarketingRecordDetail.class);
			detachedCriteria.createAlias(MarketingRecordDetail.MARKETING_RECORD, MarketingRecordDetail.MARKETING_RECORD, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK, MarketingRecordDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK_BRAND, MarketingRecordDetail.PRODUCT_STOCK_BRAND, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MarketingRecordDetail.PRODUCT_STOCK_SERIES, MarketingRecordDetail.PRODUCT_STOCK_SERIES, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MarketingRecordDetail.DEPOT_INFO, MarketingRecordDetail.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(MarketingRecordDetail.MARKETING_RECORD, marketingRecord));
			historyMarketingRecordViewDto.setMarketingRecordDetailList(marketingRecordDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.HISTORY_MARKETING_RECORD_VIEW;
	}
	
	/**
	 * @param marketingRecordDetailService the marketingRecordDetailService to set
	 */
	public void setMarketingRecordDetailService(
			MarketingRecordDetailService marketingRecordDetailService) {
		this.marketingRecordDetailService = marketingRecordDetailService;
	}

	/**
	 * @param marketingRecordService the marketingRecordService to set
	 */
	public void setMarketingRecordService(MarketingRecordService marketingRecordService) {
		this.marketingRecordService = marketingRecordService;
	}

	/**
	 * @return the historyMarketingRecordViewDto
	 */
	public HistoryMarketingRecordViewDto getHistoryMarketingRecordViewDto() {
		return historyMarketingRecordViewDto;
	}

	/**
	 * @param historyMarketingRecordViewDto the historyMarketingRecordViewDto to set
	 */
	public void setHistoryMarketingRecordViewDto(HistoryMarketingRecordViewDto historyMarketingRecordViewDto) {
		this.historyMarketingRecordViewDto = historyMarketingRecordViewDto;
	}

}
