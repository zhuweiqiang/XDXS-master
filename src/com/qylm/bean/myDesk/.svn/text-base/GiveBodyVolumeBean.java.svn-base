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
import com.qylm.dto.myDesk.GiveBodyVolumeDto;
import com.qylm.dxo.GiveBodyVolumeDxo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.GiveInfoService;

/**
 * 赠送身体卷登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class GiveBodyVolumeBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2626888473117927390L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(GiveBodyVolumeBean.class);

	/**
	 * 存放赠送身体卷登陆画面需要保存的值
	 */
	private GiveBodyVolumeDto giveBodyVolumeDto = new GiveBodyVolumeDto();
	
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
	 * 此方法绑定于赠送身体卷登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 赠送身体卷登陆画面
	 */
	public String newGiveBodyVolume() {
		Tool.sendLog(LOG, userBean, "【赠送身体卷登陆画面_新建按钮】");
		giveBodyVolumeDto.setCustomInfo(null);
		giveBodyVolumeDto.setPersonnelInfo(null);
		giveBodyVolumeDto.setAdviser(null);
		giveBodyVolumeDto.setDate(DateUtil.getNowyyyymmdd());
		giveBodyVolumeDto.setGiveInfo(null);
		giveBodyVolumeDto.setMoney(null);
		giveBodyVolumeDto.setNumber(null);
		giveBodyVolumeDto.setExperienceCardId(null);
		giveBodyVolumeDto.setCustomLeaguerDetailList(null);
		giveBodyVolumeDto.setCreater(null);
		giveBodyVolumeDto.setBelongingUser(null);
		return Navigation.GIVE_BODY_VOLUME;
	}
	
	/**
	 * 此方法绑定于赠送身体卷登陆画面的确认赠送按钮
	 */
	public void save() {
		Tool.sendLog(LOG, userBean, "【赠送身体卷登陆画面_确认赠送按钮】");
		String[] experienceCardId = giveBodyVolumeDto.getExperienceCardId();
		System.out.println(experienceCardId.length);
		if (experienceCardId == null || experienceCardId.length <= 0) {
			Tool.sendErrorMessage("请选择要赠送的身体卷！");
			return;
		}
		giveBodyVolumeDto.setCreater(userBean.getUser());
		giveBodyVolumeDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
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
				giveBodyVolumeDto.setGiveInfo(giveInfo);
				GiveBodyVolumeDxo.dtoToEntity(giveBodyVolumeDto, customLeaguerDetail);
				customLeaguerDetail.setCreateDate(DateUtil.getNowyyyymmddhhmmss());
				customLeaguerDetail.setMoney(giveInfo.getMoney());
				customLeaguerDetailList.add(customLeaguerDetail);
			}
			customLeaguerDetailService.saveEntityAll(customLeaguerDetailList);
			Tool.sendErrorMessage("赠送成功！");
			newGiveBodyVolume();
		}
	}
	
	/**
	 * 此方法绑定于赠送身体卷登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【赠送身体卷登陆画面_返回按钮】");
		return giveBodyVolumeDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		giveBodyVolumeDto.setReturner(returner);
		giveBodyVolumeDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		// 获取到身体卷
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, GiveInfo.TYPE_3));
		giveBodyVolumeDto.setExperienceCardItem(SelectItemUtil.createSelectItems(giveInfoService.getByDetachedCriteria(detachedCriteria), false));
		return Navigation.GIVE_BODY_VOLUME;
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		giveBodyVolumeDto.setMoney(giveBodyVolumeDto.getCustomInfo().getMoney());
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, giveBodyVolumeDto.getCustomInfo()));
		// 只查询身体卷
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.GIVE_INFO));
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.GIVE_INFO_TYPE, GiveInfo.TYPE_3));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.GIVE_INFO));
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		giveBodyVolumeDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
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
	 * get giveBodyVolumeDto
	 * @return the giveBodyVolumeDto
	 */
	public GiveBodyVolumeDto getGiveBodyVolumeDto() {
		return giveBodyVolumeDto;
	}

	/**
	 * set giveBodyVolumeDto
	 * @param giveBodyVolumeDto the giveBodyVolumeDto to set
	 */
	public void setGiveBodyVolumeDto(GiveBodyVolumeDto giveBodyVolumeDto) {
		this.giveBodyVolumeDto = giveBodyVolumeDto;
	}

}
