package com.qylm.logic.custom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.constants.Constants;
import com.qylm.dao.ConversionTreatmentDao;
import com.qylm.dao.ConversionTreatmentDetailDao;
import com.qylm.dao.CustomInfoDao;
import com.qylm.dao.LargessRecordDao;
import com.qylm.dao.MealBuyRecordDetailDao;
import com.qylm.dao.ProjectBuyDetailDao;
import com.qylm.entity.ConversionTreatment;
import com.qylm.entity.ConversionTreatmentDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.ProjectBuyDetail;

public class ConversionTreatmentLogic {
	
	@Autowired
	private ConversionTreatmentDao conversionTreatmentDao;
	
	@Autowired
	private ConversionTreatmentDetailDao conversionTreatmentDetailDao;
	
	@Autowired
	private LargessRecordDao largessRecordDao;
	
	@Autowired
	private MealBuyRecordDetailDao mealBuyRecordDetailDao;
	
	@Autowired
	private ProjectBuyDetailDao projectBuyDetailDao;
	
	@Autowired
	private CustomInfoDao customInfoDao;
	
	public void saveConversionTreatment(
			ConversionTreatment conversionTreatment,
			List<ConversionTreatmentDetail> conversionTreatmentDetailList) {
		conversionTreatmentDao.saveEntity(conversionTreatment);
		conversionTreatmentDetailDao.saveEntityAll(conversionTreatmentDetailList);
		// 扣除对应的赠送项目数量，并累加转换金额，赠送项目不累计
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		Map<Integer, Integer> largessRecordMaps = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mealBuyRecordDetailMaps = new HashMap<Integer, Integer>();
		Map<Integer, Integer> projectBuyDetailMaps = new HashMap<Integer, Integer>();
		for (ConversionTreatmentDetail conversionTreatmentDetail : conversionTreatmentDetailList) {
			Integer type = conversionTreatmentDetail.getType();
			if (ConversionTreatmentDetail.TYPE_2.equals(type)) {
				largessRecordMaps.put(conversionTreatmentDetail.getTypeId(), conversionTreatmentDetail.getNumber());
			} else if (ConversionTreatmentDetail.TYPE_3.equals(type)) {
				mealBuyRecordDetailMaps.put(conversionTreatmentDetail.getTypeId(), conversionTreatmentDetail.getNumber());
				sumMoney = BigDecimalUtil.add(sumMoney, conversionTreatmentDetail.getSumMoney());
			} else {
				projectBuyDetailMaps.put(conversionTreatmentDetail.getTypeId(), conversionTreatmentDetail.getNumber());
				sumMoney = BigDecimalUtil.add(sumMoney, conversionTreatmentDetail.getSumMoney());
			}
		}
		List<Integer> idList;
		if (!largessRecordMaps.isEmpty()) {
			idList = new ArrayList<Integer>();
			for (Entry<Integer, Integer> map : largessRecordMaps.entrySet()) {
				idList.add(map.getKey());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
			detachedCriteria.add(Restrictions.in(LargessRecord.BASE_ID, idList));
			List<LargessRecord> list = largessRecordDao.getByDetachedCriteria(detachedCriteria);
			// 数量扣除
			for (LargessRecord largessRecord : list) {
				for (Entry<Integer, Integer> map : largessRecordMaps.entrySet()) {
					if (largessRecord.getId().equals(map.getKey())) {
						largessRecord.setSurplusNumber(largessRecord.getSurplusNumber() - map.getValue());
						largessRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
						break;
					}
				}
			}
			largessRecordDao.updateEntityAll(list);
		}
		// 活动套餐详细
		if (!mealBuyRecordDetailMaps.isEmpty()) {
			idList = new ArrayList<Integer>();
			for (Entry<Integer, Integer> map : mealBuyRecordDetailMaps.entrySet()) {
				idList.add(map.getKey());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
			detachedCriteria.add(Restrictions.in(MealBuyRecordDetail.BASE_ID, idList));
			List<MealBuyRecordDetail> list = mealBuyRecordDetailDao.getByDetachedCriteria(detachedCriteria);
			// 数量扣除
			for (MealBuyRecordDetail detail : list) {
				for (Entry<Integer, Integer> map : mealBuyRecordDetailMaps.entrySet()) {
					if (detail.getId().equals(map.getKey())) {
						System.out.println("detail.getSurplusNumber():" + detail.getSurplusNumber());
						System.out.println("map.getValue():" + map.getValue());
						detail.setSurplusNumber(detail.getSurplusNumber() - map.getValue());
						detail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
						break;
					}
				}
			}
			mealBuyRecordDetailDao.updateEntityAll(list);
		}
		// 项目购买记录详细持久化类
		if (!projectBuyDetailMaps.isEmpty()) {
			idList = new ArrayList<Integer>();
			for (Entry<Integer, Integer> map : projectBuyDetailMaps.entrySet()) {
				idList.add(map.getKey());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
			detachedCriteria.add(Restrictions.in(ProjectBuyDetail.BASE_ID, idList));
			List<ProjectBuyDetail> list = projectBuyDetailDao.getByDetachedCriteria(detachedCriteria);
			// 数量扣除
			for (ProjectBuyDetail detail : list) {
				for (Entry<Integer, Integer> map : projectBuyDetailMaps.entrySet()) {
					if (detail.getId().equals(map.getKey())) {
						detail.setSurplusNumber(detail.getSurplusNumber() - map.getValue());
						detail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
						break;
					}
				}
			}
			projectBuyDetailDao.updateEntityAll(list);
		}
		if (BigDecimalUtil.isNotNullOrZero(sumMoney)) {
			CustomInfo customInfo = conversionTreatment.getCustomInfo();
			customInfo.setMoney(BigDecimalUtil.add(sumMoney, customInfo.getMoney()));
			customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			customInfoDao.updateEntity(customInfo);
		}
	}
	
}
