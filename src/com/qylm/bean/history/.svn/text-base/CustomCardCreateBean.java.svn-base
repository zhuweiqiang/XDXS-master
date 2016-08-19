package com.qylm.bean.history;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.qylm.bean.UserBean;
import com.qylm.bean.returner.Returner;
import com.qylm.common.CreateBean;
import com.qylm.common.Message;
import com.qylm.common.MothedUtil;
import com.qylm.common.Navigation;
import com.qylm.common.Tool;
import com.qylm.common.utils.SelectItemUtil;
import com.qylm.dto.history.CustomCardCreateDto;
import com.qylm.dxo.CustomCardCreateDxo;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.Leaguer;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.GiveInfoService;
import com.qylm.service.LeaguerService;

/**
 * 客户卡项记录登录
 * @author 
 */
@ManagedBean
@RequestScoped
public class CustomCardCreateBean implements CreateBean<CustomLeaguerDetail>{
	
	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(CustomCardCreateBean.class);

	/**
	 * 存放购卡登陆画面需要保存的值
	 */
	private CustomCardCreateDto customCardCreateDto = new CustomCardCreateDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 卡项业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
	/**
	 * 客户档案与卡项的关系业务类
	 */
	@ManagedProperty(value="#{customLeaguerDetailService}")
	private CustomLeaguerDetailService customLeaguerDetailService;
	
	/**
	 * 客户档案与卡项的关系业务类
	 */
	@ManagedProperty(value="#{giveInfoService}")
	private GiveInfoService giveInfoService;
	
	/**
	 * 此方法绑定于客户卡项记录登录画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 购卡登陆画面
	 */
	public String newCustomCard() {
		Tool.sendLog(LOG, userBean, "【客户卡项记录登录画面_新建按钮】");
		customCardCreateDto.setCustomInfo(null);
		customCardCreateDto.setLeaguer(null);
		customCardCreateDto.setMoney(null);
		customCardCreateDto.setRebate(null);
		//获取卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		customCardCreateDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getByDetachedCriteria(detachedCriteria), false));
		customCardCreateDto.setCreateDate(null);
		customCardCreateDto.setCreater(null);
		customCardCreateDto.setBelongingUser(null);
		customCardCreateDto.setTransferCustomLeaguerDetail(null);
		return Navigation.CUSTOM_CARD_CREATE;
	}
	
	/**
	 * 此方法绑定于客户卡项记录登录画面的保存按钮 
	 * 实现功能：并保存一个事件
	 * @return 购卡登陆画面
	 */
	public void saveCustomCard() {
		Tool.sendLog(LOG, userBean, "按下【客户卡项记录登录画面_保存记录按钮】");
		CustomLeaguerDetail transferCustomLeaguerDetail = customCardCreateDto.getTransferCustomLeaguerDetail();
		Leaguer leaguer = null;
		GiveInfo giveInfo = null;
		if(customCardCreateDto.getLeguerId()!=null){
		 leaguer = leaguerService.getById(Integer.valueOf(customCardCreateDto.getLeguerId()));
		}
		if(customCardCreateDto.getGiveInfoId()!=null){
		 giveInfo = giveInfoService.getById(Integer.valueOf(customCardCreateDto.getGiveInfoId()));
		}
		if (transferCustomLeaguerDetail == null) {
			transferCustomLeaguerDetail = new CustomLeaguerDetail();
			if(customCardCreateDto.getLeguerId()!=null){
				customCardCreateDto.setLeaguer(leaguer);				
			}
		if(customCardCreateDto.getGiveInfoId()!=null){
			customCardCreateDto.setGiveInfo(giveInfo);
			}
		    customCardCreateDto.setBelongingUser(userBean.getUser());
			CustomCardCreateDxo.dtoToEntity(customCardCreateDto, transferCustomLeaguerDetail);
			customLeaguerDetailService.saveEntity(transferCustomLeaguerDetail);
			customCardCreateDto.setTransferCustomLeaguerDetail(transferCustomLeaguerDetail);
		} else {
			transferCustomLeaguerDetail.setLeaguer(leaguer);
			CustomCardCreateDxo.dtoToEntity(customCardCreateDto, transferCustomLeaguerDetail);
			
			customLeaguerDetailService.updateEntity(transferCustomLeaguerDetail);
		}
		Tool.sendErrorMessage(Message.GENERAL_SAVESUCCESS);
	}
	
	/**
	 * 此方法绑定于客户卡项记录登录画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 购卡登陆画面
	 */
	public String newCreate(Returner<?, ?, ?> returner) {
		customCardCreateDto.setReturner(returner);
		// 获取到卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		customCardCreateDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getByDetachedCriteria(detachedCriteria), false));
		return Navigation.CUSTOM_CARD_CREATE;
	}
	
	public String newCreate(Returner<?, ?, ?> returner,String type) {
		customCardCreateDto.setReturner(returner);
		//获取优惠券项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, type));
		customCardCreateDto.setGiveInfoItems(SelectItemUtil.createSelectItems(giveInfoService.getByDetachedCriteria(detachedCriteria), false));
		
		if (GiveInfo.TYPE_1.equals(type)) {
			customCardCreateDto.setTitle("体验卡");
		} else if (GiveInfo.TYPE_2.equals(type)) {
			customCardCreateDto.setTitle("现金卷");
		} else if (GiveInfo.TYPE_3.equals(type)) {
			customCardCreateDto.setTitle("身体卷");
		}
		return Navigation.HISTORY_GIVE_INFO_CREATE;
	}
	
	public String updateDetail(Returner<?, ?, ?> returner,CustomLeaguerDetail entity) {
		customCardCreateDto.setReturner(returner);
		CustomCardCreateDxo.entityToDto(entity, customCardCreateDto);
		customCardCreateDto.setTransferCustomLeaguerDetail(entity);
		customCardCreateDto.setLeguerId(entity.getLeaguer().getValue());
		// 获取到卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		customCardCreateDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getByDetachedCriteria(detachedCriteria), false));
		return Navigation.CUSTOM_CARD_CREATE;
	}
	
	//更新部分代码重用
	public String updateDetail(Returner<?, ?, ?> returner,CustomLeaguerDetail entity,String type){
		customCardCreateDto.setReturner(returner);
		CustomCardCreateDxo.entityToDto(entity, customCardCreateDto);
		customCardCreateDto.setTransferCustomLeaguerDetail(entity);
		//获取卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, type));
		customCardCreateDto.setGiveInfoItems(SelectItemUtil.createSelectItems(giveInfoService.getByDetachedCriteria(detachedCriteria), false));
		return Navigation.HISTORY_GIVE_INFO_CREATE;
	}
	
	/**
	 * 此方法绑定于购卡登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【客户卡项记录登录画面_返回按钮】");
		return customCardCreateDto.getReturner().returnOnly();
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
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the customCardCreateDto
	 */
	public CustomCardCreateDto getCustomCardCreateDto() {
		return customCardCreateDto;
	}

	/**
	 * @param customCardCreateDto the customCardCreateDto to set
	 */
	public void setCustomCardCreateDto(CustomCardCreateDto customCardCreateDto) {
		this.customCardCreateDto = customCardCreateDto;
	}

	/**
	 * @param giveInfoService the giveInfoService to set
	 */
	public void setGiveInfoService(GiveInfoService giveInfoService) {
		this.giveInfoService = giveInfoService;
	}
}
