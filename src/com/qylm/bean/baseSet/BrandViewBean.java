package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.common.Navigation;
import com.qylm.dto.baseSet.BrandViewDto;
import com.qylm.dxo.BrandViewDxo;
import com.qylm.entity.Brand;
import com.qylm.service.BrandService;

/**
 * 品牌登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class BrandViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1609639535022836123L;

	/**
	 * 存放品牌登陆画面需要保存的值
	 */
	private BrandViewDto brandViewDto = new BrandViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{brandService}")
	private BrandService brandService;
	
	/**
	 * 查看详细
	 * @param brand
	 * @return
	 */
	public String viewDetail(Brand brand) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Brand.class);
		detachedCriteria.add(Restrictions.eq(Brand.BASE_ID, brand.getId()));
		List<Brand> brandList = brandService.getByDetachedCriteria(detachedCriteria);
		if (!brandList.isEmpty()) {
			brand = brandList.get(0);
			BrandViewDxo.entityToDto(brand, brandViewDto);
		}
		return Navigation.BRAND_VIEW;
	}
	
	/**
	 * @param brandService the brandService to set
	 */
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	/**
	 * @return the brandViewDto
	 */
	public BrandViewDto getBrandViewDto() {
		return brandViewDto;
	}

	/**
	 * @param brandViewDto the brandViewDto to set
	 */
	public void setBrandViewDto(BrandViewDto brandViewDto) {
		this.brandViewDto = brandViewDto;
	}

}
