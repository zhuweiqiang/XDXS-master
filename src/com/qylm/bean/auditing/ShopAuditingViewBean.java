package com.qylm.bean.auditing;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.auditing.ShopAuditingViewDto;
import com.qylm.dxo.ShopAuditingViewDxo;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.entity.ShopAuditing;
import com.qylm.service.ShopAppleDetailService;
import com.qylm.service.ShopAuditingService;

/**
 * 店铺配货审核登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ShopAuditingViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4294312341090981641L;

	/**
	 * 存放店铺配货审核登陆画面需要保存的值
	 */
	private ShopAuditingViewDto shopAuditingViewDto = new ShopAuditingViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{shopAuditingService}")
	private ShopAuditingService shopAuditingService;
	
	/**
	 *店铺申请配货详细务类
	 */
	@ManagedProperty(value="#{shopAppleDetailService}")
	private ShopAppleDetailService shopAppleDetailService;
	
	/**
	 * 查看详细
	 * @param shopAuditing
	 * @return
	 */
	public String viewDetail(ShopAuditing shopAuditing) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopAuditing.class);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE, ShopAuditing.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE_DEPOT_INFO, ShopAuditing.SHOP_APPLE_DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAuditing.SHOP_APPLE_USER, ShopAuditing.SHOP_APPLE_USER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopAuditing.AUDITOR, ShopAuditing.AUDITOR, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ShopAuditing.BASE_ID, shopAuditing.getId()));
		List<ShopAuditing> shopAuditingList = shopAuditingService.getByDetachedCriteria(detachedCriteria);
		if (!shopAuditingList.isEmpty()) {
			shopAuditing = shopAuditingList.get(0);
			ShopAuditingViewDxo.entityToDto(shopAuditing, shopAuditingViewDto);
			ShopApple shopApple = shopAuditingViewDto.getShopApple();
			detachedCriteria = DetachedCriteria.forClass(ShopAppleDetail.class);
			detachedCriteria.createAlias(ShopAppleDetail.PRODUCT_STOCK, ShopAppleDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ShopAppleDetail.SHOP_APPLE, ShopAppleDetail.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ShopAppleDetail.SHOP_APPLE, shopApple));
			shopApple.setShopAppleDetailList(shopAppleDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.SHOP_AUDITING_VIEW;
	}
	
	/**
	 * @param shopAppleDetailService the shopAppleDetailService to set
	 */
	public void setShopAppleDetailService(
			ShopAppleDetailService shopAppleDetailService) {
		this.shopAppleDetailService = shopAppleDetailService;
	}

	/**
	 * @param shopAuditingService the shopAuditingService to set
	 */
	public void setShopAuditingService(ShopAuditingService shopAuditingService) {
		this.shopAuditingService = shopAuditingService;
	}

	/**
	 * @return the shopAuditingViewDto
	 */
	public ShopAuditingViewDto getShopAuditingViewDto() {
		return shopAuditingViewDto;
	}

	/**
	 * @param shopAuditingViewDto the shopAuditingViewDto to set
	 */
	public void setShopAuditingViewDto(ShopAuditingViewDto shopAuditingViewDto) {
		this.shopAuditingViewDto = shopAuditingViewDto;
	}

}
