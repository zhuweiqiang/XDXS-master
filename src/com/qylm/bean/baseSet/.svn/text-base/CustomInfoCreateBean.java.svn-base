package com.qylm.bean.baseSet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.bean.AddressFinderBean;
import com.qylm.bean.UserBean;
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
import com.qylm.dto.baseSet.CustomInfoCreateDto;
import com.qylm.dto.baseSet.CustomInfoNurseCreateDto;
import com.qylm.dxo.CustomInfoCreateDxo;
import com.qylm.entity.AddressEntity;
import com.qylm.entity.CustomInfo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.Leaguer;
import com.qylm.service.CustomInfoService;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.LeaguerService;

/**
 * 客户档案登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class CustomInfoCreateBean implements Serializable, CreateBean<CustomInfo> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6488122205129790944L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(CustomInfoCreateBean.class);

	/**
	 * 存放客户档案登陆画面需要保存的值
	 */
	private CustomInfoCreateDto customInfoCreateDto = new CustomInfoCreateDto();
	
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
		customInfoCreateDto.setAddressEntity(new AddressEntity());
		addressFinderBean.clearAll();
		customInfoCreateDto.setName(null);
		customInfoCreateDto.setBirthday(null);
		customInfoCreateDto.setLeaguerNumber(null);
		customInfoCreateDto.setSpouse(null);
		customInfoCreateDto.setIssue(null);
		customInfoCreateDto.setBloodGroup(null);
		customInfoCreateDto.setMaritalStatus(null);
		customInfoCreateDto.setMaritalDeta(null);
		customInfoCreateDto.setAddressDetail(null);
		customInfoCreateDto.setOccupation(null);
		customInfoCreateDto.setMobile(null);
		customInfoCreateDto.setSkinType(null);
		customInfoCreateDto.setOcularRegionState(null);
		customInfoCreateDto.setFaceState(null);
		customInfoCreateDto.setFaceNeed(null);
		customInfoCreateDto.setDietPractice(null);
		customInfoCreateDto.setStapleFood(null);
		customInfoCreateDto.setRepast(null);
		customInfoCreateDto.setAddSeasonings(null);
		customInfoCreateDto.setXhwd(null);
		customInfoCreateDto.setYzsw(null);
		customInfoCreateDto.setDietaryBias(null);
		customInfoCreateDto.setPac(null);
		customInfoCreateDto.setDiet(null);
		customInfoCreateDto.setHealthState(null);
		customInfoCreateDto.setYjkzt(null);
		customInfoCreateDto.setSkinType1(null);
		customInfoCreateDto.setRemark(null);
		customInfoCreateDto.setHljy(null);
		customInfoCreateDto.setYearNumber(null);
		customInfoCreateDto.setImpressions(null);
		customInfoCreateDto.setShiftShopCause(null);
		customInfoCreateDto.setPurpose(null);
		customInfoCreateDto.setNurse(null);
		customInfoCreateDto.setMoney(null);
		customInfoCreateDto.setArrearage(null);
		customInfoCreateDto.setLeaguer(null);
		customInfoCreateDto.setLeaguerSource(null);
		customInfoCreateDto.setEmergencyContact(null);
		customInfoCreateDto.setEmergencyMobile(null);
		customInfoCreateDto.setLeaguerItems(null);
		customInfoCreateDto.setLeaguerIdList(null);
		customInfoCreateDto.setCustomLeaguerDetailList(null);
		customInfoCreateDto.setCustomInfoNurseCreateDto(null);
		customInfoCreateDto.setCreater(null);
		customInfoCreateDto.setBelongingUser(null);
		customInfoCreateDto.setPersonnelInfo1(null);
		customInfoCreateDto.setPersonnelInfo2(null);
		customInfoCreateDto.setTransferCustomInfo(null);
		return Navigation.CUSTOM_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于客户档案登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户档案登陆画面_返回按钮】");
		return customInfoCreateDto.getReturner().returnOnly();
	}

	/**
	 * 此方法绑定于客户档案登陆画面的保存按钮 
	 * 实现功能：根据transferCustomInfo对象判断当前操作时保存还是更新
	 * @return 画面不跳转
	 */
	public void saveCustomInfo() {
		Tool.sendLog(LOG, userBean, "【客户档案登陆画面_保存按钮】");
		CustomInfo transferCustomInfo = customInfoCreateDto.getTransferCustomInfo();
		if (transferCustomInfo == null) {
			transferCustomInfo = new CustomInfo();
			customInfoCreateDto.setCreater(userBean.getUser());
			customInfoCreateDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
			create(transferCustomInfo);
			transferCustomInfo.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
			customInfoService.saveEntity(transferCustomInfo);
			customInfoCreateDto.setTransferCustomInfo(transferCustomInfo);
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
		if (customInfoCreateDto.getSkinType() != null) {
			transferCustomInfo.setSkinType(StringUtil.join(customInfoCreateDto.getSkinType(), Constants.COMMA));
		}
		// 眼部情况
		if (customInfoCreateDto.getOcularRegionState() != null) {
			transferCustomInfo.setOcularRegionState(StringUtil.join(customInfoCreateDto.getOcularRegionState(), Constants.COMMA));
		}
		// 面部
		if (customInfoCreateDto.getFaceState() != null) {
			transferCustomInfo.setFaceState(StringUtil.join(customInfoCreateDto.getFaceState(), Constants.COMMA));
		}
		// 面部皮肤重建需要
		if (customInfoCreateDto.getFaceNeed() != null) {
			transferCustomInfo.setFaceNeed(StringUtil.join(customInfoCreateDto.getFaceNeed(), Constants.COMMA));
		}
		// 进食速度
		if (customInfoCreateDto.getDietPractice() != null) {
			transferCustomInfo.setDietPractice(StringUtil.join(customInfoCreateDto.getDietPractice(), Constants.COMMA));
		}
		// 主食
		if (customInfoCreateDto.getStapleFood() != null) {
			transferCustomInfo.setStapleFood(StringUtil.join(customInfoCreateDto.getStapleFood(), Constants.COMMA));
		}
		// 食量
		if (customInfoCreateDto.getRepast() != null) {
			transferCustomInfo.setRepast(StringUtil.join(customInfoCreateDto.getRepast(), Constants.COMMA));
		}
		// 加味调料
		if (customInfoCreateDto.getAddSeasonings() != null) {
			transferCustomInfo.setAddSeasonings(StringUtil.join(customInfoCreateDto.getAddSeasonings(), Constants.COMMA));
		}
		// 喜欢味道
		if (customInfoCreateDto.getXhwd() != null) {
			transferCustomInfo.setXhwd(StringUtil.join(customInfoCreateDto.getXhwd(), Constants.COMMA));
		}
		// 油炸食物
		if (customInfoCreateDto.getYzsw() != null) {
			transferCustomInfo.setYzsw(StringUtil.join(customInfoCreateDto.getYzsw(), Constants.COMMA));
		}
		// 偏食
		if (customInfoCreateDto.getDietaryBias() != null) {
			transferCustomInfo.setDietaryBias(StringUtil.join(customInfoCreateDto.getDietaryBias(), Constants.COMMA));
		}
		// 偏爱吃
		if (customInfoCreateDto.getPac() != null) {
			transferCustomInfo.setPac(StringUtil.join(customInfoCreateDto.getPac(), Constants.COMMA));
		}
		// 饮食
		if (customInfoCreateDto.getDiet() != null) {
			transferCustomInfo.setDiet(StringUtil.join(customInfoCreateDto.getDiet(), Constants.COMMA));
		}
		// 月经生理
		if (customInfoCreateDto.getHealthState() != null) {
			transferCustomInfo.setHealthState(StringUtil.join(customInfoCreateDto.getHealthState(), Constants.COMMA));
		}
		// 亚健康状态
		if (customInfoCreateDto.getYjkzt() != null) {
			transferCustomInfo.setYjkzt(StringUtil.join(customInfoCreateDto.getYjkzt(), Constants.COMMA));
		}
		// 在美容店接受面部皮肤护理经验
		if (StringUtil.isNotBlank(customInfoCreateDto.getHljy())) {
			transferCustomInfo.setHljy("1".equals(customInfoCreateDto.getHljy()));
		}
		// 为个人日常皮肤护理赋值
		CustomInfoNurseCreateDto customInfoNurseCreateDto = customInfoCreateDto.getCustomInfoNurseCreateDto();
		List<String> nurseList = new ArrayList<String>();
		//待修改
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue1()) ? " " : customInfoNurseCreateDto.getValue1());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue2()) ? " " : customInfoNurseCreateDto.getValue2());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue3()) ? " " : customInfoNurseCreateDto.getValue3());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue4()) ? " " : customInfoNurseCreateDto.getValue4());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue5()) ? " " : customInfoNurseCreateDto.getValue5());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue6()) ? " " : customInfoNurseCreateDto.getValue6());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue7()) ? " " : customInfoNurseCreateDto.getValue7());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue8()) ? " " : customInfoNurseCreateDto.getValue8());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue9()) ? " " : customInfoNurseCreateDto.getValue9());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue10()) ? " " : customInfoNurseCreateDto.getValue10());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue11()) ? " " : customInfoNurseCreateDto.getValue11());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue12()) ? " " : customInfoNurseCreateDto.getValue12());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue13()) ? " " : customInfoNurseCreateDto.getValue13());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue14()) ? " " : customInfoNurseCreateDto.getValue14());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue15()) ? " " : customInfoNurseCreateDto.getValue15());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue16()) ? " " : customInfoNurseCreateDto.getValue16());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue17()) ? " " : customInfoNurseCreateDto.getValue17());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue18()) ? " " : customInfoNurseCreateDto.getValue18());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue19()) ? " " : customInfoNurseCreateDto.getValue19());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue20()) ? " " : customInfoNurseCreateDto.getValue20());
//		nurseList.add(StringUtil.isBlank(customInfoNurseCreateDto.getValue21()) ? " " : customInfoNurseCreateDto.getValue21());
		customInfoCreateDto.setNurse(StringUtil.join(nurseList, Constants.ASTERISK));
		List<String> leaguerIdList = customInfoCreateDto.getLeaguerIdList();
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
		CustomInfoCreateDxo.dtoToEntity(customInfoCreateDto, transferCustomInfo);
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		customInfoCreateDto.setReturner(returner);
		customInfoCreateDto.setAddressEntity(new AddressEntity());
		addressFinderBean.clearAll();
		customInfoCreateDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getAll(), false));
		return Navigation.CUSTOM_INFO_CREATE;
	}

	public String updateDetail(Returner<?, ?, ?> returner, CustomInfo customInfo) {
		customInfoCreateDto.setReturner(returner);
		CustomInfoCreateDxo.entityToDto(customInfo, customInfoCreateDto);
		
		
		customInfoCreateDto.setSkinType(StringUtil.split(customInfo.getSkinType(), Constants.COMMA));
		customInfoCreateDto.setOcularRegionState(StringUtil.split(customInfo.getOcularRegionState(), Constants.COMMA));
		customInfoCreateDto.setFaceState(StringUtil.split(customInfo.getFaceState(), Constants.COMMA));
		customInfoCreateDto.setFaceNeed(StringUtil.split(customInfo.getFaceNeed(), Constants.COMMA));
		customInfoCreateDto.setDietPractice(StringUtil.split(customInfo.getDietPractice(), Constants.COMMA));
		customInfoCreateDto.setStapleFood(StringUtil.split(customInfo.getStapleFood(), Constants.COMMA));
		customInfoCreateDto.setRepast(StringUtil.split(customInfo.getRepast(), Constants.COMMA));
		customInfoCreateDto.setAddSeasonings(StringUtil.split(customInfo.getAddSeasonings(), Constants.COMMA));
		customInfoCreateDto.setXhwd(StringUtil.split(customInfo.getXhwd(), Constants.COMMA));
		customInfoCreateDto.setYzsw(StringUtil.split(customInfo.getYzsw(), Constants.COMMA));
		customInfoCreateDto.setDietaryBias(StringUtil.split(customInfo.getDietaryBias(), Constants.COMMA));
		customInfoCreateDto.setPac(StringUtil.split(customInfo.getPac(), Constants.COMMA));
		customInfoCreateDto.setDiet(StringUtil.split(customInfo.getDiet(), Constants.COMMA));
		customInfoCreateDto.setHealthState(StringUtil.split(customInfo.getHealthState(), Constants.COMMA));
		customInfoCreateDto.setYjkzt(StringUtil.split(customInfo.getYjkzt(), Constants.COMMA));
		customInfoCreateDto.setHljy(customInfo.isHljy() ? "1" : "2");
		// 为个人日常皮肤护理赋值
//		String[] splits = StringUtil.split(customInfo.getNurse(), Constants.ASTERISK);
//		CustomInfoNurseCreateDto customInfoNurseCreateDto = customInfoCreateDto.getCustomInfoNurseCreateDto();
//		customInfoNurseCreateDto.setValue1(splits[0]);
//		customInfoNurseCreateDto.setValue2(splits[1]);
//		customInfoNurseCreateDto.setValue3(splits[2]);
//		customInfoNurseCreateDto.setValue4(splits[3]);
//		customInfoNurseCreateDto.setValue5(splits[4]);
//		customInfoNurseCreateDto.setValue6(splits[5]);
//		customInfoNurseCreateDto.setValue7(splits[6]);
//		customInfoNurseCreateDto.setValue8(splits[7]);
//		customInfoNurseCreateDto.setValue9(splits[8]);
//		customInfoNurseCreateDto.setValue10(splits[9]);
//		customInfoNurseCreateDto.setValue11(splits[10]);
//		customInfoNurseCreateDto.setValue12(splits[11]);
//		customInfoNurseCreateDto.setValue13(splits[12]);
//		customInfoNurseCreateDto.setValue14(splits[13]);
//		customInfoNurseCreateDto.setValue15(splits[14]);
//		customInfoNurseCreateDto.setValue16(splits[15]);
//		customInfoNurseCreateDto.setValue17(splits[16]);
//		customInfoNurseCreateDto.setValue18(splits[17]);
//		customInfoNurseCreateDto.setValue19(splits[18]);
//		customInfoNurseCreateDto.setValue20(splits[19]);
//		customInfoNurseCreateDto.setValue21(splits[20]);
		customInfoCreateDto.setTransferCustomInfo(customInfo);
		if(customInfo.getAddressEntity()==null){
			customInfoCreateDto.setAddressEntity(new AddressEntity());
			addressFinderBean.clearAll();
		}else{
			addressFinderBean.initAllByAddressEntity(customInfo.getAddressEntity());
		}
		return Navigation.CUSTOM_INFO_CREATE;
	}
	
	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * set customInfoService
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @param addressFinderBean the addressFinderBean to set
	 */
	public void setAddressFinderBean(AddressFinderBean addressFinderBean) {
		this.addressFinderBean = addressFinderBean;
	}

	/**
	 * get customInfoCreateDto
	 * @return the customInfoCreateDto
	 */
	public CustomInfoCreateDto getCustomInfoCreateDto() {
		return customInfoCreateDto;
	}

	/**
	 * set customInfoCreateDto
	 * @param customInfoCreateDto the customInfoCreateDto to set
	 */
	public void setCustomInfoCreateDto(CustomInfoCreateDto customInfoCreateDto) {
		this.customInfoCreateDto = customInfoCreateDto;
	}

}
