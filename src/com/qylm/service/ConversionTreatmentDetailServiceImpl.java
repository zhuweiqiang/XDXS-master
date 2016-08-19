package com.qylm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qylm.dao.ConversionTreatmentDetailDao;
import com.qylm.entity.ConversionTreatmentDetail;

@Service("conversionTreatmentDetailService")
public class ConversionTreatmentDetailServiceImpl extends GenericServiceImpl<ConversionTreatmentDetail, Integer> implements ConversionTreatmentDetailService {

	@Autowired
	protected ConversionTreatmentDetailServiceImpl(ConversionTreatmentDetailDao conversionTreatmentDetailDao) {
		super(conversionTreatmentDetailDao);
	}

}
