package com.qylm.bean.prepareGoods;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.prepareGoods.ShopAppleViewDto;
import com.qylm.dxo.ShopAppleViewDxo;
import com.qylm.entity.ShopApple;
import com.qylm.entity.ShopAppleDetail;
import com.qylm.service.ShopAppleDetailService;
import com.qylm.service.ShopAppleService;

/**
 * 店铺申请配货登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ShopAppleViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5608057094399776469L;

	/**
	 * 存放店铺申请配货登陆画面需要保存的值
	 */
	private ShopAppleViewDto shopAppleViewDto = new ShopAppleViewDto();
	
	/**
	 * 店铺申请配货业务类
	 */
	@ManagedProperty(value="#{shopAppleService}")
	private ShopAppleService shopAppleService;
	
	/**
	 *店铺申请配货详细务类
	 */
	@ManagedProperty(value="#{shopAppleDetailService}")
	private ShopAppleDetailService shopAppleDetailService;
	
	/**
	 * 查看详细
	 * @param shopApple
	 * @return
	 */
	public String viewDetail(ShopApple shopApple) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ShopApple.class);
		detachedCriteria.createAlias(ShopApple.DEPOT_INFO, ShopApple.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ShopApple.USER, ShopApple.USER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ShopApple.BASE_ID, shopApple.getId()));
		List<ShopApple> shopAppleList = shopAppleService.getByDetachedCriteria(detachedCriteria);
		if (!shopAppleList.isEmpty()) {
			shopApple = shopAppleList.get(0);
			ShopAppleViewDxo.entityToDto(shopApple, shopAppleViewDto);
			 detachedCriteria = DetachedCriteria.forClass(ShopAppleDetail.class);
			 detachedCriteria.createAlias(ShopAppleDetail.PRODUCT_STOCK, ShopAppleDetail.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
			 detachedCriteria.createAlias(ShopAppleDetail.SHOP_APPLE, ShopAppleDetail.SHOP_APPLE, JoinType.LEFT_OUTER_JOIN);
			 detachedCriteria.add(Restrictions.eq(ShopAppleDetail.SHOP_APPLE, shopApple));
			 shopAppleViewDto.setShopAppleDetailList(shopAppleDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.SHOP_APPLE_VIEW;
	}
	
	/**
	 * @param shopAppleDetailService the shopAppleDetailService to set
	 */
	public void setShopAppleDetailService(
			ShopAppleDetailService shopAppleDetailService) {
		this.shopAppleDetailService = shopAppleDetailService;
	}

	/**
	 * @param shopAppleService the shopAppleService to set
	 */
	public void setShopAppleService(ShopAppleService shopAppleService) {
		this.shopAppleService = shopAppleService;
	}

	/**
	 * @return the shopAppleViewDto
	 */
	public ShopAppleViewDto getShopAppleViewDto() {
		return shopAppleViewDto;
	}

	/**
	 * @param shopAppleViewDto the shopAppleViewDto to set
	 */
	public void setShopAppleViewDto(ShopAppleViewDto shopAppleViewDto) {
		this.shopAppleViewDto = shopAppleViewDto;
	}

}
