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
import com.qylm.common.utils.StringUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.baseSet.CustomInfoNurseCreateDto;
import com.qylm.dto.baseSet.CustomInfoViewDto;
import com.qylm.dxo.CustomInfoViewDxo;
import com.qylm.entity.CustomInfo;
import com.qylm.service.CustomInfoService;

/**
 * 客户档案登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class CustomInfoViewBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7958870958196804685L;

	/**
	 * 存放客户档案登陆画面需要保存的值
	 */
	private CustomInfoViewDto customInfoViewDto = new CustomInfoViewDto();
	
	/**
	 * 事件管理业务类
	 */
	@ManagedProperty(value="#{customInfoService}")
	private CustomInfoService customInfoService;
	
	/**
	 * 查看详细
	 * @param customInfo
	 * @return
	 */
	public String viewDetail(CustomInfo customInfo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomInfo.class);
		detachedCriteria.createAlias(CustomInfo.PERSONNEL_INFO_1, CustomInfo.PERSONNEL_INFO_1, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomInfo.PERSONNEL_INFO_2, CustomInfo.PERSONNEL_INFO_2, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomInfo.BASE_ID, customInfo.getId()));
		List<CustomInfo> customInfoList = customInfoService.getByDetachedCriteria(detachedCriteria);
		if (!customInfoList.isEmpty()) {
			customInfo = customInfoList.get(0);
			CustomInfoViewDxo.entityToDto(customInfo, customInfoViewDto);
			customInfoViewDto.setSkinType(StringUtil.split(customInfo.getSkinType(), Constants.COMMA));
			customInfoViewDto.setOcularRegionState(StringUtil.split(customInfo.getOcularRegionState(), Constants.COMMA));
			customInfoViewDto.setFaceState(StringUtil.split(customInfo.getFaceState(), Constants.COMMA));
			customInfoViewDto.setFaceNeed(StringUtil.split(customInfo.getFaceNeed(), Constants.COMMA));
			customInfoViewDto.setDietPractice(StringUtil.split(customInfo.getDietPractice(), Constants.COMMA));
			customInfoViewDto.setStapleFood(StringUtil.split(customInfo.getStapleFood(), Constants.COMMA));
			customInfoViewDto.setRepast(StringUtil.split(customInfo.getRepast(), Constants.COMMA));
			customInfoViewDto.setAddSeasonings(StringUtil.split(customInfo.getAddSeasonings(), Constants.COMMA));
			customInfoViewDto.setXhwd(StringUtil.split(customInfo.getXhwd(), Constants.COMMA));
			customInfoViewDto.setYzsw(StringUtil.split(customInfo.getYzsw(), Constants.COMMA));
			customInfoViewDto.setDietaryBias(StringUtil.split(customInfo.getDietaryBias(), Constants.COMMA));
			customInfoViewDto.setPac(StringUtil.split(customInfo.getPac(), Constants.COMMA));
			customInfoViewDto.setDiet(StringUtil.split(customInfo.getDiet(), Constants.COMMA));
			customInfoViewDto.setHealthState(StringUtil.split(customInfo.getHealthState(), Constants.COMMA));
			customInfoViewDto.setYjkzt(StringUtil.split(customInfo.getYjkzt(), Constants.COMMA));
			customInfoViewDto.setHljy(customInfo.isHljy() ? "1" : "2");
			// 为个人日常皮肤护理赋值
			String[] splits = StringUtil.split(customInfo.getNurse(), Constants.ASTERISK);
			CustomInfoNurseCreateDto customInfoNurseCreateDto = customInfoViewDto.getCustomInfoNurseCreateDto();
			customInfoNurseCreateDto.setValue1(splits[0]);
			customInfoNurseCreateDto.setValue2(splits[1]);
			customInfoNurseCreateDto.setValue3(splits[2]);
			customInfoNurseCreateDto.setValue4(splits[3]);
			customInfoNurseCreateDto.setValue5(splits[4]);
			customInfoNurseCreateDto.setValue6(splits[5]);
			customInfoNurseCreateDto.setValue7(splits[6]);
			customInfoNurseCreateDto.setValue8(splits[7]);
			customInfoNurseCreateDto.setValue9(splits[8]);
			customInfoNurseCreateDto.setValue10(splits[9]);
			customInfoNurseCreateDto.setValue11(splits[10]);
			customInfoNurseCreateDto.setValue12(splits[11]);
			customInfoNurseCreateDto.setValue13(splits[12]);
			customInfoNurseCreateDto.setValue14(splits[13]);
			customInfoNurseCreateDto.setValue15(splits[14]);
			customInfoNurseCreateDto.setValue16(splits[15]);
			customInfoNurseCreateDto.setValue17(splits[16]);
			customInfoNurseCreateDto.setValue18(splits[17]);
			customInfoNurseCreateDto.setValue19(splits[18]);
			customInfoNurseCreateDto.setValue20(splits[19]);
			customInfoNurseCreateDto.setValue21(splits[20]);
		}
		return Navigation.CUSTOM_INFO_VIEW;
	}
	
	/**
	 * @param customInfoService the customInfoService to set
	 */
	public void setCustomInfoService(CustomInfoService customInfoService) {
		this.customInfoService = customInfoService;
	}

	/**
	 * @return the customInfoViewDto
	 */
	public CustomInfoViewDto getCustomInfoViewDto() {
		return customInfoViewDto;
	}

	/**
	 * @param customInfoViewDto the customInfoViewDto to set
	 */
	public void setCustomInfoViewDto(CustomInfoViewDto customInfoViewDto) {
		this.customInfoViewDto = customInfoViewDto;
	}

}
