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
import com.qylm.dto.baseSet.ProductStockViewDto;
import com.qylm.dxo.ProductStockViewDxo;
import com.qylm.entity.ProductStock;
import com.qylm.service.ProductStockService;

/**
 * 产品登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ProductStockViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9148218099764845624L;

	/**
	 * 存放产品登陆画面需要保存的值
	 */
	private ProductStockViewDto productStockViewDto = new ProductStockViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{productStockService}")
	private ProductStockService productStockService;
	
	/**
	 * 查看详细
	 * @param productStock
	 * @return
	 */
	public String viewDetail(ProductStock productStock) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductStock.class);
		detachedCriteria.add(Restrictions.eq(ProductStock.BASE_ID, productStock.getId()));
		detachedCriteria.createAlias(ProductStock.BRAND, ProductStock.BRAND, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ProductStock.SERIES, ProductStock.SERIES, JoinType.LEFT_OUTER_JOIN);
		List<ProductStock> productStockList = productStockService.getByDetachedCriteria(detachedCriteria);
		if (!productStockList.isEmpty()) {
			productStock = productStockList.get(0);
			ProductStockViewDxo.entityToDto(productStock, productStockViewDto);
		}
		return Navigation.PRODUCT_STOCK_VIEW;
	}
	
	/**
	 * @param productStockService the productStockService to set
	 */
	public void setProductStockService(ProductStockService productStockService) {
		this.productStockService = productStockService;
	}

	/**
	 * @return the productStockViewDto
	 */
	public ProductStockViewDto getProductStockViewDto() {
		return productStockViewDto;
	}

	/**
	 * @param productStockViewDto the productStockViewDto to set
	 */
	public void setProductStockViewDto(ProductStockViewDto productStockViewDto) {
		this.productStockViewDto = productStockViewDto;
	}

}
