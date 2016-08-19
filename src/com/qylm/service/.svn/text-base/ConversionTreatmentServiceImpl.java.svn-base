package com.qylm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qylm.dao.ConversionTreatmentDao;
import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.ConversionTreatmentDetail;
import com.qylm.logic.custom.ConversionTreatmentLogic;

@Service("conversionTreatmentService")
public class ConversionTreatmentServiceImpl extends GenericServiceImpl<ConversionTreatment, Integer> implements ConversionTreatmentService {

	@Autowired
	private ConversionTreatmentLogic conversionTreatmentLogic;
	
	@Autowired
	protected ConversionTreatmentServiceImpl(ConversionTreatmentDao conversionTreatmentDao) {
		super(conversionTreatmentDao);
	}

	public void saveConversionTreatment(
			ConversionTreatment conversionTreatment,
			List<ConversionTreatmentDetail> conversionTreatmentDetailList) {
		conversionTreatmentLogic.saveConversionTreatment(conversionTreatment, conversionTreatmentDetailList);
	}

}
