package com.qylm.logic.custom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import com.qylm.common.MothedUtil;
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dao.ConsumptionDetailDao;
import com.qylm.dao.ConsumptionRegisterDao;
import com.qylm.dao.ConsumptionRegisterDetailDao;
import com.qylm.dao.CustomInfoDao;
import com.qylm.dao.CustomLeaguerDetailDao;
import com.qylm.dao.GiveInfoDao;
import com.qylm.dao.GiveInfoDetailDao;
import com.qylm.dao.LargessRecordDao;
import com.qylm.dao.LeaguerDao;
import com.qylm.dao.LeaguerDetailDao;
import com.qylm.dao.MealBuyRecordDetailDao;
import com.qylm.dao.ProjectBuyDetailDao;
import com.qylm.dto.myDesk.ShopCardDto;
import com.qylm.entity.ConsumptionDetail;
import com.qylm.entity.ConsumptionRegister;
import com.qylm.entity.ConsumptionRegisterDetail;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.GiveInfoDetail;
import com.qylm.entity.LargessRecord;
import com.qylm.entity.Leaguer;
import com.qylm.entity.LeaguerDetail;
import com.qylm.entity.MarketingProject;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.PersonnelInfo;
import com.qylm.entity.ProjectBuyDetail;
import com.qylm.entity.User;
import com.qylm.exception.ConsumptionException;

public class ConsumptionRegisterLogic {
	
	@Autowired
	private ConsumptionRegisterDao consumptionRegisterDao;
	
	@Autowired
	private ConsumptionRegisterDetailDao consumptionRegisterDetailDao;
	
	@Autowired
	private CustomInfoDao customInfoDao;
	
	@Autowired
	private LargessRecordDao largessRecordDao;
	
	@Autowired
	private MealBuyRecordDetailDao mealBuyRecordDetailDao;
	
	@Autowired
	private ProjectBuyDetailDao projectBuyDetailDao;
	
	@Autowired
	private LeaguerDao leaguerDao;
	
	@Autowired
	private LeaguerDetailDao leaguerDetailDao;
	
	@Autowired
	private CustomLeaguerDetailDao customLeaguerDetailDao;
	
	@Autowired
	private GiveInfoDao giveInfoDao;
	
	@Autowired
	private GiveInfoDetailDao giveInfoDetailDao;
	
	@Autowired
	private ConsumptionDetailDao consumptionDetailDao;
	
	public void saveConsumptionRegister(ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		consumptionRegisterDao.saveEntity(consumptionRegister);
		consumptionRegisterDetailDao.saveEntityAll(consumptionRegisterDetailList);
		compute(consumptionRegister, consumptionRegisterDetailList);
	}

	public void updateConsumptionRegister(ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		consumptionRegisterDao.updateEntity(consumptionRegister);
		consumptionRegisterDetailDao.saveOrUpdateAll(consumptionRegisterDetailList);
		compute(consumptionRegister, consumptionRegisterDetailList);
	}
	
	public void saveConsumptionRegister(ShopCardDto shopCardDto) {
		CustomInfo customInfo = shopCardDto.getCustomInfo();
		List<CustomLeaguerDetail> customLeaguerDetailList = new ArrayList<CustomLeaguerDetail>();
		getCustomLeaguer(shopCardDto, customInfo, customLeaguerDetailList);
		getLargessRecord(shopCardDto, customInfo, customLeaguerDetailList);
		// 扣除对应的费用
		// 建立个人消费登记表
		ConsumptionRegister consumptionRegister = getConsumptionRegister(
				customInfo, shopCardDto.getPersonnelInfo(),
				shopCardDto.getAdviser(), shopCardDto.getDate(),
				shopCardDto.getRealityMoney(), shopCardDto.getCreater());
		consumptionRegister.setType(ConsumptionRegister.TYPE_1);
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = getConsumptionRegisterDetailList(consumptionRegister, customLeaguerDetailList);
		saveConsumptionRegisterDetail(customInfo, shopCardDto.getDate(),
				shopCardDto.getRealityMoney(), shopCardDto.getBalance(),
				shopCardDto.getReadyMoney(), shopCardDto.getCreater(),
				customLeaguerDetailList, consumptionRegister,
				consumptionRegisterDetailList);
	}

	/**
	 * 获取体验卡
	 * @param shopCardDto
	 * @param customInfo
	 * @param customLeaguerDetailList
	 */
	private void getLargessRecord(ShopCardDto shopCardDto,
			CustomInfo customInfo,
			List<CustomLeaguerDetail> customLeaguerDetailList) {
		// 添加体验卡记录
		String[] experienceCardId = shopCardDto.getExperienceCardId();
		if (experienceCardId != null && experienceCardId.length > 0) {
			List<Integer> idList = new ArrayList<Integer>();
			for (String string : experienceCardId) {
				idList.add(Integer.valueOf(string));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
			detachedCriteria.add(Restrictions.in(GiveInfo.BASE_ID, idList));
			List<GiveInfo> giveInfoList = giveInfoDao.getByDetachedCriteria(detachedCriteria);
			CustomLeaguerDetail customLeaguerDetail;
			for (GiveInfo giveInfo : giveInfoList) {
				customLeaguerDetail = new CustomLeaguerDetail();
				customLeaguerDetail.setCreater(shopCardDto.getCreater());
				customLeaguerDetail.setBelongingUser(shopCardDto.getBelongingUser());
				customLeaguerDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				customLeaguerDetail.setCustomInfo(customInfo);
				customLeaguerDetail.setGiveInfo(giveInfo);
				customLeaguerDetail.setMoney(giveInfo.getMoney());
				customLeaguerDetail.setRebate(giveInfo.getRebate());
				customLeaguerDetailList.add(customLeaguerDetail);
			}
			if (!customLeaguerDetailList.isEmpty()) {
				customLeaguerDetailDao.saveEntityAll(customLeaguerDetailList);
			}
			// 获取赠送记录
			detachedCriteria = DetachedCriteria.forClass(GiveInfoDetail.class);
			detachedCriteria.createAlias(GiveInfoDetail.GIVE_INFO, GiveInfoDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(GiveInfoDetail.MARKETING_PROJECT, GiveInfoDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(GiveInfoDetail.GIVE_INFO, giveInfoList));
			List<GiveInfoDetail> giveInfoDetailList = giveInfoDetailDao.getByDetachedCriteria(detachedCriteria);
			
			if (!giveInfoDetailList.isEmpty()) {
				List<LargessRecord> largessRecordList = new ArrayList<LargessRecord>();
				LargessRecord largessRecord;
				for (GiveInfoDetail giveInfoDetail : giveInfoDetailList) {
					largessRecord = new LargessRecord();
					largessRecord.setCreater(shopCardDto.getCreater());
					largessRecord.setBelongingUser(shopCardDto.getBelongingUser());
					largessRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
					largessRecord.setMarketingProject(giveInfoDetail.getMarketingProject());
					largessRecord.setNumber(giveInfoDetail.getNumber());
					largessRecord.setSurplusNumber(giveInfoDetail.getNumber());
					largessRecord.setCustomInfo(customInfo);
					largessRecordList.add(largessRecord);
				}
				largessRecordDao.saveEntityAll(largessRecordList);
			}
		}
	}

	/**
	 * 获取卡项
	 * @param shopCardDto
	 * @param customInfo
	 * @param customLeaguerDetailList
	 */
	private void getCustomLeaguer(ShopCardDto shopCardDto,
			CustomInfo customInfo,
			List<CustomLeaguerDetail> customLeaguerDetailList) {
		// 添加购卡记录
		String[] leaguerId = shopCardDto.getLeaguerId();
		if (leaguerId != null && leaguerId.length > 0) {
			List<Integer> idList = new ArrayList<Integer>();
			for (String string : leaguerId) {
				idList.add(Integer.valueOf(string));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
			detachedCriteria.add(Restrictions.in(Leaguer.BASE_ID, idList));
			List<Leaguer> leaguerList = leaguerDao.getByDetachedCriteria(detachedCriteria);
			// 客户与卡项的详细
			CustomLeaguerDetail customLeaguerDetail;
			for (Leaguer leaguer : leaguerList) {
				customLeaguerDetail = new CustomLeaguerDetail();
				customLeaguerDetail.setCreater(shopCardDto.getCreater());
				customLeaguerDetail.setBelongingUser(shopCardDto.getBelongingUser());
				customLeaguerDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				customLeaguerDetail.setCustomInfo(customInfo);
				customLeaguerDetail.setLeaguer(leaguer);
				customLeaguerDetail.setMoney(leaguer.getMoney());
				customLeaguerDetail.setRebate(leaguer.getRebate());
				customLeaguerDetailList.add(customLeaguerDetail);
			}
			if (!customLeaguerDetailList.isEmpty()) {
				customLeaguerDetailDao.saveEntityAll(customLeaguerDetailList);
			}
			// 获取赠送记录
			detachedCriteria = DetachedCriteria.forClass(LeaguerDetail.class);
			detachedCriteria.createAlias(LeaguerDetail.LEAGUER, LeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(LeaguerDetail.MARKETING_PROJECT, LeaguerDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.in(LeaguerDetail.LEAGUER, leaguerList));
			detachedCriteria.add(Restrictions.eq(LeaguerDetail.STATE, true));
			List<LeaguerDetail> leaguerDetailList = leaguerDetailDao.getByDetachedCriteria(detachedCriteria);
			if (!leaguerDetailList.isEmpty()) {
				// 根据赠送的类型，来保存数据
				List<LargessRecord> largessRecordList = new ArrayList<LargessRecord>();
				List<CustomLeaguerDetail> detailList = new ArrayList<CustomLeaguerDetail>();
				for (LeaguerDetail leaguerDetail : leaguerDetailList) {
					if (leaguerDetail.getMarketingProject() != null) {
						LargessRecord largessRecord = new LargessRecord();
						largessRecord.setCreater(shopCardDto.getCreater());
						largessRecord.setBelongingUser(shopCardDto.getBelongingUser());
						largessRecord.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
						largessRecord.setMarketingProject(leaguerDetail.getMarketingProject());
						largessRecord.setMoney(leaguerDetail.getMoney());
						largessRecord.setNumber(leaguerDetail.getNumber());
						largessRecord.setSurplusNumber(leaguerDetail.getNumber());
						largessRecord.setCustomInfo(customInfo);
						largessRecordList.add(largessRecord);
					}
					if (leaguerDetail.getGiveInfo() != null) {
						if (leaguerDetail.getNumber() != null) {
							for (int i = 0; i < leaguerDetail.getNumber(); i++) {
								CustomLeaguerDetail detail = new CustomLeaguerDetail();
								detail.setCreater(shopCardDto.getCreater());
								detail.setBelongingUser(shopCardDto.getBelongingUser());
								detail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
								detail.setGiveInfo(leaguerDetail.getGiveInfo());
								detail.setMoney(leaguerDetail.getGiveInfo().getMoney());
								detail.setCustomInfo(customInfo);
								detailList.add(detail);
							}
						} else {
							CustomLeaguerDetail detail = new CustomLeaguerDetail();
							detail.setCreater(shopCardDto.getCreater());
							detail.setBelongingUser(shopCardDto.getBelongingUser());
							detail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
							detail.setGiveInfo(leaguerDetail.getGiveInfo());
							detail.setMoney(leaguerDetail.getGiveInfo().getMoney());
							detail.setCustomInfo(customInfo);
							detail.setNumber(leaguerDetail.getNumber());
							detailList.add(detail);
						}
					}
				}
				if (!largessRecordList.isEmpty()) {
					largessRecordDao.saveEntityAll(largessRecordList);
				}
				if (!detailList.isEmpty()) {
					customLeaguerDetailDao.saveEntityAll(detailList);
				}
			}
		}
	}
	
	/**
	 * 计算金额，或者扣除购买的项目或者套餐，或者赠送的项目
	 * @param consumptionRegister
	 * @param consumptionRegisterDetailList
	 */
	private void compute(ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		if (consumptionRegister.isState() && consumptionRegisterDetailList != null && !consumptionRegisterDetailList.isEmpty()) {
			// 扣钱，
			if (BigDecimalUtil.isNotNullOrZero(consumptionRegister.getRealityMoney())) {
				CustomInfo customInfo = customInfoDao.getById(consumptionRegister.getCustomInfo().getId());
				customInfo.setMoney(BigDecimalUtil.subtract(customInfo.getMoney(), consumptionRegister.getRealityMoney()));
				customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
				customInfoDao.updateEntity(customInfo);
				consumptionRegister.setCustomInfo(customInfo);
			}
			// 减赠送项目次数
			Map<Integer, Integer> largessRecordMaps = new HashMap<Integer, Integer>();
			// 减套餐购买项目次数
			Map<Integer, Integer> mealBuyRecordDetailMaps = new HashMap<Integer, Integer>();
			// 项目购买记录次数
			Map<Integer, Integer> projectBuyDetailMaps = new HashMap<Integer, Integer>();
			for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
				
			}
			List<Integer> idList = new ArrayList<Integer>();
			if (!largessRecordMaps.isEmpty()) {
				for (Entry<Integer, Integer> map : largessRecordMaps.entrySet()) {
					idList.add(map.getKey());
				}
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
				detachedCriteria.add(Restrictions.in(LargessRecord.BASE_ID, idList));
				List<LargessRecord> largessRecordList = largessRecordDao.getByDetachedCriteria(detachedCriteria);
				for (LargessRecord largessRecord : largessRecordList) {
					for (Entry<Integer, Integer> map : largessRecordMaps.entrySet()) {
						if (largessRecord.getId().equals(map.getKey())) {
							largessRecord.setSurplusNumber(largessRecord.getSurplusNumber() - map.getValue());
							break;
						}
					}
				}
				idList.clear();
				largessRecordDao.updateEntityAll(largessRecordList);
			}
			if (!mealBuyRecordDetailMaps.isEmpty()) {
				for (Entry<Integer, Integer> map : mealBuyRecordDetailMaps.entrySet()) {
					idList.add(map.getKey());
				}
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
				detachedCriteria.add(Restrictions.in(MealBuyRecordDetail.BASE_ID, idList));
				List<MealBuyRecordDetail> mealBuyRecordDetailList = mealBuyRecordDetailDao.getByDetachedCriteria(detachedCriteria);
				for (MealBuyRecordDetail mealBuyRecordDetail : mealBuyRecordDetailList) {
					for (Entry<Integer, Integer> map : mealBuyRecordDetailMaps.entrySet()) {
						if (mealBuyRecordDetail.getId().equals(map.getKey())) {
							mealBuyRecordDetail.setSurplusNumber(mealBuyRecordDetail.getSurplusNumber() - map.getValue());
							break;
						}
					}
				}
				idList.clear();
				mealBuyRecordDetailDao.updateEntityAll(mealBuyRecordDetailList);
			}
			if (!projectBuyDetailMaps.isEmpty()) {
				for (Entry<Integer, Integer> map : projectBuyDetailMaps.entrySet()) {
					idList.add(map.getKey());
				}
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
				detachedCriteria.add(Restrictions.in(ProjectBuyDetail.BASE_ID, idList));
				List<ProjectBuyDetail> projectBuyDetaillList = projectBuyDetailDao.getByDetachedCriteria(detachedCriteria);
				for (ProjectBuyDetail projectBuyDetail : projectBuyDetaillList) {
					for (Entry<Integer, Integer> map : projectBuyDetailMaps.entrySet()) {
						if (projectBuyDetail.getId().equals(map.getKey())) {
							projectBuyDetail.setSurplusNumber(projectBuyDetail.getSurplusNumber() - map.getValue());
							break;
						}
					}
				}
				idList.clear();
				projectBuyDetailDao.updateEntityAll(projectBuyDetaillList);
			}
		}
	}
	
	/**
	 * 付款
	 * @param consumptionRegister 消费信息
	 * @param money 折后金额
	 * @param consumptionRegisterDetailList 消费项目列表
	 * @param balance 余额付款
	 * @param readyMoney 现金付款
	 * @param customLeaguerDetail 客户卡项
	 * @throws ConsumptionException 
	 */
	public void savePay(ConsumptionRegister consumptionRegister, BigDecimal money, 
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList,
			BigDecimal balance, BigDecimal readyMoney,
			CustomLeaguerDetail customLeaguerDetail) throws ConsumptionException {
		saveConsumptionRegisterDetail(consumptionRegister.getCustomInfo(), consumptionRegister.getDate(), money, balance, readyMoney, consumptionRegister.getCreater(), customLeaguerDetail, consumptionRegister, consumptionRegisterDetailList);
		// 如果有使用了数量扣除，就扣除数量
		Map<MarketingProject, Integer> largessRecordMaps = new HashMap<MarketingProject, Integer>();
		Map<MarketingProject, Integer> mealBuyRecordDetailMaps = new HashMap<MarketingProject, Integer>();
		Map<MarketingProject, Integer> projectBuyDetailMaps = new HashMap<MarketingProject, Integer>();
		
		for (ConsumptionRegisterDetail consumptionRegisterDetail : consumptionRegisterDetailList) {
			String types = consumptionRegisterDetail.getTypes();
			if (StringUtil.isNotBlank(types)) {
				String[] split = types.split(Constants.COMMA);
				for (String str : split) {
					MarketingProject marketingProject = consumptionRegisterDetail.getMarketingProject();
					int consumptionNumber = consumptionRegisterDetail.getConsumptionNumber();
					if (ConsumptionRegisterDetail.TYPE_2.equals(Integer.valueOf(str))) {
						Integer integer = largessRecordMaps.get(marketingProject);
						if (integer == null) {
							largessRecordMaps.put(marketingProject, consumptionNumber);
						} else {
							largessRecordMaps.put(marketingProject, consumptionNumber + integer.intValue());
						}
					} else if (ConsumptionRegisterDetail.TYPE_3.equals(Integer.valueOf(str))) {
						Integer integer = mealBuyRecordDetailMaps.get(marketingProject);
						if (integer == null) {
							mealBuyRecordDetailMaps.put(marketingProject, consumptionNumber);
						} else {
							mealBuyRecordDetailMaps.put(marketingProject, consumptionNumber + integer.intValue());
						}
					} else if (ConsumptionRegisterDetail.TYPE_4.equals(Integer.valueOf(str))){
						Integer integer = projectBuyDetailMaps.get(marketingProject);
						if (integer == null) {
							projectBuyDetailMaps.put(marketingProject, consumptionNumber);
						} else {
							projectBuyDetailMaps.put(marketingProject, consumptionNumber + integer.intValue());
						}
					}
				} 
			}
		}
		List<MarketingProject> mkarketingProjectList;
		// 扣除赠送项目记录
		if (!largessRecordMaps.isEmpty()) {
			mkarketingProjectList = new ArrayList<MarketingProject>();
			for (Entry<MarketingProject, Integer> map : largessRecordMaps.entrySet()) {
				mkarketingProjectList.add(map.getKey());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LargessRecord.class);
			detachedCriteria.createAlias(LargessRecord.MARKETING_PROJECT, LargessRecord.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(LargessRecord.CUSTOM_INFO, LargessRecord.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(LargessRecord.CUSTOM_INFO, consumptionRegister.getCustomInfo()));
			detachedCriteria.add(Restrictions.gt(LargessRecord.SURPLUS_NUMBER, 0));
			detachedCriteria.add(Restrictions.in(LargessRecord.MARKETING_PROJECT, mkarketingProjectList));
			List<LargessRecord> list = largessRecordDao.getByDetachedCriteria(detachedCriteria);
			if (!list.isEmpty()) {
				// 循环扣除
				int size = 0;
				for (Entry<MarketingProject, Integer> map : largessRecordMaps.entrySet()) {
					size = map.getValue().intValue();
					for (LargessRecord largessRecord : list) {
						if (map.getKey().equals(largessRecord.getMarketingProject())) {
							Integer surplusNumber = largessRecord.getSurplusNumber();
							// 如果数量足够
							if (surplusNumber.intValue() >= size) {
								largessRecord.setSurplusNumber(surplusNumber - size);
								largessRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
								size = 0; 
								break;
							} else {
								// 扣除对应的，在继续循环扣除
								size = size - surplusNumber.intValue();
								largessRecord.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
								largessRecord.setSurplusNumber(0);
							}
						}
					}
				}
				if (size != 0) {
					throw new ConsumptionException("赠送项目扣除有误请重新操作！");
				}
				largessRecordDao.updateEntityAll(list);
			} else {
				throw new ConsumptionException("赠送项目扣除有误请重新操作！");
			}
		}
		// 扣除购买的服务项目
		if (!mealBuyRecordDetailMaps.isEmpty()) {
			mkarketingProjectList = new ArrayList<MarketingProject>();
			for (Entry<MarketingProject, Integer> map : mealBuyRecordDetailMaps.entrySet()) {
				mkarketingProjectList.add(map.getKey());
			}
			
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MealBuyRecordDetail.class);
			detachedCriteria.createAlias(MealBuyRecordDetail.MARKETING_PROJECT, MealBuyRecordDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD, MealBuyRecordDetail.MEAL_BUY_RECORD, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(MealBuyRecordDetail.MEAL_BUY_RECORD_CUSTOMINFO, consumptionRegister.getCustomInfo()));
			detachedCriteria.add(Restrictions.gt(MealBuyRecordDetail.SURPLUS_NUMBER, 0));
			detachedCriteria.add(Restrictions.in(MealBuyRecordDetail.MARKETING_PROJECT, mkarketingProjectList));
			List<MealBuyRecordDetail> list = mealBuyRecordDetailDao.getByDetachedCriteria(detachedCriteria);
			if (!list.isEmpty()) {
				// 循环扣除
				int size = 0;
				for (Entry<MarketingProject, Integer> map : mealBuyRecordDetailMaps.entrySet()) {
					size = map.getValue().intValue();
					for (MealBuyRecordDetail mealBuyRecordDetail : list) {
						if (map.getKey().equals(mealBuyRecordDetail.getMarketingProject())) {
							Integer surplusNumber = mealBuyRecordDetail.getSurplusNumber();
							// 如果数量足够
							if (surplusNumber.intValue() >= size) {
								mealBuyRecordDetail.setSurplusNumber(surplusNumber - size);
								mealBuyRecordDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
								size = 0; 
								break;
							} else {
								// 扣除对应的，在继续循环扣除
								size = size - surplusNumber.intValue();
								mealBuyRecordDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
								mealBuyRecordDetail.setSurplusNumber(0);
							}
						}
					}
				}
				if (size != 0) {
					throw new ConsumptionException("套餐内的项目扣除有误请重新操作！");
				}
				mealBuyRecordDetailDao.updateEntityAll(list);
			} else {
				throw new ConsumptionException("套餐内的项目扣除有误请重新操作！");
			}
		}
		// 扣除购买的套餐项目
		if (!projectBuyDetailMaps.isEmpty()) {
			mkarketingProjectList = new ArrayList<MarketingProject>();
			for (Entry<MarketingProject, Integer> map : projectBuyDetailMaps.entrySet()) {
				mkarketingProjectList.add(map.getKey());
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProjectBuyDetail.class);
			detachedCriteria.createAlias(ProjectBuyDetail.MARKETING_PROJECT, ProjectBuyDetail.MARKETING_PROJECT, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY, ProjectBuyDetail.PROJECT_BUY, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.createAlias(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
			detachedCriteria.add(Restrictions.eq(ProjectBuyDetail.PROJECT_BUY_CUSTOM_INFO, consumptionRegister.getCustomInfo()));
			detachedCriteria.add(Restrictions.gt(ProjectBuyDetail.SURPLUS_NUMBER, 0));
			detachedCriteria.add(Restrictions.in(ProjectBuyDetail.MARKETING_PROJECT, mkarketingProjectList));
			List<ProjectBuyDetail> list = projectBuyDetailDao.getByDetachedCriteria(detachedCriteria);
			if (!list.isEmpty()) {
				// 循环扣除
				int size = 0;
				for (Entry<MarketingProject, Integer> map : projectBuyDetailMaps.entrySet()) {
					size = map.getValue().intValue();
					for (ProjectBuyDetail projectBuyDetail : list) {
						if (map.getKey().equals(projectBuyDetail.getMarketingProject())) {
							Integer surplusNumber = projectBuyDetail.getSurplusNumber();
							// 如果数量足够
							if (surplusNumber.intValue() >= size) {
								projectBuyDetail.setSurplusNumber(surplusNumber - size);
								projectBuyDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
								size = 0; 
								break;
							} else {
								// 扣除对应的，在继续循环扣除
								size = size - surplusNumber.intValue();
								projectBuyDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
								projectBuyDetail.setSurplusNumber(0);
							}
						}
					}
				}
				if (size != 0) {
					throw new ConsumptionException("购买的疗程扣除有误请重新操作！");
				}
				projectBuyDetailDao.updateEntityAll(list);
			} else {
				throw new ConsumptionException("购买的疗程扣除有误请重新操作！");
			}
		}
	}
	
	/**
	 * 建立消费登记
	 * @param customInfo 客户档案
	 * @param personnelInfo 美容师
	 * @param adviser 顾问
	 * @param date 登记日期
	 * @param realityMoney 消费金额
	 * @param creater 登记用户
	 * @return
	 */
	public ConsumptionRegister getConsumptionRegister(CustomInfo customInfo, PersonnelInfo personnelInfo,
			PersonnelInfo adviser, Date date, BigDecimal realityMoney, User creater) {
		// 建立个人消费登记表
		ConsumptionRegister consumptionRegister = new ConsumptionRegister();
		consumptionRegister.setCreater(creater);
		consumptionRegister.setBelongingUser(MothedUtil.getBelongingUser(creater));
		consumptionRegister.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
		consumptionRegister.setCustomInfo(customInfo);
		consumptionRegister.setRealityMoney(realityMoney);
		consumptionRegister.setState(true);
		consumptionRegister.setDate(date);
		consumptionRegister.setPersonnelInfo(personnelInfo);
		consumptionRegister.setAdviser(adviser);
		return consumptionRegister;
	}
	
	/**
	 * 根据购买的卡项货体验卡获取消费详细
	 * @param consumptionRegister
	 * @param customLeaguerDetailList
	 */
	public List<ConsumptionRegisterDetail> getConsumptionRegisterDetailList(ConsumptionRegister consumptionRegister, List<CustomLeaguerDetail> customLeaguerDetailList) {
		List<ConsumptionRegisterDetail> consumptionRegisterDetailList = new ArrayList<ConsumptionRegisterDetail>();
		ConsumptionRegisterDetail consumptionRegisterDetail;
		for (CustomLeaguerDetail customLeaguerDetail : customLeaguerDetailList) {
			consumptionRegisterDetail = new ConsumptionRegisterDetail();
			consumptionRegisterDetail.setConsumptionRegister(consumptionRegister);
			consumptionRegisterDetail.setCreater(consumptionRegister.getCreater());
			consumptionRegisterDetail.setBelongingUser(MothedUtil.getBelongingUser(consumptionRegister.getCreater()));
			consumptionRegisterDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionRegisterDetail.setCustomLeaguerDetail(customLeaguerDetail);
			consumptionRegisterDetail.setMoney(customLeaguerDetail.getMoney());
			consumptionRegisterDetailList.add(consumptionRegisterDetail);
		}
		return consumptionRegisterDetailList;
	}
	
	/**
	 * 建立各个卡项的消费记录
	 * @param customInfo 客户
	 * @param date 登记日期
	 * @param realityMoney 实耗金额
	 * @param balance 余额付款
	 * @param readyMoney 现金付款
	 * @param creater 创建者
	 * @param customLeaguerDetailList 客户卡项列表
	 * @param consumptionRegister 消费登记
	 * @param consumptionRegisterDetailList 消费登记详细
	 */
	public void saveConsumptionRegisterDetail(CustomInfo customInfo, Date date, BigDecimal realityMoney,
			BigDecimal balance, BigDecimal readyMoney, User creater,
			List<CustomLeaguerDetail> customLeaguerDetailList,
			ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		// 记录消费登记详细
		List<ConsumptionDetail> consumptionDetailList = new ArrayList<ConsumptionDetail>();
		
		// 欠款= 余额消费后还有未付 - 卡项消费后还有未付清的 - 现金消费后还有未付清
		BigDecimal debt = Constants.BIGDECIMAL_ZERO;
		// 是否要登记，余额消费
		debt = BigDecimalUtil.add(debt, balance);
		// 有余额消费记录就登记余额消费
		if (BigDecimalUtil.isNotNullOrZero(balance)) {
			// 扣除充值卡余额
			BigDecimal money = customInfo.getMoney();
			customInfo.setMoney(BigDecimalUtil.subtract(money, balance));
			customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			
			// 记录充值卡消费记录
			ConsumptionDetail consumptionDetail = new ConsumptionDetail();
			consumptionDetail.setCreater(creater);
			consumptionDetail.setBelongingUser(MothedUtil.getBelongingUser(creater));
			consumptionDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionDetail.setCustomInfo(customInfo);
			consumptionDetail.setDate(date);
			consumptionDetail.setEntity(customInfo);
			consumptionDetail.setConsumptionRegister(consumptionRegister);
			consumptionDetail.setMoney(balance);
			consumptionDetailList.add(consumptionDetail);
		}
		// 验证是否有当前客户下的卡项 消费情况
		if (customLeaguerDetailList != null && !customLeaguerDetailList.isEmpty()) {
			// 登记卡项消费
			for (CustomLeaguerDetail customLeaguerDetail : customLeaguerDetailList) {
				if (BigDecimalUtil.isNotNullOrZero(customLeaguerDetail.getReadyMoney())) {
					debt = BigDecimalUtil.add(debt, customLeaguerDetail.getReadyMoney());
					// 扣除卡项余额
					BigDecimal money = customLeaguerDetail.getMoney();
					customLeaguerDetail.setMoney(BigDecimalUtil.subtract(money, customLeaguerDetail.getReadyMoney()));
					customLeaguerDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
					
					// 记录卡项消费记录
					ConsumptionDetail consumptionDetail = new ConsumptionDetail();
					consumptionDetail.setCreater(creater);
					consumptionDetail.setBelongingUser(MothedUtil.getBelongingUser(creater));
					consumptionDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
					consumptionDetail.setDate(date);
					consumptionDetail.setCustomInfo(customInfo);
					consumptionDetail.setConsumptionRegister(consumptionRegister);
					consumptionDetail.setEntity(customLeaguerDetail);
					consumptionDetail.setMoney(customLeaguerDetail.getReadyMoney());
					consumptionDetailList.add(consumptionDetail);
				}
			}
			customLeaguerDetailDao.updateEntityAll(customLeaguerDetailList);
		}
		// 是否登记，现金消费
		if (BigDecimalUtil.isNotNullOrZero(readyMoney)) {
			debt = BigDecimalUtil.add(debt, readyMoney);
			
			// 记录现金消费记录
			ConsumptionDetail consumptionDetail = new ConsumptionDetail();
			consumptionDetail.setCreater(creater);
			consumptionDetail.setBelongingUser(MothedUtil.getBelongingUser(creater));
			consumptionDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionDetail.setDate(date);
			consumptionDetail.setCustomInfo(customInfo);
			consumptionDetail.setConsumptionRegister(consumptionRegister);
			consumptionDetail.setMoney(readyMoney);
			consumptionDetailList.add(consumptionDetail);
		}
		if (!consumptionDetailList.isEmpty()) {
			consumptionDetailDao.saveEntityAll(consumptionDetailList);
		}
		// 欠款等于=需要支付的金额-已支付的金额
		BigDecimal subtract = BigDecimalUtil.subtract(realityMoney, debt);
		consumptionRegister.setMoney(debt);
		consumptionRegister.setDebt(Constants.BIGDECIMAL_ZERO);
		// 获取充值卡余额
		consumptionRegister.setBalance(customInfo.getMoney());
		if (BigDecimalUtil.isNotNullOrZero(subtract)) {
			consumptionRegister.setDebt(subtract);
			// 更新客户欠款
			BigDecimal newArrearage = BigDecimalUtil.isNullOrZero(customInfo.getArrearage()) ? Constants.BIGDECIMAL_ZERO : subtract;
			customInfo.setArrearage(BigDecimalUtil.add(newArrearage, subtract));
		}
		consumptionRegisterDao.saveEntity(consumptionRegister);
		consumptionRegisterDetailDao.saveEntityAll(consumptionRegisterDetailList);
		customInfoDao.updateEntity(customInfo);
	}
	
	/**
	 * 建立各个卡项的消费记录
	 * @param customInfo 客户
	 * @param date 登记日期
	 * @param realityMoney 实耗金额
	 * @param balance 余额付款
	 * @param readyMoney 现金付款
	 * @param creater 创建者
	 * @param customLeaguerDetailList 客户卡项列表
	 * @param consumptionRegister 消费登记
	 * @param consumptionRegisterDetailList 消费登记详细
	 */
	public void saveConsumptionRegisterDetail(CustomInfo customInfo, Date date, BigDecimal realityMoney,
			BigDecimal balance, BigDecimal readyMoney, User creater,
			CustomLeaguerDetail customLeaguerDetail,
			ConsumptionRegister consumptionRegister,
			List<ConsumptionRegisterDetail> consumptionRegisterDetailList) {
		// 记录消费登记详细
		List<ConsumptionDetail> consumptionDetailList = new ArrayList<ConsumptionDetail>();
		
		// 欠款= 余额消费后还有未付 - 卡项消费后还有未付清的 - 现金消费后还有未付清
		BigDecimal debt = Constants.BIGDECIMAL_ZERO;
		// 是否要登记，余额消费
		debt = BigDecimalUtil.add(debt, balance);
		// 有余额消费记录就登记余额消费
		if (BigDecimalUtil.isNotNullOrZero(balance)) {
			// 扣除充值卡余额
			BigDecimal money = customInfo.getMoney();
			customInfo.setMoney(BigDecimalUtil.subtract(money, balance));
			customInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			
			// 记录充值卡消费记录
			ConsumptionDetail consumptionDetail = new ConsumptionDetail();
			consumptionDetail.setCreater(creater);
			consumptionDetail.setBelongingUser(MothedUtil.getBelongingUser(creater));
			consumptionDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionDetail.setCustomInfo(customInfo);
			consumptionDetail.setDate(date);
			consumptionDetail.setEntity(customInfo);
			consumptionDetail.setConsumptionRegister(consumptionRegister);
			consumptionDetail.setMoney(balance);
			consumptionDetailList.add(consumptionDetail);
		}
		// 验证是否有当前客户下的卡项 消费情况
		if (customLeaguerDetail != null) {
			// 登记卡项消费
			if (BigDecimalUtil.isNotNullOrZero(customLeaguerDetail.getReadyMoney())) {
				debt = BigDecimalUtil.add(debt, customLeaguerDetail.getReadyMoney());
				// 扣除卡项余额
				BigDecimal money = customLeaguerDetail.getMoney();
				customLeaguerDetail.setMoney(BigDecimalUtil.subtract(money, customLeaguerDetail.getReadyMoney()));
				customLeaguerDetail.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
				
				// 记录卡项消费记录
				ConsumptionDetail consumptionDetail = new ConsumptionDetail();
				consumptionDetail.setCreater(creater);
				consumptionDetail.setBelongingUser(MothedUtil.getBelongingUser(creater));
				consumptionDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				consumptionDetail.setDate(date);
				consumptionDetail.setCustomInfo(customInfo);
				consumptionDetail.setConsumptionRegister(consumptionRegister);
				consumptionDetail.setEntity(customLeaguerDetail);
				consumptionDetail.setMoney(customLeaguerDetail.getReadyMoney());
				consumptionDetailList.add(consumptionDetail);
			}
			customLeaguerDetailDao.updateEntity(customLeaguerDetail);
		}
		// 是否登记，现金消费
		if (BigDecimalUtil.isNotNullOrZero(readyMoney)) {
			debt = BigDecimalUtil.add(debt, readyMoney);
			
			// 记录现金消费记录
			ConsumptionDetail consumptionDetail = new ConsumptionDetail();
			consumptionDetail.setCreater(creater);
			consumptionDetail.setBelongingUser(MothedUtil.getBelongingUser(creater));
			consumptionDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			consumptionDetail.setDate(date);
			consumptionDetail.setCustomInfo(customInfo);
			consumptionDetail.setConsumptionRegister(consumptionRegister);
			consumptionDetail.setMoney(readyMoney);
			consumptionDetailList.add(consumptionDetail);
		}
		if (!consumptionDetailList.isEmpty()) {
			consumptionDetailDao.saveEntityAll(consumptionDetailList);
		}
		// 欠款等于
		BigDecimal subtract = BigDecimalUtil.subtract(realityMoney, debt);
		consumptionRegister.setMoney(debt);
		consumptionRegister.setDebt(Constants.BIGDECIMAL_ZERO);
		// 获取充值卡余额
		consumptionRegister.setBalance(customInfo.getMoney());
		if (BigDecimalUtil.isNotNullOrZero(subtract)) {
			consumptionRegister.setDebt(subtract);
			// 更新客户欠款
			BigDecimal newArrearage = BigDecimalUtil.isNullOrZero(customInfo.getArrearage()) ? Constants.BIGDECIMAL_ZERO : subtract;
			customInfo.setArrearage(BigDecimalUtil.add(newArrearage, subtract));
		}
		consumptionRegisterDao.saveEntity(consumptionRegister);
		consumptionRegisterDetailDao.saveEntityAll(consumptionRegisterDetailList);
		customInfoDao.updateEntity(customInfo);
	}
	
}
