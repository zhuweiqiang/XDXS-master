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
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.baseSet.CustomInfoNurseCreateDto;
import com.qylm.dto.history.HistoryArrearageViewDto;
import com.qylm.dto.history.HistoryTemporaryViewDto;
import com.qylm.dxo.CustomInfoViewDxo;
import com.qylm.dxo.HistoryTemporaryViewDxo;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.service.CustomInfoService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.MealBuyRecordService;

/**
 * 客户欠款登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryArrearageViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2329907007986737276L;

	/**
	 * 存放客户套餐记录登陆画面需要保存的值
	 */
	private HistoryArrearageViewDto historyArrearageViewDto = new HistoryArrearageViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{customInfoService}")
	private CustomInfoService customInfoService;
	
	/**
	 * 查看详细
	 * @param customInfo
	 * @return
	 */
	public String viewDetail(CustomInfo customInfo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomInfo.class);
		detachedCriteria.createAlias(CustomInfo.PERSONNEL_INFO_1, CustomInfo.PERSONNEL_INFO_1, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomInfo.PERSONNEL_INFO_2, CustomInfo.PERSONNEL_INFO_2, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomInfo.BASE_ID, customInfo.getId()));
		List<CustomInfo> customInfoList = customInfoService.getByDetachedCriteria(detachedCriteria);
		if (!customInfoList.isEmpty()) {
			customInfo = customInfoList.get(0);
			CustomInfoViewDxo.entityToDto(customInfo, historyArrearageViewDto);
			historyArrearageViewDto.setSkinType(StringUtil.split(customInfo.getSkinType(), Constants.COMMA));
			historyArrearageViewDto.setOcularRegionState(StringUtil.split(customInfo.getOcularRegionState(), Constants.COMMA));
			historyArrearageViewDto.setFaceState(StringUtil.split(customInfo.getFaceState(), Constants.COMMA));
			historyArrearageViewDto.setFaceNeed(StringUtil.split(customInfo.getFaceNeed(), Constants.COMMA));
			historyArrearageViewDto.setDietPractice(StringUtil.split(customInfo.getDietPractice(), Constants.COMMA));
			historyArrearageViewDto.setStapleFood(StringUtil.split(customInfo.getStapleFood(), Constants.COMMA));
			historyArrearageViewDto.setRepast(StringUtil.split(customInfo.getRepast(), Constants.COMMA));
			historyArrearageViewDto.setAddSeasonings(StringUtil.split(customInfo.getAddSeasonings(), Constants.COMMA));
			historyArrearageViewDto.setXhwd(StringUtil.split(customInfo.getXhwd(), Constants.COMMA));
			historyArrearageViewDto.setYzsw(StringUtil.split(customInfo.getYzsw(), Constants.COMMA));
			historyArrearageViewDto.setDietaryBias(StringUtil.split(customInfo.getDietaryBias(), Constants.COMMA));
			historyArrearageViewDto.setPac(StringUtil.split(customInfo.getPac(), Constants.COMMA));
			historyArrearageViewDto.setDiet(StringUtil.split(customInfo.getDiet(), Constants.COMMA));
			historyArrearageViewDto.setHealthState(StringUtil.split(customInfo.getHealthState(), Constants.COMMA));
			historyArrearageViewDto.setYjkzt(StringUtil.split(customInfo.getYjkzt(), Constants.COMMA));
			historyArrearageViewDto.setHljy(customInfo.isHljy() ? "1" : "2");
		}
		return Navigation.HISTORY_ARREARAGE_VIEW;
	}

	/**
	 * @return the historyArrearageViewDto
	 */
	public HistoryArrearageViewDto getHistoryArrearageViewDto() {
		return historyArrearageViewDto;
	}

	/**
	 * @param historyArrearageViewDto the historyArrearageViewDto to set
	 */
	public void setHistoryArrearageViewDto(
			HistoryArrearageViewDto historyArrearageViewDto) {
		this.historyArrearageViewDto = historyArrearageViewDto;
	}

	/**
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

}
