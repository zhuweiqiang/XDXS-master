package com.qylm.bean.myDesk;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.qylm.common.utils.BigDecimalUtil;
import com.qylm.common.utils.DateUtil;
import com.qylm.common.utils.SelectItemUtil;
import com.qylm.constants.Constants;
import com.qylm.dto.myDesk.ShopCardDto;
import com.qylm.entity.CustomLeaguerDetail;
import com.qylm.entity.GiveInfo;
import com.qylm.entity.Leaguer;
import com.qylm.service.ConsumptionRegisterService;
import com.qylm.service.CustomLeaguerDetailService;
import com.qylm.service.GiveInfoService;
import com.qylm.service.LeaguerService;

/**
 * 购卡登陆画面bean
 * @author 
 */
@ManagedBean
@RequestScoped
public class ShopCardBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6037240078125707908L;

	/**
	 * LOG
	 */
	private static final Log LOG = LogFactory.getLog(ShopCardBean.class);

	/**
	 * 存放购卡登陆画面需要保存的值
	 */
	private ShopCardDto shopCardDto = new ShopCardDto();
	
	/**
	 * 事件bean
	 */
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	/**
	 * 事件业务类
	 */
	@ManagedProperty(value="#{consumptionRegisterService}")
	private ConsumptionRegisterService consumptionRegisterService;
	
	/**
	 * 卡项业务类
	 */
	@ManagedProperty(value="#{leaguerService}")
	private LeaguerService leaguerService;
	
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
	 * 此方法绑定于购卡登陆画面的新建按钮 
	 * 实现功能：清空注入信息，并新建一个事件
	 * @return 购卡登陆画面
	 */
	public String newShopCard() {
		Tool.sendLog(LOG, userBean, "【购卡登陆画面_新建按钮】");
		shopCardDto.setCustomInfo(null);
		shopCardDto.setPersonnelInfo(null);
		shopCardDto.setAdviser(null);
		shopCardDto.setDate(DateUtil.getNowyyyymmdd());
		shopCardDto.setMoney(null);
		shopCardDto.setArrearage(null);
		shopCardDto.setRealityMoney(null);
		shopCardDto.setState(false);
		// 获取到卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		shopCardDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getByDetachedCriteria(detachedCriteria), false));
		shopCardDto.setExperienceCardId(null);
		shopCardDto.setExperienceCardItem(null);
		shopCardDto.setSumLeaguerMoney(null);
		shopCardDto.setCustomLeaguerDetailList(null);
		shopCardDto.setBalance(null);
		shopCardDto.setSurplusMoney(null);
		shopCardDto.setSumMoney(null);
		shopCardDto.setReadyMoney(null);
		shopCardDto.setCreater(null);
		shopCardDto.setBelongingUser(null);
		shopCardDto.setTransferConsumptionRegister(null);
		return Navigation.SHOP_CARD;
	}
	
	/**
	 * 此方法绑定于购卡登陆画面的返回按钮 
	 * 实现功能：返回共通方法
	 * @return 返回共通方法
	 */
	public String back() {
		Tool.sendLog(LOG, userBean, "【购卡登陆画面_返回按钮】");
		return shopCardDto.getReturner().returnOnly();
	}

	public String newCreate(Returner<?, ?, ?> returner) {
		shopCardDto.setReturner(returner);
		shopCardDto.setDate(DateUtil.getNowyyyymmddhhmmss());
		// 获取到卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
		MothedUtil.getBelongingUser(detachedCriteria, userBean.getUser());
		shopCardDto.setLeaguerItems(SelectItemUtil.createSelectItems(leaguerService.getByDetachedCriteria(detachedCriteria), false));
		
		// 获取到体验卡
		detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
		detachedCriteria.add(Restrictions.eq(GiveInfo.TYPE, GiveInfo.TYPE_1));
		shopCardDto.setExperienceCardItem(SelectItemUtil.createSelectItems(giveInfoService.getByDetachedCriteria(detachedCriteria), false));
		return Navigation.SHOP_CARD;
	}
	
	/**
	 * 此方法绑定于购卡登陆画面的选择付款按钮 
	 * @return 画面不跳转
	 */
	public void findPay() {
		Tool.sendLog(LOG, userBean, "按下【购卡登陆画面_选择付款按钮】");
		String[] leaguerId = shopCardDto.getLeaguerId();
		if (leaguerId == null || leaguerId.length == 0) {
			Tool.sendErrorMessage("请选择卡项");
			return;
		}
		if (BigDecimalUtil.bigThan(shopCardDto.getMoney(), shopCardDto.getRealityMoney())) {
			shopCardDto.setBalance(shopCardDto.getRealityMoney());
		} else {
			shopCardDto.setBalance(shopCardDto.getMoney());
		}
		getSurplusMoney();
	}
	
	/**
	 * 此方法绑定于购卡登陆画面的确认付款按钮 
	 * @return 画面不跳转
	 */
	public void queryPay() {
		Tool.sendLog(LOG, userBean, "按下【购卡登陆画面_确认付款按钮】");
		// 验证付款金额是否超出了需要支付的金额
		if (BigDecimalUtil.bigThan(shopCardDto.getSumMoney(), shopCardDto.getRealityMoney())) {
			Tool.sendErrorMessage("多付钱了，请确认！");
			return;
		}
		shopCardDto.setCreater(userBean.getUser());
		shopCardDto.setBelongingUser(MothedUtil.getBelongingUser(userBean.getUser()));
		consumptionRegisterService.saveConsumptionRegister(shopCardDto);
		newShopCard();
		Tool.sendErrorMessage("付款成功！");
	}
	
	/**
	 * 清空选择到的项目
	 */
	public void clearMarketingProject() {
		shopCardDto.setMoney(shopCardDto.getCustomInfo().getMoney());
		// 获取当前客户下所有的卡项
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CustomLeaguerDetail.class);
		detachedCriteria.createAlias(CustomLeaguerDetail.CUSTOM_INFO, CustomLeaguerDetail.CUSTOM_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.LEAGUER, CustomLeaguerDetail.LEAGUER, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.createAlias(CustomLeaguerDetail.GIVE_INFO, CustomLeaguerDetail.GIVE_INFO, JoinType.LEFT_OUTER_JOIN);
		detachedCriteria.add(Restrictions.eq(CustomLeaguerDetail.CUSTOM_INFO, shopCardDto.getCustomInfo()));
		// 除体验卡、赠送现金卷、身体卷
		detachedCriteria.add(Restrictions.isNotNull(CustomLeaguerDetail.LEAGUER));
		detachedCriteria.addOrder(Order.desc(CustomLeaguerDetail.LEAGUER));
		detachedCriteria.add(Restrictions.gt(CustomLeaguerDetail.MONEY, Constants.BIGDECIMAL_ZERO));
		shopCardDto.setCustomLeaguerDetailList(customLeaguerDetailService.getByDetachedCriteria(detachedCriteria));
	}
	
	/**
	 * 选择卡项后计算出的总金额
	 */
	public void getSumLeaguerMoney() {
		String[] leaguerId = shopCardDto.getLeaguerId();
		BigDecimal sumLeaguerMoney = Constants.BIGDECIMAL_ZERO;
		List<Integer> idList = new ArrayList<Integer>();
		if (leaguerId != null && leaguerId.length > 0) {
			for (String string : leaguerId) {
				idList.add(Integer.valueOf(string));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Leaguer.class);
			detachedCriteria.add(Restrictions.in(Leaguer.BASE_ID, idList));
			List<Leaguer> leaguerList = leaguerService.getByDetachedCriteria(detachedCriteria);
			
			for (Leaguer leaguer : leaguerList) {
				sumLeaguerMoney = BigDecimalUtil.add(sumLeaguerMoney, leaguer.getMoney());
			}
		}
		idList.clear();
		String[] experienceCardId = shopCardDto.getExperienceCardId();
		if (experienceCardId != null && experienceCardId.length > 0) {
			for (String id : experienceCardId) {
				idList.add(Integer.valueOf(id));
			}
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GiveInfo.class);
			detachedCriteria.add(Restrictions.in(GiveInfo.BASE_ID, idList));
			List<GiveInfo> giveInfoList = giveInfoService.getByDetachedCriteria(detachedCriteria);
			for (GiveInfo giveInfo : giveInfoList) {
				sumLeaguerMoney = BigDecimalUtil.add(sumLeaguerMoney, giveInfo.getMoney());
			}
		}
		shopCardDto.setSumLeaguerMoney(sumLeaguerMoney);
		shopCardDto.setRealityMoney(sumLeaguerMoney);
	}
	
	/**
	 * 获取付款后，计算出还需要付款的金额
	 */
	public void getSurplusMoney() {
		BigDecimal sumMoney = Constants.BIGDECIMAL_ZERO;
		// 获取充值卡付款记录
		if (BigDecimalUtil.isNotNullOrZero(shopCardDto.getBalance())) {
			sumMoney = BigDecimalUtil.add(sumMoney, shopCardDto.getBalance());
		}
		// 获取现金付款记录
		if (BigDecimalUtil.isNotNullOrZero(shopCardDto.getReadyMoney())) {
			sumMoney = BigDecimalUtil.add(sumMoney, shopCardDto.getReadyMoney());
		}
		// 获取充值卡付款记录
		List<CustomLeaguerDetail> customLeaguerDetailList = shopCardDto.getCustomLeaguerDetailList();
		for (CustomLeaguerDetail customLeaguerDetail : customLeaguerDetailList) {
			sumMoney = BigDecimalUtil.add(sumMoney, customLeaguerDetail.getReadyMoney());
		}
		// 总金额-已经付款的金额=还需要支付的金额
		shopCardDto.setSumMoney(sumMoney);
		shopCardDto.setSurplusMoney(BigDecimalUtil.subtract(shopCardDto.getRealityMoney(), sumMoney));
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
	 * @param leaguerService the leaguerService to set
	 */
	public void setLeaguerService(LeaguerService leaguerService) {
		this.leaguerService = leaguerService;
	}

	/**
	 * set consumptionRegisterService
	 * @param consumptionRegisterService the consumptionRegisterService to set
	 */
	public void setConsumptionRegisterService(ConsumptionRegisterService consumptionRegisterService) {
		this.consumptionRegisterService = consumptionRegisterService;
	}

	/**
	 * set userBean
	 * @param userBean the userBean to set
	 */
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
	 * get shopCardDto
	 * @return the shopCardDto
	 */
	public ShopCardDto getShopCardDto() {
		return shopCardDto;
	}

	/**
	 * set shopCardDto
	 * @param shopCardDto the shopCardDto to set
	 */
	public void setShopCardDto(ShopCardDto shopCardDto) {
		this.shopCardDto = shopCardDto;
	}

}
