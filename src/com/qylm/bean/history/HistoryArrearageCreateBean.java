package com.qylm.bean.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.AddressFinderBean;
import com.qylm.bean.UserBean;
import com.qylm.bean.baseSet.CustomInfoCreateBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.SelectItemUtil;
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.history.HistoryArrearageCreateDto;
import com.qylm.dto.history.HistoryTemporaryCreateDto;
import com.qylm.dxo.CustomInfoCreateDxo;
import com.qylm.dxo.HistoryArrearageCreateDxo;
import com.qylm.dxo.HistoryTemporaryCreateDxo;
import com.qylm.entity.AddressEntity;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.Leaguer;
import com.qylm.entity.MealBuyRecord;
import com.qylm.entity.MealBuyRecordDetail;
import com.qylm.entity.TemporaryActivity;
import com.qylm.entity.TemporaryActivityDetail;
import com.qylm.service.CustomInfoService;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.LeaguerService;
import com.qylm.service.MealBuyRecordDetailService;
import com.qylm.service.MealBuyRecordService;
import com.qylm.service.TemporaryActivityDetailService;
import com.qylm.service.TemporaryActivityService;

/**
 * 客户欠款登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class HistoryArrearageCreateBean implements Serializable, CreateBean<CustomInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1462978727608699113L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(CustomInfoCreateBean.class);

	/**
	 * 存放客户档案登陆画面需要保存的值
	 */
	private HistoryArrearageCreateDto historyArrearageCreateDto = new HistoryArrearageCreateDto();
	
	/**
	 * 地点查询bean
	 */
	@ManagedProperty(value = "#{addressFinderBean}")
	private AddressFinderBean addressFinderBean;
	
	/**
	 * 用户bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 客户档案业务类
	 */
	@ManagedProperty(value="#{customInfoService}")
	private CustomInfoService customInfoService;
	
	/**
	 * 卡项业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
	/**
	 * 客户档案与卡项关系业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;

	/**
	 * 此方法绑定于客户档案登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 客户档案登陆画面
	 */
	public String newCustomInfo() {
		Tool.sendLog(LOG, userBean, "【客户档案登陆画面_新建按钮】");
		historyArrearageCreateDto.setAddressEntity(new AddressEntity());
		addressFinderBean.clearAll();
		historyArrearageCreateDto.setName(null);
		historyArrearageCreateDto.setBirthday(null);
		historyArrearageCreateDto.setLeaguerNumber(null);
		historyArrearageCreateDto.setSpouse(null);
		historyArrearageCreateDto.setIssue(null);
		historyArrearageCreateDto.setBloodGroup(null);
		historyArrearageCreateDto.setMaritalStatus(null);
		historyArrearageCreateDto.setMaritalDeta(null);
		historyArrearageCreateDto.setAddressDetail(null);
		historyArrearageCreateDto.setOccupation(null);
		historyArrearageCreateDto.setMobile(null);
		historyArrearageCreateDto.setSkinType(null);
		historyArrearageCreateDto.setOcularRegionState(null);
		historyArrearageCreateDto.setFaceState(null);
		historyArrearageCreateDto.setFaceNeed(null);
		historyArrearageCreateDto.setDietPractice(null);
		historyArrearageCreateDto.setStapleFood(null);
		historyArrearageCreateDto.setRepast(null);
		historyArrearageCreateDto.setAddSeasonings(null);
		historyArrearageCreateDto.setXhwd(null);
		historyArrearageCreateDto.setYzsw(null);
		historyArrearageCreateDto.setDietaryBias(null);
		historyArrearageCreateDto.setPac(null);
		historyArrearageCreateDto.setDiet(null);
		historyArrearageCreateDto.setHealthState(null);
		historyArrearageCreateDto.setYjkzt(null);
		historyArrearageCreateDto.setSkinType1(null);
		historyArrearageCreateDto.setRemark(null);
		historyArrearageCreateDto.setHljy(null);
		historyArrearageCreateDto.setYearNumber(null);
		historyArrearageCreateDto.setImpressions(null);
		historyArrearageCreateDto.setShiftShopCause(null);
		historyArrearageCreateDto.setPurpose(null);
		historyArrearageCreateDto.setNurse(null);
		historyArrearageCreateDto.setMoney(null);
		historyArrearageCreateDto.setArrearage(null);
		historyArrearageCreateDto.setLeaguer(null);
		historyArrearageCreateDto.setLeaguerSource(null);
		historyArrearageCreateDto.setEmergencyContact(null);
		historyArrearageCreateDto.setEmergencyMobile(null);
		historyArrearageCreateDto.setLeaguerItems(null);
		historyArrearageCreateDto.setLeaguerIdList(null);
		historyArrearageCreateDto.setCustomLeaguerDetailList(null);
		historyArrearageCreateDto.setCreater(null);
		historyArrearageCreateDto.setBelongingUser(null);
		historyArrearageCreateDto.setPersonnelInfo1(null);
		historyArrearageCreateDto.setPersonnelInfo2(null);
		historyArrearageCreateDto.setTransferCustomInfo(null);
		return Navigation.CUSTOM_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于客户档案登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户档案登陆画面_返回按钮】");
		return historyArrearageCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于客户档案登陆画面的保存按钮 
	 * 实现功能：根据transferCustomInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveCustomInfo() {
		Tool.sendLog(LOG, userBean, "【客户档案登陆画面_保存按钮】");
		CustomInfo transferCustomInfo = historyArrearageCreateDto.getTransferCustomInfo();
		if (transferCustomInfo == null) {
			transferCustomInfo = new CustomInfo();
			historyArrearageCreateDto.setCreater(userBean.getUser());
			historyArrearageCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferCustomInfo);
			transferCustomInfo.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			customInfoService.saveEntity(transferCustomInfo);
			historyArrearageCreateDto.setTransferCustomInfo(transferCustomInfo);
			Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
		} else {
			create(transferCustomInfo);
			transferCustomInfo.setUpdateDate(DateUtil.getNowyyyymmddhhmmss());
			customInfoService.updateEntity(transferCustomInfo);
			Tool.sendErrorMessage(Message.GENERAL_UPDATESUCCESS);
		}
	}
	/**
	 * 赋值
	 * @param transferCustomInfo
	 */
	private void create(CustomInfo transferCustomInfo) {
		// 皮肤类型
		if (historyArrearageCreateDto.getSkinType() != null) {
			transferCustomInfo.setSkinType(StringUtil.join(historyArrearageCreateDto.getSkinType(), Constants.COMMA));
		}
		// 眼部情况
		if (historyArrearageCreateDto.getOcularRegionState() != null) {
			transferCustomInfo.setOcularRegionState(StringUtil.join(historyArrearageCreateDto.getOcularRegionState(), Constants.COMMA));
		}
		// 面部
		if (historyArrearageCreateDto.getFaceState() != null) {
			transferCustomInfo.setFaceState(StringUtil.join(historyArrearageCreateDto.getFaceState(), Constants.COMMA));
		}
		// 面部皮肤重建需要
		if (historyArrearageCreateDto.getFaceNeed() != null) {
			transferCustomInfo.setFaceNeed(StringUtil.join(historyArrearageCreateDto.getFaceNeed(), Constants.COMMA));
		}
		// 进食速度
		if (historyArrearageCreateDto.getDietPractice() != null) {
			transferCustomInfo.setDietPractice(StringUtil.join(historyArrearageCreateDto.getDietPractice(), Constants.COMMA));
		}
		// 主食
		if (historyArrearageCreateDto.getStapleFood() != null) {
			transferCustomInfo.setStapleFood(StringUtil.join(historyArrearageCreateDto.getStapleFood(), Constants.COMMA));
		}
		// 食量
		if (historyArrearageCreateDto.getRepast() != null) {
			transferCustomInfo.setRepast(StringUtil.join(historyArrearageCreateDto.getRepast(), Constants.COMMA));
		}
		// 加味调料
		if (historyArrearageCreateDto.getAddSeasonings() != null) {
			transferCustomInfo.setAddSeasonings(StringUtil.join(historyArrearageCreateDto.getAddSeasonings(), Constants.COMMA));
		}
		// 喜欢味道
		if (historyArrearageCreateDto.getXhwd() != null) {
			transferCustomInfo.setXhwd(StringUtil.join(historyArrearageCreateDto.getXhwd(), Constants.COMMA));
		}
		// 油炸食物
		if (historyArrearageCreateDto.getYzsw() != null) {
			transferCustomInfo.setYzsw(StringUtil.join(historyArrearageCreateDto.getYzsw(), Constants.COMMA));
		}
		// 偏食
		if (historyArrearageCreateDto.getDietaryBias() != null) {
			transferCustomInfo.setDietaryBias(StringUtil.join(historyArrearageCreateDto.getDietaryBias(), Constants.COMMA));
		}
		// 偏爱吃
		if (historyArrearageCreateDto.getPac() != null) {
			transferCustomInfo.setPac(StringUtil.join(historyArrearageCreateDto.getPac(), Constants.COMMA));
		}
		// 饮食
		if (historyArrearageCreateDto.getDiet() != null) {
			transferCustomInfo.setDiet(StringUtil.join(historyArrearageCreateDto.getDiet(), Constants.COMMA));
		}
		// 月经生理
		if (historyArrearageCreateDto.getHealthState() != null) {
			transferCustomInfo.setHealthState(StringUtil.join(historyArrearageCreateDto.getHealthState(), Constants.COMMA));
		}
		// 亚健康状态
		if (historyArrearageCreateDto.getYjkzt() != null) {
			transferCustomInfo.setYjkzt(StringUtil.join(historyArrearageCreateDto.getYjkzt(), Constants.COMMA));
		}
		// 在美容店接受面部皮肤护理经验
		if (StringUtil.isNotBlank(historyArrearageCreateDto.getHljy())) {
			transferCustomInfo.setHljy("1".equals(historyArrearageCreateDto.getHljy()));
		}
		List<String> leaguerIdList = historyArrearageCreateDto.getLeaguerIdList();
		if (leaguerIdList != null && !leaguerIdList.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for (String id : leaguerIdList) {
				idList.add(Integer.valueOf(id));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
			detachedCriteria.add(Restrictions.in(Leaguer.BASE_ID, idList));
			List<Leaguer> leaguerList = leaguerService.getByDetachedCriteria(detachedCriteria);
			List<CustomLeaguerDetail> customLeaguerDetailList = new ArrayList<CustomLeaguerDetail>();
			CustomLeaguerDetail customLeaguerDetail;
			for (Leaguer leaguer : leaguerList) {
				customLeaguerDetail = new CustomLeaguerDetail();
				customLeaguerDetail.setCustomInfo(transferCustomInfo);
				customLeaguerDetail.setLeaguer(leaguer);
				customLeaguerDetail.setCreater(userBean.getUser());
				customLeaguerDetail.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
				customLeaguerDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				customLeaguerDetailList.add(customLeaguerDetail);
			}
		}
		HistoryArrearageCreateDxo.dtoToEntity(historyArrearageCreateDto, transferCustomInfo);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		historyArrearageCreateDto.setReturner(returner);
		historyArrearageCreateDto.setAddressEntity(new AddressEntity());
		addressFinderBean.clearAll();
		historyArrearageCreateDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getAll(), false));
		return Navigation.HISTORY_ARREARAGE_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, CustomInfo customInfo) {
		historyArrearageCreateDto.setReturner(returner);
		CustomInfoCreateDxo.entityToDto(customInfo, historyArrearageCreateDto);
		
		
		historyArrearageCreateDto.setSkinType(StringUtil.split(customInfo.getSkinType(), Constants.COMMA));
		historyArrearageCreateDto.setOcularRegionState(StringUtil.split(customInfo.getOcularRegionState(), Constants.COMMA));
		historyArrearageCreateDto.setFaceState(StringUtil.split(customInfo.getFaceState(), Constants.COMMA));
		historyArrearageCreateDto.setFaceNeed(StringUtil.split(customInfo.getFaceNeed(), Constants.COMMA));
		historyArrearageCreateDto.setDietPractice(StringUtil.split(customInfo.getDietPractice(), Constants.COMMA));
		historyArrearageCreateDto.setStapleFood(StringUtil.split(customInfo.getStapleFood(), Constants.COMMA));
		historyArrearageCreateDto.setRepast(StringUtil.split(customInfo.getRepast(), Constants.COMMA));
		historyArrearageCreateDto.setAddSeasonings(StringUtil.split(customInfo.getAddSeasonings(), Constants.COMMA));
		historyArrearageCreateDto.setXhwd(StringUtil.split(customInfo.getXhwd(), Constants.COMMA));
		historyArrearageCreateDto.setYzsw(StringUtil.split(customInfo.getYzsw(), Constants.COMMA));
		historyArrearageCreateDto.setDietaryBias(StringUtil.split(customInfo.getDietaryBias(), Constants.COMMA));
		historyArrearageCreateDto.setPac(StringUtil.split(customInfo.getPac(), Constants.COMMA));
		historyArrearageCreateDto.setDiet(StringUtil.split(customInfo.getDiet(), Constants.COMMA));
		historyArrearageCreateDto.setHealthState(StringUtil.split(customInfo.getHealthState(), Constants.COMMA));
		historyArrearageCreateDto.setYjkzt(StringUtil.split(customInfo.getYjkzt(), Constants.COMMA));
		historyArrearageCreateDto.setHljy(customInfo.isHljy() ? "1" : "2");

		historyArrearageCreateDto.setTransferCustomInfo(customInfo);
		if(customInfo.getAddressEntity()==null){
			historyArrearageCreateDto.setAddressEntity(new AddressEntity());
			addressFinderBean.clearAll();
		}else{
			addressFinderBean.initAllByAddressEntity(customInfo.getAddressEntity());
		}
		return Navigation.HISTORY_ARREARAGE_CREATE;
	}

	/**
	 * @return the historyArrearageCreateDto
	 */
	public HistoryArrearageCreateDto getHistoryArrearageCreateDto() {
		return historyArrearageCreateDto;
	}

	/**
	 * @param historyArrearageCreateDto the historyArrearageCreateDto to set
	 */
	public void setHistoryArrearageCreateDto(
			HistoryArrearageCreateDto historyArrearageCreateDto) {
		this.historyArrearageCreateDto = historyArrearageCreateDto;
	}

	/**
	 * @return the addressFinderBean
	 */
	public AddressFinderBean getAddressFinderBean() {
		return addressFinderBean;
	}

	/**
	 * @param addressFinderBean the addressFinderBean to set
	 */
	public void setAddressFinderBean(AddressFinderBean addressFinderBean) {
		this.addressFinderBean = addressFinderBean;
	}

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean() {
		return userBean;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

	/**
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}



	
}
