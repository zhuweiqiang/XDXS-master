package com.qylm.bean.myDesk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.SelectItemUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.myDesk.GiveExperienceCardDto;
import com.qylm.dxo.GiveExperienceCardDxo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.GiveInfoService;

/**
 * 赠送体验卡登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class GiveExperienceCardBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2972374827219545605L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(GiveExperienceCardBean.class);

	/**
	 * 存放赠送体验卡登陆画面需要保存的值
	 */
	private GiveExperienceCardDto giveExperienceCardDto = new GiveExperienceCardDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 客户档案与卡项业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 体验卡信息业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 此方法绑定于赠送体验卡登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 赠送体验卡登陆画面
	 */
	public String newGiveExperienceCard() {
		Tool.sendLog(LOG, userBean, "【赠送体验卡登陆画面_新建按钮】");
		giveExperienceCardDto.setCustomInfo(null);
		giveExperienceCardDto.setPersonnelInfo(null);
		giveExperienceCardDto.setAdviser(null);
		giveExperienceCardDto.setDate(DateUtil.getNowyyyymmdd());
		giveExperienceCardDto.setGiveInfo(null);
		giveExperienceCardDto.setMoney(null);
		giveExperienceCardDto.setNumber(null);
		giveExperienceCardDto.setExperienceCardId(null);
		giveExperienceCardDto.setCustomLeaguerDetailList(null);
		giveExperienceCardDto.setCreater(null);
		giveExperienceCardDto.setBelongingUser(null);
		return Navigation.GIVE_EXPERIENCE_CARD;
	}
	
	/**
	 * 此方法绑定于赠送体验卡登陆画面的确认赠送按钮
	 */
	public void save() {
		Tool.sendLog(LOG, userBean, "【赠送体验卡登陆画面_确认赠送按钮】");
		String[] experienceCardId = giveExperienceCardDto.getExperienceCardId();
		System.out.println(experienceCardId.length);
		if (experienceCardId == null || experienceCardId.length <= 0) {
			Tool.sendErrorMessage("请选择要赠送的体验卡！");
			return;
		}
		giveExperienceCardDto.setCreater(userBean.getUser());
		giveExperienceCardDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : experienceCardId) {
			idList.add(Integer.valueOf(id));
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.in(GiveInfo.BASE_ID, idList));
		List<GiveInfo> giveInfoList = giveInfoService.getByDetachedCriteria(detachedCriteria);
		if (!giveInfoList.isEmpty()) {
			List<CustomLeaguerDetail> customLeaguerDetailList = new ArrayList<CustomLeaguerDetail>();
			for (GiveInfo giveInfo : giveInfoList) {
				CustomLeaguerDetail customLeaguerDetail = new CustomLeaguerDetail();
				giveExperienceCardDto.setGiveInfo(giveInfo);
				GiveExperienceCardDxo.dtoToEntity(giveExperienceCardDto, customLeaguerDetail);
				customLeaguerDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				customLeaguerDetail.setMoney(giveInfo.getMoney());
				customLeaguerDetailList.add(customLeaguerDetail);
			}
			customLeaguerDetailService.saveEntityAll(customLeaguerDetailList);
			Tool.sendErrorMessage("赠送成功！");
			newGiveExperienceCard();
		}
	}
	
	/**
	 * 此方法绑定于赠送体验卡登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【赠送体验卡登陆画面_返回按钮】");
		return giveExperienceCardDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		giveExperienceCardDto.setReturner(returner);
		giveExperienceCardDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		// 获取到体验卡
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, GiveInfo.TYPE_1));
		giveExperienceCardDto.setExperienceCardItem(SelectItemUtil.createSelectItems(giveInfoService.getByDetachedCriteria(detachedCriteria), false));
		return Navigation.GIVE_EXPERIENCE_CARD;
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		giveExperienceCardDto.setMoney(giveExperienceCardDto.getCustomInfo().getMoney());
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, giveExperienceCardDto.getCustomInfo()));
		// 只查询体验卡
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.GIVE_INFO));
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.GIVE_INFO_TYPE, GiveInfo.TYPE_1));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.GIVE_INFO));
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		List<CustomLeaguerDetail> customLeaguerDetailList = customLeaguerDetailService.getByDetachedCriteria(detachedCriteria);
		giveExperienceCardDto.setCustomLeaguerDetailList(customLeaguerDetailList);
	}
	
	/**
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}

	/**
	 * @param customLeaguerDetailService the customLeaguerDetailService to set
	 */
	public void setCustomLeaguerDetailService(
			CustomLeaguerDetailService customLeaguerDetailService) {
		this.customLeaguerDetailService = customLeaguerDetailService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get giveExperienceCardDto
	 * @return the giveExperienceCardDto
	 */
	public GiveExperienceCardDto getGiveExperienceCardDto() {
		return giveExperienceCardDto;
	}

	/**
	 * set giveExperienceCardDto
	 * @param giveExperienceCardDto the giveExperienceCardDto to set
	 */
	public void setGiveExperienceCardDto(GiveExperienceCardDto giveExperienceCardDto) {
		this.giveExperienceCardDto = giveExperienceCardDto;
	}

}
