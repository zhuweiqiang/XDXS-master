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
import com.qylm.dto.baseSet.GiveInfoViewDto;
import com.qylm.dxo.GiveInfoViewDxo;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;
import com.qylm.service.GiveInfoDetailService;
import com.qylm.service.GiveInfoService;

/**
 * 体验卡登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class GiveInfoViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5065461626667842677L;

	/**
	 * 存放体验卡登陆画面需要保存的值
	 */
	private GiveInfoViewDto giveInfoViewDto = new GiveInfoViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 体验卡详细业务类
	 */
	@ManagedProperty(value="#{giveInfoDetailService}")
	private GiveInfoDetailService giveInfoDetailService;
	
	/**
	 * 查看详细
	 * @param giveInfo
	 * @return
	 */
	public String viewDetail(GiveInfo giveInfo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.BASE_ID, giveInfo.getId()));
		List<GiveInfo> giveInfoList = giveInfoService.getByDetachedCriteria(detachedCriteria);
		if (!giveInfoList.isEmpty()) {
			giveInfo = giveInfoList.get(0);
			GiveInfoViewDxo.entityToDto(giveInfo, giveInfoViewDto);
			detachedCriteria = DetachedCriteria.forClass(GiveInfoDetail.class);
			detachedCriteria.createAlias(GiveInfoDetail.GIVE_INFO, GiveInfoDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(GiveInfoDetail.PRODUCT_STOCK_DETIAL, GiveInfoDetail.PRODUCT_STOCK_DETIAL, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(GiveInfoDetail.MARKETING_PROJECT, GiveInfoDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(GiveInfoDetail.GIVE_INFO, giveInfo));
			List<GiveInfoDetail> giveInfoDetailList = giveInfoDetailService.getByDetachedCriteria(detachedCriteria);
			giveInfoViewDto.setGiveInfoDetailList(giveInfoDetailList);
		}
		return Navigation.GIVE_INFO_VIEW;
	}
	
	/**
	 * @param giveInfoDetailService the giveInfoDetailService to set
	 */
	public void setGiveInfoDetailService(GiveInfoDetailService giveInfoDetailService) {
		this.giveInfoDetailService = giveInfoDetailService;
	}

	/**
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}

	/**
	 * @return the giveInfoViewDto
	 */
	public GiveInfoViewDto getGiveInfoViewDto() {
		return giveInfoViewDto;
	}

	/**
	 * @param giveInfoViewDto the giveInfoViewDto to set
	 */
	public void setGiveInfoViewDto(GiveInfoViewDto giveInfoViewDto) {
		this.giveInfoViewDto = giveInfoViewDto;
	}

}
