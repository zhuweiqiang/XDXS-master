package com.qylm.bean.depot;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.common.Navigation;
import com.qylm.dto.depot.ProductDepotAllotViewDto;
import com.qylm.dxo.ProductDepotAllotViewDxo;
import com.qylm.entity.ProductDepotAllot;
import com.qylm.service.ProductDepotAllotService;

/**
 * 仓库库存调拨登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProductDepotAllotViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1053923903872234533L;

	/**
	 * 存放仓库库存调拨登陆画面需要保存的值
	 */
	private ProductDepotAllotViewDto productDepotAllotViewDto = new ProductDepotAllotViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{productDepotAllotService}")
	private ProductDepotAllotService productDepotAllotService;
	
	/**
	 * 查看详细
	 * @param productDepotAllot
	 * @return
	 */
	public String viewDetail(ProductDepotAllot productDepotAllot) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductDepotAllot.class);
		detachedCriteria.createAlias(ProductDepotAllot.DEPOT_INFO, ProductDepotAllot.DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.ALLOT_DEPOT_INFO, ProductDepotAllot.ALLOT_DEPOT_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.ALLOT_PRODUCT_STOCK_DETAIL, ProductDepotAllot.ALLOT_PRODUCT_STOCK_DETAIL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.PRODUCT_STOCK_DETAIL, ProductDepotAllot.PRODUCT_STOCK_DETAIL, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductDepotAllot.PRODUCT_STOCK_DETAIL_PRODUCT_STOCK, ProductDepotAllot.PRODUCT_STOCK, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ProductDepotAllot.BASE_ID, productDepotAllot.getId()));
		List<ProductDepotAllot> productDepotAllotList = productDepotAllotService.getByDetachedCriteria(detachedCriteria);
		if (!productDepotAllotList.isEmpty()) {
			productDepotAllot = productDepotAllotList.get(0);
			ProductDepotAllotViewDxo.entityToDto(productDepotAllot, productDepotAllotViewDto);
		}
		return Navigation.PRODUCT_DEPOT_ALLOT_VIEW;
	}
	
	/**
	 * @param productDepotAllotService the productDepotAllotService to set
	 */
	public void setProductDepotAllotService(ProductDepotAllotService productDepotAllotService) {
		this.productDepotAllotService = productDepotAllotService;
	}

	/**
	 * @return the productDepotAllotViewDto
	 */
	public ProductDepotAllotViewDto getProductDepotAllotViewDto() {
		return productDepotAllotViewDto;
	}

	/**
	 * @param productDepotAllotViewDto the productDepotAllotViewDto to set
	 */
	public void setProductDepotAllotViewDto(ProductDepotAllotViewDto productDepotAllotViewDto) {
		this.productDepotAllotViewDto = productDepotAllotViewDto;
	}

}
