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
import com.qylm.dto.custom.ConversionTreatmentViewDto;
import com.qylm.dxo.ConversionTreatmentViewDxo;
import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.ConversionTreatmentDetail;
import com.qylm.service.ConversionTreatmentDetailService;
import com.qylm.service.ConversionTreatmentService;

/**
 * 产品销售登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ConversionTreatmentViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7474218448164550115L;

	/**
	 * 存放产品销售登陆画面需要保存的值
	 */
	private ConversionTreatmentViewDto conversionTreatmentViewDto = new ConversionTreatmentViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{conversionTreatmentService}")
	private ConversionTreatmentService conversionTreatmentService;
	
	/**
	 * 事件详细业务类
	 */
	@ManagedProperty(value="#{conversionTreatmentDetailService}")
	private ConversionTreatmentDetailService conversionTreatmentDetailService;
	
	/**
	 * 查看详细
	 * @param conversionTreatment
	 * @return
	 */
	public String viewDetail(ConversionTreatment conversionTreatment) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ConversionTreatment.class);
		detachedCriteria.createAlias(ConversionTreatment.CUSTOMINFO, ConversionTreatment.CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(ConversionTreatment.PERSONNEL_INFO, ConversionTreatment.PERSONNEL_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(ConversionTreatment.BASE_ID, conversionTreatment.getId()));
		List<ConversionTreatment> conversionTreatmentList = conversionTreatmentService.getByDetachedCriteria(detachedCriteria);
		if (!conversionTreatmentList.isEmpty()) {
			conversionTreatment = conversionTreatmentList.get(0);
			ConversionTreatmentViewDxo.entityToDto(conversionTreatment, conversionTreatmentViewDto);
			detachedCriteria = DetachedCriteria.forClass(ConversionTreatmentDetail.class);
			detachedCriteria.createAlias(ConversionTreatmentDetail.MARKETING_PROJECT, ConversionTreatmentDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ConversionTreatmentDetail.CONVERSION_TREATMENT, ConversionTreatmentDetail.CONVERSION_TREATMENT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ConversionTreatmentDetail.CONVERSION_TREATMENT, conversionTreatment));
			conversionTreatmentViewDto.setConversionTreatmentDetailList(conversionTreatmentDetailService.getByDetachedCriteria(detachedCriteria));
		}
		return Navigation.CONVERSION_TREATMENT_VIEW;
	}
	
	/**
	 * @param conversionTreatmentDetailService the conversionTreatmentDetailService to set
	 */
	public void setConversionTreatmentDetailService(
			ConversionTreatmentDetailService conversionTreatmentDetailService) {
		this.conversionTreatmentDetailService = conversionTreatmentDetailService;
	}

	/**
	 * @param conversionTreatmentService the conversionTreatmentService to set
	 */
	public void setConversionTreatmentService(ConversionTreatmentService conversionTreatmentService) {
		this.conversionTreatmentService = conversionTreatmentService;
	}

	/**
	 * @return the conversionTreatmentViewDto
	 */
	public ConversionTreatmentViewDto getConversionTreatmentViewDto() {
		return conversionTreatmentViewDto;
	}

	/**
	 * @param conversionTreatmentViewDto the conversionTreatmentViewDto to set
	 */
	public void setConversionTreatmentViewDto(ConversionTreatmentViewDto conversionTreatmentViewDto) {
		this.conversionTreatmentViewDto = conversionTreatmentViewDto;
	}

}
